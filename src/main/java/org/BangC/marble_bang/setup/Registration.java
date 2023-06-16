package org.BangC.marble_bang.setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.BangC.marble_bang.MarbleBang;
import org.BangC.marble_bang.block.RailHolder;
import org.BangC.marble_bang.item.TweakRod;

public class Registration {
    public Registration(){}
    public static void register(IEventBus modEventBus){
        BLOCK.register(modEventBus);
        ITEM.register(modEventBus);
    }

    public static void addCreativeTab(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == ModTab.MOD_TAB){
            event.accept(TWEAK_ROD);
            event.accept(RAIL_HOLDER_ITEM);
        }
    }

    private static RegistryObject<Item> blockItem(RegistryObject<Block> block){
        return ITEM.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MarbleBang.MOD_ID);

    private static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, MarbleBang.MOD_ID);

    public static final RegistryObject<Item> TWEAK_ROD = ITEM.register(TweakRod.ID, TweakRod::new);

    public static final RegistryObject<Block> RAIL_HOLDER = BLOCK.register(RailHolder.ID, RailHolder::new);
    public static final RegistryObject<Item> RAIL_HOLDER_ITEM = blockItem(RAIL_HOLDER);
}
