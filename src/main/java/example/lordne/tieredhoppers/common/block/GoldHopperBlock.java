package example.lordne.tieredhoppers.common.block;

import example.lordne.tieredhoppers.common.tileentity.GoldHopperTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import mcp.MethodsReturnNonnullByDefault;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GoldHopperBlock extends AbstractHopperBlock {
    public GoldHopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new GoldHopperTileEntity();
    }
}
