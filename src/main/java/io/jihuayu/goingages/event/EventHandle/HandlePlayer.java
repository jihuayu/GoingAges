package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.api.GAEventHandle;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandlePlayer extends GAEventHandle
{

    /**
     * 空手破坏树叶草
     * @param e
     */
    @SubscribeEvent
    public void breakLeaves(BlockEvent.HarvestDropsEvent e){
        if(e==null||e.getHarvester()==null||!e.getHarvester().getHeldItem(EnumHand.MAIN_HAND).equals(ItemStack.EMPTY))return;
        Block block = e.getState().getBlock();
        if(block.equals(Blocks.LEAVES)||block.equals(Blocks.LEAVES2)){
            e.setDropChance(0.2f);
            e.getDrops().clear();
            e.getDrops().add(new ItemStack(Items.STICK));
        }
        else if(block.equals(Blocks.TALLGRASS)||block.equals(Blocks.DOUBLE_PLANT)){
            e.setDropChance(0.4f);
            e.getDrops().clear();
            e.getDrops().add(new ItemStack(ItemsRegister.grass_fiber));
        }
    }

    /**
     * 不能破坏其他方块，除非用对应道具
     * @param e
     */
    @SubscribeEvent
    public void breakStop(PlayerEvent.BreakSpeed e){
        Block block = e.getState().getBlock();
        if(block.equals(Blocks.LEAVES)||block.equals(Blocks.LEAVES2)||block.equals(Blocks.TALLGRASS)||block.equals(Blocks.DOUBLE_PLANT))return;
        ItemStack handItem = e.getEntityPlayer().getHeldItem(EnumHand.MAIN_HAND);
        if(e.getEntityPlayer()==null||handItem.getItem() instanceof ItemTool&&((ItemTool)handItem.getItem()).getDestroySpeed(handItem,e.getState())!=1.0f)return;
        e.setNewSpeed(0.0f);
    }

}
