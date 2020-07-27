package xyz.bpteam.mitrek.blocks;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;

public class BlockDilithiumCrystal extends BlockBase {
    public BlockDilithiumCrystal(Properties properties) {
        super(properties);
    }

    public static final VoxelShape SHAPE = BlockBase.makeCuboidShape(5.0D, 0.0D, 5.0D, 12.0D, 7.0D, 11.0D);

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isOpaque() {
        return true;
    }
}
