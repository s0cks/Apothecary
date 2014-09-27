package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.{Apothecary, Poisonables}
import io.github.asyncronous.apothecary.anot.Low
import net.minecraft.potion.Potion

@Low
object PoisonHemlock
extends Potion(Poisonables.nextAvailableID(), true, 0)
with Poison{
  override def id(): String ={
    return "hemlock";
  }

  override def maxUses(): Int ={
    return Apothecary.usesLow;
  }

  override def uid(): Int={
    return this.getId();
  }
}
