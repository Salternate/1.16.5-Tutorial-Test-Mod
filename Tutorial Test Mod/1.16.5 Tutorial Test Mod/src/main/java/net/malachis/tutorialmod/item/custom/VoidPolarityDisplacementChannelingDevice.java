package net.malachis.tutorialmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.datafix.fixes.EntityHealth;
import net.minecraft.world.World;

public class VoidPolarityDisplacementChannelingDevice extends Item {
    int storedAbsorption = 0;

    public VoidPolarityDisplacementChannelingDevice(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerEntity, Hand hand) {
        //PlayerEntity playerEntity =


        rightClick(playerEntity);



        return super.onItemRightClick(world, playerEntity, hand);
    }


    private void rightClick(PlayerEntity playerEntity) {

        if((playerEntity.getHealth() > 1) && (playerEntity.getAbsorptionAmount() < 20))
        {
            // Store Absorption Amount, for intended health reduction
            storedAbsorption = (int) playerEntity.getAbsorptionAmount();

            // Reduce Health by 1, ignoring Absorption
            reduceHealthByOne(playerEntity, storedAbsorption + 1);

            // Increase Absorption Health by 1
            addAbsorption(playerEntity, storedAbsorption);

            //playerEntity.hurtTime = 0;
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
