#pragma once
#include <list>
#include "pixel.hpp"
#include <math.h>

class Cluster
{
public:
	int dist(Pixel *p);
	void update_means();

	int mean_r;
	int mean_g;
	int mean_b;

	std::list<Pixel*> pixels;
};
