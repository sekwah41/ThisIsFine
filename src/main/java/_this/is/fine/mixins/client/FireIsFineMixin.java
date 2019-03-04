package _this.is.fine.mixins.client;

import _this.is.fine.ThisIsFine;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(FireBlock.class)
public class FireIsFineMixin {

    @Environment(EnvType.CLIENT)
    @Inject(method="randomDisplayTick", at=@At("HEAD"), cancellable = true)
    public void randomDisplayTick(BlockState blockState_1, World world_1, BlockPos blockPos_1, Random random_1, CallbackInfo info) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if(player != null && player.inventory.armor.get(3).getItem() == ThisIsFine.ITEM_SHADES) {
            info.cancel();
        }
    }
}
