public class Node {
    private boolean alive;
    private int xCord;
    private int yCord;
    private Node[][] neighborNodes;

    //array handelr calss should handle out of cordinate errors, as this class does not know the size of the board

    public Node(){
        initialize();
    }

    public void setNeighborAt(int x, int y, Node neighbor){//-1, 0, or 1
        if(   !((x==-1||x==0||x==1)&&(y==-1||y==0||y==1)) ) //Meaning not a -1, 0, or 1. Can be optimized
            throw new NodeException(x, y);
        if(x==0&&y==0)
            throw new NodeException(x, y);
        x++;y++;
        neighborNodes[x][y] = neighbor;
    }

    public Node getNeighbor(int x, int y){//-1, 0, or 1
        x--; y--;
        if(   !((x==-1||x==0||x==1)&&(y==-1||y==0||y==1)) ) //Meaning not a -1, 0, or 1. Can be optimized
            throw new NodeException(x, y);
        if(x==0&&y==0)
            throw new NodeException(x, y);
        
        return neighborNodes[x][y];
    }

    public int getNumberOfAliveNeighbors() {
        int alive =0;
        for(Node[] nodes : neighborNodes)
            for(Node node : nodes)
                if(node!=null)
                    if(node.isAlive())
                        alive++;
        return alive;
    }
    
    public void setLife(boolean life){
        this.alive = life;
    }
    public boolean isAlive(){
        return this.alive;
    }
    public int getXCord(){
        return this.xCord;
    }
    public int getYCord(){
        return this.yCord;
    }
    public void setCords(int x, int y){
        this.xCord = x;
        this.yCord = y;
    }
    public void setXCord(int x){
        this.xCord = x;
    }
    public void setYCord(int y){
        this.yCord = y;
    }
    
    private void initialize(){
        this.alive=false;
        this.xCord=-1;//meaning null
        this.yCord=-1;//meaning null
        this.neighborNodes = new Node[3][3];
        for(Node[] nodes : neighborNodes)
            for(Node node : nodes)
                if(node!=this)
                    node = null;
    }

}
