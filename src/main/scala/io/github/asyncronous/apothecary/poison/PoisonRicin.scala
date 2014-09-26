package io.github.asyncronous.apothecary.poison

import net.minecraft.potion.Potion

object PoisonRicin
extends Potion(23, true, 0)
with Poison{
  override def id(): String={
    return "ricin";
  }

  override def maxUses(): Int ={
    return 5;
  }

  override def uid(): Int ={
    return 23;
  }
}