#include <iostream>
#include <glm/glm.hpp>
#include <glm/gtx/string_cast.hpp>
#include <iomanip>


using namespace std;

void PrintMatrix(const glm::mat4& M)
{
	for (int j = 0; j < 4; ++j)
	{
		for (int i = 0; i < 4; ++i)
		{
			std::cout
				<< std::setw(10)
				<< std::setprecision(4)
				<< std::fixed
				<< M[i][j] << " ";
		}

		std::cout << std::endl;
	}
}


void TranslationMatrix() {
	cout << endl;
	cout << "===========================================" << endl;
	cout << "              Matriz de Translacao			" << endl;
	cout << "===========================================" << endl;

	// Matriz Gen�rica - sem inicializa��o
	glm::mat4 M;
	PrintMatrix(M);

	// Matriz Inicializada com a Matriz Identidade
	glm::mat4 I = glm::identity<glm::mat4>();

	cout << endl;
	cout << endl;

	cout << " Matriz de Identidade  " << endl;
	PrintMatrix(I);

	cout << endl;
	cout << endl;

	// Dist�ncia a transladar (movimentar)
	glm::vec3 T {20.0, 20.0, 20.0};

	cout << "===============================================================" << endl;
	cout << "MOVIMENTAR: " << glm::to_string(T) << endl;
	cout << "===============================================================" << endl;

	// Montagem da Matriz Composta (identidade e Dist�ncia a transladar)
	glm::mat4 Translation = glm::translate(I, T);

	cout << endl;
	cout << endl;

	cout << " Matriz Montada para Movimentacao  " << endl;
	PrintMatrix(Translation);

	// Posi��o atual do ponto no espa�o
	glm::vec4 Position{10.0, 10.0, 10.0, 1};

	cout << endl;
	cout << endl;


	cout << "===============================================================" << endl;
	cout << "PONTO NO ESPACO: " << glm::to_string(Position) << endl;
	cout << "===============================================================" << endl;

	// Matriz Composta (Identidade + Deslocamento) | Aplicada no ponto no espa�o
	Position = Translation * Position;

	cout << endl;
	cout << endl;

	// Impress�o na tela da nova posi��o
	cout << "===============================================================" << endl;
	cout << "Apos a aplicacao da Matriz Montada (Identidade + Movimentacao" << endl;
	cout << "NOVA POSICAO DO PONTO: " << glm::to_string(Position) << endl;
	cout << "===============================================================" << endl;
}

void ScaleMatrix(){
	cout << endl;
	cout << "===========================================" << endl;
	cout << "              Matriz de Escala				" << endl;
	cout << "===========================================" << endl;

	//Matriz Identidade
	glm::mat4 I = glm::identity<glm::mat4>();
	cout << endl;
	cout << endl;

	cout << " Matriz de Identidade  " << endl;
	PrintMatrix(I);

	cout << endl;
	cout << endl;

	// Propor��o a aumentar
	glm::vec3 ScaleAmount {2.0, 2.0, 2.0};

	cout << "===============================================================" << endl;
	cout << "ESCALAR: " << glm::to_string(ScaleAmount) << endl;
	cout << "===============================================================" << endl;


	//  Monta a Matriz Composta (identidade e Propor��o a aumentar)
	glm::mat4 Scale = glm::scale(I, ScaleAmount);

	cout << endl;
	cout << endl;

	cout << " Matriz Montada para Escala  " << endl;
	PrintMatrix(Scale);

	// Posi��o atual do ponto no espa�o
	glm::vec4 Position{10.0, 10.0, 10.0, 1};

	cout << endl;
	cout << endl;

	cout << "===============================================================" << endl;
	cout << "PONTO NO ESPACO: " << glm::to_string(Position) << endl;
	cout << "===============================================================" << endl;

	// Matriz Composta (Identidade + ESCALA) | Aplicada no ponto no espa�o
	// gerando uma nova posi��o
	Position = Scale * Position;

	cout << endl;
	cout << endl;

	// Impress�o na tela da nova posi��o j� ESCALADA
	cout << "===============================================================" << endl;
	cout << "Apos a aplicacao da Matriz Montada (Identidade + ESCALA" << endl;
	cout << "NOVA POSICAO DO PONTO ESCALAD: " << glm::to_string(Position) << endl;
	cout << "===============================================================" << endl;

}

void RotationMatrix() {

	cout << endl;
	cout << "===========================================" << endl;
	cout << "              Matriz de Rotacao			" << endl;
	cout << "===========================================" << endl;

	//Matriz Identidade
	glm::mat4 I = glm::identity<glm::mat4>();

	cout << endl;
	cout << endl;

	cout << " Matriz de Identidade  " << endl;
	PrintMatrix(I);

	cout << endl;
	cout << endl;

	float Angle = glm::radians(90.0f);
	glm::vec3 Axis{ 0, 0, 1};
	glm::mat4 Rotation = glm::rotate(I, Angle, Axis);

	PrintMatrix(Rotation);

	glm::vec4 Position{ 100, 0, 0, 1};

	cout << endl;
	cout << endl;

	cout << "Posicao Inicial do Ponto: " << endl;
	cout << glm::to_string(Position) << endl;

	cout << endl;
	cout << endl;

	Position = Rotation * Position;

	cout << "Posicao Final do Ponto: " << endl;
	cout << glm::to_string(Position) << endl;
}

void ComposedMatrices() {

	cout << endl;
	cout << "======================================================================================" << endl;
	cout << "              Matriz Composta - Translacao, Escala e Rotacao			" << endl;
	cout << "======================================================================================" << endl;



}

void ModelViewProjection() {

	cout << endl;
	cout << "===========================================" << endl;
	cout << "  Matriz de Molelo, Visualizcao e Projecao	" << endl;
	cout << "===========================================" << endl;


}

int main() {

	TranslationMatrix();
	ScaleMatrix();
	RotationMatrix();
	ComposedMatrices(); // Implementar

	ModelViewProjection(); // Implementar

	return 0;
}