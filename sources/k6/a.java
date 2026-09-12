package k6;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a implements b {

    /* renamed from: b, reason: collision with root package name */
    public static final C0835a f66791b = new C0835a(null);

    /* renamed from: a, reason: collision with root package name */
    private final float f66792a;

    /* renamed from: k6.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0835a {
        private C0835a() {
        }

        public /* synthetic */ C0835a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public a() {
        this(0.0f, 1, null);
    }

    public a(float f11) {
        this.f66792a = f11;
    }

    public /* synthetic */ a(float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11);
    }

    @Override // k6.b
    public Animator[] a(View view) {
        Intrinsics.h(view, "view");
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", this.f66792a, 1.0f);
        animator.setDuration(300L);
        animator.setInterpolator(new LinearInterpolator());
        Intrinsics.g(animator, "animator");
        return new Animator[]{animator};
    }
}
