package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.g2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.b;
import androidx.compose.runtime.u2;
import androidx.compose.runtime.v1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
final class LazySaveableStateHolder implements androidx.compose.runtime.saveable.b, androidx.compose.runtime.saveable.a {

    /* renamed from: d, reason: collision with root package name */
    public static final Companion f3077d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.saveable.b f3078a;

    /* renamed from: b, reason: collision with root package name */
    private final i1 f3079b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f3080c;

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final androidx.compose.runtime.saveable.d a(final androidx.compose.runtime.saveable.b bVar) {
            return SaverKt.a(new Function2<androidx.compose.runtime.saveable.e, LazySaveableStateHolder, Map<String, ? extends List<? extends Object>>>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$1
                @Override // kotlin.jvm.functions.Function2
                public final Map<String, List<Object>> invoke(androidx.compose.runtime.saveable.e eVar, LazySaveableStateHolder lazySaveableStateHolder) {
                    Map<String, List<Object>> e11 = lazySaveableStateHolder.e();
                    if (e11.isEmpty()) {
                        return null;
                    }
                    return e11;
                }
            }, new Function1<Map<String, ? extends List<? extends Object>>, LazySaveableStateHolder>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$Companion$saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final LazySaveableStateHolder invoke(Map<String, ? extends List<? extends Object>> map) {
                    return new LazySaveableStateHolder(androidx.compose.runtime.saveable.b.this, map);
                }
            });
        }
    }

    public LazySaveableStateHolder(androidx.compose.runtime.saveable.b bVar) {
        i1 c11;
        this.f3078a = bVar;
        c11 = u2.c(null, null, 2, null);
        this.f3079b = c11;
        this.f3080c = new LinkedHashSet();
    }

    public LazySaveableStateHolder(final androidx.compose.runtime.saveable.b bVar, Map map) {
        this(SaveableStateRegistryKt.a(map, new Function1<Object, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                androidx.compose.runtime.saveable.b bVar2 = androidx.compose.runtime.saveable.b.this;
                return Boolean.valueOf(bVar2 != null ? bVar2.a(obj) : true);
            }
        }));
    }

    @Override // androidx.compose.runtime.saveable.b
    public boolean a(Object obj) {
        return this.f3078a.a(obj);
    }

    @Override // androidx.compose.runtime.saveable.b
    public b.a b(String str, Function0 function0) {
        return this.f3078a.b(str, function0);
    }

    @Override // androidx.compose.runtime.saveable.a
    public void c(Object obj) {
        androidx.compose.runtime.saveable.a h11 = h();
        if (h11 == null) {
            throw new IllegalArgumentException("null wrappedHolder");
        }
        h11.c(obj);
    }

    @Override // androidx.compose.runtime.saveable.a
    public void d(final Object obj, final Function2 function2, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i g11 = iVar.g(-697180401);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(obj) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.A(function2) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.A(this) ? 256 : 128;
        }
        if ((i12 & 147) == 146 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-697180401, i12, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)");
            }
            androidx.compose.runtime.saveable.a h11 = h();
            if (h11 == null) {
                throw new IllegalArgumentException("null wrappedHolder");
            }
            int i13 = i12 & 14;
            h11.d(obj, function2, g11, i12 & 126);
            boolean A = g11.A(this) | g11.A(obj);
            Object y10 = g11.y();
            if (A || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$2$1

                    /* loaded from: classes.dex */
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ LazySaveableStateHolder f3081a;

                        /* renamed from: b, reason: collision with root package name */
                        final /* synthetic */ Object f3082b;

                        public a(LazySaveableStateHolder lazySaveableStateHolder, Object obj) {
                            this.f3081a = lazySaveableStateHolder;
                            this.f3082b = obj;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            Set set;
                            set = this.f3081a.f3080c;
                            set.add(this.f3082b);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        Set set;
                        set = LazySaveableStateHolder.this.f3080c;
                        set.remove(obj);
                        return new a(LazySaveableStateHolder.this, obj);
                    }
                };
                g11.p(y10);
            }
            androidx.compose.runtime.g0.a(obj, (Function1) y10, g11, i13);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolder$SaveableStateProvider$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    LazySaveableStateHolder.this.d(obj, function2, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.runtime.saveable.b
    public Map e() {
        androidx.compose.runtime.saveable.a h11 = h();
        if (h11 != null) {
            Iterator it = this.f3080c.iterator();
            while (it.hasNext()) {
                h11.c(it.next());
            }
        }
        return this.f3078a.e();
    }

    @Override // androidx.compose.runtime.saveable.b
    public Object f(String str) {
        return this.f3078a.f(str);
    }

    public final androidx.compose.runtime.saveable.a h() {
        return (androidx.compose.runtime.saveable.a) this.f3079b.getValue();
    }

    public final void i(androidx.compose.runtime.saveable.a aVar) {
        this.f3079b.setValue(aVar);
    }
}
