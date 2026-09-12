package py;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class r implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f73014a;

    /* renamed from: b, reason: collision with root package name */
    public final NativeWrapperAdView f73015b;

    /* renamed from: c, reason: collision with root package name */
    public final CardView f73016c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f73017d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f73018e;

    /* renamed from: f, reason: collision with root package name */
    public final BLTextView f73019f;

    /* renamed from: g, reason: collision with root package name */
    public final BLTextView f73020g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f73021h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f73022i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f73023j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f73024k;

    private r(ConstraintLayout constraintLayout, NativeWrapperAdView nativeWrapperAdView, CardView cardView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, BLTextView bLTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.f73014a = constraintLayout;
        this.f73015b = nativeWrapperAdView;
        this.f73016c = cardView;
        this.f73017d = appCompatImageView;
        this.f73018e = appCompatImageView2;
        this.f73019f = bLTextView;
        this.f73020g = bLTextView2;
        this.f73021h = appCompatTextView;
        this.f73022i = appCompatTextView2;
        this.f73023j = appCompatTextView3;
        this.f73024k = appCompatTextView4;
    }

    public static r a(View view) {
        int i11 = R$id.adContainer;
        NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) g4.b.a(view, i11);
        if (nativeWrapperAdView != null) {
            i11 = R$id.card_native_ad;
            CardView cardView = (CardView) g4.b.a(view, i11);
            if (cardView != null) {
                i11 = R$id.ivClose;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivDownload;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.tvBtnDetails;
                        BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                        if (bLTextView != null) {
                            i11 = R$id.tvBtnPlayNow;
                            BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
                            if (bLTextView2 != null) {
                                i11 = R$id.tvDes;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tvFileSize;
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView2 != null) {
                                        i11 = R$id.tvTitle;
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView3 != null) {
                                            i11 = R$id.tvTitleCopy;
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView4 != null) {
                                                return new r((ConstraintLayout) view, nativeWrapperAdView, cardView, appCompatImageView, appCompatImageView2, bLTextView, bLTextView2, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                            }
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
    public ConstraintLayout getRoot() {
        return this.f73014a;
    }
}
