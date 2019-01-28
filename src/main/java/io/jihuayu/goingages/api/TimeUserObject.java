package io.jihuayu.goingages.api;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class TimeUserObject{
    private Long overtime;
    private Block block;
    private BlockPos pos;

    public TimeUserObject(Block block, BlockPos pos, Long overtime) {
        this.overtime = overtime;
        this.block = block;
        this.pos = pos;
    }

    public BlockPos getPos() {
        return pos;
    }

    public Block getBlock() {
        return block;
    }

    public long getOvertime() {
        return overtime;
    }

}