package io.jihuayu.goingages.creativetab;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.ItemsRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMisc extends CreativeTabs
{
    public TabMisc() {
        super(GoingAges.MODID+":"+"misc");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemsRegister.grass_fiber);
    }
}
