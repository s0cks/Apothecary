package io.github.asyncronous.apothecary.common.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.api.Poisonables
import io.github.asyncronous.apothecary.common.poison._
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent

object PoisonHandler{
  @SubscribeEvent
  def onEntityUpdate_aconite(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonAconite.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonAconite).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonAconite.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackHigh(e.entity);
      }
    }
  }

  @SubscribeEvent
  def onEntityUpdate_belladonna(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonBelladonna.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonBelladonna).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonBelladonna.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackMed(e.entity);
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

  @SubscribeEvent
  def onEntityUpdate_hemlock(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonHemlock.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonHemlock).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonHemlock.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        Poisonables.attackLow(e.entity);
      }
    }
  }

  @SubscribeEvent
  def onEntityUpdate_nerium(e: LivingUpdateEvent): Unit ={
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
}