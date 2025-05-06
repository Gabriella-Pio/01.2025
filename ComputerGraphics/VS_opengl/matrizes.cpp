#include<iostream>
#include<glm/glm.hpp>
#include<glm/gtx/string_cast.hpp>

using namespace std;

int main() {

	/*glm::mat4 M;

	cout << glm::to_string(M);*/

	glm::mat4 I = glm::identity<glm::mat4>();

	cout << "matriz identidade" << endl;
	cout << glm::to_string(I);

	cout << endl;
	cout << endl;
	cout << endl;


}