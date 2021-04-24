package fr.luki.immersivecooking.init.modBlocks;

import fr.luki.immersivecooking.init.modBlockEntitys.Mixing_bowl_BE;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Mixing_bowl extends BlockWithEntity{
    public Mixing_bowl() {
        super(FabricBlockSettings
                .of(Material.METAL)
                .strength(0f, 4.25f)
                .sounds(BlockSoundGroup.METAL));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new Mixing_bowl_BE();
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        //With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (!world.isClient) {
            /*Mixing_bowl_BE BE = (Mixing_bowl_BE) world.getBlockEntity(pos);
            BE.setNb_click(BE.getNb_click()+1);
            System.out.println("Nombre de click: "+BE.getNb_click());*/
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        System.out.println("onStateReplaced test");
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Mixing_bowl_BE) {
                ItemScatterer.spawn(world, pos, (Inventory) blockEntity);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
