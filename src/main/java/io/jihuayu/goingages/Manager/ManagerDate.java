package io.jihuayu.goingages.Manager;

import io.jihuayu.goingages.GoingAges;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;

import java.util.Objects;

import static net.minecraftforge.common.DimensionManager.getWorld;

public class ManagerDate extends WorldSavedData {
    public static ManagerDate date;
    private long time = 0;
    private int tick = 0;
    public ManagerDate(String name)
    {
        super(name);
    }
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        time =  nbt.getInteger("time");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setLong("time",time);
        return compound;
    }

    public static void onTick(){
        if(date==null)
            date = ManagerDate.get();
        date.tick++;
        if(date.tick>=20){
            date.tick-=20;
            date.time++;
        }
    }
    public long getTime(){
        return time;
    }
    public static ManagerDate get()
    {
        World world = getWorld(0);
        WorldSavedData data = world.getMapStorage().getOrLoadData(ManagerDate.class, GoingAges.MODID+"_date");
        if (data == null)
        {
            data = new ManagerDate(GoingAges.MODID+"_date");

            world.getMapStorage().setData(GoingAges.MODID+"_date", data);
        }
        return (ManagerDate) data;
    }
    public boolean isDirty()
    {
        return true;
    }
}
