package au;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.subroom.R$layout;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16227a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16228b;

    private d(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f16227a = frameLayout;
        this.f16228b = frameLayout2;
    }

    public static d a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new d(frameLayout, frameLayout);
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_user_prefer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f16227a;
    }
}
