#pragma once

#include <list>
#include <string>

#include "pixel.hpp"
#include "cluster.hpp"

#include <opencv2/core/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/highgui/highgui.hpp>

class Img
{
public:
	Img(std::string path);	
	void makeList();
	void clusterize();
	void list_clusters();

	cv::Mat img;
	std::list<Pixel*> pixlist;	
	std::list<Cluster*> clusters;
};
