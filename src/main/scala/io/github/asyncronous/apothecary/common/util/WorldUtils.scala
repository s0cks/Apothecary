package io.github.asyncronous.apothecary.common.util

import java.util.Random

import cpw.mods.fml.common.FMLCommonHandler
import net.minecraft.entity.item.EntityItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

object WorldUtils{
  private val rand: Random = new Random();

  def isServer(): Boolean={
    return FMLCommonHandler.instance().getEffectiveSide.isServer;
  }

  def spawn(world: World, x: Int, y: Int, z: Int, stack: ItemStack): Unit ={
    if(isServer()){
      if(stack != null && stack.stackSize > 0){
        val off_x: Double = (rand.nextInt() % 32 - 16) / 82;
        val off_y: Double = (rand.nextInt() % 32 - 16) / 82;
        val off_z: Double = (rand.nextInt() % 32 - 16) / 82;

        val entity: EntityItem = new EntityItem(world, 0.5 + off_x, 0.5 + off_y, 0.5 + off_z, stack);
        world.spawnEntityInWorld(entity);
      }
    }
  }
}