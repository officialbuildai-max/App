package com.transsion.baseui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.style.ImageSpan;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.transsion.baseui.widget.c;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends ImageSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f43662a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference f43663b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference f43664c;

    /* renamed from: d, reason: collision with root package name */
    private Animatable f43665d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f43666e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f43667f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f43668g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f43669h;

    /* renamed from: i, reason: collision with root package name */
    private final a f43670i;

    /* renamed from: j, reason: collision with root package name */
    private ViewTreeObserver f43671j;

    /* renamed from: k, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f43672k;

    /* loaded from: classes5.dex */
    public static final class a implements Drawable.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f43674b;

        a(TextView textView) {
            this.f43674b = textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
        
            if (r0 == null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final void b(com.transsion.baseui.widget.c r2, android.widget.TextView r3) {
            /*
                boolean r0 = com.transsion.baseui.widget.c.e(r2)
                r1 = 0
                if (r0 == 0) goto Lb
                com.transsion.baseui.widget.c.f(r2, r1)
                return
            Lb:
                android.graphics.Rect r0 = com.transsion.baseui.widget.c.b(r2)
                if (r0 == 0) goto L1c
                if (r3 == 0) goto L19
                r3.invalidate(r0)
                kotlin.Unit r0 = kotlin.Unit.f67184a
                goto L1a
            L19:
                r0 = r1
            L1a:
                if (r0 != 0) goto L23
            L1c:
                if (r3 == 0) goto L23
                r3.invalidate()
                kotlin.Unit r3 = kotlin.Unit.f67184a
            L23:
                com.transsion.baseui.widget.c.f(r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.baseui.widget.c.a.b(com.transsion.baseui.widget.c, android.widget.TextView):void");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            Intrinsics.h(who, "who");
            if (c.this.f43669h) {
                return;
            }
            Runnable runnable = c.this.f43668g;
            if (runnable != null) {
                c.this.f43667f.removeCallbacks(runnable);
            }
            final c cVar = c.this;
            final TextView textView = this.f43674b;
            cVar.f43668g = new Runnable() { // from class: com.transsion.baseui.widget.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.a.b(c.this, textView);
                }
            };
            Handler handler = c.this.f43667f;
            Runnable runnable2 = c.this.f43668g;
            Intrinsics.e(runnable2);
            handler.postDelayed(runnable2, 16L);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long j11) {
            Intrinsics.h(who, "who");
            Intrinsics.h(what, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Intrinsics.h(who, "who");
            Intrinsics.h(what, "what");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Drawable drawable, final TextView textView, int i11, int i12) {
        super(drawable, i11);
        Intrinsics.h(drawable, "drawable");
        this.f43662a = i12;
        this.f43663b = textView != null ? new WeakReference(textView) : null;
        this.f43664c = new WeakReference(drawable);
        this.f43667f = new Handler(Looper.getMainLooper());
        a aVar = new a(textView);
        this.f43670i = aVar;
        this.f43672k = new ViewTreeObserver.OnPreDrawListener() { // from class: com.transsion.baseui.widget.a
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean i13;
                i13 = c.i(c.this, textView);
                return i13;
            }
        };
        if (drawable instanceof Animatable) {
            this.f43665d = (Animatable) drawable;
            drawable.setCallback(aVar);
            l();
            j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void g(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (!Intrinsics.c(drawable.getCallback(), this.f43670i)) {
                drawable.setCallback(this.f43670i);
            }
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                return;
            }
            animatable.start();
        }
    }

    private final TextView h() {
        WeakReference weakReference = this.f43663b;
        if (weakReference != null) {
            return (TextView) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean i(c cVar, TextView textView) {
        Drawable drawable = (Drawable) cVar.f43664c.get();
        if (!(drawable instanceof Animatable) || ((Animatable) drawable).isRunning() || cVar.f43669h || textView == null || textView.getVisibility() != 0 || !textView.isShown()) {
            return true;
        }
        cVar.g(drawable);
        return true;
    }

    private final void j() {
        ViewTreeObserver viewTreeObserver;
        TextView h11 = h();
        if (h11 == null || (viewTreeObserver = h11.getViewTreeObserver()) == null) {
            return;
        }
        if (!viewTreeObserver.isAlive()) {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null) {
            this.f43671j = viewTreeObserver;
            viewTreeObserver.addOnPreDrawListener(this.f43672k);
        }
    }

    private final void l() {
        TextView h11;
        TextView h12;
        Object obj = (Drawable) this.f43664c.get();
        if ((obj instanceof Animatable) && (h11 = h()) != null && h11.getVisibility() == 0 && (h12 = h()) != null && h12.isShown()) {
            Animatable animatable = (Animatable) obj;
            if (animatable.isRunning()) {
                return;
            }
            animatable.start();
        }
    }

    private final void n() {
        ViewTreeObserver viewTreeObserver = this.f43671j;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(this.f43672k);
            }
        }
        this.f43671j = null;
    }

    private final void o(float f11, int i11, int i12, int i13, Paint paint, Drawable drawable) {
        int i14;
        int verticalAlignment = getVerticalAlignment();
        if (verticalAlignment == 0) {
            i14 = i13 - drawable.getBounds().bottom;
        } else if (verticalAlignment != 1) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i15 = fontMetricsInt.descent;
            i14 = ((i12 + i15) - ((i15 - fontMetricsInt.ascent) / 2)) - (drawable.getBounds().height() / 2);
        } else {
            i14 = (i12 - drawable.getBounds().bottom) + paint.getFontMetricsInt().descent;
        }
        int i16 = (int) f11;
        this.f43666e = new Rect(i16, i14, drawable.getBounds().width() + i16, drawable.getBounds().height() + i14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        int i16;
        TextView h11;
        Intrinsics.h(canvas, "canvas");
        Intrinsics.h(text, "text");
        Intrinsics.h(paint, "paint");
        Drawable drawable = (Drawable) this.f43664c.get();
        if (drawable == 0) {
            return;
        }
        if (this.f43669h) {
            o(f11, i13, i14, i15, paint, drawable);
            return;
        }
        o(f11, i13, i14, i15, paint, drawable);
        if (drawable instanceof Animatable) {
            TextView h12 = h();
            boolean z10 = h12 != null && h12.getVisibility() == 0 && (h11 = h()) != null && h11.isShown();
            if (z10 && !Intrinsics.c(drawable.getCallback(), this.f43670i)) {
                drawable.setCallback(this.f43670i);
            }
            if (z10) {
                Animatable animatable = (Animatable) drawable;
                if (!animatable.isRunning()) {
                    animatable.start();
                }
            }
            if (!z10) {
                Animatable animatable2 = (Animatable) drawable;
                if (animatable2.isRunning()) {
                    animatable2.stop();
                }
            }
        }
        canvas.save();
        int verticalAlignment = getVerticalAlignment();
        if (verticalAlignment == 0) {
            i16 = i15 - drawable.getBounds().bottom;
        } else if (verticalAlignment != 1) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i17 = fontMetricsInt.descent;
            i16 = ((i14 + i17) - ((i17 - fontMetricsInt.ascent) / 2)) - (drawable.getBounds().height() / 2);
        } else {
            i16 = (i14 - drawable.getBounds().bottom) + paint.getFontMetricsInt().descent;
        }
        canvas.translate(f11, i16);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.h(paint, "paint");
        Intrinsics.h(text, "text");
        Drawable drawable = (Drawable) this.f43664c.get();
        if (drawable == null) {
            return 0;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.g(bounds, "getBounds(...)");
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int verticalAlignment = getVerticalAlignment();
            if (verticalAlignment == 0 || verticalAlignment == 1) {
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
            } else {
                int height = bounds.height() / 2;
                int i13 = (fontMetricsInt2.descent - fontMetricsInt2.ascent) / 4;
                int i14 = (-height) - i13;
                fontMetricsInt.ascent = i14;
                fontMetricsInt.top = i14;
                int i15 = height - i13;
                fontMetricsInt.bottom = i15;
                fontMetricsInt.descent = i15;
            }
        }
        return bounds.right + this.f43662a;
    }

    public final void k() {
        this.f43669h = false;
        Drawable drawable = (Drawable) this.f43664c.get();
        if (drawable != null && !Intrinsics.c(drawable.getCallback(), this.f43670i)) {
            drawable.setCallback(this.f43670i);
        }
        l();
        j();
    }

    public final void m() {
        this.f43669h = true;
        Runnable runnable = this.f43668g;
        if (runnable != null) {
            this.f43667f.removeCallbacks(runnable);
            this.f43668g = null;
        }
        n();
        Animatable animatable = this.f43665d;
        if (animatable != null) {
            animatable.stop();
        }
        Drawable drawable = (Drawable) this.f43664c.get();
        if (drawable == null || !Intrinsics.c(drawable.getCallback(), this.f43670i)) {
            return;
        }
        drawable.setCallback(null);
    }
}
