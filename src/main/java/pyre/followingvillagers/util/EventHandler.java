package pyre.followingvillagers.util;

import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void addVillagerFollowTast(final EntityJoinWorldEvent event) {
        if (!event.getWorld().isRemote && event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) event.getEntity();
            EntityAITempt followPlayerTask = new EntityAITempt(villager, 0.6D, Ingredient.fromItems(Blocks.EMERALD_BLOCK.asItem()), false);
            villager.tasks.addTask(3, followPlayerTask);
        }
    }
}
