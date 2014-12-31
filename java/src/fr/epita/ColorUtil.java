package fr.epita;

public class ColorUtil {
	public static int getRed(int rgb)
	{
		rgb = rgb>>16;
		return (rgb&0x000000ff);
	}
	public static int getGreen(int rgb)
	{
		rgb = rgb>>8;
		return (rgb&0x000000ff);
	}
	public static int getBlue(int rgb)
	{
		return (rgb&0x000000ff);
	}
}
