package io.github.asyncronous.apothecary.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.Poisonables
import io.github.asyncronous.apothecary.poison.{PoisonNightshade, PoisonOleander, PoisonRicin}
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent

object PoisonHandler{
  @SubscribeEvent
  def onEntityUpdate_nightshade(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonNightshade.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonNightshade).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonNightshade.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackMed(e.entity);
      }
    }
  }

  @SubscribeEvent
  def onEntityUpdate_oleander(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonOleander.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonOleander).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonOleander.getId());
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
}