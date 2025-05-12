from sympy import symbols, diff

#Define a derivada -> 
def derivative(expr: str):
    x = symbols('x')
    expression = eval(expr)
    return diff(expression, x)

def second_derivative(expr: str):
    x = symbols('x')
    expression = eval(expr)
    return diff(expression, x, 2)