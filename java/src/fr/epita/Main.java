package fr.epita;

import java.awt.image.BufferedImage;

public class Main {

	public static void main(String[] args) 
	{
	        if (args.length != 3) 
	        { 
	            System.out.print("Usage: java -jar segment.jar"); 
	            System.out.println(" image_in image_out number_of_class");
	            return; 
	        } 
	      
	        String image_in_path = args[0]; 
	        String image_out_path = args[1]; 
	        
	        int nb_of_class = Integer.parseInt(args[2]); 

	        Segmenter kmeans = new Segmenter(); 
	        BufferedImage srcImg = ImageUtil.openImage(image_in_path);
	        BufferedImage dstImg = kmeans.compute(srcImg, nb_of_class);
	        ImageUtil.saveImage(image_out_path, dstImg);
	        	
	        return;
	        
	} 

}