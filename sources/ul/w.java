package ul;

import android.os.Handler;
import android.os.Looper;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.tn.lib.widget.R$color;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.videodetail.R$drawable;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.x;
import ul.w;

/* loaded from: classes6.dex */
public abstract class w {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f76938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Item f76939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1 f76940c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f76941d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ul.w$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0965a implements Function3 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FilterVal f76942a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ androidx.compose.foundation.layout.k f76943b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Function1 f76944c;

            C0965a(FilterVal filterVal, androidx.compose.foundation.layout.k kVar, Function1 function1) {
                this.f76942a = filterVal;
                this.f76943b = kVar;
                this.f76944c = function1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit c(Function1 function1, FilterVal filterVal) {
                function1.invoke(filterVal.getId());
                return Unit.f67184a;
            }

            public final void b(androidx.compose.foundation.lazy.b item, androidx.compose.runtime.i iVar, int i11) {
                Intrinsics.h(item, "$this$item");
                if ((i11 & 17) == 16 && iVar.h()) {
                    iVar.G();
                    return;
                }
                if (androidx.compose.runtime.k.H()) {
                    androidx.compose.runtime.k.Q(860266798, i11, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SingleFilterPopupWindow.kt:114)");
                }
                String name = this.f76942a.getName();
                androidx.compose.ui.text.font.s b11 = androidx.compose.ui.text.font.h.f6199b.b();
                androidx.compose.ui.text.font.p b12 = androidx.compose.ui.text.font.p.f6224b.b();
                int b13 = androidx.compose.ui.text.style.p.f6517a.b();
                long c11 = x.c(16);
                long f11 = u1.f4733b.f();
                androidx.compose.foundation.layout.k kVar = this.f76943b;
                f.a aVar = androidx.compose.ui.f.f4253a;
                androidx.compose.ui.f b14 = kVar.b(PaddingKt.g(SizeKt.d(aVar, 0.0f, 1, null), o0.i.g(16), 0.0f, 2, null), androidx.compose.ui.b.f4162a.f());
                iVar.P(-1633490746);
                boolean O = iVar.O(this.f76944c) | iVar.O(this.f76942a);
                final Function1 function1 = this.f76944c;
                final FilterVal filterVal = this.f76942a;
                Object y10 = iVar.y();
                if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                    y10 = new Function0() { // from class: ul.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c12;
                            c12 = w.a.C0965a.c(Function1.this, filterVal);
                            return c12;
                        }
                    };
                    iVar.p(y10);
                }
                iVar.K();
                TextKt.a(name, ClickableKt.d(b14, false, null, null, (Function0) y10, 7, null), f11, c11, null, b12, b11, 0L, null, null, 0L, b13, false, 0, 0, null, null, iVar, 200064, 48, 128912);
                e0.a(SizeKt.e(aVar, o0.i.g(37)), iVar, 6);
                if (androidx.compose.runtime.k.H()) {
                    androidx.compose.runtime.k.P();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                b((androidx.compose.foundation.lazy.b) obj, (androidx.compose.runtime.i) obj2, ((Number) obj3).intValue());
                return Unit.f67184a;
            }
        }

        a(long j11, Item item, Function1 function1, String str) {
            this.f76938a = j11;
            this.f76939b = item;
            this.f76940c = function1;
            this.f76941d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function1 function1) {
            function1.invoke(null);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Item item, androidx.compose.foundation.layout.k kVar, Function1 function1, androidx.compose.foundation.lazy.u LazyColumn) {
            Intrinsics.h(LazyColumn, "$this$LazyColumn");
            for (FilterVal filterVal : item.getFilterValsV2()) {
                androidx.compose.foundation.lazy.t.a(LazyColumn, filterVal.getId(), null, androidx.compose.runtime.internal.b.b(860266798, true, new C0965a(filterVal, kVar, function1)), 2, null);
            }
            return Unit.f67184a;
        }

        public final void c(androidx.compose.runtime.i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(-800641360, i11, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter.<anonymous> (SingleFilterPopupWindow.kt:65)");
            }
            f.a aVar = androidx.compose.ui.f.f4253a;
            androidx.compose.ui.f b11 = SizeKt.b(BackgroundKt.b(aVar, this.f76938a, null, 2, null), 0.0f, 1, null);
            final Item item = this.f76939b;
            final Function1 function1 = this.f76940c;
            String str = this.f76941d;
            b.a aVar2 = androidx.compose.ui.b.f4162a;
            androidx.compose.ui.layout.t h11 = BoxKt.h(aVar2.m(), false);
            int a11 = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n11 = iVar.n();
            androidx.compose.ui.f e11 = ComposedModifierKt.e(iVar, b11);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a12 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a12);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a13 = f3.a(iVar);
            f3.b(a13, h11, companion.c());
            f3.b(a13, n11, companion.e());
            Function2 b12 = companion.b();
            if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
                a13.p(Integer.valueOf(a11));
                a13.k(Integer.valueOf(a11), b12);
            }
            f3.b(a13, e11, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2819a;
            androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.f2911a;
            androidx.compose.ui.layout.t a14 = androidx.compose.foundation.layout.i.a(bVar.d(), aVar2.i(), iVar, 0);
            int a15 = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n12 = iVar.n();
            androidx.compose.ui.f e12 = ComposedModifierKt.e(iVar, aVar);
            Function0 a16 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a16);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a17 = f3.a(iVar);
            f3.b(a17, a14, companion.c());
            f3.b(a17, n12, companion.e());
            Function2 b13 = companion.b();
            if (a17.e() || !Intrinsics.c(a17.y(), Integer.valueOf(a15))) {
                a17.p(Integer.valueOf(a15));
                a17.k(Integer.valueOf(a15), b13);
            }
            f3.b(a17, e12, companion.d());
            final androidx.compose.foundation.layout.l lVar = androidx.compose.foundation.layout.l.f2935a;
            float f11 = 12;
            androidx.compose.ui.f f12 = PaddingKt.f(aVar, o0.i.g(16), o0.i.g(f11));
            androidx.compose.ui.layout.t b14 = a0.b(bVar.c(), aVar2.j(), iVar, 0);
            int a18 = androidx.compose.runtime.g.a(iVar, 0);
            androidx.compose.runtime.s n13 = iVar.n();
            androidx.compose.ui.f e13 = ComposedModifierKt.e(iVar, f12);
            Function0 a19 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                androidx.compose.runtime.g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a19);
            } else {
                iVar.o();
            }
            androidx.compose.runtime.i a20 = f3.a(iVar);
            f3.b(a20, b14, companion.c());
            f3.b(a20, n13, companion.e());
            Function2 b15 = companion.b();
            if (a20.e() || !Intrinsics.c(a20.y(), Integer.valueOf(a18))) {
                a20.p(Integer.valueOf(a18));
                a20.k(Integer.valueOf(a18), b15);
            }
            f3.b(a20, e13, companion.d());
            d0 d0Var = d0.f2924a;
            androidx.compose.ui.text.font.s b16 = androidx.compose.ui.text.font.h.f6199b.b();
            androidx.compose.ui.text.font.p e14 = androidx.compose.ui.text.font.p.f6224b.e();
            int b17 = androidx.compose.ui.text.style.p.f6517a.b();
            TextKt.a(str, b0.a(d0Var, SizeKt.l(aVar, o0.i.g(0)), 1.0f, false, 2, null), u1.f4733b.f(), x.c(18), null, e14, b16, 0L, null, null, 0L, b17, false, 0, 0, null, null, iVar, 200064, 48, 128912);
            e0.a(SizeKt.l(aVar, o0.i.g(f11)), iVar, 6);
            Painter c11 = i0.e.c(R$drawable.music_iv_close, iVar, 0);
            long a21 = i0.b.a(R$color.white, iVar, 0);
            float f13 = 21;
            androidx.compose.ui.f e15 = SizeKt.e(SizeKt.l(aVar, o0.i.g(f13)), o0.i.g(f13));
            iVar.P(5004770);
            boolean O = iVar.O(function1);
            Object y10 = iVar.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Function0() { // from class: ul.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d11;
                        d11 = w.a.d(Function1.this);
                        return d11;
                    }
                };
                iVar.p(y10);
            }
            iVar.K();
            IconKt.a(c11, MRAIDPresenter.OPEN, ClickableKt.d(e15, false, null, null, (Function0) y10, 7, null), a21, iVar, 48, 0);
            iVar.r();
            DividerKt.a(null, o0.i.g(1), i0.b.a(R$color.white_10, iVar, 0), iVar, 48, 1);
            e0.a(SizeKt.e(aVar, o0.i.g(23)), iVar, 6);
            androidx.compose.ui.f d11 = SizeKt.d(androidx.compose.foundation.layout.j.a(lVar, aVar, 1.0f, false, 2, null), 0.0f, 1, null);
            iVar.P(-1746271574);
            boolean A = iVar.A(item) | iVar.O(function1);
            Object y11 = iVar.y();
            if (A || y11 == androidx.compose.runtime.i.f3811a.a()) {
                y11 = new Function1() { // from class: ul.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e16;
                        e16 = w.a.e(Item.this, lVar, function1, (androidx.compose.foundation.lazy.u) obj);
                        return e16;
                    }
                };
                iVar.p(y11);
            }
            iVar.K();
            LazyDslKt.a(d11, null, null, false, null, null, null, false, (Function1) y11, iVar, 0, 254);
            e0.a(SizeKt.e(aVar, o0.i.g(40)), iVar, 6);
            iVar.r();
            iVar.r();
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }
    }

    public static final void e(final Item filterItem, final String title, final Function1 dismiss, androidx.compose.runtime.i iVar, final int i11) {
        int i12;
        androidx.compose.runtime.i iVar2;
        Intrinsics.h(filterItem, "filterItem");
        Intrinsics.h(title, "title");
        Intrinsics.h(dismiss, "dismiss");
        androidx.compose.runtime.i g11 = iVar.g(666133991);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(filterItem) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(title) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.A(dismiss) ? 256 : 128;
        }
        if ((i12 & 147) == 146 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.Q(666133991, i12, -1, "com.transsion.home.view.filter.popup.SingleSelectFilter (SingleFilterPopupWindow.kt:44)");
            }
            final com.google.accompanist.systemuicontroller.c e11 = SystemUiControllerKt.e(null, g11, 0, 1);
            final long a11 = i0.b.a(R$color.black_80, g11, 0);
            Handler handler = new Handler(Looper.getMainLooper());
            g11.P(-1633490746);
            boolean O = g11.O(e11) | g11.d(a11);
            Object y10 = g11.y();
            if (O || y10 == androidx.compose.runtime.i.f3811a.a()) {
                y10 = new Runnable() { // from class: ul.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.f(com.google.accompanist.systemuicontroller.c.this, a11);
                    }
                };
                g11.p(y10);
            }
            g11.K();
            handler.postDelayed((Runnable) y10, 100L);
            g11.P(-1633490746);
            boolean O2 = g11.O(e11) | ((i12 & 896) == 256);
            Object y11 = g11.y();
            if (O2 || y11 == androidx.compose.runtime.i.f3811a.a()) {
                y11 = new Function1() { // from class: ul.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit g12;
                        g12 = w.g(com.google.accompanist.systemuicontroller.c.this, dismiss, (String) obj);
                        return g12;
                    }
                };
                g11.p(y11);
            }
            final Function1 function1 = (Function1) y11;
            g11.K();
            g11.P(5004770);
            boolean O3 = g11.O(function1);
            Object y12 = g11.y();
            if (O3 || y12 == androidx.compose.runtime.i.f3811a.a()) {
                y12 = new Function0() { // from class: ul.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit h11;
                        h11 = w.h(Function1.this);
                        return h11;
                    }
                };
                g11.p(y12);
            }
            g11.K();
            iVar2 = g11;
            AndroidDialog_androidKt.a((Function0) y12, new androidx.compose.ui.window.c(false, false, false, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.b.d(-800641360, true, new a(a11, filterItem, function1, title), g11, 54), g11, 432, 0);
            if (androidx.compose.runtime.k.H()) {
                androidx.compose.runtime.k.P();
            }
        }
        g2 j11 = iVar2.j();
        if (j11 != null) {
            j11.a(new Function2() { // from class: ul.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i13;
                    i13 = w.i(Item.this, title, dismiss, i11, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return i13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(com.google.accompanist.systemuicontroller.c cVar, long j11) {
        com.google.accompanist.systemuicontroller.b.b(cVar, j11, false, false, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(com.google.accompanist.systemuicontroller.c cVar, Function1 function1, String str) {
        com.google.accompanist.systemuicontroller.b.b(cVar, u1.f4733b.d(), false, false, null, 14, null);
        function1.invoke(str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1) {
        function1.invoke(null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Item item, String str, Function1 function1, int i11, androidx.compose.runtime.i iVar, int i12) {
        e(item, str, function1, iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }
}
