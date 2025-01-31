package com.dfsek.terra.fabric.mixin.implementations.block.state;

import com.dfsek.terra.api.platform.block.state.MobSpawner;
import com.dfsek.terra.api.platform.block.state.SerialState;
import com.dfsek.terra.api.platform.entity.EntityType;
import com.dfsek.terra.fabric.TerraFabricPlugin;
import com.dfsek.terra.fabric.mixin.access.MobSpawnerLogicAccessor;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.MobSpawnerLogic;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MobSpawnerBlockEntity.class)
@Implements(@Interface(iface = MobSpawner.class, prefix = "terra$", remap = Interface.Remap.NONE))
public abstract class MobSpawnerBlockEntityMixin {
    @Shadow
    public abstract MobSpawnerLogic getLogic();

    public EntityType terra$getSpawnedType() {
        return (EntityType) Registry.ENTITY_TYPE.get(((MobSpawnerLogicAccessor) getLogic()).callGetEntityId());
    }

    public void terra$setSpawnedType(@NotNull EntityType creatureType) {
        getLogic().setEntityId((net.minecraft.entity.EntityType<?>) creatureType);
    }

    public int terra$getDelay() {
        return 0;
    }

    public void terra$setDelay(int delay) {

    }

    public int terra$getMinSpawnDelay() {
        return 0;
    }

    public void terra$setMinSpawnDelay(int delay) {

    }

    public int terra$getMaxSpawnDelay() {
        return 0;
    }

    public void terra$setMaxSpawnDelay(int delay) {

    }

    public int terra$getSpawnCount() {
        return 0;
    }

    public void terra$setSpawnCount(int spawnCount) {

    }

    public int terra$getMaxNearbyEntities() {
        return 0;
    }

    public void terra$setMaxNearbyEntities(int maxNearbyEntities) {

    }

    public int terra$getRequiredPlayerRange() {
        return 0;
    }

    public void terra$setRequiredPlayerRange(int requiredPlayerRange) {

    }

    public int terra$getSpawnRange() {
        return 0;
    }

    public void terra$setSpawnRange(int spawnRange) {

    }

    public void terra$applyState(String state) {
        SerialState.parse(state).forEach((k, v) -> {
            switch(k) {
                case "type":
                    terra$setSpawnedType(TerraFabricPlugin.getInstance().getWorldHandle().getEntity(v));
                    return;
                case "delay":
                    terra$setDelay(Integer.parseInt(v));
                    return;
                case "min_delay":
                    terra$setMinSpawnDelay(Integer.parseInt(v));
                    return;
                case "max_delay":
                    terra$setMaxSpawnDelay(Integer.parseInt(v));
                    return;
                case "spawn_count":
                    terra$setSpawnCount(Integer.parseInt(v));
                    return;
                case "spawn_range":
                    terra$setSpawnRange(Integer.parseInt(v));
                    return;
                case "max_nearby":
                    terra$setMaxNearbyEntities(Integer.parseInt(v));
                    return;
                case "required_player_range":
                    terra$setRequiredPlayerRange(Integer.parseInt(v));
                    return;
                default:
                    throw new IllegalArgumentException("Invalid property: " + k);
            }
        });
    }
}
