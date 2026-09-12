package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.r2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;

/* loaded from: classes.dex */
public abstract class LazyListItemProviderKt {
    public static final Function0 a(final LazyListState lazyListState, Function1 function1, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-343736148, i11, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:43)");
        }
        final a3 i12 = r2.i(function1, iVar, (i11 >> 3) & 14);
        boolean z10 = (((i11 & 14) ^ 6) > 4 && iVar.O(lazyListState)) || (i11 & 6) == 4;
        Object y10 = iVar.y();
        if (z10 || y10 == androidx.compose.runtime.i.f3811a.a()) {
            final c cVar = new c();
            final a3 b11 = r2.b(r2.h(), new Function0<LazyListIntervalContent>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$intervalContentState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final LazyListIntervalContent invoke() {
                    return new LazyListIntervalContent((Function1) a3.this.getValue());
                }
            });
            final a3 b12 = r2.b(r2.h(), new Function0<LazyListItemProviderImpl>() { // from class: androidx.compose.foundation.lazy.LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$itemProviderState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final LazyListItemProviderImpl invoke() {
                    LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) a3.this.getValue();
                    return new LazyListItemProviderImpl(lazyListState, lazyListIntervalContent, cVar, new NearestRangeKeyIndexMap(lazyListState.v(), lazyListIntervalContent));
                }
            });
            y10 = new PropertyReference0Impl(b12) { // from class: androidx.compose.foundation.lazy.LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.jvm.internal.PropertyReference0
                public Object get() {
                    return ((a3) this.receiver).getValue();
                }
            };
            iVar.p(y10);
        }
        KProperty0 kProperty0 = (KProperty0) y10;
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return kProperty0;
    }
}
