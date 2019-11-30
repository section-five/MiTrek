package com.bpteammc.mitrek;

import com.bpteammc.mitrek.common.ship.data.ShipSaver;
import com.bpteammc.mitrek.common.tileentity.TileEntityShip;
import com.bpteammc.mitrek.common.tileentity.TileEntityShipExterior;
import com.bpteammc.mitrek.common.tileentity.exteriors.TileShipExterior_01;
import com.bpteammc.mitrek.common.world.InteriorGeneration;
import com.bpteammc.mitrek.init.ModBlocks;
import com.bpteammc.mitrek.init.ModDimensions;
import com.bpteammc.mitrek.init.ModItems;
import com.bpteammc.mitrek.network.NetworkManager;
import com.bpteammc.mitrek.proxy.IProxy;
import com.bpteammc.mitrek.util.Reference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import static com.bpteammc.mitrek.util.handlers.RegistryHandler.registerTileEntity;

@Mod(modid = Mitrek.MODID, name = Mitrek.NAME, version = Mitrek.VERSION)
public class Mitrek {
    public static final String MODID = "mitrek";
    public static final String NAME = "MiTrek";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static Mitrek instance;

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static FMLCommonHandler FML = FMLCommonHandler.instance();


    @SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static IProxy proxy;

 /*   public static CreativeTabs uniforms = new CreativeTabs("uniforms") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.TNG_COMBADGE);
        }
    };*/

    public static CreativeTabs items = new CreativeTabs("items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.TNG_COMBADGE);
        }
    };

    public static CreativeTabs blocks = new CreativeTabs("blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.STARSHIP_HULL);
        }
    };

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        NetworkManager.init();
        ModDimensions.Register();
        registerTileEntity(TileEntityShip.class, "TileShip");
        registerTileEntity(TileEntityShipExterior.class, "TileShipExterior");
        registerTileEntity(TileShipExteriorConstitution.class, "TileShipExteriorConstitution");
        InteriorGeneration.registerConsoleRoom("shiptest", new BlockPos(16, 1, 16));
        CapabilityManager.INSTANCE.register(IShipCapability.class, new CapShipStorage(), CapabilityShip::new);
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent e) {
        ShipSaver.ships.clear();
        ShipSaver.mapAllShips();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
}
