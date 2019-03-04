package _this.is.fine.mixins.client;

import _this.is.fine.ThisIsFine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockIsFineMixin {



    @Inject(method="getRenderType", at=@At("HEAD"), cancellable = true)
    public void getRenderLayer(CallbackInfoReturnable<BlockRenderType> infoReturnable) {
        if((Object) this == Blocks.FIRE) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if(player != null && player.inventory.armor.get(3).getItem() == ThisIsFine.ITEM_SHADES) {
                infoReturnable.setReturnValue(BlockRenderType.INVISIBLE);
            }
        }
    }
}
