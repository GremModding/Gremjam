package io.gremstudio.gremjam.fabric;

import io.gremstudio.gremjam.Gremjam;
import io.gremstudio.gremlib.fabric.initializers.GremModInitializer;

public class GremjamFabric implements GremModInitializer {
    Gremjam gremjam;

    @Override
    public void onGremModInitalization() {
        gremjam = new Gremjam();

    }
}
