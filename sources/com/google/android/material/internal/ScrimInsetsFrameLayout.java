package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes4.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    Drawable f29166a;

    /* renamed from: b, reason: collision with root package name */
    Rect f29167b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f29168c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f29169d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29170e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f29171f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f29172g;

    /* loaded from: classes4.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f29167b == null) {
                scrimInsetsFrameLayout.f29167b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f29167b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.f29166a == null);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29168c = new Rect();
        this.f29169d = true;
        this.f29170e = true;
        this.f29171f = true;
        this.f29172g = true;
        TypedArray i12 = b0.i(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i11, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f29166a = i12.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        i12.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    protected void a(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f29167b == null || this.f29166a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f29169d) {
            this.f29168c.set(0, 0, width, this.f29167b.top);
            this.f29166a.setBounds(this.f29168c);
            this.f29166a.draw(canvas);
        }
        if (this.f29170e) {
            this.f29168c.set(0, height - this.f29167b.bottom, width, height);
            this.f29166a.setBounds(this.f29168c);
            this.f29166a.draw(canvas);
        }
        if (this.f29171f) {
            Rect rect = this.f29168c;
            Rect rect2 = this.f29167b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f29166a.setBounds(this.f29168c);
            this.f29166a.draw(canvas);
        }
        if (this.f29172g) {
            Rect rect3 = this.f29168c;
            Rect rect4 = this.f29167b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f29166a.setBounds(this.f29168c);
            this.f29166a.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f29166a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f29166a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f29170e = z10;
    }

    public void setDrawLeftInsetForeground(boolean z10) {
        this.f29171f = z10;
    }

    public void setDrawRightInsetForeground(boolean z10) {
        this.f29172g = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f29169d = z10;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f29166a = drawable;
    }
}
