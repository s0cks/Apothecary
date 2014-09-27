package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.{Poisonables, Apothecary}
import io.github.asyncronous.apothecary.anot.Low
import net.minecraft.potion.Potion

@Low
object PoisonNerium
extends Potion(Poisonables.nextAvailableID(), true, 0)
with Poison{
  this.setPotionName("poison.neriumPoison");

  override def uid(): Int={
    return 21;
  }

  override def id(): String ={
    return "nerium";
  }

  override def maxUses(): Int ={
    return Apothecary.usesLow;
  }
}