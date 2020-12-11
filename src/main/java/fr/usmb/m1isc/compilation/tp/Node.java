package fr.usmb.m1isc.compilation.tp;

import java.util.HashSet;
import java.util.Set;

public class Node {
    public enum NodeType {SEQUENCE, EXPRESSION, EXPR, VAR, INT, OUTPUT, INPUT, NIL}

    public NodeType _t;
    public String _v;
    public Node _left, _right;

    public Node(NodeType t, String v) {
        _t = t;
        _v = v;
        _left = null;
        _right = null;

    }

    public Node(NodeType t, String v, Node e1, Node e2) {
        _t = t;
        _v = v;
        _left = e1;
        _right = e2;


    }
    @Override
    public String toString() {
        String str="";
        if (!(_left==null && _right==null))
            str = "(";

        str = str.concat(_v);

        if (_left != null) {
            str = str.concat(" " + _left.toString() + " ");
        }
        if (_right != null) {
            str = str.concat(" " + _right.toString() + " ");
        }
        if (!(_left == null && _right == null))
            str = str.concat(")");

        return str;
    }

    public Set<String> getLet() {

        Set<String> s = new HashSet<String>();
        if ((this._t) == NodeType.EXPRESSION) {
            s.add(this._left._v);
        }
        Set<String> setLeft = this._left != null ? this._left.getLet() : null;
        Set<String> setRight = this._right != null ? this._right.getLet() : null;
        if (setLeft != null)
            s.addAll(setLeft);
        if (setRight != null)
            s.addAll(setRight);
        return s;
    }

    public String generer() {
        switch (this._t) {
            case SEQUENCE:
                return genererExpr();
            case EXPRESSION:
                return genererExpr();
            case EXPR:
                return genererExpr();
            case VAR:
                return genererExpr();
            case INT:
                return genererExpr();
            case OUTPUT:
                return genererExpr();
            case INPUT:
                return genererExpr();
            case NIL:
                return genererExpr();
            default:
                return genererExpr();
        }

    }

    public String genererExpr() {

        return "";
    }
}
