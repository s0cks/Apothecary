package io.github.asyncronous.apothecary.common.block

import net.minecraft.block.BlockBush
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs

object BlockMonkshood
  extends BlockBush{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockName("monkshood");

  override def registerBlockIcons(register: IIconRegister): Unit ={
    this.blockIcon = register.registerIcon("apot:monkshood");
  }
}