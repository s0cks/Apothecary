package io.github.asyncronous.apothecary.common.poison

import io.github.asyncronous.apothecary.api.anot.High
import io.github.asyncronous.apothecary.api.{AbstractPoison, Poisonables}

@High
object PoisonAconite
extends AbstractPoison("aconite"){
  override def maxUses(): Int ={
    return Poisonables.usesHigh;
  }
}