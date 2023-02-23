NodeArray handles a 2D array of nodes. 
Responsible for throwing NodeArrayExceptions when the use fucks up.

-boardHeight : int
-boardWidth : int
-nodesArray : Node[][]

+NodeArray() - Create array. default of 10x10 all set to dead/false.

+setBoardHeight(h:int) : void - this.boardHeight=h;
+getBoardHeight() : int - return this.boardHeight;

+setBoardWidth(w:int) : void - this.boardWidth=w;
+getBoardWidth() : int - return this.boardWidth;

+getNodeAt(x:int, y:int) : Node - return nodesArray[x][y]; must be within bounds
+setNodeAt(x:int, y:int, newNode:Node) : void - You get it. must be within bounds

-initialize() : void - creates nodesArray. every node in array is set to default. Then another swoop gives the Nodes coordinates. and idk what next, i feel the order is important so i dont want to mess it up.
