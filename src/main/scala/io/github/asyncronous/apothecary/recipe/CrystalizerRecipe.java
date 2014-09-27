package io.github.asyncronous.apothecary.recipe;

import net.minecraft.item.ItemStack;

public final class CrystalizerRecipe{
    public final ItemStack output;
    public final ItemStack input;

    public CrystalizerRecipe(ItemStack output, ItemStack input){
        this.output = output;
        this.input = input;
    }

    public boolean equal(ItemStack input){
        return ItemStack.areItemStacksEqual(this.input, input);
    }
}