# sorting-algorithms
This is a small repository that contains implementation of the following sorting algorithms in java:
<ul>
<li>Heap sort</li>
<li>Insertion sort</li>
<li>Merge sort</li>
<li>Quick sort</li>
<li>Radix sort</li>
<li>Selection sort</li>
</ul>
We then display the number of movements, comparisons and duration required to sort a dataset containing an array of 10000 integers.
<br>
The intergers are in one of the following patterns:
<ul>
<li>Ordered -> This are arrays arranged in ascending order from 1-10000</li>
<li>Reverse Order -> This is a reverse of in the ordered arrays where the integers are in descending order from 10000-1</li>
<li>Almost Ordered -> This is an array resembling the Ordered array but with a random 100 numbers swapped in position</li>
<li>Unordered/Random -> A random array is created by using Collections.shuffle(list) where list contains integers from 1-10000</li>
</ul>

# Setting Up
The project has a javaFx GUI for ease in observing the analysis of the sorting algorithms.

## Requirements
<ul>
<li>Java >= version 11</li>
<li>JavaFx</li>
</ul>

## Running
`$ git clone https://github.com/vikie1/sorting-algorithms.git` - Clone the repository <br>
`$ cd sorting-algorithms`<br>
`$ javac --module-path=/path/to/javafx/lib --add-modules=ALL-MODULE-PATH algo/javaFxGUI/MainGuiFile.java` -> This is not necessary because all files have been compiled but you can use it in case you are not on java 11<br>
`$ java --module-path=/usr/share/openjfx/lib --add-modules=ALL-MODULE-PATH  algo.javaFxGUI.MainGuiFile` -> This is how you will run the application and interact with the GUI

### Note
The Quick sort algorithm might provide a stackoverflow error. This is fine you just have to increase the allocated memory from the JVM or change the Quick sort implementation from recursive funnctions to loops.
