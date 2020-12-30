package fr.usmb.m1isc.compilation.tp;

public class Node {
    public enum NodeType{SEQUENCE,EXPRESSION,EXPR, VAR, INT, OUTPUT, INPUT, NIL}
    public NodeType _t;
    public String _v;
    public Node _left,_right;

    public Node(NodeType t,String v){
            _t=t;
            _v=v;
            _left=null;
            _right=null;

    }
    public Node(NodeType t,String v,Node e1, Node e2){
        _t=t;
        _v=v;
        _left=e1;
        _right=e2;


    }
    @Override
    public String toString() {
        String str="";
        if (!(_left==null && _right==null))
            str = "(";

        str=str.concat(_v);

        if (_left != null) {
            str=str.concat(" "+_left.toString());
        }
        if (_right != null) {
            str=str.concat(" "+_right.toString());
        }
        if (!(_left==null && _right==null))
            str=str.concat(")");
        
        return str;
    }
}
