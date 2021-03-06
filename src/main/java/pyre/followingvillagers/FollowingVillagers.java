package pyre.followingvillagers;

import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("followingvillagers")
public class FollowingVillagers {

    public FollowingVillagers() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void addVillagerFollowTask(final EntityJoinWorldEvent event) {
        if (!event.getWorld().isRemote && event.getEntity() instanceof VillagerEntity) {
            VillagerEntity villager = (VillagerEntity) event.getEntity();
            TemptGoal followPlayerTask = new TemptGoal(villager, 0.5D, Ingredient.fromItems(Blocks.EMERALD_BLOCK.asItem()), false);
            villager.goalSelector.addGoal(4, followPlayerTask);
        }
    }
}
