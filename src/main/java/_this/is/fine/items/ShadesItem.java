package _this.is.fine.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.TextFormat;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.awt.*;
import java.util.List;

public class ShadesItem extends ArmorItem {

    public ShadesItem(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1, Settings item$Settings_1) {
        super(armorMaterial_1, equipmentSlot_1, item$Settings_1);
    }

    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("shades.item.descriptor").formatted(Formatting.ITALIC, Formatting.GRAY));
    }

}
