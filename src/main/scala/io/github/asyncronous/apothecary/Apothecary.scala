package io.github.asyncronous.apothecary

import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.apothecary.block.BlockVial
import io.github.asyncronous.apothecary.handler.{PoisonHandler, ApothecaryToolTipHandler, PoisonedBladeHandler}
import io.github.asyncronous.apothecary.item.{ItemPoisonVial, ItemPoison}
import io.github.asyncronous.apothecary.poison.{PoisonRicin, PoisonNightshade, PoisonOleander}
import io.github.asyncronous.apothecary.proxy.CommonProxy
import net.minecraft.item.Item
import net.minecraft.util.DamageSource
import net.minecraftforge.common.MinecraftForge

@Mod(modid = "APOT", name = "Apothecary", version = "0.0.0", useMetadata = true, modLanguage = "scala")
object Apothecary{
  @SidedProxy(clientSide = "io.github.asyncronous.apothecary.proxy.ClientProxy", serverSide = "io.github.asyncronous.apothecary.proxy.ServerProxy")
  var proxy: CommonProxy = null;

  val itemOleanderPV: Item = new ItemPoison(PoisonOleander);
  val itemNightshadePV: Item = new ItemPoison(PoisonNightshade);
  val itemRicinPV: Item = new ItemPoison(PoisonRicin);

  val dmgLow: DamageSource = new DamageSource("poison_low").setDamageBypassesArmor();
  val dmgMed: DamageSource = new DamageSource("poison_med").setDamageBypassesArmor();
  val dmgHigh: DamageSource = new DamageSource("poison_high").setDamageBypassesArmor();

  val usesLow: Int = 4;
  val usesMed: Int = 3;
  val usesHigh: Int = 2;

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={}

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    GameRegistry.registerBlock(BlockVial, classOf[ItemPoisonVial], "blockVial");
    GameRegistry.registerItem(itemOleanderPV, "itemOleanderPV");
    GameRegistry.registerItem(itemNightshadePV, "itemNightshadePV");
    GameRegistry.registerItem(itemRicinPV, "itemRicinPV");

    Poisonables.init();

    proxy.registerHandlers();
    proxy.registerRenders();
    proxy.registerTiles();
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(ApothecaryToolTipHandler);
    MinecraftForge.EVENT_BUS.register(PoisonedBladeHandler);
    MinecraftForge.EVENT_BUS.register(PoisonHandler);
  }
}