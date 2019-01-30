package io.jihuayu.goingages.event.OreGenHandle;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.api.GAOreGenHandle;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleOreGen extends GAOreGenHandle {
    /**
     * 禁止所有矿物生成
     * @param e
     */
    @SubscribeEvent
    public void stopOreGen(OreGenEvent.GenerateMinable  e){
        e.setResult(Event.Result.DENY);
    }
}
