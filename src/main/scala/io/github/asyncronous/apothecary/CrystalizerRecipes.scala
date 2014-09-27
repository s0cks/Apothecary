package io.github.asyncronous.apothecary

import java.util
import scala.collection.JavaConversions._
import io.github.asyncronous.apothecary.recipe.CrystalizerRecipe
import net.minecraft.item.ItemStack

object CrystalizerRecipes{
  private val recipes: util.List[CrystalizerRecipe] = new util.LinkedList[CrystalizerRecipe]();

  def add(r: CrystalizerRecipe): Unit ={
    this.recipes.add(r);
  }

  def isValid(args: ItemStack): Boolean={
    for(r: CrystalizerRecipe <- this.recipes){
      if(r.equal(args)){
        return true;
      }
    }

    return false;
  }

  def getValid(arg: ItemStack): ItemStack={
    for(r: CrystalizerRecipe <- this.recipes){
      if(r.equal(arg)){
        return r.output;
      }
    }

    return null;
  }
}