package ji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* loaded from: classes6.dex */
public final class p implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f66275a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f66276b;

    /* renamed from: c, reason: collision with root package name */
    public final Button f66277c;

    /* renamed from: d, reason: collision with root package name */
    public final Button f66278d;

    /* renamed from: e, reason: collision with root package name */
    public final Button f66279e;

    /* renamed from: f, reason: collision with root package name */
    public final Button f66280f;

    /* renamed from: g, reason: collision with root package name */
    public final Button f66281g;

    /* renamed from: h, reason: collision with root package name */
    public final Button f66282h;

    /* renamed from: i, reason: collision with root package name */
    public final Button f66283i;

    /* renamed from: j, reason: collision with root package name */
    public final Button f66284j;

    /* renamed from: k, reason: collision with root package name */
    public final Button f66285k;

    private p(LinearLayout linearLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10) {
        this.f66275a = linearLayout;
        this.f66276b = button;
        this.f66277c = button2;
        this.f66278d = button3;
        this.f66279e = button4;
        this.f66280f = button5;
        this.f66281g = button6;
        this.f66282h = button7;
        this.f66283i = button8;
        this.f66284j = button9;
        this.f66285k = button10;
    }

    public static p a(View view) {
        int i11 = R$id.btnAdConfigHost;
        Button button = (Button) g4.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnAdExample;
            Button button2 = (Button) g4.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.btnAdPlanConfig;
                Button button3 = (Button) g4.b.a(view, i11);
                if (button3 != null) {
                    i11 = R$id.btnGlobalSwitchConfig;
                    Button button4 = (Button) g4.b.a(view, i11);
                    if (button4 != null) {
                        i11 = R$id.btnMcc;
                        Button button5 = (Button) g4.b.a(view, i11);
                        if (button5 != null) {
                            i11 = R$id.btnNonHitLog;
                            Button button6 = (Button) g4.b.a(view, i11);
                            if (button6 != null) {
                                i11 = R$id.btnOtherConfig;
                                Button button7 = (Button) g4.b.a(view, i11);
                                if (button7 != null) {
                                    i11 = R$id.btnPsOfferConfig;
                                    Button button8 = (Button) g4.b.a(view, i11);
                                    if (button8 != null) {
                                        i11 = R$id.btnResetVersion;
                                        Button button9 = (Button) g4.b.a(view, i11);
                                        if (button9 != null) {
                                            i11 = R$id.btnSceneConfig;
                                            Button button10 = (Button) g4.b.a(view, i11);
                                            if (button10 != null) {
                                                return new p((LinearLayout) view, button, button2, button3, button4, button5, button6, button7, button8, button9, button10);
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

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_test_ad_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66275a;
    }
}
