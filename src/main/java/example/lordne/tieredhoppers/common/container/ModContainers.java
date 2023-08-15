package example.lordne.tieredhoppers.common.container;

import example.lordne.tieredhoppers.TieredHoppers;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModContainers {
    private ModContainers() {};

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, TieredHoppers.MOD_ID);

    public static final RegistryObject<ContainerType<AbstractHopperContainer>> ABSTRACTHOPPER
            = CONTAINER_TYPES.register("abstracthopper",
            () -> new ContainerType<>(AbstractHopperContainer::new));

    public static void register(IEventBus eventBus) {
        CONTAINER_TYPES.register(eventBus);
    }

}
