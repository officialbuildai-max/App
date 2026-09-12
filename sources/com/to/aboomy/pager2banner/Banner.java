package com.to.aboomy.pager2banner;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class Banner extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f41756a;

    /* renamed from: b, reason: collision with root package name */
    private CompositePageTransformer f41757b;

    /* renamed from: c, reason: collision with root package name */
    private c f41758c;

    /* renamed from: d, reason: collision with root package name */
    private ViewPager2 f41759d;

    /* renamed from: e, reason: collision with root package name */
    private com.to.aboomy.pager2banner.a f41760e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f41761f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41762g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f41763h;

    /* renamed from: i, reason: collision with root package name */
    private long f41764i;

    /* renamed from: j, reason: collision with root package name */
    private long f41765j;

    /* renamed from: k, reason: collision with root package name */
    private int f41766k;

    /* renamed from: l, reason: collision with root package name */
    private int f41767l;

    /* renamed from: m, reason: collision with root package name */
    private int f41768m;

    /* renamed from: n, reason: collision with root package name */
    private float f41769n;

    /* renamed from: o, reason: collision with root package name */
    private float f41770o;

    /* renamed from: p, reason: collision with root package name */
    private float f41771p;

    /* renamed from: q, reason: collision with root package name */
    private float f41772q;

    /* renamed from: r, reason: collision with root package name */
    private final int f41773r;

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f41774s;

    /* renamed from: t, reason: collision with root package name */
    private final RecyclerView.g f41775t;

    /* loaded from: classes5.dex */
    class a extends RecyclerView.g {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onChanged() {
            Banner banner = Banner.this;
            banner.t(banner.getCurrentPager());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onItemRangeChanged(int i11, int i12, Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onItemRangeInserted(int i11, int i12) {
            if (i11 > 1) {
                onChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void onItemRangeMoved(int i11, int i12, int i13) {
            onChanged();
        }
    }

    /* loaded from: classes5.dex */
    class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f41777a;

        b(float f11) {
            this.f41777a = f11;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f41777a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView.Adapter f41779a;

        private c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return h() > 1 ? h() + Banner.this.f41766k : h();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i11) {
            return this.f41779a.getItemId(Banner.this.u(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i11) {
            return this.f41779a.getItemViewType(Banner.this.u(i11));
        }

        int h() {
            RecyclerView.Adapter adapter = this.f41779a;
            if (adapter == null) {
                return 0;
            }
            return adapter.getItemCount();
        }

        void i(RecyclerView.Adapter adapter) {
            RecyclerView.Adapter adapter2 = this.f41779a;
            if (adapter2 != null) {
                adapter2.unregisterAdapterDataObserver(Banner.this.f41775t);
            }
            this.f41779a = adapter;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(Banner.this.f41775t);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.b0 b0Var, int i11) {
            this.f41779a.onBindViewHolder(b0Var, Banner.this.u(i11));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.b0 onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return this.f41779a.onCreateViewHolder(viewGroup, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d extends ViewPager2.OnPageChangeCallback {
        private d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            if (i11 == 1) {
                if (Banner.this.f41768m == Banner.this.f41767l - 1) {
                    Banner.this.f41762g = false;
                    Banner.this.f41759d.setCurrentItem(Banner.this.getRealCount() + Banner.this.f41768m, false);
                } else if (Banner.this.f41768m == Banner.this.getRealCount() + Banner.this.f41767l) {
                    Banner.this.f41762g = false;
                    Banner.this.f41759d.setCurrentItem(Banner.this.f41767l, false);
                } else {
                    Banner.this.f41762g = true;
                }
            }
            if (Banner.this.f41756a != null) {
                Banner.this.f41756a.onPageScrollStateChanged(i11);
            }
            if (Banner.this.f41760e != null) {
                Banner.this.f41760e.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            int u11 = Banner.this.u(i11);
            if (Banner.this.f41756a != null) {
                Banner.this.f41756a.onPageScrolled(u11, f11, i12);
            }
            if (Banner.this.f41760e != null) {
                Banner.this.f41760e.onPageScrolled(u11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            if (Banner.this.getRealCount() > 1) {
                Banner.this.f41768m = i11;
            }
            if (Banner.this.f41762g) {
                int u11 = Banner.this.u(i11);
                if (Banner.this.f41756a != null) {
                    Banner.this.f41756a.onPageSelected(u11);
                }
                if (Banner.this.f41760e != null) {
                    Banner.this.f41760e.onPageSelected(u11);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class e extends LinearLayoutManager {

        /* renamed from: a, reason: collision with root package name */
        private final RecyclerView.m f41782a;

        /* loaded from: classes5.dex */
        class a extends h {
            a(Context context) {
                super(context);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.h
            public int w(int i11) {
                return (int) (Banner.this.f41765j * 0.6644d);
            }
        }

        e(Context context, LinearLayoutManager linearLayoutManager) {
            super(context, linearLayoutManager.getOrientation(), false);
            this.f41782a = linearLayoutManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.y yVar, int[] iArr) {
            try {
                Method declaredMethod = this.f41782a.getClass().getDeclaredMethod("calculateExtraLayoutSpace", yVar.getClass(), iArr.getClass());
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f41782a, yVar, iArr);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (NoSuchMethodException e12) {
                e12.printStackTrace();
            } catch (InvocationTargetException e13) {
                e13.printStackTrace();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public void onInitializeAccessibilityNodeInfo(RecyclerView.t tVar, RecyclerView.y yVar, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.f41782a.onInitializeAccessibilityNodeInfo(tVar, yVar, accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean performAccessibilityAction(RecyclerView.t tVar, RecyclerView.y yVar, int i11, Bundle bundle) {
            return this.f41782a.performAccessibilityAction(tVar, yVar, i11, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.m
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
            return this.f41782a.requestChildRectangleOnScreen(recyclerView, view, rect, z10, z11);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i11) {
            a aVar = new a(recyclerView.getContext());
            aVar.p(i11);
            startSmoothScroll(aVar);
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41761f = true;
        this.f41762g = true;
        this.f41764i = 2500L;
        this.f41765j = 800L;
        this.f41766k = 2;
        this.f41767l = 2 / 2;
        this.f41774s = new Runnable() { // from class: com.to.aboomy.pager2banner.Banner.1
            @Override // java.lang.Runnable
            public void run() {
                if (Banner.this.isAutoPlay()) {
                    Banner.i(Banner.this);
                    if (Banner.this.f41768m == Banner.this.getRealCount() + Banner.this.f41767l + 1) {
                        Banner.this.f41762g = false;
                        Banner.this.f41759d.setCurrentItem(Banner.this.f41767l, false);
                        Banner banner = Banner.this;
                        banner.post(banner.f41774s);
                        return;
                    }
                    Banner.this.f41762g = true;
                    Banner.this.f41759d.setCurrentItem(Banner.this.f41768m);
                    Banner banner2 = Banner.this;
                    banner2.postDelayed(banner2.f41774s, Banner.this.f41764i);
                }
            }
        };
        this.f41775t = new a();
        this.f41773r = ViewConfiguration.get(context).getScaledTouchSlop() >> 1;
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealCount() {
        return this.f41758c.h();
    }

    static /* synthetic */ int i(Banner banner) {
        int i11 = banner.f41768m;
        banner.f41768m = i11 + 1;
        return i11;
    }

    private void r() {
        try {
            RecyclerView recyclerView = (RecyclerView) this.f41759d.getChildAt(0);
            recyclerView.setOverScrollMode(2);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            e eVar = new e(getContext(), linearLayoutManager);
            recyclerView.setLayoutManager(eVar);
            Field declaredField = RecyclerView.m.class.getDeclaredField("mRecyclerView");
            declaredField.setAccessible(true);
            declaredField.set(linearLayoutManager, recyclerView);
            Field declaredField2 = ViewPager2.class.getDeclaredField("mLayoutManager");
            declaredField2.setAccessible(true);
            declaredField2.set(this.f41759d, eVar);
            Field declaredField3 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            declaredField3.setAccessible(true);
            Object obj = declaredField3.get(this.f41759d);
            if (obj != null) {
                Field declaredField4 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, eVar);
            }
            Field declaredField5 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            declaredField5.setAccessible(true);
            Object obj2 = declaredField5.get(this.f41759d);
            if (obj2 != null) {
                Field declaredField6 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField6.setAccessible(true);
                declaredField6.set(obj2, eVar);
            }
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
        } catch (NoSuchFieldException e12) {
            e12.printStackTrace();
        }
    }

    private void s(Context context) {
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f41759d = viewPager2;
        viewPager2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewPager2 viewPager22 = this.f41759d;
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        this.f41757b = compositePageTransformer;
        viewPager22.setPageTransformer(compositePageTransformer);
        this.f41759d.registerOnPageChangeCallback(new d());
        ViewPager2 viewPager23 = this.f41759d;
        c cVar = new c();
        this.f41758c = cVar;
        viewPager23.setAdapter(cVar);
        setOffscreenPageLimit(1);
        r();
        addView(this.f41759d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i11) {
        if (this.f41767l == 2) {
            this.f41759d.setAdapter(this.f41758c);
        } else {
            this.f41758c.notifyDataSetChanged();
        }
        setCurrentItem(i11, false);
        com.to.aboomy.pager2banner.a aVar = this.f41760e;
        if (aVar != null) {
            aVar.initIndicatorCount(getRealCount(), getCurrentPager());
        }
        if (isAutoPlay()) {
            startTurning();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(int i11) {
        int realCount = getRealCount() > 1 ? (i11 - this.f41767l) % getRealCount() : 0;
        return realCount < 0 ? realCount + getRealCount() : realCount;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.l lVar) {
        this.f41759d.addItemDecoration(lVar);
        return this;
    }

    public Banner addItemDecoration(@NonNull RecyclerView.l lVar, int i11) {
        this.f41759d.addItemDecoration(lVar, i11);
        return this;
    }

    public Banner addPageTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.f41757b.addTransformer(pageTransformer);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isAutoPlay() && this.f41759d.isUserInputEnabled()) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startTurning();
            } else if (action == 0) {
                stopTurning();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f41758c.f41779a;
    }

    public int getCurrentPager() {
        return Math.max(u(this.f41768m), 0);
    }

    public ViewPager2 getViewPager2() {
        return this.f41759d;
    }

    public boolean isAutoPlay() {
        return this.f41761f && getRealCount() > 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAutoPlay()) {
            startTurning();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isAutoPlay()) {
            stopTurning();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            float rawX = motionEvent.getRawX();
            this.f41771p = rawX;
            this.f41769n = rawX;
            float rawY = motionEvent.getRawY();
            this.f41772q = rawY;
            this.f41770o = rawY;
        } else {
            boolean z10 = false;
            if (action == 2) {
                this.f41771p = motionEvent.getRawX();
                this.f41772q = motionEvent.getRawY();
                if (this.f41759d.isUserInputEnabled()) {
                    float abs = Math.abs(this.f41771p - this.f41769n);
                    float abs2 = Math.abs(this.f41772q - this.f41770o);
                    if (this.f41759d.getOrientation() != 0 ? !(abs2 <= this.f41773r || abs2 <= abs) : !(abs <= this.f41773r || abs <= abs2)) {
                        z10 = true;
                    }
                    getParent().requestDisallowInterceptTouchEvent(z10);
                }
            } else if (action == 3 || action == 1) {
                return Math.abs(this.f41771p - this.f41769n) > ((float) this.f41773r) || Math.abs(this.f41772q - this.f41770o) > ((float) this.f41773r);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        setAdapter(adapter, 0);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter, int i11) {
        this.f41758c.i(adapter);
        t(i11);
    }

    public Banner setAutoPlay(boolean z10) {
        this.f41761f = z10;
        if (z10 && getRealCount() > 1) {
            startTurning();
        }
        return this;
    }

    public Banner setAutoTurningTime(long j11) {
        this.f41764i = j11;
        return this;
    }

    public void setCurrentItem(int i11) {
        setCurrentItem(i11, true);
    }

    public void setCurrentItem(int i11, boolean z10) {
        int i12 = i11 + this.f41767l;
        this.f41768m = i12;
        this.f41759d.setCurrentItem(i12, z10);
    }

    public Banner setIndicator(com.to.aboomy.pager2banner.a aVar) {
        return setIndicator(aVar, true);
    }

    public Banner setIndicator(com.to.aboomy.pager2banner.a aVar, boolean z10) {
        com.to.aboomy.pager2banner.a aVar2 = this.f41760e;
        if (aVar2 != null) {
            removeView(aVar2.getView());
        }
        if (aVar != null) {
            this.f41760e = aVar;
            if (z10) {
                addView(aVar.getView(), this.f41760e.getParams());
            }
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i11) {
        this.f41759d.setOffscreenPageLimit(i11);
        return this;
    }

    public Banner setOrientation(int i11) {
        this.f41759d.setOrientation(i11);
        return this;
    }

    public Banner setOuterPageChangeListener(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f41756a = onPageChangeCallback;
        return this;
    }

    public Banner setPageMargin(int i11, int i12) {
        return setPageMargin(i11, i11, i12);
    }

    public Banner setPageMargin(int i11, int i12, int i13) {
        if (i13 < 0) {
            i13 = 0;
        }
        addPageTransformer(new MarginPageTransformer(i13));
        RecyclerView recyclerView = (RecyclerView) this.f41759d.getChildAt(0);
        if (this.f41759d.getOrientation() == 1) {
            recyclerView.setPadding(this.f41759d.getPaddingLeft(), i11 + Math.abs(i13), this.f41759d.getPaddingRight(), i12 + Math.abs(i13));
        } else {
            recyclerView.setPadding(i11 + Math.abs(i13), this.f41759d.getPaddingTop(), i12 + Math.abs(i13), this.f41759d.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
        this.f41766k = 4;
        this.f41767l = 2;
        return this;
    }

    public Banner setPagerScrollDuration(long j11) {
        this.f41765j = j11;
        return this;
    }

    public Banner setRoundCorners(float f11) {
        setOutlineProvider(new b(f11));
        setClipToOutline(true);
        return this;
    }

    public void startTurning() {
        stopTurning();
        postDelayed(this.f41774s, this.f41764i);
        this.f41763h = true;
    }

    public void stopTurning() {
        if (this.f41763h) {
            removeCallbacks(this.f41774s);
            this.f41763h = false;
        }
    }
}
