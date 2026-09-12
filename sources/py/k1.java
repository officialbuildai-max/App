package py;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLView;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class k1 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f72912a;

    /* renamed from: b, reason: collision with root package name */
    public final View f72913b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f72914c;

    /* renamed from: d, reason: collision with root package name */
    public final Group f72915d;

    /* renamed from: e, reason: collision with root package name */
    public final Group f72916e;

    /* renamed from: f, reason: collision with root package name */
    public final Group f72917f;

    /* renamed from: g, reason: collision with root package name */
    public final Group f72918g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f72919h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f72920i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatImageView f72921j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f72922k;

    /* renamed from: l, reason: collision with root package name */
    public final ProgressBar f72923l;

    /* renamed from: m, reason: collision with root package name */
    public final View f72924m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f72925n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f72926o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f72927p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f72928q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f72929r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f72930s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f72931t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatTextView f72932u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f72933v;

    /* renamed from: w, reason: collision with root package name */
    public final View f72934w;

    /* renamed from: x, reason: collision with root package name */
    public final View f72935x;

    /* renamed from: y, reason: collision with root package name */
    public final View f72936y;

    /* renamed from: z, reason: collision with root package name */
    public final BLView f72937z;

    private k1(View view, View view2, FrameLayout frameLayout, Group group, Group group2, Group group3, Group group4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ProgressBar progressBar, View view3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, View view4, View view5, View view6, BLView bLView) {
        this.f72912a = view;
        this.f72913b = view2;
        this.f72914c = frameLayout;
        this.f72915d = group;
        this.f72916e = group2;
        this.f72917f = group3;
        this.f72918g = group4;
        this.f72919h = appCompatImageView;
        this.f72920i = appCompatImageView2;
        this.f72921j = appCompatImageView3;
        this.f72922k = appCompatImageView4;
        this.f72923l = progressBar;
        this.f72924m = view3;
        this.f72925n = appCompatTextView;
        this.f72926o = appCompatTextView2;
        this.f72927p = appCompatTextView3;
        this.f72928q = appCompatTextView4;
        this.f72929r = appCompatTextView5;
        this.f72930s = appCompatTextView6;
        this.f72931t = appCompatTextView7;
        this.f72932u = appCompatTextView8;
        this.f72933v = appCompatTextView9;
        this.f72934w = view4;
        this.f72935x = view5;
        this.f72936y = view6;
        this.f72937z = bLView;
    }

    public static k1 a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        int i11 = R$id.bottom_guideline;
        View a15 = g4.b.a(view, i11);
        if (a15 != null) {
            i11 = R$id.fl_send;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.group_def;
                Group group = (Group) g4.b.a(view, i11);
                if (group != null) {
                    i11 = R$id.group_list;
                    Group group2 = (Group) g4.b.a(view, i11);
                    if (group2 != null) {
                        i11 = R$id.group_send;
                        Group group3 = (Group) g4.b.a(view, i11);
                        if (group3 != null) {
                            i11 = R$id.group_top_connect;
                            Group group4 = (Group) g4.b.a(view, i11);
                            if (group4 != null) {
                                i11 = R$id.iv_close;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView != null) {
                                    i11 = R$id.iv_reset;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.iv_send_list;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                        if (appCompatImageView3 != null) {
                                            i11 = R$id.iv_top_icon;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                                            if (appCompatImageView4 != null) {
                                                i11 = R$id.pb_loading;
                                                ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                                if (progressBar != null && (a11 = g4.b.a(view, (i11 = R$id.top_guideline))) != null) {
                                                    i11 = R$id.tv_close;
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView != null) {
                                                        i11 = R$id.tv_receive_def;
                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView2 != null) {
                                                            i11 = R$id.tv_reset;
                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView3 != null) {
                                                                i11 = R$id.tv_send;
                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView4 != null) {
                                                                    i11 = R$id.tv_send_def;
                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView5 != null) {
                                                                        i11 = R$id.tv_send_list_count;
                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView6 != null) {
                                                                            i11 = R$id.tv_send_list_tips;
                                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView7 != null) {
                                                                                i11 = R$id.tv_top_disconnect;
                                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                if (appCompatTextView8 != null) {
                                                                                    i11 = R$id.tv_top_phone_model;
                                                                                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView9 != null && (a12 = g4.b.a(view, (i11 = R$id.v_receive_def))) != null && (a13 = g4.b.a(view, (i11 = R$id.v_send))) != null && (a14 = g4.b.a(view, (i11 = R$id.v_send_def))) != null) {
                                                                                        i11 = R$id.v_top_bg;
                                                                                        BLView bLView = (BLView) g4.b.a(view, i11);
                                                                                        if (bLView != null) {
                                                                                            return new k1(view, a15, frameLayout, group, group2, group3, group4, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, progressBar, a11, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, a12, a13, a14, bLView);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // g4.a
    public View getRoot() {
        return this.f72912a;
    }
}
