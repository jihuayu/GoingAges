package io.jihuayu.goingages.api;

import net.minecraft.block.Block;

import java.util.Set;

public abstract class GAMaterialTool extends GATool
{
    protected GAMaterialTool(String name, ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
        super(name+"_"+materialIn.name().toLowerCase(), materialIn, effectiveBlocksIn);
    }

}
