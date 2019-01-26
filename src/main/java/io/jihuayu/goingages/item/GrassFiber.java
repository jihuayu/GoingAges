package io.jihuayu.goingages.item;

import io.jihuayu.goingages.Register.CreativeTabsRegister;
import io.jihuayu.goingages.api.GAItem;
import net.minecraft.item.Item;

public class GrassFiber extends GAItem {

    public GrassFiber(){
        super("grass_fiber");
        this.setCreativeTab(CreativeTabsRegister.misc);
    }

}
