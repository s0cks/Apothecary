package io.github.asyncronous.apothecary.api

import net.minecraft.potion.Potion

abstract class AbstractPoison(val pid: String)
extends Potion(Poisonables.nextAvailableID(), true, 0)
with Poison{
  Poisonables.addPoison(this);

  override def id(): String ={
    return this.pid;
  }

  override def uid(): Int ={
    return this.getId();
  }
}