package me.ukminecrafted.mitrek.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;

public class BlockDilithiumCrystal extends BlockBase {
    public static final VoxelShape DILITHIUM_CRYSTAL = VoxelShapes.create(0.9375, 0.9375, 0.9375, 0.9, 1, 0.9);

    public BlockDilithiumCrystal(Properties properties) {
        super(properties);
    }


    public static final VoxelShape SHAPE = makeCuboidShape(5.0D, 0.0D, 5.0D, 12.0D, 7.0D, 11.0D);
  
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isOpaque() {
        return true;
    }
}
