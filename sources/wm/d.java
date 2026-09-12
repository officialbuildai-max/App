package wm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* loaded from: classes6.dex */
public final class d implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final GradientBorderView f77849a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientBorderView f77850b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayoutCompat f77851c;

    /* renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f77852d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f77853e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f77854f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f77855g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f77856h;

    private d(GradientBorderView gradientBorderView, GradientBorderView gradientBorderView2, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        this.f77849a = gradientBorderView;
        this.f77850b = gradientBorderView2;
        this.f77851c = linearLayoutCompat;
        this.f77852d = appCompatTextView;
        this.f77853e = imageView;
        this.f77854f = textView;
        this.f77855g = imageView2;
        this.f77856h = textView2;
    }

    public static d a(View view) {
        GradientBorderView gradientBorderView = (GradientBorderView) view;
        int i11 = R$id.explore;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
        if (linearLayoutCompat != null) {
            i11 = R$id.explore_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.iv_close;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.iv_detail;
                    TextView textView = (TextView) g4.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.iv_premium_mask;
                        ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                        if (imageView2 != null) {
                            i11 = R$id.iv_title;
                            TextView textView2 = (TextView) g4.b.a(view, i11);
                            if (textView2 != null) {
                                return new d(gradientBorderView, gradientBorderView, linearLayoutCompat, appCompatTextView, imageView, textView, imageView2, textView2);
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
    public GradientBorderView getRoot() {
        return this.f77849a;
    }
}
