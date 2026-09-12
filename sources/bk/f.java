package bk;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.R$id;
import com.transsion.baseui.music.RoundedCornerLayout;

/* loaded from: classes5.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16680a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f16681b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f16682c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f16683d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f16684e;

    /* renamed from: f, reason: collision with root package name */
    public final ProgressBar f16685f;

    /* renamed from: g, reason: collision with root package name */
    public final RoundedCornerLayout f16686g;

    /* renamed from: h, reason: collision with root package name */
    public final RoundedCornerLayout f16687h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f16688i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f16689j;

    private f(FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ProgressBar progressBar, RoundedCornerLayout roundedCornerLayout, RoundedCornerLayout roundedCornerLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.f16680a = frameLayout;
        this.f16681b = appCompatImageView;
        this.f16682c = appCompatImageView2;
        this.f16683d = appCompatImageView3;
        this.f16684e = appCompatImageView4;
        this.f16685f = progressBar;
        this.f16686g = roundedCornerLayout;
        this.f16687h = roundedCornerLayout2;
        this.f16688i = appCompatTextView;
        this.f16689j = appCompatTextView2;
    }

    public static f a(View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivCover;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivCoverBg;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivPlayPause;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.progress;
                        ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                        if (progressBar != null) {
                            i11 = R$id.roundExpand;
                            RoundedCornerLayout roundedCornerLayout = (RoundedCornerLayout) g4.b.a(view, i11);
                            if (roundedCornerLayout != null) {
                                i11 = R$id.roundFold;
                                RoundedCornerLayout roundedCornerLayout2 = (RoundedCornerLayout) g4.b.a(view, i11);
                                if (roundedCornerLayout2 != null) {
                                    i11 = R$id.tvDescription;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tvTitle;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            return new f((FrameLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, progressBar, roundedCornerLayout, roundedCornerLayout2, appCompatTextView, appCompatTextView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f16680a;
    }
}
