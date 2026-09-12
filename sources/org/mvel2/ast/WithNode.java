package org.mvel2.ast;

import java.io.Serializable;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;
import org.mvel2.util.n;

/* loaded from: classes7.dex */
public class WithNode extends BlockNode {
    protected String nestParm;
    protected ParmValuePair[] withExpressions;

    /* loaded from: classes7.dex */
    public static final class ParmValuePair implements Serializable {
        private Serializable setExpression;
        private ExecutableStatement statement;

        public ParmValuePair(String str, ExecutableStatement executableStatement, Class cls, ParserContext parserContext) {
            if (str != null && str.length() != 0) {
                this.setExpression = org.mvel2.d.i(str, cls != null ? n.h(cls, str, parserContext) : Object.class, parserContext);
            }
            this.statement = executableStatement;
        }

        public void eval(Object obj, VariableResolverFactory variableResolverFactory) {
            Serializable serializable = this.setExpression;
            if (serializable == null) {
                this.statement.getValue(obj, variableResolverFactory);
            } else {
                org.mvel2.d.w(serializable, obj, variableResolverFactory, this.statement.getValue(obj, variableResolverFactory));
            }
        }

        public Serializable getSetExpression() {
            return this.setExpression;
        }

        public ExecutableStatement getStatement() {
            return this.statement;
        }
    }

    public WithNode(char[] cArr, int i11, int i12, int i13, int i14, int i15, ParserContext parserContext) {
        super(parserContext);
        this.expr = cArr;
        this.start = i11;
        this.offset = i12;
        this.nestParm = m.x(cArr, i11, i12);
        this.blockStart = i13;
        this.blockOffset = i14;
        if ((i15 & 16) != 0) {
            parserContext.setBlockSymbols(true);
            ExecutableStatement executableStatement = (ExecutableStatement) m.I0(cArr, i11, i12, parserContext);
            this.compiledBlock = executableStatement;
            Class knownEgressType = executableStatement.getKnownEgressType();
            this.egressType = knownEgressType;
            this.withExpressions = compileWithExpressions(cArr, i13, i14, this.nestParm, knownEgressType, parserContext);
            parserContext.setBlockSymbols(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0165, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.mvel2.ast.WithNode.ParmValuePair[] compileWithExpressions(char[] r18, int r19, int r20, java.lang.String r21, java.lang.Class r22, org.mvel2.ParserContext r23) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.ast.WithNode.compileWithExpressions(char[], int, int, java.lang.String, java.lang.Class, org.mvel2.ParserContext):org.mvel2.ast.WithNode$ParmValuePair[]");
    }

    public ExecutableStatement getNestedStatement() {
        return this.compiledBlock;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str = this.nestParm;
        char[] cArr = this.expr;
        int i11 = this.blockStart;
        int i12 = this.blockOffset;
        Object q11 = org.mvel2.d.q(cArr, this.start, this.offset, obj, variableResolverFactory);
        m.z0(str, cArr, i11, i12, q11, variableResolverFactory);
        return q11;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        Object value = this.compiledBlock.getValue(obj, obj2, variableResolverFactory);
        if (value == null) {
            throw new CompileException("with-block against null pointer", this.expr, this.start);
        }
        for (ParmValuePair parmValuePair : this.withExpressions) {
            parmValuePair.eval(value, variableResolverFactory);
        }
        return value;
    }

    public ParmValuePair[] getWithExpressions() {
        return this.withExpressions;
    }
}
