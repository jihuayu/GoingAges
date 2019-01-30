package io.jihuayu.goingages.event.EventHandle;

import io.jihuayu.goingages.api.GAEventHandle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandleMob extends GAEventHandle
{
    /**
     * 怪物被烧死后掉落灵魂火
     * @param e 生物掉落事件
     */
    @SubscribeEvent(priority = EventPriority.LOW)
    public void modDie(LivingDropsEvent e){
        if(!(e.getEntityLiving() instanceof EntityMob))return;
        DamageSource damageSource = e.getSource();
        if(DamageSource.ON_FIRE.equals(damageSource)){
            e.getDrops().clear();
            BlockPos pos =  e.getEntityLiving().getPosition();
            e.getDrops().add(new EntityItem(e.getEntityLiving().getEntityWorld(),pos.getX(),pos.getY(),pos.getZ(),new ItemStack(Blocks.STONE)));
        }
    }
}
