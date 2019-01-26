package io.jihuayu.goingages.api;

import io.jihuayu.goingages.GoingAges;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.storage.WorldSavedData;

public class GADate  extends WorldSavedData {
    public static GADate date = new GADate();
    private static int time = 0;
    private static int tick = 0;
    public GADate() {
        super(GoingAges.MODID+"_date");
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        time =  nbt.getInteger("time");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("time",time);
        return compound;
    }

    public static void onTick(){
        tick++;
        if(tick>=20){
            tick-=20;
            time++;
            GoingAges.logger.info(time);
        }

    }
}
