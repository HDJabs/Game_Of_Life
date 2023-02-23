public class NodeException extends GameOfLifeException{
    public NodeException(String s){
        super(s);
    }

    public NodeException(int x, int y){
        String s = "";
        if(x==0&&y==0)
            throw new NodeException("Cannot select the current node (0, 0)");
        if(x<-1 || x>1)
            s = s + x; 
        if(y<-1 || y>1){
            if(s.equals(x))
                s = s + " and ";
            s = s + y;
        }

        s = s + " is invalid for binary compass index (-1, 0, or 1)";
        throw new NodeException(s);
    }
}
