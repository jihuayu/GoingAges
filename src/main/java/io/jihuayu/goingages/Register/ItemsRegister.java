package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.api.GAEventHandle;
import io.jihuayu.goingages.item.*;
import io.jihuayu.goingages.item.tool.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ItemsRegister extends GAEventHandle {
    public static final Item wood_knife =  new WoodKnife();
    public static final Item grass_fiber = new GrassFiber();
    public static final Item soul_fire = new SoulFire();
    public static final Item sharp_stick = new SharpStick();
    public static final Item  incense = new Incense();
    public static final Item grass_rope  =new GrassRope();
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        registerAll(event,
                wood_knife,grass_fiber,soul_fire,sharp_stick,incense,grass_rope
        );
    }
    private static void registerAll(RegistryEvent.Register<Item> event,Item... values){
        for (Item i :values){
            event.getRegistry().register(i);
            registerRender(i);
        }
    }
    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        //((ForgeRegistry<IRecipe>)event.getRegistry()).clear();

    }

}
