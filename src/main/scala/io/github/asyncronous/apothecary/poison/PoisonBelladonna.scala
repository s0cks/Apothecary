package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.{Apothecary, Poisonables}
import io.github.asyncronous.apothecary.anot.Medium
import net.minecraft.potion.Potion

@Medium
object PoisonBelladonna
extends Potion(Poisonables.nextAvailableID(), true, 0)
with Poison{
  override def id(): String ={
    return "belladonna";
  }

  override def maxUses(): Int ={
    return Apothecary.usesMed;
  }

  override def uid(): Int={
    return this.getId();
  }
}