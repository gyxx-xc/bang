package org.BangC.marble_bang.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.BangC.marble_bang.setup.Registration;

public class RailHolderBlockEntity extends BlockEntity {
    public RailHolderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(Registration.RAIL_HOLDER_ENTITY.get(), pPos, pBlockState);
    }
}
