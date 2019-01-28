package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Manager.ManagerTimeUser;
import io.jihuayu.goingages.Manager.ManagerDate;
import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.api.TimeUserObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import static net.minecraftforge.common.DimensionManager.getWorld;

public class HandleTick extends GAEventHandle {
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent e){
        if(e.side.equals(Side.SERVER)&&e.phase.equals(TickEvent.ServerTickEvent.Phase.END))
            ManagerDate.onTick();
    }
    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent e){
        World world = e.world;
        if(e.side.equals(Side.SERVER)&&e.phase.equals(TickEvent.ServerTickEvent.Phase.END)&&world.equals(getWorld(0))) {
            TimeUserObject object = ManagerTimeUser.getNearObject();
            if(object == null||ManagerDate.date==null)return;
            while (object.getOvertime() <= ManagerDate.date.getTime()){
                if (world.getBlockState(object.getPos()).getBlock().equals(object.getBlock())){
                    world.setBlockToAir(object.getPos());
                }
                ManagerTimeUser.removeNearObject();
                object = ManagerTimeUser.getNearObject();
                if(object==null)break;
            }
        }
    }
}
