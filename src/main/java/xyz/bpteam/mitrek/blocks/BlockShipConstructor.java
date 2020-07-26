package xyz.bpteam.mitrek.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockShipConstructor extends BlockBase {
    public BlockShipConstructor(Properties properties) {
        super(properties);
    }
    int state = 0;

    public static final VoxelShape SHAPE = BlockBase.makeCuboidShape(16.0D, 0.0D, 16.0D, 0.0D, 8.0D, 0.0D);

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isOpaque() {
        return true;
    }
}
