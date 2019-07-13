package rev3n4nt.blastermod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BlasterMod.MODID)
public class BlasterMod {
    public static final String MODID = "blastermod";

    public BlasterMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                // new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID, "dirt"),
                // new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID, "stick"),
                new ItemBlaster(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID, "blaster")
            );
        }

        @SubscribeEvent
        public static void onSoundRegistry(final RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(
                new SoundEvent(new ResourceLocation(MODID, "blaster_ready")).setRegistryName(MODID, "blaster_ready"),
                new SoundEvent(new ResourceLocation(MODID, "blaster_fire")).setRegistryName(MODID, "blaster_fire")
            );
        }
    }
}
