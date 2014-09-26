package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.Apothecary
import io.github.asyncronous.apothecary.anot.Medium
import net.minecraft.potion.Potion

@Medium
object PoisonNightshade
extends Potion(22, true, 0)
with Poison{
  this.setPotionName("poison.nightshadePoison");

  override def id(): String ={
    return "nightshade";
  }

  override def maxUses(): Int ={
    return Apothecary.usesMed;
  }

  override def uid(): Int ={
    return 22;
  }
}