package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$string;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomePreferencesContentItem;
import com.transsion.home.bean.HomePreferencesSelectType;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class e extends BaseItemProvider {

    /* renamed from: r, reason: collision with root package name */
    public static final a f44791r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    public static final int f44792s = 8;

    /* renamed from: f, reason: collision with root package name */
    private Function1 f44794f;

    /* renamed from: g, reason: collision with root package name */
    private Function1 f44795g;

    /* renamed from: h, reason: collision with root package name */
    private Function3 f44796h;

    /* renamed from: i, reason: collision with root package name */
    private Function1 f44797i;

    /* renamed from: p, reason: collision with root package name */
    private final TextPaint f44804p;

    /* renamed from: q, reason: collision with root package name */
    private final Map f44805q;

    /* renamed from: e, reason: collision with root package name */
    private final Set f44793e = new LinkedHashSet();

    /* renamed from: j, reason: collision with root package name */
    private final int f44798j = com.blankj.utilcode.util.a0.a(12.0f);

    /* renamed from: k, reason: collision with root package name */
    private final int f44799k = com.blankj.utilcode.util.a0.a(32.0f);

    /* renamed from: l, reason: collision with root package name */
    private final int f44800l = com.blankj.utilcode.util.a0.a(68.0f);

    /* renamed from: m, reason: collision with root package name */
    private final int f44801m = com.blankj.utilcode.util.a0.a(8.0f);

    /* renamed from: n, reason: collision with root package name */
    private final int f44802n = com.blankj.utilcode.util.a0.a(16.0f);

    /* renamed from: o, reason: collision with root package name */
    private final int f44803o = com.blankj.utilcode.util.a0.a(4.0f);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e() {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(com.blankj.utilcode.util.a0.a(12.0f));
        this.f44804p = textPaint;
        this.f44805q = new LinkedHashMap();
    }

    private final void A(LinearLayout linearLayout, List list, boolean z10, int i11, LinearLayout linearLayout2) {
        int a11 = com.blankj.utilcode.util.a0.a(8.0f);
        int i12 = 0;
        for (Object obj : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            View E = E(linearLayout, (HomePreferencesContentItem) obj, z10, i11, linearLayout2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.f44799k);
            layoutParams.setMarginStart(i12 == 0 ? a11 : this.f44801m);
            linearLayout.addView(E, layoutParams);
            i12 = i13;
        }
    }

    private final void B(GradientTextView gradientTextView, Context context, boolean z10) {
        int color = androidx.core.content.b.getColor(context, R$color.white_80);
        int color2 = androidx.core.content.b.getColor(context, R$color.brand_new_gradient_start);
        int color3 = androidx.core.content.b.getColor(context, R$color.brand_new_gradient_center);
        int color4 = androidx.core.content.b.getColor(context, R$color.brand_new_gradient_end);
        if (!z10) {
            color2 = color;
        }
        if (!z10) {
            color3 = color;
        }
        if (z10) {
            color = color4;
        }
        gradientTextView.setGradientColors(color2, color3, color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(e eVar, HomePreferencesConfig homePreferencesConfig, View view) {
        Function1 function1 = eVar.f44794f;
        if (function1 != null) {
            function1.invoke(homePreferencesConfig);
        }
    }

    private final LinearLayout E(ViewGroup viewGroup, final HomePreferencesContentItem homePreferencesContentItem, final boolean z10, final int i11, final LinearLayout linearLayout) {
        final Context context = viewGroup.getContext();
        boolean contains = this.f44793e.contains(homePreferencesContentItem.getValue());
        final LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setMinimumWidth(this.f44800l);
        int i12 = this.f44798j;
        linearLayout2.setPadding(i12, 0, i12, 0);
        linearLayout2.setBackground(androidx.core.content.b.getDrawable(context, R$drawable.bg_preferences_tag));
        linearLayout2.setSelected(contains);
        linearLayout2.setTag(homePreferencesContentItem.getValue());
        Intrinsics.e(context);
        final GradientTextView gradientTextView = new GradientTextView(context, null, 0, 6, null);
        gradientTextView.setText(homePreferencesContentItem.getName());
        gradientTextView.setTextSize(12.0f);
        gradientTextView.setMaxLines(1);
        gradientTextView.setGravity(17);
        gradientTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        B(gradientTextView, context, contains);
        final ImageView imageView = new ImageView(context);
        imageView.setImageResource(contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
        int i13 = this.f44802n;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i13, i13);
        layoutParams.setMarginStart(this.f44803o);
        imageView.setLayoutParams(layoutParams);
        linearLayout2.addView(gradientTextView);
        linearLayout2.addView(imageView);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.F(z10, this, homePreferencesContentItem, linearLayout, i11, context, linearLayout2, imageView, gradientTextView, view);
            }
        });
        return linearLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(boolean z10, e eVar, HomePreferencesContentItem homePreferencesContentItem, LinearLayout linearLayout, int i11, Context context, LinearLayout linearLayout2, ImageView imageView, GradientTextView gradientTextView, View view) {
        if (z10) {
            if (eVar.f44793e.contains(homePreferencesContentItem.getValue())) {
                eVar.f44793e.remove(homePreferencesContentItem.getValue());
            } else {
                eVar.f44793e.clear();
                eVar.f44793e.add(homePreferencesContentItem.getValue());
            }
            eVar.I(linearLayout);
        } else {
            boolean contains = eVar.f44793e.contains(homePreferencesContentItem.getValue());
            boolean z11 = !contains;
            if (contains) {
                eVar.f44793e.remove(homePreferencesContentItem.getValue());
            } else {
                if (i11 > 0 && eVar.f44793e.size() >= i11) {
                    String string = context.getString(R$string.home_preferences_max_select_tips, Integer.valueOf(i11));
                    Intrinsics.g(string, "getString(...)");
                    com.transsion.baseui.util.m.f(string);
                    return;
                }
                eVar.f44793e.add(homePreferencesContentItem.getValue());
            }
            linearLayout2.setSelected(z11);
            imageView.setImageResource(!contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
            Intrinsics.e(context);
            eVar.B(gradientTextView, context, z11);
        }
        Function1 function1 = eVar.f44795g;
        if (function1 != null) {
            function1.invoke(CollectionsKt.R0(eVar.f44793e));
        }
    }

    private final List G(List list, int i11) {
        List[] listArr = new List[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            listArr[i12] = new ArrayList();
        }
        float[] fArr = new float[i11];
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HomePreferencesContentItem homePreferencesContentItem = (HomePreferencesContentItem) it.next();
            float H = H(homePreferencesContentItem.getName());
            float f11 = Float.MAX_VALUE;
            int i13 = -1;
            for (int i14 = 0; i14 < i11; i14++) {
                if (listArr[i14].size() < 8) {
                    float f12 = fArr[i14];
                    if (f12 < f11) {
                        i13 = i14;
                        f11 = f12;
                    }
                }
            }
            if (i13 == -1) {
                break;
            }
            listArr[i13].add(homePreferencesContentItem);
            fArr[i13] = fArr[i13] + H + this.f44801m;
        }
        ArrayList arrayList = new ArrayList(i11);
        for (int i15 = 0; i15 < i11; i15++) {
            arrayList.add(CollectionsKt.R0(listArr[i15]));
        }
        return arrayList;
    }

    private final float H(String str) {
        return Math.max((this.f44798j * 2) + this.f44804p.measureText(str) + this.f44803o + this.f44802n, this.f44800l);
    }

    private final void I(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) childAt;
                int childCount2 = linearLayout.getChildCount();
                for (int i12 = 0; i12 < childCount2; i12++) {
                    View childAt2 = linearLayout.getChildAt(i12);
                    if (childAt2 instanceof LinearLayout) {
                        LinearLayout linearLayout2 = (LinearLayout) childAt2;
                        if (linearLayout2.getTag() instanceof String) {
                            Object tag = linearLayout2.getTag();
                            Intrinsics.f(tag, "null cannot be cast to non-null type kotlin.String");
                            boolean contains = this.f44793e.contains((String) tag);
                            linearLayout2.setSelected(contains);
                            if (linearLayout2.getChildCount() >= 2) {
                                View childAt3 = linearLayout2.getChildAt(0);
                                GradientTextView gradientTextView = childAt3 instanceof GradientTextView ? (GradientTextView) childAt3 : null;
                                if (gradientTextView != null) {
                                    Context context = linearLayout2.getContext();
                                    Intrinsics.g(context, "getContext(...)");
                                    B(gradientTextView, context, contains);
                                }
                                View childAt4 = linearLayout2.getChildAt(1);
                                ImageView imageView = childAt4 instanceof ImageView ? (ImageView) childAt4 : null;
                                if (imageView != null) {
                                    imageView.setImageResource(contains ? R$drawable.ic_preferences_heart_selected : R$drawable.ic_preferences_heart_unselected);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, OperateItem item) {
        boolean z10;
        final e eVar = this;
        Intrinsics.h(helper, "helper");
        Intrinsics.h(item, "item");
        long nanoTime = System.nanoTime();
        final HomePreferencesConfig homePreferencesConfig = item.getHomePreferencesConfig();
        if (homePreferencesConfig == null) {
            return;
        }
        List options = homePreferencesConfig.getOptions();
        if (options.isEmpty()) {
            return;
        }
        TextView textView = (TextView) helper.getViewOrNull(R$id.tv_title);
        if (textView != null) {
            textView.setText(homePreferencesConfig.getTitle());
        }
        ImageView imageView = (ImageView) helper.getViewOrNull(R$id.iv_close);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.D(e.this, homePreferencesConfig, view);
                }
            });
        }
        LinearLayout linearLayout = (LinearLayout) helper.getViewOrNull(R$id.ll_rows_container);
        if (linearLayout == null) {
            return;
        }
        boolean c11 = Intrinsics.c(homePreferencesConfig.getSelectType(), HomePreferencesSelectType.SINGLE.getValue());
        String labelId = homePreferencesConfig.getLabelId();
        List list = (List) eVar.f44805q.get(labelId);
        if (list != null) {
            List x10 = CollectionsKt.x(list);
            boolean z11 = x10.size() == options.size();
            if (z11) {
                List list2 = x10;
                ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((HomePreferencesContentItem) it.next()).getValue());
                }
                List list3 = options;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.v(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((HomePreferencesContentItem) it2.next()).getValue());
                }
                z10 = Intrinsics.c(arrayList, arrayList2);
            } else {
                z10 = false;
            }
            if (!z11 || !z10) {
                list = eVar.G(options, options.size() <= 8 ? 1 : (int) Math.ceil(options.size() / 8));
                eVar.f44805q.put(labelId, list);
            }
        } else {
            list = eVar.G(options, options.size() <= 8 ? 1 : (int) Math.ceil(options.size() / 8));
            eVar.f44805q.put(labelId, list);
        }
        int size = list.size();
        Object tag = linearLayout.getTag();
        if (!Intrinsics.c(tag instanceof String ? (String) tag : null, labelId) || linearLayout.getChildCount() == 0) {
            linearLayout.removeAllViews();
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                List list4 = (List) obj;
                LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setOrientation(0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i11 > 0) {
                    layoutParams.topMargin = eVar.f44801m;
                }
                linearLayout2.setLayoutParams(layoutParams);
                A(linearLayout2, list4, c11, homePreferencesConfig.getMaxSelectNum(), linearLayout);
                linearLayout.addView(linearLayout2);
                eVar = this;
                i11 = i12;
            }
            linearLayout.setTag(labelId);
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) helper.getViewOrNull(R$id.hsv_tags);
        if (horizontalScrollView != null) {
            horizontalScrollView.scrollTo(0, 0);
        }
        float nanoTime2 = ((float) (System.nanoTime() - nanoTime)) / 1000000.0f;
        a.C0856a.f(lg.a.f68962a, "HomePreferencesProvider", "convert cost=" + nanoTime2 + "ms, items=" + options.size() + ", rows=" + size, false, 4, null);
    }

    public final void J(Function1 function1) {
        this.f44794f = function1;
    }

    public final void K(Function1 function1) {
        this.f44797i = function1;
    }

    public final void L(Function3 function3) {
        this.f44796h = function3;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int l() {
        return PostItemType.PREFERENCES.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int m() {
        return R$layout.item_home_preferences;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void t(BaseViewHolder holder) {
        HomePreferencesConfig homePreferencesConfig;
        List<Object> data;
        Intrinsics.h(holder, "holder");
        super.t(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        BaseProviderMultiAdapter g11 = g();
        OperateItem operateItem = (g11 == null || (data = g11.getData()) == null) ? null : (OperateItem) CollectionsKt.l0(data, bindingAdapterPosition);
        OperateItem operateItem2 = operateItem instanceof OperateItem ? operateItem : null;
        if (operateItem2 == null || (homePreferencesConfig = operateItem2.getHomePreferencesConfig()) == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "HomePreferencesProvider", "onViewAttachedToWindow: labelId=" + homePreferencesConfig.getLabelId(), false, 4, null);
        Function1 function1 = this.f44797i;
        if (function1 != null) {
            function1.invoke(homePreferencesConfig);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public void u(BaseViewHolder holder) {
        HomePreferencesConfig homePreferencesConfig;
        List<Object> data;
        Intrinsics.h(holder, "holder");
        super.u(holder);
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        BaseProviderMultiAdapter g11 = g();
        OperateItem operateItem = (g11 == null || (data = g11.getData()) == null) ? null : (OperateItem) CollectionsKt.l0(data, bindingAdapterPosition);
        OperateItem operateItem2 = operateItem instanceof OperateItem ? operateItem : null;
        if (operateItem2 == null || (homePreferencesConfig = operateItem2.getHomePreferencesConfig()) == null) {
            return;
        }
        List<HomePreferencesContentItem> options = homePreferencesConfig.getOptions();
        ArrayList arrayList = new ArrayList(CollectionsKt.v(options, 10));
        Iterator<T> it = options.iterator();
        while (it.hasNext()) {
            arrayList.add(((HomePreferencesContentItem) it.next()).getValue());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (this.f44793e.contains((String) obj)) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            a.C0856a.f(lg.a.f68962a, "HomePreferencesProvider", "onViewDetachedFromWindow: no selection, skip submit, labelId=" + homePreferencesConfig.getLabelId(), false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "HomePreferencesProvider", "onViewDetachedFromWindow: try submit, labelId=" + homePreferencesConfig.getLabelId() + ", options=" + arrayList2, false, 4, null);
        Function3 function3 = this.f44796h;
        if (function3 != null) {
            function3.invoke(homePreferencesConfig, arrayList2, "opt_scroll");
        }
    }
}
