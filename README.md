# type-renderers-test

### Test task for Type Renderers for Python project

The first problem solution located in `PrintVars` folder. `main.py` contains `print_vars` 
function that prints whether a variable is an instance of a built-in type for each variable
defined in the function from which it is called.

Code example:

```
a = 10
b = numpy.zeros((3, 4))
print_vars()
```

Output: 

```
a : True
b : False
```



The second problem solution located in `Timer` project.

To run the application use `./gradlew run`. 

The program reads the path to the python executable and runs `$path -m timeit -r 10` command.
While the command is being executed, the number of seconds from the start of execution is printed.

Input:

```
Enter python executable path: /usr/bin/python3
```

Output:
```
0
1
2
3
OUTPUT:
50000000 loops, best of 10: 5.8 nsec per loop
```