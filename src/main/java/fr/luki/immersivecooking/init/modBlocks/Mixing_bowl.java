package fr.luki.immersivecooking.init.modBlocks;

import fr.luki.immersivecooking.init.modBlockEntitys.Mixing_bowl_BE;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Mixing_bowl extends HorizontalFacingBlock implements BlockEntityProvider{
    public Mixing_bowl() {
        super(FabricBlockSettings
                .of(Material.METAL)
                .strength(0f, 4.25f)
                .sounds(BlockSoundGroup.METAL));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (!world.isClient) {
            Mixing_bowl_BE BE = (Mixing_bowl_BE) world.getBlockEntity(pos);
            BE.setNb_click(BE.getNb_click()+1);
            System.out.println("Nombre de click: "+BE.getNb_click());
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return VoxelShapes.cuboid(0.125f, 0f, 0f, 0.8125f, 0.125f, 1f);
            case SOUTH:
                return VoxelShapes.cuboid(0.1875f, 0f, 0f, 0.875f, 0.125f, 1f);
            case EAST:
                return VoxelShapes.cuboid(0f, 0f, 0.125f, 1f, 0.125f, 0.8125f);
            case WEST:
                return VoxelShapes.cuboid(0f, 0f, 0.1875f, 1f, 0.125f, 0.875f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new Mixing_bowl_BE();
    }
}
