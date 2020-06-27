package xyz.bpteam.mitrek.blocks;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;

public class BlockDilithiumCrystal extends BlockBase {
<<<<<<< Updated upstream
=======

    public static final VoxelShape getVoxelShape() {
        VoxelShape voxelShape = VoxelShapes.create(0.31, 0.06, 0, 0.56, 0.75, 0.25);
        voxelShape = VoxelShapes.combineAndSimplify(voxelShape, VoxelShapes.create(0.68, 0, 0.35, 0.93, 0.68, 0.62), IBooleanFunction.OR);
        voxelShape = VoxelShapes.combineAndSimplify(voxelShape, VoxelShapes.create(0, 0.06, 0.43, 0.25, 0.87, 0.68), IBooleanFunction.OR);
        voxelShape = VoxelShapes.combineAndSimplify(voxelShape, VoxelShapes.create(0.45, 0, 0.68, 0.68, 0.35, 0.93), IBooleanFunction.OR);
        return voxelShape;
    };

>>>>>>> Stashed changes
    public BlockDilithiumCrystal(Properties properties) {
        super(properties);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public static final VoxelShape DILITHIUM_CRYSTAL = VoxelShapes.create(0.9375,0.9375,0.9375,0.9,1,0.9);

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getVoxelShape();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getVoxelShape();
    }


}
