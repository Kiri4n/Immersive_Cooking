package fr.luki.immersivecooking.init.modBlockEntitys;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import static fr.luki.immersivecooking.init.modBlocks.BasicBlocks.MIXING_BOWL;

public class BE_Registry {
    public static BlockEntityType<Mixing_bowl_BE> MIXING_BOWL_BE;

    public static void registerAll(){
        MIXING_BOWL_BE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "immcook:mixing_bowl", BlockEntityType.Builder.create(Mixing_bowl_BE::new, MIXING_BOWL).build(null));
    }
}
