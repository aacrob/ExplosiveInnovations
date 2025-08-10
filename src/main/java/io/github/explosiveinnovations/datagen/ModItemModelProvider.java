package io.github.explosiveinnovations.datagen;

import io.github.explosiveinnovations.ExplosiveInnovations;
import io.github.explosiveinnovations.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, ExplosiveInnovations.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.METEORITE_INGOT);
        simpleItem(ModItems.METEORITE_PLATE);
        simpleItem(ModItems.RAW_METEORITE);
        simpleItem(ModItems.METEORITE_NUGGET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.tryParse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(ExplosiveInnovations.MODID, "item/" + item.getId().getPath()));
    }
}
