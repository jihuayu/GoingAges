package io.jihuayu.goingages.api;

import io.jihuayu.goingages.GoingAges;
import net.minecraft.item.Item;

public class GAItem extends Item
{
    public GAItem(String name){
        this.setName(name);
    }
    public GAItem(){

    }
    public Item setName(String name){
        this.setRegistryName(name);
        this.setUnlocalizedName(GoingAges.MODID + "." + name);
        return this;
    }
}
