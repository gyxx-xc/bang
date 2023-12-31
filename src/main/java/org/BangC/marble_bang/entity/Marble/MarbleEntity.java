package org.BangC.marble_bang.entity.Marble;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MarbleEntity extends Entity {
    public MarbleEntity(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
        this.noPhysics = false;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag p_20139_) {

    }

    @Override
    public void tick() {
        this.setDeltaMovement(this.getDeltaMovement().add(0, -0.04D, 0));
        this.move(MoverType.SELF, this.getDeltaMovement());
        super.tick();
    }

    public boolean isPushable() {
        return true;
    }
}
