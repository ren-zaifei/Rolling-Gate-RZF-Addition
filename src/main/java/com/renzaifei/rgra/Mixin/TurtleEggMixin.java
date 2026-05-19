package com.renzaifei.rgra.Mixin;


import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TurtleEggBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TurtleEggBlock.class)
public class TurtleEggMixin {

    @Inject(method = "shouldUpdateHatchLevel",at = @At("HEAD"), cancellable = true)
    private void suhl(Level level , CallbackInfoReturnable<Boolean> cir){
        if (RollingGateRZFAdditionServerRules.turtleEggFastHatch) {
            cir.setReturnValue(true);
        }
    }
}
