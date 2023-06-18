package org.BangC.marble_bang.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import java.util.SplittableRandom;

public class RailHolderBlockRender implements BlockEntityRenderer<RailHolderBlockEntity> {
    private ModelPart bb_main;
    public RailHolderBlockRender(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(@NotNull RailHolderBlockEntity pBlockEntity, float pPartialTick,
                       @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBufferSource,
                       int pPackedLight, int pPackedOverlay) {
        //VertexConsumer vertexConsumer = pBufferSource.getBuffer(RenderType.solid());
    }
}
