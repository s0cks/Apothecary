package io.github.asyncronous.apothecary.poison;

import net.minecraft.potion.Potion;

public final class PotionNightshadePoison
extends Potion{
    public PotionNightshadePoison(int id){
        super(id, true, 0);
        this.setPotionName("potion.nightshadePoison");
    }
}