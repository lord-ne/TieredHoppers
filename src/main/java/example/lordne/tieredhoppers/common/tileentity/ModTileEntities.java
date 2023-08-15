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

    public static final RegistryObject<TileEntityType<GoldHopperTileEntity>> HOPPER_GOLD
            = TE_TYPES.register("hopper_gold",
            () -> TileEntityType.Builder.of(GoldHopperTileEntity::new, ModBlocks.HOPPER_GOLD.get()).build(null));

    public static final RegistryObject<TileEntityType<DiamondHopperTileEntity>> HOPPER_DIAMOND
            = TE_TYPES.register("hopper_diamond",
            () -> TileEntityType.Builder.of(DiamondHopperTileEntity::new, ModBlocks.HOPPER_DIAMOND.get()).build(null));

    public static final RegistryObject<TileEntityType<NetheriteHopperTileEntity>> HOPPER_NETHERITE
            = TE_TYPES.register("hopper_netherite",
            () -> TileEntityType.Builder.of(NetheriteHopperTileEntity::new, ModBlocks.HOPPER_NETHERITE.get()).build(null));

    public static void register(IEventBus eventBus) {
        TE_TYPES.register(eventBus);
    }

}
