package net.malachis.tutorialmod.block;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.block.custom.VoidEnergyBlock;
import net.malachis.tutorialmod.block.custom.VoidCropBlock;
import net.malachis.tutorialmod.item.ModItemGroup;
import net.malachis.tutorialmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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

    //public static final RegistryObject<Block> VOID_PLANKS = registerBlock("void_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2f)));

    public static final RegistryObject<Block> VOID_STONE_BRICK_STAIRS = registerBlock("void_stone_brick_stairs", () -> new StairsBlock(() -> VOID_STONE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(2f)));

    public static final RegistryObject<Block> VOID_DIAMOND_BLOCK_STAIRS = registerBlock("void_diamond_block_stairs", () -> new StairsBlock(() -> VOID_DIAMOND_BLOCK.get().getDefaultState(), AbstractBlock.Properties.create(Material.ROCK).harvestLevel(5).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> VOID_PLANK_FENCE = registerBlock("void_plank_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f)));

    public static final RegistryObject<Block> VOID_PLANK_FENCE_GATE = registerBlock("void_plank_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(1.5f)));

    public static final RegistryObject<Block> VOID_STONE_BRICK_SLAB = registerBlock("void_stone_brick_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f)));

    public static final RegistryObject<Block> VOID_STONE_BUTTON = registerBlock("void_stone_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f).doesNotBlockMovement()));

    public static final RegistryObject<Block> VOID_STONE_PRESSURE_PLATE = registerBlock("void_stone_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f)));

    public static final RegistryObject<Block> VOID_DIAMOND_BUTTON = registerBlock("void_diamond_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.CORAL).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f).doesNotBlockMovement()));

    public static final RegistryObject<Block> VOID_DIAMOND_PRESSURE_PLATE = registerBlock("void_diamond_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, AbstractBlock.Properties.create(Material.CORAL).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f)));

    public static final RegistryObject<Block> VOID_DIAMOND_DOOR = registerBlock("void_diamond_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.CORAL).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f).notSolid()));

    public static final RegistryObject<Block> VOID_DIAMOND_TRAPDOOR = registerBlock("void_diamond_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.CORAL).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1f).notSolid()));

    //public static final RegistryObject<Block> GOLDEN_PUMPKIN = registerBlock("golden_pumpkin", () -> new PumpkinBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.0f).sound(SoundType.GILDED_BLACKSTONE)));
    //public static final RegistryObject<Block> ATTACHED_GOLDEN_PUMPKIN_STEM = registerBlock("attached_golden_pumpkin_stem", new AttachedStemBlock((StemGrownBlock)GOLDEN_PUMPKIN, AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.WOOD)));
    //public static final RegistryObject<Block> GOLDEN_PUMPKIN_STEM = registerBlock("golden_pumpkin_stem", new StemBlock((StemGrownBlock) GOLDEN_PUMPKIN, AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.STEM)));

    public static final RegistryObject<Block> VOID_CROP = BLOCKS.register("void_crop", () -> new VoidCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> VOID_LOG = registerBlock("void_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> VOID_WOOD = registerBlock("void_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_VOID_LOG = registerBlock("stripped_void_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_VOID_WOOD = registerBlock("stripped_void_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> VOID_PLANKS = registerBlock("void_planks", () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));



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
