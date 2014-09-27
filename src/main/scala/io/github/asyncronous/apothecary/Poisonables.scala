package io.github.asyncronous.apothecary

import java.util

import io.github.asyncronous.apothecary.poison._
import net.minecraft.entity.Entity
import net.minecraft.init.Items
import net.minecraft.item.Item

import scala.collection.JavaConversions._

object Poisonables{
  private val items: util.List[Item] = new util.LinkedList[Item]();
  private val poisons: util.List[Poison] = new util.LinkedList[Poison]();

  private var potion_id = 30;

  def nextAvailableID(): Int={
    val id = potion_id;
    potion_id += 1;
    return id;
  }

  def init(): Unit ={
    items.add(Items.wooden_sword);
    items.add(Items.stone_sword);
    items.add(Items.iron_sword);
    items.add(Items.golden_sword);
    items.add(Items.diamond_sword);

    items.add(Items.wooden_axe);
    items.add(Items.stone_axe);
    items.add(Items.iron_axe);
    items.add(Items.golden_axe);
    items.add(Items.diamond_axe);

    poisons.add(PoisonNerium);
    poisons.add(PoisonRicin);
    poisons.add(PoisonCyanide);
  }

  def valid(item: Item): Boolean={
    return items.contains(item);
  }

  def getById(id: String): Poison={
    for(p: Poison <- this.poisons){
      if(p.id().equalsIgnoreCase(id)){
        return p;
      }
    }

    return null;
  }

  def attackHigh(e: Entity): Unit ={
    e.attackEntityFrom(Apothecary.dmgHigh, 10.0F);
  }

  def attackMed(e: Entity): Unit ={
    e.attackEntityFrom(Apothecary.dmgMed, 8.0F);
  }

  def attackLow(e: Entity): Unit ={
    e.attackEntityFrom(Apothecary.dmgLow, 2.0F);
  }
}