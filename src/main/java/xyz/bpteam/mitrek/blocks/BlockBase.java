package xyz.bpteam.mitrek.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import xyz.bpteam.mitrek.items.MItemBlock;

public class BlockBase extends Block {

    private MItemBlock mItemBlock;

    public BlockBase(Properties properties) {
        super(properties);
    }

    public Block setGroup(ItemGroup... groups) {
        if(mItemBlock != null) mItemBlock.setGroup(groups);
        return this;
    }

    public void setmItemBlock(MItemBlock mItemBlock) {
        this.mItemBlock = mItemBlock;
    }
}
