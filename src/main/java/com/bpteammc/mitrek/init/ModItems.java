/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteammc.com for more info
*/
package com.bpteammc.mitrek.init;

import com.bpteammc.mitrek.common.items.ItemCombadge;
import com.bpteammc.mitrek.common.items.ItemPhaser;
import com.bpteammc.mitrek.common.items.ItemTricorder;
import com.bpteammc.mitrek.common.items.WeaponBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //item
    public static final Item TNG_COMBADGE = new ItemCombadge("tng_combadge");
    public static final Item VOY_COMBADGE = new ItemCombadge("voy_combadge");
    public static final Item TOS_COMMUNICATOR = new ItemCombadge("tos_communicator");
    public static final Item BATLETH = new WeaponBase("batleth", ModMaterials.BATLETH);
    public static final Item TRICORDER = new ItemTricorder("tricorder");
    public static final Item TOS_PHASER = new ItemPhaser("tos_phaser");

   /* //Voyager Command
    public static final Item VOY_COMMAND_SHIRT = new ArmorBase("voy_command_shirt", ModMaterials.VOY_COMMAND_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOY_COMMAND_PANTS = new ArmorBase("voy_command_pants", ModMaterials.VOY_COMMAND_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOY_COMMAND_BOOTS = new ArmorBase("voy_command_boots", ModMaterials.VOY_COMMAND_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //Voyager Engineering
    public static final Item VOY_ENGINEERING_SHIRT = new ArmorBase("voy_engineering_shirt", ModMaterials.VOY_ENGINEERING_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOY_ENGINEERING_PANTS = new ArmorBase("voy_engineering_pants", ModMaterials.VOY_ENGINEERING_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOY_ENGINEERING_BOOTS = new ArmorBase("voy_engineering_boots", ModMaterials.VOY_ENGINEERING_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //Voyager Medical
    public static final Item VOY_MEDICAL_SHIRT = new ArmorBase("voy_medical_shirt", ModMaterials.VOY_MEDICAL_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOY_MEDICAL_PANTS = new ArmorBase("voy_medical_pants", ModMaterials.VOY_MEDICAL_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOY_MEDICAL_BOOTS = new ArmorBase("voy_medical_boots", ModMaterials.VOY_MEDICAL_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //TNG Command
    public static final Item TNG_COMMAND_SHIRT = new ArmorBase("tng_command_shirt", ModMaterials.TNG_COMMAND_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item TNG_COMMAND_PANTS = new ArmorBase("tng_command_pants", ModMaterials.TNG_COMMAND_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item TNG_COMMAND_BOOTS = new ArmorBase("tng_command_boots", ModMaterials.TNG_COMMAND_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //TNG Engineering
    public static final Item TNG_ENGINEERING_SHIRT = new ArmorBase("tng_engineering_shirt", ModMaterials.TNG_ENGINEERING_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item TNG_ENGINEERING_PANTS = new ArmorBase("tng_engineering_pants", ModMaterials.TNG_ENGINEERING_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item TNG_ENGINEERING_BOOTS = new ArmorBase("tng_engineering_boots", ModMaterials.TNG_ENGINEERING_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //TNG Medical
    public static final Item TNG_MEDICAL_SHIRT = new ArmorBase("tng_medical_shirt", ModMaterials.TNG_MEDICAL_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item TNG_MEDICAL_PANTS = new ArmorBase("tng_medical_pants", ModMaterials.TNG_MEDICAL_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item TNG_MEDICAL_BOOTS = new ArmorBase("tng_medical_boots", ModMaterials.TNG_MEDICAL_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //TOS Command
    public static final Item TOS_COMMAND_SHIRT = new ArmorBase("tos_command_shirt", ModMaterials.TOS_COMMAND_UNIFORM, 1, EntityEquipmentSlot.CHEST); */
}
