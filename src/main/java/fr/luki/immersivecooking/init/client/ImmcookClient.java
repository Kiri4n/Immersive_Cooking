package fr.luki.immersivecooking.init.client;

import fr.luki.immersivecooking.immcook;
import fr.luki.immersivecooking.init.client.screen.Mixing_bowl_Screen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ImmcookClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(immcook.MIXING_BOWL_SH, Mixing_bowl_Screen::new);
    }
}
