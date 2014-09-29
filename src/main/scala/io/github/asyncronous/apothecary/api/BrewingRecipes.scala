package io.github.asyncronous.apothecary.api

import java.util

import net.minecraft.item.ItemStack

import scala.collection.JavaConversions._

object BrewingRecipes{
  private val recipes: util.List[BrewingRecipe] = new util.LinkedList[BrewingRecipe]();

  def add(r: BrewingRecipe): Unit ={
    this.recipes.add(r);
  }

  def size(): Int={
    return this.recipes.size();
  }

  def isValid(args: Array[ItemStack]): Boolean ={
    for(r: BrewingRecipe <- recipes){
      if(r.equal(args)){
        return true;
      }
    }

    return false;
  }

  def getValid(args: Array[ItemStack]): ItemStack={
    for(r: BrewingRecipe <- recipes){
      if(r.equal(args)){
        return r.output;
      }
    }

    return null;
  }
}