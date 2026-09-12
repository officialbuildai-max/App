package ms;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: classes7.dex */
public final class u implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f70055a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f70056b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f70057c;

    /* renamed from: d, reason: collision with root package name */
    public final TnTextView f70058d;

    private u(View view, AppCompatImageView appCompatImageView, LinearLayoutCompat linearLayoutCompat, TnTextView tnTextView) {
        this.f70055a = view;
        this.f70056b = appCompatImageView;
        this.f70057c = linearLayoutCompat;
        this.f70058d = tnTextView;
    }

    public static u a(View view) {
        int i11 = R$id.iv_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ll_download_inner;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.short_tv_tips;
                TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
                if (tnTextView != null) {
                    return new u(view, appCompatImageView, linearLayoutCompat, tnTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f70055a;
    }
}
