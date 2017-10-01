# HuffmanEncoder

Utilises a simple Depth First Search in order to [encode](https://en.wikipedia.org/wiki/Huffman_coding) a random variable.

**Example code with alphabet of size 3:**

| P    | Code |
|------|------|
| 0.0  | 1    |
| 0.02 | 2    |
| 0.03 | 01   |
| 0.04 | 02   |
| 0.04 | 001  |
| 0.11 | 002  |
| 0.23 | 0000 |
| 0.26 | 0001 |
| 0.27 | 0002 |

#### Compile program:

```
> javac HuffmanEncoder.java Node.java Code.java Main.java
```

#### Run program:

```
> java Main
```

**Parameters:**

- PMF of random variable.
- Size of alphabet to encode with.
