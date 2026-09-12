package n10;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.OptimizationNotSupported;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* loaded from: classes7.dex */
public class d implements a {

    /* renamed from: a, reason: collision with root package name */
    private char[] f70225a;

    /* renamed from: b, reason: collision with root package name */
    private int f70226b;

    /* renamed from: c, reason: collision with root package name */
    private int f70227c;

    /* renamed from: e, reason: collision with root package name */
    private int f70229e;

    /* renamed from: f, reason: collision with root package name */
    private int f70230f;

    /* renamed from: h, reason: collision with root package name */
    private ParserContext f70232h;

    /* renamed from: i, reason: collision with root package name */
    private org.mvel2.compiler.a f70233i;

    /* renamed from: j, reason: collision with root package name */
    private org.mvel2.compiler.a f70234j;

    /* renamed from: g, reason: collision with root package name */
    private boolean f70231g = false;

    /* renamed from: d, reason: collision with root package name */
    private long f70228d = System.currentTimeMillis();

    public d(ParserContext parserContext, char[] cArr, int i11, int i12, int i13, org.mvel2.compiler.a aVar) {
        this.f70234j = aVar;
        this.f70233i = aVar;
        this.f70229e = i13;
        this.f70225a = cArr;
        this.f70226b = i11;
        this.f70227c = i12;
        this.f70232h = parserContext;
    }

    private Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        org.mvel2.optimizers.a b11 = org.mvel2.optimizers.b.b("ASM");
        int i11 = this.f70229e;
        if (i11 == 0) {
            this.f70234j = b11.optimizeAccessor(this.f70232h, this.f70225a, this.f70226b, this.f70227c, obj, obj2, variableResolverFactory, false, null);
            return b11.getResultOptPass();
        }
        if (i11 == 2) {
            org.mvel2.compiler.a optimizeCollection = b11.optimizeCollection(this.f70232h, obj, null, this.f70225a, this.f70226b, this.f70227c, obj, obj2, variableResolverFactory);
            this.f70234j = optimizeCollection;
            return optimizeCollection.getValue(obj, obj2, variableResolverFactory);
        }
        if (i11 != 3) {
            return null;
        }
        org.mvel2.compiler.a optimizeObjectCreation = b11.optimizeObjectCreation(this.f70232h, this.f70225a, this.f70226b, this.f70227c, obj, obj2, variableResolverFactory);
        this.f70234j = optimizeObjectCreation;
        return optimizeObjectCreation.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // n10.a
    public void a() {
        this.f70234j = this.f70233i;
        this.f70231g = false;
        this.f70230f = 0;
        this.f70228d = System.currentTimeMillis();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f70233i.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.f70231g) {
            int i11 = this.f70230f + 1;
            this.f70230f = i11;
            if (i11 > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f70228d < DynamicOptimizer.timeSpan) {
                    this.f70231g = true;
                    try {
                        return b(obj, obj2, variableResolverFactory);
                    } catch (OptimizationNotSupported unused) {
                    }
                } else {
                    this.f70230f = 0;
                    this.f70228d = System.currentTimeMillis();
                }
            }
        }
        return this.f70234j.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        this.f70230f++;
        return this.f70234j.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
