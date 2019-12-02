package com.bpteammc.mitrek.init;

import com.bpteammc.mitrek.Mitrek;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModMaterials {
    public static final List<Item> MATERIALS = new ArrayList<Item>();
//Voyager Uniforms
    public static final ItemArmor.ArmorMaterial VOY_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("voy_command_uniform", Mitrek.MODID + ":voy_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial VOY_ENGINEERING_UNIFORM = EnumHelper.addArmorMaterial("voy_engineering_uniform", Mitrek.MODID + ":voy_engineering", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial VOY_MEDICAL_UNIFORM = EnumHelper.addArmorMaterial("voy_medical_uniform", Mitrek.MODID + ":voy_medical", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);

//TNG Uniforms
    public static final ItemArmor.ArmorMaterial TNG_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("tng_command_uniform", Mitrek.MODID + ":tng_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial TNG_ENGINEERING_UNIFORM = EnumHelper.addArmorMaterial("tng_engineering_uniform", Mitrek.MODID + ":tng_engineering", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial TNG_MEDICAL_UNIFORM = EnumHelper.addArmorMaterial("tng_medical_uniform", Mitrek.MODID + ":tng_medical", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);

//DS9 Uniforms
    public static final ItemArmor.ArmorMaterial DS9_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("ds9_command_uniform", Mitrek.MODID + ":ds9_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial DS9_ENGINEERING_UNIFORM = EnumHelper.addArmorMaterial("ds9_engineering_uniform", Mitrek.MODID + ":ds9_engineering", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial DS9_MEDICAL_UNIFORM = EnumHelper.addArmorMaterial("ds9_medical_uniform", Mitrek.MODID + ":ds9_medical", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);

//Enterprise Uniforms
    public static final ItemArmor.ArmorMaterial ENT_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("ent_command_uniform", Mitrek.MODID + ":ent_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial ENT_ENGINEERING_UNIFORM = EnumHelper.addArmorMaterial("ent_engineering_uniform", Mitrek.MODID + ":ent_engineering", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial ENT_MEDICAL_UNIFORM = EnumHelper.addArmorMaterial("ent_medical_uniform", Mitrek.MODID + ":ent_medical", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);

//Disco Uniforms
    public static final ItemArmor.ArmorMaterial DIS_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("dis_command_uniform", Mitrek.MODID + ":dis_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial DIS_ENGINEERING_UNIFORM = EnumHelper.addArmorMaterial("dis_engineering_uniform", Mitrek.MODID + ":dis_engineering", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
    public static final ItemArmor.ArmorMaterial DIS_MEDICAL_UNIFORM = EnumHelper.addArmorMaterial("dis_medical_uniform", Mitrek.MODID + ":dis_medical", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);

    //TOS Uniforms
    public static final ItemArmor.ArmorMaterial TOS_COMMAND_UNIFORM = EnumHelper.addArmorMaterial("tos_command_uniform", Mitrek.MODID + ":tos_command", 15, new int[] {3,6,8,3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);


//tools
    public static final ItemTool.ToolMaterial BATLETH = EnumHelper.addToolMaterial("batleth", 0, 1024, 1, 5, 1);
}
