#include "img.hpp"
#include <iostream>

Img::Img(std::string path)
{
	cv::Mat image = cv::imread(path, CV_LOAD_IMAGE_COLOR);
    	if(image.empty()) 
	{       		
		std::cout << "Error opening image : ";
		std::cout << path;
		std::cout << std::endl;
		exit(4);
	}
	this->img = image;
}
