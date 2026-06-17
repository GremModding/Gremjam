package io.gremstudio.gremjam;

import io.gremstudio.gremjam.registry.GremjamBlocks;
import io.gremstudio.gremjam.registry.GremjamEntities;
import io.gremstudio.gremjam.registry.GremjamItems;
import io.gremstudio.gremlib.mod.GremMod;
import io.gremstudio.gremlib.mod.HasRegistration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Gremjam extends GremMod implements HasRegistration {
    private final Logger LOGGER = LoggerFactory.getLogger("Gremjam");
    Map<ResourceKey<?>, Consumer<Registry<?>>> registryMap = new HashMap<>();
    public static Gremjam INSTANCE;

    public Gremjam() {
        if (INSTANCE != null) {
            throw new GremMod.GremModReinitError("Can't run a GremMod twice over!");
        }

        super();
        INSTANCE = this;
    }

    @Override
    public String getModID() {
        return "gremjam";
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }

    @Override
    public Map<ResourceKey<?>, Consumer<Registry<?>>> getOrMapRegistries() {
        if (registryMap.isEmpty()) {
            registryMap.put(Registries.BLOCK, (_) -> GremjamBlocks.init());
            registryMap.put(Registries.ITEM, (_) -> GremjamItems.init());
            registryMap.put(Registries.ENTITY_TYPE, (_) -> GremjamEntities.init());
        }

        return registryMap;
    }
}
