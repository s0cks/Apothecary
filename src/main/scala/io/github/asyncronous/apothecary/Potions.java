package io.github.asyncronous.apothecary;

import net.minecraft.potion.Potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class Potions{
    public static void extendArray()
    throws Exception{
        Potion[] potions;
        Field f;
        f = Potion.class.getDeclaredField("potionTypes");
        if(f == null){
            f = Potion.class.getDeclaredField("field_764245_a");
        }
        if(f == null){
            throw new RuntimeException("Cannot find Potion#potionTypes field");
        }

        Field mods = Field.class.getDeclaredField("modifiers");
        mods.setAccessible(true);
        mods.setInt(f, f.getModifiers()&~Modifier.FINAL);
        potions = (Potion[]) f.get(null);
        Potion[] types = new Potion[256];
        System.arraycopy(potions, 0, types, 0, potions.length);
        f.set(null, types);
    }
}