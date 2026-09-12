package androidx.compose.foundation.lazy.layout;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final i0 f3159a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1 f3160b;

    /* renamed from: c, reason: collision with root package name */
    private final f0 f3161c;

    /* renamed from: d, reason: collision with root package name */
    private PrefetchHandleProvider f3162d;

    /* loaded from: classes.dex */
    private final class a implements d0 {

        /* renamed from: a, reason: collision with root package name */
        private final List f3163a = new ArrayList();

        public a() {
        }

        @Override // androidx.compose.foundation.lazy.layout.d0
        public void a(int i11) {
            c(i11, y.a());
        }

        public final List b() {
            return this.f3163a;
        }

        public void c(int i11, long j11) {
            PrefetchHandleProvider c11 = x.this.c();
            if (c11 == null) {
                return;
            }
            this.f3163a.add(c11.c(i11, j11, x.this.f3161c));
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void cancel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public x(i0 i0Var, Function1 function1) {
        this.f3159a = i0Var;
        this.f3160b = function1;
        this.f3161c = new f0();
    }

    public /* synthetic */ x(i0 i0Var, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : i0Var, (i11 & 2) != 0 ? null : function1);
    }

    public final List b() {
        Function1 function1 = this.f3160b;
        if (function1 == null) {
            return CollectionsKt.l();
        }
        a aVar = new a();
        function1.invoke(aVar);
        return aVar.b();
    }

    public final PrefetchHandleProvider c() {
        return this.f3162d;
    }

    public final i0 d() {
        return this.f3159a;
    }

    public final b e(int i11, long j11) {
        b d11;
        PrefetchHandleProvider prefetchHandleProvider = this.f3162d;
        return (prefetchHandleProvider == null || (d11 = prefetchHandleProvider.d(i11, j11, this.f3161c)) == null) ? androidx.compose.foundation.lazy.layout.a.f3105a : d11;
    }

    public final void f(PrefetchHandleProvider prefetchHandleProvider) {
        this.f3162d = prefetchHandleProvider;
    }
}
