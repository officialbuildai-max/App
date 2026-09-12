package androidx.compose.foundation.layout;

import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
public abstract class BoxWithConstraintsKt {
    public static final void a(androidx.compose.ui.f fVar, androidx.compose.ui.b bVar, boolean z10, final Function3 function3, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(1781813501);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (g11.O(fVar) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i15 = i12 & 2;
        if (i15 != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= g11.O(bVar) ? 32 : 16;
        }
        int i16 = i12 & 4;
        if (i16 != 0) {
            i13 |= 384;
        } else if ((i11 & 384) == 0) {
            i13 |= g11.a(z10) ? 256 : 128;
        }
        if ((i12 & 8) != 0) {
            i13 |= 3072;
        } else if ((i11 & 3072) == 0) {
            i13 |= g11.A(function3) ? 2048 : 1024;
        }
        if ((i13 & 1171) == 1170 && g11.h()) {
            g11.G();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f4253a;
            }
            if (i15 != 0) {
                bVar = androidx.compose.ui.b.f4162a.m();
            }
            if (i16 != 0) {
                z10 = false;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(1781813501, i13, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:64)");
            }
            final androidx.compose.ui.layout.t h11 = BoxKt.h(bVar, z10);
            boolean O = ((i13 & 7168) == 2048) | g11.O(h11);
            Object y10 = g11.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function2<o0, o0.b, androidx.compose.ui.layout.v>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m38invoke0kLqBqw((o0) obj, ((o0.b) obj2).r());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final androidx.compose.ui.layout.v m38invoke0kLqBqw(o0 o0Var, long j11) {
                        final h hVar = new h(o0Var, j11, null);
                        Unit unit = Unit.f67184a;
                        final Function3<g, androidx.compose.runtime.i, Integer, Unit> function32 = function3;
                        return androidx.compose.ui.layout.t.this.c(o0Var, o0Var.E(unit, androidx.compose.runtime.internal.b.b(-1945019079, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                                return Unit.f67184a;
                            }

                            public final void invoke(androidx.compose.runtime.i iVar2, int i17) {
                                if ((i17 & 3) == 2 && iVar2.h()) {
                                    iVar2.G();
                                    return;
                                }
                                if (androidx.compose.runtime.k.H()) {
                                    androidx.compose.runtime.k.Q(-1945019079, i17, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:68)");
                                }
                                function32.invoke(hVar, iVar2, 0);
                                if (androidx.compose.runtime.k.H()) {
                                    androidx.compose.runtime.k.P();
                                }
                            }
                        })), j11);
                    }
                };
                g11.p(y10);
            }
            SubcomposeLayoutKt.a(fVar, (Function2) y10, g11, i13 & 14, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        final androidx.compose.ui.f fVar2 = fVar;
        final androidx.compose.ui.b bVar2 = bVar;
        final boolean z11 = z10;
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxWithConstraintsKt$BoxWithConstraints$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i17) {
                    BoxWithConstraintsKt.a(androidx.compose.ui.f.this, bVar2, z11, function3, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
