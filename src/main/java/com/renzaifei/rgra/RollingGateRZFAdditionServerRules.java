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
    //懂事的末影人
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean smartEndermen = false;
    //村民无限交易
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean noTradeCooldown = false;
    //创造模式一击必杀
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean onePunch = false;
    //禁用爆炸破坏方块
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean cancelExplodeBroke = false;
    //禁用流体破坏红石原件
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean cancelFluidBroke = false;
    //骨粉催熟小型花
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean accelerateSmallFlowers = false;
    //坚韧凋零玫瑰
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean toughWitherRose = false;
    //海龟蛋快速腐化
    @Rule(
            categories = {
                    RollingGateRZFAddition.MODID,
            }
    )
    public static boolean turtleEggFastHatch = false;
}
