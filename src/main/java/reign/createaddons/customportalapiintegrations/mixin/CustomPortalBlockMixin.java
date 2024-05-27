package reign.createaddons.customportalapiintegrations.mixin;


import net.kyrptonaught.customportalapi.CustomPortalBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomPortalBlock.class)
public abstract class CustomPortalBlockMixin {
	@Inject(method = "entityInside", at = @At(value = "HEAD"))
	public void customPortalBlock$entityInside(BlockState state, Level world, BlockPos pos, Entity entity, CallbackInfo ci) {
		if (entity.isVehicle() || entity.isPassenger()) ci.cancel();
	}
}
