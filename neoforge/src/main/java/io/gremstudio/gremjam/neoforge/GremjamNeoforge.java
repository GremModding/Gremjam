package io.gremstudio.gremjam.neoforge;

import io.gremstudio.gremjam.Gremjam;
import io.gremstudio.gremlib.neoforge.initializers.GremModInitalizationEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;

public class GremjamNeoforge {
    Gremjam gremjam;

    final ModLoadingContext modLoadingContext = ModLoadingContext.get();
    final IEventBus modEventBus = modLoadingContext.getActiveContainer().getEventBus();

    public GremjamNeoforge() {
        modEventBus.register(this);
    }

    @SubscribeEvent
    public void onGremModInitalization(GremModInitalizationEvent event) {
        gremjam = new Gremjam();
    }
}
