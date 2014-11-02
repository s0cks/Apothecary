package io.github.asyncronous.apothecary.common

import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.apothecary.api.{BrewingRecipe, BrewingRecipes}
import io.github.asyncronous.apothecary.common.block._
import io.github.asyncronous.apothecary.common.item.IngredientMeta
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.ItemStack

object ApothecaryRecipes{
  def init(): Unit ={
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemPoisonBase),
      new ItemStack(Items.poisonous_potato, 1)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemCyanidePV),
      new ItemStack(Apothecary.itemPoisonBase, 1),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.APPLE_SEEDS)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemHemlockPV),
      new ItemStack(Apothecary.itemPoisonBase, 1),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.HEMLOCK_LEAF)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemBelladonnaPV),
      new ItemStack(Apothecary.itemPoisonBase, 1),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.BELLADONNA_BERRIES)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemNeriumPV),
      new ItemStack(Apothecary.itemPoisonBase, 1),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.OLEANDER_LEAF)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemRicinPV),
      new ItemStack(Apothecary.itemPoisonBase, 1),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.CASTOR_BEANS)
    ));
    BrewingRecipes.add(new BrewingRecipe(new ItemStack(Apothecary.itemAconitePV),
      new ItemStack(Apothecary.itemPoisonBase, 1),
      new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.MONKSHOOD_LEAF)
    ));

    GameRegistry.addShapelessRecipe(new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.APPLE_SEEDS), new ItemStack(Items.apple));
    GameRegistry.addShapelessRecipe(new ItemStack(BlockBrewingPot, 1), new ItemStack(Blocks.cauldron));
    GameRegistry.addShapelessRecipe(new ItemStack(BlockVial, 1), new ItemStack(Items.glass_bottle, 1));

    GameRegistry.addShapelessRecipe(new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.HEMLOCK_LEAF), new ItemStack(BlockHemlock, 1));
    GameRegistry.addShapelessRecipe(new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.BELLADONNA_BERRIES), new ItemStack(BlockBelladonna, 1));
    GameRegistry.addShapelessRecipe(new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.OLEANDER_LEAF), new ItemStack(BlockOleander, 1));
    GameRegistry.addShapelessRecipe(new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.CASTOR_BEANS), new ItemStack(BlockCastor, 1));
    GameRegistry.addShapelessRecipe(new ItemStack(Apothecary.itemIngredient, 1, IngredientMeta.MONKSHOOD_LEAF), new ItemStack(BlockMonkshood, 1));

  }
}