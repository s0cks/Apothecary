package io.github.asyncronous.apothecary.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.common.ApothecaryTag
import net.minecraft.entity.EntityLiving
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.potion.PotionEffect
import net.minecraftforge.event.entity.player.AttackEntityEvent

object PoisonedBladeHandler{
  @SubscribeEvent
  def onPlayerAttack(e: AttackEntityEvent): Unit ={
    val stack: ItemStack = e.entityPlayer.getCurrentEquippedItem();
    if(stack != null && stack.hasTagCompound() && stack.getTagCompound().hasKey(ApothecaryTag.IDENTIFIER)){
      val comp: NBTTagCompound = ApothecaryTag.getTag(stack);
      if(comp.getBoolean("poisoned")){
        if(e.target.isInstanceOf[EntityLiving]){
          val living: EntityLiving = e.target.asInstanceOf[EntityLiving];
          living.addPotionEffect(new PotionEffect(comp.getByte("poisonId"), 200));
          comp.setBoolean("poisoned", false);
        }
      }
    }
  }
}