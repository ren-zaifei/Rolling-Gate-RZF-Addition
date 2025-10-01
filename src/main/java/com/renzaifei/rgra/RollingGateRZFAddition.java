package com.renzaifei.rgra;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;



@Mod(RollingGateRZFAddition.MODID)
public class RollingGateRZFAddition {
    public static final String MODID = "rolling_gate_rzf_addition";
    public static final Logger LOGGER = LogUtils.getLogger();
    public RollingGateRZFAddition(@NotNull @SuppressWarnings("unused") IEventBus modEventBus, @NotNull @SuppressWarnings("unused") ModContainer modContainer) {
    }
}
