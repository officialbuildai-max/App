package oa;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private long f71056a;

    /* renamed from: b, reason: collision with root package name */
    private long f71057b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f71058c;

    /* renamed from: d, reason: collision with root package name */
    private int f71059d;

    /* renamed from: e, reason: collision with root package name */
    private int f71060e;

    public i(long j11, long j12) {
        this.f71058c = null;
        this.f71059d = 0;
        this.f71060e = 1;
        this.f71056a = j11;
        this.f71057b = j12;
    }

    public i(long j11, long j12, TimeInterpolator timeInterpolator) {
        this.f71059d = 0;
        this.f71060e = 1;
        this.f71056a = j11;
        this.f71057b = j12;
        this.f71058c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f71059d = valueAnimator.getRepeatCount();
        iVar.f71060e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f71042b : interpolator instanceof AccelerateInterpolator ? a.f71043c : interpolator instanceof DecelerateInterpolator ? a.f71044d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f71056a;
    }

    public long d() {
        return this.f71057b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f71058c;
        return timeInterpolator != null ? timeInterpolator : a.f71042b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f71059d;
    }

    public int h() {
        return this.f71060e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
