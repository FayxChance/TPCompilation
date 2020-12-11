package fr.usmb.m1isc.compilation.tp;

import java.util.HashSet;
import java.util.Set;

public class Node {
    public enum NodeType {SEQUENCE, EXPRESSION, EXPR, VAR, INT, OUTPUT, INPUT, NIL}

    public static int COMPTEUR_BOUCLE = 0;
    public static int COMPTEUR_COND = 0;
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
        if ((this._t) == NodeType.EXPRESSION && (this._v) == "let") {
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
                return genererExpression();
            case EXPR:
                return genererExpr();
            case VAR:
            case INT:
                return "\t\tmov eax, " + this._v + "\n" +
                        "\t\tpush eax\n";
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

    public String genererExpression() {
        String res = "";
        switch (this._v) {
            case "let":
                String fils_droit = this._right.generer();
                res +=
                        fils_droit +
                                "\t\tmov " + this._left._v +
                                ", eax\n"
                ;
                break;
            case "while":
                String cond = "\tdebut_while_" + "yolo" + ":\n";
                break;
        }


        return res;
    }

    public String genererExpr() {
        String res = "";
        String expressionGauche;
        String expressionDroite;
        switch (this._v) {
            case "+":
                expressionGauche = this._left.generer();
                expressionDroite = this._right.generer();
                res += expressionGauche + expressionDroite +
                        "\t\tpop ebx\n" +
                        "\t\tpop eax\n" +
                        "\t\tadd eax, ebx\n" +
                        "\t\tpush eax\n";
                break;
            case "-":
                expressionGauche = this._left.generer();
                expressionDroite = this._right.generer();
                res += expressionGauche + expressionDroite +
                        "\t\tpop ebx\n" +
                        "\t\tpop eax\n" +
                        "\t\tsub eax, ebx\n" +
                        "\t\tpush eax\n";
                break;
            case "*":
                expressionGauche = this._left.generer();
                expressionDroite = this._right.generer();
                res += expressionGauche + expressionDroite +
                        "\t\tpop ebx\n" +
                        "\t\tpop eax\n" +
                        "\t\tmul eax, ebx\n" +
                        "\t\tpush eax\n";
                break;
            case "/":
                expressionGauche = this._left.generer();
                expressionDroite = this._right.generer();
                res += expressionGauche + expressionDroite +
                        "\t\tpop ebx\n" +
                        "\t\tpop eax\n" +
                        "\t\tdiv eax, ebx\n" +
                        "\t\tpush eax\n";
                break;
        }
        return res;
    }
}
