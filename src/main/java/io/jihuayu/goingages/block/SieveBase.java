package io.jihuayu.goingages.block;

import io.jihuayu.goingages.GoingAges;
import io.jihuayu.goingages.Register.ItemsRegister;
import io.jihuayu.goingages.api.GABlockContainer;
import io.jihuayu.goingages.entity.block.TileEntitySieveBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class SieveBase extends GABlockContainer {

    public SieveBase() {
        super(Material.WOOD,"sieve_base");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntitySieveBase();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote) return true;
        if(playerIn.getHeldItem(hand).getItem().equals(ItemsRegister.incense)){
            if(worldIn.getTileEntity(pos.add(0,1,0)) instanceof TileEntityChest){
                ((TileEntitySieveBase)(worldIn.getTileEntity(pos))).reSet();
            }
            worldIn.playSound((EntityPlayer)null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.PLAYERS, 0.7F, 1.0f);
            return true;
        }
        return false;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (worldIn.isRemote) return;
        if(!worldIn.getBlockState(pos.add(0,1,0)).getBlock().equals(Blocks.CHEST)&&worldIn.getTileEntity(pos) instanceof TileEntitySieveBase){
            ((TileEntitySieveBase)(worldIn.getTileEntity(pos))).setCheat(null);
        }
        for(int i =-1 ;i<2;i++){
            for(int j=-1;j<2;j++){
                if(i+j!=0){
                    if(!worldIn.getBlockState(pos.add(i,0,j)).getBlock().equals(Blocks.WATER)&&worldIn.getTileEntity(pos) instanceof TileEntitySieveBase){
                        ((TileEntitySieveBase)worldIn.getTileEntity(pos)).setCheat(null);
                    }
                }
            }
        }
        if(worldIn.getTileEntity(pos.add(0,1,0)) instanceof TileEntityChest){
            ((TileEntitySieveBase)(worldIn.getTileEntity(pos))).setCheat(pos.add(0,1,0) );
        }
    }

}
