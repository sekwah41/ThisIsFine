package _this.is.fine.mixins.common;

import _this.is.fine.ThisIsFine;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class MixinEntityIsFine {

    @Shadow
    private int fireTimer;

    @Inject(method = "setOnFireFor", at = @At("HEAD"), cancellable = true)
    public void setOnFireFor(int int_1, CallbackInfo info) {
        if(!((Entity) (Object)this).isOnFire() && int_1 > 0 && ((Object) this)instanceof ServerPlayerEntity && !((ServerPlayerEntity) (Object)this).isCreative() &&
                ((PlayerEntity) (Object)this).inventory.armor.get(3).getItem() != ThisIsFine.ITEM_SHADES) {
            ((ServerPlayerEntity) (Object)this).getServer().getPlayerManager().sendToAll(new TranslatableTextComponent("chat.type.text", ((ServerPlayerEntity) (Object)this).getDisplayName(), "This Is Fine"));
        }
    }

    @Inject(method = "isOnFire", at = @At("HEAD"), cancellable = true)
    public void isOnFire(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if(((Object) this)instanceof PlayerEntity && ((PlayerEntity) (Object)this).inventory.armor.get(3).getItem() == ThisIsFine.ITEM_SHADES) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }
}
