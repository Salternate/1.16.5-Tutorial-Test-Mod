package net.malachis.tutorialmod.item;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.block.ModBlocks;
import net.malachis.tutorialmod.item.custom.VoidPolarityDisplacementChannelingDevice;
import net.minecraft.inventory.EquipmentSlotType;
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


    public static final RegistryObject<Item> VOID_DIAMOND_BOOTS = ITEMS.register("void_diamond_boots", () -> new ArmorItem(ModArmorMaterial.VOID_DIAMOND, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> VOID_DIAMOND_LEGGINGS = ITEMS.register("void_diamond_leggings", () -> new ArmorItem(ModArmorMaterial.VOID_DIAMOND, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> VOID_DIAMOND_CHESTPLATE = ITEMS.register("void_diamond_chestplate", () -> new ArmorItem(ModArmorMaterial.VOID_DIAMOND, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> VOID_DIAMOND_HELMET = ITEMS.register("void_diamond_helmet", () -> new ArmorItem(ModArmorMaterial.VOID_DIAMOND, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));


    //public static final RegistryObject<Item> GOLDEN_PUMPKIN_SEED = ITEMS.register("golden_pumpkin_seed", () -> new BlockItem(ModBlocks.GOLDEN_PUMPKIN.get(), new Item.Properties().food(new Food.Builder().hunger(2).saturation(0.2f).fastToEat().build()).group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> VOID_SEEDS = ITEMS.register("void_seeds", () -> new BlockItem(ModBlocks.VOID_CROP.get(), new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> VOID_HARVEST = ITEMS.register("void_harvest", () -> new BlockItem(ModBlocks.VOID_CROP.get(), new Item.Properties().food( new Food.Builder().hunger(-1).saturation(-1.0f).setAlwaysEdible().build()).group(ModItemGroup.TUTORIAL_GROUP)));
    // Above items must be changed to named items, add Void Saturation Effect to Void Harvest


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
