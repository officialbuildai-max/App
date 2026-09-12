package ho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.transsion.ad.view.CustomRoundCornerLayout;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.intercept.PlaybackInterceptAdView;
import com.transsion.player.longvideo.intercept.PlaybackPremiumTipView;
import com.transsion.player.longvideo.intercept.VideoContentInterceptView;
import com.transsion.player.ui.longvideo.ORLongVodPlayerView;

/* loaded from: classes6.dex */
public final class j implements g4.a {

    /* renamed from: a, reason: collision with root package name */
    private final View f64734a;

    /* renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f64735b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f64736c;

    /* renamed from: d, reason: collision with root package name */
    public final CustomRoundCornerLayout f64737d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f64738e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayoutCompat f64739f;

    /* renamed from: g, reason: collision with root package name */
    public final View f64740g;

    /* renamed from: h, reason: collision with root package name */
    public final k f64741h;

    /* renamed from: i, reason: collision with root package name */
    public final l f64742i;

    /* renamed from: j, reason: collision with root package name */
    public final i f64743j;

    /* renamed from: k, reason: collision with root package name */
    public final AppCompatImageView f64744k;

    /* renamed from: l, reason: collision with root package name */
    public final View f64745l;

    /* renamed from: m, reason: collision with root package name */
    public final ORLongVodPlayerView f64746m;

    /* renamed from: n, reason: collision with root package name */
    public final VideoContentInterceptView f64747n;

    /* renamed from: o, reason: collision with root package name */
    public final PlaybackPremiumTipView f64748o;

    /* renamed from: p, reason: collision with root package name */
    public final PlaybackInterceptAdView f64749p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f64750q;

    /* renamed from: r, reason: collision with root package name */
    public final AppCompatTextView f64751r;

    /* renamed from: s, reason: collision with root package name */
    public final SimpleSubtitleView f64752s;

    /* renamed from: t, reason: collision with root package name */
    public final SimpleSubtitleView f64753t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f64754u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewStub f64755v;

    /* renamed from: w, reason: collision with root package name */
    public final ViewStub f64756w;

    /* renamed from: x, reason: collision with root package name */
    public final ViewStub f64757x;

    /* renamed from: y, reason: collision with root package name */
    public final ViewStub f64758y;

    private j(View view, ConstraintLayout constraintLayout, FrameLayout frameLayout, CustomRoundCornerLayout customRoundCornerLayout, FrameLayout frameLayout2, LinearLayoutCompat linearLayoutCompat, View view2, k kVar, l lVar, i iVar, AppCompatImageView appCompatImageView, View view3, ORLongVodPlayerView oRLongVodPlayerView, VideoContentInterceptView videoContentInterceptView, PlaybackPremiumTipView playbackPremiumTipView, PlaybackInterceptAdView playbackInterceptAdView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, ImageView imageView, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4) {
        this.f64734a = view;
        this.f64735b = constraintLayout;
        this.f64736c = frameLayout;
        this.f64737d = customRoundCornerLayout;
        this.f64738e = frameLayout2;
        this.f64739f = linearLayoutCompat;
        this.f64740g = view2;
        this.f64741h = kVar;
        this.f64742i = lVar;
        this.f64743j = iVar;
        this.f64744k = appCompatImageView;
        this.f64745l = view3;
        this.f64746m = oRLongVodPlayerView;
        this.f64747n = videoContentInterceptView;
        this.f64748o = playbackPremiumTipView;
        this.f64749p = playbackInterceptAdView;
        this.f64750q = appCompatTextView;
        this.f64751r = appCompatTextView2;
        this.f64752s = simpleSubtitleView;
        this.f64753t = simpleSubtitleView2;
        this.f64754u = imageView;
        this.f64755v = viewStub;
        this.f64756w = viewStub2;
        this.f64757x = viewStub3;
        this.f64758y = viewStub4;
    }

    public static j a(View view) {
        View a11;
        View a12;
        View a13;
        int i11 = R$id.clPlayer;
        ConstraintLayout constraintLayout = (ConstraintLayout) g4.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.flLandscapePremium;
            FrameLayout frameLayout = (FrameLayout) g4.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.flResolution;
                CustomRoundCornerLayout customRoundCornerLayout = (CustomRoundCornerLayout) g4.b.a(view, i11);
                if (customRoundCornerLayout != null) {
                    i11 = R$id.flRootSubtitle;
                    FrameLayout frameLayout2 = (FrameLayout) g4.b.a(view, i11);
                    if (frameLayout2 != null) {
                        i11 = R$id.flSubtitle;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) g4.b.a(view, i11);
                        if (linearLayoutCompat != null && (a11 = g4.b.a(view, (i11 = R$id.guideline))) != null && (a12 = g4.b.a(view, (i11 = R$id.layout_land))) != null) {
                            k a14 = k.a(a12);
                            i11 = R$id.layout_middle;
                            View a15 = g4.b.a(view, i11);
                            if (a15 != null) {
                                l a16 = l.a(a15);
                                i11 = R$id.layout_top_tool_bar;
                                View a17 = g4.b.a(view, i11);
                                if (a17 != null) {
                                    i a18 = i.a(a17);
                                    i11 = R$id.or_long_vod_iv_bg;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) g4.b.a(view, i11);
                                    if (appCompatImageView != null && (a13 = g4.b.a(view, (i11 = R$id.or_long_vod_player_bg))) != null) {
                                        i11 = R$id.or_long_vod_view;
                                        ORLongVodPlayerView oRLongVodPlayerView = (ORLongVodPlayerView) g4.b.a(view, i11);
                                        if (oRLongVodPlayerView != null) {
                                            i11 = R$id.playbackInterceptView;
                                            VideoContentInterceptView videoContentInterceptView = (VideoContentInterceptView) g4.b.a(view, i11);
                                            if (videoContentInterceptView != null) {
                                                i11 = R$id.premiumTipView;
                                                PlaybackPremiumTipView playbackPremiumTipView = (PlaybackPremiumTipView) g4.b.a(view, i11);
                                                if (playbackPremiumTipView != null) {
                                                    i11 = R$id.startInterceptView;
                                                    PlaybackInterceptAdView playbackInterceptAdView = (PlaybackInterceptAdView) g4.b.a(view, i11);
                                                    if (playbackInterceptAdView != null) {
                                                        i11 = R$id.tv_center_progress;
                                                        AppCompatTextView appCompatTextView = (AppCompatTextView) g4.b.a(view, i11);
                                                        if (appCompatTextView != null) {
                                                            i11 = R$id.tvPressSpeed;
                                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) g4.b.a(view, i11);
                                                            if (appCompatTextView2 != null) {
                                                                i11 = R$id.vSubtitleBottom;
                                                                SimpleSubtitleView simpleSubtitleView = (SimpleSubtitleView) g4.b.a(view, i11);
                                                                if (simpleSubtitleView != null) {
                                                                    i11 = R$id.vSubtitleTop;
                                                                    SimpleSubtitleView simpleSubtitleView2 = (SimpleSubtitleView) g4.b.a(view, i11);
                                                                    if (simpleSubtitleView2 != null) {
                                                                        i11 = R$id.v_top_space;
                                                                        ImageView imageView = (ImageView) g4.b.a(view, i11);
                                                                        if (imageView != null) {
                                                                            i11 = R$id.vs_load_fail;
                                                                            ViewStub viewStub = (ViewStub) g4.b.a(view, i11);
                                                                            if (viewStub != null) {
                                                                                i11 = R$id.vs_mobile_data;
                                                                                ViewStub viewStub2 = (ViewStub) g4.b.a(view, i11);
                                                                                if (viewStub2 != null) {
                                                                                    i11 = R$id.vs_replay;
                                                                                    ViewStub viewStub3 = (ViewStub) g4.b.a(view, i11);
                                                                                    if (viewStub3 != null) {
                                                                                        i11 = R$id.vs_toast;
                                                                                        ViewStub viewStub4 = (ViewStub) g4.b.a(view, i11);
                                                                                        if (viewStub4 != null) {
                                                                                            return new j(view, constraintLayout, frameLayout, customRoundCornerLayout, frameLayout2, linearLayoutCompat, a11, a14, a16, a18, appCompatImageView, a13, oRLongVodPlayerView, videoContentInterceptView, playbackPremiumTipView, playbackInterceptAdView, appCompatTextView, appCompatTextView2, simpleSubtitleView, simpleSubtitleView2, imageView, viewStub, viewStub2, viewStub3, viewStub4);
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

    public static j b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.long_vod_view_player, viewGroup);
        return a(viewGroup);
    }

    @Override // g4.a
    public View getRoot() {
        return this.f64734a;
    }
}
