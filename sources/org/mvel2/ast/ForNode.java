package org.mvel2.ast;

import java.util.HashMap;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.integration.impl.MapVariableResolverFactory;
import org.mvel2.util.e;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class ForNode extends BlockNode {
    protected ExecutableStatement after;
    protected ExecutableStatement condition;
    protected boolean indexAlloc;
    protected ExecutableStatement initializer;
    protected String item;

    public ForNode(char[] cArr, int i11, int i12, int i13, int i14, int i15, ParserContext parserContext) {
        super(parserContext);
        boolean z10 = false;
        this.indexAlloc = false;
        this.expr = cArr;
        this.start = i11;
        this.offset = i12;
        this.blockStart = i13;
        this.blockOffset = i14;
        boolean buildForEach = buildForEach(cArr, i11, i12, i13, i14, i15, parserContext);
        if (parserContext != null && parserContext.isIndexAllocation()) {
            z10 = true;
        }
        this.indexAlloc = z10;
        if ((i15 & 16) != 0 && this.compiledBlock.isEmptyStatement() && !buildForEach) {
            throw new RedundantCodeException();
        }
        if (parserContext != null) {
            parserContext.popVariableScope();
        }
    }

    private boolean buildForEach(char[] cArr, int i11, int i12, int i13, int i14, int i15, ParserContext parserContext) {
        ParserContext createColoringSubcontext;
        int i16 = i12 + i11;
        boolean z10 = false;
        int nextCondPart = nextCondPart(cArr, i11, i16, false);
        try {
            createColoringSubcontext = parserContext != null ? parserContext.createSubcontext().createColoringSubcontext() : new ParserContext();
            this.initializer = (ExecutableStatement) m.I0(cArr, i11, (nextCondPart - i11) - 1, createColoringSubcontext);
            if (parserContext != null) {
                parserContext.pushVariableScope();
            }
        } catch (NegativeArraySizeException unused) {
        }
        try {
            try {
                i11 = nextCondPart(cArr, nextCondPart, i16, false);
                ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, nextCondPart, (i11 - nextCondPart) - 1, createColoringSubcontext);
                this.condition = executableStatement;
                int i17 = i15 & 16;
                e.c(parserContext, executableStatement, Boolean.class, i17 != 0);
                this.after = (ExecutableStatement) m.I0(cArr, i11, nextCondPart(cArr, i11, i16, true) - i11, createColoringSubcontext);
                if (createColoringSubcontext != null && i17 != 0 && createColoringSubcontext.isVariablesEscape()) {
                    if (parserContext != createColoringSubcontext) {
                        parserContext.addVariables(createColoringSubcontext.getVariables());
                    }
                    z10 = true;
                } else if (createColoringSubcontext != null && parserContext != null) {
                    parserContext.addVariables(createColoringSubcontext.getVariables());
                }
                this.compiledBlock = (ExecutableStatement) m.I0(this.expr, i13, i14, createColoringSubcontext);
                if (parserContext != null) {
                    parserContext.setInputs(createColoringSubcontext.getInputs());
                }
                return z10;
            } catch (CompileException e11) {
                if (e11.getExpr().length == 0) {
                    e11.setExpr(this.expr);
                    int i18 = nextCondPart;
                    while (true) {
                        char[] cArr2 = this.expr;
                        if (i18 >= cArr2.length || !m.q0(cArr2[i18])) {
                            break;
                        }
                        i18++;
                    }
                    e11.setCursor(i18);
                }
                throw e11;
            }
        } catch (NegativeArraySizeException unused2) {
            i11 = nextCondPart;
            throw new CompileException("wrong syntax; did you mean to use 'foreach'?", this.expr, i11);
        }
    }

    private static int nextCondPart(char[] cArr, int i11, int i12, boolean z10) {
        while (i11 < i12) {
            if (cArr[i11] == ';') {
                return i11 + 1;
            }
            i11++;
        }
        if (z10) {
            return i11;
        }
        throw new CompileException("expected ;", cArr, i11);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        ExecutableStatement executableStatement = this.initializer;
        MapVariableResolverFactory mapVariableResolverFactory = new MapVariableResolverFactory(new HashMap(1), variableResolverFactory);
        executableStatement.getValue(obj, obj2, mapVariableResolverFactory);
        while (((Boolean) this.condition.getValue(obj, obj2, mapVariableResolverFactory)).booleanValue()) {
            Object value = this.compiledBlock.getValue(obj, obj2, mapVariableResolverFactory);
            if (mapVariableResolverFactory.tiltFlag()) {
                return value;
            }
            this.after.getValue(obj, obj2, mapVariableResolverFactory);
        }
        return null;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.indexAlloc) {
            variableResolverFactory = new MapVariableResolverFactory(new HashMap(1), variableResolverFactory);
        }
        ExecutableStatement executableStatement = this.initializer;
        while (true) {
            executableStatement.getValue(obj, obj2, variableResolverFactory);
            if (!((Boolean) this.condition.getValue(obj, obj2, variableResolverFactory)).booleanValue()) {
                return null;
            }
            Object value = this.compiledBlock.getValue(obj, obj2, variableResolverFactory);
            if (variableResolverFactory.tiltFlag()) {
                return value;
            }
            executableStatement = this.after;
        }
    }
}
