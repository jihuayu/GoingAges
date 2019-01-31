package io.jihuayu.goingages.Register;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.block.SieveBase;
import io.jihuayu.goingages.entity.block.TileEntitySieveBase;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntitysRegister {

    public TileEntitysRegister()
    {
        registerTileEntity(TileEntitySieveBase.class,BlocksRegister.sieve_base);
    }

    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass,Block block)
    {
        GameRegistry.registerTileEntity(tileEntityClass,block.getRegistryName());
    }
}
