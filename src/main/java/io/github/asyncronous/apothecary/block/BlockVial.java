package io.github.asyncronous.apothecary.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

import io.github.asyncronous.apothecary.Apothecary;
import io.github.asyncronous.apothecary.Poisonables;

public final class BlockVial
extends Block{
    public BlockVial(){
        super(Material.glass);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
        ItemStack stack = player.getCurrentEquippedItem();
        if(stack != null){
            if(Poisonables.items.contains(stack.getItem())){
                if(!stack.hasTagCompound()){
                    NBTTagCompound comp = new NBTTagCompound();
                    stack.setTagCompound(comp);
                }

                NBTTagCompound comp = stack.getTagCompound();
                comp.setBoolean("poisoned", true);
                comp.setByte("poisonId", (byte) Apothecary.nightShadePoison.getId());
                player.addChatComponentMessage(new ChatComponentText("Item Poisoned"));
            } else{
                player.addChatComponentMessage(new ChatComponentText("Item can't be poisoned"));
            }
        }

        return true;
    }
}