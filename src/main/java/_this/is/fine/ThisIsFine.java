package _this.is.fine;

import _this.is.fine.items.CustomArmourClass;
import _this.is.fine.items.ShadesItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ThisIsFine<ITEM_SHADES> implements ModInitializer {

    public static final String MODID = "thisisfine";

    public static final Logger logger = LogManager.getLogger("This Is Fine");

    public static List<Block> ignoreList = Arrays.asList(Blocks.AIR, Blocks.STRUCTURE_VOID, Blocks.VOID_AIR, Blocks.CAVE_AIR, Blocks.BEDROCK, Blocks.FIRE);

    public static Item ITEM_SHADES = new ShadesItem(CustomArmourClass.SHADES, EquipmentSlot.HEAD, (new Item.Settings()).itemGroup(ItemGroup.COMBAT));

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier(MODID, "thisisfine_shades"), ITEM_SHADES);

        logger.info("Everything will be fine");
    }
}
