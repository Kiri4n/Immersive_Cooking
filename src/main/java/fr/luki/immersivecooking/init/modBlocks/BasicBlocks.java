package fr.luki.immersivecooking.init.modBlocks;

import fr.luki.immersivecooking.immcook;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BasicBlocks {

    public static final Cutting_board CUTTING_BOARD = new Cutting_board();
    public static final Mixing_bowl MIXING_BOWL = new Mixing_bowl();
    public static final Identifier MIXING_BOWL_ID = new Identifier(immcook.MODID,"mixing_bowl");

    public static void registerAll(){
        Registry.register(Registry.BLOCK, new Identifier(immcook.MODID, "cutting_board"), CUTTING_BOARD);
        Registry.register(Registry.BLOCK, MIXING_BOWL_ID, MIXING_BOWL);
    }
}
