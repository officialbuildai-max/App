package ey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;

/* loaded from: classes7.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final CardView f62205a;

    /* renamed from: b, reason: collision with root package name */
    public final CardView f62206b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f62207c;

    /* renamed from: d, reason: collision with root package name */
    public final CardView f62208d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f62209e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f62210f;

    /* renamed from: g, reason: collision with root package name */
    public final MediaView f62211g;

    /* renamed from: h, reason: collision with root package name */
    public final FrameLayout f62212h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f62213i;

    private d(CardView cardView, CardView cardView2, AppCompatTextView appCompatTextView, CardView cardView3, TextView textView, AppCompatImageView appCompatImageView, MediaView mediaView, FrameLayout frameLayout, TextView textView2) {
        this.f62205a = cardView;
        this.f62206b = cardView2;
        this.f62207c = appCompatTextView;
        this.f62208d = cardView3;
        this.f62209e = textView;
        this.f62210f = appCompatImageView;
        this.f62211g = mediaView;
        this.f62212h = frameLayout;
        this.f62213i = textView2;
    }

    public static d a(View view) {
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
                                    return new d(cardView2, cardView, appCompatTextView, cardView2, textView, appCompatImageView, mediaView, frameLayout, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static d c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.search_hot_hi_native_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.f62205a;
    }
}
