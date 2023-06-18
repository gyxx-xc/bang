package org.BangC.marble_bang.item;

import net.minecraft.client.particle.BubbleParticle;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.BangC.marble_bang.block.RailHolder;

public class TweakRod extends Item {
    public static final String ID = "tweak_rod";
    public TweakRod() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
         Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
         if(block instanceof RailHolder railHolder){
             railHolder.aaa();
             railHolder.aaa();
             context.getClickLocation();
             context.getLevel().addParticle(ParticleTypes.BUBBLE, 0, 0, 0, 0, 0, 0);
             return InteractionResult.SUCCESS;
         }
        return super.useOn(context);
    }
}
