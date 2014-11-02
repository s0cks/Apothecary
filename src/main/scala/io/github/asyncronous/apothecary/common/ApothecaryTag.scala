package io.github.asyncronous.apothecary.common

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

object ApothecaryTag{
  def IDENTIFIER = "apot";

  def getTag(stack: ItemStack): NBTTagCompound={
    if(stack == null){
      return null;
    }

    if(!stack.hasTagCompound()){
      stack.setTagCompound(new NBTTagCompound());
    }

    val comp: NBTTagCompound = stack.getTagCompound();
    if(!comp.hasKey(IDENTIFIER)){
      comp.setTag(IDENTIFIER, new NBTTagCompound());
    }

    return comp.getCompoundTag(IDENTIFIER);
  }
}