package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.ui.LongVodPlayerView;

/* loaded from: classes6.dex */
public final class o implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f64810a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f64811b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f64812c;

    /* renamed from: d, reason: collision with root package name */
    public final h f64813d;

    /* renamed from: e, reason: collision with root package name */
    public final LongVodPlayerView f64814e;

    private o(ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, h hVar, LongVodPlayerView longVodPlayerView) {
        this.f64810a = constraintLayout;
        this.f64811b = frameLayout;
        this.f64812c = frameLayout2;
        this.f64813d = hVar;
        this.f64814e = longVodPlayerView;
    }

    public static o a(View view) {
        View a11;
        int i11 = R$id.fl_full_player_container;
        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.fl_player_container;
            FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout2 != null && (a11 = g4.b.a(view, (i11 = R$id.layout_sync_adjust))) != null) {
                h a12 = h.a(a11);
                i11 = R$id.player_view;
                LongVodPlayerView longVodPlayerView = (LongVodPlayerView) g4.b.a(view, i11);
                if (longVodPlayerView != null) {
                    return new o((ConstraintLayout) view, frameLayout, frameLayout2, a12, longVodPlayerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.test_fragment_long_vod, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64810a;
    }
}
