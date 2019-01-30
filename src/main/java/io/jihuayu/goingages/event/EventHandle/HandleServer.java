package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.ManagerRegister;
import io.jihuayu.goingages.api.GAEventHandle;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.minecraftforge.common.DimensionManager.getWorld;

public class HandleServer extends GAEventHandle {
    /**、
     * 关闭记录功能
     * @param e
     */
    @SubscribeEvent
    public void serverClosed(WorldEvent.Unload e){
        if(e.getWorld().equals(getWorld(0))){
            ManagerRegister.closed();
        }
    }
}
