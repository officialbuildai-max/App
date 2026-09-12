package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public abstract class InspectableValueKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Function1 f5738a = new Function1<z0, Unit>() { // from class: androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((z0) obj);
            return Unit.f67184a;
        }

        public final void invoke(z0 z0Var) {
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static boolean f5739b;

    public static final Function1 a() {
        return f5738a;
    }

    public static final boolean b() {
        return f5739b;
    }
}
