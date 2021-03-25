package fr.luki.immersivecooking.init;

import fr.luki.immersivecooking.immcook;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CUTTING_BOARD = new Block(FabricBlockSettings
            .of(Material.WOOD)
            .breakByTool(FabricToolTags.AXES)
            .strength(0.75f, 2f)
            .sounds(BlockSoundGroup.WOOD));

    public static void registerAll(){
        Registry.register(Registry.BLOCK, new Identifier(immcook.MODID, "cutting_board"), CUTTING_BOARD);
    }
}
