package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.{Apothecary, Poisonables}
import io.github.asyncronous.apothecary.anot.High
import net.minecraft.potion.Potion

@High
object PoisonAconite
extends Potion(Poisonables.nextAvailableID(), true, 0)
with Poison{
  override def id(): String ={
    return "aconite";
  }

  override def maxUses(): Int ={
    return Apothecary.usesHigh;
  }

  override def uid(): Int ={
    return this.getId();
  }
}