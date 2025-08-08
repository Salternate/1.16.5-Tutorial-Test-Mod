package net.malachis.tutorialmod.block.custom;

import io.netty.channel.ChannelHandler;
import net.malachis.tutorialmod.block.ModBlocks;
import net.malachis.tutorialmod.container.SaturatorContainer;
import net.malachis.tutorialmod.item.ModItems;
import net.malachis.tutorialmod.screen.SaturatorScreen;
import net.malachis.tutorialmod.tileentity.ModTileEntities;
import net.malachis.tutorialmod.tileentity.SaturatorTile;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootFunction;
import net.minecraft.loot.functions.Smelt;
import net.minecraft.network.NetworkManager;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

// Unfinished

import javax.annotation.Nullable;
import java.net.NetworkInterface;
import java.util.Properties;
import java.util.Random;

public class SaturatorBlock extends AbstractFurnaceBlock {
    public SaturatorBlock(AbstractBlock.Properties builder) {
        super(builder);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new SaturatorTile();
    }

    @Override
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof SaturatorTile) {
            INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);
            NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileentity.getPos());
            //player.addStat(Stats.INTERACT_WITH_FURNACE);
        }
    }



//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        if(!worldIn.isRemote())
//        {
//            TileEntity tileEntity = worldIn.getTileEntity(pos);
//
//            if(!player.isCrouching())
//            {
//                if(tileEntity instanceof SaturatorTile)
//                {
//                    INamedContainerProvider containerProvider = createContainerProvider(worldIn, pos);
//                    NetworkHooks.openGui(((ServerPlayerEntity)player), containerProvider, tileEntity.getPos());
////                    if(tileEntity.getWorld().getDimensionType().isUltrawarm())
////                    {
////                        ((SaturatorTile) tileEntity).voidEnergySaturation();
////                    }
//                }
//                else {
//                    throw new IllegalStateException("Our Container provider is missing!!!!!!!");
//                }
//            }
//            else
//            {
//                if(tileEntity instanceof SaturatorTile)
//                {
//                    if(tileEntity.getWorld().getDimensionKey() == World.THE_NETHER && player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL)
//                    {
//                        EntityType.END_CRYSTAL.spawn(((ServerWorld) worldIn), null, player, pos, SpawnReason.TRIGGERED, true, true);
//                    }
//                }
//            }
//        }
//        return ActionResultType.SUCCESS;
//    }


    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos) {
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.tutorialmod.saturator");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                return new SaturatorContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.SATURATOR_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }



    //    @Override
//    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
//        TileEntity tileentity = worldIn.getTileEntity(pos);
//        if (tileentity instanceof FurnaceTileEntity) {
//            player.openContainer((INamedContainerProvider)tileentity);
//            //player.addStat(Stats.INTERACT_WITH_FURNACE);
//        }
//    }
//
//
//    @Nullable
//    @Override
//    public TileEntity createNewTileEntity(IBlockReader worldIn) {
//        return new FurnaceTileEntity();
//    }
}
