package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62754a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageButton f62755b;

    /* renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f62756c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f62757d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f62758e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f62759f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f62760g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatTextView f62761h;

    /* renamed from: i, reason: collision with root package name */
    public final AppCompatTextView f62762i;

    /* renamed from: j, reason: collision with root package name */
    public final AppCompatTextView f62763j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatTextView f62764k;

    /* renamed from: l, reason: collision with root package name */
    public final AppCompatTextView f62765l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f62766m;

    /* renamed from: n, reason: collision with root package name */
    public final AppCompatTextView f62767n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f62768o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f62769p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f62770q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f62771r;

    /* renamed from: s, reason: collision with root package name */
    public final AppCompatTextView f62772s;

    private f(LinearLayout linearLayout, AppCompatImageButton appCompatImageButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, AppCompatTextView appCompatTextView12, AppCompatTextView appCompatTextView13, AppCompatTextView appCompatTextView14, AppCompatTextView appCompatTextView15, AppCompatTextView appCompatTextView16, AppCompatTextView appCompatTextView17) {
        this.f62754a = linearLayout;
        this.f62755b = appCompatImageButton;
        this.f62756c = appCompatTextView;
        this.f62757d = appCompatTextView2;
        this.f62758e = appCompatTextView3;
        this.f62759f = appCompatTextView4;
        this.f62760g = appCompatTextView5;
        this.f62761h = appCompatTextView6;
        this.f62762i = appCompatTextView7;
        this.f62763j = appCompatTextView8;
        this.f62764k = appCompatTextView9;
        this.f62765l = appCompatTextView10;
        this.f62766m = appCompatTextView11;
        this.f62767n = appCompatTextView12;
        this.f62768o = appCompatTextView13;
        this.f62769p = appCompatTextView14;
        this.f62770q = appCompatTextView15;
        this.f62771r = appCompatTextView16;
        this.f62772s = appCompatTextView17;
    }

    public static f a(View view) {
        int i11 = R$id.btn_back;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) g4.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.tv_app_info;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvChannel;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_content_mode;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tvDebugJS;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tv_fps_switch;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tvHttpHost;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tvIso;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tvKillApp;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            i11 = R$id.tv_lane;
                                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                            if (appCompatTextView9 != null) {
                                                i11 = R$id.tv_location_mock;
                                                AppCompatTextView appCompatTextView10 = (AppCompatTextView) g4.b.a(view, i11);
                                                if (appCompatTextView10 != null) {
                                                    i11 = R$id.tvMiniAppSDKTest;
                                                    AppCompatTextView appCompatTextView11 = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView11 != null) {
                                                        i11 = R$id.tvNotification;
                                                        AppCompatTextView appCompatTextView12 = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView12 != null) {
                                                            i11 = R$id.tv_select_brand;
                                                            AppCompatTextView appCompatTextView13 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView13 != null) {
                                                                i11 = R$id.tvStreaming;
                                                                AppCompatTextView appCompatTextView14 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView14 != null) {
                                                                    i11 = R$id.tvTestAd;
                                                                    AppCompatTextView appCompatTextView15 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView15 != null) {
                                                                        i11 = R$id.tvWebTest;
                                                                        AppCompatTextView appCompatTextView16 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView16 != null) {
                                                                            i11 = R$id.tvWidget;
                                                                            AppCompatTextView appCompatTextView17 = (AppCompatTextView) g4.b.a(view, i11);
                                                                            if (appCompatTextView17 != null) {
                                                                                return new f((LinearLayout) view, appCompatImageButton, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, appCompatTextView11, appCompatTextView12, appCompatTextView13, appCompatTextView14, appCompatTextView15, appCompatTextView16, appCompatTextView17);
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

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_laboratory, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f62754a;
    }
}
