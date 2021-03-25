package fr.luki.immersivecooking.init;

import fr.luki.immersivecooking.immcook;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static void registerAll(){
        //Items
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "knife"), KNIFE);
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "knife_tall"), KNIFE_TALL);

        //Block items
        Registry.register(Registry.ITEM, new Identifier(immcook.MODID, "cutting_board"), CUTTING_BOARD);
    }

    //Items
    public static final Item KNIFE = new Item(new Item.Settings().group(immcook.ITEM_GROUP));
    public static final Item KNIFE_TALL = new Item(new Item.Settings().group(immcook.ITEM_GROUP));

    //Block items
    public static final BlockItem CUTTING_BOARD = new BlockItem(ModBlocks.CUTTING_BOARD, new Item.Settings().group(immcook.ITEM_GROUP));
}
