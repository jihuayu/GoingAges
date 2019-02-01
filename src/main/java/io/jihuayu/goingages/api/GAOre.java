package io.jihuayu.goingages.api;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class GAOre extends GABlock {
    public GAOre(String name) {
        super(Material.ROCK,name);
    }
    public GAOre(){
        super(Material.ROCK);
    }
}
