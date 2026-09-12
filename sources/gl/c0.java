package gl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* loaded from: classes6.dex */
public final class c0 implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f63773a;

    /* renamed from: b, reason: collision with root package name */
    public final View f63774b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f63775c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayout f63776d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f63777e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f63778f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f63779g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f63780h;

    /* renamed from: i, reason: collision with root package name */
    public final BLFrameLayout f63781i;

    /* renamed from: j, reason: collision with root package name */
    public final FrameLayout f63782j;

    /* renamed from: k, reason: collision with root package name */
    public final ProgressBar f63783k;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f63784l;

    /* renamed from: m, reason: collision with root package name */
    public final View f63785m;

    /* renamed from: n, reason: collision with root package name */
    public final LinearLayout f63786n;

    /* renamed from: o, reason: collision with root package name */
    public final View f63787o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f63788p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f63789q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f63790r;

    /* renamed from: s, reason: collision with root package name */
    public final ViewStub f63791s;

    private c0(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView, View view2, LinearLayout linearLayout4, View view3, TextView textView, TextView textView2, TextView textView3, ViewStub viewStub) {
        this.f63773a = constraintLayout;
        this.f63774b = view;
        this.f63775c = linearLayout;
        this.f63776d = linearLayout2;
        this.f63777e = linearLayout3;
        this.f63778f = imageView;
        this.f63779g = imageView2;
        this.f63780h = imageView3;
        this.f63781i = bLFrameLayout;
        this.f63782j = frameLayout;
        this.f63783k = progressBar;
        this.f63784l = recyclerView;
        this.f63785m = view2;
        this.f63786n = linearLayout4;
        this.f63787o = view3;
        this.f63788p = textView;
        this.f63789q = textView2;
        this.f63790r = textView3;
        this.f63791s = viewStub;
    }

    public static c0 a(View view) {
        View a11;
        View a12;
        int i11 = R$id.bottomGradient;
        View a13 = g4.b.a(view, i11);
        if (a13 != null) {
            i11 = R$id.btnHelp;
            LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
            if (linearLayout != null) {
                i11 = R$id.btnSetting;
                LinearLayout linearLayout2 = (LinearLayout) g4.b.a(view, i11);
                if (linearLayout2 != null) {
                    i11 = R$id.fsControls;
                    LinearLayout linearLayout3 = (LinearLayout) g4.b.a(view, i11);
                    if (linearLayout3 != null) {
                        i11 = R$id.ivBack;
                        ImageView imageView = (ImageView) g4.b.a(view, i11);
                        if (imageView != null) {
                            i11 = R$id.ivFullscreen;
                            ImageView imageView2 = (ImageView) g4.b.a(view, i11);
                            if (imageView2 != null) {
                                i11 = R$id.ivTapLock;
                                ImageView imageView3 = (ImageView) g4.b.a(view, i11);
                                if (imageView3 != null) {
                                    i11 = R$id.liveBadge;
                                    BLFrameLayout bLFrameLayout = (BLFrameLayout) g4.b.a(view, i11);
                                    if (bLFrameLayout != null) {
                                        i11 = R$id.playerLayout;
                                        FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
                                        if (frameLayout != null) {
                                            i11 = R$id.playerLoading;
                                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                            if (progressBar != null) {
                                                i11 = R$id.rvChannels;
                                                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                if (recyclerView != null && (a11 = g4.b.a(view, (i11 = R$id.statusBarPlaceholder))) != null) {
                                                    i11 = R$id.tapToLockLayout;
                                                    LinearLayout linearLayout4 = (LinearLayout) g4.b.a(view, i11);
                                                    if (linearLayout4 != null && (a12 = g4.b.a(view, (i11 = R$id.topGradient))) != null) {
                                                        i11 = R$id.tvChannelName;
                                                        TextView textView = (TextView) g4.b.a(view, i11);
                                                        if (textView != null) {
                                                            i11 = R$id.tvLiveBadge;
                                                            TextView textView2 = (TextView) g4.b.a(view, i11);
                                                            if (textView2 != null) {
                                                                i11 = R$id.tvTapToLock;
                                                                TextView textView3 = (TextView) g4.b.a(view, i11);
                                                                if (textView3 != null) {
                                                                    i11 = R$id.vsLoadFail;
                                                                    ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                                    if (viewStub != null) {
                                                                        return new c0((ConstraintLayout) view, a13, linearLayout, linearLayout2, linearLayout3, imageView, imageView2, imageView3, bLFrameLayout, frameLayout, progressBar, recyclerView, a11, linearLayout4, a12, textView, textView2, textView3, viewStub);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    public static c0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R$layout.fragment_tv_live_detail_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // g4.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f63773a;
    }
}
