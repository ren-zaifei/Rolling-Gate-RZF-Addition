package com.renzaifei.rgra.rules;

import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;

@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class AccelerateSmallFlowers {
    @SubscribeEvent
    public static void smallFlowers(BonemealEvent event) {
        if (!RollingGateRZFAdditionServerRules.accelerateSmallFlowers) return;
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Block block = event.getState().getBlock();
        Player player = event.getPlayer();
        if (event.getState().is(BlockTags.SMALL_FLOWERS)) {
            event.setSuccessful(true);
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                        pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        10, 0.5, 0.5, 0.5, 0.1);
            }
            assert player != null;
            player.getMainHandItem().shrink(1);
            ItemEntity itemEntity = new ItemEntity(level,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(block));
            level.addFreshEntity(itemEntity);
        }
    }
}
