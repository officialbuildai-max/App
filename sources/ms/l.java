package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f69985a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f69986b;

    private l(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f69985a = frameLayout;
        this.f69986b = frameLayout2;
    }

    public static l a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new l(frameLayout, frameLayout);
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_activity_comm, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f69985a;
    }
}
