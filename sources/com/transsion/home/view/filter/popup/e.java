package com.transsion.home.view.filter.popup;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
import androidx.compose.foundation.layout.j;
import androidx.compose.foundation.layout.l;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.u;
import androidx.compose.material.DividerKt;
import androidx.compose.material.SliderKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.f3;
import androidx.compose.runtime.g;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.i;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.k;
import androidx.compose.runtime.s;
import androidx.compose.runtime.snapshots.t;
import androidx.compose.runtime.u2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.b;
import androidx.compose.ui.f;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.p;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.blankj.utilcode.util.f0;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.tn.lib.widget.R$color;
import com.transsion.home.R$string;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.bean.RangeValue;
import com.transsion.home.view.filter.popup.e;
import com.transsion.videodetail.R$drawable;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import i0.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import o0.x;

/* loaded from: classes5.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static float f45826a;

    /* renamed from: b, reason: collision with root package name */
    private static float f45827b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f45828c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f45829a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f45830b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f45831c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f45832d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ t f45833e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f45834f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ t f45835g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.transsion.home.view.filter.popup.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0628a implements Function3 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Item f45836a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ t f45837b;

            C0628a(Item item, t tVar) {
                this.f45836a = item;
                this.f45837b = tVar;
            }

            public final void a(androidx.compose.foundation.lazy.b item, i iVar, int i11) {
                Intrinsics.h(item, "$this$item");
                if ((i11 & 17) == 16 && iVar.h()) {
                    iVar.G();
                    return;
                }
                if (k.H()) {
                    k.Q(807301957, i11, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiFilterPopupWindow.kt:175)");
                }
                e.k(this.f45836a, this.f45837b, iVar, 0);
                if (k.H()) {
                    k.P();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.foundation.lazy.b) obj, (i) obj2, ((Number) obj3).intValue());
                return Unit.f67184a;
            }
        }

        a(long j11, float f11, float f12, List list, t tVar, Function1 function1, t tVar2) {
            this.f45829a = j11;
            this.f45830b = f11;
            this.f45831c = f12;
            this.f45832d = list;
            this.f45833e = tVar;
            this.f45834f = function1;
            this.f45835g = tVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(t tVar, t tVar2, Function1 function1) {
            function1.invoke(Boolean.valueOf(e.D(tVar, tVar2)));
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(List list, t tVar) {
            e.E(list, tVar);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(Function1 function1) {
            function1.invoke(Boolean.FALSE);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit i(List list, t tVar, u LazyColumn) {
            Intrinsics.h(LazyColumn, "$this$LazyColumn");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Item item = (Item) it.next();
                androidx.compose.foundation.lazy.t.a(LazyColumn, item.getFilterType(), null, androidx.compose.runtime.internal.b.b(807301957, true, new C0628a(item, tVar)), 2, null);
            }
            return Unit.f67184a;
        }

        public final void e(i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (k.H()) {
                k.Q(-1419240635, i11, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup.<anonymous> (MultiFilterPopupWindow.kt:122)");
            }
            f.a aVar = f.f4253a;
            f b11 = SizeKt.b(BackgroundKt.b(aVar, this.f45829a, null, 2, null), 0.0f, 1, null);
            float f11 = this.f45830b;
            float f12 = this.f45831c;
            final List list = this.f45832d;
            final t tVar = this.f45833e;
            final Function1 function1 = this.f45834f;
            final t tVar2 = this.f45835g;
            b.a aVar2 = androidx.compose.ui.b.f4162a;
            androidx.compose.ui.layout.t h11 = BoxKt.h(aVar2.m(), false);
            int a11 = g.a(iVar, 0);
            s n11 = iVar.n();
            f e11 = ComposedModifierKt.e(iVar, b11);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a12 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a12);
            } else {
                iVar.o();
            }
            i a13 = f3.a(iVar);
            f3.b(a13, h11, companion.c());
            f3.b(a13, n11, companion.e());
            Function2 b12 = companion.b();
            if (a13.e() || !Intrinsics.c(a13.y(), Integer.valueOf(a11))) {
                a13.p(Integer.valueOf(a11));
                a13.k(Integer.valueOf(a11), b12);
            }
            f3.b(a13, e11, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2819a;
            f i12 = PaddingKt.i(SizeKt.b(aVar, 0.0f, 1, null), 0.0f, f11, 0.0f, f12, 5, null);
            androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.f2911a;
            androidx.compose.ui.layout.t a14 = androidx.compose.foundation.layout.i.a(bVar.d(), aVar2.i(), iVar, 0);
            int a15 = g.a(iVar, 0);
            s n12 = iVar.n();
            f e12 = ComposedModifierKt.e(iVar, i12);
            Function0 a16 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a16);
            } else {
                iVar.o();
            }
            i a17 = f3.a(iVar);
            f3.b(a17, a14, companion.c());
            f3.b(a17, n12, companion.e());
            Function2 b13 = companion.b();
            if (a17.e() || !Intrinsics.c(a17.y(), Integer.valueOf(a15))) {
                a17.p(Integer.valueOf(a15));
                a17.k(Integer.valueOf(a15), b13);
            }
            f3.b(a17, e12, companion.d());
            l lVar = l.f2935a;
            float f13 = 12;
            float f14 = 16;
            f f15 = PaddingKt.f(aVar, o0.i.g(f14), o0.i.g(f13));
            androidx.compose.ui.layout.t b14 = a0.b(bVar.c(), aVar2.j(), iVar, 0);
            int a18 = g.a(iVar, 0);
            s n13 = iVar.n();
            f e13 = ComposedModifierKt.e(iVar, f15);
            Function0 a19 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a19);
            } else {
                iVar.o();
            }
            i a20 = f3.a(iVar);
            f3.b(a20, b14, companion.c());
            f3.b(a20, n13, companion.e());
            Function2 b15 = companion.b();
            if (a20.e() || !Intrinsics.c(a20.y(), Integer.valueOf(a18))) {
                a20.p(Integer.valueOf(a18));
                a20.k(Integer.valueOf(a18), b15);
            }
            f3.b(a20, e13, companion.d());
            d0 d0Var = d0.f2924a;
            String a21 = h.a(R$string.filter_more_title, iVar, 0);
            h.a aVar3 = androidx.compose.ui.text.font.h.f6199b;
            androidx.compose.ui.text.font.s b16 = aVar3.b();
            p.a aVar4 = p.f6224b;
            p e14 = aVar4.e();
            int b17 = androidx.compose.ui.text.style.p.f6517a.b();
            TextKt.a(a21, b0.a(d0Var, SizeKt.l(aVar, o0.i.g(0)), 1.0f, false, 2, null), u1.f4733b.f(), x.c(18), null, e14, b16, 0L, null, null, 0L, b17, false, 0, 0, null, null, iVar, 200064, 48, 128912);
            e0.a(SizeKt.l(aVar, o0.i.g(f13)), iVar, 6);
            Painter c11 = i0.e.c(R$drawable.music_iv_close, iVar, 0);
            long a22 = i0.b.a(R$color.white, iVar, 0);
            float f16 = 21;
            f e15 = SizeKt.e(SizeKt.l(aVar, o0.i.g(f16)), o0.i.g(f16));
            iVar.P(5004770);
            boolean O = iVar.O(function1);
            Object y10 = iVar.y();
            if (O || y10 == i.f3811a.a()) {
                y10 = new Function0() { // from class: com.transsion.home.view.filter.popup.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit h12;
                        h12 = e.a.h(Function1.this);
                        return h12;
                    }
                };
                iVar.p(y10);
            }
            iVar.K();
            IconKt.a(c11, MRAIDPresenter.OPEN, ClickableKt.d(e15, false, null, null, (Function0) y10, 7, null), a22, iVar, 48, 0);
            iVar.r();
            float f17 = 1;
            DividerKt.a(null, i0.b.a(R$color.white_10, iVar, 0), o0.i.g(f17), 0.0f, iVar, 384, 9);
            e0.a(SizeKt.e(aVar, o0.i.g(f13)), iVar, 6);
            f d11 = SizeKt.d(PaddingKt.g(j.a(lVar, aVar, 1.0f, false, 2, null), o0.i.g(f14), 0.0f, 2, null), 0.0f, 1, null);
            iVar.P(-1633490746);
            boolean A = iVar.A(list) | iVar.O(tVar);
            Object y11 = iVar.y();
            if (A || y11 == i.f3811a.a()) {
                y11 = new Function1() { // from class: com.transsion.home.view.filter.popup.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit i13;
                        i13 = e.a.i(list, tVar, (u) obj);
                        return i13;
                    }
                };
                iVar.p(y11);
            }
            iVar.K();
            LazyDslKt.a(d11, null, null, false, null, null, null, false, (Function1) y11, iVar, 0, 254);
            DividerKt.a(null, i0.b.a(R$color.white_10, iVar, 0), o0.i.g(f17), 0.0f, iVar, 384, 9);
            e0.a(SizeKt.e(aVar, o0.i.g(f13)), iVar, 6);
            f g11 = PaddingKt.g(aVar, o0.i.g(f14), 0.0f, 2, null);
            androidx.compose.ui.layout.t b18 = a0.b(bVar.c(), aVar2.j(), iVar, 0);
            int a23 = g.a(iVar, 0);
            s n14 = iVar.n();
            f e16 = ComposedModifierKt.e(iVar, g11);
            Function0 a24 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a24);
            } else {
                iVar.o();
            }
            i a25 = f3.a(iVar);
            f3.b(a25, b18, companion.c());
            f3.b(a25, n14, companion.e());
            Function2 b19 = companion.b();
            if (a25.e() || !Intrinsics.c(a25.y(), Integer.valueOf(a23))) {
                a25.p(Integer.valueOf(a23));
                a25.k(Integer.valueOf(a23), b19);
            }
            f3.b(a25, e16, companion.d());
            b.InterfaceC0044b f18 = aVar2.f();
            b.e b20 = bVar.b();
            float f19 = 48;
            float f20 = 100;
            f e17 = BorderKt.e(SizeKt.e(aVar, o0.i.g(f19)), o0.i.g(f17), i0.b.a(R$color.white, iVar, 0), q.g.c(o0.i.g(f20)));
            iVar.P(-1633490746);
            boolean A2 = iVar.A(list) | iVar.O(tVar);
            Object y12 = iVar.y();
            if (A2 || y12 == i.f3811a.a()) {
                y12 = new Function0() { // from class: com.transsion.home.view.filter.popup.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit g12;
                        g12 = e.a.g(list, tVar);
                        return g12;
                    }
                };
                iVar.p(y12);
            }
            iVar.K();
            f d12 = ClickableKt.d(e17, false, null, null, (Function0) y12, 7, null);
            androidx.compose.ui.layout.t a26 = androidx.compose.foundation.layout.i.a(b20, f18, iVar, 54);
            int a27 = g.a(iVar, 0);
            s n15 = iVar.n();
            f e18 = ComposedModifierKt.e(iVar, d12);
            Function0 a28 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a28);
            } else {
                iVar.o();
            }
            i a29 = f3.a(iVar);
            f3.b(a29, a26, companion.c());
            f3.b(a29, n15, companion.e());
            Function2 b21 = companion.b();
            if (a29.e() || !Intrinsics.c(a29.y(), Integer.valueOf(a27))) {
                a29.p(Integer.valueOf(a27));
                a29.k(Integer.valueOf(a27), b21);
            }
            f3.b(a29, e18, companion.d());
            String a30 = i0.h.a(R$string.filter_reset, iVar, 0);
            long c12 = x.c(18);
            androidx.compose.ui.text.font.s b22 = aVar3.b();
            TextKt.a(a30, PaddingKt.g(aVar, o0.i.g(24), 0.0f, 2, null), i0.b.a(R$color.white, iVar, 0), c12, null, aVar4.e(), b22, 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar, 199728, 0, 130960);
            iVar.r();
            e0.a(SizeKt.l(aVar, o0.i.g(f13)), iVar, 6);
            b.InterfaceC0044b f21 = aVar2.f();
            b.e b23 = bVar.b();
            f a31 = BackgroundKt.a(b0.a(d0Var, SizeKt.e(aVar, o0.i.g(f19)), 1.0f, false, 2, null), i0.b.a(R$color.white, iVar, 0), q.g.c(o0.i.g(f20)));
            iVar.P(-1746271574);
            boolean O2 = iVar.O(tVar2) | iVar.O(tVar) | iVar.O(function1);
            Object y13 = iVar.y();
            if (O2 || y13 == i.f3811a.a()) {
                y13 = new Function0() { // from class: com.transsion.home.view.filter.popup.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit f22;
                        f22 = e.a.f(t.this, tVar, function1);
                        return f22;
                    }
                };
                iVar.p(y13);
            }
            iVar.K();
            f d13 = ClickableKt.d(a31, false, null, null, (Function0) y13, 7, null);
            androidx.compose.ui.layout.t a32 = androidx.compose.foundation.layout.i.a(b23, f21, iVar, 54);
            int a33 = g.a(iVar, 0);
            s n16 = iVar.n();
            f e19 = ComposedModifierKt.e(iVar, d13);
            Function0 a34 = companion.a();
            if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            iVar.C();
            if (iVar.e()) {
                iVar.F(a34);
            } else {
                iVar.o();
            }
            i a35 = f3.a(iVar);
            f3.b(a35, a32, companion.c());
            f3.b(a35, n16, companion.e());
            Function2 b24 = companion.b();
            if (a35.e() || !Intrinsics.c(a35.y(), Integer.valueOf(a33))) {
                a35.p(Integer.valueOf(a33));
                a35.k(Integer.valueOf(a33), b24);
            }
            f3.b(a35, e19, companion.d());
            TextKt.a(i0.h.a(R$string.filter_confirm, iVar, 0), null, i0.b.a(R$color.black, iVar, 0), x.c(18), null, aVar4.e(), aVar3.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar, 199680, 0, 130962);
            iVar.r();
            iVar.r();
            e0.a(SizeKt.e(aVar, o0.i.g(f13)), iVar, 6);
            iVar.r();
            iVar.r();
            if (k.H()) {
                k.P();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            e((i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(t tVar, t tVar2) {
        boolean z10 = false;
        for (Map.Entry entry : tVar2.entrySet()) {
            if (!Intrinsics.c(tVar.get(entry.getKey()), entry.getValue())) {
                tVar.put(entry.getKey(), entry.getValue());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(List list, t tVar) {
        f45828c = true;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            if (item.getRangeVals() != null) {
                tVar.put(item.getFilterType(), PopupFilterView.INSTANCE.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal()));
            } else if (!item.getFilterValsV2().isEmpty()) {
                tVar.put(item.getFilterType(), item.getFilterValsV2().get(0).getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final Item item, final t tVar, i iVar, final int i11) {
        i iVar2;
        int i12;
        i g11 = iVar.g(1506355035);
        int i13 = (i11 & 6) == 0 ? (g11.A(item) ? 4 : 2) | i11 : i11;
        if ((i11 & 48) == 0) {
            i13 |= g11.O(tVar) ? 32 : 16;
        }
        int i14 = i13;
        if ((i14 & 19) == 18 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (k.H()) {
                k.Q(1506355035, i14, -1, "com.transsion.home.view.filter.popup.FilterItemView (MultiFilterPopupWindow.kt:280)");
            }
            f.a aVar = f.f4253a;
            androidx.compose.ui.layout.t a11 = androidx.compose.foundation.layout.i.a(androidx.compose.foundation.layout.b.f2911a.d(), androidx.compose.ui.b.f4162a.i(), g11, 0);
            int a12 = g.a(g11, 0);
            s n11 = g11.n();
            f e11 = ComposedModifierKt.e(g11, aVar);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a13 = companion.a();
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a13);
            } else {
                g11.o();
            }
            i a14 = f3.a(g11);
            f3.b(a14, a11, companion.c());
            f3.b(a14, n11, companion.e());
            Function2 b11 = companion.b();
            if (a14.e() || !Intrinsics.c(a14.y(), Integer.valueOf(a12))) {
                a14.p(Integer.valueOf(a12));
                a14.k(Integer.valueOf(a12), b11);
            }
            f3.b(a14, e11, companion.d());
            l lVar = l.f2935a;
            int i15 = 0;
            TextKt.a(item.getTitle(), null, i0.b.a(R$color.white, g11, 0), x.c(16), null, p.f6224b.c(), androidx.compose.ui.text.font.h.f6199b.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, g11, 199680, 0, 130962);
            if (item.getRangeVals() == null) {
                g11.P(727601012);
                int i16 = (((Configuration) g11.l(AndroidCompositionLocals_androidKt.f())).screenWidthDp - 44) / 2;
                for (List<FilterVal> list : CollectionsKt.a0(item.getFilterValsV2(), 2)) {
                    f i17 = PaddingKt.i(SizeKt.d(f.f4253a, 0.0f, 1, null), 0.0f, o0.i.g(12), 0.0f, 0.0f, 13, null);
                    androidx.compose.ui.layout.t b12 = a0.b(androidx.compose.foundation.layout.b.f2911a.c(), androidx.compose.ui.b.f4162a.j(), g11, i15);
                    int a15 = g.a(g11, i15);
                    s n12 = g11.n();
                    f e12 = ComposedModifierKt.e(g11, i17);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f5299c1;
                    Function0 a16 = companion2.a();
                    if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    g11.C();
                    if (g11.e()) {
                        g11.F(a16);
                    } else {
                        g11.o();
                    }
                    i a17 = f3.a(g11);
                    f3.b(a17, b12, companion2.c());
                    f3.b(a17, n12, companion2.e());
                    Function2 b13 = companion2.b();
                    if (a17.e() || !Intrinsics.c(a17.y(), Integer.valueOf(a15))) {
                        a17.p(Integer.valueOf(a15));
                        a17.k(Integer.valueOf(a15), b13);
                    }
                    f3.b(a17, e12, companion2.d());
                    d0 d0Var = d0.f2924a;
                    g11.P(-1743407500);
                    for (FilterVal filterVal : list) {
                        f.a aVar2 = f.f4253a;
                        int i18 = i16;
                        int i19 = i14;
                        i iVar3 = g11;
                        m(item, filterVal, tVar, SizeKt.l(aVar2, o0.i.g(i16)), g11, (i14 & 14) | ((i14 << 3) & 896));
                        iVar3.P(-1743402035);
                        if (Intrinsics.c(filterVal, CollectionsKt.u0(list))) {
                            i12 = 0;
                        } else {
                            i12 = 0;
                            e0.a(b0.a(d0Var, aVar2, 1.0f, false, 2, null), iVar3, 0);
                        }
                        iVar3.K();
                        i15 = i12;
                        g11 = iVar3;
                        i16 = i18;
                        i14 = i19;
                    }
                    int i20 = i16;
                    i iVar4 = g11;
                    iVar4.K();
                    iVar4.r();
                    i16 = i20;
                }
                iVar2 = g11;
                iVar2.K();
            } else {
                iVar2 = g11;
                iVar2.P(728374648);
                u(item, tVar, iVar2, i14 & 126);
                iVar2.K();
            }
            e0.a(SizeKt.e(f.f4253a, o0.i.g(32)), iVar2, 6);
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j11 = iVar2.j();
        if (j11 != null) {
            j11.a(new Function2() { // from class: ul.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l11;
                    l11 = com.transsion.home.view.filter.popup.e.l(Item.this, tVar, i11, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return l11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Item item, t tVar, int i11, i iVar, int i12) {
        k(item, tVar, iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }

    private static final void m(final Item item, final FilterVal filterVal, final t tVar, final f fVar, i iVar, final int i11) {
        int i12;
        long a11;
        long a12;
        i iVar2;
        i g11 = iVar.g(973616320);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(item) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(filterVal) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.O(tVar) ? 256 : 128;
        }
        if ((i11 & 3072) == 0) {
            i12 |= g11.O(fVar) ? 2048 : 1024;
        }
        if ((i12 & 1171) == 1170 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (k.H()) {
                k.Q(973616320, i12, -1, "com.transsion.home.view.filter.popup.GridItem (MultiFilterPopupWindow.kt:323)");
            }
            if (Intrinsics.c(tVar.get(item.getFilterType()), filterVal.getId())) {
                g11.P(1089913522);
                a11 = i0.b.a(R$color.white, g11, 0);
                a12 = i0.b.a(com.transsion.wrapperad.R$color.white_40, g11, 0);
                g11.K();
            } else {
                g11.P(1090061733);
                a11 = i0.b.a(R$color.text_03, g11, 0);
                a12 = i0.b.a(R$color.transparent, g11, 0);
                g11.K();
            }
            androidx.compose.ui.b d11 = androidx.compose.ui.b.f4162a.d();
            float f11 = 100;
            f a13 = BackgroundKt.a(BorderKt.e(SizeKt.e(fVar, o0.i.g(32)), o0.i.g(1), a11, q.g.c(o0.i.g(f11))), a12, q.g.c(o0.i.g(f11)));
            g11.P(-1746271574);
            boolean A = ((i12 & 896) == 256) | g11.A(item) | ((i12 & 112) == 32);
            Object y10 = g11.y();
            if (A || y10 == i.f3811a.a()) {
                y10 = new Function0() { // from class: ul.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit n11;
                        n11 = com.transsion.home.view.filter.popup.e.n(androidx.compose.runtime.snapshots.t.this, item, filterVal);
                        return n11;
                    }
                };
                g11.p(y10);
            }
            g11.K();
            f d12 = ClickableKt.d(a13, false, null, null, (Function0) y10, 7, null);
            androidx.compose.ui.layout.t h11 = BoxKt.h(d11, false);
            int a14 = g.a(g11, 0);
            s n11 = g11.n();
            f e11 = ComposedModifierKt.e(g11, d12);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a15 = companion.a();
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a15);
            } else {
                g11.o();
            }
            i a16 = f3.a(g11);
            f3.b(a16, h11, companion.c());
            f3.b(a16, n11, companion.e());
            Function2 b11 = companion.b();
            if (a16.e() || !Intrinsics.c(a16.y(), Integer.valueOf(a14))) {
                a16.p(Integer.valueOf(a14));
                a16.k(Integer.valueOf(a14), b11);
            }
            f3.b(a16, e11, companion.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f2819a;
            iVar2 = g11;
            TextKt.a(filterVal.getName(), null, i0.b.a(R$color.white, g11, 0), x.c(14), null, p.f6224b.c(), androidx.compose.ui.text.font.h.f6199b.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199680, 0, 130962);
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j11 = iVar2.j();
        if (j11 != null) {
            j11.a(new Function2() { // from class: ul.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o11;
                    o11 = com.transsion.home.view.filter.popup.e.o(Item.this, filterVal, tVar, fVar, i11, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return o11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(t tVar, Item item, FilterVal filterVal) {
        tVar.put(item.getFilterType(), filterVal.getId());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Item item, FilterVal filterVal, t tVar, f fVar, int i11, i iVar, int i12) {
        m(item, filterVal, tVar, fVar, iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }

    public static final void p(final List filterItems, final t selectItems, final Function1 dismiss, i iVar, final int i11) {
        int i12;
        Object a11;
        z0.c insets;
        z0.c insets2;
        Window window;
        View decorView;
        Intrinsics.h(filterItems, "filterItems");
        Intrinsics.h(selectItems, "selectItems");
        Intrinsics.h(dismiss, "dismiss");
        i g11 = iVar.g(1096788014);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(filterItems) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(selectItems) ? 32 : 16;
        }
        if ((i11 & 384) == 0) {
            i12 |= g11.A(dismiss) ? 256 : 128;
        }
        if ((i12 & 147) == 146 && g11.h()) {
            g11.G();
        } else {
            if (k.H()) {
                k.Q(1096788014, i12, -1, "com.transsion.home.view.filter.popup.MultiFilterPopup (MultiFilterPopupWindow.kt:66)");
            }
            final com.google.accompanist.systemuicontroller.c e11 = SystemUiControllerKt.e(null, g11, 0, 1);
            final long a12 = i0.b.a(R$color.black_80, g11, 0);
            Handler handler = new Handler(Looper.getMainLooper());
            g11.P(-1633490746);
            boolean O = g11.O(e11) | g11.d(a12);
            Object y10 = g11.y();
            if (O || y10 == i.f3811a.a()) {
                y10 = new Runnable() { // from class: ul.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.transsion.home.view.filter.popup.e.q(com.google.accompanist.systemuicontroller.c.this, a12);
                    }
                };
                g11.p(y10);
            }
            g11.K();
            handler.postDelayed((Runnable) y10, 100L);
            g11.P(-1633490746);
            boolean O2 = g11.O(e11) | ((i12 & 896) == 256);
            Object y11 = g11.y();
            if (O2 || y11 == i.f3811a.a()) {
                y11 = new Function1() { // from class: ul.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit r11;
                        r11 = com.transsion.home.view.filter.popup.e.r(com.google.accompanist.systemuicontroller.c.this, dismiss, ((Boolean) obj).booleanValue());
                        return r11;
                    }
                };
                g11.p(y11);
            }
            final Function1 function1 = (Function1) y11;
            g11.K();
            t tVar = new t();
            tVar.putAll(selectItems);
            Context context = (Context) g11.l(AndroidCompositionLocals_androidKt.g());
            o0.e eVar = (o0.e) g11.l(CompositionLocalsKt.c());
            Activity activity = context instanceof Activity ? (Activity) context : null;
            WindowInsetsCompat rootWindowInsets = (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : ViewCompat.getRootWindowInsets(decorView);
            g11.P(5004770);
            boolean O3 = g11.O(context);
            Object y12 = g11.y();
            if (O3 || y12 == i.f3811a.a()) {
                if (Build.VERSION.SDK_INT >= 35) {
                    Resources resources = context.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int max = Math.max(identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0, (rootWindowInsets == null || (insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars())) == null) ? 0 : insets2.f79249b);
                    int i13 = (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) == null) ? 0 : insets.f79251d;
                    a11 = TuplesKt.a(o0.i.d(eVar.x0(max)), o0.i.d(eVar.x0(i13 > 0 ? i13 + ((int) (16 * eVar.getDensity())) : (int) (32 * eVar.getDensity()))));
                } else {
                    float f11 = 0;
                    a11 = TuplesKt.a(o0.i.d(o0.i.g(f11)), o0.i.d(o0.i.g(f11)));
                }
                y12 = a11;
                g11.p(y12);
            }
            Pair pair = (Pair) y12;
            g11.K();
            float l11 = ((o0.i) pair.component1()).l();
            float l12 = ((o0.i) pair.component2()).l();
            g11.P(5004770);
            boolean O4 = g11.O(function1);
            Object y13 = g11.y();
            if (O4 || y13 == i.f3811a.a()) {
                y13 = new Function0() { // from class: ul.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s11;
                        s11 = com.transsion.home.view.filter.popup.e.s(Function1.this);
                        return s11;
                    }
                };
                g11.p(y13);
            }
            g11.K();
            AndroidDialog_androidKt.a((Function0) y13, new androidx.compose.ui.window.c(false, false, false, 3, (DefaultConstructorMarker) null), androidx.compose.runtime.internal.b.d(-1419240635, true, new a(a12, l11, l12, filterItems, tVar, function1, selectItems), g11, 54), g11, 432, 0);
            if (k.H()) {
                k.P();
            }
        }
        g2 j11 = g11.j();
        if (j11 != null) {
            j11.a(new Function2() { // from class: ul.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit t11;
                    t11 = com.transsion.home.view.filter.popup.e.t(filterItems, selectItems, dismiss, i11, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return t11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(com.google.accompanist.systemuicontroller.c cVar, long j11) {
        com.google.accompanist.systemuicontroller.b.b(cVar, j11, false, false, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(com.google.accompanist.systemuicontroller.c cVar, Function1 function1, boolean z10) {
        com.google.accompanist.systemuicontroller.b.b(cVar, u1.f4733b.d(), false, false, null, 14, null);
        function1.invoke(Boolean.valueOf(z10));
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(List list, t tVar, Function1 function1, int i11, i iVar, int i12) {
        p(list, tVar, function1, iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }

    private static final void u(final Item item, final t tVar, i iVar, final int i11) {
        int i12;
        final i1 i1Var;
        i iVar2;
        String str;
        Float t11;
        String str2;
        Float t12;
        i g11 = iVar.g(-945657323);
        if ((i11 & 6) == 0) {
            i12 = (g11.A(item) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 48) == 0) {
            i12 |= g11.O(tVar) ? 32 : 16;
        }
        int i13 = i12;
        if ((i13 & 19) == 18 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (k.H()) {
                k.Q(-945657323, i13, -1, "com.transsion.home.view.filter.popup.StepRangeSlider (MultiFilterPopupWindow.kt:375)");
            }
            RangeValue rangeVals = item.getRangeVals();
            Intrinsics.e(rangeVals);
            float minVal = rangeVals.getMinVal();
            float maxVal = rangeVals.getMaxVal();
            String str3 = (String) tVar.get(item.getFilterType());
            List S0 = str3 != null ? StringsKt.S0(str3, new String[]{","}, false, 0, 6, null) : null;
            if ((S0 != null ? S0.size() : 0) >= 2) {
                minVal = (S0 == null || (str2 = (String) S0.get(0)) == null || (t12 = StringsKt.t(str2)) == null) ? rangeVals.getMinVal() : t12.floatValue();
                maxVal = (S0 == null || (str = (String) S0.get(1)) == null || (t11 = StringsKt.t(str)) == null) ? rangeVals.getMaxVal() : t11.floatValue();
            }
            g11.P(1849434622);
            Object y10 = g11.y();
            i.a aVar = i.f3811a;
            if (y10 == aVar.a()) {
                y10 = u2.c(RangesKt.b(minVal, maxVal), null, 2, null);
                g11.p(y10);
            }
            i1 i1Var2 = (i1) y10;
            g11.K();
            if (f45828c) {
                w(i1Var2, RangesKt.b(minVal, maxVal));
                f45828c = false;
            }
            f.a aVar2 = f.f4253a;
            androidx.compose.foundation.layout.b bVar = androidx.compose.foundation.layout.b.f2911a;
            b.k d11 = bVar.d();
            b.a aVar3 = androidx.compose.ui.b.f4162a;
            androidx.compose.ui.layout.t a11 = androidx.compose.foundation.layout.i.a(d11, aVar3.i(), g11, 0);
            int a12 = g.a(g11, 0);
            s n11 = g11.n();
            f e11 = ComposedModifierKt.e(g11, aVar2);
            ComposeUiNode.Companion companion = ComposeUiNode.f5299c1;
            Function0 a13 = companion.a();
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a13);
            } else {
                g11.o();
            }
            i a14 = f3.a(g11);
            f3.b(a14, a11, companion.c());
            f3.b(a14, n11, companion.e());
            Function2 b11 = companion.b();
            if (a14.e() || !Intrinsics.c(a14.y(), Integer.valueOf(a12))) {
                a14.p(Integer.valueOf(a12));
                a14.k(Integer.valueOf(a12), b11);
            }
            f3.b(a14, e11, companion.d());
            l lVar = l.f2935a;
            int d12 = MathKt.d(((Number) v(i1Var2).j()).floatValue());
            int d13 = MathKt.d(((Number) v(i1Var2).e()).floatValue());
            ClosedFloatingPointRange v11 = v(i1Var2);
            ClosedFloatingPointRange b12 = RangesKt.b(rangeVals.getMinVal(), rangeVals.getMaxVal());
            int maxVal2 = ((int) rangeVals.getMaxVal()) - 1;
            androidx.compose.material.j a15 = androidx.compose.material.k.f3493a.a(i0.b.a(R$color.white, g11, 0), 0L, i0.b.a(R$color.white, g11, 0), 0L, i0.b.a(R$color.white_40, g11, 0), 0L, i0.b.a(R$color.transparent, g11, 0), i0.b.a(R$color.transparent, g11, 0), 0L, 0L, g11, 0, androidx.compose.material.k.f3494b, 810);
            g11.P(5004770);
            Object y11 = g11.y();
            if (y11 == aVar.a()) {
                i1Var = i1Var2;
                y11 = new Function1() { // from class: ul.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit x10;
                        x10 = com.transsion.home.view.filter.popup.e.x(i1.this, (ClosedFloatingPointRange) obj);
                        return x10;
                    }
                };
                g11.p(y11);
            } else {
                i1Var = i1Var2;
            }
            Function1 function1 = (Function1) y11;
            g11.K();
            g11.P(-1746271574);
            boolean A = g11.A(item) | ((i13 & 112) == 32);
            Object y12 = g11.y();
            if (A || y12 == aVar.a()) {
                y12 = new Function0() { // from class: ul.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit y13;
                        y13 = com.transsion.home.view.filter.popup.e.y(androidx.compose.runtime.snapshots.t.this, item, i1Var);
                        return y13;
                    }
                };
                g11.p(y12);
            }
            g11.K();
            SliderKt.b(v11, function1, null, false, b12, maxVal2, (Function0) y12, a15, g11, 48, 12);
            androidx.compose.ui.layout.t b13 = a0.b(bVar.c(), aVar3.j(), g11, 0);
            int a16 = g.a(g11, 0);
            s n12 = g11.n();
            f e12 = ComposedModifierKt.e(g11, aVar2);
            Function0 a17 = companion.a();
            if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                g.b();
            }
            g11.C();
            if (g11.e()) {
                g11.F(a17);
            } else {
                g11.o();
            }
            i a18 = f3.a(g11);
            f3.b(a18, b13, companion.c());
            f3.b(a18, n12, companion.e());
            Function2 b14 = companion.b();
            if (a18.e() || !Intrinsics.c(a18.y(), Integer.valueOf(a16))) {
                a18.p(Integer.valueOf(a16));
                a18.k(Integer.valueOf(a16), b14);
            }
            f3.b(a18, e12, companion.d());
            d0 d0Var = d0.f2924a;
            String valueOf = String.valueOf(d12);
            long c11 = x.c(12);
            h.a aVar4 = androidx.compose.ui.text.font.h.f6199b;
            androidx.compose.ui.text.font.s b15 = aVar4.b();
            p.a aVar5 = p.f6224b;
            TextKt.a(valueOf, PaddingKt.i(aVar2, o0.i.g(5), 0.0f, 0.0f, 0.0f, 14, null), i0.b.a(R$color.white, g11, 0), c11, null, aVar5.e(), b15, 0L, null, null, 0L, 0, false, 0, 0, null, null, g11, 199728, 0, 130960);
            e0.a(b0.a(d0Var, aVar2, 1.0f, false, 2, null), g11, 0);
            iVar2 = g11;
            TextKt.a(String.valueOf(d13), null, i0.b.a(R$color.white, g11, 0), x.c(12), null, aVar5.e(), aVar4.b(), 0L, null, null, 0L, 0, false, 0, 0, null, null, iVar2, 199680, 0, 130962);
            iVar2.r();
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j11 = iVar2.j();
        if (j11 != null) {
            j11.a(new Function2() { // from class: ul.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z10;
                    z10 = com.transsion.home.view.filter.popup.e.z(Item.this, tVar, i11, (androidx.compose.runtime.i) obj, ((Integer) obj2).intValue());
                    return z10;
                }
            });
        }
    }

    private static final ClosedFloatingPointRange v(i1 i1Var) {
        return (ClosedFloatingPointRange) i1Var.getValue();
    }

    private static final void w(i1 i1Var, ClosedFloatingPointRange closedFloatingPointRange) {
        i1Var.setValue(closedFloatingPointRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(i1 i1Var, ClosedFloatingPointRange it) {
        Intrinsics.h(it, "it");
        float floatValue = ((Number) it.j()).floatValue() == ((Number) v(i1Var).j()).floatValue() ? ((Number) it.e()).floatValue() : ((Number) it.j()).floatValue();
        if (((int) floatValue) != ((int) f45827b)) {
            f0.b(20L);
        }
        f45827b = floatValue;
        w(i1Var, it);
        if (((Number) it.j()).floatValue() == ((Number) it.e()).floatValue()) {
            f45826a = ((Number) it.j()).floatValue();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(t tVar, Item item, i1 i1Var) {
        if (((Number) v(i1Var).j()).floatValue() > ((Number) v(i1Var).e()).floatValue()) {
            float f11 = f45826a;
            w(i1Var, RangesKt.b(f11, f11));
        }
        tVar.put(item.getFilterType(), PopupFilterView.INSTANCE.a(((Number) v(i1Var).j()).floatValue(), ((Number) v(i1Var).e()).floatValue()));
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Item item, t tVar, int i11, i iVar, int i12) {
        u(item, tVar, iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }
}
