package io.gremstudio.gremjam.registry;

import io.gremstudio.gremjam.Gremjam;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class GremjamItems {
    public static Item register(String id, Function<Item.Properties, Item> func, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Gremjam.INSTANCE.createId(id));
        return Registry.register(BuiltInRegistries.ITEM, key, func.apply(properties.setId(key)));
    }

    public static void init() {}
}
