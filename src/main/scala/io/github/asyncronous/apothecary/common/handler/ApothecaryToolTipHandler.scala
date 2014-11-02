package io.github.asyncronous.apothecary.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.common.item.ItemPoison
import io.github.asyncronous.apothecary.common.{ApothecaryTag, PoisonVial}
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.event.entity.player.ItemTooltipEvent

object ApothecaryToolTipHandler{
  @SubscribeEvent
  def onToolTip(e: ItemTooltipEvent): Unit = {
    if (e.itemStack.hasTagCompound() &&
        e.itemStack.getTagCompound().hasKey(ApothecaryTag.IDENTIFIER)) {
      val comp: NBTTagCompound = ApothecaryTag.getTag(e.itemStack);
      if (comp.getBoolean("poisoned")) {
        e.toolTip.add("Poisoned");
      }
    }
  }

  @SubscribeEvent
  def onToolTip_vial(e: ItemTooltipEvent): Unit = {
    if (e.itemStack.hasTagCompound &&
        e.itemStack.getItem().isInstanceOf[PoisonVial] &&
        e.itemStack.getTagCompound().hasKey(ApothecaryTag.IDENTIFIER)) {
      val vial: PoisonVial = e.itemStack.getItem().asInstanceOf[PoisonVial];
      if(vial.getPoison(e.itemStack) != null){
        e.toolTip.add("Poison: " + vial.getPoison(e.itemStack).id());
        e.toolTip.add("Uses Left: " + vial.getUses(e.itemStack));
      }
    }
  }

  @SubscribeEvent
  def onToolTip_pv(e: ItemTooltipEvent): Unit ={
       if(e.itemStack.getItem().isInstanceOf[ItemPoison]){
         val vial: ItemPoison = e.itemStack.getItem.asInstanceOf[ItemPoison];
        e.toolTip.add("Uses: " + vial.poison.maxUses());
       }
  }
}