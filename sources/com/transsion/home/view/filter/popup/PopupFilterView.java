package com.transsion.home.view.filter.popup;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a0;
import androidx.compose.foundation.layout.b0;
import androidx.compose.foundation.layout.d0;
import androidx.compose.foundation.layout.e0;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.font.p;
import androidx.view.InterfaceC1015e;
import androidx.view.ViewTreeLifecycleOwner;
import androidx.view.ViewTreeSavedStateRegistryOwner;
import androidx.view.ViewTreeViewModelStoreOwner;
import androidx.view.u;
import androidx.view.y0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$drawable;
import com.transsion.home.R$mipmap;
import com.transsion.home.bean.FilterVal;
import com.transsion.home.bean.Item;
import com.transsion.home.view.filter.popup.PopupFilterView;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o0.x;
import ul.w;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2(\b\u0002\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001d\u001a\u00020\u00172\u001e\u0010\u001c\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00172\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007¢\u0006\u0004\b\u001f\u0010 R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010'\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*²\u0006\u000e\u0010)\u001a\u00020\u00148\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/transsion/home/view/filter/popup/PopupFilterView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "Lcom/transsion/home/bean/Item;", "filterItem", "", "m", "(Ljava/util/List;)Z", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "selectItems", "", "initSelectData", "(Ljava/util/List;Ljava/util/HashMap;)V", "Lkotlin/Function1;", "", "callback", "setOnFilterListener", "(Lkotlin/jvm/functions/Function1;)V", "FilterLinear", "(Ljava/util/List;Landroidx/compose/runtime/i;I)V", "Landroidx/compose/runtime/snapshots/t;", "a", "Landroidx/compose/runtime/snapshots/t;", "selectItemsMap", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/jvm/functions/Function1;", "onFilterChangedListener", "Companion", "currentPopup", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class PopupFilterView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final t selectItemsMap;

    /* renamed from: b */
    private Function1 onFilterChangedListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: com.transsion.home.view.filter.popup.PopupFilterView$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(float f11, float f12) {
            return ((int) f11) + "," + ((int) f12);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements Function2 {

        /* renamed from: b */
        final /* synthetic */ List f45817b;

        b(List list) {
            this.f45817b = list;
        }

        public final void a(i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.G();
                return;
            }
            if (k.H()) {
                k.Q(486758898, i11, -1, "com.transsion.home.view.filter.popup.PopupFilterView.initSelectData.<anonymous>.<anonymous> (PopupFilterView.kt:93)");
            }
            PopupFilterView.this.FilterLinear(this.f45817b, iVar, 0);
            if (k.H()) {
                k.P();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((i) obj, ((Number) obj2).intValue());
            return Unit.f67184a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.selectItemsMap = new t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.h(context, "context");
        Intrinsics.h(attrs, "attrs");
        this.selectItemsMap = new t();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupFilterView(Context context, AttributeSet attrs, int i11) {
        super(context, attrs, i11);
        Intrinsics.h(context, "context");
        Intrinsics.h(attrs, "attrs");
        this.selectItemsMap = new t();
    }

    public static final Unit f(PopupFilterView popupFilterView, Item item, i1 i1Var, String str) {
        if (str != null) {
            popupFilterView.selectItemsMap.put(item.getFilterType(), str);
            Function1 function1 = popupFilterView.onFilterChangedListener;
            if (function1 != null) {
                function1.invoke(popupFilterView.selectItemsMap.l());
            }
        }
        l(i1Var, "");
        return Unit.f67184a;
    }

    public static final Unit g(Item item, i1 i1Var) {
        l(i1Var, item.getFilterType());
        return Unit.f67184a;
    }

    public static final Unit h(i1 i1Var) {
        l(i1Var, "multi");
        return Unit.f67184a;
    }

    public static final Unit i(PopupFilterView popupFilterView, i1 i1Var, boolean z10) {
        Function1 function1;
        l(i1Var, "");
        if (z10 && (function1 = popupFilterView.onFilterChangedListener) != null) {
            function1.invoke(popupFilterView.selectItemsMap.l());
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initSelectData$default(PopupFilterView popupFilterView, List list, HashMap hashMap, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            hashMap = null;
        }
        popupFilterView.initSelectData(list, hashMap);
    }

    public static final Unit j(PopupFilterView popupFilterView, List list, int i11, i iVar, int i12) {
        popupFilterView.FilterLinear(list, iVar, v1.a(i11 | 1));
        return Unit.f67184a;
    }

    private static final String k(i1 i1Var) {
        return (String) i1Var.getValue();
    }

    private static final void l(i1 i1Var, String str) {
        i1Var.setValue(str);
    }

    private final boolean m(List filterItem) {
        if (filterItem != null) {
            Iterator it = filterItem.iterator();
            while (it.hasNext()) {
                Item item = (Item) it.next();
                String str = (String) this.selectItemsMap.get(item.getFilterType());
                if (item.getRangeVals() == null && Intrinsics.c(item.getShowOut(), "false")) {
                    if (str != null && !Intrinsics.c(str, item.getFilterValsV2().get(0).getId())) {
                        return true;
                    }
                } else if (item.getRangeVals() != null) {
                    String a11 = INSTANCE.a(item.getRangeVals().getMinVal(), item.getRangeVals().getMaxVal());
                    if (str != null && !Intrinsics.c(str, a11)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final void FilterLinear(final List<Item> list, i iVar, final int i11) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i12;
        i iVar2;
        ArrayList arrayList3;
        final i1 i1Var;
        int i13;
        long a11;
        long a12;
        Object obj;
        String name;
        long a13;
        int i14 = 1;
        i g11 = iVar.g(541655127);
        int i15 = (i11 & 6) == 0 ? (g11.A(list) ? 4 : 2) | i11 : i11;
        if ((i11 & 48) == 0) {
            i15 |= g11.A(this) ? 32 : 16;
        }
        if ((i15 & 19) == 18 && g11.h()) {
            g11.G();
            iVar2 = g11;
        } else {
            if (k.H()) {
                k.Q(541655127, i15, -1, "com.transsion.home.view.filter.popup.PopupFilterView.FilterLinear (PopupFilterView.kt:127)");
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj2 : list) {
                    Item item = (Item) obj2;
                    if (Intrinsics.c(item.getShowOut(), "true") && item.getRangeVals() == null) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (list != null) {
                arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (Intrinsics.c(((Item) obj3).getShowOut(), "false")) {
                        arrayList2.add(obj3);
                    }
                }
            } else {
                arrayList2 = new ArrayList();
            }
            ArrayList arrayList4 = arrayList2;
            Iterator it = arrayList4.iterator();
            while (true) {
                i12 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Item item2 = (Item) it.next();
                if (!item2.getFilterValsV2().isEmpty() && this.selectItemsMap.get(item2.getFilterType()) == null) {
                    this.selectItemsMap.put(item2.getFilterType(), item2.getFilterValsV2().get(0).getId());
                }
            }
            g11.P(1849434622);
            Object y10 = g11.y();
            if (y10 == i.f3811a.a()) {
                y10 = u2.c("", null, 2, null);
                g11.p(y10);
            }
            final i1 i1Var2 = (i1) y10;
            g11.K();
            f p11 = SizeKt.p(SizeKt.d(f.f4253a, 0.0f, 1, null), null, false, 3, null);
            androidx.compose.ui.layout.t b11 = a0.b(androidx.compose.foundation.layout.b.f2911a.c(), androidx.compose.ui.b.f4162a.h(), g11, 48);
            int a14 = g.a(g11, 0);
            s n11 = g11.n();
            f e11 = ComposedModifierKt.e(g11, p11);
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
            f3.b(a16, b11, companion.c());
            f3.b(a16, n11, companion.e());
            Function2 b12 = companion.b();
            if (a16.e() || !Intrinsics.c(a16.y(), Integer.valueOf(a14))) {
                a16.p(Integer.valueOf(a14));
                a16.k(Integer.valueOf(a14), b12);
            }
            f3.b(a16, e11, companion.d());
            d0 d0Var = d0.f2924a;
            float size = 2 + ((((Configuration) g11.l(AndroidCompositionLocals_androidKt.f())).screenWidthDp - ((r5 * 46) + 52.0f)) / (arrayList != null ? arrayList.size() : 1));
            g11.P(-1055580859);
            if (arrayList == null) {
                iVar2 = g11;
                arrayList3 = arrayList4;
                i1Var = i1Var2;
                i13 = 0;
            } else {
                int i16 = 0;
                for (Object obj4 : arrayList) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt.u();
                    }
                    final Item item3 = (Item) obj4;
                    String str = (String) this.selectItemsMap.get(item3.getFilterType());
                    if (str == null) {
                        str = item3.getFilterValsV2().get(i12).getId();
                    }
                    if (Intrinsics.c(str, item3.getFilterValsV2().get(i12).getId())) {
                        g11.P(-1987907022);
                        a11 = i0.b.a(R$color.text_03, g11, i12);
                        a12 = i0.b.a(R$color.transparent, g11, i12);
                        str = item3.getTitle();
                        g11.K();
                    } else {
                        g11.P(-1988249107);
                        a11 = i0.b.a(R$color.white, g11, i12);
                        a12 = i0.b.a(com.transsion.wrapperad.R$color.white_40, g11, i12);
                        Iterator<T> it2 = item3.getFilterValsV2().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj = it2.next();
                                if (Intrinsics.c(((FilterVal) obj).getId(), str)) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        FilterVal filterVal = (FilterVal) obj;
                        if (filterVal != null && (name = filterVal.getName()) != null) {
                            str = name;
                        }
                        g11.K();
                    }
                    String str2 = str;
                    long j11 = a12;
                    g11.P(-1055550993);
                    if (Intrinsics.c(k(i1Var2), item3.getFilterType())) {
                        g11.P(-1746271574);
                        boolean A = g11.A(this) | g11.A(item3);
                        Object y11 = g11.y();
                        if (A || y11 == i.f3811a.a()) {
                            y11 = new Function1() { // from class: ul.k
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj5) {
                                    Unit f11;
                                    f11 = PopupFilterView.f(PopupFilterView.this, item3, i1Var2, (String) obj5);
                                    return f11;
                                }
                            };
                            g11.p(y11);
                        }
                        g11.K();
                        w.e(item3, str2, (Function1) y11, g11, i12);
                    }
                    g11.K();
                    b.c h11 = androidx.compose.ui.b.f4162a.h();
                    f.a aVar = f.f4253a;
                    float f11 = i14;
                    ArrayList arrayList5 = arrayList4;
                    float f12 = 100;
                    f a17 = BackgroundKt.a(BorderKt.e(SizeKt.e(aVar, o0.i.g(28)), o0.i.g(f11), a11, q.g.c(o0.i.g(f12))), j11, q.g.c(o0.i.g(f12)));
                    g11.P(-1633490746);
                    boolean A2 = g11.A(item3);
                    Object y12 = g11.y();
                    if (A2 || y12 == i.f3811a.a()) {
                        y12 = new Function0() { // from class: ul.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit g12;
                                g12 = PopupFilterView.g(Item.this, i1Var2);
                                return g12;
                            }
                        };
                        g11.p(y12);
                    }
                    g11.K();
                    f d11 = ClickableKt.d(a17, false, null, null, (Function0) y12, 7, null);
                    androidx.compose.ui.layout.t b13 = a0.b(androidx.compose.foundation.layout.b.f2911a.c(), h11, g11, 48);
                    int a18 = g.a(g11, 0);
                    s n12 = g11.n();
                    f e12 = ComposedModifierKt.e(g11, d11);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f5299c1;
                    Function0 a19 = companion2.a();
                    if (!(g11.i() instanceof androidx.compose.runtime.f)) {
                        g.b();
                    }
                    g11.C();
                    if (g11.e()) {
                        g11.F(a19);
                    } else {
                        g11.o();
                    }
                    i a20 = f3.a(g11);
                    f3.b(a20, b13, companion2.c());
                    f3.b(a20, n12, companion2.e());
                    Function2 b14 = companion2.b();
                    if (a20.e() || !Intrinsics.c(a20.y(), Integer.valueOf(a18))) {
                        a20.p(Integer.valueOf(a18));
                        a20.k(Integer.valueOf(a18), b14);
                    }
                    f3.b(a20, e12, companion2.d());
                    d0 d0Var2 = d0.f2924a;
                    e0.a(SizeKt.l(aVar, o0.i.g(12)), g11, 6);
                    i iVar3 = g11;
                    TextKt.a(str2, SizeKt.n(aVar, 0.0f, o0.i.g(size), 1, null), i0.b.a(R$color.white, g11, 0), x.c(14), null, p.f6224b.c(), h.f6199b.b(), 0L, null, null, 0L, androidx.compose.ui.text.style.p.f6517a.b(), false, 1, 0, null, null, iVar3, 199680, 3120, 120720);
                    IconKt.a(i0.e.c(R$drawable.ic_arrow_down, iVar3, 0), MRAIDPresenter.OPEN, PaddingKt.i(SizeKt.e(SizeKt.l(aVar, o0.i.g(16)), o0.i.g(17)), 0.0f, o0.i.g(f11), 0.0f, 0.0f, 13, null), i0.b.a(R$color.white, iVar3, 0), iVar3, 432, 0);
                    e0.a(SizeKt.l(aVar, o0.i.g(10)), iVar3, 6);
                    iVar3.r();
                    e0.a(SizeKt.l(aVar, o0.i.g(8)), iVar3, 6);
                    i1Var2 = i1Var2;
                    g11 = iVar3;
                    i12 = 0;
                    arrayList4 = arrayList5;
                    i16 = i17;
                    size = size;
                    i14 = 1;
                }
                iVar2 = g11;
                arrayList3 = arrayList4;
                i1Var = i1Var2;
                i13 = i12;
                Unit unit = Unit.f67184a;
            }
            iVar2.K();
            f.a aVar2 = f.f4253a;
            e0.a(b0.a(d0Var, SizeKt.l(aVar2, o0.i.g(i13)), 1.0f, false, 2, null), iVar2, i13);
            iVar2.P(-1055474072);
            if (!arrayList3.isEmpty()) {
                if (m(list)) {
                    iVar2.P(1640111020);
                    a13 = i0.b.a(R$color.brand, iVar2, i13);
                    iVar2.K();
                } else {
                    iVar2.P(1640207244);
                    a13 = i0.b.a(R$color.white, iVar2, i13);
                    iVar2.K();
                }
                long j12 = a13;
                Painter c11 = i0.e.c(R$mipmap.ic_sub_operation_filter, iVar2, i13);
                float f13 = 24;
                f e13 = SizeKt.e(SizeKt.l(aVar2, o0.i.g(f13)), o0.i.g(f13));
                iVar2.P(5004770);
                Object y13 = iVar2.y();
                if (y13 == i.f3811a.a()) {
                    y13 = new Function0() { // from class: ul.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit h12;
                            h12 = PopupFilterView.h(i1.this);
                            return h12;
                        }
                    };
                    iVar2.p(y13);
                }
                iVar2.K();
                IconKt.a(c11, "filter", ClickableKt.d(e13, false, null, null, (Function0) y13, 7, null), j12, iVar2, 48, 0);
            }
            iVar2.K();
            iVar2.P(-1055450448);
            if (Intrinsics.c(k(i1Var), "multi")) {
                t tVar = this.selectItemsMap;
                iVar2.P(-1633490746);
                boolean A3 = iVar2.A(this);
                Object y14 = iVar2.y();
                if (A3 || y14 == i.f3811a.a()) {
                    y14 = new Function1() { // from class: ul.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj5) {
                            Unit i18;
                            i18 = PopupFilterView.i(PopupFilterView.this, i1Var, ((Boolean) obj5).booleanValue());
                            return i18;
                        }
                    };
                    iVar2.p(y14);
                }
                iVar2.K();
                e.p(arrayList3, tVar, (Function1) y14, iVar2, i13);
            }
            iVar2.K();
            iVar2.r();
            if (k.H()) {
                k.P();
            }
        }
        g2 j13 = iVar2.j();
        if (j13 != null) {
            j13.a(new Function2() { // from class: ul.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    Unit j14;
                    j14 = PopupFilterView.j(PopupFilterView.this, list, i11, (androidx.compose.runtime.i) obj5, ((Integer) obj6).intValue());
                    return j14;
                }
            });
        }
    }

    public final void initSelectData(List<Item> data, HashMap<String, String> selectItems) {
        List<Item> list = data;
        if (list == null || list.isEmpty()) {
            jg.c.g(this);
        } else {
            jg.c.k(this);
        }
        removeAllViews();
        this.selectItemsMap.clear();
        if (selectItems != null) {
            this.selectItemsMap.putAll(selectItems);
        }
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        Object context2 = composeView.getContext();
        ViewTreeLifecycleOwner.b(composeView, context2 instanceof u ? (u) context2 : null);
        Object context3 = composeView.getContext();
        ViewTreeViewModelStoreOwner.b(composeView, context3 instanceof y0 ? (y0) context3 : null);
        Object context4 = composeView.getContext();
        ViewTreeSavedStateRegistryOwner.b(composeView, context4 instanceof InterfaceC1015e ? (InterfaceC1015e) context4 : null);
        composeView.setContent(androidx.compose.runtime.internal.b.b(486758898, true, new b(data)));
        addView(composeView);
    }

    public final void setOnFilterListener(Function1<? super Map<String, String>, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.onFilterChangedListener = callback;
    }
}
