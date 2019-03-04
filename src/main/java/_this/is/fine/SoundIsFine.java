package _this.is.fine;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundIsFine {

    public static final SoundEvent EQUIP_SHADES = register("thatshot");

    private static SoundEvent register(String string_1) {
        return Registry.register(Registry.SOUND_EVENT, string_1, new SoundEvent(new Identifier("thisisfine", string_1)));
    }
}
