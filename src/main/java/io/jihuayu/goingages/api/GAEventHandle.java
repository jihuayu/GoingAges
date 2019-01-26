package io.jihuayu.goingages.api;

import io.jihuayu.goingages.GoingAges;
import net.minecraftforge.common.MinecraftForge;

public class GAEventHandle {
    protected GAEventHandle(){
        MinecraftForge.EVENT_BUS.register(this);
    }
}
