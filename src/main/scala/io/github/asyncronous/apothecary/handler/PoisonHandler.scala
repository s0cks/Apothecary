package io.github.asyncronous.apothecary.handler

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import io.github.asyncronous.apothecary.poison.{PoisonOleander, PoisonNightshade}
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent

object PoisonHandler{
  @SubscribeEvent
  def onEntityUpdate_nightshade(e: LivingUpdateEvent): Unit ={
    if(e.entityLiving.isPotionActive(PoisonNightshade.getId())){
      if(e.entityLiving.getActivePotionEffect(PoisonNightshade).getDuration() == 0){
        e.entityLiving.removePotionEffect(PoisonNightshade.getId());
      }

      if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
        e.entity.attackEntityFrom(DamageSource.generic, 10.0F);
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
        e.entity.attackEntityFrom(DamageSource.generic, 20.0F);
      }
    }
  }
}