package u;

import java.util.Set;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u.t;

/* loaded from: classes.dex */
public class d extends AbstractMap implements t.g {

    /* renamed from: f, reason: collision with root package name */
    public static final a f76614f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f76615g = 8;

    /* renamed from: h, reason: collision with root package name */
    private static final d f76616h = new d(t.f76639e.a(), 0);

    /* renamed from: d, reason: collision with root package name */
    private final t f76617d;

    /* renamed from: e, reason: collision with root package name */
    private final int f76618e;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            d dVar = d.f76616h;
            Intrinsics.f(dVar, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return dVar;
        }
    }

    public d(t tVar, int i11) {
        this.f76617d = tVar;
        this.f76618e = i11;
    }

    private final t.e s() {
        return new n(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f76617d.k(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.f76617d.o(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractMap
    public final Set h() {
        return s();
    }

    @Override // kotlin.collections.AbstractMap
    public int j() {
        return this.f76618e;
    }

    @Override // t.g, androidx.compose.runtime.n1
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public f builder() {
        return new f(this);
    }

    @Override // kotlin.collections.AbstractMap
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public t.e i() {
        return new p(this);
    }

    public final t u() {
        return this.f76617d;
    }

    @Override // kotlin.collections.AbstractMap
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public t.b l() {
        return new r(this);
    }

    public d w(Object obj, Object obj2) {
        t.b P = this.f76617d.P(obj != null ? obj.hashCode() : 0, obj, obj2, 0);
        return P == null ? this : new d(P.a(), size() + P.b());
    }

    public d x(Object obj) {
        t Q = this.f76617d.Q(obj != null ? obj.hashCode() : 0, obj, 0);
        return this.f76617d == Q ? this : Q == null ? f76614f.a() : new d(Q, size() - 1);
    }
}
