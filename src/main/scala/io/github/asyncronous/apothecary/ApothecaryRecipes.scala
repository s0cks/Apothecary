package io.github.asyncronous.apothecary

import io.github.asyncronous.apothecary.api.{BrewingRecipes, BrewingRecipe}
import io.github.asyncronous.apothecary.item.IngredientMeta
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

object ApothecaryRecipes{
  def init(): Unit ={
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemPoisonBase),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemCyanidePV),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.APPLE_SEEDS)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemHemlockPV),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.HEMLOCK_LEAF)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemBelladonnaPV),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.BELLADONNA_BERRIES)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemNeriumPV),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.OLEANDER_LEAF)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemRicinPV),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.CASTOR_BEANS)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemAconitePV),
      new ItemStack(Items.nether_wart),
      new ItemStack(Items.fermented_spider_eye),
      new ItemStack(Items.rotten_flesh),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.MONKSHOOD_LEAF)
    ));
  }
}