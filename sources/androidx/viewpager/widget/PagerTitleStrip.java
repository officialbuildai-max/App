package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.m;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.c
/* loaded from: classes2.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f15325o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f15326p = {R.attr.textAllCaps};

    /* renamed from: a, reason: collision with root package name */
    ViewPager f15327a;

    /* renamed from: b, reason: collision with root package name */
    TextView f15328b;

    /* renamed from: c, reason: collision with root package name */
    TextView f15329c;

    /* renamed from: d, reason: collision with root package name */
    TextView f15330d;

    /* renamed from: e, reason: collision with root package name */
    private int f15331e;

    /* renamed from: f, reason: collision with root package name */
    float f15332f;

    /* renamed from: g, reason: collision with root package name */
    private int f15333g;

    /* renamed from: h, reason: collision with root package name */
    private int f15334h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f15335i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f15336j;

    /* renamed from: k, reason: collision with root package name */
    private final a f15337k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference f15338l;

    /* renamed from: m, reason: collision with root package name */
    private int f15339m;

    /* renamed from: n, reason: collision with root package name */
    int f15340n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends DataSetObserver implements ViewPager.h, ViewPager.g {

        /* renamed from: a, reason: collision with root package name */
        private int f15341a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.g
        public void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.f15327a.getCurrentItem(), PagerTitleStrip.this.f15327a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f11 = pagerTitleStrip2.f15332f;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.f15327a.getCurrentItem(), f11, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrollStateChanged(int i11) {
            this.f15341a = i11;
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageScrolled(int i11, float f11, int i12) {
            if (f11 > 0.5f) {
                i11++;
            }
            PagerTitleStrip.this.c(i11, f11, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onPageSelected(int i11) {
            if (this.f15341a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.f15327a.getCurrentItem(), PagerTitleStrip.this.f15327a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f11 = pagerTitleStrip2.f15332f;
                if (f11 < 0.0f) {
                    f11 = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.f15327a.getCurrentItem(), f11, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends SingleLineTransformationMethod {

        /* renamed from: a, reason: collision with root package name */
        private Locale f15343a;

        b(Context context) {
            this.f15343a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f15343a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15331e = -1;
        this.f15332f = -1.0f;
        this.f15337k = new a();
        TextView textView = new TextView(context);
        this.f15328b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f15329c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f15330d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f15325o);
        boolean z10 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            m.q(this.f15328b, resourceId);
            m.q(this.f15329c, resourceId);
            m.q(this.f15330d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f15328b.setTextColor(color);
            this.f15329c.setTextColor(color);
            this.f15330d.setTextColor(color);
        }
        this.f15334h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f15340n = this.f15329c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextView textView4 = this.f15328b;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);
        this.f15329c.setEllipsize(truncateAt);
        this.f15330d.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f15326p);
            z10 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z10) {
            setSingleLineAllCaps(this.f15328b);
            setSingleLineAllCaps(this.f15329c);
            setSingleLineAllCaps(this.f15330d);
        } else {
            this.f15328b.setSingleLine();
            this.f15329c.setSingleLine();
            this.f15330d.setSingleLine();
        }
        this.f15333g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f15337k);
            this.f15338l = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f15337k);
            this.f15338l = new WeakReference(pagerAdapter2);
        }
        ViewPager viewPager = this.f15327a;
        if (viewPager != null) {
            this.f15331e = -1;
            this.f15332f = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void b(int i11, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.f15335i = true;
        CharSequence charSequence = null;
        this.f15328b.setText((i11 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i11 - 1));
        this.f15329c.setText((pagerAdapter == null || i11 >= count) ? null : pagerAdapter.getPageTitle(i11));
        int i12 = i11 + 1;
        if (i12 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i12);
        }
        this.f15330d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f15328b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f15329c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f15330d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f15331e = i11;
        if (!this.f15336j) {
            c(i11, this.f15332f, false);
        }
        this.f15335i = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i11, float f11, boolean z10) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (i11 != this.f15331e) {
            b(i11, this.f15327a.getAdapter());
        } else if (!z10 && f11 == this.f15332f) {
            return;
        }
        this.f15336j = true;
        int measuredWidth = this.f15328b.getMeasuredWidth();
        int measuredWidth2 = this.f15329c.getMeasuredWidth();
        int measuredWidth3 = this.f15330d.getMeasuredWidth();
        int i16 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i17 = paddingRight + i16;
        int i18 = (width - (paddingLeft + i16)) - i17;
        float f12 = 0.5f + f11;
        if (f12 > 1.0f) {
            f12 -= 1.0f;
        }
        int i19 = ((width - i17) - ((int) (i18 * f12))) - i16;
        int i20 = measuredWidth2 + i19;
        int baseline = this.f15328b.getBaseline();
        int baseline2 = this.f15329c.getBaseline();
        int baseline3 = this.f15330d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i21 = max - baseline;
        int i22 = max - baseline2;
        int i23 = max - baseline3;
        int max2 = Math.max(Math.max(this.f15328b.getMeasuredHeight() + i21, this.f15329c.getMeasuredHeight() + i22), this.f15330d.getMeasuredHeight() + i23);
        int i24 = this.f15334h & 112;
        if (i24 == 16) {
            i12 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else {
            if (i24 != 80) {
                i13 = i21 + paddingTop;
                i14 = i22 + paddingTop;
                i15 = paddingTop + i23;
                TextView textView = this.f15329c;
                textView.layout(i19, i14, i20, textView.getMeasuredHeight() + i14);
                int min = Math.min(paddingLeft, (i19 - this.f15333g) - measuredWidth);
                TextView textView2 = this.f15328b;
                textView2.layout(min, i13, measuredWidth + min, textView2.getMeasuredHeight() + i13);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i20 + this.f15333g);
                TextView textView3 = this.f15330d;
                textView3.layout(max3, i15, max3 + measuredWidth3, textView3.getMeasuredHeight() + i15);
                this.f15332f = f11;
                this.f15336j = false;
            }
            i12 = (height - paddingBottom) - max2;
        }
        i13 = i21 + i12;
        i14 = i22 + i12;
        i15 = i12 + i23;
        TextView textView4 = this.f15329c;
        textView4.layout(i19, i14, i20, textView4.getMeasuredHeight() + i14);
        int min2 = Math.min(paddingLeft, (i19 - this.f15333g) - measuredWidth);
        TextView textView22 = this.f15328b;
        textView22.layout(min2, i13, measuredWidth + min2, textView22.getMeasuredHeight() + i13);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i20 + this.f15333g);
        TextView textView32 = this.f15330d;
        textView32.layout(max32, i15, max32 + measuredWidth3, textView32.getMeasuredHeight() + i15);
        this.f15332f = f11;
        this.f15336j = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f15333g;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.f15337k);
        viewPager.addOnAdapterChangeListener(this.f15337k);
        this.f15327a = viewPager;
        WeakReference weakReference = this.f15338l;
        a(weakReference != null ? (PagerAdapter) weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f15327a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            this.f15327a.setInternalPageChangeListener(null);
            this.f15327a.removeOnAdapterChangeListener(this.f15337k);
            this.f15327a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        if (this.f15327a != null) {
            float f11 = this.f15332f;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            c(this.f15331e, f11, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int max;
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i12, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i11);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, (int) (size * 0.2f), -2);
        this.f15328b.measure(childMeasureSpec2, childMeasureSpec);
        this.f15329c.measure(childMeasureSpec2, childMeasureSpec);
        this.f15330d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i12) == 1073741824) {
            max = View.MeasureSpec.getSize(i12);
        } else {
            max = Math.max(getMinHeight(), this.f15329c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i12, this.f15329c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f15335i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i11) {
        this.f15334h = i11;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f11) {
        int i11 = ((int) (f11 * 255.0f)) & 255;
        this.f15339m = i11;
        int i12 = (i11 << 24) | (this.f15340n & 16777215);
        this.f15328b.setTextColor(i12);
        this.f15330d.setTextColor(i12);
    }

    public void setTextColor(int i11) {
        this.f15340n = i11;
        this.f15329c.setTextColor(i11);
        int i12 = (this.f15339m << 24) | (this.f15340n & 16777215);
        this.f15328b.setTextColor(i12);
        this.f15330d.setTextColor(i12);
    }

    public void setTextSize(int i11, float f11) {
        this.f15328b.setTextSize(i11, f11);
        this.f15329c.setTextSize(i11, f11);
        this.f15330d.setTextSize(i11, f11);
    }

    public void setTextSpacing(int i11) {
        this.f15333g = i11;
        requestLayout();
    }
}
