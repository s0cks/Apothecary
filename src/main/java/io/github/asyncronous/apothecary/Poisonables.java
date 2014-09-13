package io.github.asyncronous.apothecary;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.LinkedList;
import java.util.List;

public final class Poisonables{
    public static final List<Item> items = new LinkedList<Item>();

    static
    {
        items.add(Items.wooden_sword);
        items.add(Items.stone_sword);
        items.add(Items.iron_sword);
        items.add(Items.golden_sword);
        items.add(Items.diamond_sword);

        items.add(Items.wooden_axe);
        items.add(Items.stone_axe);
        items.add(Items.iron_axe);
        items.add(Items.golden_axe);
        items.add(Items.diamond_axe);
    }

    private Poisonables(){}
}