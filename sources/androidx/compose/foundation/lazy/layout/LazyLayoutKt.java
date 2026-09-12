package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
public abstract class LazyLayoutKt {
    public static final void a(final Function0 function0, final androidx.compose.ui.f fVar, final x xVar, final Function2 function2, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(2002163445);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 6) == 0) {
            i13 = (g11.A(function0) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i14 = i12 & 2;
        if (i14 != 0) {
            i13 |= 48;
        } else if ((i11 & 48) == 0) {
            i13 |= g11.O(fVar) ? 32 : 16;
        }
        int i15 = i12 & 4;
        if (i15 != 0) {
            i13 |= 384;
        } else if ((i11 & 384) == 0) {
            i13 |= g11.O(xVar) ? 256 : 128;
        }
        if ((i12 & 8) != 0) {
            i13 |= 3072;
        } else if ((i11 & 3072) == 0) {
            i13 |= g11.A(function2) ? 2048 : 1024;
        }
        if ((i13 & 1171) == 1170 && g11.h()) {
            g11.G();
        } else {
            if (i14 != 0) {
                fVar = androidx.compose.ui.f.f4253a;
            }
            if (i15 != 0) {
                xVar = null;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(2002163445, i13, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:78)");
            }
            final a3 i16 = r2.i(function0, g11, i13 & 14);
            LazySaveableStateHolderKt.a(androidx.compose.runtime.internal.b.d(-1488997347, true, new Function3<androidx.compose.runtime.saveable.a, androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((androidx.compose.runtime.saveable.a) obj, (androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.saveable.a aVar, androidx.compose.runtime.i iVar2, int i17) {
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.Q(-1488997347, i17, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:82)");
                    }
                    final a3 a3Var = i16;
                    Object y10 = iVar2.y();
                    i.a aVar2 = androidx.compose.runtime.i.f3811a;
                    if (y10 == aVar2.a()) {
                        y10 = new LazyLayoutItemContentFactory(aVar, new Function0<m>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$itemContentFactory$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final m invoke() {
                                return (m) ((Function0) a3.this.getValue()).invoke();
                            }
                        });
                        iVar2.p(y10);
                    }
                    final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) y10;
                    Object y11 = iVar2.y();
                    if (y11 == aVar2.a()) {
                        y11 = new SubcomposeLayoutState(new o(lazyLayoutItemContentFactory));
                        iVar2.p(y11);
                    }
                    final SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) y11;
                    if (x.this != null) {
                        iVar2.P(205264983);
                        final i0 d11 = x.this.d();
                        if (d11 == null) {
                            iVar2.P(6622915);
                            d11 = j0.a(iVar2, 0);
                        } else {
                            iVar2.P(6621830);
                        }
                        iVar2.K();
                        Object[] objArr = {x.this, lazyLayoutItemContentFactory, subcomposeLayoutState, d11};
                        boolean O = iVar2.O(x.this) | iVar2.A(lazyLayoutItemContentFactory) | iVar2.A(subcomposeLayoutState) | iVar2.A(d11);
                        final x xVar2 = x.this;
                        Object y12 = iVar2.y();
                        if (O || y12 == aVar2.a()) {
                            y12 = new Function1<androidx.compose.runtime.d0, androidx.compose.runtime.c0>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$1$1

                                /* loaded from: classes.dex */
                                public static final class a implements androidx.compose.runtime.c0 {

                                    /* renamed from: a, reason: collision with root package name */
                                    final /* synthetic */ x f3062a;

                                    public a(x xVar) {
                                        this.f3062a = xVar;
                                    }

                                    @Override // androidx.compose.runtime.c0
                                    public void dispose() {
                                        this.f3062a.f(null);
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final androidx.compose.runtime.c0 invoke(androidx.compose.runtime.d0 d0Var) {
                                    x.this.f(new PrefetchHandleProvider(lazyLayoutItemContentFactory, subcomposeLayoutState, d11));
                                    return new a(x.this);
                                }
                            };
                            iVar2.p(y12);
                        }
                        androidx.compose.runtime.g0.b(objArr, (Function1) y12, iVar2, 0);
                        iVar2.K();
                    } else {
                        iVar2.P(205858881);
                        iVar2.K();
                    }
                    androidx.compose.ui.f b11 = y.b(fVar, x.this);
                    boolean O2 = iVar2.O(lazyLayoutItemContentFactory) | iVar2.O(function2);
                    final Function2<q, o0.b, androidx.compose.ui.layout.v> function22 = function2;
                    Object y13 = iVar2.y();
                    if (O2 || y13 == aVar2.a()) {
                        y13 = new Function2<o0, o0.b, androidx.compose.ui.layout.v>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m47invoke0kLqBqw((o0) obj, ((o0.b) obj2).r());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final androidx.compose.ui.layout.v m47invoke0kLqBqw(o0 o0Var, long j11) {
                                return (androidx.compose.ui.layout.v) function22.invoke(new r(LazyLayoutItemContentFactory.this, o0Var), o0.b.a(j11));
                            }
                        };
                        iVar2.p(y13);
                    }
                    SubcomposeLayoutKt.b(subcomposeLayoutState, b11, (Function2) y13, iVar2, SubcomposeLayoutState.f5227f, 0);
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.P();
                    }
                }
            }, g11, 54), g11, 6);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        final androidx.compose.ui.f fVar2 = fVar;
        final x xVar2 = xVar;
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$4
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
                    LazyLayoutKt.a(function0, fVar2, xVar2, function2, iVar2, v1.a(i11 | 1), i12);
                }
            });
        }
    }
}
