package com.renzaifei.rgra.Mixin;

import com.renzaifei.rgra.RollingGateRZFAdditionServerRules;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(targets = "net.minecraft.world.entity.monster.EnderMan$EndermanTakeBlockGoal")
public class EndermanTakeBlockGoalMixin {
    @Redirect(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z"
            )
    )
    private boolean redirectIsEndermanHoldable(BlockState blockState, TagKey<Block> tagKey) {
        if (!RollingGateRZFAdditionServerRules.smartEndermen) {
            return blockState.is(tagKey);
        }
        if (blockState.is(BlockTags.ENDERMAN_HOLDABLE)) {
            return blockState.is(Blocks.MELON) || blockState.is(Blocks.PUMPKIN);
        }
        return blockState.is(tagKey);
    }
}