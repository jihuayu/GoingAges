package io.jihuayu.goingages.block;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.CreativeTabsRegister;
import io.jihuayu.goingages.api.ITimeUser;
import net.minecraft.block.BlockTorch;

public class TorchSimple extends BlockTorch {
    public TorchSimple(){
        String name = "torch_simple";
        this.setUnlocalizedName(GoingAges.MODID+":"+name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabsRegister.misc);
        this.setLightLevel(10/15f);
    }

}
