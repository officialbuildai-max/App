package com.transsion.ninegridview.preview;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.y;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$id;
import com.transsion.photoview.PhotoView;
import com.transsion.player.ui.ORPlayerView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r extends ch.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.transsion.player.orplayer.g f47794a;

    /* renamed from: b, reason: collision with root package name */
    private final ORPlayerView f47795b;

    /* renamed from: c, reason: collision with root package name */
    private int f47796c;

    /* renamed from: d, reason: collision with root package name */
    private View f47797d;

    /* renamed from: e, reason: collision with root package name */
    private Image f47798e;

    public r(com.transsion.player.orplayer.g player, ORPlayerView playerView) {
        Intrinsics.h(player, "player");
        Intrinsics.h(playerView, "playerView");
        this.f47794a = player;
        this.f47795b = playerView;
        this.f47796c = -1;
    }

    private final void e(View view) {
        PhotoView photoView = view != null ? (PhotoView) view.findViewById(R$id.video_cover) : null;
        if (photoView != null) {
            jg.c.g(photoView);
        }
    }

    private final void h(GifBean gifBean, View view, boolean z10) {
        i(view);
        com.transsion.player.orplayer.g gVar = this.f47794a;
        String videoUrl = gifBean.getVideoUrl();
        String str = videoUrl == null ? "" : videoUrl;
        String videoUrl2 = gifBean.getVideoUrl();
        if (videoUrl2 == null) {
            videoUrl2 = "";
        }
        gVar.setDataSource(new ao.e(str, videoUrl2, 0, null, null, 28, null));
        this.f47794a.prepare();
        this.f47794a.play();
        this.f47794a.setLooping(z10);
    }

    private final void i(View view) {
        Integer height;
        Integer width;
        PhotoView photoView;
        FrameLayout frameLayout = view != null ? (FrameLayout) view.findViewById(R$id.video_container) : null;
        ViewParent parent = this.f47795b.getParent();
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) parent;
            frameLayout2.removeView(this.f47795b);
            ViewParent parent2 = frameLayout2.getParent();
            if ((parent2 instanceof FrameLayout) && (photoView = (PhotoView) ((FrameLayout) parent2).findViewById(R$id.video_cover)) != null) {
                jg.c.k(photoView);
            }
        }
        this.f47795b.setId(R$id.player_view);
        Image image = this.f47798e;
        float e11 = (image == null || (width = image.getWidth()) == null) ? y.e() : width.intValue();
        Image image2 = this.f47798e;
        float c11 = (image2 == null || (height = image2.getHeight()) == null) ? y.c() : height.intValue();
        float e12 = y.e();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) e12, (int) ((c11 / e11) * e12));
        layoutParams.gravity = 17;
        this.f47795b.setLayoutParams(layoutParams);
        if (frameLayout != null) {
            frameLayout.addView(this.f47795b);
        }
    }

    @Override // ch.a
    public void c(boolean z10, int i11, View view) {
    }

    public final void f(int i11, Image image, View view) {
        String videoUrl;
        this.f47796c = i11;
        this.f47797d = view;
        this.f47798e = image;
        GifBean gifBean = image != null ? image.getGifBean() : null;
        if (gifBean == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
            return;
        }
        h(gifBean, view, true);
    }

    public void g() {
        e(this.f47797d);
    }
}
