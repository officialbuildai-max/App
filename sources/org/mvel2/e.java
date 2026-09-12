package org.mvel2;

import org.mvel2.ast.ASTNode;
import org.mvel2.ast.LineLabel;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.n;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static ThreadLocal f72096a;

    public static Object a(boolean z10, CompiledExpression compiledExpression, Object obj, VariableResolverFactory variableResolverFactory) {
        org.mvel2.util.g gVar = new org.mvel2.util.g();
        ASTNode firstNode = compiledExpression.getFirstNode();
        if (firstNode == null) {
            return null;
        }
        do {
            try {
                try {
                    if (firstNode.fields != -1) {
                        if (gVar.g()) {
                            gVar.q(firstNode.getReducedValueAccelerated(obj, obj, variableResolverFactory));
                        }
                        if (variableResolverFactory.tiltFlag()) {
                            return gVar.n();
                        }
                        Integer operator = firstNode.getOperator();
                        int intValue = operator.intValue();
                        if (intValue != -1) {
                            if (intValue != 37) {
                                if (intValue == 99) {
                                    variableResolverFactory.setTiltFlag(true);
                                    return gVar.n();
                                }
                                if (intValue == 29) {
                                    if (!gVar.p().booleanValue()) {
                                        while (true) {
                                            ASTNode aSTNode = firstNode.nextASTNode;
                                            if (aSTNode == null) {
                                                break;
                                            }
                                            try {
                                                if (aSTNode.isOperator(30)) {
                                                    firstNode = aSTNode;
                                                    break;
                                                }
                                                firstNode = aSTNode;
                                            } catch (NullPointerException e11) {
                                                e = e11;
                                                firstNode = aSTNode;
                                                if (firstNode == null || !firstNode.isOperator() || firstNode.nextASTNode == null) {
                                                    throw e;
                                                }
                                                throw new CompileException("incomplete statement: " + firstNode.getName() + " (possible use of reserved keyword as identifier: " + firstNode.getName() + ")", firstNode.getExpr(), firstNode.getStart());
                                            }
                                        }
                                    }
                                    gVar.b();
                                } else {
                                    if (intValue == 30) {
                                        return gVar.n();
                                    }
                                    gVar.r(firstNode.nextASTNode.getReducedValueAccelerated(obj, obj, variableResolverFactory), operator);
                                    while (gVar.h()) {
                                        try {
                                            if (((Integer) gVar.k()).intValue() == 23) {
                                                gVar.n();
                                                Object n11 = gVar.n();
                                                Object n12 = gVar.n();
                                                if (n.k(n12) && n.k(n11)) {
                                                    gVar.q(null);
                                                }
                                                gVar.b();
                                                if (!n.k(n12)) {
                                                    n11 = n12;
                                                }
                                                gVar.q(n11);
                                            } else {
                                                gVar.i();
                                            }
                                        } catch (ClassCastException e12) {
                                            throw new CompileException("syntax error or incomptable types", new char[0], 0, e12);
                                        } catch (CompileException e13) {
                                            throw e13;
                                        } catch (Exception e14) {
                                            throw new CompileException("failed to compileShared sub expression", new char[0], 0, e14);
                                        }
                                    }
                                }
                            } else if (firstNode.nextASTNode != null) {
                                gVar.b();
                            }
                        }
                    } else if (z10 || (z10 = b())) {
                        try {
                            ((j10.b) f72096a.get()).a((LineLabel) firstNode, variableResolverFactory, compiledExpression);
                        } catch (NullPointerException unused) {
                        }
                    }
                    firstNode = firstNode.nextASTNode;
                } catch (NullPointerException e15) {
                    e = e15;
                }
            } finally {
                org.mvel2.optimizers.b.a();
            }
        } while (firstNode != null);
        return gVar.k();
    }

    public static boolean b() {
        ThreadLocal threadLocal = f72096a;
        return (threadLocal == null || threadLocal.get() == null) ? false : true;
    }
}
