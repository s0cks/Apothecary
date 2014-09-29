package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.anot.Medium
import io.github.asyncronous.apothecary.api.{AbstractPoison, Poisonables}

@Medium
object PoisonBelladonna
extends AbstractPoison("belladonna"){
  override def maxUses(): Int ={
    return Poisonables.usesMed;
  }
}