package org.mvel2.ast;

import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public class d extends b {

    /* renamed from: b, reason: collision with root package name */
    private final VariableResolverFactory f72075b;

    public d(Function function, VariableResolverFactory variableResolverFactory) {
        super(function);
        this.f72075b = variableResolverFactory;
    }

    @Override // org.mvel2.ast.b
    public Object a(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr) {
        return this.f72074a.call(obj, obj2, new InvokationContextFactory(variableResolverFactory, this.f72075b), objArr);
    }

    public VariableResolverFactory c() {
        return this.f72075b;
    }

    public String toString() {
        return "function_prototype:" + this.f72074a.getName();
    }
}
