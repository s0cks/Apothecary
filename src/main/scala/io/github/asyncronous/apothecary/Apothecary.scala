package io.github.asyncronous.apothecary

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}
import io.github.asyncronous.apothecary.block.{BlockBrewingPot, BlockCrystalizer, BlockVial}
import io.github.asyncronous.apothecary.handler.{ApothecaryToolTipHandler, PoisonHandler, PoisonedBladeHandler}
import io.github.asyncronous.apothecary.item._
import io.github.asyncronous.apothecary.poison._
import io.github.asyncronous.apothecary.proxy.CommonProxy
import net.minecraft.init.Items
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.DamageSource
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.common.config.Configuration
import org.apache.logging.log4j.{LogManager, Logger}

@Mod(modid = "APOT", name = "Apothecary", version = "0.0.0", useMetadata = true, modLanguage = "scala")
object Apothecary{
  Potions.extendArray();

  @SidedProxy(clientSide = "io.github.asyncronous.apothecary.proxy.ClientProxy", serverSide = "io.github.asyncronous.apothecary.proxy.ServerProxy")
  var proxy: CommonProxy = null;

  val itemNeriumPV: Item = new ItemPoison(PoisonNerium);
  val itemRicinPV: Item = new ItemPoison(PoisonRicin);
  val itemCyanidePV: Item = new ItemPoison(PoisonCyanide);
  val itemAconitePV: Item = new ItemPoison(PoisonAconite);
  val itemBelladonnaPV: Item = new ItemPoison(PoisonBelladonna);
  val itemHemlockPV: Item = new ItemPoison(PoisonHemlock);
  val itemPoisonBase: Item = new ItemPoisonBase();
  val itemIngredient: Item = new ItemPoisonIngredient();
  val itemDebug: Item = new ItemDebug();

  val config: Configuration = new Configuration();

  val logger: Logger = LogManager.getLogger(Apothecary.getClass.getSimpleName());

  val dmgLow: DamageSource = new DamageSource("poison_low").setDamageBypassesArmor();
  val dmgMed: DamageSource = new DamageSource("poison_med").setDamageBypassesArmor();
  val dmgHigh: DamageSource = new DamageSource("poison_high").setDamageBypassesArmor();

  val hardcore = this.config.getBoolean("hardcore", "settings", true, "Enable this for fun :)");

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    if(hardcore){
      Recipes.removeRecipe(new ItemStack(Items.brewing_stand));
    }
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    GameRegistry.registerBlock(BlockVial, classOf[ItemPoisonVial], "blockVial");
    GameRegistry.registerBlock(BlockCrystalizer, "blockCrystalizer");
    GameRegistry.registerBlock(BlockBrewingPot, "blockBrewPot");

    GameRegistry.registerItem(itemNeriumPV, "itemOleanderPV");
    GameRegistry.registerItem(itemRicinPV, "itemRicinPV");
    GameRegistry.registerItem(itemCyanidePV, "itemCyanidePV");
    GameRegistry.registerItem(itemAconitePV, "itemAconitePV");
    GameRegistry.registerItem(itemBelladonnaPV, "itemBelladonnaPV");
    GameRegistry.registerItem(itemHemlockPV, "itemHemlockPV");
    GameRegistry.registerItem(itemPoisonBase, "itemPoisonBase");
    GameRegistry.registerItem(itemIngredient, "itemIngredient");
    GameRegistry.registerItem(itemDebug, "itemDebug");

    ApothecaryPoisonables.init();

    proxy.registerHandlers();
    proxy.registerRenders();
    proxy.registerTiles();
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit ={
    MinecraftForge.EVENT_BUS.register(ApothecaryToolTipHandler);
    MinecraftForge.EVENT_BUS.register(PoisonedBladeHandler);
    MinecraftForge.EVENT_BUS.register(PoisonHandler);

    ApothecaryRecipes.init();
  }
}