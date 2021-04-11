from main import var_types
import unittest
import numpy


class Example:
    def __init__(self, a=10, b=100):
        self.a = a
        self.b = b


class TestVarsTypes(unittest.TestCase):
    def test_int(self):
        a = 1
        ans = var_types()
        self.assertTrue(ans["a"])

    def test_list(self):
        a = [1, 2, [100]]
        ans = var_types()
        self.assertTrue(ans["a"])

    def test_set(self):
        a = {1, 2, 4}
        ans = var_types()
        self.assertTrue(ans["a"])

    def test_custom_class(self):
        a = Example()
        ans = var_types()
        self.assertFalse(ans["a"])

    def test_numpy_array(self):
        a = numpy.array([1, 2, 4])
        ans = var_types()
        self.assertFalse(ans["a"])

    def test_custom_class_list(self):
        a = [Example(12), Example(13), Example(15)]
        ans = var_types()
        self.assertTrue(ans["a"])

    def test_lambda(self):
        func = lambda x: x * x
        ans = var_types()
        self.assertTrue(ans["func"])

    def test_several_vars(self):
        a = 1
        b = [1, 2]
        c = "dada"
        ans = var_types()
        self.assertTrue(ans["a"])
        self.assertTrue(ans["b"])
        self.assertTrue(ans["c"])

    def test_several_vars_custom(self):
        a = 1
        b = [1, 2]
        c = Example()
        d = numpy.zeros((3, 3))
        ans = var_types()
        self.assertTrue(ans["a"])
        self.assertTrue(ans["b"])
        self.assertFalse(ans["c"])
        self.assertFalse(ans["d"])
