package example.lordne.tieredhoppers.common.block;

import example.lordne.tieredhoppers.common.tileentity.NetheriteHopperTileEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NetheriteHopperBlock extends AbstractHopperBlock {
    public NetheriteHopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new NetheriteHopperTileEntity();
    }
}
