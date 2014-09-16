package io.github.asyncronous.apothecary

import java.util
import net.minecraft.init.Items
import net.minecraft.item.Item

object Poisonables{
  private val items: util.List[Item] = new util.LinkedList[Item]();

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
  }

  def valid(item: Item): Boolean={
    return items.contains(item);
  }
}