package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.anot.Low
import io.github.asyncronous.apothecary.api.{AbstractPoison, Poisonables}

@Low
object PoisonHemlock
extends AbstractPoison("hemlock"){
  override def maxUses(): Int ={
    return Poisonables.usesLow;
  }
}
