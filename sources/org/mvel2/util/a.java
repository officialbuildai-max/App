package org.mvel2.util;

import org.mvel2.ast.ASTNode;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.OperatorNode;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ASTNode f72156a;

    /* renamed from: b, reason: collision with root package name */
    private a f72157b;

    /* renamed from: c, reason: collision with root package name */
    private a f72158c;

    public a(ASTNode aSTNode) {
        this.f72156a = aSTNode;
    }

    public static a b(ASTIterator aSTIterator) {
        ASTLinkedList aSTLinkedList = new ASTLinkedList(aSTIterator.firstNode());
        a aVar = new a(aSTLinkedList.nextNode());
        while (aSTLinkedList.hasMoreNodes()) {
            ASTNode nextNode = aSTLinkedList.nextNode();
            if (!(nextNode instanceof EndOfStatement)) {
                aVar = aVar.a(nextNode);
            } else if (aSTLinkedList.hasMoreNodes()) {
                aVar = new a(aSTLinkedList.nextNode());
            }
        }
        return aVar;
    }

    private int c(ASTNode aSTNode, ASTNode aSTNode2) {
        boolean z10 = aSTNode instanceof OperatorNode;
        if (!z10 && !(aSTNode2 instanceof OperatorNode)) {
            return 0;
        }
        if (!z10 || !(aSTNode2 instanceof OperatorNode)) {
            return z10 ? -1 : 1;
        }
        int[] iArr = org.mvel2.f.f72097a;
        return iArr[((OperatorNode) aSTNode).getOperator().intValue()] - iArr[((OperatorNode) aSTNode2).getOperator().intValue()];
    }

    public a a(ASTNode aSTNode) {
        if (c(this.f72156a, aSTNode) >= 0) {
            a aVar = new a(aSTNode);
            aVar.f72157b = this;
            return aVar;
        }
        if (this.f72157b == null) {
            throw new RuntimeException("Missing left node");
        }
        a aVar2 = this.f72158c;
        if (aVar2 == null) {
            this.f72158c = new a(aSTNode);
        } else {
            this.f72158c = aVar2.a(aSTNode);
        }
        return this;
    }

    public Class d(boolean z10) {
        ASTNode aSTNode = this.f72156a;
        if (!(aSTNode instanceof OperatorNode)) {
            return aSTNode.getEgressType();
        }
        a aVar = this.f72157b;
        if (aVar == null || this.f72158c == null) {
            throw new RuntimeException("Malformed expression");
        }
        Class d11 = aVar.d(z10);
        Class d12 = this.f72158c.d(z10);
        int intValue = ((OperatorNode) this.f72156a).getOperator().intValue();
        if (intValue != 0) {
            if (intValue != 1 && intValue != 2 && intValue != 3) {
                if (intValue == 4) {
                    if (!z10 || d.b(d11, d12)) {
                        return Integer.class;
                    }
                    throw new RuntimeException("Associative operation requires compatible types. Found " + d11 + " and " + d12);
                }
                if (intValue == 21 || intValue == 22) {
                    if (z10) {
                        if (d11 != Boolean.class && d11 != Boolean.TYPE) {
                            throw new RuntimeException("Left side of logical operation is not of type boolean. Found " + d11);
                        }
                        if (d12 != Boolean.class && d12 != Boolean.TYPE) {
                            throw new RuntimeException("Right side of logical operation is not of type boolean. Found " + d12);
                        }
                    }
                    return Boolean.class;
                }
                switch (intValue) {
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        if (!z10 || d.a(d11, d12)) {
                            return Boolean.class;
                        }
                        throw new RuntimeException("Comparison operation requires compatible types. Found " + d11 + " and " + d12);
                    case 18:
                    case 19:
                        if (!z10 || d.b(d11, d12)) {
                            return Boolean.class;
                        }
                        throw new RuntimeException("Comparison operation requires compatible types. Found " + d11 + " and " + d12);
                    default:
                        switch (intValue) {
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                                return Boolean.class;
                            case NOTIFICATION_REDIRECT_VALUE:
                                if (!z10 || d11 == Boolean.class || d11 == Boolean.TYPE) {
                                    return d12;
                                }
                                throw new RuntimeException("Condition of ternary operator is not of type boolean. Found " + d11);
                            case 30:
                                if (!z10 || d.b(d11, d12)) {
                                    return d11;
                                }
                                throw new RuntimeException("Associative operation requires compatible types. Found " + d11 + " and " + d12);
                            default:
                                return this.f72156a.getEgressType();
                        }
                }
            }
        } else if (d11.equals(String.class) || d12.equals(String.class)) {
            return String.class;
        }
        if (!z10 || d.b(d11, d12)) {
            return Double.class;
        }
        throw new RuntimeException("Associative operation requires compatible types. Found " + d11 + " and " + d12);
    }
}
