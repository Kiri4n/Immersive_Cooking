package fr.luki.immersivecooking;

import fr.luki.immersivecooking.init.ModItems;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class immcook implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "immcook";
    public static final String MODNAME = "Immersive Cooking";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        ModItems.registerAll();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MODNAME+"] " + message);
    }

}