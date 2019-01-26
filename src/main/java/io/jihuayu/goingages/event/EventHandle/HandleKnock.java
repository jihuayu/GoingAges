package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.api.GAEventHandle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleKnock extends GAEventHandle {
    @SubscribeEvent
    public void KnockStick(PlayerInteractEvent e){
        if(!e.getItemStack().getItem().equals(Items.STICK))return;
        World world = e.getWorld();
        BlockPos pos =e.getPos();
        if(world.getBlockState(pos).getBlock().equals(Blocks.STONE)){
            e.getItemStack().shrink(1);
            world.spawnEntity(new EntityItem(world,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(ItemsRegister.sharp_stick,2)));
        }
        else if(world.getBlockState(pos).getBlock().equals(Blocks.LOG2)||world.getBlockState(pos).getBlock().equals(Blocks.LOG)){
            e.getItemStack().shrink(1);
            world.spawnEntity(new EntityItem(world,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(ItemsRegister.sharp_stick,1)));
        }
    }
}
