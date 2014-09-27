package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.{Poisonables, Apothecary}
import io.github.asyncronous.apothecary.anot.High
import net.minecraft.potion.Potion

@High
object PoisonCyanide
extends Potion(Poisonables.nextAvailableID(), true, 0)
with Poison{
  override def id(): String ={
    return "cyanide";
  }

  override def maxUses(): Int ={
    return Apothecary.usesHigh;
  }

  override def uid(): Int ={
    return 24;
  }
}