package io.jihuayu.goingages.entity.block;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.api.GATickTileEntity;
import io.jihuayu.goingages.recipe.SieveRecipe;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class TileEntitySieveBase extends GATickTileEntity {
    private BlockPos workChest = null;
    private static final String LEFTTIME = "lefttime";
    private static final int USETIME = 100;
    private int leftTime = 0;
    private int smallTime = 0;

    static {
        SieveRecipe.addRecipe(Items.STICK,1.0f);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        GoingAges.logger.error(compound.getInteger(LEFTTIME));
        leftTime = compound.getInteger(LEFTTIME);
        int x = compound.getInteger("x1");
        int y = compound.getInteger("y1");
        int z = compound.getInteger("z1");
        if(y<0){
            workChest = null;
        }
        else{
            workChest = new BlockPos(x,y,z);
        }
        GoingAges.logger.error(workChest);
        GoingAges.logger.error(leftTime);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setInteger(LEFTTIME,leftTime);
        if(workChest==null){
            compound.setInteger("x1",0);
            compound.setInteger("y1",-1);
            compound.setInteger("z1",0);
        }
        else{
            BlockPos pos = workChest;
            compound.setInteger("x1",pos.getX());
            compound.setInteger("y1",pos.getY());
            compound.setInteger("z1",pos.getZ());
        }
        GoingAges.logger.error(workChest);
        GoingAges.logger.error(compound.getInteger(LEFTTIME));
        return compound;
    }

    @Override
    public void update() {
        if (!this.getWorld().isRemote && workChest!=null && leftTime>0){
            GoingAges.logger.error(leftTime);
            smallTime++;
            if(smallTime>=60){
                smallTime-=60;
                leftTime--;
                markDirty();
                float num = (float) Math.random();
                Map<Item,Float> recipe= SieveRecipe.getRecipe();
                TileEntityChest chest = (TileEntityChest)this.getWorld().getTileEntity(workChest);
                if(chest==null) {
                    workChest = null;
                    return;
                }
                for(Item i :recipe.keySet()){
                    if(num<=recipe.get(i)){
                        for(int j =0;j<chest.getSizeInventory();j++){
                            if(chest.getStackInSlot(j).getItem().equals(i)){
                                chest.setInventorySlotContents(j,new ItemStack(i,chest.getStackInSlot(j).getCount()+1));
                                break;
                            }
                            else if(chest.getStackInSlot(j).getItem().equals(Items.AIR)){
                                chest.setInventorySlotContents(j,new ItemStack(i,1));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    public void setCheat(BlockPos entityChest){
        this.workChest = entityChest;
    }

    public boolean reSet(){
        if(leftTime != 0)return false;
        else leftTime = USETIME;
        return true;
    }


}
