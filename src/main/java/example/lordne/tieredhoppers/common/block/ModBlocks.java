package example.lordne.tieredhoppers.common.block;

import example.lordne.tieredhoppers.TieredHoppers;
import example.lordne.tieredhoppers.common.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.function.Supplier;

public final class ModBlocks {
    private ModBlocks() {};

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TieredHoppers.MOD_ID);

    public static final RegistryObject<Block> HOPPER_GOLD = registerBlock("hopper_gold",
            () -> new GoldHopperBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.GOLD)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isValidSpawn((a, b, c, d) -> false)),
            ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> HOPPER_DIAMOND = registerBlock("hopper_diamond",
            () -> new DiamondHopperBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.DIAMOND)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 6.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isValidSpawn((a, b, c, d) -> false)),
            ItemGroup.TAB_REDSTONE);

    public static final RegistryObject<Block> HOPPER_NETHERITE = registerBlock("hopper_netherite",
            () -> new NetheriteHopperBlock(AbstractBlock.Properties.of(Material.METAL, MaterialColor.NETHER)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 1200.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()
                    .isValidSpawn((a, b, c, d) -> false)),
            ItemGroup.TAB_REDSTONE);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup creativeTab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, creativeTab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties blockItemProperties) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, blockItemProperties);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        registerBlockItem(name, block, new Item.Properties());
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup creativeTab) {
        registerBlockItem(name, block, new Item.Properties().tab(creativeTab));
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, Item.Properties itemProperties) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }
}
