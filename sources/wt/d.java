package wt;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes7.dex */
public final class d implements wt.b {

    /* renamed from: g, reason: collision with root package name */
    public static final a f78075g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private Set f78076b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final String f78077c = d.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private final n0 f78078d = o0.a(y0.c());

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f78079e = LazyKt.b(new Function0() { // from class: wt.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            st.c b11;
            b11 = d.b();
            return b11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private final b f78080f = new b();

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final st.c b() {
        tt.a b11 = ys.a.f79179a.b();
        if (b11 != null) {
            return b11.b();
        }
        return null;
    }

    @Override // wt.b
    public void init() {
    }
}
