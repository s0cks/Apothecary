package io.github.asyncronous.apothecary.block

import io.github.asyncronous.apothecary.Poisonables
import io.github.asyncronous.apothecary.item.ItemPoisonVial
import io.github.asyncronous.apothecary.tile.TileEntityVial
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World

object BlockVial
extends BlockContainer(Material.glass){
  private var id: Int = 0;

  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 0.5F, 0.6F);

  override def onBlockActivated (world: World, x: Int, y: Int, z: Int, player : EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean ={
    val stack: ItemStack = player.getCurrentEquippedItem();
    val tile: TileEntityVial = world.getTileEntity(x, y, z).asInstanceOf[TileEntityVial];
    if(stack == null){
      if(tile.poison != null){
        player.addChatComponentMessage(new ChatComponentText("Current Poison: " + tile.poison.id()));
        player.addChatComponentMessage(new ChatComponentText("Uses Left: " + tile.uses));
      }
    } else if(stack.getItem().isInstanceOf[ItemPoisonVial] &&
              tile.poison == null){
      tile.set(stack.getItem().asInstanceOf[ItemPoisonVial].poison);
      stack.stackSize -= 1;
    } else if(Poisonables.valid(stack.getItem())){
      //TODO: Write Poisoning logic
    }

    return true;
  }

  override def createNewTileEntity(world: World, id: Int): TileEntity={
    return new TileEntityVial();
  }

  def setRenderID(id: Int): Unit ={
    this.id = id;
  }

  override def getRenderType(): Int={
    return this.id;
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }
}