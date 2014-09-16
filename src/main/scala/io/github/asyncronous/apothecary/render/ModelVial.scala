package io.github.asyncronous.apothecary.render

import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.{AdvancedModelLoader, IModelCustom}

class ModelVial{
  private val loc: ResourceLocation = new ResourceLocation("apot", "model/block/vial.obj");
  private val model: IModelCustom = AdvancedModelLoader.loadModel(loc);

  def render(): Unit ={
    model.renderAll();
  }
}