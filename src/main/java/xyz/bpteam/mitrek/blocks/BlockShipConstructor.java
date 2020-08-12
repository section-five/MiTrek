package xyz.bpteam.mitrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockShipConstructor extends BlockBase {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public BlockShipConstructor(Block.Properties builder) {

        super(builder);
    }


    public BlockShipConstructor(Block.Properties builder) {
        super(builder);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
