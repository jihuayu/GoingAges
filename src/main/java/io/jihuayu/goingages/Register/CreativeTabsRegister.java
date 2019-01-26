package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.creativetab.TabMisc;
import io.jihuayu.goingages.creativetab.TabTool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsRegister {
    public static final CreativeTabs tool = new TabTool();
    public static final CreativeTabs misc = new TabMisc();

}
