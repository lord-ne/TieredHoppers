package example.lordne.tieredhoppers.mixin;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TileEntity.class)
public interface IMixinTileEntity {
    @Accessor @Mutable
    void setType(TileEntityType<?> type);
}
