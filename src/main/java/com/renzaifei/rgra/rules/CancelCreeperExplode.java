package com.renzaifei.rgra.rules;


import com.renzaifei.rgra.RollingGateRZFAddition;
import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.world.entity.monster.Creeper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = RollingGateRZFAddition.MODID)
public class CancelCreeperExplode {
    @SubscribeEvent
    public static void cancel(@NotNull ExplosionEvent.Detonate event) {
        if (!RollingGateRZFAdditionServerRules.cancelCreeperExplode) return;
        if (!(event.getExplosion().getDirectSourceEntity() instanceof Creeper)) return;
        event.getAffectedBlocks().clear();
    }
}
