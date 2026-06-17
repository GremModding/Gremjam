package io.gremstudio.gremjam.registry;

import io.gremstudio.gremjam.Gremjam;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class GremjamBlocks {


    public static Block register(String id, Function<BlockBehaviour.Properties, Block> func, BlockBehaviour.Properties properties) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Gremjam.INSTANCE.createId(id));
        return Registry.register(BuiltInRegistries.BLOCK, key, func.apply(properties.setId(key)));
    }

    public static void init() {}
}
