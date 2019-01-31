package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.api.GAOreGenHandle;
import io.jihuayu.goingages.event.EventHandle.*;
import io.jihuayu.goingages.event.OreGenHandle.*;
public class HandlesRegister {
    public static final GAEventHandle items_register = new ItemsRegister();
    public static final GAEventHandle blocks_register = new BlocksRegister();

    public static final GAEventHandle handle_knife = new HandleKnife();
    public static final GAEventHandle handle_player = new HandlePlayer();
    public static final GAEventHandle handle_mob = new HandleMob();
    public static final GAEventHandle handle_knock = new HandleKnock();
//    public static final GAOreGenHandle handle_ore_gen = new HandleOreGen();

}
