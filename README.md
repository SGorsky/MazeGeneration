# MazeGeneration (Open as RAW)

This algorithm can be used to create a perfect maze in Java (only 1 path between any two points)
The size of the maze must be odd in order to prevent the outer wall from looking something like this:

Maze Size: 10*10
XXXXXXXXXX
X     X XX
XXXXX X XX
X   X X XX
X X X X XX
X X X X XX
X XXX X XX
X       XX
XXXXXXXXXX
XXXXXXXXXX

Maze Size: 11*11
XXXXXXXXXXX
X X       X
X XXXXXXX X
X       X X
XXXXXXX X X
X   X   X X
X X X XXX X
X X X   X X
X X XXX X X
X X       X
XXXXXXXXXXX

Start with a grid of walls
Pick a random point (I used {1, 1} ) and set it to empty. This cell is your current cell
Add that point to a stack of cell locations
While the stack is not empty
  Get the cells that are two above, below, left and right of the current cell if they are in the maze and are walls
    Pick a random neighbouring cell. 
    Set that cell to an empty cell and set the cell in between your current cell and the chosen cell to empty
    Set your current cell to the chosen cell's location and add that location to the top of a stack
  If there are no cells to choose from
    Pop the stack and set the removed element as your current cell

Here is the algorithm implemented on a 9*9 maze: 
XXXXXXXXX				XXXXXXXXX				XXXXXXXXX				XXXXXXXXX
X XXXXXXX				X XXXXXXX				X XXXXXXX				X XXXXXXX
X XXXXXXX				X XXXXXXX				X XXXXXXX				X XXXXXXX
X XXXXXXX				X   XXXXX				X   XXXXX				X   XXXXX
XXXXXXXXX				XXXXXXXXX				XXX XXXXX				XXX XXXXX
XXXXXXXXX				XXXXXXXXX				XXX XXXXX				XXX   XXX
XXXXXXXXX				XXXXXXXXX				XXXXXXXXX				XXXXXXXXX
XXXXXXXXX				XXXXXXXXX				XXXXXXXXX				XXXXXXXXX
XXXXXXXXX				XXXXXXXXX				XXXXXXXXX				XXXXXXXXX

XXXXXXXXX       XXXXXXXXX       XXXXXXXXX       XXXXXXXXX
X XXXXXXX       X XXXXXXX       X XXXXXXX       X XXXXXXX
X XXXXXXX       X XXXXXXX       X XXXXXXX       X XXXXXXX
X   XXXXX       X   XXXXX       X   XXXXX       X   XXX X
XXX XXXXX       XXX XXXXX       XXX XXXXX       XXX XXX X
XXX   XXX       XXX   XXX       XXX   X X       XXX   X X
XXXXX XXX       XXXXX XXX       XXXXX X X       XXXXX X X
XXXXX XXX       XXXXX   X       XXXXX   X       XXXXX   X
XXXXXXXXX       XXXXXXXXX       XXXXXXXXX       XXXXXXXXX

XXXXXXXXX       XXXXXXXXX       XXXXXXXXX       XXXXXXXXX
X XXXXX X       X XXX   X       X X     X       X X     X
X XXXXX X       X XXXXX X       X XXXXX X       X XXX X X
X   XXX X       X   XXX X       X   XXX X       X   X X X
XXX XXX X       XXX XXX X       XXX XXX X       XXX XXX X
XXX   X X       XXX   X X       XXX   X X       XXX   X X
XXXXX X X       XXXXX X X       XXXXX X X       XXXXX X X
XXXXX   X       XXXXX   X       XXXXX   X       XXXXX   X
XXXXXXXXX       XXXXXXXXX       XXXXXXXXX       XXXXXXXXX

XXXXXXXXX       XXXXXXXXX       XXXXXXXXX
X X     X       X X     X       X X     X
X XXX X X       X XXX X X       X XXX X X
X   X X X       X   X X X       X   X X X
XXX XXX X       XXX XXX X       XXX XXX X
XXX   X X       XXX   X X       X X   X X
XXXXX X X       XXXXX X X       X XXX X X
XXX     X       X       X       X       X
XXXXXXXXX       XXXXXXXXX       XXXXXXXXX
