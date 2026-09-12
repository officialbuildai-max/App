package gv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* loaded from: classes7.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutCompat f64099a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f64100b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f64101c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f64102d;

    /* renamed from: e, reason: collision with root package name */
    public final ShapeableImageView f64103e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f64104f;

    /* renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f64105g;

    /* renamed from: h, reason: collision with root package name */
    public final ProgressBar f64106h;

    /* renamed from: i, reason: collision with root package name */
    public final SwitchButton f64107i;

    /* renamed from: j, reason: collision with root package name */
    public final TitleLayout f64108j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f64109k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f64110l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f64111m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f64112n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f64113o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f64114p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f64115q;

    private d(LinearLayoutCompat linearLayoutCompat, Group group, Group group2, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, ProgressBar progressBar, SwitchButton switchButton, TitleLayout titleLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7) {
        this.f64099a = linearLayoutCompat;
        this.f64100b = group;
        this.f64101c = group2;
        this.f64102d = appCompatImageView;
        this.f64103e = shapeableImageView;
        this.f64104f = linearLayout;
        this.f64105g = constraintLayout;
        this.f64106h = progressBar;
        this.f64107i = switchButton;
        this.f64108j = titleLayout;
        this.f64109k = appCompatTextView;
        this.f64110l = appCompatTextView2;
        this.f64111m = appCompatTextView3;
        this.f64112n = appCompatTextView4;
        this.f64113o = appCompatTextView5;
        this.f64114p = appCompatTextView6;
        this.f64115q = appCompatTextView7;
    }

    public static d a(View view) {
        int i11 = R$id.groupErrorLayout;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupSuccessLayout;
            Group group2 = (Group) g4.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivError;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivTransWifiQrCode;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.llSend;
                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.llUp;
                            ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.progressBar;
                                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                if (progressBar != null) {
                                    i11 = R$id.switchButton;
                                    SwitchButton switchButton = (SwitchButton) g4.b.a(view, i11);
                                    if (switchButton != null) {
                                        i11 = R$id.toolBar;
                                        TitleLayout titleLayout = (TitleLayout) g4.b.a(view, i11);
                                        if (titleLayout != null) {
                                            i11 = R$id.tvErrorTip;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView != null) {
                                                i11 = R$id.tvRetry;
                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView2 != null) {
                                                    i11 = R$id.tvSend;
                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView3 != null) {
                                                        i11 = R$id.tvShareLink;
                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView4 != null) {
                                                            i11 = R$id.tvShareQrCode;
                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView5 != null) {
                                                                i11 = R$id.tvWaitingForReceiver;
                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView6 != null) {
                                                                    i11 = R$id.tvWifiSsid;
                                                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView7 != null) {
                                                                        return new d((LinearLayoutCompat) view, group, group2, appCompatImageView, shapeableImageView, linearLayout, constraintLayout, progressBar, switchButton, titleLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static d c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_wifi_create, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f64099a;
    }
}
