package io.github.asyncronous.apothecary.tile

import io.github.asyncronous.apothecary.Poisonables
import io.github.asyncronous.apothecary.poison.Poison
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity

class TileEntityVial
extends TileEntity{
  var poison: Poison = null;
  var uses: Int = 0;

  def set(p: Poison): Unit ={
    this.poison = p;
    this.uses = p.maxUses();
  }

  def subUses(): Unit ={
    this.uses -= 1;
    if(uses <= 0){
      this.poison = null;
    }
  }

  override def writeToNBT(comp: NBTTagCompound): Unit ={
    super.writeToNBT(comp);
    if(this.poison != null){
      comp.setString("poison_id", this.poison.id());
      comp.setInteger("uses", this.uses);
    }
  }

  override def readFromNBT(comp: NBTTagCompound): Unit ={
    super.readFromNBT(comp);
    this.poison = Poisonables.getById(comp.getString("poison_id"));
    this.uses = comp.getInteger("uses");
  }
}