package org.mvel2.ast;

import org.mvel2.integration.VariableResolverFactory;

/* loaded from: classes7.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected final Function f72074a;

    public b(Function function) {
        this.f72074a = function;
    }

    public abstract Object a(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object[] objArr);

    public Function b() {
        return this.f72074a;
    }
}
