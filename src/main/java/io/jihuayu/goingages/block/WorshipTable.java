package io.jihuayu.goingages.block;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.api.GABlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorshipTable extends GABlock {
    private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
    public WorshipTable() {
        super(Material.WOOD, "worship_table");
    }
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote) return true;
        if(playerIn.getHeldItem(hand).getItem().equals(ItemsRegister.incense)){
            this.activated(worldIn,pos,state,playerIn,hand,facing,hitX,hitY,hitZ);
            worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.PLAYERS, 0.7F, 1.0f);
            return true;
        }
        return false;
    }
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public void activated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){

        if(worldIn.getBlockState(pos.add(0,0,-1)).getBlock().equals(Blocks.CHEST)){
            TileEntity tileEntity = worldIn.getTileEntity(pos.add(0,0,-1));
            if(tileEntity instanceof TileEntityChest){
                Map<Item,Integer> items = new HashMap<>();
                Set<Integer> airs = new HashSet<>();
                TileEntityChest chest = (TileEntityChest)tileEntity;
                for(int i =0 ;i<chest.getSizeInventory();i++){
                    ItemStack in = chest.getStackInSlot(i);
                    if(!in.getItem().equals(Items.AIR)){

                        if(items.containsKey(in.getItem()))
                            items.put(in.getItem(),in.getCount()+items.get(in.getItem()));
                        else
                            items.put(in.getItem(),in.getCount());
                    }
                    else{
                        airs.add(i);
                    }
                }
                if(airs.isEmpty())return;
                for(Item i :items.keySet()){
                    if(i.equals(Items.STICK)){
                        int count = items.get(i)/4*4;
                        if(count==0)break;
                        for(int j =0 ;j<chest.getSizeInventory();j++){
                            ItemStack in = chest.getStackInSlot(j);
                            if(!in.getItem().equals(Items.STICK))continue;
                            if(in.getCount()>count){
                                chest.decrStackSize(j,count);
                                break;
                            }
                            else{
                                count-=in.getCount();
                                chest.removeStackFromSlot(j);
                                airs.add(j);
                            }
                        }
                        count = items.get(i)/4;
                        for(int j :airs){
                            if(count>64){
                                chest.setInventorySlotContents(j,new ItemStack(Blocks.LOG,64));
                                count-=64;
                            }
                            else{
                                chest.setInventorySlotContents(j,new ItemStack(Blocks.LOG,count));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
