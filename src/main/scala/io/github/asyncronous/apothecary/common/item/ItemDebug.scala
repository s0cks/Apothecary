package io.github.asyncronous.apothecary.common.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class ItemDebug
extends Item{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setUnlocalizedName("debug");
}