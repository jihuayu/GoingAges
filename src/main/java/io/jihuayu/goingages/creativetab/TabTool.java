package io.jihuayu.goingages.creativetab;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.ItemsRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabTool extends CreativeTabs
{
    public TabTool() {
        super(GoingAges.MODID+":"+"tool");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemsRegister.knife_diamond);
    }
}
