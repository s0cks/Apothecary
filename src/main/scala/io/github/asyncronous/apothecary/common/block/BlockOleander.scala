package io.github.asyncronous.apothecary.common.block

import net.minecraft.block.BlockBush
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs

object BlockOleander
  extends BlockBush{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockName("oleander");

  override def registerBlockIcons(register: IIconRegister): Unit ={
    this.blockIcon = register.registerIcon("apot:oleander");
  }
}