#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/highgui/highgui.hpp>

#include <cstdlib>
#include <iostream>

#include "img.hpp"

using namespace cv;

int main(int argc, char *argv[])
{
	if (argc != 3)
	{
		std::cout << "Usage : ./";
		std::cout << argv[0];
		std::cout << " input_image output_image";
		std::cout << std::endl;
		exit(3);		
	}
	Img *image_in = new Img(argv[1]);	
    	return 0;
}




