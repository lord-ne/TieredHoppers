package example.lordne.tieredhoppers.common.tileentity;

import example.lordne.tieredhoppers.common.container.AbstractHopperContainer;
import example.lordne.tieredhoppers.mixin.IMixinHopperTileEntity;
import example.lordne.tieredhoppers.mixin.IMixinTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.HopperTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class AbstractHopperTileEntity extends HopperTileEntity {
    public AbstractHopperTileEntity() {
        super();
        setItems(NonNullList.withSize(numRows() * 9, ItemStack.EMPTY));
        ((IMixinTileEntity) this).setType(this.getType());
    }

    protected int numRows() {
        return 1;
    }

    protected int fullCooldownTime() {
        return 4;
    }

    static ContainerType<?>[] chestTypes = {ContainerType.GENERIC_9x1, ContainerType.GENERIC_9x2,
            ContainerType.GENERIC_9x3, ContainerType.GENERIC_9x4, ContainerType.GENERIC_9x5, ContainerType.GENERIC_9x6};

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    protected Container createMenu(int containerID, PlayerInventory playerInv) {
        if (numRows() < 1 || numRows() > chestTypes.length) {
            throw new RuntimeException("Hopper size must be between 1 and 6 rows");
        }
        return new ChestContainer(chestTypes[numRows() - 1], containerID, playerInv, this, numRows());
    }

    // From TileEntity class
    @Override
    @Nonnull
    public TileEntityType<?> getType() {
        return ModTileEntities.ABSTRACTHOPPER.get();
    }

    @Override
    protected boolean isOnCooldown() {
        return ((IMixinHopperTileEntity) this).getCooldownTime() > (8 - fullCooldownTime());
    }
}
