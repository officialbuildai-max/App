package bk;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.noober.background.view.BLTextView;
import com.transsion.baseui.R$id;
import com.transsion.baseui.widget.DrawableCenterTextView;

/* loaded from: classes5.dex */
public final class h implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16693a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f16694b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f16695c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f16696d;

    /* renamed from: e, reason: collision with root package name */
    public final DrawableCenterTextView f16697e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f16698f;

    private h(FrameLayout frameLayout, TextView textView, BLTextView bLTextView, TextView textView2, DrawableCenterTextView drawableCenterTextView, TextView textView3) {
        this.f16693a = frameLayout;
        this.f16694b = textView;
        this.f16695c = bLTextView;
        this.f16696d = textView2;
        this.f16697e = drawableCenterTextView;
        this.f16698f = textView3;
    }

    public static h a(View view) {
        int i11 = R$id.card_detail;
        TextView textView = (TextView) g4.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.card_tip;
            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.card_title;
                TextView textView2 = (TextView) g4.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.iv_centerView;
                    DrawableCenterTextView drawableCenterTextView = (DrawableCenterTextView) g4.b.a(view, i11);
                    if (drawableCenterTextView != null) {
                        i11 = R$id.numText;
                        TextView textView3 = (TextView) g4.b.a(view, i11);
                        if (textView3 != null) {
                            return new h((FrameLayout) view, textView, bLTextView, textView2, drawableCenterTextView, textView3);
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
        return this.f16693a;
    }
}
