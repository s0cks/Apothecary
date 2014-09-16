package io.github.asyncronous.apothecary.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.ApothecaryTag
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.entity.player.ItemTooltipEvent

object ApothecaryToolTipHandler{
  @SubscribeEvent
  def onToolTip(e: ItemTooltipEvent): Unit ={
    if(e.itemStack.hasTagCompound() && e.itemStack.getTagCompound().hasKey(ApothecaryTag.IDENTIFIER)){
      val comp: NBTTagCompound = ApothecaryTag.getTag(e.itemStack);
      if(comp.getBoolean("poisoned")){
        e.toolTip.add("Poisoned");
      }
    }
  }
}