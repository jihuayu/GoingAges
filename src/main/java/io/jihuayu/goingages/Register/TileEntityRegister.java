package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.GoingAges;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegister {
    public TileEntityRegister()
    {

    }

    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass,Block block)
    {
        GameRegistry.registerTileEntity(tileEntityClass,block.getRegistryName());
    }
}
