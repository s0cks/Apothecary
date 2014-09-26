package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.Apothecary
import io.github.asyncronous.apothecary.anot.High
import net.minecraft.potion.Potion

@High
object PoisonRicin
extends Potion(23, true, 0)
with Poison{
  override def id(): String={
    return "ricin";
  }

  override def maxUses(): Int ={
    return Apothecary.usesHigh;
  }

  override def uid(): Int ={
    return 23;
  }
}