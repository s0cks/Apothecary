package io.github.asyncronous.apothecary.render

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import io.github.asyncronous.apothecary.tile.TileEntityBrewPot
import net.minecraft.block.Block
import net.minecraft.client.renderer.texture.TextureMap
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.client.renderer.{RenderBlocks, Tessellator}
import net.minecraft.init.Blocks
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{IIcon, ResourceLocation}
import net.minecraft.world.IBlockAccess
import org.lwjgl.opengl.GL11

class PotRenderer(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler{
  private val model: ModelPot = new ModelPot();
  private val texture: ResourceLocation = new ResourceLocation("apot", "textures/block/pot.png");
  private val water: IIcon = Blocks.water.getIcon(0, 0);

  override def renderTileEntityAt(tiles: TileEntity, x: Double, y: Double, z: Double, scale: Float): Unit ={
    val tile: TileEntityBrewPot = tiles.asInstanceOf[TileEntityBrewPot];
    this.bindTexture(this.texture);
    GL11.glPushMatrix();
    GL11.glTranslated(x, y, z + 1.0D);
    this.model.render();

    val v: Float = 1.0F / 8.0F;
    val w: Float = -v * 3.5F;
    val s: Float = 1.0F / 256.0F * 14.0F;

    if(tile.isFilled()){
      GL11.glPushMatrix();
      /*
      GL11.glEnable(GL11.GL_BLEND);
      GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
      GL11.glDisable(GL11.GL_ALPHA_TEST);
      */

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glTranslatef(0.25F, 0.9F, 0.25F);
      GL11.glTranslatef(0.0F, 0.43F - 1.0F, w - 0.5F);
      GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      GL11.glScalef(s / 2F, s / 2F, s / 2F);

      this.bindTexture(TextureMap.locationBlocksTexture);
      this.renderIcon(0, 0, this.water, 16, 16, 240);

      Console.println("Rendering Water");

      /*
      GL11.glEnable(GL11.GL_ALPHA_TEST);
      GL11.glDisable(GL11.GL_BLEND);
      */
      GL11.glPopMatrix();
    }

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

  def renderIcon(par1: Int, par2: Int, par3Icon: IIcon, par4: Int, par5: Int, brightness: Int): Unit={
    val tessellator: Tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.setBrightness(brightness);
    tessellator.addVertexWithUV(par1 + 0, par2 + par5, 0, par3Icon.getMinU(), par3Icon.getMaxV());
    tessellator.addVertexWithUV(par1 + par4, par2 + par5, 0, par3Icon.getMaxU(), par3Icon.getMaxV());
    tessellator.addVertexWithUV(par1 + par4, par2 + 0, 0, par3Icon.getMaxU(), par3Icon.getMinV());
    tessellator.addVertexWithUV(par1 + 0, par2 + 0, 0, par3Icon.getMinU(), par3Icon.getMinV());
    tessellator.draw();
  }
}