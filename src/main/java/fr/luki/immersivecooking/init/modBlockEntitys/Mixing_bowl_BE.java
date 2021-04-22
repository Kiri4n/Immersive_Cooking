package fr.luki.immersivecooking.init.modBlockEntitys;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static fr.luki.immersivecooking.init.modBlockEntitys.BE_Registry.MIXING_BOWL_BE;

public class Mixing_bowl_BE extends BlockEntity {
    private int nb_click =0;

    public Mixing_bowl_BE() {
        super(MIXING_BOWL_BE);
    }

    public int getNb_click() {
        return nb_click;
    }

    public void setNb_click(int nb_click) {
        this.nb_click = nb_click;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        tag.putInt("nb_click", nb_click);

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        nb_click = tag.getInt("nb_click");
    }
}
