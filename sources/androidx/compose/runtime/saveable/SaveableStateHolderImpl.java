package androidx.compose.runtime.saveable;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.c0;
import androidx.compose.runtime.d0;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.t1;
import androidx.compose.runtime.v1;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
final class SaveableStateHolderImpl implements androidx.compose.runtime.saveable.a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f3969d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final d f3970e = SaverKt.a(new Function2<e, SaveableStateHolderImpl, Map<Object, Map<String, ? extends List<? extends Object>>>>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Map<Object, Map<String, List<Object>>> invoke(e eVar, SaveableStateHolderImpl saveableStateHolderImpl) {
            Map<Object, Map<String, List<Object>>> h11;
            h11 = saveableStateHolderImpl.h();
            return h11;
        }
    }, new Function1<Map<Object, Map<String, ? extends List<? extends Object>>>, SaveableStateHolderImpl>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final SaveableStateHolderImpl invoke(Map<Object, Map<String, List<Object>>> map) {
            return new SaveableStateHolderImpl(map);
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private final Map f3971a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f3972b;

    /* renamed from: c, reason: collision with root package name */
    private b f3973c;

    /* loaded from: classes.dex */
    public final class RegistryHolder {

        /* renamed from: a, reason: collision with root package name */
        private final Object f3974a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f3975b = true;

        /* renamed from: c, reason: collision with root package name */
        private final b f3976c;

        public RegistryHolder(Object obj) {
            this.f3974a = obj;
            this.f3976c = SaveableStateRegistryKt.a((Map) SaveableStateHolderImpl.this.f3971a.get(obj), new Function1<Object, Boolean>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$RegistryHolder$registry$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj2) {
                    b g11 = SaveableStateHolderImpl.this.g();
                    return Boolean.valueOf(g11 != null ? g11.a(obj2) : true);
                }
            });
        }

        public final b a() {
            return this.f3976c;
        }

        public final void b(Map map) {
            if (this.f3975b) {
                Map e11 = this.f3976c.e();
                if (e11.isEmpty()) {
                    map.remove(this.f3974a);
                } else {
                    map.put(this.f3974a, e11);
                }
            }
        }

        public final void c(boolean z10) {
            this.f3975b = z10;
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return SaveableStateHolderImpl.f3970e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SaveableStateHolderImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SaveableStateHolderImpl(Map map) {
        this.f3971a = map;
        this.f3972b = new LinkedHashMap();
    }

    public /* synthetic */ SaveableStateHolderImpl(Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new LinkedHashMap() : map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map h() {
        Map w11 = MapsKt.w(this.f3971a);
        Iterator it = this.f3972b.values().iterator();
        while (it.hasNext()) {
            ((RegistryHolder) it.next()).b(w11);
        }
        if (w11.isEmpty()) {
            return null;
        }
        return w11;
    }

    @Override // androidx.compose.runtime.saveable.a
    public void c(Object obj) {
        RegistryHolder registryHolder = (RegistryHolder) this.f3972b.get(obj);
        if (registryHolder != null) {
            registryHolder.c(false);
        } else {
            this.f3971a.remove(obj);
        }
    }

    @Override // androidx.compose.runtime.saveable.a
    public void d(final Object obj, final Function2 function2, i iVar, final int i11) {
        int i12;
        i g11 = iVar.g(-1198538093);
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
            if (k.H()) {
                k.Q(-1198538093, i12, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:75)");
            }
            g11.E(Sdk$SDKError.Reason.PLACEMENT_AD_TYPE_MISMATCH_VALUE, obj);
            Object y10 = g11.y();
            i.a aVar = i.f3811a;
            if (y10 == aVar.a()) {
                b bVar = this.f3973c;
                if (!(bVar != null ? bVar.a(obj) : true)) {
                    throw new IllegalArgumentException(("Type of the key " + obj + " is not supported. On Android you can only use types which can be stored inside the Bundle.").toString());
                }
                y10 = new RegistryHolder(obj);
                g11.p(y10);
            }
            final RegistryHolder registryHolder = (RegistryHolder) y10;
            CompositionLocalKt.a(SaveableStateRegistryKt.d().d(registryHolder.a()), function2, g11, (i12 & 112) | t1.f4116i);
            Unit unit = Unit.f67184a;
            boolean A = g11.A(this) | g11.A(obj) | g11.A(registryHolder);
            Object y11 = g11.y();
            if (A || y11 == aVar.a()) {
                y11 = new Function1<d0, c0>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$1

                    /* loaded from: classes.dex */
                    public static final class a implements c0 {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ SaveableStateHolderImpl.RegistryHolder f3978a;

                        /* renamed from: b, reason: collision with root package name */
                        final /* synthetic */ SaveableStateHolderImpl f3979b;

                        /* renamed from: c, reason: collision with root package name */
                        final /* synthetic */ Object f3980c;

                        public a(SaveableStateHolderImpl.RegistryHolder registryHolder, SaveableStateHolderImpl saveableStateHolderImpl, Object obj) {
                            this.f3978a = registryHolder;
                            this.f3979b = saveableStateHolderImpl;
                            this.f3980c = obj;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            Map map;
                            this.f3978a.b(this.f3979b.f3971a);
                            map = this.f3979b.f3972b;
                            map.remove(this.f3980c);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final c0 invoke(d0 d0Var) {
                        Map map;
                        Map map2;
                        map = SaveableStateHolderImpl.this.f3972b;
                        boolean containsKey = map.containsKey(obj);
                        Object obj2 = obj;
                        if (!containsKey) {
                            SaveableStateHolderImpl.this.f3971a.remove(obj);
                            map2 = SaveableStateHolderImpl.this.f3972b;
                            map2.put(obj, registryHolder);
                            return new a(registryHolder, SaveableStateHolderImpl.this, obj);
                        }
                        throw new IllegalArgumentException(("Key " + obj2 + " was used multiple times ").toString());
                    }
                };
                g11.p(y11);
            }
            g0.a(unit, (Function1) y11, g11, 6);
            g11.w();
            if (k.H()) {
                k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((i) obj2, ((Number) obj3).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(i iVar2, int i13) {
                    SaveableStateHolderImpl.this.d(obj, function2, iVar2, v1.a(i11 | 1));
                }
            });
        }
    }

    public final b g() {
        return this.f3973c;
    }

    public final void i(b bVar) {
        this.f3973c = bVar;
    }
}
