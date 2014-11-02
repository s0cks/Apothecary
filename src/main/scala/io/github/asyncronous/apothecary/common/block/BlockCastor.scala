package io.github.asyncronous.apothecary.common.block

import net.minecraft.block.BlockBush
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs

object BlockCastor
  extends BlockBush{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockName("castor");

  override def registerBlockIcons(register: IIconRegister): Unit ={
    this.blockIcon = register.registerIcon("apot:castor");
  }
}