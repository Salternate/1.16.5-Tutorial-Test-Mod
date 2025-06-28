package net.malachis.tutorialmod.item;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.item.custom.VoidPolarityDisplacementChannelingDevice;
import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> VOID_DIAMOND = ITEMS.register("void_diamond",
            () -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> ENDSTONE_ENCASED_DIAMOND = ITEMS.register("endstone_encased_diamond",
            () -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> VOID_POLARITY_DISPLACEMENT_CHANNELING_DEVICE = ITEMS.register("void_polarity_displacement_channeling_device",
            () -> new VoidPolarityDisplacementChannelingDevice(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxStackSize(1)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
