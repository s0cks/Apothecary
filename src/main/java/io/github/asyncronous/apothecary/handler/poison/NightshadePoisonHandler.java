package io.github.asyncronous.apothecary.handler.poison;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import io.github.asyncronous.apothecary.Apothecary;

public final class NightshadePoisonHandler{
    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent e){
        if(e.entityLiving.isPotionActive(Apothecary.nightShadePoison)){
            if(e.entityLiving.getActivePotionEffect(Apothecary.nightShadePoison).getDuration() == 0){
                e.entityLiving.removePotionEffect(Apothecary.nightShadePoison.getId());
            }

            if(e.entityLiving.worldObj.rand.nextInt(20) == 0){
                e.entity.attackEntityFrom(DamageSource.generic, 10.0F);
            }
        }
    }
}