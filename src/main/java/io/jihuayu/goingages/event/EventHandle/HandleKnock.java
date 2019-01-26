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
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;

public class HandleKnock extends GAEventHandle {
    @SubscribeEvent
    public void KnockStick(PlayerInteractEvent e){
        if(!e.getItemStack().getItem().equals(Items.STICK))return;
        World world = e.getWorld();
        BlockPos pos =e.getPos();
        if(world.getBlockState(pos).getBlock().equals(Blocks.STONE)){
          knockStickDo(e,2);
        }
        else if(world.getBlockState(pos).getBlock().equals(Blocks.LOG2)||world.getBlockState(pos).getBlock().equals(Blocks.LOG)){
            knockStickDo(e,1);
        }
    }
    private void knockStickDo(PlayerInteractEvent e, int num){
        World world = e.getWorld();
        BlockPos pos2 = e.getEntityPlayer().getPosition();
        if(Math.random()<0.4)return;
        e.getItemStack().shrink(1);
        if(Math.random()<0.5)return;
        if(e.getSide().equals(Side.SERVER))
            world.spawnEntity(new EntityItem(world,pos2.getX(),pos2.getY(),pos2.getZ(),new ItemStack(ItemsRegister.sharp_stick,2)));
    }
}
