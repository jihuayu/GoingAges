package io.jihuayu.goingages.mixin.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ItemSpade.class)
public class NewSpade {


    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        return 1.0F;
    }

}
