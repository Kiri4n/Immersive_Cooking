package fr.luki.immersivecooking.init;

import fr.luki.immersivecooking.immcook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item testItem = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Item knife = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static void registerAll(){
        Registry.register(Registry.ITEM,new Identifier(immcook.MODID, "knife"), knife);
    }
}
