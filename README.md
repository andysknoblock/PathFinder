# PathFinder
This application counts the number of possible paths from the upper right hand corner of the grid to the bottom left hand corner by moving only right and down.  
This application can create a randomized grid (and will store the grid file) of a grid. The format of a .grd file is a series of ones and zeroes seperated by commas. Zeroes indicate spaces, ones represent blocks.  
An example grid file (.grd) may look like this:  
0,0,1,1  
0,0,0,1   
1,0,0,0  
1,0,0,0  
The application would then be able to read from this file and count the number of paths from the top right to the bottom left.  
![PathFinder in terminal](https://github.com/andysknoblock/PathFinder/blob/master/PathFinder.png)
