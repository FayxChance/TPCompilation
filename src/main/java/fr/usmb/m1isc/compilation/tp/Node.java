package fr.usmb.m1isc.compilation.tp;

public class Node {
    enum NodeType{ENTIER, STRING, SIGNE }
    public String _v;
    public Node _left,_right;
    public NodeType _type;

    public Node(String v){
            _v=v;
            _left=null;
            _right=null;

    }
}
