package reign.createaddons.customportalapiintegrations.mixin;

import com.simibubi.create.content.trains.entity.Carriage;

import net.kyrptonaught.customportalapi.interfaces.EntityInCustomPortal;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Carriage.DimensionalCarriageEntity.class)
public abstract class DCEntityMixin {
	@Inject(method = "dismountPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;setPortalCooldown()V"))
	public void dimensionalCarriageEntity$setCustomPortalCooldown(ServerLevel sLevel, ServerPlayer sp, Integer seat, boolean capture, CallbackInfo ci) {
		((EntityInCustomPortal)(Object)sp).setDidTP(true);
	}
}
