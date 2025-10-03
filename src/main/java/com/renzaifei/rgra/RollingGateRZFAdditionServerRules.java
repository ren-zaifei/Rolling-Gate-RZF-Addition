package com.renzaifei.rgra;


import dev.anvilcraft.rg.api.Rule;
import dev.anvilcraft.rg.api.server.RGServerRules;

@RGServerRules(value = "rolling_gate_rzf_addition", languages = {"zh_cn", "en_us"})
public class RollingGateRZFAdditionServerRules {
    //引入fabric刷线机
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean cutString = false;
    //岩浆碰到铁块生成安山岩
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean lavaAndesiteHandler = false;
    //苦力怕爆炸不破坏方块
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean cancelCreeperExplode = false;
    //杀死末影龙掉落龙头
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean renewableDragonHead = false;
}
