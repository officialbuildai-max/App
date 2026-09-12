package xm;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Build;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.h2;
import androidx.compose.runtime.s;
import androidx.compose.runtime.v1;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.p;
import androidx.view.InterfaceC1015e;
import androidx.view.ViewTreeLifecycleOwner;
import androidx.view.ViewTreeSavedStateRegistryOwner;
import androidx.view.ViewTreeViewModelStoreOwner;
import androidx.view.u;
import androidx.view.y0;
import com.blankj.utilcode.util.y;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$color;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import o0.x;

/* loaded from: classes6.dex */
public final class c {

    /* loaded from: classes6.dex */
    static final class a implements Function2 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f78500b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f78501c;

        a(int i11, int i12) {
            this.f78500b = i11;
            this.f78501c = i12;
        }

        public final void a(androidx.compose.runtime.i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(1875731887, i11, -1, "com.transsion.member.task.TaskCompleteTips.showTips.<anonymous>.<anonymous> (TaskCompleteTips.kt:78)");
            }
            c.this.c(this.f78500b, this.f78501c, iVar, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d() {
        if (com.transsion.baseui.util.c.f43558a.a(0, 2000L)) {
            return Unit.f67184a;
        }
        ak.k.p(TheRouter.c("/member/MemberActivity").z("extra_member_scroll_bottom", true));
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(c cVar, int i11, int i12, int i13, androidx.compose.runtime.i iVar, int i14) {
        cVar.c(i11, i12, iVar, v1.a(i13 | 1));
        return Unit.f67184a;
    }

    private final boolean f(Activity activity) {
        return y.d(activity) > 0;
    }

    public final void c(final int i11, final int i12, androidx.compose.runtime.i iVar, final int i13) {
        int i14;
        androidx.compose.runtime.i iVar2;
        androidx.compose.runtime.i g11 = iVar.g(-1799667828);
        if ((i13 & 6) == 0) {
            i14 = (g11.c(i11) ? 4 : 2) | i13;
        } else {
            i14 = i13;
        }
        if ((i13 & 48) == 0) {
            i14 |= g11.c(i12) ? 32 : 16;
        }
        if ((i14 & 19) == 18 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-1799667828, i14, -1, "com.transsion.member.task.TaskCompleteTips.TaskCompleteView (TaskCompleteTips.kt:100)");
            }
            Painter c11 = i0.e.c(R$mipmap.ic_succeed, g11, 0);
            b.a aVar = androidx.compose.ui.b.f4162a;
            b.c h11 = aVar.h();
            f.a aVar2 = androidx.compose.ui.f.f4253a;
            float f11 = 8;
            androidx.compose.ui.f a11 = BackgroundKt.a(SizeKt.l(aVar2, o0.i.g(i11)), i0.b.a(R$color.white_90, g11, 0), q.g.c(o0.i.g(f11)));
            g11.x(693286680);
            t b11 = a0.b(androidx.compose.foundation.layout.b.f2911a.c(), h11, g11, 48);
            g11.x(-1323940314);
            int a12 = androidx.compose.runtime.g.a(g11, 0);
            s n11 = g11.n();
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a13 = companion.a();
            Function3 a14 = LayoutKt.a(a11);
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a13);
            } else {
                g11.o();
            }
            androidx.compose.runtime.i a15 = f3.a(g11);
            f3.b(a15, b11, companion.c());
            f3.b(a15, n11, companion.e());
            Function2 b12 = companion.b();
            if (a15.e() || !Intrinsics.c(a15.y(), Integer.valueOf(a12))) {
                a15.p(Integer.valueOf(a12));
                a15.k(Integer.valueOf(a12), b12);
            }
            a14.invoke(h2.a(h2.b(g11)), g11, 0);
            g11.x(2058660585);
            d0 d0Var = d0.f2924a;
            float f12 = 16;
            e0.a(SizeKt.l(aVar2, o0.i.g(f12)), g11, 6);
            iVar2 = g11;
            ImageKt.a(c11, null, SizeKt.j(aVar2, o0.i.g(32)), null, null, 0.0f, null, g11, 432, 120);
            e0.a(SizeKt.l(aVar2, o0.i.g(f11)), iVar2, 6);
            String b13 = i0.h.b(R$string.member_task_claim_toast, new Object[]{String.valueOf(i12)}, iVar2, 0);
            long a16 = i0.b.a(R$color.gray_light_80, iVar2, 0);
            long c12 = x.c(14);
            h.a aVar3 = androidx.compose.ui.text.font.h.f6199b;
            androidx.compose.ui.text.font.s b14 = aVar3.b();
            p.a aVar4 = p.f6224b;
            TextKt.a(b13, b0.a(d0Var, PaddingKt.i(aVar2, 0.0f, o0.i.g(f12), 0.0f, o0.i.g(f12), 5, null), 1.0f, false, 2, null), a16, c12, null, aVar4.c(), b14, 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199680, 0, 130960);
            e0.a(SizeKt.l(aVar2, o0.i.g(f11)), iVar2, 6);
            androidx.compose.ui.f a17 = BackgroundKt.a(SizeKt.e(SizeKt.l(aVar2, o0.i.g(64)), o0.i.g(28)), i0.b.a(R$color.yellow_light_50, iVar2, 0), q.g.c(o0.i.g(6)));
            iVar2.P(1849434622);
            Object y10 = iVar2.y();
            if (y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function0() { // from class: xm.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d11;
                        d11 = c.d();
                        return d11;
                    }
                };
                iVar2.p(y10);
            }
            iVar2.K();
            androidx.compose.ui.f d11 = ClickableKt.d(a17, false, null, null, (Function0) y10, 7, null);
            androidx.compose.ui.b d12 = aVar.d();
            iVar2.x(733328855);
            t j11 = BoxKt.j(d12, false, iVar2, 6);
            iVar2.x(-1323940314);
            int a18 = androidx.compose.runtime.g.a(iVar2, 0);
            s n12 = iVar2.n();
            Function0 a19 = companion.a();
            Function3 a20 = LayoutKt.a(d11);
            if (!(iVar2.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar2.C();
            if (iVar2.e()) {
                iVar2.F(a19);
            } else {
                iVar2.o();
            }
            androidx.compose.runtime.i a21 = f3.a(iVar2);
            f3.b(a21, j11, companion.c());
            f3.b(a21, n12, companion.e());
            Function2 b15 = companion.b();
            if (a21.e() || !Intrinsics.c(a21.y(), Integer.valueOf(a18))) {
                a21.p(Integer.valueOf(a18));
                a21.k(Integer.valueOf(a18), b15);
            }
            a20.invoke(h2.a(h2.b(iVar2)), iVar2, 0);
            iVar2.x(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2819a;
            TextKt.a(i0.h.a(R$string.member_claim, iVar2, 0), null, i0.b.a(R$color.gray_dark_00, iVar2, 0), x.c(14), null, aVar4.d(), aVar3.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199680, 0, 130962);
            iVar2.N();
            iVar2.r();
            iVar2.N();
            iVar2.N();
            e0.a(SizeKt.l(aVar2, o0.i.g(f12)), iVar2, 6);
            iVar2.N();
            iVar2.r();
            iVar2.N();
            iVar2.N();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j12 = iVar2.j();
        if (j12 != null) {
            j12.a(new Function2() { // from class: xm.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e11;
                    e11 = c.e(c.this, i11, i12, i13, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return e11;
                }
            });
        }
    }

    public final void g(int i11) {
        boolean z10;
        boolean isInPictureInPictureMode;
        com.transsion.baselib.report.l lVar = com.transsion.baselib.report.l.f43413a;
        Activity o11 = lVar.o();
        if (Build.VERSION.SDK_INT >= 24 && o11 != null) {
            isInPictureInPictureMode = o11.isInPictureInPictureMode();
            if (isInPictureInPictureMode) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    o11 = lVar.p(lVar.b() - 1);
                    Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m1185constructorimpl(ResultKt.a(th2));
                }
            }
        }
        if (o11 == null || o11.isDestroyed() || !((z10 = o11 instanceof u))) {
            return;
        }
        int i12 = f(o11) ? 400 : o11.getResources().getConfiguration().screenWidthDp - 32;
        ComposeView composeView = new ComposeView(o11, null, 0, 6, null);
        ViewTreeLifecycleOwner.b(composeView, z10 ? (u) o11 : null);
        ViewTreeViewModelStoreOwner.b(composeView, o11 instanceof y0 ? (y0) o11 : null);
        ViewTreeSavedStateRegistryOwner.b(composeView, o11 instanceof InterfaceC1015e ? (InterfaceC1015e) o11 : null);
        composeView.setContent(androidx.compose.runtime.internal.b.b(1875731887, true, new a(i12, i11)));
        composeView.setTag(Integer.valueOf(i12));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(composeView, "translationY", -92.0f, 0.0f);
        ofFloat.setDuration(500L);
        com.tn.lib.widget.toast.core.b bVar = new com.tn.lib.widget.toast.core.b(o11);
        bVar.e(composeView);
        bVar.setDuration(1);
        bVar.setGravity(48, 0, 62);
        bVar.show();
        ofFloat.start();
    }
}
