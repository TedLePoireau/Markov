#include "img.hpp"

Img::Img(std::string path)
{
	cv::Mat image = cv::imread(path, CV_LOAD_IMAGE_COLOR);
    	if(image.empty()) 
       		return -1;
	this->img = image;
}
