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

void Img::makeList()
{
	for(int i=0; i<img.rows; i++)
	{
    		for(int j=0; j<img.cols; j++) 
		{
			pixel *p = new pixel();
			p->b = img.at<cv::Vec3b>(i,j)[0];
			p->g = img.at<cv::Vec3b>(i,j)[1];
			p->r = img.at<cv::Vec3b>(i,j)[2];

			p->x = i;
			p->y = j;
			
			p->print();
		}
	}
}
