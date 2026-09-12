package n10;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* loaded from: classes7.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private ParserContext f70213a;

    /* renamed from: b, reason: collision with root package name */
    private Object f70214b;

    /* renamed from: c, reason: collision with root package name */
    private Class f70215c;

    /* renamed from: d, reason: collision with root package name */
    private char[] f70216d;

    /* renamed from: e, reason: collision with root package name */
    private int f70217e;

    /* renamed from: f, reason: collision with root package name */
    private int f70218f;

    /* renamed from: h, reason: collision with root package name */
    private int f70220h;

    /* renamed from: i, reason: collision with root package name */
    private int f70221i;

    /* renamed from: k, reason: collision with root package name */
    private org.mvel2.compiler.a f70223k;

    /* renamed from: l, reason: collision with root package name */
    private org.mvel2.compiler.a f70224l;

    /* renamed from: j, reason: collision with root package name */
    private boolean f70222j = false;

    /* renamed from: g, reason: collision with root package name */
    private long f70219g = System.currentTimeMillis();

    public c(ParserContext parserContext, Object obj, Class cls, char[] cArr, int i11, int i12, int i13, org.mvel2.compiler.a aVar) {
        this.f70213a = parserContext;
        this.f70214b = obj;
        this.f70215c = cls;
        this.f70224l = aVar;
        this.f70223k = aVar;
        this.f70220h = i13;
        this.f70216d = cArr;
        this.f70217e = i11;
        this.f70218f = i12;
    }

    private Object b(ParserContext parserContext, Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        org.mvel2.compiler.a optimizeCollection = org.mvel2.optimizers.b.b("ASM").optimizeCollection(parserContext, this.f70214b, this.f70215c, this.f70216d, this.f70217e, this.f70218f, obj, obj2, variableResolverFactory);
        this.f70224l = optimizeCollection;
        return optimizeCollection.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // n10.a
    public void a() {
        this.f70224l = this.f70223k;
        this.f70222j = false;
        this.f70221i = 0;
        this.f70219g = System.currentTimeMillis();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f70215c;
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        if (!this.f70222j) {
            int i11 = this.f70221i + 1;
            this.f70221i = i11;
            if (i11 > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f70219g < DynamicOptimizer.timeSpan) {
                    this.f70222j = true;
                    return b(this.f70213a, obj, obj2, variableResolverFactory);
                }
                this.f70221i = 0;
                this.f70219g = System.currentTimeMillis();
            }
        }
        return this.f70224l.getValue(obj, obj2, variableResolverFactory);
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        this.f70221i++;
        return this.f70224l.setValue(obj, obj2, variableResolverFactory, obj3);
    }
}
