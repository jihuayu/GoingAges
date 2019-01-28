package io.jihuayu.goingages.mixin.item;

import io.jihuayu.goingages.api.ITimeUser;
import net.minecraft.block.BlockTorch;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockTorch.class)
public class NewTorch implements ITimeUser {
    @Override
    public int getUseTime() {
        return 5;
    }
}
