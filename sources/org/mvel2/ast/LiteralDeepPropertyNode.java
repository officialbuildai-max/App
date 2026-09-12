package org.mvel2.ast;

import org.mvel2.ParserContext;
import org.mvel2.g;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public class LiteralDeepPropertyNode extends ASTNode {
    private Object literal;

    public LiteralDeepPropertyNode(char[] cArr, int i11, int i12, int i13, Object obj, ParserContext parserContext) {
        super(parserContext);
        this.fields = i13;
        this.expr = cArr;
        this.start = i11;
        this.offset = i12;
        this.literal = obj;
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        return g.m(this.expr, this.start, this.offset, this.literal, variableResolverFactory, obj2, this.pCtx);
    }

    @Override // org.mvel2.ast.ASTNode
    public Object getReducedValueAccelerated(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.accessor != null) {
            return this.accessor.getValue(this.literal, obj2, variableResolverFactory);
        }
        try {
            org.mvel2.optimizers.a d11 = org.mvel2.optimizers.b.d();
            this.accessor = d11.optimizeAccessor(this.pCtx, this.expr, this.start, this.offset, this.literal, obj2, variableResolverFactory, false, null);
            return d11.getResultOptPass();
        } finally {
            org.mvel2.optimizers.b.a();
        }
    }
}
