package com.renzaifei.rgra.Mixin;

import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BushBlock.class)
public class WitherRoseMixin {

    @Inject(
            method = "mayPlaceOn",
            at = @At("HEAD"),
            cancellable = true
    )
    private void mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (RollingGateRZFAdditionServerRules.toughWitherRose) {
            if ((Object)this == Blocks.WITHER_ROSE){
                cir.setReturnValue(true);
            }
        }
    }
}
