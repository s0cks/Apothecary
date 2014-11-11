package io.github.asyncronous.apothecary.common.block

import io.github.asyncronous.apothecary.api.ApothecaryAPI
import io.github.asyncronous.apothecary.common.Apothecary
import io.github.asyncronous.apothecary.common.tile.TileEntityBrewPot
import net.minecraft.block.material.Material
import net.minecraft.block.{Block, BlockContainer}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase}
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.AxisAlignedBB
import net.minecraft.world.World

object BlockBrewingPot
extends BlockContainer(Material.iron){
  private var renderID: Int = 0;

  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockName("brew_pot");
  this.setHardness(2.0F);
  this.setResistance(10.0F);

  def setRenderID(id: Int): Unit ={
    this.renderID = id;
  }

  override def getRenderType(): Int={
    return this.renderID;
  }

  override def renderAsNormalBlock(): Boolean={
    return false;
  }

  override def isOpaqueCube(): Boolean={
    return false;
  }

  override def onNeighborBlockChange(world: World, x: Int, y: Int, z: Int, block: Block): Unit ={
    val b: Block = world.getBlock(x, y - 1, z);
    val tile: TileEntityBrewPot = world.getTileEntity(x, y, z).asInstanceOf[TileEntityBrewPot];

    if(!ApothecaryAPI.isHeater(b)){
      tile.cooled();
    } else{
      tile.heated();
    }
  }

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, i: Int, f: Float, j: Float, k: Float): Boolean = {
    val tile: TileEntityBrewPot = world.getTileEntity(x, y, z).asInstanceOf[TileEntityBrewPot];

      if (player.isSneaking() && player.getCurrentEquippedItem == null) {
        tile.clear();
      } else {
        val stack: ItemStack = player.getCurrentEquippedItem();
        if (stack == null) {
          if(!world.isRemote){
            tile.debug();
          }
        } else if (stack.getItem() == Items.glass_bottle) {
          if (tile.hasRecipe()) {
            val output: ItemStack = tile.getOutput();

            if(player.inventory.addItemStackToInventory(output.copy())){
              stack.stackSize -= 1;
              tile.clear();
            }
          } else {
            if(tile.isFilled()){
              if(player.inventory.addItemStackToInventory(new ItemStack(Apothecary.itemPoisonFailed, 1))){
                stack.stackSize -= 1;
                tile.clear();
              }
            }
          }
        } else if(stack.getItem() == Items.water_bucket){
          if(!tile.isFilled()){
            tile.fill();
            stack.stackSize -= 1;
            player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
          }
        }
    }

    return true;
  }

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, living: EntityLivingBase, stack: ItemStack): Unit = {
    val tile: TileEntityBrewPot = world.getTileEntity(x, y, z).asInstanceOf[TileEntityBrewPot];

    if(ApothecaryAPI.isHeater(world.getBlock(x, y - 1, z))){
      tile.heated();
    }
  }

  override def onEntityCollidedWithBlock(world: World, x: Int, y: Int, z: Int, e: Entity): Unit ={
    val tile: TileEntityBrewPot = world.getTileEntity(x, y, z).asInstanceOf[TileEntityBrewPot];

    if(e.isInstanceOf[EntityItem] && !e.isDead){
      val item: EntityItem = e.asInstanceOf[EntityItem];
      val stack: ItemStack = item.getEntityItem();

      if(tile.addItem(stack)){
        item.setDead();
        world.markBlockForUpdate(x, y, z);
      }
    }
  }

  override def getCollisionBoundingBoxFromPool(world: World, x: Int, y: Int, z: Int): AxisAlignedBB={
    return AxisAlignedBB.getBoundingBox(x + 0.1, y + 0.1, z + 0.1, x + 0.99, y + 0.99, z + 0.99);
  }

  override def getSelectedBoundingBoxFromPool(world: World, x: Int, y: Int, z: Int): AxisAlignedBB={
    return AxisAlignedBB.getBoundingBox(x + 0.3, y, z + 0.3, x + 0.7, y + 0.4, z + 0.7);
  }

  override def createNewTileEntity(world: World, id: Int): TileEntity={
    return new TileEntityBrewPot();
  }
}