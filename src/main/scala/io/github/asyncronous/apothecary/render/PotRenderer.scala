package io.github.asyncronous.apothecary.render

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import net.minecraft.block.{BlockLiquid, Block}
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{IIcon, ResourceLocation}
import net.minecraft.world.IBlockAccess
import org.lwjgl.opengl.GL11

class PotRenderer(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler{
  private val model: ModelPot = new ModelPot();
  private val texture: ResourceLocation = new ResourceLocation("apot", "textures/block/pot.png");
  private val water: IIcon = BlockLiquid.getLiquidIcon("water_still");

  override def renderTileEntityAt(tile: TileEntity, x: Double, y: Double, z: Double, scale: Float): Unit ={
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(x, y, z + 1.0D);
    this.model.render();
    GL11.glPopMatrix();
  }

  override def getRenderId: Int ={
    return this.id;
  }

  override def shouldRender3DInInventory(modelId: Int): Boolean ={
    return true;
  }

  override def renderInventoryBlock(block: Block, metadata: Int, modelId: Int, renderer: RenderBlocks): Unit ={
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glScalef(1.5F, 1.5F, 1.5F);
    GL11.glTranslated(0.0D, 0.25D, 1.0D);
    this.model.render();
    GL11.glPopMatrix();
  }

  override def renderWorldBlock(world: IBlockAccess, x: Int, y: Int, z: Int, block: Block, modelId: Int, renderer: RenderBlocks): Boolean ={
    return true;
  }
}