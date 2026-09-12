package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.t1;
import androidx.compose.runtime.v1;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public abstract class LazyLayoutPinnableItemKt {
    public static final void a(final Object obj, final int i11, final w wVar, final Function2 function2, androidx.compose.runtime.i iVar, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(-2079116560);
        if ((i12 & 6) == 0) {
            i13 = (g11.A(obj) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= g11.c(i11) ? 32 : 16;
        }
        if ((i12 & 384) == 0) {
            i13 |= g11.A(wVar) ? 256 : 128;
        }
        if ((i12 & 3072) == 0) {
            i13 |= g11.A(function2) ? 2048 : 1024;
        }
        if ((i13 & 1171) == 1170 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-2079116560, i13, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:52)");
            }
            boolean O = g11.O(obj) | g11.O(wVar);
            Object y10 = g11.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new v(obj, wVar);
                g11.p(y10);
            }
            final v vVar = (v) y10;
            vVar.g(i11);
            vVar.i((androidx.compose.ui.layout.f0) g11.l(PinnableContainerKt.a()));
            boolean O2 = g11.O(vVar);
            Object y11 = g11.y();
            if (O2 || y11 == androidx.compose.runtime.i.f3811a.a()) {
                y11 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1

                    /* loaded from: classes.dex */
                    public static final class a implements androidx.compose.runtime.c0 {

                        /* renamed from: a, reason: collision with root package name */
                        final /* synthetic */ v f3063a;

                        public a(v vVar) {
                            this.f3063a = vVar;
                        }

                        @Override // androidx.compose.runtime.c0
                        public void dispose() {
                            this.f3063a.f();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                        return new a(v.this);
                    }
                };
                g11.p(y11);
            }
            androidx.compose.runtime.g0.a(vVar, (Function1) y11, g11, 0);
            CompositionLocalKt.a(PinnableContainerKt.a().d(vVar), function2, g11, ((i13 >> 6) & 112) | t1.f4116i);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2
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
                    LazyLayoutPinnableItemKt.a(obj, i11, wVar, function2, iVar2, v1.a(i12 | 1));
                }
            });
        }
    }
}
