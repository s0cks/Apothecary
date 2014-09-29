package io.github.asyncronous.apothecary.api

import java.util

import io.github.asyncronous.apothecary.Apothecary
import net.minecraft.entity.Entity
import net.minecraft.item.Item

import scala.collection.JavaConversions._

object Poisonables{
  private val items: util.List[Item] = new util.LinkedList[Item]();
  private val poisons: util.List[Poison] = new util.LinkedList[Poison]();
  private var potion_id = 30;

  val usesLow: Int = 4;
  val usesMed: Int = 3;
  val usesHigh: Int = 2;

  def nextAvailableID(): Int={
    val id = potion_id;
    potion_id += 1;
    return id;
  }

  def addPoisonable(i: Item): Unit ={
    this.items.add(i);
  }

  def addPoison(p: Poison): Unit ={
    this.poisons.add(p);
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