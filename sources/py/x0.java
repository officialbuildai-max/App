package py;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.transsnet.downloader.R$id;

/* loaded from: classes7.dex */
public final class x0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f73091a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f73092b;

    /* renamed from: c, reason: collision with root package name */
    public final Group f73093c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f73094d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f73095e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f73096f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f73097g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f73098h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f73099i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f73100j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f73101k;

    private x0(View view, ConstraintLayout constraintLayout, Group group, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f73091a = view;
        this.f73092b = constraintLayout;
        this.f73093c = group;
        this.f73094d = appCompatImageView;
        this.f73095e = linearLayout;
        this.f73096f = textView;
        this.f73097g = textView2;
        this.f73098h = textView3;
        this.f73099i = textView4;
        this.f73100j = textView5;
        this.f73101k = textView6;
    }

    public static x0 a(View view) {
        int i11 = R$id.cl_permission;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.group_permission;
            Group group = (Group) g4.b.a(view, i11);
            if (group != null) {
                i11 = R$id.iv_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_content;
                    LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.tv_available_size;
                        TextView textView = (TextView) g4.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.tv_change;
                            TextView textView2 = (TextView) g4.b.a(view, i11);
                            if (textView2 != null) {
                                i11 = R$id.tv_path_name;
                                TextView textView3 = (TextView) g4.b.a(view, i11);
                                if (textView3 != null) {
                                    i11 = R$id.tv_permission_btn;
                                    TextView textView4 = (TextView) g4.b.a(view, i11);
                                    if (textView4 != null) {
                                        i11 = R$id.tv_permission_tips;
                                        TextView textView5 = (TextView) g4.b.a(view, i11);
                                        if (textView5 != null) {
                                            i11 = R$id.tv_permission_title;
                                            TextView textView6 = (TextView) g4.b.a(view, i11);
                                            if (textView6 != null) {
                                                return new x0(view, constraintLayout, group, appCompatImageView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6);
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
        return this.f73091a;
    }
}
