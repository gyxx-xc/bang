package org.BangC.marble_bang.entity.Marble;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.BangC.marble_bang.MarbleBang;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class MarbleModel<T extends Entity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(MarbleBang.MOD_ID, "Marble"), "main");
    private final ModelPart bb_main;

    public MarbleModel(ModelPart root) {
        bb_main = root.getChild("bb_main");
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer,
                               int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        bb_main.translateAndRotate(poseStack);
        final float[][][] oneCube = {
                {{1, 1, 1, 1}, {1, 1, 1}},
                {{1, 1, 0, 1}, {1, 1, -1}},
                {{1, 0, 1, 1}, {1, -1, 1}},
                {{1, 0, 0, 1}, {1, -1, -1}},
                {{0, 1, 1, 1}, {-1, 1, 1}},
                {{0, 0, 1, 1}, {-1, -1, 1}},
                {{0, 1, 0, 1}, {-1, 1, -1}},
                {{0, 0, 0, 1}, {-1, -1, -1}}
        };
        final int[][] order = {
                {0, 1, 3, 2},
                {4, 5, 7, 6},
                {0, 1, 6, 4},
                {2, 3, 7, 5},
                {0, 2, 5, 4},
                {1, 3, 7, 6}
        };
        final float[][] uv = {
                {1f, 1f},
                {1f, 0f},
                {0f, 0f},
                {0f, 1f}
        };
        for(int i = 0; i < 6; i ++)
            for(int j = 0; j < 4; j ++)
                createBallPoint(poseStack, vertexConsumer,
                        new Vector4f( oneCube[ order[i][j] ][0] ),
                        new Vector3f( oneCube[ order[i][j] ][1] ),
                        uv[j][0], uv[j][1],
                        packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    private void createBallPoint(PoseStack poseStack, VertexConsumer vertexConsumer,
                                 Vector4f poseIn,
                                 Vector3f normalIn,
                                 float u, float v,
                                 int packedLight, int packedOverlay,
                                 float red, float green, float blue, float alpha){
        Matrix4f poseS = poseStack.last().pose();
        Matrix3f normalS = poseStack.last().normal();
        Vector4f pose = poseS.transform(poseIn);
        Vector3f normal = normalS.transform(normalIn.normalize());
        vertexConsumer.vertex(pose.x(), pose.y(), pose.z(),
                red, green, blue, alpha,
                u, v,
                packedOverlay, packedLight,
                normal.x(), normal.y(), normal.z());
    }
}
