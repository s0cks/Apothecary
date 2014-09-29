package io.github.asyncronous.apothecary.proxy

import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.apothecary.block.{BlockBrewingPot, BlockVial}
import io.github.asyncronous.apothecary.handler.{PoisonHandler, PoisonedBladeHandler, ApothecaryToolTipHandler}
import io.github.asyncronous.apothecary.render.{PotRenderer, VialRenderer}
import io.github.asyncronous.apothecary.tile.{TileEntityCrystalizer, TileEntityBrewPot, TileEntityVial}
import net.minecraft.item.Item
import net.minecraftforge.client.MinecraftForgeClient
import net.minecraftforge.common.MinecraftForge

class ClientProxy
extends CommonProxy{
  override def registerTiles(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileEntityVial], "tileVial");
    GameRegistry.registerTileEntity(classOf[TileEntityBrewPot], "tileBrewPot");
    GameRegistry.registerTileEntity(classOf[TileEntityCrystalizer], "tileCrystalizer");
  }

  override def registerRenders(): Unit ={
    val vialId = RenderingRegistry.getNextAvailableRenderId();
    val vialRenderer: VialRenderer = new VialRenderer(vialId);
    BlockVial.setRenderID(vialId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityVial], vialRenderer);
    RenderingRegistry.registerBlockHandler(vialRenderer);
    MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockVial), vialRenderer);

    val potId = RenderingRegistry.getNextAvailableRenderId();
    val potRenderer: PotRenderer = new PotRenderer(potId);
    BlockBrewingPot.setRenderID(potId);
    ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityBrewPot], potRenderer);
    RenderingRegistry.registerBlockHandler(potRenderer);
  }

  override def registerHandlers(): Unit ={
    MinecraftForge.EVENT_BUS.register(ApothecaryToolTipHandler);
    MinecraftForge.EVENT_BUS.register(PoisonedBladeHandler);
    MinecraftForge.EVENT_BUS.register(PoisonHandler);
  }
}
