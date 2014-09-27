package io.github.asyncronous.apothecary.recipe;

import net.minecraft.item.ItemStack;

public class BrewingRecipe{
    public static final int MAX_SIZE = 10;
    public final ItemStack[] ingrediants = new ItemStack[MAX_SIZE];
    public final ItemStack output;

    public BrewingRecipe(ItemStack output, ItemStack... args){
        if(args.length > MAX_SIZE){
            throw new IllegalStateException("Recipe size is too large");
        }

        this.output = output;
        System.arraycopy(args, 0, this.ingrediants, 0, args.length);
    }

    public boolean equal(ItemStack[] args){
        for(int i = 0; i < MAX_SIZE; i++){
            if(args[i] == null || this.ingrediants[i] == null){
                return false;
            }

            if(ItemStack.areItemStacksEqual(args[i], this.ingrediants[i])){
                return true;
            }
        }

        return false;
    }
}