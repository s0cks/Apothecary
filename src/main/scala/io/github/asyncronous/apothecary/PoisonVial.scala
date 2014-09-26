package io.github.asyncronous.apothecary

import io.github.asyncronous.apothecary.poison.Poison
import net.minecraft.item.ItemStack

trait PoisonVial{
  def setPoison(s: ItemStack, p: Poison)
  def getPoison(s: ItemStack): Poison;
  def setUses(s: ItemStack, i: Int);
  def getUses(s: ItemStack): Int;
}