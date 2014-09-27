package io.github.asyncronous.apothecary.item

import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon

object IngredientMeta{
  val OLEANDER_LEAF: Int = 0;
  val BELLADONNA_BERRIES: Int = 1;
  val APPLE_SEEDS: Int = 2;
  val MONKSHOOD_LEAF: Int = 3;
  val HEMLOCK_LEAF: Int = 4;
  val CASTOR_BEANS: Int = 5;
}

class ItemPoisonIngredient
extends Item{
  private val names: Array[String] = Array(
    "oleander_leaf", "belladonna_berries", "apple_seeds",
    "monkshood_leaf", "hemlock_leaf", "castor_beans"
  );
  private val icons: Array[IIcon] = new Array[IIcon](this.names.length);

  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setHasSubtypes(true);
  this.setUnlocalizedName("ingredient");

  @SideOnly(Side.CLIENT)
  override def getIconFromDamage(dmg: Int): IIcon={
    return this.icons(dmg);
  }

  override def getUnlocalizedName(stack: ItemStack): String={
    return super.getUnlocalizedName() + "." + this.names(stack.getItemDamage());
  }

  override def getSubItems(item: Item, tab: CreativeTabs, list: util.List[_]): Unit ={
    val l: util.List[ItemStack] = list.asInstanceOf[util.List[ItemStack]];

    for(id: Int <- 0 until this.names.length){
      l.add(new ItemStack(item, 0, id));
    }
  }
}
