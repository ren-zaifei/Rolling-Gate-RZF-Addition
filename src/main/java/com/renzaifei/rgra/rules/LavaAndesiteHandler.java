package com.renzaifei.rgra.rules;


import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

//实现岩浆碰到铁块变成安山岩
@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class LavaAndesiteHandler {

    @SubscribeEvent
    public static void onNeighborNotify(@NotNull BlockEvent.NeighborNotifyEvent event) {
        if (!RollingGateRZFAdditionServerRules.lavaAndesiteHandler) return;
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        if (level.isClientSide()) return;
        BlockState sourceState = level.getBlockState(pos);
        if (sourceState.getBlock() == Blocks.LAVA) {
            if (isAdjacentToIronBlock(level, pos)) {
                level.setBlock(pos, Blocks.ANDESITE.defaultBlockState(), 3);
                playConversionEffects(level, pos);
            }
        }
    }

    private static boolean isAdjacentToIronBlock(Level level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            if (level.getBlockState(neighborPos).getBlock() == Blocks.IRON_BLOCK) {
                return true;
            }
        }
        return false;
    }

    private static void playConversionEffects(Level level, BlockPos pos) {
        level.playSound(null, pos, SoundEvents.LAVA_EXTINGUISH,
                SoundSource.BLOCKS, 0.5F, 1.0F);

        for (int i = 0; i < 8; i++) {
            double x = pos.getX() + level.random.nextDouble();
            double y = pos.getY() + level.random.nextDouble();
            double z = pos.getZ() + level.random.nextDouble();
            level.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 0.1, 0);
        }
    }
}
