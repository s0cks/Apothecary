package io.github.asyncronous.apothecary.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class ItemPoisonBase
extends Item{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setMaxStackSize(1);
  this.setUnlocalizedName("poison_base");
}