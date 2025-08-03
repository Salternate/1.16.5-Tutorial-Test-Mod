//package net.malachis.tutorialmod.tileentity;
//
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.FurnaceContainer;
//import net.minecraft.item.crafting.IRecipeType;
//import net.minecraft.tileentity.AbstractFurnaceTileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TranslationTextComponent;
//
//public class SaturatorTileEntity extends AbstractFurnaceTileEntity {
//    public SaturatorTileEntity() {
//        super(TileEntityType.FURNACE, IRecipeType.SMELTING);
//    }
//
//    @Override
//    protected ITextComponent getDefaultName() {
//        return new TranslationTextComponent("container.saturator");
//    }
//
//    @Override
//    protected Container createMenu(int id, PlayerInventory player) {
//        return new FurnaceContainer(id, player, this, this.furnaceData);
//    }
//}
