package io.github.asyncronous.apothecary.item

import io.github.asyncronous.apothecary.poison.Poison
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.Item

class ItemPoisonVial(val poison: Poison)
extends Item{
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setUnlocalizedName("poison." + poison.id());
}