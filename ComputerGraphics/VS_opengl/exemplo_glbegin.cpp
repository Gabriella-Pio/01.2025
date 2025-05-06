#include <GLFW/glfw3.h>
#include <glm/glm.hpp>
#include <iostream>


int main() {
    // 1. Inicializa a GLFW
    if (!glfwInit()) {
        std::cerr << "Erro ao inicializar GLFW!" << std::endl;
        return -1;
    }

    // 2. Cria uma janela GLFW com contexto OpenGL
    GLFWwindow* window = glfwCreateWindow(800, 600, "Triângulo Branco", NULL, NULL);
    if (!window) {
        std::cerr << "Erro ao criar a janela!" << std::endl;
        glfwTerminate();
        return -1;
    }
    glfwMakeContextCurrent(window);  // Define o contexto OpenGL

    // 3. Loop de renderização
    while (!glfwWindowShouldClose(window)) {

        // 4. Define a cor de fundo e limpa a tela
        glClearColor(1.0f, 0.0f, 0.0f, 1.0f); // Fundo preto
        glClear(GL_COLOR_BUFFER_BIT);

        // 5. Renderiza um triângulo branco
        glBegin(GL_TRIANGLES);
            glVertex2f(-0.5f, -0.5f);
            glVertex2f(0.5f, -0.5f);
            glVertex2f(0.0f, 0.5f);
        glEnd();

        // 6. Atualiza a tela
        glfwSwapBuffers(window);
        glfwPollEvents();
    }

    // 7. Encerra a aplicação
    glfwDestroyWindow(window);
    glfwTerminate();
    return 0;
}
