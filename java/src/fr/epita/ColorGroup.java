package fr.epita;

public class ColorGroup 
{
    int sum_r; 
    int sum_g; 
    int sum_b; 
    
    int mean_r; 
    int mean_g; 
    int mean_b;
    
	int id; 
	
    int nb_pixels; 
     
     public ColorGroup(int id, int color) 
     { 
    	 this.id = id;
    	 
         mean_r = ColorUtil.getRed(color);
         mean_g = ColorUtil.getGreen(color);
         mean_b = ColorUtil.getBlue(color);
         
         addPixel(color); 
     } 
      
     public void reset() { 
         mean_r = 0; 
         mean_g = 0; 
         mean_b = 0; 
         sum_r = 0; 
         sum_g = 0; 
         sum_b = 0; 
         nb_pixels = 0; 
     } 
      
     int getId() { 
         return id; 
     } 
     
     //Retourne une couleur en fonction de l'ID du cluster
     //A ameliorer, naif et pas joli
     public int colorOfCluster() { 
     	if (id == 0)
     		return 0x0000ff;
     	else if (id == 1)
     		return 0x00ff00;
     	else if (id == 2)
     		return 0x00ffff;
     	else if (id == 3)
     		return 0xff0000;
     	else if (id == 4)
     		return 0xff00ff;
     	else if (id == 5)
     		return 0xffff00;
       	else if (id == 6)
     		return 0xffffff;
       	else if (id == 7)
     		return 0x000000;
     	else if (id == 8)
     		return 0x777777;
     	else
     		return 0x101010;
     }
     
     
     void addPixel(int rgb) 
     {  
         sum_r 	+= ColorUtil.getRed(rgb); 
         sum_g 	+= ColorUtil.getGreen(rgb); 
         sum_b 	+= ColorUtil.getBlue(rgb); 
         
         nb_pixels++; 
         
         mean_r  = sum_r/nb_pixels; 
         mean_g  = sum_g/nb_pixels; 
         mean_b  = sum_b/nb_pixels; 
     } 
      
     void removePixel(int rgb) 
     { 
         sum_r	-= ColorUtil.getRed(rgb); 
         sum_g	-= ColorUtil.getGreen(rgb); 
         sum_b	-= ColorUtil.getBlue(rgb);
         
         nb_pixels--; 
         
         mean_r   = sum_r/nb_pixels; 
         mean_g = sum_g/nb_pixels; 
         mean_b  = sum_b/nb_pixels; 
     } 
     
     //Calcule la distance chromatique entre la couleur moyenne du cluster et le parametre color
     int chromaticDistance(int color) 
     {   
         int dcr = Math.abs(ColorUtil.getRed(color) - mean_r); 
         int dcg = Math.abs(ColorUtil.getGreen(color) - mean_g); 
         int dcb = Math.abs(ColorUtil.getBlue(color) - mean_b); 
         
         int dcm = (dcr+dcg+dcb);
         dcm = dcm / 3;
         
         return dcm; 
     }


}
