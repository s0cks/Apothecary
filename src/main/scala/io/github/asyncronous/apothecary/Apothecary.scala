package io.github.asyncronous.apothecary

import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.apothecary.block.BlockVial
import io.github.asyncronous.apothecary.handler.{ApothecaryToolTipHandler, PoisonedBladeHandler}
import io.github.asyncronous.apothecary.item.ItemPoisonVial
import io.github.asyncronous.apothecary.poison.{PoisonNightshade, PoisonOleander}
import io.github.asyncronous.apothecary.proxy.CommonProxy
import net.minecraft.item.Item
import net.minecraftforge.common.MinecraftForge

@Mod(modid = "APOT", name = "Apothecary", version = "0.0.0", useMetadata = true, modLanguage = "scala")
object Apothecary{
  @SidedProxy(clientSide = "io.github.asyncronous.apothecary.proxy.ClientProxy", serverSide = "io.github.asyncronous.apothecary.proxy.ServerProxy")
  var proxy: CommonProxy = null;

  val itemOleanderPV: Item = new ItemPoisonVial(PoisonOleander);
  val itemNightshadePV: Item = new ItemPoisonVial(PoisonNightshade);

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    proxy.registerHandlers();
    proxy.registerRenders();
    proxy.registerTiles();
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    GameRegistry.registerBlock(BlockVial, "blockVial");
    GameRegistry.registerItem(itemOleanderPV, "itemOleanderPV");
    GameRegistry.registerItem(itemNightshadePV, "itemNightshadePV");

    Poisonables.init();
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(ApothecaryToolTipHandler);
    MinecraftForge.EVENT_BUS.register(PoisonedBladeHandler);
  }
}