package io.jihuayu.goingages.api;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.CreativeTabsRegister;
import io.jihuayu.goingages.creativetab.TabTool;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class GATool extends ItemTool
{
    protected GATool(ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
        super(materialIn, effectiveBlocksIn);
        this.setCreativeTab(CreativeTabsRegister.tool);
    }

    protected GATool(String name,ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
        this(materialIn, effectiveBlocksIn);
        this.setName(name);
    }

   public Item setName(String name){
       this.setRegistryName(name);
       this.setUnlocalizedName(GoingAges.MODID + ":" + name);
       return this;
   }
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair){
        return false;
    }
}
