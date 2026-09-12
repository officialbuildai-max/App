package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class m implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63899a;

    private m(FrameLayout frameLayout) {
        this.f63899a = frameLayout;
    }

    public static m a(View view) {
        if (view != null) {
            return new m((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_empty, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63899a;
    }
}
