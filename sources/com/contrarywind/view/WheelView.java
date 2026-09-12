package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.timer.InertiaTimerTask;
import com.contrarywind.timer.SmoothScrollTimerTask;
import com.google.android.material.timepicker.TimeModel;
import com.tn.lib.view.FlowLayout;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import m7.a;
import n7.b;

/* loaded from: classes3.dex */
public class WheelView extends View {
    private float A;
    private float B;
    private float C;
    private float D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private float N;
    private long O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private float T;
    private final float U;
    private final List V;

    /* renamed from: a, reason: collision with root package name */
    private DividerType f24042a;

    /* renamed from: b, reason: collision with root package name */
    private Context f24043b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f24044c;

    /* renamed from: d, reason: collision with root package name */
    private GestureDetector f24045d;

    /* renamed from: e, reason: collision with root package name */
    private b f24046e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f24047f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f24048g;

    /* renamed from: h, reason: collision with root package name */
    private ScheduledExecutorService f24049h;

    /* renamed from: i, reason: collision with root package name */
    private ScheduledFuture f24050i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f24051j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f24052k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f24053l;

    /* renamed from: m, reason: collision with root package name */
    private a f24054m;

    /* renamed from: n, reason: collision with root package name */
    private String f24055n;

    /* renamed from: o, reason: collision with root package name */
    private Boolean f24056o;

    /* renamed from: p, reason: collision with root package name */
    private int f24057p;

    /* renamed from: q, reason: collision with root package name */
    private int f24058q;

    /* renamed from: r, reason: collision with root package name */
    private int f24059r;

    /* renamed from: s, reason: collision with root package name */
    private int f24060s;

    /* renamed from: t, reason: collision with root package name */
    private float f24061t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f24062u;

    /* renamed from: v, reason: collision with root package name */
    private int f24063v;

    /* renamed from: w, reason: collision with root package name */
    private int f24064w;

    /* renamed from: x, reason: collision with root package name */
    private int f24065x;

    /* renamed from: y, reason: collision with root package name */
    private float f24066y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f24067z;

    /* loaded from: classes3.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes3.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24047f = false;
        this.f24048g = true;
        this.f24049h = Executors.newSingleThreadScheduledExecutor();
        this.f24056o = Boolean.FALSE;
        this.f24062u = Typeface.MONOSPACE;
        this.f24066y = 4.0f;
        this.I = 5;
        this.M = 0;
        this.N = 0.0f;
        this.O = 0L;
        this.Q = 17;
        this.R = 0;
        this.S = 0;
        this.U = 0.5f;
        this.V = Arrays.asList(new DateFormatSymbols(Locale.getDefault()).getShortMonths());
        this.f24057p = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f11 = getResources().getDisplayMetrics().density;
        if (f11 < 1.0f) {
            this.T = 2.4f;
        } else if (1.0f <= f11 && f11 < 2.0f) {
            this.T = 3.6f;
        } else if (1.0f <= f11 && f11 < 2.0f) {
            this.T = 4.5f;
        } else if (2.0f <= f11 && f11 < 3.0f) {
            this.T = 6.0f;
        } else if (f11 >= 3.0f) {
            this.T = f11 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.Q = obtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.f24063v = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, FlowLayout.SPACING_AUTO);
            this.f24064w = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -16711936);
            this.f24065x = obtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, 855638016);
            this.f24057p = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.f24057p);
            this.f24066y = obtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.f24066y);
            obtainStyledAttributes.recycle();
        }
        h();
        f(context);
    }

    private String b(int i11) {
        try {
            return (String) this.V.get(i11 - 1);
        } catch (Exception unused) {
            return String.valueOf(i11);
        }
    }

    private String c(Object obj) {
        return obj == null ? "" : obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, (Integer) obj) : obj.toString();
    }

    private int d(int i11) {
        return i11 < 0 ? d(i11 + this.f24054m.a()) : i11 > this.f24054m.a() + (-1) ? d(i11 - this.f24054m.a()) : i11;
    }

    private String e(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt > 12 ? str : b(parseInt);
        } catch (Exception unused) {
            return str;
        }
    }

    private void f(Context context) {
        this.f24043b = context;
        this.f24044c = new o7.a(this);
        GestureDetector gestureDetector = new GestureDetector(context, new n7.a(this));
        this.f24045d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f24067z = true;
        this.D = 0.0f;
        this.E = -1;
        g();
    }

    private void g() {
        Paint paint = new Paint();
        this.f24051j = paint;
        paint.setColor(this.f24063v);
        this.f24051j.setAntiAlias(true);
        this.f24051j.setTypeface(this.f24062u);
        this.f24051j.setTextSize(this.f24057p);
        Paint paint2 = new Paint();
        this.f24052k = paint2;
        paint2.setColor(this.f24064w);
        this.f24052k.setAntiAlias(true);
        this.f24052k.setTextScaleX(1.1f);
        this.f24052k.setTypeface(this.f24062u);
        this.f24052k.setTextSize(this.f24057p);
        Paint paint3 = new Paint();
        this.f24053l = paint3;
        paint3.setColor(this.f24065x);
        this.f24053l.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void h() {
        float f11 = this.f24066y;
        if (f11 < 1.0f) {
            this.f24066y = 1.0f;
        } else if (f11 > 4.0f) {
            this.f24066y = 4.0f;
        }
    }

    private void i() {
        Rect rect = new Rect();
        for (int i11 = 0; i11 < this.f24054m.a(); i11++) {
            String c11 = c(this.f24054m.getItem(i11));
            this.f24052k.getTextBounds(c11, 0, c11.length(), rect);
            int width = rect.width();
            if (width > this.f24058q) {
                this.f24058q = width;
            }
            this.f24052k.getTextBounds("星期", 0, 2, rect);
            this.f24059r = rect.height() + 2;
        }
        this.f24061t = this.f24059r * 3;
    }

    private void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.f24052k.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.Q;
        if (i11 == 3) {
            this.R = 0;
            return;
        }
        if (i11 == 5) {
            this.R = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i11 != 17) {
            return;
        }
        if (this.f24047f || (str2 = this.f24055n) == null || str2.equals("") || !this.f24048g) {
            this.R = (int) ((this.K - rect.width()) * 0.5d);
        } else {
            this.R = (int) ((this.K - rect.width()) * 0.25d);
        }
    }

    private void k(String str) {
        String str2;
        Rect rect = new Rect();
        this.f24051j.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.Q;
        if (i11 == 3) {
            this.S = 0;
            return;
        }
        if (i11 == 5) {
            this.S = (this.K - rect.width()) - ((int) this.T);
            return;
        }
        if (i11 != 17) {
            return;
        }
        if (this.f24047f || (str2 = this.f24055n) == null || str2.equals("") || !this.f24048g) {
            this.S = (int) ((this.K - rect.width()) * 0.5d);
        } else {
            this.S = (int) ((this.K - rect.width()) * 0.25d);
        }
    }

    private void l(String str) {
        Rect rect = new Rect();
        this.f24052k.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.f24057p;
        for (int width = rect.width(); width > this.K; width = rect.width()) {
            i11--;
            this.f24052k.setTextSize(i11);
            this.f24052k.getTextBounds(str, 0, str.length(), rect);
        }
        this.f24051j.setTextSize(i11);
    }

    private void m() {
        if (this.f24054m == null) {
            return;
        }
        i();
        int i11 = (int) (this.f24061t * (this.I - 1));
        this.J = (int) ((i11 * 2) / 3.141592653589793d);
        this.L = (int) (i11 / 3.141592653589793d);
        this.K = View.MeasureSpec.getSize(this.P);
        int i12 = this.J;
        float f11 = this.f24061t;
        this.A = (i12 - f11) / 2.0f;
        float f12 = (i12 + f11) / 2.0f;
        this.B = f12;
        this.C = (f12 - ((f11 - this.f24059r) / 2.0f)) - this.T;
        if (this.E == -1) {
            if (this.f24067z) {
                this.E = (this.f24054m.a() + 1) / 2;
            } else {
                this.E = 0;
            }
        }
        this.G = this.E;
    }

    public void cancelFuture() {
        ScheduledFuture scheduledFuture = this.f24050i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f24050i.cancel(true);
        this.f24050i = null;
    }

    public final a getAdapter() {
        return this.f24054m;
    }

    public final int getCurrentItem() {
        int i11;
        a aVar = this.f24054m;
        if (aVar == null) {
            return 0;
        }
        return (!this.f24067z || ((i11 = this.F) >= 0 && i11 < aVar.a())) ? Math.max(0, Math.min(this.F, this.f24054m.a() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.F) - this.f24054m.a()), this.f24054m.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f24044c;
    }

    public int getInitPosition() {
        return this.E;
    }

    public float getItemHeight() {
        return this.f24061t;
    }

    public int getItemsCount() {
        a aVar = this.f24054m;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i11 += (int) Math.ceil(r2[i12]);
        }
        return i11;
    }

    public float getTotalScrollY() {
        return this.D;
    }

    public void isCenterLabel(boolean z10) {
        this.f24048g = z10;
    }

    public boolean isLoop() {
        return this.f24067z;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0303  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contrarywind.view.WheelView.onDraw(android.graphics.Canvas):void");
    }

    public final void onItemSelected() {
        if (this.f24046e != null) {
            postDelayed(new Runnable() { // from class: com.contrarywind.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.f24046e.a(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        this.P = i11;
        m();
        setMeasuredDimension(this.K, this.J);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f24045d.onTouchEvent(motionEvent);
        float f11 = (-this.E) * this.f24061t;
        float a11 = ((this.f24054m.a() - 1) - this.E) * this.f24061t;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.O = System.currentTimeMillis();
            cancelFuture();
            this.N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.N - motionEvent.getRawY();
            this.N = motionEvent.getRawY();
            float f12 = this.D + rawY;
            this.D = f12;
            if (!this.f24067z) {
                float f13 = this.f24061t;
                if ((f12 - (f13 * 0.25f) < f11 && rawY < 0.0f) || ((f13 * 0.25f) + f12 > a11 && rawY > 0.0f)) {
                    this.D = f12 - rawY;
                    return true;
                }
            }
        } else if (!onTouchEvent) {
            float y10 = motionEvent.getY();
            int i11 = this.L;
            double acos = Math.acos((i11 - y10) / i11) * this.L;
            float f14 = this.f24061t;
            this.M = (int) (((((int) ((acos + (f14 / 2.0f)) / f14)) - (this.I / 2)) * f14) - (((this.D % f14) + f14) % f14));
            if (System.currentTimeMillis() - this.O > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void scrollBy(float f11) {
        cancelFuture();
        this.f24050i = this.f24049h.scheduleWithFixedDelay(new InertiaTimerTask(this, f11), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(a aVar) {
        this.f24054m = aVar;
        m();
        invalidate();
    }

    public void setConvertMonth(boolean z10) {
        this.f24056o = Boolean.valueOf(z10);
    }

    public final void setCurrentItem(int i11) {
        this.F = i11;
        this.E = i11;
        this.D = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z10) {
        this.f24067z = z10;
    }

    public void setDividerColor(int i11) {
        this.f24065x = i11;
        this.f24053l.setColor(i11);
    }

    public void setDividerType(DividerType dividerType) {
        this.f24042a = dividerType;
    }

    public void setGravity(int i11) {
        this.Q = i11;
    }

    public void setIsOptions(boolean z10) {
        this.f24047f = z10;
    }

    public void setLabel(String str) {
        this.f24055n = str;
    }

    public void setLineSpacingMultiplier(float f11) {
        if (f11 != 0.0f) {
            this.f24066y = f11;
            h();
        }
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.f24046e = bVar;
    }

    public void setTextColorCenter(int i11) {
        this.f24064w = i11;
        this.f24052k.setColor(i11);
    }

    public void setTextColorOut(int i11) {
        this.f24063v = i11;
        this.f24051j.setColor(i11);
    }

    public final void setTextSize(float f11) {
        if (f11 > 0.0f) {
            int i11 = (int) (this.f24043b.getResources().getDisplayMetrics().density * f11);
            this.f24057p = i11;
            this.f24051j.setTextSize(i11);
            this.f24052k.setTextSize(this.f24057p);
        }
    }

    public void setTextXOffset(int i11) {
        this.f24060s = i11;
        if (i11 != 0) {
            this.f24052k.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f11) {
        this.D = f11;
    }

    public final void setTypeface(Typeface typeface) {
        this.f24062u = typeface;
        this.f24051j.setTypeface(typeface);
        this.f24052k.setTypeface(this.f24062u);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f11 = this.D;
            float f12 = this.f24061t;
            int i11 = (int) (((f11 % f12) + f12) % f12);
            this.M = i11;
            if (i11 > f12 / 2.0f) {
                this.M = (int) (f12 - i11);
            } else {
                this.M = -i11;
            }
        }
        this.f24050i = this.f24049h.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.M), 0L, 10L, TimeUnit.MILLISECONDS);
    }
}
