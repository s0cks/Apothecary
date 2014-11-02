package io.github.asyncronous.apothecary.api

import java.util

import net.minecraft.block.Block
import net.minecraft.util.DamageSource

import scala.collection.JavaConversions._

object ApothecaryAPI{
  private val heaters: util.List[Block] = new util.LinkedList[Block]();

  val dmgLow: DamageSource = new DamageSource("poison_low").setDamageBypassesArmor();
  val dmgMed: DamageSource = new DamageSource("poison_med").setDamageBypassesArmor();
  val dmgHigh: DamageSource = new DamageSource("poison_high").setDamageBypassesArmor();

  def registerHeater(b: Block): Unit ={
    this.heaters.add(b);
  }

  def isHeater(b: Block): Boolean={
    for(block: Block <- heaters){
      if(block == b){
        return true;
      }
    }

    return false;
  }
}
