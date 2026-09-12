package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class ComposableSingletons$CompositionKt {

    /* renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$CompositionKt f3634a = new ComposableSingletons$CompositionKt();

    /* renamed from: b, reason: collision with root package name */
    public static Function2 f3635b = androidx.compose.runtime.internal.b.b(954879418, false, new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.ComposableSingletons$CompositionKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }

        public final void invoke(i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (k.H()) {
                k.Q(954879418, i11, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda-1.<anonymous> (Composition.kt:623)");
            }
            if (k.H()) {
                k.P();
            }
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static Function2 f3636c = androidx.compose.runtime.internal.b.b(1918065384, false, new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.ComposableSingletons$CompositionKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }

        public final void invoke(i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (k.H()) {
                k.Q(1918065384, i11, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda-2.<anonymous> (Composition.kt:757)");
            }
            if (k.H()) {
                k.P();
            }
        }
    });

    public final Function2 a() {
        return f3635b;
    }

    public final Function2 b() {
        return f3636c;
    }
}
