package org.mvel2.optimizers.impl.refl.nodes;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.b;

/* loaded from: classes7.dex */
public class a implements org.mvel2.compiler.a {

    /* renamed from: a, reason: collision with root package name */
    private org.mvel2.compiler.a f72125a;

    /* renamed from: b, reason: collision with root package name */
    private char[] f72126b;

    /* renamed from: c, reason: collision with root package name */
    private int f72127c;

    /* renamed from: d, reason: collision with root package name */
    private int f72128d;

    /* renamed from: e, reason: collision with root package name */
    private org.mvel2.compiler.a f72129e;

    /* renamed from: f, reason: collision with root package name */
    private ParserContext f72130f;

    public a(ParserContext parserContext, org.mvel2.compiler.a aVar, char[] cArr, int i11, int i12) {
        this.f72125a = aVar;
        this.f72127c = i11;
        this.f72128d = i12;
        this.f72126b = cArr;
        this.f72130f = parserContext;
    }

    private Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (this.f72129e != null) {
            return this.f72125a.getValue(obj, obj2, variableResolverFactory);
        }
        Object value = this.f72125a.getValue(obj, obj2, variableResolverFactory);
        org.mvel2.optimizers.a c11 = b.c();
        this.f72129e = c11.optimizeAccessor(this.f72130f, this.f72126b, this.f72127c, this.f72128d, value, obj2, variableResolverFactory, false, this.f72125a.getKnownEgressType());
        return c11.getResultOptPass();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f72129e.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        org.mvel2.compiler.a aVar = this.f72129e;
        return aVar == null ? b(obj, obj2, variableResolverFactory) : aVar.getValue(b(obj, obj2, variableResolverFactory), obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        return this.f72129e.setValue(b(obj, obj2, variableResolverFactory), obj2, variableResolverFactory, obj3);
    }
}
