package io.github.asyncronous.apothecary.client.render

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import io.github.asyncronous.apothecary.client.model.ModelVial
import net.minecraft.block.Block
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ResourceLocation
import net.minecraft.world.IBlockAccess
import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.{ItemRenderType, ItemRendererHelper}
import org.lwjgl.opengl.GL11

class VialRenderer(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler
with IItemRenderer{
  private val model: ModelVial = new ModelVial();
  private val texture: ResourceLocation = new ResourceLocation("apot", "textures/blocks/vial.png");

  override def renderTileEntityAt(tile: TileEntity, x : Double, y : Double, z : Double, p_147500_8_ : Float): Unit ={
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(x, y, z);
    this.model.render();
    GL11.glPopMatrix();
  }

  override def getRenderId: Int ={
    return this.id;
  }

  override def shouldRender3DInInventory(modelId: Int): Boolean ={
    return true;
  }

  override def renderInventoryBlock(block: Block, metadata: Int, modelId: Int, renderer: RenderBlocks): Unit ={}

  override def renderWorldBlock(world: IBlockAccess, x: Int, y: Int, z: Int, block: Block, modelId: Int, renderer: RenderBlocks): Boolean={
    return true;
  }

  override def handleRenderType(item: ItemStack, `type`: ItemRenderType): Boolean ={
    return true;
  }

  override def shouldUseRenderHelper(`type`: ItemRenderType, item: ItemStack, helper: ItemRendererHelper): Boolean ={
    return true;
  }

  override def renderItem(`type`: ItemRenderType, item: ItemStack, data: AnyRef*): Unit ={
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glScalef(1.5F, 1.5F, 1.5F);
    GL11.glTranslated(0.5D, 0.5D, 0.5D);
    this.model.render();
    GL11.glPopMatrix();
  }
}