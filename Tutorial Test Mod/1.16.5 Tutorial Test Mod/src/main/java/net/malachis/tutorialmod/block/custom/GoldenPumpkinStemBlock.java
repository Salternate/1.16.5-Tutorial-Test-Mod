//package net.malachis.tutorialmod.block.custom;
//
//import net.malachis.tutorialmod.item.ModItems;
//import net.minecraft.block.*;
//import net.minecraft.item.Item;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.shapes.ISelectionContext;
//import net.minecraft.util.math.shapes.VoxelShape;
//import net.minecraft.world.IBlockReader;
//
//public class GoldenPumpkinStemBlock extends StemBlock {
//
//    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
//            Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
//
//    public GoldenPumpkinStemBlock(StemGrownBlock crop, Properties properties) {
//        super(crop, properties);
//    }
//
//
//    @Override
//    protected Item getSeedItem()
//    {
//        return ModItems.GOLDEN_PUMPKIN_SEED.get();
//    }
//
//    @Override
//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return SHAPES[state.get(AGE)];
//    }
//}
