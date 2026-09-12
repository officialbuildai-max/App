package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63815a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63816b;

    private f(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f63815a = frameLayout;
        this.f63816b = frameLayout2;
    }

    public static f a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new f(frameLayout, frameLayout);
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_tv_live_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63815a;
    }
}
