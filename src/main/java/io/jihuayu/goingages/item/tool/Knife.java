package io.jihuayu.goingages.item.tool;

import com.google.common.collect.Sets;
import io.jihuayu.goingages.api.GAMaterialTool;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;


public class Knife extends GAMaterialTool {

    public Knife(ToolMaterial materialIn) {
        super("knife",materialIn, Sets.newHashSet(Blocks.LEAVES,Blocks.LEAVES2,Blocks.TALLGRASS,Blocks.DOUBLE_PLANT));
    }
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("小宝刀");
    }
}
