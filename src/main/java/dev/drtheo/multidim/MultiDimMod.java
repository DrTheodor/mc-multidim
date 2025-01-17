package dev.drtheo.multidim;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiDimMod implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("ait-multidim");

    @Override
    public void onInitialize() {
        MultiDim.init();
    }
}
