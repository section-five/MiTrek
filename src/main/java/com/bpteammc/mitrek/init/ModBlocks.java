package com.bpteammc.mitrek.init;

import com.bpteammc.mitrek.common.blocks.BlockBase;
import com.bpteammc.mitrek.common.blocks.BlockShipDoor;
import com.bpteammc.mitrek.common.blocks.BlockShipExterior;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block SHIP_EXTERIOR = new BlockShipExterior("ship_exterior", Material.IRON);
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
    public static final Block TOS_TOP_PANEL_1 = new BlockBase("tos_top_panel_1", Material.ROCK);
    public static final Block TOS_TOP_PANEL_2 = new BlockBase("tos_top_panel_2", Material.ROCK);
}