package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a, reason: collision with root package name */
    long f8552a;

    /* renamed from: b, reason: collision with root package name */
    boolean f8553b;

    /* renamed from: c, reason: collision with root package name */
    boolean f8554c;

    /* renamed from: d, reason: collision with root package name */
    boolean f8555d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f8556e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f8557f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f8552a = -1L;
        this.f8553b = false;
        this.f8554c = false;
        this.f8555d = false;
        this.f8556e = new Runnable() { // from class: androidx.core.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.f();
            }
        };
        this.f8557f = new Runnable() { // from class: androidx.core.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.g();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f8555d = true;
        removeCallbacks(this.f8557f);
        this.f8554c = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f8552a;
        long j12 = currentTimeMillis - j11;
        if (j12 >= 500 || j11 == -1) {
            setVisibility(8);
        } else {
            if (this.f8553b) {
                return;
            }
            postDelayed(this.f8556e, 500 - j12);
            this.f8553b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f8553b = false;
        this.f8552a = -1L;
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f8554c = false;
        if (this.f8555d) {
            return;
        }
        this.f8552a = System.currentTimeMillis();
        setVisibility(0);
    }

    private void h() {
        removeCallbacks(this.f8556e);
        removeCallbacks(this.f8557f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f8552a = -1L;
        this.f8555d = false;
        removeCallbacks(this.f8556e);
        this.f8553b = false;
        if (this.f8554c) {
            return;
        }
        postDelayed(this.f8557f, 500L);
        this.f8554c = true;
    }

    public void hide() {
        post(new Runnable() { // from class: androidx.core.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.e();
            }
        });
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void show() {
        post(new Runnable() { // from class: androidx.core.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.i();
            }
        });
    }
}
