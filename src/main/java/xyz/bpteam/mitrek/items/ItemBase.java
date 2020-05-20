package xyz.bpteam.mitrek.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import xyz.bpteam.mitrek.init.ModItemGroups;

import java.util.ArrayList;
import java.util.List;

public class ItemBase extends Item {
    public List<ItemGroup> groups;

    public ItemBase() {
        super(new Properties().group(ModItemGroups.MITREK_ITEMS));
    }

    public Item setGroup(ItemGroup... groups) {
        this.groups = new ArrayList<>();

        for (ItemGroup group : groups) {
            this.groups.add(group);
        }

        return this;
    }

    @Override
    protected boolean isInGroup(ItemGroup group) {
        if (getCreativeTabs().stream().anyMatch(tab -> tab == group) || (groups != null && groups.contains(group)))
            return true;

        ItemGroup itemgroup = this.getGroup();
        return itemgroup != null && (group == ItemGroup.SEARCH || group == itemgroup);
    }
}
