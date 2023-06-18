package org.BangC.marble_bang.setup;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import org.BangC.marble_bang.MarbleBang;
import org.BangC.marble_bang.item.TweakRod;

public class DataGather {
    public static void onGatherData(GatherDataEvent event){
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ItemProvider(packOutput, helper));
        gen.addProvider(event.includeClient(), new StateProvider(packOutput, helper));
    }
    public static class EnglishLanguageProvider extends LanguageProvider {
        public EnglishLanguageProvider(PackOutput output) {
            super(output, MarbleBang.MOD_ID, "en_us");
        }
        @Override
        protected void addTranslations() {
            this.add(Registration.TWEAK_ROD.get(), "Tweak Rod");
            this.add(Registration.RAIL_HOLDER.get(), "Rail Holder");
            this.add("mod_tab", "bang!");
        }
    }

    public static class ItemProvider extends ItemModelProvider {
        public ItemProvider(PackOutput gen, ExistingFileHelper helper) {
            super(gen, MarbleBang.MOD_ID, helper);
        }

        @Override
        protected void registerModels() {
            this.singleTexture(
                    TweakRod.ID,
                    new ResourceLocation("item/generated"),
                    "layer0",
                    new ResourceLocation(MarbleBang.MOD_ID, "item/" + TweakRod.ID)
            );
        }
    }
    public static class StateProvider extends BlockStateProvider {
        public StateProvider(PackOutput gen, ExistingFileHelper helper) {
            super(gen, MarbleBang.MOD_ID, helper);
        }

        @Override
        protected void registerStatesAndModels() {
            this.simpleBlock(Registration.RAIL_HOLDER.get(), this.cubeAll(Registration.RAIL_HOLDER.get()));
            this.simpleBlockItem(Registration.RAIL_HOLDER.get(), this.cubeAll(Registration.RAIL_HOLDER.get()));
        }
    }
}
