package io.jihuayu.goingages.block;

import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.api.GABlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorshipTable extends GABlock {
    public WorshipTable() {
        super(Material.WOOD, "worship_table");
    }
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(playerIn.getHeldItem(hand).getItem().equals(ItemsRegister.incense)){
            this.actived(worldIn,pos,state,playerIn,hand,facing,hitX,hitY,hitZ);
            return true;
        }
        return false;
    }
    public void actived(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

    }
}
