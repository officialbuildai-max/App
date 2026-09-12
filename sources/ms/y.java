package ms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;

/* loaded from: classes7.dex */
public final class y implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final BLConstraintLayout f70077a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f70078b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f70079c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f70080d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f70081e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f70082f;

    /* renamed from: g, reason: collision with root package name */
    public final BLView f70083g;

    private y(BLConstraintLayout bLConstraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLView bLView) {
        this.f70077a = bLConstraintLayout;
        this.f70078b = appCompatImageView;
        this.f70079c = appCompatImageView2;
        this.f70080d = appCompatTextView;
        this.f70081e = appCompatTextView2;
        this.f70082f = appCompatTextView3;
        this.f70083g = bLView;
    }

    public static y a(View view) {
        int i11 = R$id.iv_ad;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.tv_ep;
                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_unlock;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.tv_watch;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            i11 = R$id.v_bg;
                            BLView bLView = (BLView) g4.b.a(view, i11);
                            if (bLView != null) {
                                return new y((BLConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2, appCompatTextView3, bLView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static y c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static y d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.short_tv_fragment_download_res_ad, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f70077a;
    }
}
