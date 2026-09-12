package qx;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.videofloat.R$id;

/* loaded from: classes7.dex */
public final class b implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f74012a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f74013b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f74014c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f74015d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f74016e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f74017f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f74018g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f74019h;

    /* renamed from: i, reason: collision with root package name */
    public final SimpleSubtitleView f74020i;

    /* renamed from: j, reason: collision with root package name */
    public final View f74021j;

    private b(View view, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, SimpleSubtitleView simpleSubtitleView, View view2) {
        this.f74012a = view;
        this.f74013b = frameLayout;
        this.f74014c = group;
        this.f74015d = appCompatImageView;
        this.f74016e = appCompatImageView2;
        this.f74017f = appCompatImageView3;
        this.f74018g = appCompatImageView4;
        this.f74019h = appCompatImageView5;
        this.f74020i = simpleSubtitleView;
        this.f74021j = view2;
    }

    public static b a(View view) {
        View a11;
        int i11 = R$id.fl_player_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.group_control;
            Group group = (Group) g4.b.a(view, i11);
            if (group != null) {
                i11 = R$id.iv_backward;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.iv_close;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.iv_forward;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView3 != null) {
                            i11 = R$id.iv_full;
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView4 != null) {
                                i11 = R$id.iv_play;
                                AppCompatImageView appCompatImageView5 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView5 != null) {
                                    i11 = R$id.v_subtitle;
                                    SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) g4.b.a(view, i11);
                                    if (simpleSubtitleView != null && (a11 = g4.b.a(view, (i11 = R$id.v_trans_float))) != null) {
                                        return new b(view, frameLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, simpleSubtitleView, a11);
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
        return this.f74012a;
    }
}
