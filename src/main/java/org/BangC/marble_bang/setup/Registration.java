package org.BangC.marble_bang.setup;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.BangC.marble_bang.MarbleBang;
import org.BangC.marble_bang.block.RailHolder;
import org.BangC.marble_bang.entity.Marble.MarbleEntity;
import org.BangC.marble_bang.entity.Marble.MarbleModel;
import org.BangC.marble_bang.entity.Marble.MarbleRender;
import org.BangC.marble_bang.item.TweakRod;


@Mod.EventBusSubscriber(modid = MarbleBang.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registration {
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
    @SubscribeEvent
    public static void addCreativeTab(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == MOD_TAB){
            event.accept(TWEAK_ROD);
            event.accept(RAIL_HOLDER_ITEM);
        }
    }
    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MarbleModel.LAYER_LOCATION, MarbleModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.MARBLE.get(), MarbleRender::new);
    }

    public static void register(IEventBus modEventBus){
        BLOCK.register(modEventBus);
        ITEM.register(modEventBus);
        ENTITY_TYPE.register(modEventBus);
    }

    private static RegistryObject<Item> blockItem(RegistryObject<Block> block){
        return ITEM.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MarbleBang.MOD_ID);
    private static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, MarbleBang.MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MarbleBang.MOD_ID);

    /*item*************************************************************************************************************/
    public static final RegistryObject<Item> TWEAK_ROD = ITEM.register(TweakRod.ID, TweakRod::new);
    /*block************************************************************************************************************/
    public static final RegistryObject<Block> RAIL_HOLDER = BLOCK.register(RailHolder.ID, RailHolder::new);
    public static final RegistryObject<Item> RAIL_HOLDER_ITEM = blockItem(RAIL_HOLDER);

    /*entity***********************************************************************************************************/
    public static final RegistryObject<EntityType<MarbleEntity>> MARBLE = ENTITY_TYPE.register("marble",
            () -> EntityType.Builder
                    .of(MarbleEntity::new, MobCategory.MISC)
                    .sized(1.0f, 1.0f)
                    .build("marble"));
}
