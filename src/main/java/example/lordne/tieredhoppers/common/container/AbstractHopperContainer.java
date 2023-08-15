package example.lordne.tieredhoppers.common.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class AbstractHopperContainer extends Container {
    protected final IInventory hopper;

    // Will be abstract
    protected int numSlots() {
        return 5;
    }

    // Will be abstract
    public AbstractHopperContainer(int containerID, PlayerInventory playerInv) {
        this(containerID, playerInv, 5);
    }

    public AbstractHopperContainer(int containerID, PlayerInventory playerInv, int invSize) {
        this(containerID, playerInv, new Inventory(invSize));
    }

    public AbstractHopperContainer(int containerID, PlayerInventory playerInv, IInventory hopperInv) {
        super(ModContainers.ABSTRACTHOPPER.get(), containerID);
        this.hopper = hopperInv;
        checkContainerSize(hopperInv, numSlots());
        hopperInv.startOpen(playerInv.player);

        for(int i = 0; i < numSlots(); ++i) {
            this.addSlot(new Slot(hopperInv, i, 44 + i * 18, 20));
        }

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, i * 18 + 51));
            }
        }

        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 109));
        }

    }

    public boolean stillValid(PlayerEntity playerEntity) {
        return this.hopper.stillValid(playerEntity);
    }

    public ItemStack quickMoveStack(PlayerEntity playerEntity, int slotNum) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotNum);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (slotNum < this.hopper.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.hopper.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.hopper.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public void removed(PlayerEntity player) {
        super.removed(player);
        this.hopper.stopOpen(player);
    }
}