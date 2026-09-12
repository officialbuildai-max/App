package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f69989a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f69990b;

    private m(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f69989a = frameLayout;
        this.f69990b = frameLayout2;
    }

    public static m a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new m(frameLayout, frameLayout);
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_activity_common_fragment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f69989a;
    }
}
