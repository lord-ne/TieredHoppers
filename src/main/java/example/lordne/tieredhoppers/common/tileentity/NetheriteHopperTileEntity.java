package example.lordne.tieredhoppers.common.tileentity;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class NetheriteHopperTileEntity extends AbstractHopperTileEntity {
    @Override
    protected int numRows() {
        return 6;
    }

    @Override
    protected int fullCooldownTime() {
        return 1;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.tieredhoppers.hopper_netherite");
    }

    @Override
    public TileEntityType<?> getType() {
        return ModTileEntities.HOPPER_NETHERITE.get();
    }
}
