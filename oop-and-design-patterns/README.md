# Package Challenge

Application accept an argument is a path of a file and then return list item's index with the total cost is maximum

Application can extend with multiple Parser (Text, Csv, Excel...) and multiple Exporter (Text, PDF, Excel...)

Project uses maven shade plugin for building an uber-jar for facility using

## Documentation
### Class Diagram
![alt text](docs/class_diagram.png?raw=true "Package Challenge Class Diagram")

## Imperative programming

1. Input text absolute/relative file path
2. Parse
3. Run algorithm
4. Print result System Out

## Algorithm
    
    Knapsack 01 dynamic programming solution
    Time complexity: O(nW)
    n: number of items
    W: capacity of package (Max weight)

## Design patterns
    
    Factory method
    Singleton
    Strategy
    Builder

## Test coverage

    96% classes
    91% lines covered

![alt text](docs/test_coverage.png?raw=true "Test Coverage")
