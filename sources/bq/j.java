package bq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transsion.room.R$layout;

/* loaded from: classes5.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f16857a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f16858b;

    private j(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f16857a = frameLayout;
        this.f16858b = frameLayout2;
    }

    public static j a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new j(frameLayout, frameLayout);
    }

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.activity_subscription_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f16857a;
    }
}
