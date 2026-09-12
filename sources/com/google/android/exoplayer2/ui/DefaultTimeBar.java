package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.n0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class DefaultTimeBar extends View implements n0 {
    public static final int BAR_GRAVITY_BOTTOM = 1;
    public static final int BAR_GRAVITY_CENTER = 0;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;
    private int A;
    private long B;
    private int C;
    private Rect D;
    private ValueAnimator E;
    private float F;
    private boolean G;
    private boolean H;
    private long I;
    private long J;
    private long K;
    private long L;
    private int M;
    private long[] N;
    private boolean[] O;

    /* renamed from: a, reason: collision with root package name */
    private final Rect f26941a;

    /* renamed from: b, reason: collision with root package name */
    private final Rect f26942b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f26943c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f26944d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f26945e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f26946f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f26947g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f26948h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f26949i;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f26950j;

    /* renamed from: k, reason: collision with root package name */
    private final Drawable f26951k;

    /* renamed from: l, reason: collision with root package name */
    private final int f26952l;

    /* renamed from: m, reason: collision with root package name */
    private final int f26953m;

    /* renamed from: n, reason: collision with root package name */
    private final int f26954n;

    /* renamed from: o, reason: collision with root package name */
    private final int f26955o;

    /* renamed from: p, reason: collision with root package name */
    private final int f26956p;

    /* renamed from: q, reason: collision with root package name */
    private final int f26957q;

    /* renamed from: r, reason: collision with root package name */
    private final int f26958r;

    /* renamed from: s, reason: collision with root package name */
    private final int f26959s;

    /* renamed from: t, reason: collision with root package name */
    private final int f26960t;

    /* renamed from: u, reason: collision with root package name */
    private final StringBuilder f26961u;

    /* renamed from: v, reason: collision with root package name */
    private final Formatter f26962v;

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f26963w;

    /* renamed from: x, reason: collision with root package name */
    private final CopyOnWriteArraySet f26964x;

    /* renamed from: y, reason: collision with root package name */
    private final Point f26965y;

    /* renamed from: z, reason: collision with root package name */
    private final float f26966z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i11, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i11, @Nullable AttributeSet attributeSet2, int i12) {
        super(context, attributeSet, i11);
        this.f26941a = new Rect();
        this.f26942b = new Rect();
        this.f26943c = new Rect();
        this.f26944d = new Rect();
        Paint paint = new Paint();
        this.f26945e = paint;
        Paint paint2 = new Paint();
        this.f26946f = paint2;
        Paint paint3 = new Paint();
        this.f26947g = paint3;
        Paint paint4 = new Paint();
        this.f26948h = paint4;
        Paint paint5 = new Paint();
        this.f26949i = paint5;
        Paint paint6 = new Paint();
        this.f26950j = paint6;
        paint6.setAntiAlias(true);
        this.f26964x = new CopyOnWriteArraySet();
        this.f26965y = new Point();
        float f11 = context.getResources().getDisplayMetrics().density;
        this.f26966z = f11;
        this.f26960t = c(f11, -50);
        int c11 = c(f11, 4);
        int c12 = c(f11, 26);
        int c13 = c(f11, 4);
        int c14 = c(f11, 12);
        int c15 = c(f11, 0);
        int c16 = c(f11, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$styleable.DefaultTimeBar, i11, i12);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.f26951k = drawable;
                if (drawable != null) {
                    m(drawable);
                    c12 = Math.max(drawable.getMinimumHeight(), c12);
                }
                this.f26952l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, c11);
                this.f26953m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, c12);
                this.f26954n = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_bar_gravity, 0);
                this.f26955o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, c13);
                this.f26956p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, c14);
                this.f26957q = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, c15);
                this.f26958r = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, c16);
                int i13 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i14 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, -1);
                int i15 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, -855638017);
                int i16 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i17 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i18 = obtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i13);
                paint6.setColor(i14);
                paint2.setColor(i15);
                paint3.setColor(i16);
                paint4.setColor(i17);
                paint5.setColor(i18);
                obtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                obtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            this.f26952l = c11;
            this.f26953m = c12;
            this.f26954n = 0;
            this.f26955o = c13;
            this.f26956p = c14;
            this.f26957q = c15;
            this.f26958r = c16;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f26951k = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f26961u = sb2;
        this.f26962v = new Formatter(sb2, Locale.getDefault());
        this.f26963w = new Runnable() { // from class: com.google.android.exoplayer2.ui.e
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeBar.this.g();
            }
        };
        Drawable drawable2 = this.f26951k;
        if (drawable2 != null) {
            this.f26959s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f26959s = (Math.max(this.f26957q, Math.max(this.f26956p, this.f26958r)) + 1) / 2;
        }
        this.F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.E = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar.this.h(valueAnimator2);
            }
        });
        this.J = C.TIME_UNSET;
        this.B = C.TIME_UNSET;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private static int c(float f11, int i11) {
        return (int) ((i11 * f11) + 0.5f);
    }

    private void d(Canvas canvas) {
        if (this.J <= 0) {
            return;
        }
        Rect rect = this.f26944d;
        int q11 = com.google.android.exoplayer2.util.p0.q(rect.right, rect.left, this.f26942b.right);
        int centerY = this.f26944d.centerY();
        if (this.f26951k == null) {
            canvas.drawCircle(q11, centerY, (int) ((((this.H || isFocused()) ? this.f26958r : isEnabled() ? this.f26956p : this.f26957q) * this.F) / 2.0f), this.f26950j);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.F)) / 2;
        int intrinsicHeight = ((int) (this.f26951k.getIntrinsicHeight() * this.F)) / 2;
        this.f26951k.setBounds(q11 - intrinsicWidth, centerY - intrinsicHeight, q11 + intrinsicWidth, centerY + intrinsicHeight);
        this.f26951k.draw(canvas);
    }

    private void e(Canvas canvas) {
        int height = this.f26942b.height();
        int centerY = this.f26942b.centerY() - (height / 2);
        int i11 = height + centerY;
        if (this.J <= 0) {
            Rect rect = this.f26942b;
            canvas.drawRect(rect.left, centerY, rect.right, i11, this.f26947g);
            return;
        }
        Rect rect2 = this.f26943c;
        int i12 = rect2.left;
        int i13 = rect2.right;
        int max = Math.max(Math.max(this.f26942b.left, i13), this.f26944d.right);
        int i14 = this.f26942b.right;
        if (max < i14) {
            canvas.drawRect(max, centerY, i14, i11, this.f26947g);
        }
        int max2 = Math.max(i12, this.f26944d.right);
        if (i13 > max2) {
            canvas.drawRect(max2, centerY, i13, i11, this.f26946f);
        }
        if (this.f26944d.width() > 0) {
            Rect rect3 = this.f26944d;
            canvas.drawRect(rect3.left, centerY, rect3.right, i11, this.f26945e);
        }
        if (this.M == 0) {
            return;
        }
        long[] jArr = (long[]) com.google.android.exoplayer2.util.a.e(this.N);
        boolean[] zArr = (boolean[]) com.google.android.exoplayer2.util.a.e(this.O);
        int i15 = this.f26955o / 2;
        for (int i16 = 0; i16 < this.M; i16++) {
            int width = ((int) ((this.f26942b.width() * com.google.android.exoplayer2.util.p0.r(jArr[i16], 0L, this.J)) / this.J)) - i15;
            Rect rect4 = this.f26942b;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.f26955o, Math.max(0, width)), centerY, r10 + this.f26955o, i11, zArr[i16] ? this.f26949i : this.f26948h);
        }
    }

    private boolean f(float f11, float f12) {
        return this.f26941a.contains((int) f11, (int) f12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        q(false);
    }

    private long getPositionIncrement() {
        long j11 = this.B;
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        long j12 = this.J;
        if (j12 == C.TIME_UNSET) {
            return 0L;
        }
        return j12 / this.A;
    }

    private String getProgressText() {
        return com.google.android.exoplayer2.util.p0.h0(this.f26961u, this.f26962v, this.K);
    }

    private long getScrubberPosition() {
        if (this.f26942b.width() <= 0 || this.J == C.TIME_UNSET) {
            return 0L;
        }
        return (this.f26944d.width() * this.J) / this.f26942b.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        this.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f26941a);
    }

    private void i(float f11) {
        Rect rect = this.f26944d;
        Rect rect2 = this.f26942b;
        rect.right = com.google.android.exoplayer2.util.p0.q((int) f11, rect2.left, rect2.right);
    }

    private static int j(float f11, int i11) {
        return (int) (i11 / f11);
    }

    private Point k(MotionEvent motionEvent) {
        this.f26965y.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f26965y;
    }

    private boolean l(long j11) {
        long j12 = this.J;
        if (j12 <= 0) {
            return false;
        }
        long j13 = this.H ? this.I : this.K;
        long r11 = com.google.android.exoplayer2.util.p0.r(j13 + j11, 0L, j12);
        if (r11 == j13) {
            return false;
        }
        if (this.H) {
            t(r11);
        } else {
            p(r11);
        }
        r();
        return true;
    }

    private boolean m(Drawable drawable) {
        return com.google.android.exoplayer2.util.p0.f27680a >= 23 && n(drawable, getLayoutDirection());
    }

    private static boolean n(Drawable drawable, int i11) {
        return com.google.android.exoplayer2.util.p0.f27680a >= 23 && drawable.setLayoutDirection(i11);
    }

    private void o(int i11, int i12) {
        Rect rect = this.D;
        if (rect != null && rect.width() == i11 && this.D.height() == i12) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i11, i12);
        this.D = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private void p(long j11) {
        this.I = j11;
        this.H = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f26964x.iterator();
        while (it.hasNext()) {
            ((n0.a) it.next()).r(this, j11);
        }
    }

    private void q(boolean z10) {
        removeCallbacks(this.f26963w);
        this.H = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f26964x.iterator();
        while (it.hasNext()) {
            ((n0.a) it.next()).p(this, this.I, z10);
        }
    }

    private void r() {
        this.f26943c.set(this.f26942b);
        this.f26944d.set(this.f26942b);
        long j11 = this.H ? this.I : this.K;
        if (this.J > 0) {
            int width = (int) ((this.f26942b.width() * this.L) / this.J);
            Rect rect = this.f26943c;
            Rect rect2 = this.f26942b;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((this.f26942b.width() * j11) / this.J);
            Rect rect3 = this.f26944d;
            Rect rect4 = this.f26942b;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.f26943c;
            int i11 = this.f26942b.left;
            rect5.right = i11;
            this.f26944d.right = i11;
        }
        invalidate(this.f26941a);
    }

    private void s() {
        Drawable drawable = this.f26951k;
        if (drawable != null && drawable.isStateful() && this.f26951k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void t(long j11) {
        if (this.I == j11) {
            return;
        }
        this.I = j11;
        Iterator it = this.f26964x.iterator();
        while (it.hasNext()) {
            ((n0.a) it.next()).l(this, j11);
        }
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public void addListener(n0.a aVar) {
        com.google.android.exoplayer2.util.a.e(aVar);
        this.f26964x.add(aVar);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        s();
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public long getPreferredUpdateDelay() {
        int j11 = j(this.f26966z, this.f26942b.width());
        if (j11 != 0) {
            long j12 = this.J;
            if (j12 != 0 && j12 != C.TIME_UNSET) {
                return j12 / j11;
            }
        }
        return Long.MAX_VALUE;
    }

    public void hideScrubber(long j11) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.E.setFloatValues(this.F, 0.0f);
        this.E.setDuration(j11);
        this.E.start();
    }

    public void hideScrubber(boolean z10) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = z10;
        this.F = 0.0f;
        invalidate(this.f26941a);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f26951k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        e(canvas);
        d(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i11, Rect rect) {
        super.onFocusChanged(z10, i11, rect);
        if (!this.H || z10) {
            return;
        }
        q(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.J <= 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.p0.f27680a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.l(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.f26963w
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f26963w
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.H
            if (r0 == 0) goto L30
            r5 = 0
            r4.q(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17 = i13 - i11;
        int i18 = i14 - i12;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i17 - getPaddingRight();
        int i19 = this.G ? 0 : this.f26959s;
        if (this.f26954n == 1) {
            i15 = (i18 - getPaddingBottom()) - this.f26953m;
            int paddingBottom = i18 - getPaddingBottom();
            int i20 = this.f26952l;
            i16 = (paddingBottom - i20) - Math.max(i19 - (i20 / 2), 0);
        } else {
            i15 = (i18 - this.f26953m) / 2;
            i16 = (i18 - this.f26952l) / 2;
        }
        this.f26941a.set(paddingLeft, i15, paddingRight, this.f26953m + i15);
        Rect rect = this.f26942b;
        Rect rect2 = this.f26941a;
        rect.set(rect2.left + i19, i16, rect2.right - i19, this.f26952l + i16);
        if (com.google.android.exoplayer2.util.p0.f27680a >= 29) {
            o(i17, i18);
        }
        r();
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (mode == 0) {
            size = this.f26953m;
        } else if (mode != 1073741824) {
            size = Math.min(this.f26953m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i11), size);
        s();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        Drawable drawable = this.f26951k;
        if (drawable == null || !n(drawable, i11)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.J
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.k(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.H
            if (r8 == 0) goto L76
            int r8 = r7.f26960t
            if (r0 >= r8) goto L3a
            int r8 = r7.C
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.i(r8)
            goto L40
        L3a:
            r7.C = r2
            float r8 = (float) r2
            r7.i(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.t(r0)
            r7.r()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.H
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = r4
        L59:
            r7.q(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.f(r8, r0)
            if (r0 == 0) goto L76
            r7.i(r8)
            long r0 = r7.getScrubberPosition()
            r7.p(r0)
            r7.r()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i11, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i11, bundle)) {
            return true;
        }
        if (this.J <= 0) {
            return false;
        }
        if (i11 == 8192) {
            if (l(-getPositionIncrement())) {
                q(false);
            }
        } else {
            if (i11 != 4096) {
                return false;
            }
            if (l(getPositionIncrement())) {
                q(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void removeListener(n0.a aVar) {
        this.f26964x.remove(aVar);
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i11) {
        com.google.android.exoplayer2.util.a.a(i11 == 0 || !(jArr == null || zArr == null));
        this.M = i11;
        this.N = jArr;
        this.O = zArr;
        r();
    }

    public void setAdMarkerColor(int i11) {
        this.f26948h.setColor(i11);
        invalidate(this.f26941a);
    }

    public void setBufferedColor(int i11) {
        this.f26946f.setColor(i11);
        invalidate(this.f26941a);
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public void setBufferedPosition(long j11) {
        if (this.L == j11) {
            return;
        }
        this.L = j11;
        r();
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public void setDuration(long j11) {
        if (this.J == j11) {
            return;
        }
        this.J = j11;
        if (this.H && j11 == C.TIME_UNSET) {
            q(true);
        }
        r();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.n0
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!this.H || z10) {
            return;
        }
        q(true);
    }

    public void setKeyCountIncrement(int i11) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        this.A = i11;
        this.B = C.TIME_UNSET;
    }

    public void setKeyTimeIncrement(long j11) {
        com.google.android.exoplayer2.util.a.a(j11 > 0);
        this.A = -1;
        this.B = j11;
    }

    public void setPlayedAdMarkerColor(int i11) {
        this.f26949i.setColor(i11);
        invalidate(this.f26941a);
    }

    public void setPlayedColor(int i11) {
        this.f26945e.setColor(i11);
        invalidate(this.f26941a);
    }

    @Override // com.google.android.exoplayer2.ui.n0
    public void setPosition(long j11) {
        if (this.K == j11) {
            return;
        }
        this.K = j11;
        setContentDescription(getProgressText());
        r();
    }

    public void setScrubberColor(int i11) {
        this.f26950j.setColor(i11);
        invalidate(this.f26941a);
    }

    public void setUnplayedColor(int i11) {
        this.f26947g.setColor(i11);
        invalidate(this.f26941a);
    }

    public void showScrubber() {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = false;
        this.F = 1.0f;
        invalidate(this.f26941a);
    }

    public void showScrubber(long j11) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.G = false;
        this.E.setFloatValues(this.F, 1.0f);
        this.E.setDuration(j11);
        this.E.start();
    }
}
