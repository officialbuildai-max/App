package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class q implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f73007a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f73008b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f73009c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f73010d;

    private q(View view, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, TnTextView tnTextView) {
        this.f73007a = view;
        this.f73008b = appCompatImageView;
        this.f73009c = linearLayoutCompat;
        this.f73010d = tnTextView;
    }

    public static q a(View view) {
        int i11 = R$id.iv_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ll_download_inner;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.tv_tips;
                TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                if (tnTextView != null) {
                    return new q(view, appCompatImageView, linearLayoutCompat, tnTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f73007a;
    }
}
