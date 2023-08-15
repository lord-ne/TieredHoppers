package example.lordne.tieredhoppers.common.tileentity;

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
import net.minecraft.util.text.ITextComponent;

import javax.annotation.ParametersAreNonnullByDefault;
import mcp.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class AbstractHopperTileEntity extends HopperTileEntity {
    public AbstractHopperTileEntity() {
        super();
        setItems(NonNullList.withSize(numRows() * 9, ItemStack.EMPTY));
        ((IMixinTileEntity) this).setType(this.getType());
    }

    // The number of rows in the hopper inventory
    // Must be between 1 and 6
    protected abstract int numRows();

    // The cooldown time of the hopper, in ticks. Should be between 1 and 8
    protected abstract int fullCooldownTime();

    // The default name of the hopper, as a text component
    @Override
    protected abstract ITextComponent getDefaultName();

    // From TileEntity class

    // Return the registered type of this TileEntity
    @Override
    public abstract TileEntityType<?> getType();

    static ContainerType<?>[] chestTypes = {ContainerType.GENERIC_9x1, ContainerType.GENERIC_9x2,
            ContainerType.GENERIC_9x3, ContainerType.GENERIC_9x4, ContainerType.GENERIC_9x5, ContainerType.GENERIC_9x6};

    @Override
    @ParametersAreNonnullByDefault
    protected Container createMenu(int containerID, PlayerInventory playerInv) {
        if (numRows() < 1 || numRows() > chestTypes.length) {
            throw new RuntimeException("Hopper size must be between 1 and 6 rows");
        }
        return new ChestContainer(chestTypes[numRows() - 1], containerID, playerInv, this, numRows());
    }

    @Override
    protected boolean isOnCooldown() {
        return ((IMixinHopperTileEntity) this).getCooldownTime() > (8 - fullCooldownTime());
    }
}
