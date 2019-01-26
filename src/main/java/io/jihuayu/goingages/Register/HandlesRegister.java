package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.api.GAOreGenHandle;
import io.jihuayu.goingages.event.EventHandle.HandleKnife;
import io.jihuayu.goingages.event.EventHandle.HandleMob;
import io.jihuayu.goingages.event.OreGenHandle.HandleOreGen;
import io.jihuayu.goingages.event.EventHandle.HandlePlayer;

public class HandlesRegister {
    public static final GAEventHandle items_register = new ItemsRegister();


    public static final GAEventHandle handle_knife = new HandleKnife();
    public static final GAEventHandle handle_player = new HandlePlayer();
    public static final GAEventHandle handle_Mob = new HandleMob();


    public static final GAOreGenHandle handle_ore_gen = new HandleOreGen();

}
