package com.ukminecrafted.mitrek;

import com.ukminecrafted.mitrek.init.ModItems;
import com.ukminecrafted.mitrek.proxy.CommonProxy;
import com.ukminecrafted.mitrek.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "mitrek";
    public static final String NAME = "MiTrek";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2768,)";
    public static final String UPDATEURL = "https://raw.githubusercontent.com/bpteammc/SeasonalHeros/master/update.json";


    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs uniforms = new CreativeTabs("uniforms")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COMBADGE);
        }
    };

    public static CreativeTabs items = new CreativeTabs("assets/mitrek/models/item")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COMBADGE);
        }
    };

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
