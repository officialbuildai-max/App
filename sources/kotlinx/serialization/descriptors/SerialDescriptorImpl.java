package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.l1;
import kotlinx.serialization.internal.n;
import kotlinx.serialization.internal.n1;

/* loaded from: classes7.dex */
public final class SerialDescriptorImpl implements f, n {

    /* renamed from: a, reason: collision with root package name */
    private final String f68152a;

    /* renamed from: b, reason: collision with root package name */
    private final h f68153b;

    /* renamed from: c, reason: collision with root package name */
    private final int f68154c;

    /* renamed from: d, reason: collision with root package name */
    private final List f68155d;

    /* renamed from: e, reason: collision with root package name */
    private final Set f68156e;

    /* renamed from: f, reason: collision with root package name */
    private final String[] f68157f;

    /* renamed from: g, reason: collision with root package name */
    private final f[] f68158g;

    /* renamed from: h, reason: collision with root package name */
    private final List[] f68159h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean[] f68160i;

    /* renamed from: j, reason: collision with root package name */
    private final Map f68161j;

    /* renamed from: k, reason: collision with root package name */
    private final f[] f68162k;

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f68163l;

    public SerialDescriptorImpl(String serialName, h kind, int i11, List typeParameters, a builder) {
        Intrinsics.h(serialName, "serialName");
        Intrinsics.h(kind, "kind");
        Intrinsics.h(typeParameters, "typeParameters");
        Intrinsics.h(builder, "builder");
        this.f68152a = serialName;
        this.f68153b = kind;
        this.f68154c = i11;
        this.f68155d = builder.c();
        this.f68156e = CollectionsKt.P0(builder.f());
        Object[] array = builder.f().toArray(new String[0]);
        Intrinsics.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        this.f68157f = strArr;
        this.f68158g = l1.b(builder.e());
        Object[] array2 = builder.d().toArray(new List[0]);
        Intrinsics.f(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.f68159h = (List[]) array2;
        this.f68160i = CollectionsKt.M0(builder.g());
        Iterable<IndexedValue> R0 = ArraysKt.R0(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(R0, 10));
        for (IndexedValue indexedValue : R0) {
            arrayList.add(TuplesKt.a(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        this.f68161j = MapsKt.s(arrayList);
        this.f68162k = l1.b(typeParameters);
        this.f68163l = LazyKt.b(new Function0<Integer>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$_hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                f[] fVarArr;
                SerialDescriptorImpl serialDescriptorImpl = SerialDescriptorImpl.this;
                fVarArr = serialDescriptorImpl.f68162k;
                return Integer.valueOf(n1.a(serialDescriptorImpl, fVarArr));
            }
        });
    }

    private final int l() {
        return ((Number) this.f68163l.getValue()).intValue();
    }

    @Override // kotlinx.serialization.internal.n
    public Set a() {
        return this.f68156e;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        Integer num = (Integer) this.f68161j.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.f
    public h d() {
        return this.f68153b;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int e() {
        return this.f68154c;
    }

    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            f fVar = (f) obj;
            if (Intrinsics.c(i(), fVar.i()) && Arrays.equals(this.f68162k, ((SerialDescriptorImpl) obj).f68162k) && e() == fVar.e()) {
                int e11 = e();
                for (0; i11 < e11; i11 + 1) {
                    i11 = (Intrinsics.c(h(i11).i(), fVar.h(i11).i()) && Intrinsics.c(h(i11).d(), fVar.h(i11).d())) ? i11 + 1 : 0;
                }
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f(int i11) {
        return this.f68157f[i11];
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i11) {
        return this.f68159h[i11];
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        return this.f68155d;
    }

    @Override // kotlinx.serialization.descriptors.f
    public f h(int i11) {
        return this.f68158g[i11];
    }

    public int hashCode() {
        return l();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.f68152a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return f.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i11) {
        return this.f68160i[i11];
    }

    public String toString() {
        return CollectionsKt.s0(RangesKt.t(0, e()), ", ", i() + '(', ")", 0, null, new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final CharSequence invoke(int i11) {
                return SerialDescriptorImpl.this.f(i11) + ": " + SerialDescriptorImpl.this.h(i11).i();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, 24, null);
    }
}
