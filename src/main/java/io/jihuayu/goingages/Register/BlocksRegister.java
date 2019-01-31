package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.block.WorshipTable;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class BlocksRegister extends GAEventHandle {
    public static Block worship_table = new WorshipTable();
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                worship_table
        );
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        registerAll( event,
                worship_table
        );
    }

    private static void registerAll(RegistryEvent.Register<Item> event,Block... values){
        for (Block i :values){
            event.getRegistry().register(new ItemBlock(i).setRegistryName(i.getRegistryName()));
            registerRender(i);
        }
    }
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block)
    {
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
    }
}
