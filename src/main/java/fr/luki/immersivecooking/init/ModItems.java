package fr.luki.immersivecooking.init;

import fr.luki.immersivecooking.immcook;
import fr.luki.immersivecooking.init.modBlocks.BasicBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Items
    public static final Item KNIFE = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item KNIFE_TALL = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item JUG_OF_WATER = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item JUG_OF_MILK = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item WHEAT_FLOUR = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item SALT = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item DOUGH = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item WHISK = new Item(new Item.Settings().maxCount(1).group(immcook.ITEM_GROUP));

    //Block items
    public static final BlockItem CUTTING_BOARD = new BlockItem(BasicBlocks.CUTTING_BOARD, new Item.Settings().group(immcook.ITEM_GROUP));
    public static final BlockItem MIXING_BOWL = new BlockItem(BasicBlocks.MIXING_BOWL, new Item.Settings().group(immcook.ITEM_GROUP));

    public static void registerAll(){
        //Items
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "knife"), KNIFE);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "knife_tall"), KNIFE_TALL);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "jug_of_water"), JUG_OF_WATER);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "jug_of_milk"), JUG_OF_MILK);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "wheat_flour"), WHEAT_FLOUR);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "salt"), SALT);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "dough"), DOUGH);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "whisk"), WHISK);

        //Block items
        Registry.register(Registry.ITEM, new Identifier(immcook.MODID, "cutting_board"), CUTTING_BOARD);
        Registry.register(Registry.ITEM, new Identifier(immcook.MODID, "mixing_bowl"), MIXING_BOWL);
    }
}