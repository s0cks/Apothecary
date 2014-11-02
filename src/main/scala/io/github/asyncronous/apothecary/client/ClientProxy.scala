package io.github.asyncronous.apothecary.client

import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.apothecary.client.render.{PotRenderer, VialRenderer}
import io.github.asyncronous.apothecary.common.block._
import io.github.asyncronous.apothecary.common.handler.{ApothecaryToolTipHandler, PoisonHandler, PoisonedBladeHandler}
import io.github.asyncronous.apothecary.common.proxy.CommonProxy
import io.github.asyncronous.apothecary.common.tile.{TileEntityBrewPot, TileEntityVial}
import net.minecraft.item.Item
import net.minecraftforge.client.MinecraftForgeClient
import net.minecraftforge.common.MinecraftForge

class ClientProxy
extends CommonProxy{
  override def registerTiles(): Unit ={
    GameRegistry.registerTileEntity(classOf[TileEntityVial], "tileVial");
    GameRegistry.registerTileEntity(classOf[TileEntityBrewPot], "tileBrewPot");
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
