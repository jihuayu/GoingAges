package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Manager.ManagerTimeUser;
import io.jihuayu.goingages.Manager.ManagerDate;
import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.api.ITimeUser;
import io.jihuayu.goingages.api.TimeUserObject;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleTimeUser extends GAEventHandle {
    @SubscribeEvent
    public void set(BlockEvent.PlaceEvent e){
        Block block = e.getPlacedBlock().getBlock();
        if(!(block instanceof ITimeUser)) return;
        BlockPos pos = e.getPos();
        Long time = ManagerDate.date.getTime()+((ITimeUser) block).getUseTime();
        ManagerTimeUser.addObject(new TimeUserObject(block,pos,time));
    }
    @SubscribeEvent
    public void take(BlockEvent.BreakEvent e){
        GoingAges.logger.info("111111111111111111");
        BlockPos pos = e.getPos();
        Block block = e.getState().getBlock();
        if(block instanceof ITimeUser)
            ManagerTimeUser.removeObject(pos);
    }
}
