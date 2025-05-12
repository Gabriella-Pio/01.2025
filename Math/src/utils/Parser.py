def validate_expression(expr: str):
    try:
        # Testa se a expressão pode ser avaliada
        from sympy import sympify
        sympify(expr)
        return True
    except:
        return False
