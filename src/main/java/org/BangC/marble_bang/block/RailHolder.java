package org.BangC.marble_bang.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class RailHolder extends Block {
    public static final String ID = "rail_holder";
    public RailHolder() {
        super(Properties.of(Material.METAL));
    }
}
