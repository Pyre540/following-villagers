package pyre.followingvillagers.util;

import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public static void addVillagerFollowTast(EntityJoinWorldEvent event) {
        if (!event.getWorld().isRemote && event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager)event.getEntity();
            EntityAITempt followPlayerTask = new EntityAITempt(villager, 0.6D, Item.getItemFromBlock(Blocks.EMERALD_BLOCK), false);
            villager.tasks.addTask(3, followPlayerTask);
        }
    }
}
