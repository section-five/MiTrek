/*
        All code copyright (C) BP Team 2019.
        All rights reserved.
        Contact support@bpteam.xyz for more info
*/
package xyz.bpteam.mitrek.client.renderers;

import xyz.bpteam.mitrek.Mitrek;
import xyz.bpteam.mitrek.client.models.ModelBeam;
import xyz.bpteam.mitrek.common.entity.EntityBeam;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBeam extends Render<xyz.bpteam.mitrek.common.entity.EntityBeam> {
    private Entity EntityBeam;

    public RenderBeam(RenderManager renderManager) {
        super(renderManager);
    }
    public ModelBeam beam = new ModelBeam();
    public static final ResourceLocation texture = new ResourceLocation(Mitrek.MODID, "textures/items/beam.png");
// TODO render beam model for this


    @Override
    public void doRenderShadowAndFire(Entity entityIn, double x, double y, double z, float yaw, float partialTicks) {

    }

    @Override
    public void doRender(EntityBeam entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(x + 0.6, y + 10, z + 0.6);
        GlStateManager.rotate(180, 1, 0, 0);
        GlStateManager.scale(7,7,7);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        GlStateManager.popMatrix();
        beam.render(EntityBeam, 0,0,0,0,0,1f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBeam entity) {
        return texture;
    }
}
