package io.github.asyncronous.apothecary

import io.github.asyncronous.apothecary.api.Poisonables
import io.github.asyncronous.apothecary.poison._
import net.minecraft.init.Items

object ApothecaryPoisonables {
  def init(): Unit ={
    Poisonables.addPoisonable(Items.wooden_sword);
    Poisonables.addPoisonable(Items.stone_sword);
    Poisonables.addPoisonable(Items.iron_sword);
    Poisonables.addPoisonable(Items.golden_sword);
    Poisonables.addPoisonable(Items.diamond_sword);

    Poisonables.addPoisonable(Items.wooden_axe);
    Poisonables.addPoisonable(Items.stone_axe);
    Poisonables.addPoisonable(Items.iron_axe);
    Poisonables.addPoisonable(Items.golden_axe);
    Poisonables.addPoisonable(Items.diamond_axe);

    Poisonables.addPoison(PoisonAconite);
    Poisonables.addPoison(PoisonBelladonna);
    Poisonables.addPoison(PoisonHemlock);
    Poisonables.addPoison(PoisonNerium);
    Poisonables.addPoison(PoisonRicin);
    Poisonables.addPoison(PoisonCyanide);
  }
}
