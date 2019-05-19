package com.bpteammc.mitrek.client.renderers;

import com.bpteammc.mitrek.Mitrek;
import com.bpteammc.mitrek.client.models.EnterPriseShip;
import com.bpteammc.mitrek.common.blocks.BlockShipExterior;
import com.bpteammc.mitrek.common.tileentity.exteriors.TileShipExterior_01;
import com.bpteammc.mitrek.util.helper.RenderHelpers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderShipExterior_01 extends TileEntitySpecialRenderer<TileShipExterior_01> {

    public EnterPriseShip priseShip = new EnterPriseShip();
    public static ResourceLocation texture = new ResourceLocation(Mitrek.MODID, "tewtures/block/enterprise");

    @Override
    public void render(TileShipExterior_01 te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.5, y + 1.5, z - 0.5);
        GlStateManager.rotate(180, 1, 0, 0);
        IBlockState state = te.getWorld().getBlockState(te.getPos());
        if (state.getBlock() instanceof BlockShipExterior) {
            GlStateManager.rotate(RenderHelpers.getAngleFromFacing(state.getValue(BlockShipExterior.FACING)), 0, 1, 0);
        }
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        priseShip.render(null, 0,0,0,0,0,0.0625f);
        GlStateManager.popMatrix();
    }
}
