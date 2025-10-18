package com.renzaifei.rgra.rules;


import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ExplosionEvent;

@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class CancelExplodeBroke {
    @SubscribeEvent
    public static void broke(ExplosionEvent.Detonate event) {
        if (!RollingGateRZFAdditionServerRules.cancelExplodeBroke) return;
        event.getAffectedBlocks().clear();
    }
}
