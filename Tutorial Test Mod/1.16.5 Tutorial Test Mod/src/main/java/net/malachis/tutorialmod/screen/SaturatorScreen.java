package net.malachis.tutorialmod.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.malachis.tutorialmod.TutorialMod;
import net.malachis.tutorialmod.container.SaturatorContainer;
import net.malachis.tutorialmod.tileentity.SaturatorTile;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SaturatorScreen extends ContainerScreen<SaturatorContainer> {
    private final ResourceLocation GUI = new ResourceLocation(TutorialMod.MOD_ID, "textures/gui/saturator_gui.png");

    public SaturatorScreen(SaturatorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        if(container.isLightlevelLowEnough())
        {
            this.blit(matrixStack, i+64, j+20, 176, 0, 48, 48); //13 and 17 are the Width and Height of the extra textures cutouts
        }
    }
}
