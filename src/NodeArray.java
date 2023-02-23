import javax.naming.InitialContext;

public class NodeArray {
    private int boardHeight =-1;
    private int boardWidth =-1;
    private Node[][] nodesArray; //nodesArray[x][y]

    public NodeArray(){
        initialize();
    }

    private void initialize(){
        this.boardHeight = 10;
        this.boardWidth = 10;
        initializeNodeArray();
    }

    private void initializeNodeArray(){
        this.nodesArray = new Node[this.boardWidth][this.boardHeight];
        for(int x=0; x<this.boardWidth; x++){
            for(int y=0; y<this.boardHeight; y++){
                Node node = new Node();
                node.setCords(x, y);
                node.setLife(false);
                nodesArray[x][y] = node;
                

            }
        }

        for(int x=0; x<this.boardWidth; x++){
            for(int y=0; y<this.boardHeight; y++){
                Node node = nodesArray[x][y];

                for(int xind=-1; xind<=1; xind++){
                    for(int yind=-1; yind<=1; yind++){
                        try{
                            if(x+xind<0||x+xind>this.getBoardWidth()-1||y+yind<0||y+yind>this.getBoardHeight()-1)
                                throw new NodeArrayException(x + " or " + y + " is invalid for the board size");
                            if(node==null)
                                throw new NodeArrayException("node is null");
                            node.setNeighborAt(xind, yind, nodesArray[x+xind][y+yind]);
                        }
                        catch(GameOfLifeException e){
                            //System.out.println(e);
                        }
                    }
                }

            }
        }
        
    }

    public void setBoardHeight(int h){
        this.boardHeight = 10;
        if(h>10)
            this.boardHeight = h;
        initializeNodeArray();
    }

    /*
     * @return y
     */
    public int getBoardHeight(){
        return this.boardHeight;
    }

    
    public void setBoardWidth(int w){
        this.boardWidth = 10;
        if(w>10)
            this.boardWidth = w;
        initializeNodeArray();
    }
    /*
     * @return x
     */
    public int getBoardWidth(){
        return this.boardWidth;
    }

    public Node getNodeAt(int x, int y){
        checkBounds(x, y);
        return nodesArray[x][y];
    }

    public void setNodeAt(int x, int y, Node newNode){
        checkBounds(x, y);
        nodesArray[x][y] = newNode;
    }

    private void checkBounds(int x, int y){
        if(x<0||x>this.boardWidth||y<0||y>this.boardHeight)
            throw new NodeArrayException(x + " or " + y + " is out of bounds for height,width: " +this.boardHeight+","+this.boardWidth + ".");
    }
}
