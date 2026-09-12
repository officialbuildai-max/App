package androidx.compose.foundation;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class t extends f.c implements m1 {

    /* renamed from: p, reason: collision with root package name */
    public static final a f3263p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f3264q = 8;

    /* renamed from: n, reason: collision with root package name */
    private Function1 f3265n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f3266o = f3263p;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public t(Function1 function1) {
        this.f3265n = function1;
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return this.f3266o;
    }

    public final void D1(androidx.compose.ui.layout.l lVar) {
        this.f3265n.invoke(lVar);
        t tVar = (t) n1.b(this);
        if (tVar != null) {
            tVar.D1(lVar);
        }
    }
}
