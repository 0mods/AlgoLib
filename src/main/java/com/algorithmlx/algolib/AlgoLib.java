package com.algorithmlx.algolib;

import com.algorithmlx.algolib.config.AlgoLibConfig;
import com.algorithmlx.algolib.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlgoLib implements ModInitializer {
    public static final String ID = "algolib";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        new ModConfig(AlgoLibConfig.class, ID);
        if(AlgoLibConfig.allowExampleArmor){
            Registration.init();
        }
        if(AlgoLibConfig.allowExampleArmor == false) {
            LOGGER.info("allowExampleArmor = false, skipping registry classes");
        }
    }
}
