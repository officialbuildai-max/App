package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: classes7.dex */
public final class r0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f70032a;

    /* renamed from: b, reason: collision with root package name */
    public final TnTextView f70033b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f70034c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f70035d;

    /* renamed from: e, reason: collision with root package name */
    public final TnTextView f70036e;

    /* renamed from: f, reason: collision with root package name */
    public final TnTextView f70037f;

    /* renamed from: g, reason: collision with root package name */
    public final TnTextView f70038g;

    private r0(View view, TnTextView tnTextView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TnTextView tnTextView2, TnTextView tnTextView3, TnTextView tnTextView4) {
        this.f70032a = view;
        this.f70033b = tnTextView;
        this.f70034c = appCompatImageView;
        this.f70035d = appCompatImageView2;
        this.f70036e = tnTextView2;
        this.f70037f = tnTextView3;
        this.f70038g = tnTextView4;
    }

    public static r0 a(View view) {
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
                                return new r0(view, tnTextView, appCompatImageView, appCompatImageView2, tnTextView2, tnTextView3, tnTextView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static r0 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.short_tv_view_content_no_connection, viewGroup);
        return a(viewGroup);
    }

    @Override // g4.a
    public View getRoot() {
        return this.f70032a;
    }
}
