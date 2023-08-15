package example.lordne.tieredhoppers.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.HopperTileEntity;
import net.minecraft.util.NonNullList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HopperTileEntity.class)
public interface IMixinHopperTileEntity {
    @Accessor
    NonNullList<ItemStack> getItems();

    @Accessor
    void setItems(NonNullList<ItemStack> items);

    @Accessor
    int getCooldownTime();
}
