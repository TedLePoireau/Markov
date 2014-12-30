#pragma once

#include <list>
#include "pixel.hpp"
#include <string>

#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/highgui/highgui.hpp>

class Img
{
public:
	Img(std::string path);	
	void makeList();

	cv::Mat img;
	std::list<pixel> pixlist;	
};
