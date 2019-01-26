package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.item.GrassFiber;
import io.jihuayu.goingages.item.tool.Knife;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemsRegister {
    public static final Item knife_diamond =  new Knife(Item.ToolMaterial.DIAMOND);
    public static final Item grass_fiber = new GrassFiber();
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                knife_diamond,grass_fiber
        );
    }

}
