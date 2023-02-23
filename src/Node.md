Node is the cell in the Game of Life 
Can be on or off
Has 8 neighbors, as this node is used in 2D arrays. 

-alive : boolean
-xCord : int
-yCord : int
-neighborNodes : Node[3][3]

+Node() - Creates node with all null values. alive defaults to false.
+Node(x:int, y:int) - Creates node with coordinates set at x,y  , alive to false, and all else null.

+setNeighbor(neighbor:Node, x:int, y:int) : void - Sets neighbor at x,y to neighbor(Node). x and y must either be a -1, 0, or 1. Otherwise a   NodeException will be thrown. 0,0 will also throw the error.

+getNeighbor(x:int, y:int) : Node - Returns neighbor at the x,y spot in neighborNodes

+setLife(life : boolean) : void - Sets the alive state of the node. 
+isAlive() : boolean - return this.alive;

+getXCord() : int - return this.xCord;
+getYCord() : int - return this.yCord;
+setCords(x:int, y:int) : void - this.xCord=x; this.yCord=y;
+setXCord(x:int) : void - this.xCord=x;
+setYCord(y:int) : void - this.yCord=y;