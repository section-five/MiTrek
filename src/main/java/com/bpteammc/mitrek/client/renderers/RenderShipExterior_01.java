package com.bpteammc.mitrek.client.renderers;

import com.bpteammc.mitrek.client.models.EnterPriseShip;
import com.bpteammc.mitrek.common.tileentity.exteriors.TileShipExterior_01;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderShipExterior_01 extends TileEntitySpecialRenderer<TileShipExterior_01> {

    public EnterPriseShip priseShip = new EnterPriseShip();

    @Override
    public void render(TileShipExterior_01 te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.popMatrix();
        priseShip.render(null, 0,0,0,0,0,0.065f);
        GlStateManager.pushMatrix();

    }
}
