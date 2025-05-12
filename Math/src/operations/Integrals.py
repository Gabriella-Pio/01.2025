from sympy import symbols, integrate

def indefinite_integral(expr: str):
    x = symbols('x')
    expression = eval(expr)
    return integrate(expression, x)

def definite_integral(expr: str, lower: float, upper: float):
    x = symbols('x')
    expression = eval(expr)
    return integrate(expression, (x, lower, upper))