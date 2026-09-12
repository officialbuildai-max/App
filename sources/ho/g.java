package ho;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64707a;

    /* renamed from: b, reason: collision with root package name */
    public final Group f64708b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f64709c;

    /* renamed from: d, reason: collision with root package name */
    public final BLTextView f64710d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f64711e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f64712f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatTextView f64713g;

    /* renamed from: h, reason: collision with root package name */
    public final BLTextView f64714h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearLayout f64715i;

    /* renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f64716j;

    private g(ConstraintLayout constraintLayout, Group group, Group group2, BLTextView bLTextView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2) {
        this.f64707a = constraintLayout;
        this.f64708b = group;
        this.f64709c = group2;
        this.f64710d = bLTextView;
        this.f64711e = appCompatTextView;
        this.f64712f = appCompatTextView2;
        this.f64713g = appCompatTextView3;
        this.f64714h = bLTextView2;
        this.f64715i = linearLayout;
        this.f64716j = constraintLayout2;
    }

    public static g a(View view) {
        int i11 = R$id.group1;
        Group group = (Group) g4.b.a(view, i11);
        if (group != null) {
            i11 = R$id.group2;
            Group group2 = (Group) g4.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.interceptPremium;
                BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
                if (bLTextView != null) {
                    i11 = R$id.interceptTip;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.interceptTitle;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.interceptTitleCam;
                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                            if (appCompatTextView3 != null) {
                                i11 = R$id.interceptWatchAd;
                                BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
                                if (bLTextView2 != null) {
                                    i11 = R$id.llBtn;
                                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                    if (linearLayout != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        return new g(constraintLayout, group, group2, bLTextView, appCompatTextView, appCompatTextView2, appCompatTextView3, bLTextView2, linearLayout, constraintLayout);
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
        return this.f64707a;
    }
}
