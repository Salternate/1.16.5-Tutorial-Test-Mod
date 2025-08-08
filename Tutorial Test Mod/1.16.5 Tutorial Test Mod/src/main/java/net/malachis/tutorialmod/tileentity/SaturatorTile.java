package net.malachis.tutorialmod.tileentity;

import net.malachis.tutorialmod.block.ModBlocks;
import net.malachis.tutorialmod.block.custom.SaturatorBlock;
import net.malachis.tutorialmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SaturatorTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public SaturatorTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public SaturatorTile()
    {
        this(ModTileEntities.SATURATOR_TILE.get());
    }


    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(1)
        {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot)
                {
                    case 0: return stack.getItem() == ModItems.ENDSTONE_ENCASED_DIAMOND.get() || stack.getItem() == ModItems.VOID_DIAMOND.get() ||
                                   stack.getItem() == Items.STONE || stack.getItem() == ModBlocks.VOID_STONE.get().asItem();
                    default: return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 64;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack))
                {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
        {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void markDirty() {
        voidEnergySaturation();
        super.markDirty();
    }


    public void voidEnergySaturation()
    {
        //boolean hasMinimumVoidEnergy
        boolean hasSaturatableInSlot = this.itemHandler.getStackInSlot(0).getCount() > 0 && (this.itemHandler.getStackInSlot(0).getItem() == ModItems.ENDSTONE_ENCASED_DIAMOND.get()) ||
                                                                                             this.itemHandler.getStackInSlot(0).getItem() == Items.STONE.getItem();
        if(hasSaturatableInSlot && getWorld().getDimensionKey() == World.THE_NETHER)
        {
            if(this.itemHandler.getStackInSlot(0).getItem() == ModItems.ENDSTONE_ENCASED_DIAMOND.get())
            {
                int inputAmount = this.itemHandler.getStackInSlot(0).getCount();
                this.itemHandler.getStackInSlot(0).shrink(this.itemHandler.getStackInSlot(0).getCount());

                this.itemHandler.insertItem(0, new ItemStack(ModItems.VOID_DIAMOND.get()), false);
                this.itemHandler.getStackInSlot(0).setCount(inputAmount);
            }

            if(this.itemHandler.getStackInSlot(0).getItem() == Items.STONE)
            {
                int inputAmount = this.itemHandler.getStackInSlot(0).getCount();
                this.itemHandler.getStackInSlot(0).shrink(this.itemHandler.getStackInSlot(0).getCount());

                this.itemHandler.insertItem(0, new ItemStack(ModBlocks.VOID_STONE.get().asItem()), false).getStack().setCount(inputAmount);
                //this.itemHandler.getStackInSlot(0).setCount(inputAmount);
            }
        }
    }
}
