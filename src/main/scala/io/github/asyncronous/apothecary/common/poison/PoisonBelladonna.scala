package io.github.asyncronous.apothecary.common.poison

import io.github.asyncronous.apothecary.api.anot.Medium
import io.github.asyncronous.apothecary.api.{AbstractPoison, Poisonables}

@Medium
object PoisonBelladonna
extends AbstractPoison("belladonna"){
  override def maxUses(): Int ={
    return Poisonables.usesMed;
  }
}