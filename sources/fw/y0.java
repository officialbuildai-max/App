package fw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: classes7.dex */
public final class y0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63128a;

    /* renamed from: b, reason: collision with root package name */
    public final BLView f63129b;

    /* renamed from: c, reason: collision with root package name */
    public final BLView f63130c;

    /* renamed from: d, reason: collision with root package name */
    public final BLView f63131d;

    /* renamed from: e, reason: collision with root package name */
    public final BLView f63132e;

    /* renamed from: f, reason: collision with root package name */
    public final BLView f63133f;

    /* renamed from: g, reason: collision with root package name */
    public final BLView f63134g;

    /* renamed from: h, reason: collision with root package name */
    public final BLView f63135h;

    /* renamed from: i, reason: collision with root package name */
    public final BLView f63136i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f63137j;

    /* renamed from: k, reason: collision with root package name */
    public final BLView f63138k;

    private y0(ConstraintLayout constraintLayout, BLView bLView, BLView bLView2, BLView bLView3, BLView bLView4, BLView bLView5, BLView bLView6, BLView bLView7, BLView bLView8, TextView textView, BLView bLView9) {
        this.f63128a = constraintLayout;
        this.f63129b = bLView;
        this.f63130c = bLView2;
        this.f63131d = bLView3;
        this.f63132e = bLView4;
        this.f63133f = bLView5;
        this.f63134g = bLView6;
        this.f63135h = bLView7;
        this.f63136i = bLView8;
        this.f63137j = textView;
        this.f63138k = bLView9;
    }

    public static y0 a(View view) {
        int i11 = R$id.avatarSkeleton;
        BLView bLView = (BLView) g4.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.expirySkeleton;
            BLView bLView2 = (BLView) g4.b.a(view, i11);
            if (bLView2 != null) {
                i11 = R$id.firstDeviceSkeleton;
                BLView bLView3 = (BLView) g4.b.a(view, i11);
                if (bLView3 != null) {
                    i11 = R$id.listTitleSkeleton;
                    BLView bLView4 = (BLView) g4.b.a(view, i11);
                    if (bLView4 != null) {
                        i11 = R$id.middleCardSkeleton;
                        BLView bLView5 = (BLView) g4.b.a(view, i11);
                        if (bLView5 != null) {
                            i11 = R$id.nameSkeleton;
                            BLView bLView6 = (BLView) g4.b.a(view, i11);
                            if (bLView6 != null) {
                                i11 = R$id.secondDeviceSkeleton;
                                BLView bLView7 = (BLView) g4.b.a(view, i11);
                                if (bLView7 != null) {
                                    i11 = R$id.thirdDeviceSkeleton;
                                    BLView bLView8 = (BLView) g4.b.a(view, i11);
                                    if (bLView8 != null) {
                                        i11 = R$id.titleSkeleton;
                                        TextView textView = (TextView) g4.b.a(view, i11);
                                        if (textView != null) {
                                            i11 = R$id.userCardSkeleton;
                                            BLView bLView9 = (BLView) g4.b.a(view, i11);
                                            if (bLView9 != null) {
                                                return new y0((ConstraintLayout) view, bLView, bLView2, bLView3, bLView4, bLView5, bLView6, bLView7, bLView8, textView, bLView9);
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

    public static y0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.layout_device_management_loading, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63128a;
    }
}
