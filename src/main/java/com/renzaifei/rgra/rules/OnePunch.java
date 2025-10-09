package com.renzaifei.rgra.rules;

import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;

@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class OnePunch {
    @SubscribeEvent
    public static void one(AttackEntityEvent event) {
        if (!RollingGateRZFAdditionServerRules.onePunch)return;
        Player player = event.getEntity();
        if (!player.isCreative())return;
        event.getTarget().hurt(player.damageSources().playerAttack(player),Float.MAX_VALUE);
    }
}
