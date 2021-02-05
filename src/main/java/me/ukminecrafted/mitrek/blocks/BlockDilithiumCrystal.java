package me.ukminecrafted.mitrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.*;
import net.minecraft.world.IBlockReader;

import java.util.function.ToIntFunction;

public class BlockDilithiumCrystal extends BlockBase {
    public static final VoxelShape DILITHIUM_CRYSTAL = VoxelShapes.create(0.9375, 0.9375, 0.9375, 0.9, 1, 0.9);

    public BlockDilithiumCrystal(Properties properties) {
        super(properties);
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.get(BlockStateProperties.LIT) ? lightValue : 15;
        };
    }


    public static final VoxelShape SHAPE = makeCuboidShape(5.0D, 0.0D, 5.0D, 12.0D, 7.0D, 11.0D);
  
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public boolean isOpaque() {
        return true;
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}
