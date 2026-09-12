package qn;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import ao.e;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.video.NineGridItemView;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.g;
import com.transsion.player.ui.ORPlayerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final C0924a f73770i = new C0924a(null);

    /* renamed from: a, reason: collision with root package name */
    private final g f73771a;

    /* renamed from: b, reason: collision with root package name */
    private final ORPlayerView f73772b;

    /* renamed from: d, reason: collision with root package name */
    private int f73774d;

    /* renamed from: e, reason: collision with root package name */
    private PostSubjectItem f73775e;

    /* renamed from: f, reason: collision with root package name */
    private View f73776f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f73777g;

    /* renamed from: c, reason: collision with root package name */
    private int f73773c = -1;

    /* renamed from: h, reason: collision with root package name */
    private final Map f73778h = new LinkedHashMap();

    /* renamed from: qn.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0924a {
        private C0924a() {
        }

        public /* synthetic */ C0924a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(g gVar, ORPlayerView oRPlayerView) {
        this.f73771a = gVar;
        this.f73772b = oRPlayerView;
    }

    private final void A(NineGridItemView nineGridItemView) {
        ShapeableImageView shapeableImageView = nineGridItemView != null ? (ShapeableImageView) nineGridItemView.findViewById(R$id.video_cover) : null;
        FrameLayout frameLayout = nineGridItemView != null ? (FrameLayout) nineGridItemView.findViewById(R$id.video_container) : null;
        ORPlayerView oRPlayerView = this.f73772b;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) parent;
            frameLayout2.removeView(this.f73772b);
            ViewParent parent2 = frameLayout2.getParent();
            if (parent2 instanceof FrameLayout) {
                FrameLayout frameLayout3 = (FrameLayout) parent2;
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) frameLayout3.findViewById(R$id.video_cover);
                if (shapeableImageView2 != null) {
                    jg.c.k(shapeableImageView2);
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) frameLayout3.findViewById(R$id.label_gif);
                if (appCompatImageView != null) {
                    jg.c.k(appCompatImageView);
                }
            }
        }
        ORPlayerView oRPlayerView2 = this.f73772b;
        if (oRPlayerView2 != null) {
            oRPlayerView2.setId(R$id.player_view);
        }
        ORPlayerView oRPlayerView3 = this.f73772b;
        if (oRPlayerView3 != null) {
            oRPlayerView3.setLayoutParams(new FrameLayout.LayoutParams(shapeableImageView != null ? shapeableImageView.getWidth() : 0, shapeableImageView != null ? shapeableImageView.getHeight() : 0));
        }
        if (frameLayout != null) {
            frameLayout.addView(this.f73772b);
        }
        if (nineGridItemView != null) {
            nineGridItemView.requestLayout();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if ((r2.length() > 0) == true) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int c(com.transsion.moviedetailapi.bean.Media r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto Le
            java.util.List r1 = r6.getImage()
            if (r1 == 0) goto Le
            int r1 = r1.size()
            goto Lf
        Le:
            r1 = r0
        Lf:
            if (r1 <= 0) goto L52
            if (r6 == 0) goto L52
            java.util.List r6 = r6.getImage()
            if (r6 == 0) goto L52
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            r1 = r0
        L20:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L52
            java.lang.Object r2 = r6.next()
            int r3 = r1 + 1
            if (r1 >= 0) goto L31
            kotlin.collections.CollectionsKt.u()
        L31:
            com.transsion.moviedetailapi.bean.Image r2 = (com.transsion.moviedetailapi.bean.Image) r2
            com.transsion.moviedetailapi.bean.GifBean r2 = r2.getGifBean()
            if (r2 == 0) goto L4c
            java.lang.String r2 = r2.getVideoUrl()
            if (r2 == 0) goto L4c
            int r2 = r2.length()
            r4 = 1
            if (r2 <= 0) goto L48
            r2 = r4
            goto L49
        L48:
            r2 = r0
        L49:
            if (r2 != r4) goto L4c
            goto L4d
        L4c:
            r4 = r0
        L4d:
            if (r4 == 0) goto L50
            return r1
        L50:
            r1 = r3
            goto L20
        L52:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: qn.a.c(com.transsion.moviedetailapi.bean.Media):int");
    }

    private final NineGridItemView d(Media media, View view) {
        List<Image> image;
        String videoUrl;
        if (media == null || (image = media.getImage()) == null) {
            return null;
        }
        int i11 = 0;
        for (Object obj : image) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            GifBean gifBean = ((Image) obj).getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                NineGridItemView k11 = k(view, i11);
                if (o(k11)) {
                    this.f73774d = i11;
                    return k11;
                }
            }
            i11 = i12;
        }
        return null;
    }

    private final int g(Media media) {
        List<Image> image;
        Image image2;
        GifBean gifBean;
        String videoUrl;
        List<Image> image3;
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (size > 0) {
            for (int i11 = size - 1; -1 < i11; i11--) {
                if (media != null && (image = media.getImage()) != null && (image2 = image.get(i11)) != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    return i11;
                }
            }
        }
        return -1;
    }

    private final int i(Media media, int i11) {
        List<Image> image;
        GifBean gifBean;
        String videoUrl;
        if (i11 == g(media)) {
            return c(media);
        }
        if (media == null || (image = media.getImage()) == null) {
            return -1;
        }
        int i12 = 0;
        for (Object obj : image) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            Image image2 = (Image) obj;
            if (i11 < i12 && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                return i12;
            }
            i12 = i13;
        }
        return -1;
    }

    private final String j(Media media, int i11) {
        List<Image> image;
        Image image2;
        GifBean gifBean;
        List<Image> image3;
        int i12 = i(media, i11);
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (i12 < 0 || i12 >= size || i12 == this.f73774d || media == null || (image = media.getImage()) == null || (image2 = image.get(i12)) == null || (gifBean = image2.getGifBean()) == null) {
            return null;
        }
        return gifBean.getVideoUrl();
    }

    private final NineGridItemView k(View view, int i11) {
        NineGridVideoView nineGridVideoView = view != null ? (NineGridVideoView) view.findViewById(R$id.nine_grid) : null;
        int childCount = nineGridVideoView != null ? nineGridVideoView.getChildCount() : 0;
        if (i11 >= 0 && i11 < childCount) {
            View childAt = nineGridVideoView != null ? nineGridVideoView.getChildAt(i11) : null;
            if (childAt instanceof NineGridItemView) {
                return (NineGridItemView) childAt;
            }
        }
        return null;
    }

    private final void m(NineGridItemView nineGridItemView) {
        AppCompatImageView appCompatImageView;
        ShapeableImageView shapeableImageView;
        if (nineGridItemView != null && (shapeableImageView = (ShapeableImageView) nineGridItemView.findViewById(R$id.video_cover)) != null) {
            jg.c.g(shapeableImageView);
        }
        if (nineGridItemView == null || (appCompatImageView = (AppCompatImageView) nineGridItemView.findViewById(R$id.label_gif)) == null) {
            return;
        }
        jg.c.h(appCompatImageView);
    }

    private final void t(GifBean gifBean, NineGridItemView nineGridItemView, boolean z10) {
        if (nineGridItemView == null) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "ItemChangeListener", "play url = " + gifBean.getVideoUrl(), false, 4, null);
        A(nineGridItemView);
        g gVar = this.f73771a;
        if (gVar != null) {
            String videoUrl = gifBean.getVideoUrl();
            String str = videoUrl == null ? "" : videoUrl;
            String videoUrl2 = gifBean.getVideoUrl();
            if (videoUrl2 == null) {
                videoUrl2 = "";
            }
            gVar.setDataSource(new e(str, videoUrl2, 0, null, null, 28, null));
        }
        g gVar2 = this.f73771a;
        if (gVar2 != null) {
            gVar2.prepare();
        }
        g gVar3 = this.f73771a;
        if (gVar3 != null) {
            gVar3.play();
        }
        g gVar4 = this.f73771a;
        if (gVar4 != null) {
            gVar4.setLooping(z10);
        }
    }

    private final void u(Media media) {
        int e11 = e(media) - 1;
        for (int i11 = 0; i11 < e11; i11++) {
            String j11 = j(media, this.f73774d + i11);
            if (j11 != null && j11.length() > 0) {
                ORPlayerPreloadManager.f48463i.a().j(j11, com.transsion.ninegridview.a.f47724h.a().l());
            }
        }
    }

    private final void z(View view) {
        ORPlayerView oRPlayerView = view != null ? (ORPlayerView) view.findViewById(R$id.player_view) : null;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent;
            frameLayout.removeView(oRPlayerView);
            ViewParent parent2 = frameLayout.getParent();
            if (parent2 instanceof FrameLayout) {
                FrameLayout frameLayout2 = (FrameLayout) parent2;
                ShapeableImageView shapeableImageView = (ShapeableImageView) frameLayout2.findViewById(R$id.video_cover);
                if (shapeableImageView != null) {
                    jg.c.k(shapeableImageView);
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) frameLayout2.findViewById(R$id.label_gif);
                if (appCompatImageView != null) {
                    jg.c.k(appCompatImageView);
                }
            }
        }
    }

    public final void a() {
        this.f73773c = -1;
        this.f73774d = 0;
        this.f73775e = null;
        this.f73776f = null;
        ORPlayerPreloadManager.f48463i.a().c();
    }

    public final int b() {
        return this.f73773c;
    }

    public final int e(Media media) {
        List<Image> image;
        GifBean gifBean;
        String videoUrl;
        int i11 = 0;
        if (Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue()) && (image = media.getImage()) != null) {
            for (Image image2 : image) {
                if (image2.getGifBean() != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    i11++;
                }
            }
        }
        return i11;
    }

    public final int f() {
        return this.f73774d;
    }

    public final float h(NineGridVideoView nineGridView, Media media) {
        List<Image> image;
        Image image2;
        List<Image> image3;
        Intrinsics.h(nineGridView, "nineGridView");
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = i(media, i11);
            if (i12 < 0 || i12 >= size) {
                break;
            }
            GifBean gifBean = (media == null || (image = media.getImage()) == null || (image2 = image.get(i12)) == null) ? null : image2.getGifBean();
            if (gifBean != null && gifBean.getVideoUrl() != null) {
                NineGridItemView k11 = k(nineGridView, i12);
                if (k11 == null) {
                    return f11;
                }
                float l11 = l(k11);
                if (f11 < l11) {
                    f11 = l11;
                }
            }
        }
        return f11;
    }

    public final float l(View view) {
        Intrinsics.h(view, "view");
        if (!view.getGlobalVisibleRect(new Rect())) {
            return 0.0f;
        }
        return (r0.height() * 1.0f) / (view.getHeight() * 1.0f);
    }

    public final boolean n() {
        g gVar = this.f73771a;
        if (gVar != null) {
            return gVar.isPlaying();
        }
        return false;
    }

    public final boolean o(View view) {
        if (view == null) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            if ((r1.height() * 1.0f) / (view.getHeight() * 1.0f) > 0.5f) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        m(k(this.f73776f, this.f73774d));
    }

    public void q() {
        String videoUrl;
        List<Image> image;
        Image image2;
        List<Image> image3;
        PostSubjectItem postSubjectItem = this.f73775e;
        Media media = postSubjectItem != null ? postSubjectItem.getMedia() : null;
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        int e11 = e(media);
        while (size > 0) {
            int i11 = i(media, this.f73774d);
            this.f73774d = i11;
            if (i11 < 0 || i11 >= size) {
                return;
            }
            GifBean gifBean = (media == null || (image = media.getImage()) == null || (image2 = image.get(this.f73774d)) == null) ? null : image2.getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null) {
                NineGridItemView k11 = k(this.f73776f, this.f73774d);
                if (o(k11) || this.f73777g) {
                    t(gifBean, k11, size == 1);
                    this.f73778h.put(videoUrl, Boolean.TRUE);
                    return;
                }
                this.f73778h.put(videoUrl, Boolean.FALSE);
            }
            if (!this.f73778h.containsValue(Boolean.TRUE) && this.f73778h.size() >= e11) {
                this.f73773c = -1;
                g gVar = this.f73771a;
                if (gVar == null || !gVar.isPlaying()) {
                    return;
                }
                this.f73771a.pause();
                return;
            }
        }
    }

    public void r() {
        g gVar = this.f73771a;
        if (gVar != null && gVar.isPlaying()) {
            this.f73771a.pause();
            z(this.f73776f);
        }
        a();
    }

    public void s(PostSubjectItem postSubjectItem, View view, int i11) {
        String videoUrl;
        Image image;
        this.f73776f = view;
        GifBean gifBean = null;
        Media media = postSubjectItem != null ? postSubjectItem.getMedia() : null;
        ORPlayerPreloadManager.f48463i.a().h();
        this.f73778h.clear();
        if (Intrinsics.c(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue())) {
            List<Image> image2 = media.getImage();
            int size = image2 != null ? image2.size() : 0;
            NineGridItemView d11 = d(postSubjectItem.getMedia(), view);
            int i12 = this.f73774d;
            if (i12 < 0 || i12 >= size) {
                return;
            }
            List<Image> image3 = media.getImage();
            if (image3 != null && (image = image3.get(this.f73774d)) != null) {
                gifBean = image.getGifBean();
            }
            if (gifBean == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
                return;
            }
            t(gifBean, d11, e(media) == 1);
            this.f73773c = i11;
            this.f73775e = postSubjectItem;
            if (size > 1) {
                u(media);
            }
        }
    }

    public final void v(Media media) {
        List<Image> image;
        Image image2;
        GifBean gifBean;
        List<Image> image3;
        int c11 = c(media);
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (c11 < 0 || c11 >= size) {
            return;
        }
        String videoUrl = (media == null || (image = media.getImage()) == null || (image2 = image.get(c11)) == null || (gifBean = image2.getGifBean()) == null) ? null : gifBean.getVideoUrl();
        if (videoUrl == null || videoUrl.length() <= 0) {
            return;
        }
        ORPlayerPreloadManager.f48463i.a().j(videoUrl, com.transsion.ninegridview.a.f47724h.a().l());
    }

    public final void w() {
        s(this.f73775e, this.f73776f, this.f73773c);
    }

    public final void x(int i11) {
        this.f73773c = i11;
    }

    public final void y(boolean z10) {
        this.f73777g = z10;
    }
}
