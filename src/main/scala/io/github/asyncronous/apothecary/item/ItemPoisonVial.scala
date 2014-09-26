package io.github.asyncronous.apothecary.item

import io.github.asyncronous.apothecary.poison.Poison
import io.github.asyncronous.apothecary.{Poisonables, ApothecaryTag, PoisonVial}
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.{ItemBlock, ItemStack}
import net.minecraft.nbt.NBTTagCompound;

class ItemPoisonVial(b: Block)
extends ItemBlock(b)
with PoisonVial{

  this.setMaxStackSize(1);
  this.setNoRepair();
  this.setCreativeTab(CreativeTabs.tabBrewing);

  override def setPoison(s: ItemStack, p: Poison): Unit ={
    val comp: NBTTagCompound = ApothecaryTag.getTag(s);
    comp.setString("poison_name", p.id());
  }

  override def setUses(s: ItemStack, i: Int): Unit ={
    val comp: NBTTagCompound = ApothecaryTag.getTag(s);
    comp.setInteger("poison_uses", i);
  }

  override def getPoison(s: ItemStack): Poison ={
    val comp: NBTTagCompound = ApothecaryTag.getTag(s);
    return Poisonables.getById(comp.getString("poison_name"));
  }

  override def getUses(s: ItemStack): Int ={
    val comp: NBTTagCompound = ApothecaryTag.getTag(s);
    return comp.getInteger("poison_uses");
  }
}