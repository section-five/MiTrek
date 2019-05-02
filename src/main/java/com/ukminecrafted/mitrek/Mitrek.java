package com.ukminecrafted.mitrek;

import com.ukminecrafted.mitrek.common.tileentity.TileEntityShip;
import com.ukminecrafted.mitrek.common.tileentity.TileEntityShipExterior;
import com.ukminecrafted.mitrek.init.ModDimensions;
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

import static com.ukminecrafted.mitrek.util.handlers.RegistryHandler.registerTileEntity;

@Mod(modid = Mitrek.MODID, name = Mitrek.NAME, version = Mitrek.VERSION)
public class Mitrek
{
    public static final String MODID = "mitrek";
    public static final String NAME = "MiTrek";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2813,)";
    public static final String UPDATEURL = "https://raw.githubusercontent.com/ukminecrafted/MiTrek/master/update.json";


    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    public static CreativeTabs uniforms = new CreativeTabs("uniforms")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COMBADGE);
        }
    };

    public static CreativeTabs items = new CreativeTabs("items")
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
        ModDimensions.Register();
        registerTileEntity(TileEntityShip.class, "TileShip");
        registerTileEntity(TileEntityShipExterior.class, "TileShipExterior");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
