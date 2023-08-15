package example.lordne.tieredhoppers.common.tileentity;

import example.lordne.tieredhoppers.TieredHoppers;
import example.lordne.tieredhoppers.common.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTileEntities {
    private ModTileEntities() {};

    public static final DeferredRegister<TileEntityType<?>> TE_TYPES
            = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TieredHoppers.MOD_ID);

    public static final RegistryObject<TileEntityType<AbstractHopperTileEntity>> ABSTRACTHOPPER
            = TE_TYPES.register("abstracthopper",
            () -> TileEntityType.Builder.of(AbstractHopperTileEntity::new, ModBlocks.ABSTRACTHOPPER.get()).build(null));

    public static void register(IEventBus eventBus) {
        TE_TYPES.register(eventBus);
    }

}
