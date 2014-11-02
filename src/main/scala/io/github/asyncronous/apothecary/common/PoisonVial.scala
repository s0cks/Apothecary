package io.github.asyncronous.apothecary.common

import io.github.asyncronous.apothecary.api.Poison
import net.minecraft.item.ItemStack

trait PoisonVial{
  def setPoison(s: ItemStack, p: Poison)
  def getPoison(s: ItemStack): Poison;
  def setUses(s: ItemStack, i: Int);
  def getUses(s: ItemStack): Int;
}