package io.github.asyncronous.apothecary.api;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BrewingRecipe{
    public static final int MAX_SIZE = 10;

    public final List<ItemStack> ingrediants;
    public final int size;
    public final ItemStack output;

    public BrewingRecipe(ItemStack output, ItemStack... args){
        if(args.length > MAX_SIZE){
            throw new IllegalStateException("Recipe size is too large");
        }

        this.output = output;
        this.size = args.length;
        this.ingrediants = Arrays.asList(args);
    }

    public boolean equal(ItemStack[] args){
        List<ItemStack> list = new ArrayList<ItemStack>(this.ingrediants);

        for(ItemStack stack : args){
            if(stack != null){
                boolean ret = false;

                for(ItemStack s : list){
                    if(s.getItem() == stack.getItem() && s.getItemDamage() == stack.getItemDamage() && s.stackSize == stack.stackSize){
                        ret = true;
                        list.remove(s);
                        break;
                    }
                }

                if(!ret){
                    return false;
                }
            }
        }

        return list.isEmpty();
    }
}