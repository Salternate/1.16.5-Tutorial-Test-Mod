package net.malachis.tutorialmod.item;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.item.custom.VoidPolarityDisplacementChannelingDevice;
import net.minecraft.item.*;
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
            () -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxStackSize(8)));


    public static final RegistryObject<Item> VOID_POLARITY_DISPLACEMENT_CHANNELING_DEVICE = ITEMS.register("void_polarity_displacement_channeling_device",
            () -> new VoidPolarityDisplacementChannelingDevice(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxStackSize(1)));


    public static final RegistryObject<Item> VOID_DIAMOND_SWORD = ITEMS.register("void_diamond_sword",
            () -> new SwordItem(ModItemTier.VOID_DIAMOND, 3, -2.3f, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> VOID_DIAMOND_PICKAXE = ITEMS.register("void_diamond_pickaxe",
            () -> new PickaxeItem(ModItemTier.VOID_DIAMOND, 1, -2.7f, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> VOID_DIAMOND_AXE = ITEMS.register("void_diamond_axe",
            () -> new AxeItem(ModItemTier.VOID_DIAMOND, 5, -2.9f, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> VOID_DIAMOND_SHOVEL = ITEMS.register("void_diamond_shovel",
            () -> new ShovelItem(ModItemTier.VOID_DIAMOND, 1.5f, -2.9f, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> VOID_DIAMOND_HOE = ITEMS.register("void_diamond_hoe",
            () -> new HoeItem(ModItemTier.VOID_DIAMOND, -3, 0.1f, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
