package io.github.explosiveinnovations.item;

import io.github.explosiveinnovations.ExplosiveInnovations;
import io.github.explosiveinnovations.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExplosiveInnovations.MODID);

    public static final RegistryObject<CreativeModeTab> EI_MATERIALS_TAB = CREATIVE_MODE_TABS.register("ei_materials_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.METEORITE_INGOT.get()))
                    .title(Component.translatable("creativetab.ei_materials_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // raw ores
                        pOutput.accept(ModItems.RAW_METEORITE.get());

                        // ingots
                        pOutput.accept(ModItems.METEORITE_INGOT.get());

                        // nuggets
                        pOutput.accept(ModItems.METEORITE_NUGGET.get());

                        //plates
                        pOutput.accept(ModItems.METEORITE_PLATE.get());

                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> EI_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ei_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.METEORITE_CASING.get()))
                    .title(Component.translatable("creativetab.ei_blocks_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // ore blocks
                        pOutput.accept(ModBlocks.METEORITE_BEARING_ORE.get());

                        // raw ore blocks

                        // ingot blocks

                        // machine casings
                        pOutput.accept(ModBlocks.METEORITE_CASING.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
