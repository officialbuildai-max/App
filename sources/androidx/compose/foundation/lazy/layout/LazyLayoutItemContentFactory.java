package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class LazyLayoutItemContentFactory {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.saveable.a f3053a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f3054b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f3055c = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class CachedItemContent {

        /* renamed from: a, reason: collision with root package name */
        private final Object f3056a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f3057b;

        /* renamed from: c, reason: collision with root package name */
        private int f3058c;

        /* renamed from: d, reason: collision with root package name */
        private Function2 f3059d;

        public CachedItemContent(int i11, Object obj, Object obj2) {
            this.f3056a = obj;
            this.f3057b = obj2;
            this.f3058c = i11;
        }

        private final Function2 c() {
            final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = LazyLayoutItemContentFactory.this;
            return androidx.compose.runtime.internal.b.b(1403994769, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar, int i11) {
                    androidx.compose.runtime.saveable.a aVar;
                    if ((i11 & 3) == 2 && iVar.h()) {
                        iVar.G();
                        return;
                    }
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.Q(1403994769, i11, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:91)");
                    }
                    m mVar = (m) LazyLayoutItemContentFactory.this.d().invoke();
                    int f11 = this.f();
                    if ((f11 >= mVar.getItemCount() || !Intrinsics.c(mVar.b(f11), this.g())) && (f11 = mVar.a(this.g())) != -1) {
                        this.f3058c = f11;
                    }
                    int i12 = f11;
                    if (i12 != -1) {
                        iVar.P(-660479623);
                        aVar = LazyLayoutItemContentFactory.this.f3053a;
                        LazyLayoutItemContentFactoryKt.b(mVar, k0.a(aVar), i12, k0.a(this.g()), iVar, 0);
                        iVar.K();
                    } else {
                        iVar.P(-660272047);
                        iVar.K();
                    }
                    Object g11 = this.g();
                    boolean A = iVar.A(this);
                    final LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = this;
                    Object y10 = iVar.y();
                    if (A || y10 == androidx.compose.runtime.i.f3811a.a()) {
                        y10 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$1$1

                            /* loaded from: classes.dex */
                            public static final class a implements androidx.compose.runtime.c0 {

                                /* renamed from: a, reason: collision with root package name */
                                final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent f3061a;

                                public a(LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
                                    this.f3061a = cachedItemContent;
                                }

                                @Override // androidx.compose.runtime.c0
                                public void dispose() {
                                    this.f3061a.f3059d = null;
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                                return new a(LazyLayoutItemContentFactory.CachedItemContent.this);
                            }
                        };
                        iVar.p(y10);
                    }
                    androidx.compose.runtime.g0.a(g11, (Function1) y10, iVar, 0);
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.P();
                    }
                }
            });
        }

        public final Function2 d() {
            Function2 function2 = this.f3059d;
            if (function2 != null) {
                return function2;
            }
            Function2 c11 = c();
            this.f3059d = c11;
            return c11;
        }

        public final Object e() {
            return this.f3057b;
        }

        public final int f() {
            return this.f3058c;
        }

        public final Object g() {
            return this.f3056a;
        }
    }

    public LazyLayoutItemContentFactory(androidx.compose.runtime.saveable.a aVar, Function0 function0) {
        this.f3053a = aVar;
        this.f3054b = function0;
    }

    public final Function2 b(int i11, Object obj, Object obj2) {
        CachedItemContent cachedItemContent = (CachedItemContent) this.f3055c.get(obj);
        if (cachedItemContent != null && cachedItemContent.f() == i11 && Intrinsics.c(cachedItemContent.e(), obj2)) {
            return cachedItemContent.d();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(i11, obj, obj2);
        this.f3055c.put(obj, cachedItemContent2);
        return cachedItemContent2.d();
    }

    public final Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = (CachedItemContent) this.f3055c.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.e();
        }
        m mVar = (m) this.f3054b.invoke();
        int a11 = mVar.a(obj);
        if (a11 != -1) {
            return mVar.c(a11);
        }
        return null;
    }

    public final Function0 d() {
        return this.f3054b;
    }
}
