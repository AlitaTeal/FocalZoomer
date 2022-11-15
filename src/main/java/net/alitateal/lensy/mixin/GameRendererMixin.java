package net.alitateal.lensy.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
    private void modifyFovWithZoom(CallbackInfoReturnable cir) {
        double currentAspectRatio = calculateAspectRatio(MinecraftClient.getInstance().getWindow().getWidth(),MinecraftClient.getInstance().getWindow().getHeight());
        double newFov = calculateFovFromFocalLength(16, currentAspectRatio);
        cir.setReturnValue(newFov);
    }

    private double calculateFovFromFocalLength(int focalLength, double aspectRatio) {
        double calculatedFov = 2.0*Math.atan((36.0*aspectRatio)/(2.0*(double)focalLength)) * (180.0/Math.PI);
        return calculatedFov;
    }

    private double calculateAspectRatio(int width, int height) {
        return (double)Math.min(width,height)/(double)Math.max(width,height);
    }
}
