package org.BangC.marble_bang;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.BangC.marble_bang.setup.DataGather;
import org.BangC.marble_bang.setup.Registration;
import org.slf4j.Logger;

@Mod("marble_bang")
public class MarbleBang {
    public static final String MOD_ID = "marble_bang";
    public static final Logger LOGGER = LogUtils.getLogger();
    public MarbleBang() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Registration.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(Registration::registerCreativeModeTabs);
        modEventBus.addListener(Registration::addCreativeTab);
        modEventBus.addListener(DataGather::onGatherData);
    }
}
