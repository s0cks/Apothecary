package io.github.asyncronous.apothecary.recipe;

import net.minecraft.item.ItemStack;

public class BrewingRecipe{
    public static final int MAX_SIZE = 10;
    public final ItemStack[] ingrediants = new ItemStack[MAX_SIZE];
    public final int size;
    public final ItemStack output;

    public BrewingRecipe(ItemStack output, ItemStack... args){
        if(args.length > MAX_SIZE){
            throw new IllegalStateException("Recipe size is too large");
        }

        this.output = output;
        this.size = args.length;
        System.arraycopy(args, 0, this.ingrediants, 0, args.length);
    }

    public boolean equal(ItemStack[] args){
        boolean ret = false;

        if(this.calcSize(args) != this.size){
            return false;
        }

        for(int i = 0; i < this.size; i++){
            ret = ItemStack.areItemStacksEqual(args[i], this.ingrediants[i]);
        }

        return ret;
    }

    private int calcSize(ItemStack[] stack){
        int count = 0;
        for(ItemStack aStack : stack){
            if(aStack != null){
                count++;
            }
        }
        return count;
    }
}