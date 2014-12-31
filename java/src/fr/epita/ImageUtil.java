package fr.epita;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil 
{
    public static void saveImage(String path, BufferedImage img) 
    { 
        File file = new File(path); 
        try {
			ImageIO.write(img, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    } 
     
    public static BufferedImage openImage(String path) 
    { 
        BufferedImage img = null; 
        try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        return img; 
    } 
}
