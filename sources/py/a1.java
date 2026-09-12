package py;

import android.view.View;
import android.widget.ImageView;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class a1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f72716a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f72717b;

    /* renamed from: c, reason: collision with root package name */
    public final CircleProgressBar f72718c;

    private a1(View view, ImageView imageView, CircleProgressBar circleProgressBar) {
        this.f72716a = view;
        this.f72717b = imageView;
        this.f72718c = circleProgressBar;
    }

    public static a1 a(View view) {
        int i11 = R$id.iv_close;
        ImageView imageView = (ImageView) g4.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.progress_bar_close;
            CircleProgressBar circleProgressBar = (CircleProgressBar) g4.b.a(view, i11);
            if (circleProgressBar != null) {
                return new a1(view, imageView, circleProgressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f72716a;
    }
}
