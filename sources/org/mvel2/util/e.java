package org.mvel2.util;

import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.BinaryOperation;
import org.mvel2.ast.BooleanNode;
import org.mvel2.ast.Contains;
import org.mvel2.ast.Convertable;
import org.mvel2.ast.Instance;
import org.mvel2.ast.IntAdd;
import org.mvel2.ast.IntDiv;
import org.mvel2.ast.IntMult;
import org.mvel2.ast.IntSub;
import org.mvel2.ast.RegExMatchNode;
import org.mvel2.ast.Soundslike;
import org.mvel2.ast.Strsim;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ClassImportResolverFactory;

/* loaded from: classes7.dex */
public class e {
    private static BinaryOperation a(int i11, ASTNode aSTNode, ASTNode aSTNode2, ParserContext parserContext) {
        return (aSTNode.getEgressType() == Integer.class && aSTNode2.getEgressType() == Integer.class) ? i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? new BinaryOperation(i11, aSTNode, aSTNode2, parserContext) : new IntDiv(aSTNode, aSTNode2, parserContext) : new IntMult(aSTNode, aSTNode2, parserContext) : new IntSub(aSTNode, aSTNode2, parserContext) : new IntAdd(aSTNode, aSTNode2, parserContext) : new BinaryOperation(i11, aSTNode, aSTNode2, parserContext);
    }

    public static void b(ParserContext parserContext, ASTNode aSTNode, Class cls, boolean z10) {
        Class<?> f11 = m.f(aSTNode.getEgressType());
        if (!z10) {
            if (f11 == null || !(Object.class.equals(f11) || m.f(cls).isAssignableFrom(f11))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("was expecting type: ");
                sb2.append(cls.getName());
                sb2.append("; but found type: ");
                sb2.append(f11 != null ? f11.getName() : "<Unknown>");
                throw new CompileException(sb2.toString(), new char[0], 0);
            }
            return;
        }
        if ((f11 == null || !m.f(cls).isAssignableFrom(f11)) && !Object.class.equals(f11) && parserContext.isStrictTypeEnforcement()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("was expecting type: ");
            sb3.append(cls.getName());
            sb3.append("; but found type: ");
            sb3.append(f11 != null ? f11.getName() : "<Unknown>");
            throw new CompileException(sb3.toString(), new char[0], 0);
        }
    }

    public static void c(ParserContext parserContext, org.mvel2.compiler.a aVar, Class cls, boolean z10) {
        Class knownEgressType = aVar.getKnownEgressType();
        if (!z10) {
            if (knownEgressType == null || !(Object.class.equals(knownEgressType) || m.f(cls).isAssignableFrom(m.f(knownEgressType)))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("was expecting type: ");
                sb2.append(cls.getName());
                sb2.append("; but found type: ");
                sb2.append(knownEgressType != null ? knownEgressType.getName() : "<Unknown>");
                throw new CompileException(sb2.toString(), new char[0], 0);
            }
            return;
        }
        if (knownEgressType == null || !m.f(cls).isAssignableFrom(m.f(knownEgressType))) {
            if (!Object.class.equals(knownEgressType) || parserContext.isStrictTypeEnforcement()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("was expecting type: ");
                sb3.append(cls.getName());
                sb3.append("; but found type: ");
                sb3.append(knownEgressType != null ? knownEgressType.getName() : "<Unknown>");
                throw new CompileException(sb3.toString(), new char[0], 0);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01ed, code lost:
    
        if (r2 == r5) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01ef, code lost:
    
        j(r2.getOperator().intValue(), r1, r2, r17, r9, r19);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mvel2.util.ASTLinkedList d(org.mvel2.util.ASTLinkedList r17, boolean r18, org.mvel2.ParserContext r19) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.util.e.d(org.mvel2.util.ASTLinkedList, boolean, org.mvel2.ParserContext):org.mvel2.util.ASTLinkedList");
    }

    public static Map e(VariableResolverFactory variableResolverFactory) {
        if (variableResolverFactory == null) {
            return null;
        }
        while (!(variableResolverFactory instanceof ClassImportResolverFactory)) {
            variableResolverFactory = variableResolverFactory.getNextFactory();
            if (variableResolverFactory == null) {
                return null;
            }
        }
        return ((ClassImportResolverFactory) variableResolverFactory).getImportedClasses();
    }

    public static Class f(ASTIterator aSTIterator, boolean z10) {
        ASTNode firstNode = aSTIterator.firstNode();
        return firstNode == null ? Object.class : aSTIterator.size() == 1 ? firstNode.getEgressType() : a.b(aSTIterator).d(z10);
    }

    public static Class g(int i11, Class cls, Class cls2) {
        if (i11 == 26 || i11 == 36) {
            return Boolean.class;
        }
        switch (i11) {
            case 0:
                if (cls == String.class) {
                    return String.class;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return Integer.class;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 22:
                return Boolean.class;
            case 20:
                return String.class;
            default:
                return null;
        }
        return (cls == Object.class || cls2 == Object.class) ? Object.class : m.a(m.f(cls)) < m.a(m.f(cls2)) ? cls2 : cls;
    }

    private static boolean h(BooleanNode booleanNode, ASTNode aSTNode) {
        return (booleanNode instanceof org.mvel2.ast.c) && aSTNode.getEgressType() != Integer.class;
    }

    private static boolean i(ASTNode aSTNode, ASTNode aSTNode2) {
        ASTNode aSTNode3;
        ASTNode aSTNode4;
        if (aSTNode2 != null && aSTNode2.isLiteral() && (aSTNode3 = aSTNode2.nextASTNode) != null && k(aSTNode3.getOperator().intValue())) {
            int[] iArr = org.mvel2.f.f72097a;
            if (iArr[aSTNode.getOperator().intValue()] <= iArr[aSTNode3.getOperator().intValue()] && (aSTNode4 = aSTNode3.nextASTNode) != null && aSTNode4.isLiteral() && (aSTNode4.getLiteralValue() instanceof Number)) {
                return true;
            }
        }
        return false;
    }

    private static void j(int i11, ASTNode aSTNode, ASTNode aSTNode2, ASTLinkedList aSTLinkedList, ASTLinkedList aSTLinkedList2, ParserContext parserContext) {
        if (i11 == 36) {
            aSTLinkedList2.addTokenNode(new Convertable(aSTNode, aSTLinkedList.nextNode(), parserContext));
            return;
        }
        switch (i11) {
            case 24:
                aSTLinkedList2.addTokenNode(new RegExMatchNode(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 25:
                aSTLinkedList2.addTokenNode(new Instance(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 26:
                aSTLinkedList2.addTokenNode(new Contains(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 27:
                aSTLinkedList2.addTokenNode(new Soundslike(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case 28:
                aSTLinkedList2.addTokenNode(new Strsim(aSTNode, aSTLinkedList.nextNode(), parserContext));
                return;
            case NOTIFICATION_REDIRECT_VALUE:
                if (parserContext.isStrongTyping() && aSTNode.getEgressType() != Boolean.class && aSTNode.getEgressType() != Boolean.TYPE) {
                    throw new RuntimeException("Condition of ternary operator is not of type boolean. Found " + aSTNode.getEgressType());
                }
                break;
        }
        aSTLinkedList2.addTokenNode(aSTNode, aSTNode2);
    }

    private static boolean k(int i11) {
        return i11 == 0 || i11 == 1;
    }

    public static Number l(Object obj) {
        if (obj instanceof Integer) {
            return Integer.valueOf(-((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return Double.valueOf(-((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return Float.valueOf(-((Float) obj).floatValue());
        }
        if (obj instanceof Short) {
            return Integer.valueOf(-((Short) obj).shortValue());
        }
        throw new CompileException("expected a numeric type but found: " + obj.getClass().getName(), new char[0], 0);
    }
}
