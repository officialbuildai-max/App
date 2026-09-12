package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import kotlin.jvm.internal.DefaultConstructorMarker;
import w.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0041a f3800d = new C0041a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f3801e = 8;

    /* renamed from: f, reason: collision with root package name */
    private static final a f3802f = new a(0, new Object[0]);

    /* renamed from: a, reason: collision with root package name */
    private int f3803a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f3804b;

    /* renamed from: c, reason: collision with root package name */
    private e f3805c;

    /* renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0041a {
        private C0041a() {
        }

        public /* synthetic */ C0041a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return a.f3802f;
        }
    }

    public a(int i11, Object[] objArr) {
        this(i11, objArr, null);
    }

    public a(int i11, Object[] objArr, e eVar) {
        this.f3803a = i11;
        this.f3804b = objArr;
        this.f3805c = eVar;
    }
}
