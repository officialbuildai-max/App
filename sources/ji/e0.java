package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class e0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final CardView f66185a;

    /* renamed from: b, reason: collision with root package name */
    public final CardView f66186b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f66187c;

    /* renamed from: d, reason: collision with root package name */
    public final CardView f66188d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f66189e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f66190f;

    /* renamed from: g, reason: collision with root package name */
    public final MediaView f66191g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f66192h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f66193i;

    private e0(CardView cardView, CardView cardView2, AppCompatTextView appCompatTextView, CardView cardView3, TextView textView, AppCompatImageView appCompatImageView, MediaView mediaView, FrameLayout frameLayout, TextView textView2) {
        this.f66185a = cardView;
        this.f66186b = cardView2;
        this.f66187c = appCompatTextView;
        this.f66188d = cardView3;
        this.f66189e = textView;
        this.f66190f = appCompatImageView;
        this.f66191g = mediaView;
        this.f66192h = frameLayout;
        this.f66193i = textView2;
    }

    public static e0 a(View view) {
        int i11 = R$id.icon_cardview;
        CardView cardView = (CardView) g4.b.a(view, i11);
        if (cardView != null) {
            i11 = R$id.native_ad_action;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                CardView cardView2 = (CardView) view;
                i11 = R$id.native_ad_des;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.native_ad_icon;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.native_ad_media;
                        MediaView mediaView = (MediaView) g4.b.a(view, i11);
                        if (mediaView != null) {
                            i11 = R$id.native_ad_media_container;
                            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                            if (frameLayout != null) {
                                i11 = R$id.native_ad_title;
                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                if (textView2 != null) {
                                    return new e0(cardView2, cardView, appCompatTextView, cardView2, textView, appCompatImageView, mediaView, frameLayout, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static e0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.test_ssp_hi_native_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.f66185a;
    }
}
