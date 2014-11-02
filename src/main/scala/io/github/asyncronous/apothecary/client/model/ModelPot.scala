package io.github.asyncronous.apothecary.client.model

import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.{AdvancedModelLoader, IModelCustom}

class ModelPot{
  private val loc: ResourceLocation = new ResourceLocation("apot", "model/block/pot.obj");
  private val model: IModelCustom = AdvancedModelLoader.loadModel(loc);

  def render(): Unit ={
    this.model.renderAll();
  }
}