package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.o0;

/* loaded from: classes.dex */
public abstract class LazyListStateKt {

    /* renamed from: a, reason: collision with root package name */
    private static final float f3009a = o0.i.g(1);

    /* renamed from: b, reason: collision with root package name */
    private static final m f3010b = new m(null, 0, false, 0.0f, new a(), 0.0f, false, o0.a(EmptyCoroutineContext.INSTANCE), o0.g.b(1.0f, 0.0f, 2, null), o0.c.b(0, 0, 0, 0, 15, null), CollectionsKt.l(), 0, 0, 0, false, Orientation.Vertical, 0, 0, null);

    /* loaded from: classes.dex */
    public static final class a implements androidx.compose.ui.layout.v {

        /* renamed from: a, reason: collision with root package name */
        private final int f3011a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3012b;

        /* renamed from: c, reason: collision with root package name */
        private final Map f3013c = MapsKt.h();

        a() {
        }

        @Override // androidx.compose.ui.layout.v
        public int getHeight() {
            return this.f3012b;
        }

        @Override // androidx.compose.ui.layout.v
        public int getWidth() {
            return this.f3011a;
        }

        @Override // androidx.compose.ui.layout.v
        public Map v() {
            return this.f3013c;
        }

        @Override // androidx.compose.ui.layout.v
        public void w() {
        }

        @Override // androidx.compose.ui.layout.v
        public /* synthetic */ Function1 x() {
            return androidx.compose.ui.layout.u.a(this);
        }
    }

    public static final LazyListState c(final int i11, final int i12, androidx.compose.runtime.i iVar, int i13, int i14) {
        if ((i14 & 1) != 0) {
            i11 = 0;
        }
        if ((i14 & 2) != 0) {
            i12 = 0;
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(1470655220, i13, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:80)");
        }
        Object[] objArr = new Object[0];
        androidx.compose.runtime.saveable.d a11 = LazyListState.f2981y.a();
        boolean z10 = ((((i13 & 14) ^ 6) > 4 && iVar.c(i11)) || (i13 & 6) == 4) | ((((i13 & 112) ^ 48) > 32 && iVar.c(i12)) || (i13 & 48) == 32);
        Object y10 = iVar.y();
        if (z10 || y10 == androidx.compose.runtime.i.f3811a.a()) {
            y10 = new Function0<LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final LazyListState invoke() {
                    return new LazyListState(i11, i12);
                }
            };
            iVar.p(y10);
        }
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.c(objArr, a11, null, (Function0) y10, iVar, 0, 4);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return lazyListState;
    }
}
