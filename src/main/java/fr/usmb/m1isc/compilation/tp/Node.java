package fr.usmb.m1isc.compilation.tp;

public class Node {
    public String _v;
    public Node _left,_right;

    public Node(String v){
            _v=v;
            _left=null;
            _right=null;

    }
    public Node(String v,Node e1, Node e2){
        _v=v;
        _left=e1;
        _right=e2;

    }
    public Node(String v,Object e1, Object e2){
        _v=v;
        _left=(Node)e1;
        _right=(Node)e2;

    }
}
