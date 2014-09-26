package io.github.asyncronous.apothecary.poison

import net.minecraft.potion.Potion

object PoisonOleander
extends Potion(21, true, 0)
with Poison{
  this.setPotionName("poison.oleanderPoison");

  override def uid(): Int={
    return 21;
  }

  override def id(): String ={
    return "oleander";
  }

  override def maxUses(): Int ={
    return 16;
  }
}