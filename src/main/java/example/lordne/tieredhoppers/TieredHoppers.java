package example.lordne.tieredhoppers;

import example.lordne.tieredhoppers.common.block.ModBlocks;
import example.lordne.tieredhoppers.common.item.ModItems;
import example.lordne.tieredhoppers.common.tileentity.ModTileEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tieredhoppers")
public class TieredHoppers {
    public static final String MOD_ID = "tieredhoppers";
    
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TieredHoppers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModTileEntities.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
