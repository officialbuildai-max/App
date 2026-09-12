package androidx.compose.ui.scrollcapture;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RelativeScroller {

    /* renamed from: a, reason: collision with root package name */
    private final int f5973a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f5974b;

    /* renamed from: c, reason: collision with root package name */
    private float f5975c;

    public RelativeScroller(int i11, Function2 function2) {
        this.f5973a = i11;
        this.f5974b = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(float r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = (androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1 r0 = new androidx.compose.ui.scrollcapture.RelativeScroller$scrollBy$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.scrollcapture.RelativeScroller r5 = (androidx.compose.ui.scrollcapture.RelativeScroller) r5
            kotlin.ResultKt.b(r6)
            goto L4a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            kotlin.jvm.functions.Function2 r6 = r4.f5974b
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r5 = r4
        L4a:
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r0 = r5.f5975c
            float r0 = r0 + r6
            r5.f5975c = r0
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.scrollcapture.RelativeScroller.e(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float b() {
        return this.f5975c;
    }

    public final int c(int i11) {
        return RangesKt.m(i11 - MathKt.d(this.f5975c), 0, this.f5973a);
    }

    public final void d() {
        this.f5975c = 0.0f;
    }

    public final Object f(int i11, int i12, Continuation continuation) {
        if (i11 > i12) {
            throw new IllegalArgumentException(("Expected min=" + i11 + " ≤ max=" + i12).toString());
        }
        int i13 = i12 - i11;
        int i14 = this.f5973a;
        if (i13 > i14) {
            throw new IllegalArgumentException(("Expected range (" + i13 + ") to be ≤ viewportSize=" + this.f5973a).toString());
        }
        float f11 = i11;
        float f12 = this.f5975c;
        if (f11 >= f12 && i12 <= i14 + f12) {
            return Unit.f67184a;
        }
        if (f11 >= f12) {
            i11 = i12 - i14;
        }
        Object g11 = g(i11, continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }

    public final Object g(float f11, Continuation continuation) {
        Object e11 = e(f11 - this.f5975c, continuation);
        return e11 == IntrinsicsKt.f() ? e11 : Unit.f67184a;
    }
}
