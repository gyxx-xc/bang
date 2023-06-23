package org.BangC.marble_bang.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
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

public class RailHolderBlockRender implements BlockEntityRenderer<RailHolderBlockEntity> {
    public static final ResourceLocation LIGHT = new ResourceLocation(MarbleBang.MOD_ID, "block/light");
    public RailHolderBlockRender(BlockEntityRendererProvider.Context context) {
    }
    @Override
    public void render(@NotNull RailHolderBlockEntity pBlockEntity, float pPartialTick,
                       @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBufferSource,
                       int pPackedLight, int pPackedOverlay) {

        pPoseStack.pushPose();
        pPoseStack.translate(0.45, 0.45, 0.5);
        VertexConsumer vc = pBufferSource.getBuffer(RenderType.solid());
        Matrix4f matrix = pPoseStack.last().pose();
        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(LIGHT);
        vc.vertex(matrix, 0.1f, 0.1f, 1).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0.1f, 0, 0).endVertex();
        vc.vertex(matrix, 0.1f, 0, 1)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0.1f, 0, 0).endVertex();
        vc.vertex(matrix, 0.1f, 0, 0)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0.1f, 0, 0).endVertex();
        vc.vertex(matrix, 0.1f, 0.1f, 0).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0.1f, 0, 0).endVertex();

        vc.vertex(matrix, 0, 0.1f, 0).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 0, 0).endVertex();
        vc.vertex(matrix, 0, 0, 0)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 0, 0).endVertex();
        vc.vertex(matrix, 0, 0, 1)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 0, 0).endVertex();
        vc.vertex(matrix, 0, 0.1f, 1).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 0, 0).endVertex();

        vc.vertex(matrix, 0.1f, 0.1f, 1).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 1, 0).endVertex();
        vc.vertex(matrix, 0.1f, 0.1f, 0).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 1, 0).endVertex();
        vc.vertex(matrix, 0, 0.1f, 0)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 1, 0).endVertex();
        vc.vertex(matrix, 0, 0.1f, 1)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, 1, 0).endVertex();

        vc.vertex(matrix, 0.1f, 0, 0).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, -1, 0).endVertex();
        vc.vertex(matrix, 0.1f, 0, 1).color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, -1, 0).endVertex();
        vc.vertex(matrix, 0, 0, 1)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, -1, 0).endVertex();
        vc.vertex(matrix, 0, 0, 0)   .color(0xffffffff).uv(sprite.getU0(), sprite.getV0()).uv2(pPackedLight).normal(0, -1, 0).endVertex();
        pPoseStack.popPose();
    }

}
