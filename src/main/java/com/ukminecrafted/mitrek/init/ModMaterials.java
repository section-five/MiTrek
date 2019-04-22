package com.ukminecrafted.mitrek.init;

import com.ukminecrafted.mitrek.Main;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModMaterials {
    public static final List<Item> MATERIALS = new ArrayList<Item>();
//clothing
    public static final ItemArmor.ArmorMaterial VOY_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("voy_command_uniform", Main.MODID + ":voy_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial VOY_ENGINEERING_UNIFORM = EnumHelper.addArmorMaterial("voy_engineering_uniform", Main.MODID + ":voy_engineering", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
//tools
    public static final ItemTool.ToolMaterial BATLETH = EnumHelper.addToolMaterial("batleth", 0, 1024, 1, 7, 1);
}
