package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.block.TorchSimple;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class BlocksRegister extends GAEventHandle {
    public static Block torch_simple = new TorchSimple();
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                torch_simple
        );
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        registerAll( event,
                torch_simple
        );
    }

    private static void registerAll(RegistryEvent.Register<Item> event,Block... values){
        for (Block i :values){
            event.getRegistry().register(new ItemBlock(i).setRegistryName(i.getRegistryName()));
        }
    }
}
