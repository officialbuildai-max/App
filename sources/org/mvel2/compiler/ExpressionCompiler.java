package org.mvel2.compiler;

import java.util.Iterator;
import java.util.List;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.LiteralNode;
import org.mvel2.ast.NewObjectNode;
import org.mvel2.ast.OperatorNode;
import org.mvel2.ast.Union;
import org.mvel2.c;
import org.mvel2.d;
import org.mvel2.util.ASTLinkedList;
import org.mvel2.util.e;
import org.mvel2.util.f;
import org.mvel2.util.m;
import org.mvel2.util.s;

/* loaded from: classes7.dex */
public class ExpressionCompiler extends AbstractParser {
    private Class returnType;
    private boolean secondPassOptimization;
    private boolean verifyOnly;
    private boolean verifying;

    public ExpressionCompiler(String str) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        setExpression(str);
    }

    public ExpressionCompiler(String str, int i11, int i12, ParserContext parserContext) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        this.expr = str.toCharArray();
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        int trimLeft = trimLeft(i13);
        this.end = trimLeft;
        this.length = trimLeft - i11;
        this.pCtx = parserContext;
    }

    public ExpressionCompiler(String str, ParserContext parserContext) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        setExpression(str);
        this.pCtx = parserContext;
    }

    public ExpressionCompiler(String str, boolean z10) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        setExpression(str);
        this.verifying = z10;
    }

    public ExpressionCompiler(char[] cArr) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        setExpression(cArr);
    }

    public ExpressionCompiler(char[] cArr, int i11, int i12) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        this.expr = cArr;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        int trimLeft = trimLeft(i13);
        this.end = trimLeft;
        this.length = trimLeft - i11;
    }

    public ExpressionCompiler(char[] cArr, int i11, int i12, ParserContext parserContext) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        this.expr = cArr;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        int trimLeft = trimLeft(i13);
        this.end = trimLeft;
        this.length = trimLeft - i11;
        this.pCtx = parserContext;
    }

    public ExpressionCompiler(char[] cArr, ParserContext parserContext) {
        this.verifyOnly = false;
        this.verifying = true;
        this.secondPassOptimization = false;
        setExpression(cArr);
        this.pCtx = parserContext;
    }

    private boolean compileReduce(int i11, ASTLinkedList aSTLinkedList) {
        int arithmeticFunctionReduction = arithmeticFunctionReduction(i11);
        if (arithmeticFunctionReduction == -3) {
            ASTNode aSTNode = (ASTNode) this.stk.n();
            Integer num = (Integer) this.stk.n();
            aSTLinkedList.addTokenNode(new LiteralNode(getStackValueResult(), this.pCtx));
            aSTLinkedList.addTokenNode(new OperatorNode(num, this.expr, this.f72083st, this.pCtx), verify(this.pCtx, aSTNode));
            return false;
        }
        if (arithmeticFunctionReduction != -2) {
            if (arithmeticFunctionReduction != -1) {
                return true;
            }
            this.stk.w();
            aSTLinkedList.addTokenNode(new LiteralNode(this.stk.n(), this.pCtx));
            aSTLinkedList.addTokenNode((OperatorNode) this.splitAccumulator.n(), verify(this.pCtx, (ASTNode) this.splitAccumulator.n()));
            return false;
        }
        LiteralNode literalNode = new LiteralNode(this.stk.n(), this.pCtx);
        aSTLinkedList.addTokenNode(new LiteralNode(this.stk.n(), this.pCtx), new OperatorNode((Integer) this.stk.n(), this.expr, this.f72083st, this.pCtx));
        aSTLinkedList.addTokenNode(literalNode, (OperatorNode) this.splitAccumulator.n());
        aSTLinkedList.addTokenNode(verify(this.pCtx, (ASTNode) this.splitAccumulator.n()));
        return false;
    }

    private Object getStackValueResult() {
        return (this.fields & 524288) == 0 ? this.stk.n() : e.l(this.stk.n());
    }

    private static boolean isBooleanOperator(int i11) {
        return i11 == 21 || i11 == 22 || i11 == 29 || i11 == 30;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0217, code lost:
    
        if (r6.isOperator() != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x021f, code lost:
    
        if ((r4.getLiteralValue() instanceof java.lang.Class) == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0242, code lost:
    
        throw new org.mvel2.CompileException("unexpected token: " + r6.getName(), r15.expr, r6.getStart());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.mvel2.compiler.CompiledExpression _compile() {
        /*
            Method dump skipped, instructions count: 793
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.compiler.ExpressionCompiler._compile():org.mvel2.compiler.CompiledExpression");
    }

    public CompiledExpression compile() {
        try {
            this.debugSymbols = this.pCtx.isDebugSymbols();
            CompiledExpression _compile = _compile();
            if (!this.pCtx.isFatalError()) {
                return _compile;
            }
            s sVar = new s();
            Iterator<c> it = this.pCtx.getErrorList().iterator();
            while (it.hasNext()) {
                c b11 = f.b(it.next(), this.expr, this.cursor);
                if (b11.d() != this.expr) {
                    it.remove();
                } else {
                    sVar.d("\n - ").d("(").c(Integer.valueOf(b11.e())).d(",").c(Integer.valueOf(b11.b())).d(")").d(" ").d(b11.f());
                }
            }
            throw new CompileException("Failed to compileShared: " + this.pCtx.getErrorList().size() + " compilation error(s): " + sVar.toString(), this.pCtx.getErrorList(), this.expr, this.cursor, this.pCtx);
        } catch (Throwable th2) {
            if (!this.pCtx.isFatalError()) {
                throw th2;
            }
            s sVar2 = new s();
            Iterator<c> it2 = this.pCtx.getErrorList().iterator();
            while (it2.hasNext()) {
                c b12 = f.b(it2.next(), this.expr, this.cursor);
                if (b12.d() != this.expr) {
                    it2.remove();
                } else {
                    sVar2.d("\n - ").d("(").c(Integer.valueOf(b12.e())).d(",").c(Integer.valueOf(b12.b())).d(")").d(" ").d(b12.f());
                }
            }
            throw new CompileException("Failed to compileShared: " + this.pCtx.getErrorList().size() + " compilation error(s): " + sVar2.toString(), this.pCtx.getErrorList(), this.expr, this.cursor, this.pCtx);
        }
    }

    public ParserContext getParserContextState() {
        return this.pCtx;
    }

    public Class getReturnType() {
        return this.returnType;
    }

    public boolean isLiteralOnly() {
        return this.literalOnly == 1;
    }

    public boolean isVerifyOnly() {
        return this.verifyOnly;
    }

    public boolean isVerifying() {
        return this.verifying;
    }

    public void setReturnType(Class cls) {
        this.returnType = cls;
    }

    public void setVerifyOnly(boolean z10) {
        this.verifyOnly = z10;
    }

    public void setVerifying(boolean z10) {
        this.verifying = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ASTNode verify(ParserContext parserContext, ASTNode aSTNode) {
        if (aSTNode.isOperator() && (aSTNode.getOperator().equals(21) || aSTNode.getOperator().equals(22))) {
            this.secondPassOptimization = true;
        }
        if (!aSTNode.isDiscard() && !aSTNode.isOperator()) {
            if (aSTNode.isLiteral()) {
                return ((this.fields & 16) == 0 || aSTNode.getClass() != ASTNode.class) ? aSTNode : new LiteralNode(aSTNode.getLiteralValue(), parserContext);
            }
            if (this.verifying) {
                if (aSTNode.isIdentifier()) {
                    PropertyVerifier propertyVerifier = new PropertyVerifier(this.expr, aSTNode.getStart(), aSTNode.getOffset(), parserContext);
                    if (aSTNode instanceof Union) {
                        propertyVerifier.setCtx(((Union) aSTNode).getLeftEgressType());
                        Class analyze = propertyVerifier.analyze();
                        this.returnType = analyze;
                        aSTNode.setEgressType(analyze);
                    } else {
                        Class analyze2 = propertyVerifier.analyze();
                        this.returnType = analyze2;
                        aSTNode.setEgressType(analyze2);
                        if (propertyVerifier.isFqcn()) {
                            aSTNode.setAsFQCNReference();
                        }
                        if (propertyVerifier.isClassLiteral()) {
                            return new LiteralNode(this.returnType, parserContext);
                        }
                        if (propertyVerifier.isInput()) {
                            parserContext.addInput(aSTNode.getAbsoluteName(), propertyVerifier.isDeepProperty() ? Object.class : this.returnType);
                        }
                        if (!propertyVerifier.isMethodCall() && !this.returnType.isEnum() && !parserContext.isOptimizerNotified() && parserContext.isStrongTyping() && !parserContext.isVariableVisible(aSTNode.getAbsoluteName()) && !aSTNode.isFQCN()) {
                            throw new CompileException("no such identifier: " + aSTNode.getAbsoluteName(), this.expr, aSTNode.getStart());
                        }
                    }
                } else if (aSTNode.isAssignment()) {
                    org.mvel2.ast.a aVar = (org.mvel2.ast.a) aSTNode;
                    if (aVar.getAssignmentVar() != null) {
                        PropertyVerifier propertyVerifier2 = new PropertyVerifier(aVar.getAssignmentVar(), parserContext);
                        Class analyze3 = propertyVerifier2.analyze();
                        this.returnType = analyze3;
                        aSTNode.setEgressType(analyze3);
                        if (!aVar.isNewDeclaration() && propertyVerifier2.isResolvedExternally()) {
                            parserContext.addInput(aSTNode.getAbsoluteName(), this.returnType);
                        }
                        ExecutableStatement executableStatement = (ExecutableStatement) m.I0(this.expr, aSTNode.getStart(), aSTNode.getOffset(), parserContext);
                        if (parserContext.isStrictTypeEnforcement() && !this.returnType.isAssignableFrom(executableStatement.getKnownEgressType()) && executableStatement.isLiteralOnly()) {
                            if (org.mvel2.b.a(executableStatement.getKnownEgressType(), this.returnType)) {
                                try {
                                    aVar.setValueStatement(new ExecutableLiteral(org.mvel2.b.b(executableStatement.getValue(null, null), this.returnType)));
                                    return aSTNode;
                                } catch (Exception unused) {
                                }
                            } else if (this.returnType.isPrimitive() && m.O0(executableStatement.getKnownEgressType()).equals(this.returnType)) {
                                return aSTNode;
                            }
                            throw new CompileException("cannot assign type " + executableStatement.getKnownEgressType().getName() + " to " + this.returnType.getName(), this.expr, this.f72083st);
                        }
                    }
                } else if (aSTNode instanceof NewObjectNode) {
                    List w02 = m.w0(aSTNode.getNameAsArray());
                    if (w02 != null) {
                        Iterator it = w02.iterator();
                        while (it.hasNext()) {
                            d.c((char[]) it.next(), parserContext);
                        }
                    }
                }
                this.returnType = aSTNode.getEgressType();
            }
            if (!aSTNode.isLiteral() && aSTNode.getClass() == ASTNode.class && (aSTNode.getFields() & 67108864) == 0) {
                if (parserContext.isStrongTyping()) {
                    aSTNode.strongTyping();
                }
                aSTNode.storePctx();
                aSTNode.storeInLiteralRegister(parserContext);
            }
        }
        return aSTNode;
    }
}
