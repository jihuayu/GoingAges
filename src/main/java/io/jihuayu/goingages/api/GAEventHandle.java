package io.jihuayu.goingages.api;

import net.minecraftforge.common.MinecraftForge;

public class GAEventHandle {
    protected GAEventHandle(){

        MinecraftForge.EVENT_BUS.register(this);
    }
}
