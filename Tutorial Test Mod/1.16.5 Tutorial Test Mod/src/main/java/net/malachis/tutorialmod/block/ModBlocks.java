package net.malachis.tutorialmod.block;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.block.custom.VoidEnergyBlock;
import net.malachis.tutorialmod.item.ModItemGroup;
import net.malachis.tutorialmod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);


    public static final RegistryObject<Block> VOID_DIAMOND_ORE = registerBlock("void_diamond_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> VOID_DIAMOND_BLOCK = registerBlock("void_diamond_block",
            () -> new Block(AbstractBlock.Properties.create(Material.CORAL)
                    .harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> SATURATOR = registerBlock("saturator",
            () -> new FurnaceBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3.5F)));

    public static final RegistryObject<Block> VOID_ENERGY_BLOCK = registerBlock("void_energy_block", () -> new VoidEnergyBlock(AbstractBlock.Properties.create(Material.AIR).harvestLevel(5).hardnessAndResistance(7f)));

    public static final RegistryObject<Block> VOID_STONE = registerBlock("void_stone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));

    public static final RegistryObject<Block> VOID_STONE_BRICKS = registerBlock("void_stone_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));

    public static final RegistryObject<Block> VOID_COBBLESTONE = registerBlock("void_cobblestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2.5f)));

    public static final RegistryObject<Block> VOID_BEDROCK = registerBlock("void_bedrock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(7f)));

    public static final RegistryObject<Block> VOID_PLANKS = registerBlock("void_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2f)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
