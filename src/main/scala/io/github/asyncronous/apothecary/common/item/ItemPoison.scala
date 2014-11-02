package io.github.asyncronous.apothecary.common.item

import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.github.asyncronous.apothecary.api.Poison
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class ItemPoison(val poison: Poison)
extends Item{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setUnlocalizedName("poison." + poison.id());
  this.setMaxStackSize(1);

  @SideOnly(Side.CLIENT)
  override def registerIcons(r: IIconRegister): Unit ={
    this.itemIcon = r.registerIcon("apot:poison_bottle");
  }
}