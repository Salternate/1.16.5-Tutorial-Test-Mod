package net.malachis.tutorialmod.block.custom;

import net.malachis.tutorialmod.item.custom.VoidPolarityDisplacementChannelingDevice;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// Often, health does not get reduced but absorption will increase anyway...

import static net.malachis.tutorialmod.item.custom.VoidPolarityDisplacementChannelingDevice.swapHealthForAbsorption;

public class VoidEnergyBlock extends Block {
    public VoidEnergyBlock(Properties properties) {
        super(properties);
    }


//    @SuppressWarnings("deprecation")
//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
//        if(!worldIn.isRemote())
//        {
//            if(handIn == Hand.MAIN_HAND)
//            {
//                VoidPolarityDisplacementChannelingDevice.swapHealthForAbsorption(player);
//            }
//        }
//        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
//    }


    @SuppressWarnings("deprecation")
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        if(!worldIn.isRemote())
        {
            swapHealthForAbsorption(player, 1);
        }
        super.onBlockClicked(state, worldIn, pos, player);
    }


    int tickCounter = 0;
    int tickCounterE = 0;
    int second = 20;
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {

        if(entityIn == worldIn.getClosestPlayer(entityIn, 1))
        {
            if (tickCounter == 0) {
                swapHealthForAbsorption((PlayerEntity) entityIn, 4);
                //System.out.println("Swapped");
                tickCounter = second*7;
            }
        }
        else if(tickCounterE == 0)
        {
            VoidPolarityDisplacementChannelingDevice.reduceHealthByOne(entityIn, 1);
            //System.out.println("Entity Swap");
            tickCounterE = second;
        }

        if(tickCounter > 0)
        {
            tickCounter = tickCounter - 1;
            //System.out.println("tickCounter -1");
        }

        if(tickCounterE > 0)
        {
            tickCounterE = tickCounterE - 1;
            //System.out.println("tickCounterE -1");
        }

        //System.out.println("End of Method");
        super.onEntityWalk(worldIn, pos, entityIn);
    }


}
