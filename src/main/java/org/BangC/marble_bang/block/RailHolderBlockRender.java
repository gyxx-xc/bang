package org.BangC.marble_bang.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import org.BangC.marble_bang.MarbleBang;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.SplittableRandom;

public class RailHolderBlockRender implements BlockEntityRenderer<RailHolderBlockEntity> {
    private ModelPart bb_main;
    public static final ResourceLocation LIGHT = new ResourceLocation(MarbleBang.MOD_ID, "block/light");
    public RailHolderBlockRender(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(@NotNull RailHolderBlockEntity pBlockEntity, float pPartialTick,
                       @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBufferSource,
                       int pPackedLight, int pPackedOverlay) {

        pPoseStack.pushPose();
        pPoseStack.translate(0, 0.5f, 0);
        renderBillboardQuadBright(pPoseStack, pBufferSource.getBuffer(RenderType.solid()), 0.5f, LIGHT);
        pPoseStack.popPose();
    }

    private static void renderBillboardQuadBright(PoseStack matrixStack, VertexConsumer builder, float scale, ResourceLocation texture) {
        int b1 = LightTexture.FULL_BRIGHT >> 16 & 65535;
        int b2 = LightTexture.FULL_BRIGHT & 65535;
        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(texture);
        matrixStack.pushPose();
        matrixStack.translate(0.5, 0.95, 0.5);
        Quaternionf rotation = Minecraft.getInstance().gameRenderer.getMainCamera().rotation();
        matrixStack.mulPose(rotation);
        Matrix4f matrix = matrixStack.last().pose();
        builder.vertex(matrix, -scale, -scale, 0.0f).color(255, 255, 255, 255).uv(sprite.getU0(), sprite.getV0()).uv2(b1, b2).normal(1, 0, 0).endVertex();
        builder.vertex(matrix, -scale, scale, 0.0f).color(255, 255, 255, 255).uv(sprite.getU0(), sprite.getV1()).uv2(b1, b2).normal(1, 0, 0).endVertex();
        builder.vertex(matrix, scale, scale, 0.0f).color(255, 255, 255, 255).uv(sprite.getU1(), sprite.getV1()).uv2(b1, b2).normal(1, 0, 0).endVertex();
        builder.vertex(matrix, scale, -scale, 0.0f).color(255, 255, 255, 255).uv(sprite.getU1(), sprite.getV0()).uv2(b1, b2).normal(1, 0, 0).endVertex();
        matrixStack.popPose();
    }
}
