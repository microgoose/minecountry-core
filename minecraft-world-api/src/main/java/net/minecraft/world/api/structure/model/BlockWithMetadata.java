package net.minecraft.world.api.structure.model;

import net.minecraft.world.api.structure.model.metadata.BlockMeta;
import net.minecraft.world.api.structure.registries.BlockTypes;

import java.util.Map;

public class BlockWithMetadata extends Block {
    private final Map<Class<? extends BlockMeta>, BlockMeta> metadata;

    public BlockWithMetadata(int x, int y, short height, BlockTypes blockTypes,
                             Map<Class<? extends BlockMeta>, BlockMeta> metadata) {
        super(x, y, height, blockTypes);
        this.metadata = metadata;
    }

    public void addMeta(Class<? extends BlockMeta> key, BlockMeta meta) {
        metadata.put(key, meta);
    }

    public BlockMeta getMeta(Class<? extends BlockMeta> key) {
        return metadata.get(key);
    }

    public boolean hasMeta(Class<? extends BlockMeta> key) {
        return metadata.containsKey(key);
    }

    public Map<Class<? extends BlockMeta>, BlockMeta> getMetadata() {
        return metadata;
    }
}