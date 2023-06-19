package org.BangC.marble_bang.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
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
import org.joml.Vector3f;

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

        Vector3f[] curve = new Vector3f[]{
                new Vector3f(0, 0, 0),
                new Vector3f(0, 1, 1),
                new Vector3f(2, 3, 4)
        };
        Matrix4f oldm = null, m;
        for(int i = 0; i < curve.length; i ++){
            pPoseStack.pushPose();
            pPoseStack.translate(curve[i].x, curve[i].y, curve[i].z);
            Vector3f dir = (i == curve.length-1 ? curve[i] : curve[i+1]).sub(i == 0 ? curve[i] : curve[i-1]).normalize();
            Vector3f rad;
            if(i == 0)
                rad = curve[i+2].sub(curve[i+1]).add(curve[i].sub(curve[i+1])).normalize();
            else if(i == curve.length-1)
                rad = curve[i].sub(curve[i-1]).add(curve[i-2].sub(curve[i-1])).normalize();
            else
                rad = curve[i+1].sub(curve[i]).add(curve[i-1].sub(curve[i])).normalize();
            Quaternionf q = new Quaternionf(1, 1, 1, 1).lookAlong(dir, rad);
            pPoseStack.mulPose(q);
            /*pPoseStack.scale(0.1f, 0.1f, 0.1f);*/
            m = pPoseStack.last().pose();
            pPoseStack.popPose();
            /*if(i != 0){
                vc.vertex(m, 1, 1, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(m, 1, 1, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(m, 1, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(m, 1, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();

                vc.vertex(m, 1, 1, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(oldm, 1, 1, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(oldm, 0, 1, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(m, 0, 1, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();

                vc.vertex(m, 0, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(oldm, 0, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(oldm, 1, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(m, 1, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();

                vc.vertex(m, 0, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(oldm, 0, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(oldm, 1, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
                vc.vertex(m, 1, 0, 0)
                        .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                        .uv2(pPackedLight).normal(0, 1, 0).endVertex();
            }*/

            vc.vertex(m, 1, 1, 0)
                    .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                    .uv2(pPackedLight).normal(0, 1, 0).endVertex();
            vc.vertex(m, 1, 0, 0)
                    .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                    .uv2(pPackedLight).normal(0, 1, 0).endVertex();
            vc.vertex(m, 0, 0, 0)
                    .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                    .uv2(pPackedLight).normal(0, 1, 0).endVertex();
            vc.vertex(m, 0, 1, 0)
                    .color(0xffffffff).uv(sprite.getU0(), sprite.getV0())
                    .uv2(pPackedLight).normal(0, 1, 0).endVertex();

            oldm = m;
        }
        pPoseStack.popPose();
    }
}
