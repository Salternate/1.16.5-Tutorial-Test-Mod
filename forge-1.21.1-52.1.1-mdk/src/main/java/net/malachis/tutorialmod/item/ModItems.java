package net.malachis.tutorialmod.item;

import net.malachis.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> VOID_DIAMOND = ITEMS.register( "void_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> END_STONE_ENCASED_DIAMOND = ITEMS.register("end_stone_encased_diamond",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
