package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.input.nestedscroll.e;
import androidx.compose.ui.layout.m;
import androidx.compose.ui.node.LayoutNode;
import kotlin.coroutines.Continuation;
import y.g;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final a f6593a = new a();

    /* loaded from: classes.dex */
    public static final class a implements androidx.compose.ui.input.nestedscroll.b {
        a() {
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ long B0(long j11, int i11) {
            return androidx.compose.ui.input.nestedscroll.a.d(this, j11, i11);
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ Object G(long j11, long j12, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.a(this, j11, j12, continuation);
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ Object I0(long j11, Continuation continuation) {
            return androidx.compose.ui.input.nestedscroll.a.c(this, j11, continuation);
        }

        @Override // androidx.compose.ui.input.nestedscroll.b
        public /* synthetic */ long g0(long j11, long j12, int i11) {
            return androidx.compose.ui.input.nestedscroll.a.b(this, j11, j12, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, LayoutNode layoutNode) {
        long e11 = m.e(layoutNode.o());
        int round = Math.round(g.m(e11));
        int round2 = Math.round(g.n(e11));
        view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(int i11) {
        return i11 * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float h(float f11) {
        return f11 * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i11) {
        return i11 == 0 ? e.f5014a.b() : e.f5014a.a();
    }
}
