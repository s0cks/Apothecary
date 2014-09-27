package io.github.asyncronous.apothecary.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.Poisonables
import io.github.asyncronous.apothecary.poison.{PoisonCyanide, PoisonNerium, PoisonRicin}
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent

object PoisonHandler{
  @SubscribeEvent
  def onEntityUpdate_oleander(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonNerium.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonNerium).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonNerium.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackLow(e.entity);
      }
    }
  }

  @SubscribeEvent
  def onEntityUpdate_ricin(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonRicin.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonRicin).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonRicin.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackHigh(e.entity);
      }
    }
  }

  @SubscribeEvent
  def onEntityUpdate_cyanide(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonCyanide.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonCyanide).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonCyanide.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackHigh(e.entity);
      }
    }
  }
}