package qv;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: classes7.dex */
public final class p implements g4.a {
    public final View A;
    public final View B;

    /* renamed from: a, reason: collision with root package name */
    private final View f73946a;

    /* renamed from: b, reason: collision with root package name */
    public final Barrier f73947b;

    /* renamed from: c, reason: collision with root package name */
    public final BLTextView f73948c;

    /* renamed from: d, reason: collision with root package name */
    public final Group f73949d;

    /* renamed from: e, reason: collision with root package name */
    public final Group f73950e;

    /* renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f73951f;

    /* renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f73952g;

    /* renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f73953h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeableImageView f73954i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f73955j;

    /* renamed from: k, reason: collision with root package name */
    public final ProgressBar f73956k;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f73957l;

    /* renamed from: m, reason: collision with root package name */
    public final AppCompatTextView f73958m;

    /* renamed from: n, reason: collision with root package name */
    public final BLTextView f73959n;

    /* renamed from: o, reason: collision with root package name */
    public final AppCompatTextView f73960o;

    /* renamed from: p, reason: collision with root package name */
    public final AppCompatTextView f73961p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f73962q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f73963r;

    /* renamed from: s, reason: collision with root package name */
    public final BLTextView f73964s;

    /* renamed from: t, reason: collision with root package name */
    public final BLTextView f73965t;

    /* renamed from: u, reason: collision with root package name */
    public final AppCompatTextView f73966u;

    /* renamed from: v, reason: collision with root package name */
    public final AppCompatTextView f73967v;

    /* renamed from: w, reason: collision with root package name */
    public final AppCompatTextView f73968w;

    /* renamed from: x, reason: collision with root package name */
    public final AppCompatTextView f73969x;

    /* renamed from: y, reason: collision with root package name */
    public final AppCompatTextView f73970y;

    /* renamed from: z, reason: collision with root package name */
    public final AppCompatTextView f73971z;

    private p(View view, Barrier barrier, BLTextView bLTextView, Group group, Group group2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ShapeableImageView shapeableImageView, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, BLTextView bLTextView2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView3, BLTextView bLTextView4, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, View view2, View view3) {
        this.f73946a = view;
        this.f73947b = barrier;
        this.f73948c = bLTextView;
        this.f73949d = group;
        this.f73950e = group2;
        this.f73951f = appCompatImageView;
        this.f73952g = appCompatImageView2;
        this.f73953h = appCompatImageView3;
        this.f73954i = shapeableImageView;
        this.f73955j = linearLayout;
        this.f73956k = progressBar;
        this.f73957l = recyclerView;
        this.f73958m = appCompatTextView;
        this.f73959n = bLTextView2;
        this.f73960o = appCompatTextView2;
        this.f73961p = appCompatTextView3;
        this.f73962q = appCompatTextView4;
        this.f73963r = appCompatTextView5;
        this.f73964s = bLTextView3;
        this.f73965t = bLTextView4;
        this.f73966u = appCompatTextView6;
        this.f73967v = appCompatTextView7;
        this.f73968w = appCompatTextView8;
        this.f73969x = appCompatTextView9;
        this.f73970y = appCompatTextView10;
        this.f73971z = appCompatTextView11;
        this.A = view2;
        this.B = view3;
    }

    public static p a(View view) {
        View a11;
        View a12;
        int i11 = R$id.barrierButtons;
        Barrier barrier = (Barrier) g4.b.a(view, i11);
        if (barrier != null) {
            i11 = R$id.bgAutoplay;
            BLTextView bLTextView = (BLTextView) g4.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.groupAutoplay;
                Group group = (Group) g4.b.a(view, i11);
                if (group != null) {
                    i11 = R$id.groupStandardButtons;
                    Group group2 = (Group) g4.b.a(view, i11);
                    if (group2 != null) {
                        i11 = R$id.ivAutoplayClose;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.ivAutoplayIcon;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) g4.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.ivPostType;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) g4.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.ivUserCover;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) g4.b.a(view, i11);
                                    if (shapeableImageView != null) {
                                        i11 = R$id.llKidsModeButtons;
                                        LinearLayout linearLayout = (LinearLayout) g4.b.a(view, i11);
                                        if (linearLayout != null) {
                                            i11 = R$id.pbSubscribeLoading;
                                            ProgressBar progressBar = (ProgressBar) g4.b.a(view, i11);
                                            if (progressBar != null) {
                                                i11 = R$id.recyclerTag;
                                                RecyclerView recyclerView = (RecyclerView) g4.b.a(view, i11);
                                                if (recyclerView != null) {
                                                    i11 = R$id.tvAddList;
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                    if (appCompatTextView != null) {
                                                        i11 = R$id.tvAutoplayGo;
                                                        BLTextView bLTextView2 = (BLTextView) g4.b.a(view, i11);
                                                        if (bLTextView2 != null) {
                                                            i11 = R$id.tvAutoplayText;
                                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView2 != null) {
                                                                i11 = R$id.tvDes;
                                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) g4.b.a(view, i11);
                                                                if (appCompatTextView3 != null) {
                                                                    i11 = R$id.tvDetailMore;
                                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) g4.b.a(view, i11);
                                                                    if (appCompatTextView4 != null) {
                                                                        i11 = R$id.tvDownload;
                                                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) g4.b.a(view, i11);
                                                                        if (appCompatTextView5 != null) {
                                                                            i11 = R$id.tvDownloadKids;
                                                                            BLTextView bLTextView3 = (BLTextView) g4.b.a(view, i11);
                                                                            if (bLTextView3 != null) {
                                                                                i11 = R$id.tvFollow;
                                                                                BLTextView bLTextView4 = (BLTextView) g4.b.a(view, i11);
                                                                                if (bLTextView4 != null) {
                                                                                    i11 = R$id.tvLike;
                                                                                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                    if (appCompatTextView6 != null) {
                                                                                        i11 = R$id.tvShare;
                                                                                        AppCompatTextView appCompatTextView7 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                        if (appCompatTextView7 != null) {
                                                                                            i11 = R$id.tvTime;
                                                                                            AppCompatTextView appCompatTextView8 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                            if (appCompatTextView8 != null) {
                                                                                                i11 = R$id.tvTitle;
                                                                                                AppCompatTextView appCompatTextView9 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                if (appCompatTextView9 != null) {
                                                                                                    i11 = R$id.tvUsername;
                                                                                                    AppCompatTextView appCompatTextView10 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                    if (appCompatTextView10 != null) {
                                                                                                        i11 = R$id.tvViews;
                                                                                                        AppCompatTextView appCompatTextView11 = (AppCompatTextView) g4.b.a(view, i11);
                                                                                                        if (appCompatTextView11 != null && (a11 = g4.b.a(view, (i11 = R$id.vIconLine1))) != null && (a12 = g4.b.a(view, (i11 = R$id.vIconLine2))) != null) {
                                                                                                            return new p(view, barrier, bLTextView, group, group2, appCompatImageView, appCompatImageView2, appCompatImageView3, shapeableImageView, linearLayout, progressBar, recyclerView, appCompatTextView, bLTextView2, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, bLTextView3, bLTextView4, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, appCompatTextView11, a11, a12);
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
    public View getRoot() {
        return this.f73946a;
    }
}
