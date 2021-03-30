package fr.luki.immersivecooking.init.modBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Cutting_board extends HorizontalFacingBlock {
    public Cutting_board() {
        super(FabricBlockSettings
                .of(Material.WOOD)
                .breakByTool(FabricToolTags.AXES)
                .strength(0.75f, 2f)
                .sounds(BlockSoundGroup.WOOD));
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
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
}
