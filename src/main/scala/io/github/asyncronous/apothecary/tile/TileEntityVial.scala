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

  override def writeToNBT(comp: NBTTagCompound): Unit ={
    super.writeToNBT(comp);
    comp.setString("poison_id", this.poison.id());
    comp.setInteger("uses", this.uses);
  }

  override def readFromNBT(comp: NBTTagCompound): Unit ={
    super.readFromNBT(comp);
    this.poison = Poisonables.getById(comp.getString("poison_id"));
    this.uses = comp.getInteger("uses");
  }
}