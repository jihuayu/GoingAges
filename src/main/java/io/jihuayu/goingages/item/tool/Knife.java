package io.jihuayu.goingages.item.tool;

import com.google.common.collect.Sets;
import io.jihuayu.goingages.api.GAMaterialTool;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;


public class Knife extends GAMaterialTool {

    public Knife(ToolMaterial materialIn) {
        super("knife",materialIn, Sets.newHashSet(Blocks.LEAVES,Blocks.LEAVES2,Blocks.TALLGRASS,Blocks.DOUBLE_PLANT));
    }

}
