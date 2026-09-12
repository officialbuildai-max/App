package g00;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private ValueAnimator f63172b;

    /* renamed from: a, reason: collision with root package name */
    private List f63171a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private int f63173c = 150;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f63174d = new AccelerateDecelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private Animator.AnimatorListener f63175e = new C0788a();

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f63176f = new b();

    /* renamed from: g00.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0788a extends AnimatorListenerAdapter {
        C0788a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.d(0);
            a.this.f63172b = null;
        }
    }

    /* loaded from: classes7.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i11 = (int) floatValue;
            float f11 = floatValue - i11;
            if (floatValue < 0.0f) {
                i11--;
                f11 += 1.0f;
            }
            a.this.e(i11, f11, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i11) {
        Iterator it = this.f63171a.iterator();
        while (it.hasNext()) {
            ((MagicIndicator) it.next()).onPageScrollStateChanged(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i11, float f11, int i12) {
        Iterator it = this.f63171a.iterator();
        while (it.hasNext()) {
            ((MagicIndicator) it.next()).onPageScrolled(i11, f11, i12);
        }
    }

    public static k00.a f(List list, int i11) {
        k00.a aVar;
        if (i11 >= 0 && i11 <= list.size() - 1) {
            return (k00.a) list.get(i11);
        }
        k00.a aVar2 = new k00.a();
        if (i11 < 0) {
            aVar = (k00.a) list.get(0);
        } else {
            i11 = (i11 - list.size()) + 1;
            aVar = (k00.a) list.get(list.size() - 1);
        }
        aVar2.f66678a = aVar.f66678a + (aVar.b() * i11);
        aVar2.f66679b = aVar.f66679b;
        aVar2.f66680c = aVar.f66680c + (aVar.b() * i11);
        aVar2.f66681d = aVar.f66681d;
        aVar2.f66682e = aVar.f66682e + (aVar.b() * i11);
        aVar2.f66683f = aVar.f66683f;
        aVar2.f66684g = aVar.f66684g + (i11 * aVar.b());
        aVar2.f66685h = aVar.f66685h;
        return aVar2;
    }
}
