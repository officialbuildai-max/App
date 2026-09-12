package py;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class l implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f72938a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f72939b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f72940c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f72941d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f72942e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f72943f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f72944g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f72945h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f72946i;

    /* renamed from: j, reason: collision with root package name */
    public final View f72947j;

    /* renamed from: k, reason: collision with root package name */
    public final View f72948k;

    /* renamed from: l, reason: collision with root package name */
    public final View f72949l;

    /* renamed from: m, reason: collision with root package name */
    public final View f72950m;

    private l(FrameLayout frameLayout, Group group, Group group2, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, View view3, View view4) {
        this.f72938a = frameLayout;
        this.f72939b = group;
        this.f72940c = group2;
        this.f72941d = appCompatImageView;
        this.f72942e = textView;
        this.f72943f = textView2;
        this.f72944g = textView3;
        this.f72945h = textView4;
        this.f72946i = textView5;
        this.f72947j = view;
        this.f72948k = view2;
        this.f72949l = view3;
        this.f72950m = view4;
    }

    public static l a(View view) {
        View a11;
        View a12;
        View a13;
        View a14;
        int i11 = R$id.groupBatteryPermission;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupPremium;
            Group group2 = (Group) g4.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivPremium;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.tvBatteryPermission;
                    TextView textView = (TextView) g4.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.tvCancel;
                        TextView textView2 = (TextView) g4.b.a(view, i11);
                        if (textView2 != null) {
                            i11 = R$id.tvDownloadXXSizeAtOnce;
                            TextView textView3 = (TextView) g4.b.a(view, i11);
                            if (textView3 != null) {
                                i11 = R$id.tvPremium;
                                TextView textView4 = (TextView) g4.b.a(view, i11);
                                if (textView4 != null) {
                                    i11 = R$id.tvResumeAll;
                                    TextView textView5 = (TextView) g4.b.a(view, i11);
                                    if (textView5 != null && (a11 = g4.b.a(view, (i11 = R$id.viewBgPremium))) != null && (a12 = g4.b.a(view, (i11 = R$id.viewLine1))) != null && (a13 = g4.b.a(view, (i11 = R$id.viewLine2))) != null && (a14 = g4.b.a(view, (i11 = R$id.viewLine3))) != null) {
                                        return new l((FrameLayout) view, group, group2, appCompatImageView, textView, textView2, textView3, textView4, textView5, a11, a12, a13, a14);
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
        return this.f72938a;
    }
}
