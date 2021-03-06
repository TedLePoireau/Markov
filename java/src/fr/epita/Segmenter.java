package fr.epita;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Segmenter {
	BufferedImage image_in;
	BufferedImage image_out;

	ArrayList<ColorGroup> colorGroups;

	public Segmenter() {
	}

	public BufferedImage compute(BufferedImage image, int nb_of_class)
	{
		int img_width = image.getWidth();
		int img_height = image.getHeight();

		colorGroups = makeGroups(image, nb_of_class);
		int[] cgroupsTable = new int[img_width * img_height];
		Arrays.fill(cgroupsTable, -1);

		boolean changed = true;
		while (changed) 
		{
			changed = false;
			for (int y = 0; y < img_height; y++) 
			{
				for (int x = 0; x < img_width; x++) 
				{
					int pixel = image.getRGB(x, y);
					ColorGroup cluster = getBestGroup(pixel);
					
					if (cgroupsTable[img_width * y + x] != cluster.getId()) 
					{
						changed = true;
						cgroupsTable[img_width * y + x] = cluster.getId();
					}
				}
			}
			for (int i = 0; i < colorGroups.size(); i++) {
				colorGroups.get(i).reset();
			}
			for (int y = 0; y < img_height; y++) 
			{
				for (int x = 0; x < img_width; x++) 
				{
					int id = cgroupsTable[(img_width * y) + x];
					colorGroups.get(id).addPixel(image.getRGB(x, y));
				}
			}

		}

		BufferedImage image_out = new BufferedImage(img_width, img_height, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < img_height; y++) 
		{
			for (int x = 0; x < img_width; x++) 
			{
				int id = cgroupsTable[(img_width * y) + x];
				image_out.setRGB(x, y, colorGroups.get(id).colorOfCluster());
			}
		}
		return image_out;
	}
	
	//Ajouter du random?
	public ArrayList<ColorGroup> makeGroups(BufferedImage image, int nb_of_class) 
	{
		ArrayList<ColorGroup> result = new ArrayList<ColorGroup>(nb_of_class);
		int x = 0;
		int y = 0;
		int dx = image.getWidth() / nb_of_class;
		int dy = image.getHeight() / nb_of_class;
		for (int i = 0; i < nb_of_class; i++) {
			result.add(i, new ColorGroup(i, image.getRGB(x, y)));
			x += dx;
			y += dy;
		}
		return result;
	}

	public ColorGroup getBestGroup(int rgb) {
		ColorGroup groups = null;
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < colorGroups.size(); i++) 
		{
			int dist = colorGroups.get(i).chromaticDistance(rgb);
			if (dist < min) 
			{
				min = dist;
				groups = colorGroups.get(i);
			}
		}
		return groups;
	}

}
