package com.renzaifei.rgra.rules;

import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class CutString {
    @SubscribeEvent
    public static void cut(@NotNull PlayerInteractEvent.LeftClickBlock event) {
        if (!RollingGateRZFAdditionServerRules.cutString) return;
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        if (level.getBlockState(pos).getBlock() != Blocks.TRIPWIRE) return;
        if (level.isClientSide()) return;
        Player player = event.getEntity();
        if (player.getMainHandItem().getItem() != Items.SHEARS) return;
        BlockState state = level.getBlockState(pos).setValue(TripWireBlock.DISARMED, true);
        level.setBlockAndUpdate(pos, state);
        event.setCanceled(true);
    }
}
