package io.github.asyncronous.apothecary.tile

import io.github.asyncronous.apothecary.BrewingRecipes
import net.minecraft.item.ItemStack
import net.minecraft.nbt.{NBTTagList, NBTTagCompound}
import net.minecraft.tileentity.TileEntity

class TileEntityBrewPot
extends TileEntity{
  private var items: Array[ItemStack] = new Array[ItemStack](10);
  private var ptr: Int = -1;

  override def writeToNBT(comp: NBTTagCompound): Unit ={
    super.writeToNBT(comp);
    comp.setInteger("ptr", this.ptr);

    val tags: NBTTagList = new NBTTagList();
    var count: Int = 0;
    while(count < 10){
      if(this.items(count) != null){
        val c: NBTTagCompound = new NBTTagCompound();
        c.setByte("Slot", count.asInstanceOf[Byte]);
        this.items(count).writeToNBT(c);
        tags.appendTag(c);
      }

      count += 1;
    }

    comp.setTag("Items", tags);
  }

  override def readFromNBT(comp: NBTTagCompound): Unit ={
    super.readFromNBT(comp);
    this.ptr = comp.getInteger("ptr");
    val tags: NBTTagList = comp.getTagList("Items", 10);
    this.items = new Array[ItemStack](10);

    var count = 0;
    while(count < tags.tagCount()){
      val c: NBTTagCompound = tags.getCompoundTagAt(count);
      val slot: Byte = c.getByte("Slot");

      if(slot >= 0 && slot < 10){
        this.items(slot) = ItemStack.loadItemStackFromNBT(c);
      }

      count += 1;
    }
  }

  def dump(): Unit ={
    var count = 0;
    for(stack: ItemStack <- this.items){
      Console.println((count += 1) + ": " + stack.getUnlocalizedName);
    }
  }

  def full(): Boolean={
    return this.ptr >= 10;
  }

  def getCount(): Int={
    var count: Int = 0;

    for(stack: ItemStack <- this.items){
      if(stack != null){
        count += 1;
      }
    }

    return count;
  }

  def clear(): Unit ={
    var count: Int = 0;
    while(count < 10){
      this.items(count) = null;
      count += 1;
    }
    this.ptr = -1;
  }

  def hasRecipe(): Boolean={
    return BrewingRecipes.isValid(this.items);
  }

  def getOutput(): ItemStack={
    return BrewingRecipes.getValid(this.items).copy();
  }

  def addItem(stack: ItemStack): Boolean ={
    this.ptr += 1;

    if(this.full()){
      return false;
    }

    this.items(this.ptr) = stack;
    return true;
  }
}