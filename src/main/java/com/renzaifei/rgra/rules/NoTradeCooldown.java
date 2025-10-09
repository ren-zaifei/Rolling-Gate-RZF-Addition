package com.renzaifei.rgra.rules;


import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.TradeWithVillagerEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
public class NoTradeCooldown {
    @SubscribeEvent
    public static void noCooldown(@NotNull TradeWithVillagerEvent event) {
        if (!RollingGateRZFAdditionServerRules.noTradeCooldown) return;
        MerchantOffer offer = event.getMerchantOffer();
        offer.resetUses();
        offer.resetSpecialPriceDiff();
    }
}
