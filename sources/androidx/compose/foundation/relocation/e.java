package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.layout.l;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.node.h;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import y.i;

/* loaded from: classes.dex */
public abstract class e {

    /* loaded from: classes.dex */
    static final class a implements androidx.compose.foundation.relocation.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.compose.ui.node.f f3239a;

        a(androidx.compose.ui.node.f fVar) {
            this.f3239a = fVar;
        }

        @Override // androidx.compose.foundation.relocation.a
        public final Object U(l lVar, Function0 function0, Continuation continuation) {
            View a11 = h.a(this.f3239a);
            long e11 = m.e(lVar);
            i iVar = (i) function0.invoke();
            i q11 = iVar != null ? iVar.q(e11) : null;
            if (q11 != null) {
                a11.requestRectangleOnScreen(e.c(q11), false);
            }
            return Unit.f67184a;
        }
    }

    public static final androidx.compose.foundation.relocation.a b(androidx.compose.ui.node.f fVar) {
        return new a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect c(i iVar) {
        return new Rect((int) iVar.f(), (int) iVar.i(), (int) iVar.g(), (int) iVar.c());
    }
}
