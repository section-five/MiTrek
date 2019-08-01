package com.bpteammc.mitrek.init;

import com.bpteammc.mitrek.common.blocks.BlockBase;
import com.bpteammc.mitrek.common.blocks.BlockConsole;
import com.bpteammc.mitrek.common.blocks.BlockShipDoor;
import com.bpteammc.mitrek.common.blocks.BlockShipExterior;
import com.bpteammc.mitrek.common.blocks.slab.BlockDoubleSlabBase;
import com.bpteammc.mitrek.common.blocks.slab.BlockHalfSlabBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block SHIP_EXTERIOR = new BlockShipExterior("ship_exterior", Material.IRON);
    public static final Block SHIP_CONSOLE = new BlockConsole("ship_console", Material.IRON);
    public static final Block SHIP_DOOR = new BlockShipDoor("ship_door", Material.IRON);
    public static final Block STARSHIP_HULL = new BlockBase("starship_hull", Material.ROCK);

  //TOS BLOCKS
    public static final Block TOS_FLOOR = new BlockBase("tos_floor", Material.ROCK);
    public static final Block TOS_LOWER_PANEL_1 = new BlockBase("tos_lower_panel_1", Material.ROCK);
    public static final Block TOS_LOWER_PANEL_2 = new BlockBase("tos_lower_panel_2", Material.ROCK);
    public static final Block TOS_LOWER_PANEL_3 = new BlockBase("tos_lower_panel_3", Material.ROCK);
    public static final Block TOS_MIDDLE_PANEL_1 = new BlockBase("tos_middle_panel_1", Material.ROCK);
    public static final Block TOS_MIDDLE_PANEL_2 = new BlockBase("tos_middle_panel_2", Material.ROCK);
    public static final Block TOS_MIDDLE_PANEL_3 = new BlockBase("tos_middle_panel_3", Material.ROCK);
    public static final Block TOS_TOP_PANEL_LT = new BlockBase("tos_top_panel_lt", Material.ROCK);
    public static final Block TOS_TOP_PANEL_LB = new BlockBase("tos_top_panel_lb", Material.ROCK);
    public static final Block TOS_TOP_PANEL_MT = new BlockBase("tos_top_panel_mt", Material.ROCK);
    public static final Block TOS_TOP_PANEL_MB = new BlockBase("tos_top_panel_mb", Material.ROCK);
    public static final Block TOS_TOP_PANEL_RT = new BlockBase("tos_top_panel_rt", Material.ROCK);
    public static final Block TOS_TOP_PANEL_RB = new BlockBase("tos_top_panel_rb", Material.ROCK);
    public static final BlockSlab TOS_FLOOR_SLAB_HALF = new BlockHalfSlabBase("tos_floor_slab_half", Material.ROCK, ModBlocks.TOS_FLOOR_SLAB_HALF, ModBlocks.TOS_FLOOR_SLAB_DOUBLE);
    public static final BlockSlab TOS_FLOOR_SLAB_DOUBLE = new BlockDoubleSlabBase("tos_floor_slab_double", Material.ROCK, ModBlocks.TOS_FLOOR_SLAB_HALF);
    public static final Block TOS_WALL = new BlockBase("tos_wall", Material.ROCK);
    public static final Block TOS_CAP_CHAIR = new BlockBase("tos_cap_chair", Material.CARPET);
    public static final Block TOS_CEILING_1 = new BlockBase("tos_ceiling_1", Material.ROCK);
    public static final Block TOS_CEILING_2 = new BlockBase("tos_ceiling_2", Material.ROCK);
    public static final Block TOS_CEILING_3 = new BlockBase("tos_ceiling_3", Material.ROCK);
    public static final Block TOS_CEILING_4 = new BlockBase("tos_ceiling_4", Material.ROCK);

    //TNG BLOCKS
    public static final Block TNG_LIGHT_BLOCK = new BlockBase("tng_light_block", Material.GLASS);
   /* public static final Block
    public static final Block
    public static final Block*/

}