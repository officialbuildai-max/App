package kotlinx.serialization.internal;

import e00.c;
import e00.e;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;

/* loaded from: classes7.dex */
public abstract class TaggedDecoder implements e00.e, e00.c {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f68221a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f68222b;

    private final Object a0(Object obj, Function0 function0) {
        Z(obj);
        Object invoke = function0.invoke();
        if (!this.f68222b) {
            Y();
        }
        this.f68222b = false;
        return invoke;
    }

    @Override // e00.c
    public final char A(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return L(X(descriptor, i11));
    }

    @Override // e00.c
    public final byte B(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return K(X(descriptor, i11));
    }

    @Override // e00.c
    public final boolean C(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return J(X(descriptor, i11));
    }

    @Override // e00.e
    public boolean D() {
        Object W = W();
        if (W == null) {
            return false;
        }
        return S(W);
    }

    @Override // e00.c
    public final short E(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return T(X(descriptor, i11));
    }

    @Override // e00.c
    public final double F(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return M(X(descriptor, i11));
    }

    @Override // e00.e
    public Object G(kotlinx.serialization.a aVar) {
        return e.a.a(this, aVar);
    }

    @Override // e00.e
    public final byte H() {
        return K(Y());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object I(kotlinx.serialization.a deserializer, Object obj) {
        Intrinsics.h(deserializer, "deserializer");
        return G(deserializer);
    }

    protected boolean J(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) V).booleanValue();
    }

    protected byte K(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) V).byteValue();
    }

    protected char L(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) V).charValue();
    }

    protected double M(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) V).doubleValue();
    }

    protected int N(Object obj, kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    protected float O(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) V).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e00.e P(Object obj, kotlinx.serialization.descriptors.f inlineDescriptor) {
        Intrinsics.h(inlineDescriptor, "inlineDescriptor");
        Z(obj);
        return this;
    }

    protected int Q(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) V).intValue();
    }

    protected long R(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) V).longValue();
    }

    protected boolean S(Object obj) {
        return true;
    }

    protected short T(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) V).shortValue();
    }

    protected String U(Object obj) {
        Object V = V(obj);
        Intrinsics.f(V, "null cannot be cast to non-null type kotlin.String");
        return (String) V;
    }

    protected Object V(Object obj) {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object W() {
        return CollectionsKt.v0(this.f68221a);
    }

    protected abstract Object X(kotlinx.serialization.descriptors.f fVar, int i11);

    protected final Object Y() {
        ArrayList arrayList = this.f68221a;
        Object remove = arrayList.remove(CollectionsKt.n(arrayList));
        this.f68222b = true;
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(Object obj) {
        this.f68221a.add(obj);
    }

    @Override // e00.e, e00.c
    public f00.c a() {
        return f00.d.a();
    }

    @Override // e00.e
    public e00.c b(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return this;
    }

    @Override // e00.c
    public void c(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
    }

    @Override // e00.e
    public final int e(kotlinx.serialization.descriptors.f enumDescriptor) {
        Intrinsics.h(enumDescriptor, "enumDescriptor");
        return N(Y(), enumDescriptor);
    }

    @Override // e00.c
    public final long f(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return R(X(descriptor, i11));
    }

    @Override // e00.e
    public final int h() {
        return Q(Y());
    }

    @Override // e00.c
    public final int i(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return Q(X(descriptor, i11));
    }

    @Override // e00.e
    public final Void j() {
        return null;
    }

    @Override // e00.c
    public int k(kotlinx.serialization.descriptors.f fVar) {
        return c.a.a(this, fVar);
    }

    @Override // e00.e
    public final long l() {
        return R(Y());
    }

    @Override // e00.c
    public final String m(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return U(X(descriptor, i11));
    }

    @Override // e00.c
    public final Object n(kotlinx.serialization.descriptors.f descriptor, int i11, final kotlinx.serialization.a deserializer, final Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        return a0(X(descriptor, i11), new Function0<Object>() { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeNullableSerializableElement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TaggedDecoder.this.D() ? TaggedDecoder.this.I(deserializer, obj) : TaggedDecoder.this.j();
            }
        });
    }

    @Override // e00.c
    public boolean p() {
        return c.a.b(this);
    }

    @Override // e00.e
    public final e00.e q(kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        return P(Y(), descriptor);
    }

    @Override // e00.c
    public final e00.e r(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return P(X(descriptor, i11), descriptor.h(i11));
    }

    @Override // e00.e
    public final short s() {
        return T(Y());
    }

    @Override // e00.e
    public final float t() {
        return O(Y());
    }

    @Override // e00.c
    public final float u(kotlinx.serialization.descriptors.f descriptor, int i11) {
        Intrinsics.h(descriptor, "descriptor");
        return O(X(descriptor, i11));
    }

    @Override // e00.e
    public final double v() {
        return M(Y());
    }

    @Override // e00.e
    public final boolean w() {
        return J(Y());
    }

    @Override // e00.e
    public final char x() {
        return L(Y());
    }

    @Override // e00.c
    public final Object y(kotlinx.serialization.descriptors.f descriptor, int i11, final kotlinx.serialization.a deserializer, final Object obj) {
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(deserializer, "deserializer");
        return a0(X(descriptor, i11), new Function0<Object>() { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TaggedDecoder.this.I(deserializer, obj);
            }
        });
    }

    @Override // e00.e
    public final String z() {
        return U(Y());
    }
}
