#include "cluster.hpp"
#define abs(x) (x<0?(-1)*x:x)

int Cluster::dist(Pixel *p)
{
	int res = 0;

	res += abs(mean_r - p->r);
	res += abs(mean_g - p->g);
	res += abs(mean_b - p->b);

	return res;
}

void Cluster::update_means()
{
	unsigned long long r = 0, g = 0, b = 0, nb = 0;
	for (Pixel *p : pixels)
	{
		nb++;
		r+=p->r;
		g+=p->g;
		b+=p->b;		
	}

	mean_r = r/nb;
	mean_g = g/nb;
	mean_b = b/nb;
}
