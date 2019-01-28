package io.jihuayu.goingages.Manager;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.api.TimeUserObject;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldSavedData;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

import static net.minecraftforge.common.DimensionManager.getWorld;

public class ManagerTimeUser  extends WorldSavedData {
    public static ManagerTimeUser manager;
    private Queue<TimeUserObject> timeUser = new PriorityQueue<>(
            (i1, i2) -> (int) (i1.getOvertime() - i2.getOvertime()));
    public ManagerTimeUser(String name) {
        super(name);
    }

    public static TimeUserObject getNearObject() {
        if(manager==null)
            manager = get();
        return manager.timeUser.peek();
    }
    public static void removeNearObject(){
        if(manager==null)
            manager = get();
        manager.timeUser.poll();
    }
    public static void addObject(TimeUserObject o){
        if(manager==null)
            manager = get();
        manager.timeUser.add(o);
    }
    public static void removeObject(BlockPos pos){
        if(manager==null)
            manager = get();
        for(TimeUserObject i :manager.timeUser) {
            if(i.getPos().equals(pos)){
                manager.timeUser.remove(i);
            }
        }
    }
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagCompound o = nbt.getCompoundTag("0");
        for(String i : o.getKeySet()){
            NBTTagCompound obj = o.getCompoundTag(i);
            long time = obj.getLong("time");
            BlockPos pos = new BlockPos(obj.getInteger("x"),obj.getInteger("y"),obj.getInteger("z"));
            Block block = Block.REGISTRY.getObject(new ResourceLocation(obj.getString("name")));
            timeUser.add(new TimeUserObject(block,pos,time));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        int j =0;
        NBTTagCompound o = new NBTTagCompound();
        for(TimeUserObject i : timeUser){
            NBTTagCompound obj = new NBTTagCompound();
            obj.setLong("time",i.getOvertime());
            obj.setInteger("x",i.getPos().getX());
            obj.setInteger("y",i.getPos().getY());
            obj.setInteger("z",i.getPos().getZ());
            obj.setString("name",i.getBlock().getRegistryName().getResourceDomain()+":"+i.getBlock().getRegistryName().getResourcePath());
            o.setTag(String.valueOf(j),obj);
            j++;
        }
        compound.setTag("0",o);
        return compound;
    }
    private static ManagerTimeUser get()
    {
        World world = getWorld(0);
        WorldSavedData data = world.getPerWorldStorage().getOrLoadData(ManagerTimeUser.class, GoingAges.MODID+"_time_user");
        if (data == null)
        {
            data = new ManagerTimeUser(GoingAges.MODID+"_time_user");
            world.getPerWorldStorage().setData(GoingAges.MODID+"_time_user", data);
        }
        return (ManagerTimeUser) data;
    }
    public boolean isDirty()
    {
        return true;
    }
}
