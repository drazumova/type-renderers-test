from __future__ import annotations
import sys
from typing import Dict


def var_types(frame_depth :int = 1) -> Dict[str, bool]:
    """For each variable defined in the stack frame, it is determined whether it is an instance of a built-in type"""
    
    frame = sys._getframe(frame_depth)
    all_vars = frame.f_locals

    builtin_type = {}
    for (var_name, var_value) in all_vars.items():
        builtin_type[var_name] = var_value.__class__.__module__ == "builtins"
    return builtin_type


def print_vars():
    types = var_types(2)
    for (name, is_builtin) in types.items():
        print(name, ":", is_builtin)

