package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.player.longvideo.R$layout;

/* loaded from: classes6.dex */
public final class n implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f64808a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f64809b;

    private n(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f64808a = frameLayout;
        this.f64809b = frameLayout2;
    }

    public static n a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new n(frameLayout, frameLayout);
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.test_acitvity_long_vod, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f64808a;
    }
}
