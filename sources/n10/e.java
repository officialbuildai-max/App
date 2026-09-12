package n10;

import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.optimizers.dynamic.DynamicOptimizer;

/* loaded from: classes7.dex */
public class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private char[] f70235a;

    /* renamed from: b, reason: collision with root package name */
    private int f70236b;

    /* renamed from: c, reason: collision with root package name */
    private int f70237c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f70238d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f70239e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f70240f = System.currentTimeMillis();

    /* renamed from: g, reason: collision with root package name */
    private ParserContext f70241g;

    /* renamed from: h, reason: collision with root package name */
    private final org.mvel2.compiler.a f70242h;

    /* renamed from: i, reason: collision with root package name */
    private org.mvel2.compiler.a f70243i;

    public e(ParserContext parserContext, char[] cArr, int i11, int i12, org.mvel2.compiler.a aVar) {
        this.f70243i = aVar;
        this.f70242h = aVar;
        this.f70241g = parserContext;
        this.f70235a = cArr;
        this.f70236b = i11;
        this.f70237c = i12;
    }

    private Object b(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        if (DynamicOptimizer.isOverloaded()) {
            DynamicOptimizer.enforceTenureLimit();
        }
        this.f70243i = org.mvel2.optimizers.b.b("ASM").optimizeSetAccessor(this.f70241g, this.f70235a, this.f70236b, this.f70237c, obj, obj2, variableResolverFactory, false, obj3, obj3 != null ? obj3.getClass() : Object.class);
        return obj3;
    }

    @Override // n10.a
    public void a() {
        this.f70243i = this.f70242h;
        this.f70238d = false;
        this.f70239e = 0;
        this.f70240f = System.currentTimeMillis();
    }

    @Override // org.mvel2.compiler.a
    public Class getKnownEgressType() {
        return this.f70242h.getKnownEgressType();
    }

    @Override // org.mvel2.compiler.a
    public Object getValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory) {
        throw new RuntimeException("value cannot be read with this accessor");
    }

    @Override // org.mvel2.compiler.a
    public Object setValue(Object obj, Object obj2, VariableResolverFactory variableResolverFactory, Object obj3) {
        if (!this.f70238d) {
            int i11 = this.f70239e + 1;
            this.f70239e = i11;
            if (i11 > DynamicOptimizer.tenuringThreshold) {
                if (System.currentTimeMillis() - this.f70240f < DynamicOptimizer.timeSpan) {
                    this.f70238d = true;
                    return b(obj, obj2, variableResolverFactory, obj3);
                }
                this.f70239e = 0;
                this.f70240f = System.currentTimeMillis();
            }
        }
        this.f70243i.setValue(obj, obj2, variableResolverFactory, obj3);
        return obj3;
    }
}
