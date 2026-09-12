package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementSerializer;

/* loaded from: classes7.dex */
public final class l0 extends e00.b implements kotlinx.serialization.json.l {

    /* renamed from: a, reason: collision with root package name */
    private final j f68450a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.json.a f68451b;

    /* renamed from: c, reason: collision with root package name */
    private final WriteMode f68452c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.serialization.json.l[] f68453d;

    /* renamed from: e, reason: collision with root package name */
    private final f00.c f68454e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlinx.serialization.json.f f68455f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f68456g;

    /* renamed from: h, reason: collision with root package name */
    private String f68457h;

    /* loaded from: classes7.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f68458a;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f68458a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l0(h0 output, kotlinx.serialization.json.a json, WriteMode mode, kotlinx.serialization.json.l[] modeReuseCache) {
        this(s.a(output, json), json, mode, modeReuseCache);
        Intrinsics.h(output, "output");
        Intrinsics.h(json, "json");
        Intrinsics.h(mode, "mode");
        Intrinsics.h(modeReuseCache, "modeReuseCache");
    }

    public l0(j composer, kotlinx.serialization.json.a json, WriteMode mode, kotlinx.serialization.json.l[] lVarArr) {
        Intrinsics.h(composer, "composer");
        Intrinsics.h(json, "json");
        Intrinsics.h(mode, "mode");
        this.f68450a = composer;
        this.f68451b = json;
        this.f68452c = mode;
        this.f68453d = lVarArr;
        this.f68454e = d().a();
        this.f68455f = d().e();
        int ordinal = mode.ordinal();
        if (lVarArr != null) {
            kotlinx.serialization.json.l lVar = lVarArr[ordinal];
            if (lVar == null && lVar == this) {
                return;
            }
            lVarArr[ordinal] = this;
        }
    }

    private final j K() {
        j jVar = this.f68450a;
        return jVar instanceof q ? jVar : new q(jVar.f68436a, this.f68456g);
    }

    private final void L(kotlinx.serialization.descriptors.f fVar) {
        this.f68450a.c();
        String str = this.f68457h;
        Intrinsics.e(str);
        G(str);
        this.f68450a.e(':');
        this.f68450a.o();
        G(fVar.i());
    }

    @Override // kotlinx.serialization.json.l
    public void A(kotlinx.serialization.json.h element) {
        Intrinsics.h(element, "element");
        e(JsonElementSerializer.f68347a, element);
    }

    @Override // e00.b, e00.f
    public void B(int i11) {
        if (this.f68456g) {
            G(String.valueOf(i11));
        } else {
            this.f68450a.h(i11);
        }
    }

    @Override // e00.b, e00.f
    public void G(String value) {
        Intrinsics.h(value, "value");
        this.f68450a.m(value);
    }

    @Override // e00.b
    public boolean H(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        int i12 = a.f68458a[this.f68452c.ordinal()];
        if (i12 != 1) {
            boolean z10 = false;
            if (i12 != 2) {
                if (i12 != 3) {
                    if (!this.f68450a.a()) {
                        this.f68450a.e(',');
                    }
                    this.f68450a.c();
                    G(descriptor.f(i11));
                    this.f68450a.e(':');
                    this.f68450a.o();
                } else {
                    if (i11 == 0) {
                        this.f68456g = true;
                    }
                    if (i11 == 1) {
                        this.f68450a.e(',');
                        this.f68450a.o();
                        this.f68456g = false;
                    }
                }
            } else if (this.f68450a.a()) {
                this.f68456g = true;
                this.f68450a.c();
            } else {
                if (i11 % 2 == 0) {
                    this.f68450a.e(',');
                    this.f68450a.c();
                    z10 = true;
                } else {
                    this.f68450a.e(':');
                    this.f68450a.o();
                }
                this.f68456g = z10;
            }
        } else {
            if (!this.f68450a.a()) {
                this.f68450a.e(',');
            }
            this.f68450a.c();
        }
        return true;
    }

    @Override // e00.f
    public f00.c a() {
        return this.f68454e;
    }

    @Override // e00.b, e00.f
    public e00.d b(kotlinx.serialization.descriptors.f descriptor) {
        kotlinx.serialization.json.l lVar;
        Intrinsics.h(descriptor, "descriptor");
        WriteMode b11 = q0.b(d(), descriptor);
        char c11 = b11.begin;
        if (c11 != 0) {
            this.f68450a.e(c11);
            this.f68450a.b();
        }
        if (this.f68457h != null) {
            L(descriptor);
            this.f68457h = null;
        }
        if (this.f68452c == b11) {
            return this;
        }
        kotlinx.serialization.json.l[] lVarArr = this.f68453d;
        return (lVarArr == null || (lVar = lVarArr[b11.ordinal()]) == null) ? new l0(this.f68450a, d(), b11, this.f68453d) : lVar;
    }

    @Override // e00.b, e00.d
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        if (this.f68452c.end != 0) {
            this.f68450a.p();
            this.f68450a.c();
            this.f68450a.e(this.f68452c.end);
        }
    }

    @Override // kotlinx.serialization.json.l
    public kotlinx.serialization.json.a d() {
        return this.f68451b;
    }

    @Override // e00.b, e00.f
    public void e(kotlinx.serialization.g serializer, Object obj) {
        Intrinsics.h(serializer, "serializer");
        if (!(serializer instanceof kotlinx.serialization.internal.b) || d().e().k()) {
            serializer.serialize(this, obj);
            return;
        }
        kotlinx.serialization.internal.b bVar = (kotlinx.serialization.internal.b) serializer;
        String c11 = i0.c(serializer.getDescriptor(), d());
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Any");
        kotlinx.serialization.g b11 = kotlinx.serialization.d.b(bVar, this, obj);
        i0.f(bVar, b11, c11);
        i0.b(b11.getDescriptor().d());
        this.f68457h = c11;
        b11.serialize(this, obj);
    }

    @Override // e00.b, e00.f
    public void g(double d11) {
        if (this.f68456g) {
            G(String.valueOf(d11));
        } else {
            this.f68450a.f(d11);
        }
        if (this.f68455f.a()) {
            return;
        }
        if (Double.isInfinite(d11) || Double.isNaN(d11)) {
            throw w.b(Double.valueOf(d11), this.f68450a.f68436a.toString());
        }
    }

    @Override // e00.b, e00.f
    public void h(byte b11) {
        if (this.f68456g) {
            G(String.valueOf((int) b11));
        } else {
            this.f68450a.d(b11);
        }
    }

    @Override // e00.b, e00.d
    public void i(kotlinx.serialization.descriptors.f descriptor, int i11, kotlinx.serialization.g serializer, Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(serializer, "serializer");
        if (obj != null || this.f68455f.f()) {
            super.i(descriptor, i11, serializer, obj);
        }
    }

    @Override // e00.b, e00.f
    public void k(kotlinx.serialization.descriptors.f enumDescriptor, int i11) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        G(enumDescriptor.f(i11));
    }

    @Override // e00.b, e00.f
    public e00.f l(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return m0.a(descriptor) ? new l0(K(), d(), this.f68452c, (kotlinx.serialization.json.l[]) null) : super.l(descriptor);
    }

    @Override // e00.b, e00.f
    public void m(long j11) {
        if (this.f68456g) {
            G(String.valueOf(j11));
        } else {
            this.f68450a.i(j11);
        }
    }

    @Override // e00.b, e00.f
    public void o() {
        this.f68450a.j("null");
    }

    @Override // e00.b, e00.f
    public void q(short s11) {
        if (this.f68456g) {
            G(String.valueOf((int) s11));
        } else {
            this.f68450a.k(s11);
        }
    }

    @Override // e00.b, e00.f
    public void r(boolean z10) {
        if (this.f68456g) {
            G(String.valueOf(z10));
        } else {
            this.f68450a.l(z10);
        }
    }

    @Override // e00.b, e00.f
    public void t(float f11) {
        if (this.f68456g) {
            G(String.valueOf(f11));
        } else {
            this.f68450a.g(f11);
        }
        if (this.f68455f.a()) {
            return;
        }
        if (Float.isInfinite(f11) || Float.isNaN(f11)) {
            throw w.b(Float.valueOf(f11), this.f68450a.f68436a.toString());
        }
    }

    @Override // e00.b, e00.f
    public void u(char c11) {
        G(String.valueOf(c11));
    }

    @Override // e00.b, e00.d
    public boolean z(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return this.f68455f.e();
    }
}
