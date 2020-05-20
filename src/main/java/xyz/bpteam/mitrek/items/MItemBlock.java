package xyz.bpteam.mitrek.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import java.util.ArrayList;
import java.util.List;

public class MItemBlock extends BlockItem {

    public List<ItemGroup> groups;

    public MItemBlock(Block blockIn) {
        super(blockIn, new Item.Properties());
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
