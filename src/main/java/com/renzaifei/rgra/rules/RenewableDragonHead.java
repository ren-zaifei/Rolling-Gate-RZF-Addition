package com.renzaifei.rgra.rules;

import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class RenewableDragonHead {
    @SubscribeEvent
    public static void Renewable(@NotNull LivingDeathEvent event) {
        if (!RollingGateRZFAdditionServerRules.renewableDragonHead) return;
        Level level = event.getEntity().level();
        if (level.isClientSide()) return;
        if (!(event.getEntity() instanceof EnderDragon)) return;
        LivingEntity dragon = event.getEntity();
        Vec3 dragonpos = dragon.position();
        Vec3 headpos1 = new Vec3(dragonpos.x, 70, dragonpos.z);
        BlockPos headpos = getDragonHead(dragon, headpos1);
        ItemEntity itemEntity = new ItemEntity(level, headpos.getX(), headpos.getY()+20, headpos.getZ(), new ItemStack(Items.DRAGON_HEAD));
        itemEntity.setGlowingTag(true);
        itemEntity.setDeltaMovement(Vec3.ZERO);
        level.addFreshEntity(itemEntity);
    }

    private static BlockPos getDragonHead(LivingEntity entity,Vec3 pos) {
        Level level = entity.level();
        BlockPos blockPos = BlockPos.containing(pos) ;
        int searchRadius = 40;
        for (int radius = 0; radius <= searchRadius; radius++) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (Math.abs(x) != radius && Math.abs(z) != radius) {
                        continue;
                    }
                    for (int y = 1; y < 30; y++) {
                        BlockPos checkPos = blockPos.offset(x, -y, z);
                        BlockState state = level.getBlockState(checkPos);
                        if (state.is(Blocks.AIR)) continue;
                        if (!state.is(Blocks.END_STONE)) break;
                        return checkPos;
                    }
                }
            }
        }
        return level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, blockPos);
    }
}
