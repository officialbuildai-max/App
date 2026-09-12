package org.mvel2.ast;

import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledAccExpression;
import org.mvel2.compiler.ExecutableStatement;
import org.mvel2.g;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class DeepAssignmentNode extends ASTNode implements a {
    private CompiledAccExpression acc;
    private String property;
    private ExecutableStatement statement;

    public DeepAssignmentNode(char[] cArr, int i11, int i12, int i13, int i14, String str, ParserContext parserContext) {
        super(parserContext);
        this.fields |= i13 | 2;
        this.expr = cArr;
        this.start = i11;
        this.offset = i12;
        if (i14 != -1) {
            this.property = str;
            ExecutableStatement executableStatement = (ExecutableStatement) m.J0(m.w(str, cArr, i11, i12, i14), parserContext);
            this.statement = executableStatement;
            this.egressType = executableStatement.getKnownEgressType();
        } else {
            int B = m.B(cArr, i11, i12, '=');
            if (B != -1) {
                this.property = m.x(cArr, i11, B - i11);
                int i15 = B + 1;
                int E0 = m.E0(cArr, i15);
                this.start = E0;
                if (E0 >= i11 + i12) {
                    throw new CompileException("unexpected end of statement", cArr, i15);
                }
                int i16 = i12 - (E0 - i11);
                this.offset = i16;
                if ((i13 & 16) != 0) {
                    this.statement = (ExecutableStatement) m.I0(cArr, E0, i16, parserContext);
                }
            } else {
                this.property = new String(cArr);
            }
        }
        if ((i13 & 16) != 0) {
            this.acc = (CompiledAccExpression) org.mvel2.d.k(this.property.toCharArray(), i11, i12, parserContext);
        }
    }

    public DeepAssignmentNode(char[] cArr, int i11, int i12, int i13, ParserContext parserContext) {
        this(cArr, i11, i12, i13, -1, null, parserContext);
    }

    @Override // org.mvel2.ast.ASTNode
    public String getAbsoluteName() {
        String str = this.property;
        return str.substring(0, str.indexOf(46));
    }

    @Override // org.mvel2.ast.a
    public String getAssignmentVar() {
        return this.property;
    }

    public char[] getExpression() {
        return m.F0(this.expr, this.start, this.offset);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        String str = this.property;
        Object q11 = org.mvel2.d.q(this.expr, this.start, this.offset, obj, variableResolverFactory);
        g.A(obj, variableResolverFactory, str, q11, this.pCtx);
        return q11;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.statement == null) {
            this.statement = (ExecutableStatement) m.I0(this.expr, this.start, this.offset, this.pCtx);
            this.acc = (CompiledAccExpression) org.mvel2.d.l(this.property.toCharArray(), this.statement.getKnownEgressType(), this.pCtx);
        }
        CompiledAccExpression compiledAccExpression = this.acc;
        Object value = this.statement.getValue(obj, obj2, variableResolverFactory);
        compiledAccExpression.setValue(obj, obj2, variableResolverFactory, value);
        return value;
    }

    @Override // org.mvel2.ast.ASTNode
    public boolean isAssignment() {
        return true;
    }

    @Override // org.mvel2.ast.a
    public boolean isNewDeclaration() {
        return false;
    }

    @Override // org.mvel2.ast.a
    public void setValueStatement(ExecutableStatement executableStatement) {
        this.statement = executableStatement;
    }
}
