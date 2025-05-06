#include <iostream>
#include <glm/glm.hpp>
#include <glm/gtx/string_cast.hpp>

int main() {
	glm::vec3 Point1{ 10.0f, 10.0f, 0.0f };
	glm::vec3 Point2{ 10.0f, 10.0f, 10.0f };

	glm::vec3 Point3 = Point1 + Point2;
	glm::vec3 Point4 = Point1 - Point2;

	std::cout << "Soma: " << glm::to_string(Point3) << std::endl;
	std::cout << "Subtração: " << glm::to_string(Point4) << std::endl;
}