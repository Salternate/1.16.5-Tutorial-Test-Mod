//package net.malachis.tutorialmod.tileentity;
//
//import com.mojang.datafixers.types.Type;
//import net.malachis.tutorialmod.block.ModBlocks;
//import net.minecraft.tileentity.FurnaceTileEntity;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.tileentity.TileEntityType;
//import net.minecraft.util.Util;
//import net.minecraft.util.datafix.TypeReferences;
//import net.minecraft.util.registry.Registry;
//
//import java.util.Set;
//import java.util.function.Supplier;
//
//public class ModTileEntities extends TileEntityType {
//    public ModTileEntities(Supplier p_i51497_1_, Set p_i51497_2_, Type p_i51497_3_) {
//        super(p_i51497_1_, p_i51497_2_, p_i51497_3_);
//    }
//
//
//    public static final TileEntityType<FurnaceTileEntity> SATURATOR = register("saturator", TileEntityType.Builder.create(FurnaceTileEntity::new, ModBlocks.SATURATOR));
//
//
//    private static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
//
//
//        Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, key);
//        return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
//    }
//}
