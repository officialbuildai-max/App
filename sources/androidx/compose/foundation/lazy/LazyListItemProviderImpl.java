package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.foundation.lazy.layout.b;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LazyListItemProviderImpl implements k {

    /* renamed from: a, reason: collision with root package name */
    private final LazyListState f2966a;

    /* renamed from: b, reason: collision with root package name */
    private final LazyListIntervalContent f2967b;

    /* renamed from: c, reason: collision with root package name */
    private final c f2968c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.compose.foundation.lazy.layout.p f2969d;

    public LazyListItemProviderImpl(LazyListState lazyListState, LazyListIntervalContent lazyListIntervalContent, c cVar, androidx.compose.foundation.lazy.layout.p pVar) {
        this.f2966a = lazyListState;
        this.f2967b = lazyListIntervalContent;
        this.f2968c = cVar;
        this.f2969d = pVar;
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public int a(Object obj) {
        return e().a(obj);
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public Object b(int i11) {
        Object b11 = e().b(i11);
        return b11 == null ? this.f2967b.e(i11) : b11;
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public Object c(int i11) {
        return this.f2967b.b(i11);
    }

    @Override // androidx.compose.foundation.lazy.k
    public c d() {
        return this.f2968c;
    }

    @Override // androidx.compose.foundation.lazy.k
    public androidx.compose.foundation.lazy.layout.p e() {
        return this.f2969d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazyListItemProviderImpl) {
            return Intrinsics.c(this.f2967b, ((LazyListItemProviderImpl) obj).f2967b);
        }
        return false;
    }

    @Override // androidx.compose.foundation.lazy.k
    public List f() {
        return this.f2967b.f();
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public void g(final int i11, final Object obj, androidx.compose.runtime.i iVar, final int i12) {
        int i13;
        androidx.compose.runtime.i g11 = iVar.g(-462424778);
        if ((i12 & 6) == 0) {
            i13 = (g11.c(i11) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 48) == 0) {
            i13 |= g11.A(obj) ? 32 : 16;
        }
        if ((i12 & 384) == 0) {
            i13 |= g11.O(this) ? 256 : 128;
        }
        if ((i13 & 147) == 146 && g11.h()) {
            g11.G();
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-462424778, i13, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:75)");
            }
            LazyLayoutPinnableItemKt.a(obj, i11, this.f2966a.w(), androidx.compose.runtime.internal.b.d(-824725566, true, new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    LazyListIntervalContent lazyListIntervalContent;
                    if ((i14 & 3) == 2 && iVar2.h()) {
                        iVar2.G();
                        return;
                    }
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.Q(-824725566, i14, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:77)");
                    }
                    lazyListIntervalContent = LazyListItemProviderImpl.this.f2967b;
                    int i15 = i11;
                    LazyListItemProviderImpl lazyListItemProviderImpl = LazyListItemProviderImpl.this;
                    b.a aVar = lazyListIntervalContent.c().get(i15);
                    ((i) aVar.c()).a().invoke(lazyListItemProviderImpl.d(), Integer.valueOf(i15 - aVar.b()), iVar2, 0);
                    if (androidx.compose.runtime.k.H()) {
                        androidx.compose.runtime.k.P();
                    }
                }
            }, g11, 54), g11, ((i13 >> 3) & 14) | 3072 | ((i13 << 3) & 112));
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                    return Unit.f67184a;
                }

                public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                    LazyListItemProviderImpl.this.g(i11, obj, iVar2, v1.a(i12 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.m
    public int getItemCount() {
        return this.f2967b.d();
    }

    public int hashCode() {
        return this.f2967b.hashCode();
    }
}
