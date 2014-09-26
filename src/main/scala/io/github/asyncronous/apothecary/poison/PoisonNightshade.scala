package io.github.asyncronous.apothecary.poison

import net.minecraft.potion.Potion

object PoisonNightshade
extends Potion(22, true, 0)
with Poison{
  this.setPotionName("poison.nightshadePoison");

  override def id(): String ={
    return "nightshade";
  }

  override def maxUses(): Int ={
    return 4;
  }
}