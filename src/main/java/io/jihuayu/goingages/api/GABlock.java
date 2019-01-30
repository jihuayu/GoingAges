package io.jihuayu.goingages.api;


import io.jihuayu.goingages.GoingAges;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GABlock extends Block {
    public GABlock(Material blockMaterialIn, String name) {
        super(blockMaterialIn);
        this.setName(name);
    }
    public Block setName(String name){
        this.setRegistryName(name);
        this.setUnlocalizedName(GoingAges.MODID + ":" + name);
        return this;
    }
}
