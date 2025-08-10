package io.github.explosiveinnovations.item;

import io.github.explosiveinnovations.ExplosiveInnovations;
//import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExplosiveInnovations.MODID);

    public static final RegistryObject<Item> METEORITE_INGOT = ITEMS.register("meteorite_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METEORITE_NUGGET = ITEMS.register("meteorite_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_METEORITE = ITEMS.register("raw_meteorite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METEORITE_PLATE = ITEMS.register("meteorite_plate",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
