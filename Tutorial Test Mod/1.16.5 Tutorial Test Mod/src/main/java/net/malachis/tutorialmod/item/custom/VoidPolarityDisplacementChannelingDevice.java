package net.malachis.tutorialmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.world.World;

// Add use animation if possible

public class VoidPolarityDisplacementChannelingDevice extends Item {
    public VoidPolarityDisplacementChannelingDevice(Properties properties) {
        super(properties);
    }

    //static float storedAbsorption = 0;

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {

        if(!world.isRemote) {
            rightClick(playerEntity);
        }

        return super.onItemRightClick(world, playerEntity, hand);
    }


    private void rightClick(PlayerEntity playerEntity) {
            swapHealthForAbsorption(playerEntity, 1);
    }


    public static void reduceHealthByOne(Entity entity, int damage)
    {
        entity.hurtResistantTime = 0;
        entity.attackEntityFrom(DamageSource.OUT_OF_WORLD.setDamageIsAbsolute(), damage);
        //System.out.println("Reduced Health by 1");
    }


    public static void addAbsorption(PlayerEntity playerEntity, int storedAbsorption)
    {
        playerEntity.setAbsorptionAmount(storedAbsorption + 1);
    }


    public static void swapHealthForAbsorption(PlayerEntity playerEntity, int damage)
    {
        if(((playerEntity.getHealth()) > damage) && (playerEntity.getAbsorptionAmount() < 20))
        {
            //System.out.println(playerEntity.getHealth());
            // Store Absorption Amount, for intended health reduction
            int storedAbsorption = (int) (playerEntity.getAbsorptionAmount());

            // Reduce Health by 1, ignoring Absorption
            reduceHealthByOne(playerEntity, storedAbsorption + damage);

            // Increase Absorption Health by 1
            addAbsorption(playerEntity, storedAbsorption);
        }
    }


}