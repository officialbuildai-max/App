package com.transsion.photoview;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.transsion.gslb.Utils;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final int f47959a;

    /* renamed from: b, reason: collision with root package name */
    private float f47960b;

    /* renamed from: c, reason: collision with root package name */
    private final int f47961c;

    /* renamed from: d, reason: collision with root package name */
    private float f47962d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference f47963e;

    /* renamed from: f, reason: collision with root package name */
    private i f47964f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f47965g;

    /* renamed from: h, reason: collision with root package name */
    private int f47966h;

    public n(final ImageView imageView) {
        this.f47963e = new WeakReference(imageView);
        int c11 = o.c(imageView.getContext());
        this.f47961c = c11;
        this.f47959a = (int) (c11 * 0.15d);
        imageView.post(new Runnable() { // from class: com.transsion.photoview.m
            @Override // java.lang.Runnable
            public final void run() {
                n.this.j(imageView);
            }
        });
    }

    private void c(float f11, float f12) {
        ImageView imageView = (ImageView) this.f47963e.get();
        if (imageView == null) {
            return;
        }
        if (Math.abs(f12) < this.f47961c / 4.0f) {
            float abs = 1.0f - (Math.abs(f12) / this.f47961c);
            this.f47962d = 1.0f - (Math.abs(f12) / (this.f47961c / 3.0f));
            imageView.setScaleX(abs);
            imageView.setScaleY(abs);
            ((ViewGroup) imageView.getParent()).setBackgroundColor(f(this.f47962d));
        }
        imageView.setTranslationY(f12);
    }

    private int f(float f11) {
        int min = (int) (Math.min(1.0f, Math.max(0.0f, f11)) * 255.0f);
        if (min <= 102) {
            return this.f47966h;
        }
        String lowerCase = Integer.toHexString(min).toLowerCase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Utils.SEPARATOR);
        sb2.append(lowerCase.length() < 2 ? "0" : "");
        sb2.append(lowerCase);
        sb2.append("000000");
        int parseColor = Color.parseColor(sb2.toString());
        this.f47966h = parseColor;
        return parseColor;
    }

    private void g() {
        ImageView imageView = (ImageView) this.f47963e.get();
        if (imageView == null) {
            return;
        }
        i iVar = this.f47964f;
        if (iVar != null) {
            iVar.a();
        }
        try {
            ((Activity) imageView.getContext()).finish();
            ((Activity) imageView.getContext()).overridePendingTransition(0, 0);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ImageView imageView, ValueAnimator valueAnimator) {
        if (this.f47962d < valueAnimator.getAnimatedFraction()) {
            ((ViewGroup) imageView.getParent()).setBackgroundColor(f(valueAnimator.getAnimatedFraction()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ImageView imageView) {
        ((ViewGroup) imageView.getParent()).setBackgroundColor(f(this.f47962d));
    }

    public void d() {
        final ImageView imageView = (ImageView) this.f47963e.get();
        if (imageView != null && this.f47965g) {
            this.f47965g = false;
            if (Math.abs(this.f47960b) <= this.f47959a) {
                imageView.animate().setDuration(200L).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.transsion.photoview.l
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        n.this.i(imageView, valueAnimator);
                    }
                }).start();
            } else {
                this.f47960b = 0.0f;
                g();
            }
        }
    }

    public void e(float f11, float f12, float f13) {
        if (Math.abs(f11 - 1.0f) != 0.0f) {
            return;
        }
        this.f47960b = f13;
        if (Math.abs(f13) > 50.0f) {
            this.f47965g = true;
            c(f12, this.f47960b);
        }
    }

    public boolean h() {
        return this.f47965g;
    }

    public void k(i iVar) {
        this.f47964f = iVar;
    }
}
