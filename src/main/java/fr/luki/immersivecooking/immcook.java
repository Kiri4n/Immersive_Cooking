package fr.luki.immersivecooking;

import fr.luki.immersivecooking.init.modBlocks.BasicBlocks;
import fr.luki.immersivecooking.init.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class immcook implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "immcook";
    public static final String MODNAME = "Immersive Cooking";


    //ItemGroup
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "immcooktab"),() -> new ItemStack(ModItems.KNIFE_TALL));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        ModItems.registerAll();
        BasicBlocks.registerAll();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MODNAME+"] " + message);
    }

}