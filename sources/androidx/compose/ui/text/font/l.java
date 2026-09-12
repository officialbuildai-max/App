package androidx.compose.ui.text.font;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6208c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f6209d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final m f6210e = new m();

    /* renamed from: f, reason: collision with root package name */
    private static final j0 f6211f = new b(j0.f68015k1);

    /* renamed from: a, reason: collision with root package name */
    private final e f6212a;

    /* renamed from: b, reason: collision with root package name */
    private n0 f6213b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends AbstractCoroutineContextElement implements j0 {
        public b(j0.a aVar) {
            super(aVar);
        }

        @Override // kotlinx.coroutines.j0
        public void o(CoroutineContext coroutineContext, Throwable th2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public l(e eVar, CoroutineContext coroutineContext) {
        this.f6212a = eVar;
        this.f6213b = o0.a(f6211f.plus(androidx.compose.ui.text.platform.j.a()).plus(coroutineContext).plus(l2.a((t1) coroutineContext.get(t1.f68119l1))));
    }

    public /* synthetic */ l(e eVar, CoroutineContext coroutineContext, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new e() : eVar, (i11 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext);
    }

    public e0 a(d0 d0Var, u uVar, Function1 function1, Function1 function12) {
        d0Var.c();
        return null;
    }
}
