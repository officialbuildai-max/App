package org.mvel2;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.Substatement;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.compiler.BlankLiteral;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.ImmutableDefaultFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;

/* loaded from: classes7.dex */
public class MVELInterpretedRuntime extends AbstractParser {
    private static final Logger LOG = Logger.getLogger(MVELInterpretedRuntime.class.getName());
    private Object holdOverRegister;

    MVELInterpretedRuntime(String str) {
        setExpression(str);
        this.variableFactory = new ImmutableDefaultFactory();
    }

    MVELInterpretedRuntime(String str, Object obj) {
        setExpression(str);
        this.ctx = obj;
        this.variableFactory = new ImmutableDefaultFactory();
    }

    public MVELInterpretedRuntime(String str, Object obj, VariableResolverFactory variableResolverFactory) {
        setExpression(str);
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    public MVELInterpretedRuntime(String str, Object obj, VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        super(parserContext);
        setExpression(str);
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    MVELInterpretedRuntime(String str, VariableResolverFactory variableResolverFactory) {
        setExpression(str);
        this.variableFactory = variableResolverFactory;
        this.pCtx.initializeTables();
    }

    MVELInterpretedRuntime(char[] cArr) {
        this.expr = cArr;
        int length = cArr.length;
        this.end = length;
        this.length = length;
    }

    public MVELInterpretedRuntime(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory) {
        this.expr = cArr;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        this.length = i13 - i11;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    public MVELInterpretedRuntime(char[] cArr, int i11, int i12, Object obj, VariableResolverFactory variableResolverFactory, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i11;
        int i13 = i12 + i11;
        this.end = i13;
        this.length = i13 - i11;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    MVELInterpretedRuntime(char[] cArr, Object obj) {
        this.expr = cArr;
        this.length = cArr.length;
        this.ctx = obj;
        this.variableFactory = new ImmutableDefaultFactory();
    }

    MVELInterpretedRuntime(char[] cArr, Object obj, Map<String, Object> map) {
        this.expr = cArr;
        this.length = cArr.length;
        this.ctx = obj;
        this.variableFactory = new MapVariableResolverFactory(map);
    }

    public MVELInterpretedRuntime(char[] cArr, Object obj, VariableResolverFactory variableResolverFactory) {
        this.expr = cArr;
        int length = cArr.length;
        this.end = length;
        this.length = length;
        this.ctx = obj;
        this.variableFactory = variableResolverFactory;
    }

    private boolean hasMore() {
        return this.cursor <= this.end;
    }

    private Object parseAndExecuteInterpreted() {
        this.lastWasIdentifier = false;
        ASTNode aSTNode = null;
        while (true) {
            try {
                aSTNode = nextToken();
                if (aSTNode == null) {
                    Object obj = this.holdOverRegister;
                    return obj != null ? obj : this.stk.k();
                }
                this.holdOverRegister = null;
                if (this.lastWasIdentifier && this.lastNode.isDiscard()) {
                    this.stk.e();
                }
                if (this.stk.g()) {
                    if ((aSTNode.fields & 4194304) != 0) {
                        org.mvel2.util.g gVar = this.stk;
                        gVar.q(aSTNode.getReducedValue(gVar, this.ctx, this.variableFactory));
                        Object k11 = this.stk.k();
                        if (k11 instanceof Integer) {
                            arithmeticFunctionReduction(((Integer) k11).intValue());
                        }
                    } else {
                        org.mvel2.util.g gVar2 = this.stk;
                        Object obj2 = this.ctx;
                        gVar2.q(aSTNode.getReducedValue(obj2, obj2, this.variableFactory));
                    }
                    if ((aSTNode instanceof Substatement) && (aSTNode = nextToken()) != null) {
                        Integer operator = aSTNode.getOperator();
                        int intValue = operator.intValue();
                        if (AbstractParser.isArithmeticOperator(intValue)) {
                            org.mvel2.util.g gVar3 = this.stk;
                            ASTNode nextToken = nextToken();
                            Object obj3 = this.ctx;
                            gVar3.r(nextToken.getReducedValue(obj3, obj3, this.variableFactory), operator);
                            if (procBooleanOperator(arithmeticFunctionReduction(intValue)) == -1) {
                                return this.stk.k();
                            }
                        }
                    }
                }
                if (this.variableFactory.tiltFlag()) {
                    return this.stk.n();
                }
                Integer operator2 = aSTNode.getOperator();
                int intValue2 = operator2.intValue();
                int procBooleanOperator = procBooleanOperator(intValue2);
                if (procBooleanOperator != -2) {
                    if (procBooleanOperator == -1) {
                        return this.stk.k();
                    }
                    if (procBooleanOperator == 0) {
                        continue;
                    } else {
                        if (procBooleanOperator == 99) {
                            this.variableFactory.setTiltFlag(true);
                            return this.stk.n();
                        }
                        org.mvel2.util.g gVar4 = this.stk;
                        ASTNode nextToken2 = nextToken();
                        Object obj4 = this.ctx;
                        gVar4.r(nextToken2.getReducedValue(obj4, obj4, this.variableFactory), operator2);
                        int arithmeticFunctionReduction = arithmeticFunctionReduction(intValue2);
                        if (arithmeticFunctionReduction == -1) {
                            return this.stk.k();
                        }
                        if (arithmeticFunctionReduction != 0 && procBooleanOperator(arithmeticFunctionReduction) == -1) {
                            return this.stk.k();
                        }
                    }
                } else if (aSTNode.isOperator()) {
                    continue;
                } else {
                    if (!(this.stk.k() instanceof Class)) {
                        throw new CompileException("unexpected token or unknown identifier:" + aSTNode.getName(), this.expr, this.f72083st);
                    }
                    this.variableFactory.createVariable(aSTNode.getName(), null, (Class) this.stk.k());
                }
            } catch (NullPointerException e11) {
                if (aSTNode == null || !aSTNode.isOperator()) {
                    throw e11;
                }
                CompileException compileException = new CompileException("incomplete statement: " + aSTNode.getName() + " (possible use of reserved keyword as identifier: " + aSTNode.getName() + ")", this.expr, this.f72083st, e11);
                compileException.setExpr(this.expr);
                compileException.setLineNumber(this.line);
                compileException.setCursor(this.cursor);
                throw compileException;
            } catch (CompileException e12) {
                throw org.mvel2.util.f.a(e12, this.expr, this.start);
            }
        }
    }

    private int procBooleanOperator(int i11) {
        ASTNode nextToken;
        if (i11 == -1) {
            return -2;
        }
        if (i11 == 37) {
            if (hasMore()) {
                this.holdOverRegister = this.stk.n();
                this.stk.b();
            }
            return 0;
        }
        if (i11 == 99) {
            return 99;
        }
        if (i11 == 29) {
            if (!this.stk.p().booleanValue()) {
                this.stk.b();
                do {
                    nextToken = nextToken();
                    if (nextToken == null) {
                        break;
                    }
                } while (!nextToken.isOperator(30));
            }
            return 0;
        }
        if (i11 == 30) {
            captureToEOS();
            return 0;
        }
        switch (i11) {
            case 21:
                reduceRight();
                if (this.stk.m().booleanValue()) {
                    this.stk.e();
                    return 0;
                }
                if (unwindStatement(i11)) {
                    return -1;
                }
                this.stk.b();
                return 0;
            case 22:
                reduceRight();
                if (!this.stk.m().booleanValue()) {
                    this.stk.e();
                    return 0;
                }
                if (unwindStatement(i11)) {
                    return -1;
                }
                this.stk.b();
                return 0;
            case 23:
                return !BlankLiteral.INSTANCE.equals(this.stk.k()) ? -1 : 1;
            default:
                return 1;
        }
    }

    private void reduceRight() {
        if (this.dStack.g()) {
            return;
        }
        this.stk.s(this.dStack.n(), this.stk.n(), this.dStack.n());
        reduce();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:
    
        r3 = nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
    
        if (r3.isOperator(37) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        if (r3.isOperator(22) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (r3 != 21) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
    
        r3 = nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r3 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r3.isOperator(37) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0030, code lost:
    
        if (r3 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean unwindStatement(int r3) {
        /*
            r2 = this;
            r0 = 21
            r1 = 37
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            if (r3 == r0) goto L17
        La:
            org.mvel2.ast.ASTNode r3 = r2.nextToken()
            if (r3 == 0) goto L30
            boolean r0 = r3.isOperator(r1)
            if (r0 != 0) goto L30
            goto La
        L17:
            org.mvel2.ast.ASTNode r3 = r2.nextToken()
            if (r3 == 0) goto L30
            boolean r0 = r3.isOperator(r1)
            if (r0 != 0) goto L30
            r0 = 22
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r0 = r3.isOperator(r0)
            if (r0 != 0) goto L30
            goto L17
        L30:
            if (r3 != 0) goto L34
            r3 = 1
            goto L35
        L34:
            r3 = 0
        L35:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.MVELInterpretedRuntime.unwindStatement(int):boolean");
    }

    public Object parse() {
        try {
            this.stk = new org.mvel2.util.g();
            this.dStack = new org.mvel2.util.g();
            this.variableFactory.setTiltFlag(false);
            this.cursor = this.start;
            return parseAndExecuteInterpreted();
        } catch (ArrayIndexOutOfBoundsException e11) {
            LOG.log(Level.WARNING, "", (Throwable) e11);
            throw new CompileException("unexpected end of statement", this.expr, this.length);
        } catch (NullPointerException e12) {
            LOG.log(Level.WARNING, "", (Throwable) e12);
            if (this.cursor >= this.length) {
                throw new CompileException("unexpected end of statement", this.expr, this.length);
            }
            throw e12;
        } catch (CompileException e13) {
            throw org.mvel2.util.f.a(e13, this.expr, this.cursor);
        }
    }
}
