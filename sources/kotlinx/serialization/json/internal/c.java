package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.internal.e1;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class c extends e1 implements kotlinx.serialization.json.g {

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.serialization.json.a f68415c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.serialization.json.h f68416d;

    /* renamed from: e, reason: collision with root package name */
    protected final kotlinx.serialization.json.f f68417e;

    private c(kotlinx.serialization.json.a aVar, kotlinx.serialization.json.h hVar) {
        this.f68415c = aVar;
        this.f68416d = hVar;
        this.f68417e = d().e();
    }

    public /* synthetic */ c(kotlinx.serialization.json.a aVar, kotlinx.serialization.json.h hVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, hVar);
    }

    private final kotlinx.serialization.json.o f0(kotlinx.serialization.json.u uVar, String str) {
        kotlinx.serialization.json.o oVar = uVar instanceof kotlinx.serialization.json.o ? (kotlinx.serialization.json.o) uVar : null;
        if (oVar != null) {
            return oVar;
        }
        throw w.e(-1, "Unexpected 'null' when " + str + " was expected");
    }

    private final kotlinx.serialization.json.h h0() {
        kotlinx.serialization.json.h g02;
        String str = (String) W();
        return (str == null || (g02 = g0(str)) == null) ? v0() : g02;
    }

    private final Void w0(String str) {
        throw w.f(-1, "Failed to parse '" + str + '\'', h0().toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, e00.e
    public boolean D() {
        return !(h0() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, e00.e
    public Object G(kotlinx.serialization.a deserializer) {
        Intrinsics.h(deserializer, "deserializer");
        return i0.d(this, deserializer);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, e00.e, e00.c
    public f00.c a() {
        return d().a();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, e00.e
    public e00.c b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        kotlinx.serialization.json.h h02 = h0();
        kotlinx.serialization.descriptors.h d11 = descriptor.d();
        if (Intrinsics.c(d11, i.b.f68194a) ? true : d11 instanceof kotlinx.serialization.descriptors.d) {
            kotlinx.serialization.json.a d12 = d();
            if (h02 instanceof kotlinx.serialization.json.b) {
                return new d0(d12, (kotlinx.serialization.json.b) h02);
            }
            throw w.e(-1, "Expected " + Reflection.b(kotlinx.serialization.json.b.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        }
        if (!Intrinsics.c(d11, i.c.f68195a)) {
            kotlinx.serialization.json.a d13 = d();
            if (h02 instanceof JsonObject) {
                return new JsonTreeDecoder(d13, (JsonObject) h02, null, null, 12, null);
            }
            throw w.e(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        }
        kotlinx.serialization.json.a d14 = d();
        kotlinx.serialization.descriptors.f a11 = q0.a(descriptor.h(0), d14.a());
        kotlinx.serialization.descriptors.h d15 = a11.d();
        if ((d15 instanceof kotlinx.serialization.descriptors.e) || Intrinsics.c(d15, h.b.f68192a)) {
            kotlinx.serialization.json.a d16 = d();
            if (h02 instanceof JsonObject) {
                return new f0(d16, (JsonObject) h02);
            }
            throw w.e(-1, "Expected " + Reflection.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        }
        if (!d14.e().b()) {
            throw w.d(a11);
        }
        kotlinx.serialization.json.a d17 = d();
        if (h02 instanceof kotlinx.serialization.json.b) {
            return new d0(d17, (kotlinx.serialization.json.b) h02);
        }
        throw w.e(-1, "Expected " + Reflection.b(kotlinx.serialization.json.b.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.b(h02.getClass()));
    }

    @Override // kotlinx.serialization.internal.e1
    protected String b0(String parentName, String childName) {
        Intrinsics.h(parentName, "parentName");
        Intrinsics.h(childName, "childName");
        return childName;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, e00.c
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.g
    public kotlinx.serialization.json.a d() {
        return this.f68415c;
    }

    @Override // kotlinx.serialization.json.g
    public kotlinx.serialization.json.h g() {
        return h0();
    }

    protected abstract kotlinx.serialization.json.h g0(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public boolean J(String tag) {
        Intrinsics.h(tag, "tag");
        kotlinx.serialization.json.u u02 = u0(tag);
        if (!d().e().l() && f0(u02, "boolean").c()) {
            throw w.f(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        }
        try {
            Boolean e11 = kotlinx.serialization.json.j.e(u02);
            if (e11 != null) {
                return e11.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            w0("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public byte K(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            int j11 = kotlinx.serialization.json.j.j(u0(tag));
            Byte valueOf = (-128 > j11 || j11 > 127) ? null : Byte.valueOf((byte) j11);
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            w0("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public char L(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            return StringsKt.x1(u0(tag).a());
        } catch (IllegalArgumentException unused) {
            w0("char");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public double M(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            double g11 = kotlinx.serialization.json.j.g(u0(tag));
            if (d().e().a() || !(Double.isInfinite(g11) || Double.isNaN(g11))) {
                return g11;
            }
            throw w.a(Double.valueOf(g11), tag, h0().toString());
        } catch (IllegalArgumentException unused) {
            w0("double");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public int N(String tag, kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.f(enumDescriptor, d(), u0(tag).a(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public float O(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            float i11 = kotlinx.serialization.json.j.i(u0(tag));
            if (d().e().a() || !(Float.isInfinite(i11) || Float.isNaN(i11))) {
                return i11;
            }
            throw w.a(Float.valueOf(i11), tag, h0().toString());
        } catch (IllegalArgumentException unused) {
            w0("float");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public e00.e P(String tag, kotlinx.serialization.descriptors.f inlineDescriptor) {
        Intrinsics.h(tag, "tag");
        Intrinsics.h(inlineDescriptor, "inlineDescriptor");
        return m0.a(inlineDescriptor) ? new v(new n0(u0(tag).a()), d()) : super.P(tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public int Q(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            return kotlinx.serialization.json.j.j(u0(tag));
        } catch (IllegalArgumentException unused) {
            w0("int");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public long R(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            return kotlinx.serialization.json.j.m(u0(tag));
        } catch (IllegalArgumentException unused) {
            w0("long");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public boolean S(String tag) {
        Intrinsics.h(tag, "tag");
        return g0(tag) != JsonNull.f68349c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public short T(String tag) {
        Intrinsics.h(tag, "tag");
        try {
            int j11 = kotlinx.serialization.json.j.j(u0(tag));
            Short valueOf = (-32768 > j11 || j11 > 32767) ? null : Short.valueOf((short) j11);
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            w0("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("short");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public String U(String tag) {
        Intrinsics.h(tag, "tag");
        kotlinx.serialization.json.u u02 = u0(tag);
        if (d().e().l() || f0(u02, "string").c()) {
            if (u02 instanceof JsonNull) {
                throw w.f(-1, "Unexpected 'null' value instead of string literal", h0().toString());
            }
            return u02.a();
        }
        throw w.f(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
    }

    protected final kotlinx.serialization.json.u u0(String tag) {
        Intrinsics.h(tag, "tag");
        kotlinx.serialization.json.h g02 = g0(tag);
        kotlinx.serialization.json.u uVar = g02 instanceof kotlinx.serialization.json.u ? (kotlinx.serialization.json.u) g02 : null;
        if (uVar != null) {
            return uVar;
        }
        throw w.f(-1, "Expected JsonPrimitive at " + tag + ", found " + g02, h0().toString());
    }

    public abstract kotlinx.serialization.json.h v0();
}
