package io.jihuayu.goingages.proxy;


import io.jihuayu.goingages.Register.BlocksRegister;
import io.jihuayu.goingages.Register.CreativeTabsRegister;
import io.jihuayu.goingages.Register.HandlesRegister;
import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.event.EventHandle.HandleKnife;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        new HandlesRegister();
        new CreativeTabsRegister();
        new ItemsRegister();
        new BlocksRegister();
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}