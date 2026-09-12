package androidx.compose.foundation.gestures;

import androidx.compose.foundation.f0;
import androidx.compose.ui.input.pointer.h0;
import androidx.compose.ui.input.pointer.w;
import androidx.compose.ui.j;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public abstract class ScrollableKt {

    /* renamed from: a */
    private static final Function1 f2760a = new Function1<w, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(w wVar) {
            return Boolean.valueOf(!h0.g(wVar.n(), h0.f5073a.b()));
        }
    };

    /* renamed from: b */
    private static final k f2761b = new b();

    /* renamed from: c */
    private static final androidx.compose.ui.j f2762c = new a();

    /* renamed from: d */
    private static final c f2763d = new c();

    /* loaded from: classes.dex */
    public static final class a implements androidx.compose.ui.j {
        a() {
        }

        @Override // kotlin.coroutines.CoroutineContext
        public Object fold(Object obj, Function2 function2) {
            return j.a.a(this, obj, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext.Element get(CoroutineContext.Key key) {
            return j.a.b(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element
        public /* synthetic */ CoroutineContext.Key getKey() {
            return androidx.compose.ui.i.a(this);
        }

        @Override // androidx.compose.ui.j
        public float k() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key key) {
            return j.a.c(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return j.a.d(this, coroutineContext);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements k {
        b() {
        }

        @Override // androidx.compose.foundation.gestures.k
        public float a(float f11) {
            return f11;
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements o0.e {
        c() {
        }

        @Override // o0.n
        public float C0() {
            return 1.0f;
        }

        @Override // o0.e
        public /* synthetic */ float E0(float f11) {
            return o0.d.e(this, f11);
        }

        @Override // o0.n
        public /* synthetic */ long H(float f11) {
            return o0.m.b(this, f11);
        }

        @Override // o0.n
        public /* synthetic */ float J(long j11) {
            return o0.m.a(this, j11);
        }

        @Override // o0.e
        public /* synthetic */ long Q(float f11) {
            return o0.d.g(this, f11);
        }

        @Override // o0.e
        public /* synthetic */ long Q0(long j11) {
            return o0.d.f(this, j11);
        }

        @Override // o0.e
        public /* synthetic */ int c0(float f11) {
            return o0.d.a(this, f11);
        }

        @Override // o0.e
        public float getDensity() {
            return 1.0f;
        }

        @Override // o0.e
        public /* synthetic */ float h0(long j11) {
            return o0.d.d(this, j11);
        }

        @Override // o0.e
        public /* synthetic */ float x0(int i11) {
            return o0.d.c(this, i11);
        }

        @Override // o0.e
        public /* synthetic */ float y0(float f11) {
            return o0.d.b(this, f11);
        }
    }

    public static final androidx.compose.ui.j e() {
        return f2762c;
    }

    public static final androidx.compose.ui.f f(androidx.compose.ui.f fVar, o oVar, Orientation orientation, f0 f0Var, boolean z10, boolean z11, g gVar, p.i iVar, d dVar) {
        return fVar.e(new ScrollableElement(oVar, orientation, f0Var, z10, z11, gVar, iVar, dVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(androidx.compose.foundation.gestures.ScrollingLogic r11, long r12, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r11 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r11 = (kotlin.jvm.internal.Ref.FloatRef) r11
            java.lang.Object r12 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r12 = (androidx.compose.foundation.gestures.ScrollingLogic) r12
            kotlin.ResultKt.b(r14)
            r14 = r11
            r11 = r12
            goto L5c
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            kotlin.ResultKt.b(r14)
            kotlin.jvm.internal.Ref$FloatRef r14 = new kotlin.jvm.internal.Ref$FloatRef
            r14.<init>()
            androidx.compose.foundation.MutatePriority r2 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2 r10 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2
            r9 = 0
            r4 = r10
            r5 = r11
            r6 = r12
            r8 = r14
            r4.<init>(r5, r6, r8, r9)
            r0.L$0 = r11
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r12 = r11.v(r2, r10, r0)
            if (r12 != r1) goto L5c
            return r1
        L5c:
            float r12 = r14.element
            long r11 = r11.B(r12)
            y.g r11 = y.g.d(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.g(androidx.compose.foundation.gestures.ScrollingLogic, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
