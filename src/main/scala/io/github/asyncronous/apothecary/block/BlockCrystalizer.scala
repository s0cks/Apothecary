package io.github.asyncronous.apothecary.block

import io.github.asyncronous.apothecary.tile.TileEntityCrystalizer
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object BlockCrystalizer
extends BlockContainer(Material.iron){
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockName("crystalizer");

  override def createNewTileEntity(p_149915_1_ : World, p_149915_2_ : Int): TileEntity = {
    return new TileEntityCrystalizer();
  }
}