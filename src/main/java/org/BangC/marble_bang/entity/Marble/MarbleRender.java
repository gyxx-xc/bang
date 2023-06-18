package org.BangC.marble_bang.entity.Marble;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.BangC.marble_bang.MarbleBang;

public class MarbleRender<T extends Entity> extends EntityRenderer<T> {
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(MarbleBang.MOD_ID, "textures/entity/marble.png");
    protected final EntityModel<MarbleEntity> model;
    public MarbleRender(EntityRendererProvider.Context context) {
        super(context);
        model = new MarbleModel<>(context.bakeLayer(MarbleModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_114482_) {
        return TEXTURE;
    }

    @Override
    public void render(T entityIn, float entityYaw, float partialTicks,
                       PoseStack poseStackIn, MultiBufferSource bufferSourceIn, int packedLightIn) {

        super.render(entityIn, entityYaw, partialTicks, poseStackIn, bufferSourceIn, packedLightIn);
        poseStackIn.pushPose();
        VertexConsumer vertexConsumer = bufferSourceIn.getBuffer(this.model.renderType(this.getTextureLocation(entityIn)));
        this.model.renderToBuffer(poseStackIn, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStackIn.popPose();
    }
}
