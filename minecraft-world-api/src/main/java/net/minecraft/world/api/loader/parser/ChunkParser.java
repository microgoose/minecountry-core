package net.minecraft.world.api.loader.parser;

import net.minecraft.world.api.loader.config.LoadingBlockConfig;
import net.minecraft.world.api.structure.config.ChunkConfig;
import net.minecraft.world.api.structure.config.SectionConfig;
import net.minecraft.world.api.structure.config.WorldConfig;
import net.minecraft.world.api.structure.model.Block;
import net.minecraft.world.api.structure.model.BlockWithMetadata;
import net.minecraft.world.api.structure.model.Chunk;
import net.minecraft.world.api.structure.model.metadata.BlockMeta;
import net.minecraft.world.api.structure.model.metadata.PlantMeta;
import net.minecraft.world.api.structure.model.metadata.UnderwaterMeta;
import net.minecraft.world.api.structure.registries.BlockTypes;
import net.minecraft.world.api.structure.registries.PlantBlockRegistry;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChunkParser {
    private static final short sectionMinY = -4;

    public static Optional<Chunk> parse(CompoundTag chunkTag) {
        int version = chunkTag.getInt("DataVersion");

        // https://minecraft.wiki/w/Data_version#List_of_data_versions
        if (version < 2844) // older than 1.18 (21w43a)
            throw new RuntimeException("Unhandled chunk version: " + version);

        if (!chunkTag.getString("Status").endsWith("full")) {
            return Optional.empty();
        }

        ListTag<CompoundTag> sectionsTags = chunkTag.getListTag("sections").asCompoundTagList();
        SectionParser[] sections = parseSections(sectionsTags);

        short maxHeight = WorldConfig.MAX_HEIGHT;
        short minHeight = WorldConfig.MIN_HEIGHT;
        int chunkX = chunkTag.getInt("xPos");
        int chunkY = chunkTag.getInt("zPos");

        Chunk chunk = new Chunk(chunkX, chunkY);

        int startBlockX = chunkX * ChunkConfig.CHUNK_SIZE;
        int startBlockY = chunkY * ChunkConfig.CHUNK_SIZE;

        for (int x = 0; x < ChunkConfig.CHUNK_SIZE; x++) {
            for (int y = 0; y < ChunkConfig.CHUNK_SIZE; y++) {
                Map<Class<? extends BlockMeta>, BlockMeta> metadata = new HashMap<>();

                for (short height = maxHeight; height > minHeight; height--) {
                    int sectionIndex = Math.floorDiv(height, SectionConfig.SECTION_HEIGHT) - sectionMinY;

                    if (sections[sectionIndex] == null)
                        continue;

                    SectionParser sectionParser = sections[sectionIndex];
                    BlockTypes blockTypes = sectionParser.getBlockType(x, height, y);

                    if (LoadingBlockConfig.IGNORED_BLOCKS.contains(blockTypes))
                        continue;

                    if (blockTypes.equals(BlockTypes.WATER) || PlantBlockRegistry.isWaterPlant(blockTypes)) {
                        UnderwaterMeta meta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);

                        if (meta == null)
                            metadata.put(UnderwaterMeta.class, new UnderwaterMeta());
                        else
                            meta.incrementDepth();

                        continue;
                    }

                    if (PlantBlockRegistry.isPlant(blockTypes)) {
                        PlantMeta meta = (PlantMeta) metadata.get(PlantMeta.class);

                        if (meta == null)
                            metadata.put(PlantMeta.class, new PlantMeta(blockTypes));
                        else
                            meta.increasePlantHeight();

                        continue;
                    }

                    int blockGlobalX = startBlockX + x;
                    int blockGlobalY = startBlockY + y;

                    if (metadata.isEmpty()) {
                        chunk.addBlockByLocal(x, y, new Block(blockGlobalX, blockGlobalY, height, blockTypes));
                    } else {
                        chunk.addBlockByLocal(x, y,
                                new BlockWithMetadata(blockGlobalX, blockGlobalY, height, blockTypes, metadata));
                    }

                    break;
                }
            }
        }

        return Optional.of(chunk);
    }

    private static SectionParser[] parseSections(ListTag<CompoundTag> sectionsTags) {
        SectionParser[] sections = new SectionParser[sectionsTags.size()];

        for (int i = 0; i < sections.length; i++) {
            CompoundTag sectionTag = sectionsTags.get(i);

            if (!sectionTag.getCompoundTag("block_states").containsKey("data"))
                continue;

            SectionParser sectionParser = new SectionParser(sectionTag);
            sections[sectionParser.getSectionY() - sectionMinY] = sectionParser;
        }

        return sections;
    }
}