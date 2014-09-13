package io.github.asyncronous.apothecary.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public final class PoisonedBladeHandler{
    @SubscribeEvent
    public void onPlayerAttack(AttackEntityEvent e){
        ItemStack currIS = e.entityPlayer.getCurrentEquippedItem();
        if(currIS.hasTagCompound()){
            NBTTagCompound comp = currIS.stackTagCompound;

            if(comp.getBoolean("poisoned")){
                if(e.target instanceof EntityLiving){
                    EntityLiving l = (EntityLiving) e.target;
                    l.addPotionEffect(new PotionEffect(comp.getByte("poisonId"), 200));
                    comp.setBoolean("poisoned", false);
                }
            }
        }
    }
}