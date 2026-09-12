package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class a1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f62703a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f62704b;

    private a1(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f62703a = frameLayout;
        this.f62704b = frameLayout2;
    }

    public static a1 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new a1(frameLayout, frameLayout);
    }

    public static a1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.profile_activity, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f62703a;
    }
}
