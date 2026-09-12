package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f70000a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f70001b;

    private o(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f70000a = frameLayout;
        this.f70001b = frameLayout2;
    }

    public static o a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new o(frameLayout, frameLayout);
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_activity_play_list, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f70000a;
    }
}
