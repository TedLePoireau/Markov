#include "pixel.hpp"
#include <iostream>

void pixel::print()
{
	std::cout << "Pixel (at x: ";
	std::cout << x << " y:";
	std::cout << y;
	std::cout << ") is R:" << r;
	std::cout << " G:" << g;	
	std::cout << " B:" << b;	
	std::cout << std::endl;	
}
