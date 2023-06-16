package org.BangC.marble_bang.setup;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.BangC.marble_bang.MarbleBang;

@Mod.EventBusSubscriber(modid = MarbleBang.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTab {
    public static CreativeModeTab MOD_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        MOD_TAB = event.registerCreativeModeTab(
                new ResourceLocation(
                        MarbleBang.MOD_ID,
                        "mod_tab"
                ),
                builder -> builder.title(Component.translatable("mod_tab"))
        );
    }
}
