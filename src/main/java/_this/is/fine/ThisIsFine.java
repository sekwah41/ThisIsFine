package _this.is.fine;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThisIsFine implements ModInitializer {

    public static final Logger logger = LogManager.getLogger("This Is Fine");

    public static List<Block> ignoreList = Arrays.asList(Blocks.AIR, Blocks.STRUCTURE_VOID, Blocks.VOID_AIR, Blocks.CAVE_AIR, Blocks.BEDROCK, Blocks.FIRE);

    @Override
    public void onInitialize() {
        logger.info("Everything will be fine");
    }
}
