package net.minecraft.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

public class WorldGenFeatureVillageSavanna {

    public static void a() {}

    static {
        ImmutableList<DefinedStructureProcessor> immutablelist = ImmutableList.of(new DefinedStructureProcessorRule(ImmutableList.of(new DefinedStructureProcessorPredicates(new DefinedStructureTestTag(TagsBlock.DOORS), DefinedStructureTestTrue.a, Blocks.AIR.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestBlock(Blocks.TORCH), DefinedStructureTestTrue.a, Blocks.AIR.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestBlock(Blocks.WALL_TORCH), DefinedStructureTestTrue.a, Blocks.AIR.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.ACACIA_PLANKS, 0.2F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.ACACIA_STAIRS, 0.2F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.ACACIA_LOG, 0.05F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.ACACIA_WOOD, 0.05F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.ORANGE_TERRACOTTA, 0.05F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.YELLOW_TERRACOTTA, 0.05F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.RED_TERRACOTTA, 0.05F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.GLASS_PANE, 0.5F), DefinedStructureTestTrue.a, Blocks.COBWEB.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestBlockState((IBlockData) ((IBlockData) Blocks.GLASS_PANE.getBlockData().set(BlockIronBars.NORTH, true)).set(BlockIronBars.SOUTH, true)), DefinedStructureTestTrue.a, (IBlockData) ((IBlockData) Blocks.BROWN_STAINED_GLASS_PANE.getBlockData().set(BlockIronBars.NORTH, true)).set(BlockIronBars.SOUTH, true)), new DefinedStructureProcessorPredicates[]{new DefinedStructureProcessorPredicates(new DefinedStructureTestBlockState((IBlockData) ((IBlockData) Blocks.GLASS_PANE.getBlockData().set(BlockIronBars.EAST, true)).set(BlockIronBars.WEST, true)), DefinedStructureTestTrue.a, (IBlockData) ((IBlockData) Blocks.BROWN_STAINED_GLASS_PANE.getBlockData().set(BlockIronBars.EAST, true)).set(BlockIronBars.WEST, true)), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.WHEAT, 0.1F), DefinedStructureTestTrue.a, Blocks.MELON_STEM.getBlockData())})));

        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/town_centers"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/town_centers/savanna_meeting_point_1"), 100), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/town_centers/savanna_meeting_point_2"), 50), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/town_centers/savanna_meeting_point_3"), 150), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/town_centers/savanna_meeting_point_4"), 150), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/town_centers/savanna_meeting_point_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/town_centers/savanna_meeting_point_2", immutablelist), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/town_centers/savanna_meeting_point_3", immutablelist), 3), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/town_centers/savanna_meeting_point_4", immutablelist), 3)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        ImmutableList<DefinedStructureProcessor> immutablelist1 = ImmutableList.of(new DefinedStructureProcessorRule(ImmutableList.of(new DefinedStructureProcessorPredicates(new DefinedStructureTestBlock(Blocks.GRASS_PATH), new DefinedStructureTestBlock(Blocks.WATER), Blocks.ACACIA_PLANKS.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.GRASS_PATH, 0.2F), DefinedStructureTestTrue.a, Blocks.GRASS_BLOCK.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestBlock(Blocks.GRASS_BLOCK), new DefinedStructureTestBlock(Blocks.WATER), Blocks.WATER.getBlockData()), new DefinedStructureProcessorPredicates(new DefinedStructureTestBlock(Blocks.DIRT), new DefinedStructureTestBlock(Blocks.WATER), Blocks.WATER.getBlockData()))));

        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/streets"), new MinecraftKey("village/savanna/terminators"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/corner_01", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/corner_03", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_02", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_04", immutablelist1), 7), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_05", immutablelist1), 3), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_06", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_08", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_09", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_10", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/straight_11", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/crossroad_02", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/crossroad_03", immutablelist1), 2), new Pair[]{new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/crossroad_04", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/crossroad_05", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/crossroad_06", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/crossroad_07", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/split_01", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/split_02", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/streets/turn_01", immutablelist1), 3)}), WorldGenFeatureDefinedStructurePoolTemplate.Matching.TERRAIN_MATCHING));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/zombie/streets"), new MinecraftKey("village/savanna/zombie/terminators"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/corner_01", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/corner_03", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_02", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_04", immutablelist1), 7), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_05", immutablelist1), 3), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_06", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_08", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_09", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_10", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/straight_11", immutablelist1), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/crossroad_02", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/crossroad_03", immutablelist1), 2), new Pair[]{new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/crossroad_04", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/crossroad_05", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/crossroad_06", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/crossroad_07", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/split_01", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/split_02", immutablelist1), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/streets/turn_01", immutablelist1), 3)}), WorldGenFeatureDefinedStructurePoolTemplate.Matching.TERRAIN_MATCHING));
        ImmutableList<DefinedStructureProcessor> immutablelist2 = ImmutableList.of(new DefinedStructureProcessorRule(ImmutableList.of(new DefinedStructureProcessorPredicates(new DefinedStructureTestRandomBlock(Blocks.WHEAT, 0.1F), DefinedStructureTestTrue.a, Blocks.MELON_STEM.getBlockData()))));

        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/houses"), new MinecraftKey("village/savanna/terminators"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_2"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_3"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_4"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_5"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_6"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_7"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_house_8"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_medium_house_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_medium_house_2"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_butchers_shop_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_butchers_shop_2"), 2), new Pair[]{new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_tool_smith_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_fletcher_house_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_shepherd_1"), 7), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_armorer_1"), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_fisher_cottage_1"), 3), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_tannery_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_cartographer_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_library_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_mason_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_weaponsmith_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_weaponsmith_2"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_temple_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_temple_2"), 3), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_large_farm_1", immutablelist2), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_large_farm_2", immutablelist2), 6), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_farm", immutablelist2), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_animal_pen_1"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_animal_pen_2"), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_animal_pen_3"), 2), Pair.of(WorldGenFeatureDefinedStructurePoolEmpty.a, 5)}), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/zombie/houses"), new MinecraftKey("village/savanna/zombie/terminators"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_2", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_3", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_4", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_5", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_6", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_7", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_small_house_8", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_medium_house_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_medium_house_2", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_butchers_shop_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_butchers_shop_2", immutablelist), 2), new Pair[]{new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_tool_smith_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_fletcher_house_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_shepherd_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_armorer_1", immutablelist), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_fisher_cottage_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_tannery_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_cartographer_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_library_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_mason_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_weaponsmith_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_weaponsmith_2", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_temple_1", immutablelist), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_temple_2", immutablelist), 3), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_large_farm_1", immutablelist), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_large_farm_2", immutablelist), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_small_farm", immutablelist), 4), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/houses/savanna_animal_pen_1", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_animal_pen_2", immutablelist), 2), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/houses/savanna_animal_pen_3", immutablelist), 2), Pair.of(WorldGenFeatureDefinedStructurePoolEmpty.a, 5)}), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/terminators"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_01", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_02", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_03", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_04", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/terminators/terminator_05", immutablelist1), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.TERRAIN_MATCHING));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/zombie/terminators"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_01", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_02", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_03", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/plains/terminators/terminator_04", immutablelist1), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/terminators/terminator_05", immutablelist1), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.TERRAIN_MATCHING));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/trees"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.ACACIA_TREE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.ACACIA_TREE)), 1)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/decor"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/savanna_lamp_post_01"), 4), new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.ACACIA_TREE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.ACACIA_TREE)), 4), new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.BLOCK_PILE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.S)), 4), new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.BLOCK_PILE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.U)), 1), Pair.of(WorldGenFeatureDefinedStructurePoolEmpty.a, 4)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/zombie/decor"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/savanna_lamp_post_01", immutablelist), 4), new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.ACACIA_TREE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.ACACIA_TREE)), 4), new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.BLOCK_PILE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.S)), 4), new Pair(new WorldGenFeatureDefinedStructurePoolFeature(WorldGenerator.BLOCK_PILE.b((WorldGenFeatureConfiguration) BiomeDecoratorGroups.U)), 1), Pair.of(WorldGenFeatureDefinedStructurePoolEmpty.a, 4)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/villagers"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/villagers/nitwit"), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/villagers/baby"), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/villagers/unemployed"), 10)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
        WorldGenFeatureDefinedStructureJigsawPlacement.a.a(new WorldGenFeatureDefinedStructurePoolTemplate(new MinecraftKey("village/savanna/zombie/villagers"), new MinecraftKey("empty"), ImmutableList.of(new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/villagers/nitwit"), 1), new Pair(new WorldGenFeatureDefinedStructurePoolSingle("village/savanna/zombie/villagers/unemployed"), 10)), WorldGenFeatureDefinedStructurePoolTemplate.Matching.RIGID));
    }
}
