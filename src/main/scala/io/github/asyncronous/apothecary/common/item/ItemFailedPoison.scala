package io.github.asyncronous.apothecary.common.item

import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class ItemFailedPoison
extends Item{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setMaxStackSize(1);
  this.setUnlocalizedName("poison_failed");

  override def registerIcons(r: IIconRegister): Unit ={
    this.itemIcon = r.registerIcon("apot:poison_bottle");
  }
}
