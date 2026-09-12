package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: l, reason: collision with root package name */
    private static final Interpolator f1890l = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Runnable f1891a;

    /* renamed from: b, reason: collision with root package name */
    private b f1892b;

    /* renamed from: c, reason: collision with root package name */
    LinearLayoutCompat f1893c;

    /* renamed from: d, reason: collision with root package name */
    private Spinner f1894d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1895e;

    /* renamed from: f, reason: collision with root package name */
    int f1896f;

    /* renamed from: g, reason: collision with root package name */
    int f1897g;

    /* renamed from: h, reason: collision with root package name */
    private int f1898h;

    /* renamed from: i, reason: collision with root package name */
    private int f1899i;

    /* renamed from: j, reason: collision with root package name */
    protected ViewPropertyAnimator f1900j;

    /* renamed from: k, reason: collision with root package name */
    protected final d f1901k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f1893c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i11) {
            return ((c) ScrollingTabContainerView.this.f1893c.getChildAt(i11)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i11) {
            return i11;
        }

        @Override // android.widget.Adapter
        public View getView(int i11, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.c((a.b) getItem(i11), true);
            }
            ((c) view).a((a.b) getItem(i11));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().e();
            int childCount = ScrollingTabContainerView.this.f1893c.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = ScrollingTabContainerView.this.f1893c.getChildAt(i11);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f1904a;

        /* renamed from: b, reason: collision with root package name */
        private a.b f1905b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f1906c;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f1907d;

        /* renamed from: e, reason: collision with root package name */
        private View f1908e;

        public c(Context context, a.b bVar, boolean z10) {
            super(context, null, R$attr.actionBarTabStyle);
            int[] iArr = {R.attr.background};
            this.f1904a = iArr;
            this.f1905b = bVar;
            j0 v11 = j0.v(context, null, iArr, R$attr.actionBarTabStyle, 0);
            if (v11.s(0)) {
                setBackgroundDrawable(v11.g(0));
            }
            v11.x();
            if (z10) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.b bVar) {
            this.f1905b = bVar;
            c();
        }

        public a.b b() {
            return this.f1905b;
        }

        public void c() {
            a.b bVar = this.f1905b;
            View b11 = bVar.b();
            if (b11 != null) {
                ViewParent parent = b11.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b11);
                    }
                    addView(b11);
                }
                this.f1908e = b11;
                TextView textView = this.f1906c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1907d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1907d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1908e;
            if (view != null) {
                removeView(view);
                this.f1908e = null;
            }
            Drawable c11 = bVar.c();
            CharSequence d11 = bVar.d();
            if (c11 != null) {
                if (this.f1907d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1907d = appCompatImageView;
                }
                this.f1907d.setImageDrawable(c11);
                this.f1907d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1907d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1907d.setImageDrawable(null);
                }
            }
            boolean isEmpty = TextUtils.isEmpty(d11);
            if (isEmpty) {
                TextView textView2 = this.f1906c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1906c.setText((CharSequence) null);
                }
            } else {
                if (this.f1906c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1906c = appCompatTextView;
                }
                this.f1906c.setText(d11);
                this.f1906c.setVisibility(0);
            }
            ImageView imageView3 = this.f1907d;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.a());
            }
            o0.a(this, isEmpty ? bVar.a() : null);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            if (ScrollingTabContainerView.this.f1896f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i13 = ScrollingTabContainerView.this.f1896f;
                if (measuredWidth > i13) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), i12);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* loaded from: classes.dex */
    protected class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1910a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f1911b;

        protected d() {
        }

        public d a(ViewPropertyAnimator viewPropertyAnimator, int i11) {
            this.f1911b = i11;
            ScrollingTabContainerView.this.f1900j = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1910a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1910a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.f1900j = null;
            scrollingTabContainerView.setVisibility(this.f1911b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f1910a = false;
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        this.f1901k = new d();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.a b11 = androidx.appcompat.view.a.b(context);
        setContentHeight(b11.f());
        this.f1897g = b11.e();
        LinearLayoutCompat b12 = b();
        this.f1893c = b12;
        addView(b12, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner a() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat b() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        return linearLayoutCompat;
    }

    private boolean d() {
        Spinner spinner = this.f1894d;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f1894d == null) {
            this.f1894d = a();
        }
        removeView(this.f1893c);
        addView(this.f1894d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1894d.getAdapter() == null) {
            this.f1894d.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.f1891a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1891a = null;
        }
        this.f1894d.setSelection(this.f1899i);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1894d);
        addView(this.f1893c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1894d.getSelectedItemPosition());
        return false;
    }

    public void addTab(a.b bVar, int i11, boolean z10) {
        c c11 = c(bVar, false);
        this.f1893c.addView(c11, i11, new LinearLayoutCompat.a(0, -1, 1.0f));
        Spinner spinner = this.f1894d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z10) {
            c11.setSelected(true);
        }
        if (this.f1895e) {
            requestLayout();
        }
    }

    public void addTab(a.b bVar, boolean z10) {
        c c11 = c(bVar, false);
        this.f1893c.addView(c11, new LinearLayoutCompat.a(0, -1, 1.0f));
        Spinner spinner = this.f1894d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z10) {
            c11.setSelected(true);
        }
        if (this.f1895e) {
            requestLayout();
        }
    }

    public void animateToTab(int i11) {
        final View childAt = this.f1893c.getChildAt(i11);
        Runnable runnable = this.f1891a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f1891a = null;
            }
        };
        this.f1891a = runnable2;
        post(runnable2);
    }

    public void animateToVisibility(int i11) {
        ViewPropertyAnimator viewPropertyAnimator = this.f1900j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i11 != 0) {
            ViewPropertyAnimator alpha = animate().alpha(0.0f);
            alpha.setDuration(200L);
            alpha.setInterpolator(f1890l);
            alpha.setListener(this.f1901k.a(alpha, i11));
            alpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimator alpha2 = animate().alpha(1.0f);
        alpha2.setDuration(200L);
        alpha2.setInterpolator(f1890l);
        alpha2.setListener(this.f1901k.a(alpha2, i11));
        alpha2.start();
    }

    c c(a.b bVar, boolean z10) {
        c cVar = new c(getContext(), bVar, z10);
        if (z10) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1898h));
        } else {
            cVar.setFocusable(true);
            if (this.f1892b == null) {
                this.f1892b = new b();
            }
            cVar.setOnClickListener(this.f1892b);
        }
        return cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1891a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a b11 = androidx.appcompat.view.a.b(getContext());
        setContentHeight(b11.f());
        this.f1897g = b11.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1891a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
        ((c) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        boolean z10 = mode == 1073741824;
        setFillViewport(z10);
        int childCount = this.f1893c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f1896f = -1;
        } else {
            if (childCount > 2) {
                this.f1896f = (int) (View.MeasureSpec.getSize(i11) * 0.4f);
            } else {
                this.f1896f = View.MeasureSpec.getSize(i11) / 2;
            }
            this.f1896f = Math.min(this.f1896f, this.f1897g);
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1898h, 1073741824);
        if (z10 || !this.f1895e) {
            f();
        } else {
            this.f1893c.measure(0, makeMeasureSpec);
            if (this.f1893c.getMeasuredWidth() > View.MeasureSpec.getSize(i11)) {
                e();
            } else {
                f();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i11, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z10 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1899i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void removeAllTabs() {
        this.f1893c.removeAllViews();
        Spinner spinner = this.f1894d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1895e) {
            requestLayout();
        }
    }

    public void removeTabAt(int i11) {
        this.f1893c.removeViewAt(i11);
        Spinner spinner = this.f1894d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1895e) {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean z10) {
        this.f1895e = z10;
    }

    public void setContentHeight(int i11) {
        this.f1898h = i11;
        requestLayout();
    }

    public void setTabSelected(int i11) {
        this.f1899i = i11;
        int childCount = this.f1893c.getChildCount();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = this.f1893c.getChildAt(i12);
            boolean z10 = i12 == i11;
            childAt.setSelected(z10);
            if (z10) {
                animateToTab(i11);
            }
            i12++;
        }
        Spinner spinner = this.f1894d;
        if (spinner == null || i11 < 0) {
            return;
        }
        spinner.setSelection(i11);
    }

    public void updateTab(int i11) {
        ((c) this.f1893c.getChildAt(i11)).c();
        Spinner spinner = this.f1894d;
        if (spinner != null) {
            ((a) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f1895e) {
            requestLayout();
        }
    }
}
