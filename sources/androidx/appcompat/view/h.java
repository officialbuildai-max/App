package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f1392c;

    /* renamed from: d, reason: collision with root package name */
    ViewPropertyAnimatorListener f1393d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1394e;

    /* renamed from: b, reason: collision with root package name */
    private long f1391b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final ViewPropertyAnimatorListenerAdapter f1395f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f1390a = new ArrayList();

    /* loaded from: classes.dex */
    class a extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1396a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f1397b = 0;

        a() {
        }

        void a() {
            this.f1397b = 0;
            this.f1396a = false;
            h.this.b();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i11 = this.f1397b + 1;
            this.f1397b = i11;
            if (i11 == h.this.f1390a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = h.this.f1393d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f1396a) {
                return;
            }
            this.f1396a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = h.this.f1393d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    }

    public void a() {
        if (this.f1394e) {
            Iterator it = this.f1390a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).cancel();
            }
            this.f1394e = false;
        }
    }

    void b() {
        this.f1394e = false;
    }

    public h c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f1394e) {
            this.f1390a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public h d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f1390a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f1390a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public h e(long j11) {
        if (!this.f1394e) {
            this.f1391b = j11;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f1394e) {
            this.f1392c = interpolator;
        }
        return this;
    }

    public h g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f1394e) {
            this.f1393d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (this.f1394e) {
            return;
        }
        Iterator it = this.f1390a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
            long j11 = this.f1391b;
            if (j11 >= 0) {
                viewPropertyAnimatorCompat.setDuration(j11);
            }
            Interpolator interpolator = this.f1392c;
            if (interpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(interpolator);
            }
            if (this.f1393d != null) {
                viewPropertyAnimatorCompat.setListener(this.f1395f);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.f1394e = true;
    }
}
