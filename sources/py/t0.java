package py;

import android.view.View;
import android.widget.ImageView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class t0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f73047a;

    /* renamed from: b, reason: collision with root package name */
    public final BLFrameLayout f73048b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f73049c;

    /* renamed from: d, reason: collision with root package name */
    public final CircleProgressBar f73050d;

    private t0(View view, BLFrameLayout bLFrameLayout, ImageView imageView, CircleProgressBar circleProgressBar) {
        this.f73047a = view;
        this.f73048b = bLFrameLayout;
        this.f73049c = imageView;
        this.f73050d = circleProgressBar;
    }

    public static t0 a(View view) {
        int i11 = R$id.fl_guide_content;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
        if (bLFrameLayout != null) {
            i11 = R$id.iv_guide_close;
            ImageView imageView = (ImageView) g4.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.progress_bar_guide_close;
                CircleProgressBar circleProgressBar = (CircleProgressBar) g4.b.a(view, i11);
                if (circleProgressBar != null) {
                    return new t0(view, bLFrameLayout, imageView, circleProgressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f73047a;
    }
}
