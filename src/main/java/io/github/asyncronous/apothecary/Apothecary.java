package io.github.asyncronous.apothecary;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

import io.github.asyncronous.apothecary.block.BlockVial;
import io.github.asyncronous.apothecary.handler.poison.NightshadePoisonHandler;
import io.github.asyncronous.apothecary.handler.poison.OleanderPoisonHandler;
import io.github.asyncronous.apothecary.handler.PoisonedBladeHandler;
import io.github.asyncronous.apothecary.handler.ToolTipHandler;
import io.github.asyncronous.apothecary.poison.PotionNightshadePoison;
import io.github.asyncronous.apothecary.poison.PotionOleanderPoison;

@Mod(modid = "APOT", name = "Apothecary", version = "0.0.0", useMetadata = true)
public final class Apothecary{
    public static final Block blockPoisoner = new BlockVial();

    public static final Potion nightShadePoison = new PotionNightshadePoison(21);
    public static final Potion oleanderPoison = new PotionOleanderPoison(22);

    @EventHandler
    public void preInit(FMLPreInitializationEvent init){
        GameRegistry.registerBlock(blockPoisoner, "apot:blockPoisoner");
    }

    @EventHandler
    public void onInit(FMLInitializationEvent e){
        MinecraftForge.EVENT_BUS.register(new ToolTipHandler());
        MinecraftForge.EVENT_BUS.register(new PoisonedBladeHandler());
        MinecraftForge.EVENT_BUS.register(new NightshadePoisonHandler());
        MinecraftForge.EVENT_BUS.register(new OleanderPoisonHandler());
    }
}