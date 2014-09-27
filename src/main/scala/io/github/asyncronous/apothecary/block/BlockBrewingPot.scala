package io.github.asyncronous.apothecary.block

import io.github.asyncronous.apothecary.tile.TileEntityBrewPot
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.Entity
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{AxisAlignedBB, ChatComponentText}
import net.minecraft.world.World

object BlockBrewingPot
extends BlockContainer(Material.iron){
  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockName("brew_pot");

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, i: Int, f: Float, j: Float, k: Float): Boolean = {
    val tile: TileEntityBrewPot = world.getTileEntity(x, y, z).asInstanceOf[TileEntityBrewPot];

    if (player.isSneaking()) {
      tile.clear();
    } else {
      val stack: ItemStack = player.getCurrentEquippedItem();
      if (stack == null) {
        if (!world.isRemote) {
          player.addChatComponentMessage(new ChatComponentText("Current Ingredient Count: " + tile.getCount()));
          tile.dump();
        }
      } else if (stack.getItem() == Items.glass_bottle) {
        if (tile.hasRecipe()) {
          val output: ItemStack = tile.getOutput();
          Console.println(output);
          if(player.inventory.addItemStackToInventory(output)){
            stack.stackSize -= 1;
            tile.clear();
          }
        } else {
          if (!world.isRemote) {
            player.addChatComponentMessage(new ChatComponentText("Invalid Recipe"));
          }
        }
      }
    }

    return true;
  }

  override def onEntityCollidedWithBlock(world: World, x: Int, y: Int, z: Int, e: Entity): Unit ={
    val tile: TileEntityBrewPot = world.getTileEntity(x, y, z).asInstanceOf[TileEntityBrewPot];

    if(e.isInstanceOf[EntityItem] && !e.isDead){
      val item: EntityItem = e.asInstanceOf[EntityItem];
      val stack: ItemStack = item.getEntityItem();

      if(tile.addItem(stack)){
        item.setDead();
      }
    }
  }

  override def getCollisionBoundingBoxFromPool(world: World, x: Int, y: Int, z: Int): AxisAlignedBB={
    return AxisAlignedBB.getBoundingBox(x + 0.1, y + 0.1, z + 0.1, x + 0.99, y + 0.99, z + 0.99);
  }

  override def getSelectedBoundingBoxFromPool(world: World, x: Int, y: Int, z: Int): AxisAlignedBB={
    return AxisAlignedBB.getBoundingBox(x + 0.3, y + 0.3, z + 0.3, x + 0.7, y + 0.7, z + 0.7);
  }

  override def createNewTileEntity(world: World, id: Int): TileEntity={
    return new TileEntityBrewPot();
  }
}