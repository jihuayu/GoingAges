package io.jihuayu.goingages.api;

import net.minecraftforge.common.MinecraftForge;

public class GAOreGenHandle {
    protected GAOreGenHandle(){
        MinecraftForge.ORE_GEN_BUS.register(this);
    }
}
