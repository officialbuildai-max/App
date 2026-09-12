package ex;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.version.update.R$id;

/* loaded from: classes7.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f62157a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f62158b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f62159c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f62160d;

    /* renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f62161e;

    /* renamed from: f, reason: collision with root package name */
    public final ScrollView f62162f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f62163g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f62164h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f62165i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f62166j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f62167k;

    private a(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout, ScrollView scrollView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f62157a = linearLayout;
        this.f62158b = textView;
        this.f62159c = textView2;
        this.f62160d = imageView;
        this.f62161e = constraintLayout;
        this.f62162f = scrollView;
        this.f62163g = textView3;
        this.f62164h = textView4;
        this.f62165i = textView5;
        this.f62166j = textView6;
        this.f62167k = textView7;
    }

    public static a a(View view) {
        int i11 = R$id.btSkip;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.btUpdate;
            TextView textView2 = (TextView) g4.b.a(view, i11);
            if (textView2 != null) {
                i11 = R$id.iv_icon;
                ImageView imageView = (ImageView) g4.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.layout_bottom;
                    ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
                    if (constraintLayout != null) {
                        i11 = R$id.scrollView;
                        ScrollView scrollView = (ScrollView) g4.b.a(view, i11);
                        if (scrollView != null) {
                            i11 = R$id.tvDetails;
                            TextView textView3 = (TextView) g4.b.a(view, i11);
                            if (textView3 != null) {
                                i11 = R$id.tvName;
                                TextView textView4 = (TextView) g4.b.a(view, i11);
                                if (textView4 != null) {
                                    i11 = R$id.tvSize;
                                    TextView textView5 = (TextView) g4.b.a(view, i11);
                                    if (textView5 != null) {
                                        i11 = R$id.tvTitle;
                                        TextView textView6 = (TextView) g4.b.a(view, i11);
                                        if (textView6 != null) {
                                            i11 = R$id.tvVersion;
                                            TextView textView7 = (TextView) g4.b.a(view, i11);
                                            if (textView7 != null) {
                                                return new a((LinearLayout) view, textView, textView2, imageView, constraintLayout, scrollView, textView3, textView4, textView5, textView6, textView7);
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
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f62157a;
    }
}
