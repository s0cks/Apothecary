package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.Apothecary
import io.github.asyncronous.apothecary.anot.Low
import net.minecraft.potion.Potion

@Low
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
    return Apothecary.usesLow;
  }
}