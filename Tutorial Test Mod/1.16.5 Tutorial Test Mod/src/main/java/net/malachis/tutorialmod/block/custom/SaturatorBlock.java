package net.malachis.tutorialmod.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

// Unfinished

import javax.annotation.Nullable;

public class SaturatorBlock extends AbstractFurnaceBlock {
    public SaturatorBlock(AbstractBlock.Properties builder) {
        super(builder);

    }


    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof FurnaceTileEntity) {
            player.openContainer((INamedContainerProvider)tileentity);
            //player.addStat(Stats.INTERACT_WITH_FURNACE);
        }
    }


    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new FurnaceTileEntity();
    }
}
