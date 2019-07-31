package io.github.bpteammc.mitrek.client.models;
//Made with Blockbench
//Paste this code into your mod.
//Copyright UKMinecrafted 2019

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelBeam extends ModelBase {
	private final ModelRenderer beam;


	public ModelBeam() {
		textureWidth = 64;
		textureHeight = 64;

		beam = new ModelRenderer(this);
		beam.setRotationPoint(0.0F, 24.0F, 0.0F);
		beam.cubeList.add(new ModelBox(beam, 0, 0, -2.0F, -4.0F, -8.0F, 4, 4, 16, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		beam.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}