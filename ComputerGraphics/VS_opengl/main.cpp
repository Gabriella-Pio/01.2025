#include <iostream>
#include <GL/glew.h>
#include <GLFW/glfw3.h>
const int Width = 800;
const int Heigth = 600;
int main() {
	//std::cout << "Hello World!" << std::endl;
	if (!glfwInit()) {
		std::cout << "Erro de Inicialização do GLEW" << std::endl;
		return -1;
	}

	GLFWwindow* Window = glfwCreateWindow(Width, Heigth, "Nova Janela", nullptr, nullptr);
	if (!Window) {
		std::cout << "Erro ao criar janela" << std::endl;
		return -1;
	}

	glfwMakeContextCurrent(Window);

	if (glewInit() != GLEW_OK) {
		std::cout << "Erro ao inicializar a GLEW" << std::endl;
		glfwTerminate();
		return -1;
	}

	std::cout << "Fabricante OpenGL: " << glGetString(GL_VENDOR) << std::endl;
	std::cout << "Renderizador OpenGL: " << glGetString(GL_RENDERER) << std::endl;
	std::cout << "Versão OpenGL: " << glGetString(GL_VERSION) << std::endl;

	//O código deve ficar preso em um loop
	while (!glfwWindowShouldClose(Window)) { //false por padrão
		glfwPollEvents(); //Processa todos os eventos da fila
		glfwSwapBuffers(Window); //Envia o backbuffer para ser desenhado na tela
	}

	return 0;

}