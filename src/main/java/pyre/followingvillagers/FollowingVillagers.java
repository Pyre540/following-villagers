package pyre.followingvillagers;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import pyre.followingvillagers.util.EventHandler;
import pyre.followingvillagers.util.Reference;

@Mod(Reference.MOD_ID)
public class FollowingVillagers {

    public FollowingVillagers() {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
