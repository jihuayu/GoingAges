package io.jihuayu.goingages.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ISacrificeMain {
    default boolean check(EntityPlayer player, World worldIn, BlockPos pos){
        return true;
    }
}
