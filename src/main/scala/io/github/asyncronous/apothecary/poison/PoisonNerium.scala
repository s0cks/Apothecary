package io.github.asyncronous.apothecary.poison

import io.github.asyncronous.apothecary.anot.Low
import io.github.asyncronous.apothecary.api.{Poisonables, AbstractPoison}

@Low
object PoisonNerium
extends AbstractPoison("nerium"){
  override def maxUses(): Int ={
    Poisonables.usesLow;
  }
}