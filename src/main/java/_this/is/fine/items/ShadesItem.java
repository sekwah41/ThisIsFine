package _this.is.fine.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TextFormat;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ShadesItem extends ArmorItem {

    public ShadesItem(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1, Settings item$Settings_1) {
        super(armorMaterial_1, equipmentSlot_1, item$Settings_1);
    }

    @Environment(EnvType.CLIENT)
    public void buildTooltip(ItemStack itemStack_1, World world_1, List<TextComponent> list_1, TooltipContext tooltipContext_1) {
        list_1.add(new TranslatableTextComponent("shades.item.descriptor").method_11020().applyFormat(TextFormat.ITALIC, TextFormat.GRAY));
    }

}
