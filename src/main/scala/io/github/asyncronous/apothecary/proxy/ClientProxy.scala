package io.github.asyncronous.apothecary.proxy

import cpw.mods.fml.client.registry.{ClientRegistry, RenderingRegistry}
import cpw.mods.fml.common.registry.GameRegistry
import io.github.asyncronous.apothecary.block.BlockVial
import io.github.asyncronous.apothecary.render.VialRenderer
import io.github.asyncronous.apothecary.tile.{TileEntityCrystalizer, TileEntityBrewPot, TileEntityVial}
import net.minecraft.item.Item
import net.minecraftforge.client.MinecraftForgeClient

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
  }

  override def registerHandlers(): Unit ={

  }
}
