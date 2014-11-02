package io.github.asyncronous.apothecary.common

import java.io.File

import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}
import io.github.asyncronous.apothecary.api.{BrewingRecipes, ApothecaryAPI}
import io.github.asyncronous.apothecary.common.block._
import io.github.asyncronous.apothecary.common.handler.FlowerDecorator
import io.github.asyncronous.apothecary.common.item._
import io.github.asyncronous.apothecary.common.poison._
import io.github.asyncronous.apothecary.common.proxy.CommonProxy
import net.minecraft.init.{Blocks, Items}
import net.minecraft.item.{Item, ItemStack}
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.common.config.Configuration
import org.apache.logging.log4j.{LogManager, Logger}

@Mod(modid = "APOT", name = "Apothecary", version = "0.0.0", useMetadata = true, modLanguage = "scala")
object Apothecary{
  VanillaTweaks.extendPotionArray();

  @SidedProxy(clientSide = "io.github.asyncronous.apothecary.client.ClientProxy", serverSide = "io.github.asyncronous.apothecary.common.proxy.ServerProxy")
  var proxy: CommonProxy = null;

  val itemNeriumPV: Item = new ItemPoison(PoisonNerium);
  val itemRicinPV: Item = new ItemPoison(PoisonRicin);
  val itemCyanidePV: Item = new ItemPoison(PoisonCyanide);
  val itemAconitePV: Item = new ItemPoison(PoisonAconite);
  val itemBelladonnaPV: Item = new ItemPoison(PoisonBelladonna);
  val itemHemlockPV: Item = new ItemPoison(PoisonHemlock);
  val itemPoisonBase: Item = new ItemPoisonBase();
  val itemIngredient: Item = new ItemPoisonIngredient();
  val itemPoisonFailed: Item = new ItemFailedPoison();

  var config: Configuration = null;

  val logger: Logger = LogManager.getLogger(Apothecary.getClass.getSimpleName());

  @Mod.EventHandler
  def preInit(e: FMLPreInitializationEvent): Unit ={
    this.config = new Configuration(new File(e.getModConfigurationDirectory(), "apothecary.cfg"));
    if(this.config.getBoolean("hardcore", "settings", true, "Enable this for fun :)")){
      VanillaTweaks.removeRecipe(new ItemStack(Items.brewing_stand));
    }
    this.config.save();
  }

  @Mod.EventHandler
  def init(e: FMLInitializationEvent): Unit ={
    GameRegistry.registerBlock(BlockVial, classOf[ItemPoisonVial], "blockVial");
    GameRegistry.registerBlock(BlockBrewingPot, "blockBrewPot");
    GameRegistry.registerBlock(BlockBelladonna, "blockBelladonna");
    GameRegistry.registerBlock(BlockCastor, "blockCastor");
    GameRegistry.registerBlock(BlockHemlock, "blockHemlock");
    GameRegistry.registerBlock(BlockMonkshood, "blockMonkshood");
    GameRegistry.registerBlock(BlockOleander, "blockOleander");

    GameRegistry.registerItem(itemNeriumPV, "itemOleanderPV");
    GameRegistry.registerItem(itemRicinPV, "itemRicinPV");
    GameRegistry.registerItem(itemCyanidePV, "itemCyanidePV");
    GameRegistry.registerItem(itemAconitePV, "itemAconitePV");
    GameRegistry.registerItem(itemBelladonnaPV, "itemBelladonnaPV");
    GameRegistry.registerItem(itemHemlockPV, "itemHemlockPV");
    GameRegistry.registerItem(itemPoisonBase, "itemPoisonBase");
    GameRegistry.registerItem(itemIngredient, "itemIngredient");
    GameRegistry.registerItem(itemPoisonFailed, "itemPoisonFailed");

    ApothecaryPoisonables.init();
    ApothecaryRecipes.init();

    ApothecaryAPI.registerHeater(Blocks.fire);
    ApothecaryAPI.registerHeater(Blocks.lava);
    ApothecaryAPI.registerHeater(Blocks.lit_furnace);
    ApothecaryAPI.registerHeater(Blocks.flowing_lava);

    proxy.registerHandlers();
    proxy.registerRenders();
    proxy.registerTiles();
  }

  @Mod.EventHandler
  def postInit(e: FMLPostInitializationEvent): Unit ={
    logger.info("Loaded " + BrewingRecipes.size() + " Brewing Recipes");

    MinecraftForge.TERRAIN_GEN_BUS.register(new FlowerDecorator(BlockBelladonna));
    MinecraftForge.TERRAIN_GEN_BUS.register(new FlowerDecorator(BlockCastor));
    MinecraftForge.TERRAIN_GEN_BUS.register(new FlowerDecorator(BlockHemlock));
    MinecraftForge.TERRAIN_GEN_BUS.register(new FlowerDecorator(BlockMonkshood));
    MinecraftForge.TERRAIN_GEN_BUS.register(new FlowerDecorator(BlockOleander));
  }
}