package io.jihuayu.goingages.item;

import io.jihuayu.goingages.Register.CreativeTabsRegister;
import io.jihuayu.goingages.api.GAItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Incense extends GAItem {
    public Incense(){
        super("incense");
        this.setCreativeTab(CreativeTabsRegister.misc);
    }
}
