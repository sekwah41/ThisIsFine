package _this.is.fine.mixins.common;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class MixinPlayerIsFine {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    public void damage(DamageSource damageSource, float float_1, CallbackInfoReturnable<Boolean> info) {
        if(damageSource.isFire()) {
            info.setReturnValue(false);
        }
    }
}
