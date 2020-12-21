package org.dabhand.botz.graphics;

import net.sf.image4j.codec.ico.ICODecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tiles {
    public enum Tile {
        SHORT_GRASS("tileable-IMG_0062.png"),
        DARK_GRASS("tileable-IMG_0062-dark.png"),
        GREY_GRASS("tileable-IMG_0062-grey.png"),
        LUSH_GRASS("tileable-IMG_0062-lush.png"),
        VERY_DARK_GRASS("tileable-IMG_0062-verydark.png"),
        GREY_HASH("tileable-IMG_0062_nm.png"),
        EMPTY_C4("empty_c4.ico"),
        RED_C4("red_c4.ico"),
        YELLOW_C4("yellow_c4.ico");

        private final String file;

        Tile(String file) {
            this.file = file;
        }

        public String getFile() {
            return file;
        }

    }
    private final Map<Tile,BufferedImage> tiles = new ConcurrentHashMap<>();

    public void checkAll() {
        Arrays.stream(Tile.values()).sequential().forEach(x->{
            get(x);
        });
    }
    BufferedImage getImage(String s) {
        try {
            InputStream res = getClass().getClassLoader().getResourceAsStream("resources/" + s);
            if ( res == null )
                System.out.println("Could not find "+s);
            if ( s.toUpperCase().endsWith("ICO"))
                return ICODecoder.read(res).get(0);
            return ImageIO.read(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public BufferedImage get(Tile t) {
        return tiles.computeIfAbsent(t,x-> {
            return getImage(t.getFile());
        });
    }
    public void done() {
        tiles.clear();
    }

}
