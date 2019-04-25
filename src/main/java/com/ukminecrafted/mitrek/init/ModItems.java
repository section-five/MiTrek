package com.ukminecrafted.mitrek.init;

import com.ukminecrafted.mitrek.common.items.ArmorBase;
import com.ukminecrafted.mitrek.common.items.ItemBase;
import com.ukminecrafted.mitrek.common.items.ItemCombadge;
import com.ukminecrafted.mitrek.common.items.WeaponBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.ukminecrafted.mitrek.init.ModMaterials.*;

public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    //item
    public static final Item COMBADGE = new ItemCombadge("combadge");
    public static final Item BATLETH = new WeaponBase("batleth", ModMaterials.BATLETH);

    //Voyager Command
    public static final Item VOY_COMMAND_SHIRT = new ArmorBase("voy_command_shirt", VOY_COMMAND_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOY_COMMAND_PANTS = new ArmorBase("voy_command_pants", VOY_COMMAND_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOY_COMMAND_BOOTS = new ArmorBase("voy_command_boots", VOY_COMMAND_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //Voyager Engineering
    public static final Item VOY_ENGINEERING_SHIRT = new ArmorBase("voy_engineering_shirt", VOY_ENGINEERING_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOY_ENGINEERING_PANTS = new ArmorBase("voy_engineering_pants", VOY_ENGINEERING_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOY_ENGINEERING_BOOTS = new ArmorBase("voy_engineering_boots", VOY_ENGINEERING_UNIFORM, 1, EntityEquipmentSlot.FEET);

    //Voyager Medical
    public static final Item VOY_MEDICAL_SHIRT = new ArmorBase("voy_medical_shirt", VOY_MEDICAL_UNIFORM, 1, EntityEquipmentSlot.CHEST);
    public static final Item VOY_MEDICAL_PANTS = new ArmorBase("voy_medical_pants", VOY_MEDICAL_UNIFORM, 2, EntityEquipmentSlot.LEGS);
    public static final Item VOY_MEDICAL_BOOTS = new ArmorBase("voy_medical_boots", VOY_MEDICAL_UNIFORM, 1, EntityEquipmentSlot.FEET);
}
