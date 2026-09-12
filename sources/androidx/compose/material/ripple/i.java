package androidx.compose.material.ripple;

import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;

/* loaded from: classes.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3579a = a.f3580a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f3580a = new a();

        private a() {
        }

        public final c a(long j11, boolean z10) {
            c cVar;
            c cVar2;
            c cVar3;
            if (!z10) {
                cVar = RippleThemeKt.f3563d;
                return cVar;
            }
            if (w1.i(j11) > 0.5d) {
                cVar3 = RippleThemeKt.f3561b;
                return cVar3;
            }
            cVar2 = RippleThemeKt.f3562c;
            return cVar2;
        }

        public final long b(long j11, boolean z10) {
            return (z10 || ((double) w1.i(j11)) >= 0.5d) ? j11 : u1.f4733b.f();
        }
    }

    long a(androidx.compose.runtime.i iVar, int i11);

    c b(androidx.compose.runtime.i iVar, int i11);
}
