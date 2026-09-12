package wm;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.member.R$id;
import com.transsion.member.view.CheckInView;
import com.transsion.member.view.GradientTextView;

/* loaded from: classes6.dex */
public final class g implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f77869a;

    /* renamed from: b, reason: collision with root package name */
    public final CheckBox f77870b;

    /* renamed from: c, reason: collision with root package name */
    public final GradientTextView f77871c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f77872d;

    /* renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f77873e;

    /* renamed from: f, reason: collision with root package name */
    public final CheckInView f77874f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f77875g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f77876h;

    /* renamed from: i, reason: collision with root package name */
    public final GradientTextView f77877i;

    private g(LinearLayout linearLayout, CheckBox checkBox, GradientTextView gradientTextView, ImageView imageView, AppCompatImageView appCompatImageView, CheckInView checkInView, TextView textView, TextView textView2, GradientTextView gradientTextView2) {
        this.f77869a = linearLayout;
        this.f77870b = checkBox;
        this.f77871c = gradientTextView;
        this.f77872d = imageView;
        this.f77873e = appCompatImageView;
        this.f77874f = checkInView;
        this.f77875g = textView;
        this.f77876h = textView2;
        this.f77877i = gradientTextView2;
    }

    public static g a(View view) {
        int i11 = R$id.dialog_ignore;
        CheckBox checkBox = (CheckBox) g4.b.a(view, i11);
        if (checkBox != null) {
            i11 = R$id.go_purchase_member;
            GradientTextView gradientTextView = (GradientTextView) g4.b.a(view, i11);
            if (gradientTextView != null) {
                i11 = R$id.ic_tips;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.member_check_in_view;
                        CheckInView checkInView = (CheckInView) g4.b.a(view, i11);
                        if (checkInView != null) {
                            i11 = R$id.member_tips;
                            TextView textView = (TextView) g4.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.point_tips;
                                TextView textView2 = (TextView) g4.b.a(view, i11);
                                if (textView2 != null) {
                                    i11 = R$id.title;
                                    GradientTextView gradientTextView2 = (GradientTextView) g4.b.a(view, i11);
                                    if (gradientTextView2 != null) {
                                        return new g((LinearLayout) view, checkBox, gradientTextView, imageView, appCompatImageView, checkInView, textView, textView2, gradientTextView2);
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
    public LinearLayout getRoot() {
        return this.f77869a;
    }
}
