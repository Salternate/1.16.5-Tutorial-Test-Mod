package net.malachis.tutorialmod.tileentity;

import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TutorialMod.MOD_ID);

    public static RegistryObject<TileEntityType<SaturatorTile>> SATURATOR_TILE = TILE_ENTITIES.register("saturator_tile", () -> TileEntityType.Builder.create(SaturatorTile::new, ModBlocks.SATURATOR.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        TILE_ENTITIES.register(eventBus);
    }
}
