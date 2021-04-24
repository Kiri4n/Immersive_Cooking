package fr.luki.immersivecooking.init.modBlockEntitys;

import fr.luki.immersivecooking.init.screenHandler.Mixing_bowl_SH;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static fr.luki.immersivecooking.init.modBlockEntitys.BE_Registry.MIXING_BOWL_BE;

public class Mixing_bowl_BE extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{
    //private int nb_click =0;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public Mixing_bowl_BE() {
        super(MIXING_BOWL_BE);
    }

    /*public int getNb_click() {
        return nb_click;
    }*/

    /*public void setNb_click(int nb_click) {
        this.nb_click = nb_click;
    }*/

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        //nb_click = tag.getInt("nb_click");
        Inventories.fromTag(tag, this.inventory);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        //tag.putInt("nb_click", nb_click);
        Inventories.toTag(tag, this.inventory);
        return tag;
    }

    //---------- Inventory ----------
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new Mixing_bowl_SH(syncId, inv, this);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }
}
