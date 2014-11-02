package io.github.asyncronous.apothecary.common.poison

import io.github.asyncronous.apothecary.api.anot.Low
import io.github.asyncronous.apothecary.api.{AbstractPoison, Poisonables}

@Low
object PoisonNerium
extends AbstractPoison("nerium"){
  override def maxUses(): Int ={
    Poisonables.usesLow;
  }
}