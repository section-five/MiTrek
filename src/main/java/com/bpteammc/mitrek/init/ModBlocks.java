package com.bpteammc.mitrek.init;

import com.bpteammc.mitrek.common.blocks.BlockBase;
import com.bpteammc.mitrek.common.blocks.BlockConsole;
import com.bpteammc.mitrek.common.blocks.BlockShipDoor;
import com.bpteammc.mitrek.common.blocks.BlockShipExterior;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block SHIP_EXTERIOR = new BlockShipExterior("ship_exterior", Material.IRON);
    public static final Block SHIP_CONSOLE = new BlockConsole("ship_console", Material.IRON);
    public static final Block SHIP_DOOR = new BlockShipDoor("ship_door", Material.IRON);
    public static final Block STARSHIP_HULL = new BlockBase("starship_hull", Material.ROCK);
    public static final Block TOS_FLOOR = new BlockBase("tos_floor", Material.ROCK);
    public static final Block TOS_SIDE_TOP1 = new BlockBase("tos_side_top1", Material.ROCK);
    public static final Block TOS_SIDE_TOP2 = new BlockBase("tos_side_top2", Material.ROCK);
    public static final Block TOS_SIDE_BOTTOM1 = new BlockBase("tos_side_bottom1", Material.ROCK);
    public static final Block TOS_SIDE_BOTTOM2 = new BlockBase("tos_side_bottom2", Material.ROCK);
    public static final Block TOS_SCREEN1 = new BlockBase("tos_screen1", Material.ROCK);
    public static final Block TOS_SCREEN2 = new BlockBase("tos_screen2", Material.ROCK);
}