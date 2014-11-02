package io.github.asyncronous.apothecary.common.poison

import io.github.asyncronous.apothecary.api.anot.High
import io.github.asyncronous.apothecary.api.{AbstractPoison, Poisonables}

@High
object PoisonCyanide
extends AbstractPoison("cyanide"){
  override def maxUses(): Int ={
    return Poisonables.usesHigh;
  }
}