package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv_pugc.base.widget.TnTextView;

/* loaded from: classes7.dex */
public final class k implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f69952a;

    /* renamed from: b, reason: collision with root package name */
    public final TnTextView f69953b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f69954c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f69955d;

    /* renamed from: e, reason: collision with root package name */
    public final TnTextView f69956e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f69957f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f69958g;

    private k(View view, TnTextView tnTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TnTextView tnTextView2, TnTextView tnTextView3, TnTextView tnTextView4) {
        this.f69952a = view;
        this.f69953b = tnTextView;
        this.f69954c = appCompatImageView;
        this.f69955d = appCompatImageView2;
        this.f69956e = tnTextView2;
        this.f69957f = tnTextView3;
        this.f69958g = tnTextView4;
    }

    public static k a(View view) {
        int i11 = R$id.go_to_setting;
        TnTextView tnTextView = (TnTextView) g4.b.a(view, i11);
        if (tnTextView != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_no_connection;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.no_connection_title;
                    TnTextView tnTextView2 = (TnTextView) g4.b.a(view, i11);
                    if (tnTextView2 != null) {
                        i11 = R$id.retry;
                        TnTextView tnTextView3 = (TnTextView) g4.b.a(view, i11);
                        if (tnTextView3 != null) {
                            i11 = R$id.tv_title;
                            TnTextView tnTextView4 = (TnTextView) g4.b.a(view, i11);
                            if (tnTextView4 != null) {
                                return new k(view, tnTextView, appCompatImageView, appCompatImageView2, tnTextView2, tnTextView3, tnTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static k b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.pugc_short_tv_view_content_no_connection, viewGroup);
        return a(viewGroup);
    }

    @Override // g4.a
    public View getRoot() {
        return this.f69952a;
    }
}
