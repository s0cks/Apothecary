package io.github.asyncronous.apothecary.poison;

import net.minecraft.potion.Potion;

public final class PotionOleanderPoison
extends Potion{
    public PotionOleanderPoison(int id){
        super(id, true, 0);
        this.setPotionName("potion.oleanderPoison");
    }
}