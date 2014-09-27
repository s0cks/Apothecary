package io.github.asyncronous.apothecary

import java.util

import scala.collection.JavaConversions._

import io.github.asyncronous.apothecary.recipe.BrewingRecipe
import net.minecraft.item.ItemStack

object BrewingRecipes{
  private val recipes: util.List[BrewingRecipe] = new util.LinkedList[BrewingRecipe]();

  def add(r: BrewingRecipe): Unit ={
    this.recipes.add(r);
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