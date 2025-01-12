package acp.client;

import net.minecraft.client.Minecraft;

import java.io.File;
import java.lang.reflect.Field;

/**
 * DO NOT DELETE THIS! This class is required to launch Minecraft. It redirects the game to use the 'run' folder in the root directory as
 * its main directory (equivalent to .minecraft or wherever the vanilla launcher stores its files).
 */
public class Start {
    public static void main(String[] args) {
        try {
            Field f = Minecraft.class.getDeclaredField("minecraftDir");
            Field.setAccessible(new Field[] { f }, true);
            f.set(null, new File("run"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Minecraft.main(args);
    }
}