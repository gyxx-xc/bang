package org.BangC.marble_bang.entity.Marble;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.BangC.marble_bang.MarbleBang;

public class MarbleRender<T extends Entity> extends EntityRenderer<T> {
    public static final ResourceLocation TEXTURE =
            new ResourceLocation(MarbleBang.MOD_ID, "textures/entity/marble.png");
    protected final EntityModel<MarbleEntity> model;
    protected MarbleRender(EntityRendererProvider.Context context) {
        super(context);
        model = new MarbleModel<>(context.bakeLayer(MarbleModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Entity p_114482_) {
        return null;
    }
}
