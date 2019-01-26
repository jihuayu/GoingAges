package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.api.GADate;
import io.jihuayu.goingages.api.GAEventHandle;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class HandleTick extends GAEventHandle {
    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent e){
        if(e.side.equals(Side.SERVER)&&e.phase.equals(TickEvent.ServerTickEvent.Phase.END))
            GADate.onTick();
    }
}
