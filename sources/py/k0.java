package py;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* loaded from: classes7.dex */
public final class k0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72909a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f72910b;

    /* renamed from: c, reason: collision with root package name */
    public final NativeSlideshowView f72911c;

    private k0(FrameLayout frameLayout, FrameLayout frameLayout2, NativeSlideshowView nativeSlideshowView) {
        this.f72909a = frameLayout;
        this.f72910b = frameLayout2;
        this.f72911c = nativeSlideshowView;
    }

    public static k0 a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R$id.nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView = (NativeSlideshowView) g4.b.a(view, i11);
        if (nativeSlideshowView != null) {
            return new k0(frameLayout, frameLayout, nativeSlideshowView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static k0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_top_card_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f72909a;
    }
}
