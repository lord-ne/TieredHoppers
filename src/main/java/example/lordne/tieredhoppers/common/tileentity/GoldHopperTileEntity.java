package example.lordne.tieredhoppers.common.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.ParametersAreNonnullByDefault;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class GoldHopperTileEntity extends AbstractHopperTileEntity {
    @Override
    protected int numRows() {
        return 1;
    }

    @Override
    protected int fullCooldownTime() {
        return 4;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.tieredhoppers.hopper_gold");
    }

    @Override
    public TileEntityType<?> getType() {
        return ModTileEntities.HOPPER_GOLD.get();
    }
}
