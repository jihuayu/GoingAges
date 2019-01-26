package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.api.GAEventHandle;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleKnife extends GAEventHandle
{
    @SubscribeEvent
    public void KnifeUse(BlockEvent.HarvestDropsEvent e){
        if(e==null||e.getHarvester()==null||!e.getHarvester().getHeldItem(EnumHand.MAIN_HAND).getItem().equals(ItemsRegister.knife_diamond))return;
        Block block = e.getState().getBlock();
        if(block.equals(Blocks.LEAVES)||block.equals(Blocks.LEAVES2)){
            e.setDropChance(0.5f);
            e.getDrops().clear();
            int num = e.getFortuneLevel()+1;
            e.getDrops().add(new ItemStack(Items.STICK,num));
        }
        else if(block.equals(Blocks.TALLGRASS)||block.equals(Blocks.DOUBLE_PLANT)){
            e.setDropChance(0.9f);
            e.getDrops().clear();
            int num = e.getFortuneLevel()+1;
            e.getDrops().add(new ItemStack(ItemsRegister.grass_fiber,num));
        }
    }
}
