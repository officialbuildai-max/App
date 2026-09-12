package gh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tn.lib.tranpay.R$layout;

/* loaded from: classes4.dex */
public final class a implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f63700a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f63701b;

    private a(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f63700a = frameLayout;
        this.f63701b = frameLayout2;
    }

    public static a a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new a(frameLayout, frameLayout);
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.tran_activity_web_pay, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f63700a;
    }
}
