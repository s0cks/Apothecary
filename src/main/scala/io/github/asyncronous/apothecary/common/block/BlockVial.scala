package io.github.asyncronous.apothecary.common.block

import java.util.Random

import cpw.mods.fml.relauncher.{Side, SideOnly}
import io.github.asyncronous.apothecary.api.Poisonables
import io.github.asyncronous.apothecary.common.item.ItemPoison
import io.github.asyncronous.apothecary.common.tile.TileEntityVial
import io.github.asyncronous.apothecary.common.{ApothecaryTag, PoisonVial}
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{ChatComponentText, MovingObjectPosition}
import net.minecraft.world.World

object BlockVial
extends BlockContainer(Material.glass){
  private var id: Int = 0;

  this.setCreativeTab(CreativeTabs.tabBrewing);
  this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 0.5F, 0.6F);
  this.setBlockName("vial");
  this.setHardness(2.0F);
  this.setResistance(10.0F);

  override def onBlockPlacedBy(world: World, x: Int, y: Int, z: Int, living: EntityLivingBase, stack: ItemStack): Unit ={
    val tile: TileEntityVial = world.getTileEntity(x, y, z).asInstanceOf[TileEntityVial];
    val comp: NBTTagCompound = ApothecaryTag.getTag(stack);
    tile.poison = Poisonables.getById(comp.getString("poison_name"));
    tile.uses = comp.getInteger("poison_uses");
  }

  override def quantityDropped(rand: Random): Int={
    return 0;
  }

  override def getItemDropped(i: Int, rand: Random, j: Int): Item={
    return null;
  }

  @SideOnly(Side.CLIENT)
  override def onBlockActivated (world: World, x: Int, y: Int, z: Int, player : EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float): Boolean ={
    val stack: ItemStack = player.getCurrentEquippedItem();
    val tile: TileEntityVial = world.getTileEntity(x, y, z).asInstanceOf[TileEntityVial];
    if(stack == null){
      if(tile.poison != null){
        if(!world.isRemote){
          player.addChatMessage(new ChatComponentText("Current Poison: " + tile.poison.id()));
          player.addChatMessage(new ChatComponentText("Uses Left: " + tile.uses));
        }
      }
    } else if(stack.getItem().isInstanceOf[ItemPoison] &&
              tile.poison == null){
      tile.set(stack.getItem().asInstanceOf[ItemPoison].poison);
      stack.stackSize -= 1;
    } else if(Poisonables.valid(stack.getItem()) &&
              tile.poison != null){
      val comp: NBTTagCompound = ApothecaryTag.getTag(stack);
      if(!comp.getBoolean("poisoned")){
        comp.setBoolean("poisoned", true);
        comp.setInteger("poisonId", tile.poison.uid());
        tile.subUses();
      }
    }

    return true;
  }

  @SideOnly(Side.CLIENT)
  override def removedByPlayer(world: World, player: EntityPlayer, x: Int, y: Int, z: Int, harvest: Boolean): Boolean={
    if(!player.capabilities.isCreativeMode &&
       !world.isRemote &&
       canHarvestBlock(player, world.getBlockMetadata(x, y, z))){

      val motion: Float = 0.7F;
      val motX: Double = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
      val motY: Double = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
      val motZ: Double = (world.rand.nextFloat() * motion) + (1.0F - motion) * 0.5D;
      val eItem: EntityItem = new EntityItem(world, x + motX, y + motY, z + motZ, this.getPickBlock(null, world, x, y, z));
      world.spawnEntityInWorld(eItem);
    }

    return world.setBlockToAir(x, y, z);
  }

  override def getPickBlock(t: MovingObjectPosition, world: World, x: Int, y: Int, z: Int): ItemStack={
    val tile: TileEntityVial = world.getTileEntity(x, y, z).asInstanceOf[TileEntityVial];
    val stack: ItemStack = new ItemStack(BlockVial);
    val poisonVial: PoisonVial = stack.getItem().asInstanceOf[PoisonVial];

    if(tile.poison != null){
      poisonVial.setPoison(stack, tile.poison);
      poisonVial.setUses(stack, tile.uses);
    }
    return stack;
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