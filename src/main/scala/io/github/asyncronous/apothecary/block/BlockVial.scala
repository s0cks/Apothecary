package io.github.asyncronous.apothecary.block

import io.github.asyncronous.apothecary.tile.TileEntityVial
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object BlockVial
extends BlockContainer(Material.glass){
  private var id: Int = 0;

  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 0.5F, 0.6F);

  override def createNewTileEntity(world: World, id: Int): TileEntity={
    return new TileEntityVial();
  }

  def setRenderID(id: Int): Unit ={
    this.id = id;
  }

  override def getRenderType(): Int={
    return this.id;
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }
}