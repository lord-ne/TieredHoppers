package example.lordne.tieredhoppers.common.block;

import example.lordne.tieredhoppers.common.tileentity.AbstractHopperTileEntity;
import net.minecraft.block.HopperBlock;
import net.minecraft.world.IBlockReader;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class AbstractHopperBlock extends HopperBlock {
    public AbstractHopperBlock(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new AbstractHopperTileEntity();
    }

}
