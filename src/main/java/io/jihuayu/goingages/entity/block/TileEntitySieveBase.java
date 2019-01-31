package io.jihuayu.goingages.entity.block;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.recipe.SieveRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ITickable;

import java.util.Map;

public class TileEntitySieveBase extends TileEntity implements ITickable {
    private TileEntityChest workChest;
    public static final int USETIME = 100;
    private int leftTime = 0;
    private int smallTime = 0;
    static {
        SieveRecipe.addRecipe(Items.STICK,1.0f);
    }
    @Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        return compound;
    }

    @Override
    public void update() {

        if (!this.getWorld().isRemote&& workChest!=null&&leftTime!=0){
            GoingAges.logger.error(leftTime);
            smallTime++;
            if(smallTime>=60){
                smallTime-=60;
                leftTime--;
                float num = (float) Math.random();
                Map<Item,Float> recipe= SieveRecipe.getRecipe();
                for(Item i :recipe.keySet()){
                    if(num<=recipe.get(i)){
                        for(int j =0;j<workChest.getSizeInventory();j++){
                            if(workChest.getStackInSlot(j).getItem().equals(i)){
                                workChest.setInventorySlotContents(j,new ItemStack(i,workChest.getStackInSlot(j).getCount()+1));
                                break;
                            }
                            else if(workChest.getStackInSlot(j).getItem().equals(Items.AIR)){
                                workChest.setInventorySlotContents(j,new ItemStack(i,1));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void setCheat(TileEntityChest entityChest){
        GoingAges.logger.error(leftTime);
        this.workChest = entityChest;
    }
    public boolean reSet(){
        GoingAges.logger.error(leftTime);
        if(leftTime != 0)return false;
        else leftTime = USETIME;
        return true;
    }
}
