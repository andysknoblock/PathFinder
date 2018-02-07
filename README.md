# PathFinder
This application counts the number of possible paths from the upper right hand corner of the grid to the bottom left hand corner by moving only right and down. 
This application can create a randomized grid (and will store the grid file) of a grid. The format of a .grd file is a series of 1's and 0's seperated by commas/ Zeroes indicate spaces, ones represent blocks. 
An example grid file (.grd) may look like this:__
0,0,1,1__
0,0,0,1__
1,0,0,0__
1,0,0,0__
The application would then be able to read from this file and count the number of paths from the top right to the bottom left.
