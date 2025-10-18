package com.renzaifei.rgra.Mixin;


import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(FlowingFluid.class)
public class CancelFluidBroke {

    @Inject(method = "canSpreadTo",
            at = @At("HEAD"),
            cancellable = true)
    private void cancelFluidBroke(BlockGetter level, BlockPos fromPos, BlockState fromBlockState, Direction direction, BlockPos toPos, BlockState toBlockState, FluidState toFluidState, Fluid fluid, CallbackInfoReturnable<Boolean> cir) {
        if (!RollingGateRZFAdditionServerRules.cancelFluidBroke) {
            return;
        }
        if (toBlockState.is(BlockTags.BUTTONS)) {
            cir.setReturnValue(false);
            return;
        }
        Block block = toBlockState.getBlock();
        if (isRedStoneComponent(block)) {
            cir.setReturnValue(false);
        }
    }

    private boolean isRedStoneComponent(Block block) {
        return block == Blocks.REDSTONE_WIRE ||
                block == Blocks.REDSTONE_TORCH ||
                block == Blocks.REPEATER ||
                block == Blocks.COMPARATOR ||
                block == Blocks.LEVER ||
                block == Blocks.TRIPWIRE_HOOK;
    }
}
