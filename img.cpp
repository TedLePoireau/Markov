#include "img.hpp"
#include <iostream>

#define MATCH_MIN 30

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

	//clusters = new std::list<Cluster*>();
}

void Img::makeList()
{
	for(int i=0; i<img.rows; i++)
	{
    	for(int j=0; j<img.cols; j++) 
		{
			Pixel *p = new Pixel();
			p->b = img.at<cv::Vec3b>(i,j)[0];
			p->g = img.at<cv::Vec3b>(i,j)[1];
			p->r = img.at<cv::Vec3b>(i,j)[2];

			p->x = i;
			p->y = j;
			
			pixlist.push_front(p);	
			//p->print();
		}
	}
}

void Img::clusterize()
{
	int n = 1;
	int n_max = 1;	
	std::cout << "**********" << std::endl;
	std::cout << "clusterize" << std::endl;
	std::cout << "**********" << std::endl;
	bool found = false;
	for (Pixel *p : pixlist)
	{
		if (n == n_max)
		{
			std::cout << n << std::endl;
			n_max*=10;
		}
		n++;
		found = false;
		for (Cluster *c : clusters)
		{
			if (c->dist(p) < MATCH_MIN)
			{
				//std::cout << "a";
				c->pixels.push_front(p);
				c->update_means();
				found = true;
			}
		}
		if (found)
			continue;
		std::cout << "cluster not found" << std::endl;
		Cluster* new_c = new Cluster();
		new_c->pixels.push_front(p);
		new_c->update_means();
		clusters.push_front(new_c);								
	}
}

void Img::list_clusters()
{
	int nb = 0;
	std::cout << "Listing clusters" << std::endl;
	for (Cluster *c : clusters)
	{
		std::cout << "Cluster nb: " << nb << std::endl;
		std::cout << "Means R:" << c->mean_r << std::endl;
		std::cout << "Means G:" << c->mean_g << std::endl;
		std::cout << "Means B:" << c->mean_b << std::endl << std::endl;
	}	
}
