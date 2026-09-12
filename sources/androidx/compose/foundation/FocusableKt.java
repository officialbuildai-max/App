package androidx.compose.foundation;

import androidx.compose.ui.node.l0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.y0;
import androidx.compose.ui.platform.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public abstract class FocusableKt {

    /* renamed from: a, reason: collision with root package name */
    private static final y0 f2667a;

    /* renamed from: b, reason: collision with root package name */
    private static final FocusableKt$FocusableInNonTouchModeElement$1 f2668b;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1] */
    static {
        f2667a = new y0(InspectableValueKt.b() ? new Function1<z0, Unit>() { // from class: androidx.compose.foundation.FocusableKt$special$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((z0) obj);
                return Unit.f67184a;
            }

            public final void invoke(z0 z0Var) {
                z0Var.b("focusGroup");
            }
        } : InspectableValueKt.a());
        f2668b = new l0() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
            public boolean equals(Object other) {
                return this == other;
            }

            public int hashCode() {
                return r.a(this);
            }

            @Override // androidx.compose.ui.node.l0
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public q a() {
                return new q();
            }

            @Override // androidx.compose.ui.node.l0
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void i(q node) {
            }
        };
    }

    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, boolean z10, p.i iVar) {
        return fVar.e(z10 ? new FocusableElement(iVar) : androidx.compose.ui.f.f4253a);
    }
}
