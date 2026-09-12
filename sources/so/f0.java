package so;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;

/* loaded from: classes6.dex */
public final class f0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f75639a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f75640b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f75641c;

    /* renamed from: d, reason: collision with root package name */
    public final BLTextView f75642d;

    /* renamed from: e, reason: collision with root package name */
    public final BLView f75643e;

    /* renamed from: f, reason: collision with root package name */
    public final BLImageView f75644f;

    private f0(View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, BLTextView bLTextView, BLView bLView, BLImageView bLImageView) {
        this.f75639a = view;
        this.f75640b = appCompatImageView;
        this.f75641c = appCompatImageView2;
        this.f75642d = bLTextView;
        this.f75643e = bLView;
        this.f75644f = bLImageView;
    }

    public static f0 a(View view) {
        int i11 = R$id.iv_short_tv_guide_arrow_1;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_short_tv_guide_arrow_2;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.tv_short_tv_guide_ep;
                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                if (bLTextView != null) {
                    i11 = R$id.tv_short_tv_guide_ep_bg;
                    BLView bLView = (BLView) g4.b.a(view, i11);
                    if (bLView != null) {
                        i11 = R$id.tv_short_tv_guide_list;
                        BLImageView bLImageView = (BLImageView) g4.b.a(view, i11);
                        if (bLImageView != null) {
                            return new f0(view, appCompatImageView, appCompatImageView2, bLTextView, bLView, bLImageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f75639a;
    }
}
