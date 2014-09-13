package io.github.asyncronous.apothecary.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public final class ToolTipHandler{
    @SubscribeEvent
    public void onToolTip(ItemTooltipEvent e){
        if(e.itemStack.hasTagCompound()){
            if(e.itemStack.getTagCompound().getBoolean("poisoned")){
                e.toolTip.add("Poisoned");
            }
        }
    }
}