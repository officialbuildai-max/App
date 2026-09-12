package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final Property S = new a(Float.class, "thumbPos");
    private static final int[] T = {R.attr.state_checked};
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private final TextPaint I;
    private ColorStateList J;
    private Layout K;
    private Layout L;
    private TransformationMethod M;
    ObjectAnimator N;
    private final AppCompatTextHelper O;
    private h P;
    private b Q;
    private final Rect R;

    /* renamed from: a, reason: collision with root package name */
    private Drawable f1961a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f1962b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1963c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1964d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1965e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f1966f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f1967g;

    /* renamed from: h, reason: collision with root package name */
    private PorterDuff.Mode f1968h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1969i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1970j;

    /* renamed from: k, reason: collision with root package name */
    private int f1971k;

    /* renamed from: l, reason: collision with root package name */
    private int f1972l;

    /* renamed from: m, reason: collision with root package name */
    private int f1973m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1974n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f1975o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f1976p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f1977q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f1978r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1979s;

    /* renamed from: t, reason: collision with root package name */
    private int f1980t;

    /* renamed from: u, reason: collision with root package name */
    private int f1981u;

    /* renamed from: v, reason: collision with root package name */
    private float f1982v;

    /* renamed from: w, reason: collision with root package name */
    private float f1983w;

    /* renamed from: x, reason: collision with root package name */
    private VelocityTracker f1984x;

    /* renamed from: y, reason: collision with root package name */
    private int f1985y;

    /* renamed from: z, reason: collision with root package name */
    float f1986z;

    /* loaded from: classes.dex */
    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1986z);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f11) {
            switchCompat.setThumbPosition(f11.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends EmojiCompat.f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f1987a;

        b(SwitchCompat switchCompat) {
            this.f1987a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void a(Throwable th2) {
            SwitchCompat switchCompat = (SwitchCompat) this.f1987a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f1987a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(@NonNull Context context) {
        this(context, null);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f1962b = null;
        this.f1963c = null;
        this.f1964d = false;
        this.f1965e = false;
        this.f1967g = null;
        this.f1968h = null;
        this.f1969i = false;
        this.f1970j = false;
        this.f1984x = VelocityTracker.obtain();
        this.H = true;
        this.R = new Rect();
        f0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        j0 v11 = j0.v(context, attributeSet, R$styleable.SwitchCompat, i11, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R$styleable.SwitchCompat, attributeSet, v11.r(), i11, 0);
        Drawable g11 = v11.g(R$styleable.SwitchCompat_android_thumb);
        this.f1961a = g11;
        if (g11 != null) {
            g11.setCallback(this);
        }
        Drawable g12 = v11.g(R$styleable.SwitchCompat_track);
        this.f1966f = g12;
        if (g12 != null) {
            g12.setCallback(this);
        }
        setTextOnInternal(v11.p(R$styleable.SwitchCompat_android_textOn));
        setTextOffInternal(v11.p(R$styleable.SwitchCompat_android_textOff));
        this.f1979s = v11.a(R$styleable.SwitchCompat_showText, true);
        this.f1971k = v11.f(R$styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1972l = v11.f(R$styleable.SwitchCompat_switchMinWidth, 0);
        this.f1973m = v11.f(R$styleable.SwitchCompat_switchPadding, 0);
        this.f1974n = v11.a(R$styleable.SwitchCompat_splitTrack, false);
        ColorStateList c11 = v11.c(R$styleable.SwitchCompat_thumbTint);
        if (c11 != null) {
            this.f1962b = c11;
            this.f1964d = true;
        }
        PorterDuff.Mode e11 = y.e(v11.k(R$styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f1963c != e11) {
            this.f1963c = e11;
            this.f1965e = true;
        }
        if (this.f1964d || this.f1965e) {
            b();
        }
        ColorStateList c12 = v11.c(R$styleable.SwitchCompat_trackTint);
        if (c12 != null) {
            this.f1967g = c12;
            this.f1969i = true;
        }
        PorterDuff.Mode e12 = y.e(v11.k(R$styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f1968h != e12) {
            this.f1968h = e12;
            this.f1970j = true;
        }
        if (this.f1969i || this.f1970j) {
            c();
        }
        int n11 = v11.n(R$styleable.SwitchCompat_switchTextAppearance, 0);
        if (n11 != 0) {
            setSwitchTextAppearance(context, n11);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.O = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i11);
        v11.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1981u = viewConfiguration.getScaledTouchSlop();
        this.f1985y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i11);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void a(boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) S, z10 ? 1.0f : 0.0f);
        this.N = ofFloat;
        ofFloat.setDuration(250L);
        this.N.setAutoCancel(true);
        this.N.start();
    }

    private void b() {
        Drawable drawable = this.f1961a;
        if (drawable != null) {
            if (this.f1964d || this.f1965e) {
                Drawable mutate = a1.a.r(drawable).mutate();
                this.f1961a = mutate;
                if (this.f1964d) {
                    a1.a.o(mutate, this.f1962b);
                }
                if (this.f1965e) {
                    a1.a.p(this.f1961a, this.f1963c);
                }
                if (this.f1961a.isStateful()) {
                    this.f1961a.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f1966f;
        if (drawable != null) {
            if (this.f1969i || this.f1970j) {
                Drawable mutate = a1.a.r(drawable).mutate();
                this.f1966f = mutate;
                if (this.f1969i) {
                    a1.a.o(mutate, this.f1967g);
                }
                if (this.f1970j) {
                    a1.a.p(this.f1966f, this.f1968h);
                }
                if (this.f1966f.isStateful()) {
                    this.f1966f.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f11, float f12, float f13) {
        return f11 < f12 ? f12 : f11 > f13 ? f13 : f11;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod f11 = getEmojiTextViewHelper().f(this.M);
        return f11 != null ? f11.getTransformation(charSequence, this) : charSequence;
    }

    @NonNull
    private h getEmojiTextViewHelper() {
        if (this.P == null) {
            this.P = new h(this);
        }
        return this.P;
    }

    private boolean getTargetCheckedState() {
        return this.f1986z > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((u0.b(this) ? 1.0f - this.f1986z : this.f1986z) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1966f;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.R;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1961a;
        Rect d11 = drawable2 != null ? y.d(drawable2) : y.f2201c;
        return ((((this.A - this.C) - rect.left) - rect.right) - d11.left) - d11.right;
    }

    private boolean h(float f11, float f12) {
        if (this.f1961a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1961a.getPadding(this.R);
        int i11 = this.E;
        int i12 = this.f1981u;
        int i13 = i11 - i12;
        int i14 = (this.D + thumbOffset) - i12;
        int i15 = this.C + i14;
        Rect rect = this.R;
        return f11 > ((float) i14) && f11 < ((float) (((i15 + rect.left) + rect.right) + i12)) && f12 > ((float) i13) && f12 < ((float) (this.G + i12));
    }

    private Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.I, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1977q;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_off);
            }
            ViewCompat.setStateDescription(this, charSequence);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1975o;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.abc_capital_on);
            }
            ViewCompat.setStateDescription(this, charSequence);
        }
    }

    private void m(int i11, int i12) {
        setSwitchTypeface(i11 != 1 ? i11 != 2 ? i11 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i12);
    }

    private void n() {
        if (this.Q == null && this.P.b() && EmojiCompat.i()) {
            EmojiCompat c11 = EmojiCompat.c();
            int e11 = c11.e();
            if (e11 == 3 || e11 == 0) {
                b bVar = new b(this);
                this.Q = bVar;
                c11.t(bVar);
            }
        }
    }

    private void o(MotionEvent motionEvent) {
        this.f1980t = 0;
        boolean z10 = true;
        boolean z11 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z11) {
            this.f1984x.computeCurrentVelocity(1000);
            float xVelocity = this.f1984x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f1985y) {
                z10 = getTargetCheckedState();
            } else if (!u0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z10 = false;
            }
        } else {
            z10 = isChecked;
        }
        if (z10 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z10);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1977q = charSequence;
        this.f1978r = g(charSequence);
        this.L = null;
        if (this.f1979s) {
            n();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1975o = charSequence;
        this.f1976p = g(charSequence);
        this.K = null;
        if (this.f1979s) {
            n();
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i11;
        int i12;
        Rect rect = this.R;
        int i13 = this.D;
        int i14 = this.E;
        int i15 = this.F;
        int i16 = this.G;
        int thumbOffset = getThumbOffset() + i13;
        Drawable drawable = this.f1961a;
        Rect d11 = drawable != null ? y.d(drawable) : y.f2201c;
        Drawable drawable2 = this.f1966f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i17 = rect.left;
            thumbOffset += i17;
            if (d11 != null) {
                int i18 = d11.left;
                if (i18 > i17) {
                    i13 += i18 - i17;
                }
                int i19 = d11.top;
                int i20 = rect.top;
                i11 = i19 > i20 ? (i19 - i20) + i14 : i14;
                int i21 = d11.right;
                int i22 = rect.right;
                if (i21 > i22) {
                    i15 -= i21 - i22;
                }
                int i23 = d11.bottom;
                int i24 = rect.bottom;
                if (i23 > i24) {
                    i12 = i16 - (i23 - i24);
                    this.f1966f.setBounds(i13, i11, i15, i12);
                }
            } else {
                i11 = i14;
            }
            i12 = i16;
            this.f1966f.setBounds(i13, i11, i15, i12);
        }
        Drawable drawable3 = this.f1961a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i25 = thumbOffset - rect.left;
            int i26 = thumbOffset + this.C + rect.right;
            this.f1961a.setBounds(i25, i14, i26, i16);
            Drawable background = getBackground();
            if (background != null) {
                a1.a.l(background, i25, i14, i26, i16);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f11, float f12) {
        super.drawableHotspotChanged(f11, f12);
        Drawable drawable = this.f1961a;
        if (drawable != null) {
            a1.a.k(drawable, f11, f12);
        }
        Drawable drawable2 = this.f1966f;
        if (drawable2 != null) {
            a1.a.k(drawable2, f11, f12);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1961a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f1966f;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!u0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1973m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (u0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1973m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    @Nullable
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.m.s(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1979s;
    }

    public boolean getSplitTrack() {
        return this.f1974n;
    }

    public int getSwitchMinWidth() {
        return this.f1972l;
    }

    public int getSwitchPadding() {
        return this.f1973m;
    }

    public CharSequence getTextOff() {
        return this.f1977q;
    }

    public CharSequence getTextOn() {
        return this.f1975o;
    }

    public Drawable getThumbDrawable() {
        return this.f1961a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getThumbPosition() {
        return this.f1986z;
    }

    public int getThumbTextPadding() {
        return this.f1971k;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f1962b;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1963c;
    }

    public Drawable getTrackDrawable() {
        return this.f1966f;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f1967g;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1968h;
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    void j() {
        setTextOnInternal(this.f1975o);
        setTextOffInternal(this.f1977q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1961a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1966f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.N;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.N.end();
        this.N = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i11) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i11 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, T);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.R;
        Drawable drawable = this.f1966f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i11 = this.E;
        int i12 = this.G;
        int i13 = i11 + rect.top;
        int i14 = i12 - rect.bottom;
        Drawable drawable2 = this.f1961a;
        if (drawable != null) {
            if (!this.f1974n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d11 = y.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d11.left;
                rect.right -= d11.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.K : this.L;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.J;
            if (colorStateList != null) {
                this.I.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.I.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i13 + i14) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f1975o : this.f1977q;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(text);
            sb2.append(' ');
            sb2.append(charSequence);
            accessibilityNodeInfo.setText(sb2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        int i15;
        int width;
        int i16;
        int i17;
        int i18;
        int i19;
        super.onLayout(z10, i11, i12, i13, i14);
        int i20 = 0;
        if (this.f1961a != null) {
            Rect rect = this.R;
            Drawable drawable = this.f1966f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d11 = y.d(this.f1961a);
            i15 = Math.max(0, d11.left - rect.left);
            i20 = Math.max(0, d11.right - rect.right);
        } else {
            i15 = 0;
        }
        if (u0.b(this)) {
            i16 = getPaddingLeft() + i15;
            width = ((this.A + i16) - i15) - i20;
        } else {
            width = (getWidth() - getPaddingRight()) - i20;
            i16 = (width - this.A) + i15 + i20;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i17 = this.B;
            i18 = paddingTop - (i17 / 2);
        } else {
            if (gravity == 80) {
                i19 = getHeight() - getPaddingBottom();
                i18 = i19 - this.B;
                this.D = i16;
                this.E = i18;
                this.G = i19;
                this.F = width;
            }
            i18 = getPaddingTop();
            i17 = this.B;
        }
        i19 = i17 + i18;
        this.D = i16;
        this.E = i18;
        this.G = i19;
        this.F = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        if (this.f1979s) {
            if (this.K == null) {
                this.K = i(this.f1976p);
            }
            if (this.L == null) {
                this.L = i(this.f1978r);
            }
        }
        Rect rect = this.R;
        Drawable drawable = this.f1961a;
        int i15 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i13 = (this.f1961a.getIntrinsicWidth() - rect.left) - rect.right;
            i14 = this.f1961a.getIntrinsicHeight();
        } else {
            i13 = 0;
            i14 = 0;
        }
        this.C = Math.max(this.f1979s ? Math.max(this.K.getWidth(), this.L.getWidth()) + (this.f1971k * 2) : 0, i13);
        Drawable drawable2 = this.f1966f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i15 = this.f1966f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i16 = rect.left;
        int i17 = rect.right;
        Drawable drawable3 = this.f1961a;
        if (drawable3 != null) {
            Rect d11 = y.d(drawable3);
            i16 = Math.max(i16, d11.left);
            i17 = Math.max(i17, d11.right);
        }
        int max = this.H ? Math.max(this.f1972l, (this.C * 2) + i16 + i17) : this.f1972l;
        int max2 = Math.max(i15, i14);
        this.A = max;
        this.B = max2;
        super.onMeasure(i11, i12);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1975o : this.f1977q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L44;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f1984x
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f1980t
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f1982v
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = androidx.appcompat.widget.u0.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f1986z
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f1986z
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f1982v = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f1982v
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1981u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f1983w
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1981u
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f1980t = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f1982v = r0
            r6.f1983w = r3
            return r1
        L89:
            int r0 = r6.f1980t
            if (r0 != r2) goto L94
            r6.o(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f1980t = r0
            android.view.VelocityTracker r0 = r6.f1984x
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f1980t = r1
            r6.f1982v = r0
            r6.f1983w = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(isChecked);
        } else {
            d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(@Nullable ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.t(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
        setTextOnInternal(this.f1975o);
        setTextOffInternal(this.f1977q);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setEnforceSwitchWidth(boolean z10) {
        this.H = z10;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f1979s != z10) {
            this.f1979s = z10;
            requestLayout();
            if (z10) {
                n();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f1974n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i11) {
        this.f1972l = i11;
        requestLayout();
    }

    public void setSwitchPadding(int i11) {
        this.f1973m = i11;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i11) {
        j0 t11 = j0.t(context, i11, R$styleable.TextAppearance);
        ColorStateList c11 = t11.c(R$styleable.TextAppearance_android_textColor);
        if (c11 != null) {
            this.J = c11;
        } else {
            this.J = getTextColors();
        }
        int f11 = t11.f(R$styleable.TextAppearance_android_textSize, 0);
        if (f11 != 0) {
            float f12 = f11;
            if (f12 != this.I.getTextSize()) {
                this.I.setTextSize(f12);
                requestLayout();
            }
        }
        m(t11.k(R$styleable.TextAppearance_android_typeface, -1), t11.k(R$styleable.TextAppearance_android_textStyle, -1));
        if (t11.a(R$styleable.TextAppearance_textAllCaps, false)) {
            this.M = new i.a(getContext());
        } else {
            this.M = null;
        }
        setTextOnInternal(this.f1975o);
        setTextOffInternal(this.f1977q);
        t11.x();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.I.getTypeface() == null || this.I.getTypeface().equals(typeface)) && (this.I.getTypeface() != null || typeface == null)) {
            return;
        }
        this.I.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setSwitchTypeface(Typeface typeface, int i11) {
        if (i11 <= 0) {
            this.I.setFakeBoldText(false);
            this.I.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i11) : Typeface.create(typeface, i11);
            setSwitchTypeface(defaultFromStyle);
            int i12 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i11;
            this.I.setFakeBoldText((i12 & 1) != 0);
            this.I.setTextSkewX((i12 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1961a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1961a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f11) {
        this.f1986z = f11;
        invalidate();
    }

    public void setThumbResource(int i11) {
        setThumbDrawable(g.a.b(getContext(), i11));
    }

    public void setThumbTextPadding(int i11) {
        this.f1971k = i11;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f1962b = colorStateList;
        this.f1964d = true;
        b();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1963c = mode;
        this.f1965e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1966f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1966f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i11) {
        setTrackDrawable(g.a.b(getContext(), i11));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f1967g = colorStateList;
        this.f1969i = true;
        c();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1968h = mode;
        this.f1970j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1961a || drawable == this.f1966f;
    }
}
