package com.transsion.ugcvideodetail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.tn.lib.widget.R$color;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.preview.GifImagePreviewActivity;
import com.transsion.ugcvideodetail.R$layout;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoBelongToCollection;
import com.transsion.ugcvideodetail.api.bean.UGCVideoDescImage;
import com.transsion.ugcvideodetail.widget.UGCVideoDetailAboutCourseView;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qv.o;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006&"}, d2 = {"Lcom/transsion/ugcvideodetail/widget/UGCVideoDetailAboutCourseView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", TmcStartParams.KEY_URL_SHORT, "()V", "n", "w", "v", "y", "x", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;", "video", "setData", "(Lcom/transsion/ugcvideodetail/api/bean/UGCVideo;)V", "", "a", "Ljava/lang/String;", "TAG", "Lqv/o;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lqv/o;", "viewBinding", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoDescImage;", "c", "Lcom/transsion/ugcvideodetail/api/bean/UGCVideoDescImage;", "descImage", "d", "collectionDescImage", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class UGCVideoDetailAboutCourseView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final o viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private UGCVideoDescImage descImage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private UGCVideoDescImage collectionDescImage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCVideoDetailAboutCourseView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCVideoDetailAboutCourseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCVideoDetailAboutCourseView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "UGCVideoDetailAboutCourseView";
        View.inflate(context, R$layout.layout_ugc_video_detail_about_course, this);
        o a11 = o.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        u();
        n();
    }

    private final void n() {
        this.viewBinding.f73939d.setOnClickListener(new View.OnClickListener() { // from class: sv.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDetailAboutCourseView.o(UGCVideoDetailAboutCourseView.this, view);
            }
        });
        this.viewBinding.f73944i.setOnClickListener(new View.OnClickListener() { // from class: sv.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDetailAboutCourseView.p(UGCVideoDetailAboutCourseView.this, view);
            }
        });
        this.viewBinding.f73941f.setOnClickListener(new View.OnClickListener() { // from class: sv.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDetailAboutCourseView.q(UGCVideoDetailAboutCourseView.this, view);
            }
        });
        this.viewBinding.f73940e.setOnClickListener(new View.OnClickListener() { // from class: sv.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDetailAboutCourseView.r(UGCVideoDetailAboutCourseView.this, view);
            }
        });
        this.viewBinding.f73945j.setOnClickListener(new View.OnClickListener() { // from class: sv.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDetailAboutCourseView.s(UGCVideoDetailAboutCourseView.this, view);
            }
        });
        this.viewBinding.f73942g.setOnClickListener(new View.OnClickListener() { // from class: sv.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCVideoDetailAboutCourseView.t(UGCVideoDetailAboutCourseView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, View view) {
        uGCVideoDetailAboutCourseView.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, View view) {
        uGCVideoDetailAboutCourseView.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, View view) {
        uGCVideoDetailAboutCourseView.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, View view) {
        uGCVideoDetailAboutCourseView.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, View view) {
        uGCVideoDetailAboutCourseView.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(UGCVideoDetailAboutCourseView uGCVideoDetailAboutCourseView, View view) {
        uGCVideoDetailAboutCourseView.x();
    }

    private final void u() {
        setVisibility(8);
    }

    private final void v() {
        Cover previewImage;
        String url;
        UGCVideoDescImage uGCVideoDescImage = this.collectionDescImage;
        if (uGCVideoDescImage == null || (previewImage = uGCVideoDescImage.getPreviewImage()) == null || (url = previewImage.getUrl()) == null) {
            return;
        }
        this.viewBinding.f73938c.setVisibility(0);
        f.a aVar = f.f62005a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b i11 = aVar.m(context).g(url).i(R$color.module_01);
        String thumbnail = previewImage.getThumbnail();
        if (thumbnail == null) {
            thumbnail = "";
        }
        f.b l11 = i11.l(thumbnail);
        TopCropShapeableImageView ivPreviewImageCollection = this.viewBinding.f73940e;
        Intrinsics.g(ivPreviewImageCollection, "ivPreviewImageCollection");
        l11.d(ivPreviewImageCollection);
    }

    private final void w() {
        Cover previewImage;
        String url;
        UGCVideoDescImage uGCVideoDescImage = this.descImage;
        if (uGCVideoDescImage == null || (previewImage = uGCVideoDescImage.getPreviewImage()) == null || (url = previewImage.getUrl()) == null) {
            return;
        }
        f.a aVar = f.f62005a;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        f.b i11 = aVar.m(context).g(url).i(R$color.module_01);
        String thumbnail = previewImage.getThumbnail();
        if (thumbnail == null) {
            thumbnail = "";
        }
        f.b l11 = i11.l(thumbnail);
        TopCropShapeableImageView ivPreviewImage = this.viewBinding.f73939d;
        Intrinsics.g(ivPreviewImage, "ivPreviewImage");
        l11.d(ivPreviewImage);
    }

    private final void x() {
        Cover previewImage;
        UGCVideoDescImage uGCVideoDescImage = this.collectionDescImage;
        if (uGCVideoDescImage == null || (previewImage = uGCVideoDescImage.getOriginalImage()) == null) {
            UGCVideoDescImage uGCVideoDescImage2 = this.collectionDescImage;
            previewImage = uGCVideoDescImage2 != null ? uGCVideoDescImage2.getPreviewImage() : null;
            if (previewImage == null) {
                return;
            }
        }
        String url = previewImage.getUrl();
        if (url == null) {
            return;
        }
        Image image = new Image(null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, 0, 16383, null);
        image.setWidth(previewImage.getWidth());
        image.setHeight(previewImage.getHeight());
        image.setSize(previewImage.getSize());
        image.setUrl(url);
        image.setFormat(previewImage.getFormat());
        image.setThumbnail(previewImage.getThumbnail());
        image.setGifBean(previewImage.getGifBean());
        image.setAverageHueLight(previewImage.getAverageHueLight());
        image.setAverageHueDark(previewImage.getAverageHueDark());
        List q11 = CollectionsKt.q(image);
        GifImagePreviewActivity.Companion companion = GifImagePreviewActivity.INSTANCE;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, 0, q11);
    }

    private final void y() {
        Cover previewImage;
        UGCVideoDescImage uGCVideoDescImage = this.descImage;
        if (uGCVideoDescImage == null || (previewImage = uGCVideoDescImage.getOriginalImage()) == null) {
            UGCVideoDescImage uGCVideoDescImage2 = this.descImage;
            previewImage = uGCVideoDescImage2 != null ? uGCVideoDescImage2.getPreviewImage() : null;
            if (previewImage == null) {
                return;
            }
        }
        String url = previewImage.getUrl();
        if (url == null) {
            return;
        }
        Image image = new Image(null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, 0, 16383, null);
        image.setWidth(previewImage.getWidth());
        image.setHeight(previewImage.getHeight());
        image.setSize(previewImage.getSize());
        image.setUrl(url);
        image.setFormat(previewImage.getFormat());
        image.setThumbnail(previewImage.getThumbnail());
        image.setGifBean(previewImage.getGifBean());
        image.setAverageHueLight(previewImage.getAverageHueLight());
        image.setAverageHueDark(previewImage.getAverageHueDark());
        List q11 = CollectionsKt.q(image);
        GifImagePreviewActivity.Companion companion = GifImagePreviewActivity.INSTANCE;
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        companion.a(context, 0, q11);
    }

    public final void setData(UGCVideo video) {
        Cover previewImage;
        Cover previewImage2;
        UGCVideoBelongToCollection belongToCollection;
        String str = null;
        this.descImage = video != null ? video.getDescImage() : null;
        this.collectionDescImage = (video == null || (belongToCollection = video.getBelongToCollection()) == null) ? null : belongToCollection.getDescImage();
        UGCVideoDescImage uGCVideoDescImage = this.descImage;
        String url = (uGCVideoDescImage == null || (previewImage2 = uGCVideoDescImage.getPreviewImage()) == null) ? null : previewImage2.getUrl();
        boolean z10 = true;
        boolean z11 = url == null || url.length() == 0;
        UGCVideoDescImage uGCVideoDescImage2 = this.collectionDescImage;
        if (uGCVideoDescImage2 != null && (previewImage = uGCVideoDescImage2.getPreviewImage()) != null) {
            str = previewImage.getUrl();
        }
        if (str != null && str.length() != 0) {
            z10 = false;
        }
        if (z11 && z10) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (z11) {
            this.viewBinding.f73937b.setVisibility(8);
        } else {
            w();
            this.viewBinding.f73937b.setVisibility(0);
        }
        if (z10) {
            this.viewBinding.f73938c.setVisibility(8);
        } else {
            v();
        }
    }
}
