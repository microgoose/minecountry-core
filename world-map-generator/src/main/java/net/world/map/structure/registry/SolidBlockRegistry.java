package net.world.map.structure.registry;

import java.util.EnumSet;

public class SolidBlockRegistry {
    public static final EnumSet<BlockTypes> NOT_SOLID_BLOCKS = EnumSet.of(
            BlockTypes.AIR,
            BlockTypes.WATER,
            BlockTypes.LAVA,
            BlockTypes.POWERED_RAIL,
            BlockTypes.DETECTOR_RAIL,
            BlockTypes.BROWN_MUSHROOM,
            BlockTypes.RED_MUSHROOM,
            BlockTypes.TORCH,
            BlockTypes.REDSTONE_WIRE,
            BlockTypes.LADDER,
            BlockTypes.LEVER,
            BlockTypes.STONE_BUTTON,
            BlockTypes.PUMPKIN_STEM,
            BlockTypes.MELON_STEM,
            BlockTypes.VINE,
            BlockTypes.COCOA,
            BlockTypes.TRIPWIRE_HOOK,
            BlockTypes.TRIPWIRE,
            BlockTypes.FLOWER_POT,
            BlockTypes.ACTIVATOR_RAIL,
            BlockTypes.END_ROD,
            BlockTypes.CHORUS_PLANT,
            BlockTypes.CHORUS_FLOWER,
            BlockTypes.SUGAR_CANE,
            BlockTypes.MELON,
            BlockTypes.SHORT_GRASS,
            BlockTypes.TALL_GRASS,
            BlockTypes.FERN,
            BlockTypes.LARGE_FERN,
            BlockTypes.KELP,
            BlockTypes.WHEAT,
            BlockTypes.SEA_PICKLE,
            BlockTypes.SEAGRASS,
            BlockTypes.TALL_SEAGRASS,
            BlockTypes.SCULK_CATALYST,
            BlockTypes.FROGSPAWN,
            BlockTypes.ACACIA_HANGING_SIGN,
            BlockTypes.CHERRY_HANGING_SIGN,
            BlockTypes.JUNGLE_HANGING_SIGN,
            BlockTypes.DARK_OAK_HANGING_SIGN,
            BlockTypes.CRIMSON_HANGING_SIGN,
            BlockTypes.WARPED_HANGING_SIGN,
            BlockTypes.MANGROVE_HANGING_SIGN,
            BlockTypes.BAMBOO_HANGING_SIGN,
            BlockTypes.OAK_WALL_HANGING_SIGN,
            BlockTypes.SPRUCE_WALL_HANGING_SIGN,
            BlockTypes.BIRCH_WALL_HANGING_SIGN,
            BlockTypes.ACACIA_WALL_HANGING_SIGN,
            BlockTypes.CHERRY_WALL_HANGING_SIGN,
            BlockTypes.JUNGLE_WALL_HANGING_SIGN,
            BlockTypes.DARK_OAK_WALL_HANGING_SIGN,
            BlockTypes.MANGROVE_WALL_HANGING_SIGN,
            BlockTypes.CRIMSON_WALL_HANGING_SIGN,
            BlockTypes.WARPED_WALL_HANGING_SIGN,
            BlockTypes.BAMBOO_WALL_HANGING_SIGN,
            BlockTypes.DEAD_BUSH,
            BlockTypes.DEAD_TUBE_CORAL_BLOCK,
            BlockTypes.DEAD_BRAIN_CORAL_BLOCK,
            BlockTypes.DEAD_BUBBLE_CORAL_BLOCK,
            BlockTypes.DEAD_FIRE_CORAL_BLOCK,
            BlockTypes.DEAD_HORN_CORAL_BLOCK,
            BlockTypes.TUBE_CORAL_BLOCK,
            BlockTypes.BRAIN_CORAL_BLOCK,
            BlockTypes.BUBBLE_CORAL_BLOCK,
            BlockTypes.FIRE_CORAL_BLOCK,
            BlockTypes.HORN_CORAL_BLOCK,
            BlockTypes.DEAD_TUBE_CORAL,
            BlockTypes.DEAD_BRAIN_CORAL,
            BlockTypes.DEAD_BUBBLE_CORAL,
            BlockTypes.DEAD_FIRE_CORAL,
            BlockTypes.DEAD_HORN_CORAL,
            BlockTypes.TUBE_CORAL,
            BlockTypes.BRAIN_CORAL,
            BlockTypes.BUBBLE_CORAL,
            BlockTypes.FIRE_CORAL,
            BlockTypes.HORN_CORAL,
            BlockTypes.DEAD_TUBE_CORAL_FAN,
            BlockTypes.DEAD_BRAIN_CORAL_FAN,
            BlockTypes.DEAD_BUBBLE_CORAL_FAN,
            BlockTypes.DEAD_FIRE_CORAL_FAN,
            BlockTypes.DEAD_HORN_CORAL_FAN,
            BlockTypes.TUBE_CORAL_FAN,
            BlockTypes.BRAIN_CORAL_FAN,
            BlockTypes.BUBBLE_CORAL_FAN,
            BlockTypes.FIRE_CORAL_FAN,
            BlockTypes.HORN_CORAL_FAN,
            BlockTypes.DEAD_TUBE_CORAL_WALL_FAN,
            BlockTypes.DEAD_BRAIN_CORAL_WALL_FAN,
            BlockTypes.DEAD_BUBBLE_CORAL_WALL_FAN,
            BlockTypes.DEAD_FIRE_CORAL_WALL_FAN,
            BlockTypes.DEAD_HORN_CORAL_WALL_FAN,
            BlockTypes.TUBE_CORAL_WALL_FAN,
            BlockTypes.BRAIN_CORAL_WALL_FAN,
            BlockTypes.BUBBLE_CORAL_WALL_FAN,
            BlockTypes.FIRE_CORAL_WALL_FAN,
            BlockTypes.HORN_CORAL_WALL_FAN,
            BlockTypes.COBWEB,
            BlockTypes.FIRE,
            BlockTypes.STRUCTURE_VOID,
            BlockTypes.NETHER_PORTAL,
            BlockTypes.END_GATEWAY,
            BlockTypes.SNOW,
            BlockTypes.LIGHT_WEIGHTED_PRESSURE_PLATE,
            BlockTypes.HEAVY_WEIGHTED_PRESSURE_PLATE,
            BlockTypes.POLISHED_BLACKSTONE_PRESSURE_PLATE,
            BlockTypes.OAK_PRESSURE_PLATE,
            BlockTypes.SPRUCE_PRESSURE_PLATE,
            BlockTypes.BIRCH_PRESSURE_PLATE,
            BlockTypes.JUNGLE_PRESSURE_PLATE,
            BlockTypes.ACACIA_PRESSURE_PLATE,
            BlockTypes.CHERRY_PRESSURE_PLATE,
            BlockTypes.DARK_OAK_PRESSURE_PLATE,
            BlockTypes.MANGROVE_PRESSURE_PLATE,
            BlockTypes.BAMBOO_PRESSURE_PLATE,
            BlockTypes.STONE_PRESSURE_PLATE,
            BlockTypes.CRIMSON_PRESSURE_PLATE,
            BlockTypes.WARPED_PRESSURE_PLATE,
            BlockTypes.SPRUCE_SAPLING,
            BlockTypes.OAK_SAPLING,
            BlockTypes.BIRCH_SAPLING,
            BlockTypes.JUNGLE_SAPLING,
            BlockTypes.ACACIA_SAPLING,
            BlockTypes.CHERRY_SAPLING,
            BlockTypes.DARK_OAK_SAPLING,
            BlockTypes.POTTED_OAK_SAPLING,
            BlockTypes.POTTED_SPRUCE_SAPLING,
            BlockTypes.POTTED_BIRCH_SAPLING,
            BlockTypes.POTTED_JUNGLE_SAPLING,
            BlockTypes.POTTED_ACACIA_SAPLING,
            BlockTypes.POTTED_CHERRY_SAPLING,
            BlockTypes.POTTED_DARK_OAK_SAPLING,
            BlockTypes.BAMBOO_SAPLING,
            BlockTypes.CRIMSON_FUNGUS
    );

    public static boolean isNotSolid(BlockTypes blockTypes) {
        return NOT_SOLID_BLOCKS.contains(blockTypes);
    }
}
