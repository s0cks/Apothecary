package io.github.asyncronous.apothecary

import java.util

import io.github.asyncronous.apothecary.item.IngredientMeta
import net.minecraft.init.Items

import scala.collection.JavaConversions._

import io.github.asyncronous.apothecary.recipe.BrewingRecipe
import net.minecraft.item.ItemStack

object BrewingRecipes{
  private val recipes: util.List[BrewingRecipe] = new util.LinkedList[BrewingRecipe]();

  def init(): Unit ={
    add(new BrewingRecipe(new ItemStack(Apothecary.itemPoisonBase),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh)
    ));
    add(new BrewingRecipe(new ItemStack(Apothecary.itemCyanidePV),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.APPLE_SEEDS)
    ));
    add(new BrewingRecipe(new ItemStack(Apothecary.itemHemlockPV),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.HEMLOCK_LEAF)
    ));
    add(new BrewingRecipe(new ItemStack(Apothecary.itemBelladonnaPV),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.BELLADONNA_BERRIES)
    ));
    add(new BrewingRecipe(new ItemStack(Apothecary.itemNeriumPV),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.OLEANDER_LEAF)
    ));
    add(new BrewingRecipe(new ItemStack(Apothecary.itemRicinPV),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.CASTOR_BEANS)
    ));
    add(new BrewingRecipe(new ItemStack(Apothecary.itemAconitePV),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.MONKSHOOD_LEAF)
    ));
  }

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