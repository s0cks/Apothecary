package io.github.asyncronous.apothecary;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public final class Recipes{
    @SuppressWarnings("unchecked")
    public static void removeRecipe(ItemStack out){
        ItemStack res;
        List<IRecipe> list = CraftingManager.getInstance().getRecipeList();
        for(int i = 0; i < list.size(); i++){
            IRecipe recipe = list.get(i);
            res = recipe.getRecipeOutput();
            if(ItemStack.areItemStacksEqual(res, out)){
                list.remove(i);
                System.out.println("Removed Recipe For: " + out);
                break;
            }
        }
    }
}