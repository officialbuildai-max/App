package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.h;

/* loaded from: classes7.dex */
public class k0 extends e00.a implements kotlinx.serialization.json.g {

    /* renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.json.a f68440a;

    /* renamed from: b, reason: collision with root package name */
    private final WriteMode f68441b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlinx.serialization.json.internal.a f68442c;

    /* renamed from: d, reason: collision with root package name */
    private final f00.c f68443d;

    /* renamed from: e, reason: collision with root package name */
    private int f68444e;

    /* renamed from: f, reason: collision with root package name */
    private a f68445f;

    /* renamed from: g, reason: collision with root package name */
    private final kotlinx.serialization.json.f f68446g;

    /* renamed from: h, reason: collision with root package name */
    private final JsonElementMarker f68447h;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f68448a;

        public a(String str) {
            this.f68448a = str;
        }
    }

    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f68449a;

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
            try {
                iArr[WriteMode.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f68449a = iArr;
        }
    }

    public k0(kotlinx.serialization.json.a json, WriteMode mode, kotlinx.serialization.json.internal.a lexer, kotlinx.serialization.descriptors.f descriptor, a aVar) {
        Intrinsics.h(json, "json");
        Intrinsics.h(mode, "mode");
        Intrinsics.h(lexer, "lexer");
        Intrinsics.h(descriptor, "descriptor");
        this.f68440a = json;
        this.f68441b = mode;
        this.f68442c = lexer;
        this.f68443d = json.a();
        this.f68444e = -1;
        this.f68445f = aVar;
        kotlinx.serialization.json.f e11 = json.e();
        this.f68446g = e11;
        this.f68447h = e11.f() ? null : new JsonElementMarker(descriptor);
    }

    private final void K() {
        if (this.f68442c.E() != 4) {
            return;
        }
        kotlinx.serialization.json.internal.a.y(this.f68442c, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean L(kotlinx.serialization.descriptors.f fVar, int i11) {
        String F;
        kotlinx.serialization.json.a aVar = this.f68440a;
        kotlinx.serialization.descriptors.f h11 = fVar.h(i11);
        if (!h11.b() && !this.f68442c.M()) {
            return true;
        }
        if (!Intrinsics.c(h11.d(), h.b.f68192a) || (F = this.f68442c.F(this.f68446g.l())) == null || JsonNamesMapKt.d(h11, aVar, F) != -3) {
            return false;
        }
        this.f68442c.q();
        return true;
    }

    private final int M() {
        boolean L = this.f68442c.L();
        if (!this.f68442c.f()) {
            if (!L) {
                return -1;
            }
            kotlinx.serialization.json.internal.a.y(this.f68442c, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i11 = this.f68444e;
        if (i11 != -1 && !L) {
            kotlinx.serialization.json.internal.a.y(this.f68442c, "Expected end of the array or comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i12 = i11 + 1;
        this.f68444e = i12;
        return i12;
    }

    private final int N() {
        int i11;
        int i12;
        int i13 = this.f68444e;
        boolean z10 = false;
        boolean z11 = i13 % 2 != 0;
        if (!z11) {
            this.f68442c.o(':');
        } else if (i13 != -1) {
            z10 = this.f68442c.L();
        }
        if (!this.f68442c.f()) {
            if (!z10) {
                return -1;
            }
            kotlinx.serialization.json.internal.a.y(this.f68442c, "Expected '}', but had ',' instead", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (z11) {
            if (this.f68444e == -1) {
                kotlinx.serialization.json.internal.a aVar = this.f68442c;
                i12 = aVar.f68409a;
                if (z10) {
                    kotlinx.serialization.json.internal.a.y(aVar, "Unexpected trailing comma", i12, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                kotlinx.serialization.json.internal.a aVar2 = this.f68442c;
                i11 = aVar2.f68409a;
                if (!z10) {
                    kotlinx.serialization.json.internal.a.y(aVar2, "Expected comma after the key-value pair", i11, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        int i14 = this.f68444e + 1;
        this.f68444e = i14;
        return i14;
    }

    private final int O(kotlinx.serialization.descriptors.f fVar) {
        boolean z10;
        boolean L = this.f68442c.L();
        while (this.f68442c.f()) {
            String P = P();
            this.f68442c.o(':');
            int d11 = JsonNamesMapKt.d(fVar, this.f68440a, P);
            boolean z11 = false;
            if (d11 == -3) {
                z11 = true;
                z10 = false;
            } else {
                if (!this.f68446g.d() || !L(fVar, d11)) {
                    JsonElementMarker jsonElementMarker = this.f68447h;
                    if (jsonElementMarker != null) {
                        jsonElementMarker.c(d11);
                    }
                    return d11;
                }
                z10 = this.f68442c.L();
            }
            L = z11 ? Q(P) : z10;
        }
        if (L) {
            kotlinx.serialization.json.internal.a.y(this.f68442c, "Unexpected trailing comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        JsonElementMarker jsonElementMarker2 = this.f68447h;
        if (jsonElementMarker2 != null) {
            return jsonElementMarker2.d();
        }
        return -1;
    }

    private final String P() {
        return this.f68446g.l() ? this.f68442c.t() : this.f68442c.k();
    }

    private final boolean Q(String str) {
        if (this.f68446g.g() || S(this.f68445f, str)) {
            this.f68442c.H(this.f68446g.l());
        } else {
            this.f68442c.A(str);
        }
        return this.f68442c.L();
    }

    private final void R(kotlinx.serialization.descriptors.f fVar) {
        do {
        } while (o(fVar) != -1);
    }

    private final boolean S(a aVar, String str) {
        if (aVar == null || !Intrinsics.c(aVar.f68448a, str)) {
            return false;
        }
        aVar.f68448a = null;
        return true;
    }

    @Override // e00.a, e00.e
    public boolean D() {
        JsonElementMarker jsonElementMarker = this.f68447h;
        return !(jsonElementMarker != null ? jsonElementMarker.b() : false) && this.f68442c.M();
    }

    @Override // e00.a, e00.e
    public Object G(kotlinx.serialization.a deserializer) {
        Intrinsics.h(deserializer, "deserializer");
        try {
            if ((deserializer instanceof kotlinx.serialization.internal.b) && !this.f68440a.e().k()) {
                String c11 = i0.c(deserializer.getDescriptor(), this.f68440a);
                String l11 = this.f68442c.l(c11, this.f68446g.l());
                kotlinx.serialization.a c12 = l11 != null ? ((kotlinx.serialization.internal.b) deserializer).c(this, l11) : null;
                if (c12 == null) {
                    return i0.d(this, deserializer);
                }
                this.f68445f = new a(c11);
                return c12.deserialize(this);
            }
            return deserializer.deserialize(this);
        } catch (MissingFieldException e11) {
            throw new MissingFieldException(e11.getMissingFields(), e11.getMessage() + " at path: " + this.f68442c.f68410b.a(), e11);
        }
    }

    @Override // e00.a, e00.e
    public byte H() {
        long p11 = this.f68442c.p();
        byte b11 = (byte) p11;
        if (p11 == b11) {
            return b11;
        }
        kotlinx.serialization.json.internal.a.y(this.f68442c, "Failed to parse byte for input '" + p11 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // e00.e, e00.c
    public f00.c a() {
        return this.f68443d;
    }

    @Override // e00.a, e00.e
    public e00.c b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        WriteMode b11 = q0.b(this.f68440a, descriptor);
        this.f68442c.f68410b.c(descriptor);
        this.f68442c.o(b11.begin);
        K();
        int i11 = b.f68449a[b11.ordinal()];
        return (i11 == 1 || i11 == 2 || i11 == 3) ? new k0(this.f68440a, b11, this.f68442c, descriptor, this.f68445f) : (this.f68441b == b11 && this.f68440a.e().f()) ? this : new k0(this.f68440a, b11, this.f68442c, descriptor, this.f68445f);
    }

    @Override // e00.a, e00.c
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        if (this.f68440a.e().g() && descriptor.e() == 0) {
            R(descriptor);
        }
        this.f68442c.o(this.f68441b.end);
        this.f68442c.f68410b.b();
    }

    @Override // kotlinx.serialization.json.g
    public final kotlinx.serialization.json.a d() {
        return this.f68440a;
    }

    @Override // e00.a, e00.e
    public int e(kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.e(enumDescriptor, this.f68440a, z(), " at path " + this.f68442c.f68410b.a());
    }

    @Override // kotlinx.serialization.json.g
    public kotlinx.serialization.json.h g() {
        return new JsonTreeReader(this.f68440a.e(), this.f68442c).e();
    }

    @Override // e00.a, e00.e
    public int h() {
        long p11 = this.f68442c.p();
        int i11 = (int) p11;
        if (p11 == i11) {
            return i11;
        }
        kotlinx.serialization.json.internal.a.y(this.f68442c, "Failed to parse int for input '" + p11 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // e00.a, e00.e
    public Void j() {
        return null;
    }

    @Override // e00.a, e00.e
    public long l() {
        return this.f68442c.p();
    }

    @Override // e00.c
    public int o(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        int i11 = b.f68449a[this.f68441b.ordinal()];
        int M = i11 != 2 ? i11 != 4 ? M() : O(descriptor) : N();
        if (this.f68441b != WriteMode.MAP) {
            this.f68442c.f68410b.g(M);
        }
        return M;
    }

    @Override // e00.a, e00.e
    public e00.e q(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return m0.a(descriptor) ? new v(this.f68442c, this.f68440a) : super.q(descriptor);
    }

    @Override // e00.a, e00.e
    public short s() {
        long p11 = this.f68442c.p();
        short s11 = (short) p11;
        if (p11 == s11) {
            return s11;
        }
        kotlinx.serialization.json.internal.a.y(this.f68442c, "Failed to parse short for input '" + p11 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // e00.a, e00.e
    public float t() {
        kotlinx.serialization.json.internal.a aVar = this.f68442c;
        String s11 = aVar.s();
        try {
            float parseFloat = Float.parseFloat(s11);
            if (this.f68440a.e().a() || !(Float.isInfinite(parseFloat) || Float.isNaN(parseFloat))) {
                return parseFloat;
            }
            w.j(this.f68442c, Float.valueOf(parseFloat));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            kotlinx.serialization.json.internal.a.y(aVar, "Failed to parse type 'float' for input '" + s11 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // e00.a, e00.e
    public double v() {
        kotlinx.serialization.json.internal.a aVar = this.f68442c;
        String s11 = aVar.s();
        try {
            double parseDouble = Double.parseDouble(s11);
            if (this.f68440a.e().a() || !(Double.isInfinite(parseDouble) || Double.isNaN(parseDouble))) {
                return parseDouble;
            }
            w.j(this.f68442c, Double.valueOf(parseDouble));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            kotlinx.serialization.json.internal.a.y(aVar, "Failed to parse type 'double' for input '" + s11 + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // e00.a, e00.e
    public boolean w() {
        return this.f68446g.l() ? this.f68442c.i() : this.f68442c.g();
    }

    @Override // e00.a, e00.e
    public char x() {
        String s11 = this.f68442c.s();
        if (s11.length() == 1) {
            return s11.charAt(0);
        }
        kotlinx.serialization.json.internal.a.y(this.f68442c, "Expected single char, but got '" + s11 + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // e00.a, e00.c
    public Object y(kotlinx.serialization.descriptors.f descriptor, int i11, kotlinx.serialization.a deserializer, Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        boolean z10 = this.f68441b == WriteMode.MAP && (i11 & 1) == 0;
        if (z10) {
            this.f68442c.f68410b.d();
        }
        Object y10 = super.y(descriptor, i11, deserializer, obj);
        if (z10) {
            this.f68442c.f68410b.f(y10);
        }
        return y10;
    }

    @Override // e00.a, e00.e
    public String z() {
        return this.f68446g.l() ? this.f68442c.t() : this.f68442c.q();
    }
}
