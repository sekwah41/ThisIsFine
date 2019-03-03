package _this.is.fine.mixins.common;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableTextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntityIsFine {

    @Inject(method = "setOnFireFor", at = @At("HEAD"), cancellable = true)
    public void setOnFireFor(int int_1, CallbackInfo info) {
        if(!((Entity) (Object)this).isOnFire() && int_1 > 0 && ((Object) this)instanceof ServerPlayerEntity && !((ServerPlayerEntity) (Object)this).isCreative()) {
            ((ServerPlayerEntity) (Object)this).getServer().getPlayerManager().sendToAll(new TranslatableTextComponent("chat.type.text", ((ServerPlayerEntity) (Object)this).getDisplayName(), "This Is Fine"));
        }
    }
}
