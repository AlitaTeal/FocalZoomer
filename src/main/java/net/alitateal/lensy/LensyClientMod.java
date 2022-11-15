package net.alitateal.lensy;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class LensyClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //Register Keybinds
        String lensyCategory = "key.lensy.category";
        KeyBindingHelper.registerKeyBinding(new KeyBinding("key.lensy.activate", GLFW.GLFW_KEY_C, lensyCategory));
        KeyBindingHelper.registerKeyBinding(new KeyBinding("key.lensy.increase_focal_length", GLFW.GLFW_KEY_EQUAL, lensyCategory));
        KeyBindingHelper.registerKeyBinding(new KeyBinding("key.lensy.decrease_focal_length", GLFW.GLFW_KEY_MINUS, lensyCategory));
    }
}
