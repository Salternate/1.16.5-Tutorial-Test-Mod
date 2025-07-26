package net.malachis.tutorialmod.world.gen;

import net.malachis.tutorialmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    VOID_DIAMOND(Lazy.of(ModBlocks.VOID_DIAMOND_ORE), 7, 16, 50),
    //DESATURATED_DIAMOND(Lazy.of(ModBlocks.DESATURATED_DIAMOND_ORE), 7, 25, 50)
    ;

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public static OreType get(Block block)
    {
        for (OreType ore : values())
        {
            if(block == ore.block)
            {
                return ore;
            }
        }
        return null;
    }
}
