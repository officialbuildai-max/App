package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72719a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f72720b;

    private b(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f72719a = frameLayout;
        this.f72720b = frameLayout2;
    }

    public static b a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new b(frameLayout, frameLayout);
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_download_panel, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72719a;
    }
}
