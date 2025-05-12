import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))

import unittest
from operations.Derivatives import derivative, second_derivative

class TestDerivatives(unittest.TestCase):
    def test_derivative(self):
        self.assertEqual(str(derivative("x**2")), "2*x")

    def test_second_derivative(self):
        self.assertEqual(str(second_derivative("x**2")), "2")

if __name__ == '__main__':
    unittest.main()
