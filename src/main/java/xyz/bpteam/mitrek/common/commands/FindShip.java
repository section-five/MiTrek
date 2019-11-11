/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
/*package xyz.bpteam.mitrek.common.commands;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.common.ship.data.ShipData;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import java.util.Collections;
import java.util.List;

public class FindShip extends CommandBase {
    private final List<String> aliases = Lists.newArrayList(Mitrek.MODID, "find-my-ship", "wheres-my-ship");

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 1) return;


        if (sender instanceof EntityPlayer) {
            //ShipData.has
        }
    }

    @Override
    public String getName() {
        return "wheres-my-ship";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "wheres-my-ship <id>";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return Collections.emptyList();
    }
}*/
