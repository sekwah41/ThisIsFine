package _this.is.fine.mixins.common;

import _this.is.fine.ThisIsFine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;

@Mixin(FireBlock.class)
public class MixinThisIsFine {

    private Random random = new Random();

    @Inject(method = "<init>", at = @At("RETURN"))
    private void initialize(Block.Settings block$Settings_1, CallbackInfo info) {
    }

    @Inject(method = "getSpreadChance", at = @At("RETURN"), cancellable = true)
    private void getSpreadChance(Block block, CallbackInfoReturnable<Integer> info) {
        if(isBlockFine(block) && info.getReturnValue() == 0) {
            info.setReturnValue(5);
        }
    }

    @Inject(method = "getBurnChance(Lnet/minecraft/block/Block;)I", at = @At("RETURN"), cancellable = true)
    private void getBurnChance(Block block, CallbackInfoReturnable<Integer> info) {
        if(isBlockFine(block) && info.getReturnValue() == 0) {
            info.setReturnValue(5);
        }
    }

    private boolean isBlockFine(Block block) {
        return !ThisIsFine.ignoreList.contains(block);
    }

    @Inject(method = "onBlockAdded", at = @At("RETURN"))
    public void onBlockAdded(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2, CallbackInfo info) {
        if(random.nextInt(1000) <= 1) {
            ThisIsFine.logger.info("This Is Fine.");
        }

    }

}
