package io.github.asyncronous.apothecary

import scala.collection.JavaConversions._
import java.util
import io.github.asyncronous.apothecary.poison._
import net.minecraft.init.Items
import net.minecraft.item.Item

object Poisonables{
  private val items: util.List[Item] = new util.LinkedList[Item]();
  private val poisons: util.List[Poison] = new util.LinkedList[Poison]();

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

    poisons.add(PoisonNightshade);
    poisons.add(PoisonOleander);
    poisons.add(PoisonRicin);
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
}