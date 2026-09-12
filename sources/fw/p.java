package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f62961a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f62962b;

    private p(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f62961a = frameLayout;
        this.f62962b = frameLayout2;
    }

    public static p a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new p(frameLayout, frameLayout);
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_user_profile, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f62961a;
    }
}
