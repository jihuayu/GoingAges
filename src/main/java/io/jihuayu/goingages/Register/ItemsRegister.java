package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.item.*;
import io.jihuayu.goingages.item.tool.*;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class ItemsRegister extends GAEventHandle {
    public static final Item knife_diamond =  new Knife(Item.ToolMaterial.DIAMOND);
    public static final Item grass_fiber = new GrassFiber();
    public static final Item soul_fire = new SoulFire();
    public static final Item sharp_stick = new SharpStick();
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
//        ((ForgeRegistry<Item>)event.getRegistry()).remove(Items.COAL.getRegistryName());
        event.getRegistry().registerAll(
                knife_diamond,grass_fiber,soul_fire,sharp_stick
        );
    }
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        //((ForgeRegistry<IRecipe>)event.getRegistry()).clear();

    }
}
