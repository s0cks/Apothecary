package io.github.asyncronous.apothecary.common.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;

public final class FlowerDecorator{
    private final Block flower;

    public FlowerDecorator(Block flower){
        this.flower = flower;
    }

    @SubscribeEvent
    public void onDecorate(Decorate e){
        int x = e.chunkX + e.rand.nextInt(16) + 8;
        int z = e.chunkZ + e.rand.nextInt(16) + 8;
        int y = e.world.getTopSolidOrLiquidBlock(x, z);
        int x1 = x + e.rand.nextInt(8) - e.rand.nextInt(8);
        int y1 = y + e.rand.nextInt(4) - e.rand.nextInt(4);
        int z1 = z + e.rand.nextInt(8) - e.rand.nextInt(8);

        if(e.world.isAirBlock(x1, y1, z1) && (!e.world.provider.hasNoSky || y1 < 127) && flower.canBlockStay(e.world, x1, y1, z1)){
            e.world.setBlock(x1, y1, z1, flower);
        }
    }
}