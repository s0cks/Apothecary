package io.github.asyncronous.apothecary

import java.lang.reflect.{Modifier, Field}

import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.{IRecipe, CraftingManager}
import net.minecraft.potion.Potion
import java.util

object VanillaTweaks{
  def removeRecipe(stack: ItemStack): Unit ={
    var res: ItemStack = null;
    val list: util.List[IRecipe] = CraftingManager.getInstance().getRecipeList().asInstanceOf[util.List[IRecipe]];
    for(i: Int <- 0 until list.size()){
      val recipe: IRecipe = list.get(i);
      res = recipe.getRecipeOutput();
      if(ItemStack.areItemStacksEqual(res, stack)){
        list.remove(i);
        return;
      }
    }
  }

  def extendPotionArray(): Unit ={
    var potions: Array[Potion] = null;
    val f: Field = this.getPotionField();
    if(f == null){
      throw new NoSuchFieldException("Cannot find Potion#potionTypes field");
    }

    val mods: Field = classOf[Field].getDeclaredField("modifiers");
    mods.setAccessible(true);
    mods.setInt(f, f.getModifiers() & ~Modifier.FINAL);
    potions = f.get(null).asInstanceOf[Array[Potion]];
    val types: Array[Potion] = new Array[Potion](256);
    System.arraycopy(potions, 0, types, 0, potions.length);
    f.set(null, types);
  }

  private def getPotionField(): Field={
    for(field: Field <- classOf[Potion].getDeclaredFields){
      if(field.getName().equalsIgnoreCase("potionTypes") ||
        field.getName().equalsIgnoreCase("field_76425_a")){

        return field;
      }
    }

    return null;
  }
}
