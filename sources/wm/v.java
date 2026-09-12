package wm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.member.R$id;
import com.transsion.member.R$layout;
import com.transsion.member.view.MemberBasicView;
import com.transsion.member.view.MemberProView;

/* loaded from: classes6.dex */
public final class v implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ScrollView f78027a;

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f78028b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f78029c;

    /* renamed from: d, reason: collision with root package name */
    public final MemberBasicView f78030d;

    /* renamed from: e, reason: collision with root package name */
    public final MemberProView f78031e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f78032f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f78033g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f78034h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f78035i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f78036j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f78037k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f78038l;

    /* renamed from: m, reason: collision with root package name */
    public final View f78039m;

    private v(ScrollView scrollView, RecyclerView recyclerView, LinearLayout linearLayout, MemberBasicView memberBasicView, MemberProView memberProView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.f78027a = scrollView;
        this.f78028b = recyclerView;
        this.f78029c = linearLayout;
        this.f78030d = memberBasicView;
        this.f78031e = memberProView;
        this.f78032f = linearLayout2;
        this.f78033g = linearLayout3;
        this.f78034h = textView;
        this.f78035i = textView2;
        this.f78036j = textView3;
        this.f78037k = textView4;
        this.f78038l = textView5;
        this.f78039m = view;
    }

    public static v a(View view) {
        View a11;
        int i11 = R$id.iv_rights_list;
        RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.layout_feedback;
            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
            if (linearLayout != null) {
                i11 = R$id.layout_premium_basic;
                MemberBasicView memberBasicView = (MemberBasicView) g4.b.a(view, i11);
                if (memberBasicView != null) {
                    i11 = R$id.layout_premium_pro;
                    MemberProView memberProView = (MemberProView) g4.b.a(view, i11);
                    if (memberProView != null) {
                        i11 = R$id.layout_user_basic_status;
                        LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                        if (linearLayout2 != null) {
                            i11 = R$id.ll_feature_rights;
                            LinearLayout linearLayout3 = (LinearLayout) g4.b.a(view, i11);
                            if (linearLayout3 != null) {
                                i11 = R$id.tv_agreement_content;
                                TextView textView = (TextView) g4.b.a(view, i11);
                                if (textView != null) {
                                    i11 = R$id.tv_agreement_title;
                                    TextView textView2 = (TextView) g4.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.tv_basic_renew;
                                        TextView textView3 = (TextView) g4.b.a(view, i11);
                                        if (textView3 != null) {
                                            i11 = R$id.tv_feedback;
                                            TextView textView4 = (TextView) g4.b.a(view, i11);
                                            if (textView4 != null) {
                                                i11 = R$id.tv_promo_code;
                                                TextView textView5 = (TextView) g4.b.a(view, i11);
                                                if (textView5 != null && (a11 = g4.b.a(view, (i11 = R$id.view_feedback_divider))) != null) {
                                                    return new v((ScrollView) view, recyclerView, linearLayout, memberBasicView, memberProView, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5, a11);
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

    public static v c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.view_premium_content, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f78027a;
    }
}
