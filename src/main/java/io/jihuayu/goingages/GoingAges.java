package io.jihuayu.goingages;

import io.jihuayu.goingages.api.GAAuth;
import io.jihuayu.goingages.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;


@Mod(modid = GoingAges.MODID, name = GoingAges.NAME, version = GoingAges.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class GoingAges
{
    public static final String MODID = "goingages";
    public static final String NAME = "Going Ages";
    public static final String VERSION = "0.1.0";

    @Mod.Instance(GoingAges.MODID)
    public static GoingAges instance;

    public static Logger logger;
    @SidedProxy(clientSide = "io.jihuayu.goingages.proxy.ClientProxy",
            serverSide = "io.jihuayu.goingages.proxy.CommonProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        try {
            GAAuth.login("","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        proxy.preInit(event);

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
