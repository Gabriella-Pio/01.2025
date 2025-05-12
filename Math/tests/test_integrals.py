import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))

import unittest
from operations.Integrals import indefinite_integral, definite_integral

'''
class TestIntegrals(unittest.TestCase):
    def test_indefinite_integral(self):
        self.assertEqual(str(indefinite_integral("")), "")

    def test_definite_integral(self):
        self.assertEqual(str(definite_integral("")), "")

if __name__ == '__main__':
    unittest.main()
'''