package kk;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.task.wheel.LuckyWheelView;

/* loaded from: classes6.dex */
public final class f implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66978a;

    /* renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f66979b;

    /* renamed from: c, reason: collision with root package name */
    public final LuckyWheelView f66980c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f66981d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f66982e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f66983f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f66984g;

    private f(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LuckyWheelView luckyWheelView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f66978a = linearLayout;
        this.f66979b = appCompatImageView;
        this.f66980c = luckyWheelView;
        this.f66981d = linearLayout2;
        this.f66982e = textView;
        this.f66983f = textView2;
        this.f66984g = textView3;
    }

    public static f a(View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.luckyWheel;
            LuckyWheelView luckyWheelView = (LuckyWheelView) g4.b.a(view, i11);
            if (luckyWheelView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R$id.spinNowBtn;
                TextView textView = (TextView) g4.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvTitle1;
                    TextView textView2 = (TextView) g4.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.tvTitle2;
                        TextView textView3 = (TextView) g4.b.a(view, i11);
                        if (textView3 != null) {
                            return new f(linearLayout, appCompatImageView, luckyWheelView, linearLayout, textView, textView2, textView3);
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
        return this.f66978a;
    }
}
