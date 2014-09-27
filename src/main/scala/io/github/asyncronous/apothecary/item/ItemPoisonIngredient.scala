package io.github.asyncronous.apothecary.item

import java.util

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.IIcon

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
