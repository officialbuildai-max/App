package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

/* loaded from: classes7.dex */
public class PluginGeneratedSerialDescriptor implements kotlinx.serialization.descriptors.f, n {

    /* renamed from: a, reason: collision with root package name */
    private final String f68209a;

    /* renamed from: b, reason: collision with root package name */
    private final i0 f68210b;

    /* renamed from: c, reason: collision with root package name */
    private final int f68211c;

    /* renamed from: d, reason: collision with root package name */
    private int f68212d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f68213e;

    /* renamed from: f, reason: collision with root package name */
    private final List[] f68214f;

    /* renamed from: g, reason: collision with root package name */
    private List f68215g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean[] f68216h;

    /* renamed from: i, reason: collision with root package name */
    private Map f68217i;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f68218j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f68219k;

    /* renamed from: l, reason: collision with root package name */
    private final Lazy f68220l;

    public PluginGeneratedSerialDescriptor(String serialName, i0 i0Var, int i11) {
        Intrinsics.h(serialName, "serialName");
        this.f68209a = serialName;
        this.f68210b = i0Var;
        this.f68211c = i11;
        this.f68212d = -1;
        String[] strArr = new String[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            strArr[i12] = "[UNINITIALIZED]";
        }
        this.f68213e = strArr;
        int i13 = this.f68211c;
        this.f68214f = new List[i13];
        this.f68216h = new boolean[i13];
        this.f68217i = MapsKt.h();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f68218j = LazyKt.a(lazyThreadSafetyMode, new Function0<kotlinx.serialization.b[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$childSerializers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final kotlinx.serialization.b[] invoke() {
                i0 i0Var2;
                kotlinx.serialization.b[] childSerializers;
                i0Var2 = PluginGeneratedSerialDescriptor.this.f68210b;
                return (i0Var2 == null || (childSerializers = i0Var2.childSerializers()) == null) ? o1.f68300a : childSerializers;
            }
        });
        this.f68219k = LazyKt.a(lazyThreadSafetyMode, new Function0<kotlinx.serialization.descriptors.f[]>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$typeParameterDescriptors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final kotlinx.serialization.descriptors.f[] invoke() {
                i0 i0Var2;
                ArrayList arrayList;
                kotlinx.serialization.b[] typeParametersSerializers;
                i0Var2 = PluginGeneratedSerialDescriptor.this.f68210b;
                if (i0Var2 == null || (typeParametersSerializers = i0Var2.typeParametersSerializers()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(typeParametersSerializers.length);
                    for (kotlinx.serialization.b bVar : typeParametersSerializers) {
                        arrayList.add(bVar.getDescriptor());
                    }
                }
                return l1.b(arrayList);
            }
        });
        this.f68220l = LazyKt.a(lazyThreadSafetyMode, new Function0<Integer>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$_hashCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = PluginGeneratedSerialDescriptor.this;
                return Integer.valueOf(n1.a(pluginGeneratedSerialDescriptor, pluginGeneratedSerialDescriptor.p()));
            }
        });
    }

    public /* synthetic */ PluginGeneratedSerialDescriptor(String str, i0 i0Var, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i12 & 2) != 0 ? null : i0Var, i11);
    }

    public static /* synthetic */ void m(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        pluginGeneratedSerialDescriptor.l(str, z10);
    }

    private final Map n() {
        HashMap hashMap = new HashMap();
        int length = this.f68213e.length;
        for (int i11 = 0; i11 < length; i11++) {
            hashMap.put(this.f68213e[i11], Integer.valueOf(i11));
        }
        return hashMap;
    }

    private final kotlinx.serialization.b[] o() {
        return (kotlinx.serialization.b[]) this.f68218j.getValue();
    }

    private final int q() {
        return ((Number) this.f68220l.getValue()).intValue();
    }

    @Override // kotlinx.serialization.internal.n
    public Set a() {
        return this.f68217i.keySet();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean b() {
        return f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int c(String name) {
        Intrinsics.h(name, "name");
        Integer num = (Integer) this.f68217i.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.h d() {
        return i.a.f68193a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public final int e() {
        return this.f68211c;
    }

    public boolean equals(Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj instanceof PluginGeneratedSerialDescriptor) {
            kotlinx.serialization.descriptors.f fVar = (kotlinx.serialization.descriptors.f) obj;
            if (Intrinsics.c(i(), fVar.i()) && Arrays.equals(p(), ((PluginGeneratedSerialDescriptor) obj).p()) && e() == fVar.e()) {
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
        return this.f68213e[i11];
    }

    @Override // kotlinx.serialization.descriptors.f
    public List g(int i11) {
        List list = this.f68214f[i11];
        return list == null ? CollectionsKt.l() : list;
    }

    @Override // kotlinx.serialization.descriptors.f
    public List getAnnotations() {
        List list = this.f68215g;
        return list == null ? CollectionsKt.l() : list;
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f h(int i11) {
        return o()[i11].getDescriptor();
    }

    public int hashCode() {
        return q();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.f68209a;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean isInline() {
        return f.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean j(int i11) {
        return this.f68216h[i11];
    }

    public final void l(String name, boolean z10) {
        Intrinsics.h(name, "name");
        String[] strArr = this.f68213e;
        int i11 = this.f68212d + 1;
        this.f68212d = i11;
        strArr[i11] = name;
        this.f68216h[i11] = z10;
        this.f68214f[i11] = null;
        if (i11 == this.f68211c - 1) {
            this.f68217i = n();
        }
    }

    public final kotlinx.serialization.descriptors.f[] p() {
        return (kotlinx.serialization.descriptors.f[]) this.f68219k.getValue();
    }

    public String toString() {
        return CollectionsKt.s0(RangesKt.t(0, this.f68211c), ", ", i() + '(', ")", 0, null, new Function1<Integer, CharSequence>() { // from class: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final CharSequence invoke(int i11) {
                return PluginGeneratedSerialDescriptor.this.f(i11) + ": " + PluginGeneratedSerialDescriptor.this.h(i11).i();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, 24, null);
    }
}
