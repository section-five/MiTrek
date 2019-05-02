package com.ukminecrafted.mitrek.init;

import com.ukminecrafted.mitrek.common.blocks.BlockConsole;
import com.ukminecrafted.mitrek.common.blocks.BlockShipExterior;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block SHIP_EXTERIOR = new BlockShipExterior("ship_exterior", Material.IRON);
    public static final Block SHIP_CONSOLE = new BlockConsole("ship_console", Material.IRON);
}