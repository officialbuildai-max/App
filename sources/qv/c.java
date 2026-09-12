package qv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.noober.background.view.BLView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: classes7.dex */
public final class c implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f73839a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f73840b;

    /* renamed from: c, reason: collision with root package name */
    public final BLView f73841c;

    private c(FrameLayout frameLayout, FrameLayout frameLayout2, BLView bLView) {
        this.f73839a = frameLayout;
        this.f73840b = frameLayout2;
        this.f73841c = bLView;
    }

    public static c a(View view) {
        int i11 = R$id.flUgcImmContainer;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.vDragHandle;
            BLView bLView = (BLView) g4.b.a(view, i11);
            if (bLView != null) {
                return new c((FrameLayout) view, frameLayout, bLView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static c c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.dialog_ugc_imm_video_setting, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f73839a;
    }
}
