package net.malachis.tutorialmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

// Add use animation if possible

public class VoidPolarityDisplacementChannelingDevice extends Item {
    int storedAbsorption = 0;

    public VoidPolarityDisplacementChannelingDevice(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {

        if(!world.isRemote) {
            rightClick(playerEntity, hand);
        }

        return super.onItemRightClick(world, playerEntity, hand);
    }


    private void rightClick(PlayerEntity playerEntity, Hand hand) {

        if((playerEntity.getHealth() > 1) && (playerEntity.getAbsorptionAmount() < 20))
        {
            // Store Absorption Amount, for intended health reduction
            storedAbsorption = (int) playerEntity.getAbsorptionAmount();

            // Reduce Health by 1, ignoring Absorption
            reduceHealthByOne(playerEntity, storedAbsorption + 1);

            // Increase Absorption Health by 1
            addAbsorption(playerEntity, storedAbsorption);
        }
    }


    public static void reduceHealthByOne(Entity entity, int damage)
    {
        entity.hurtResistantTime = 0;
        entity.attackEntityFrom(DamageSource.OUT_OF_WORLD.setDamageIsAbsolute(), damage);
    }


    public static void addAbsorption(PlayerEntity playerEntity, int storedAbsorption)
    {
        playerEntity.setAbsorptionAmount(storedAbsorption + 1);
    }
}