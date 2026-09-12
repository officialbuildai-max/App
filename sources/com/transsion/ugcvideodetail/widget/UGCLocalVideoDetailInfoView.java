package com.transsion.ugcvideodetail.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.j;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.ugcvideodetail.R$layout;
import com.transsion.ugcvideodetail.fragment.UGCVideoDetailBaseFragment;
import com.transsion.ugcvideodetail.hepler.h;
import com.transsion.ugcvideodetail.widget.UGCLocalVideoDetailInfoView;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.DownloadManagerApi;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import ej.f;
import jg.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh.m;
import qv.n;
import uh.b;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001dR\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/transsion/ugcvideodetail/widget/UGCLocalVideoDetailInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", j.f35620b, "()V", "m", "", "pageName", "setPageName", "(Ljava/lang/String;)V", "Lcom/transsion/ugcvideodetail/fragment/UGCVideoDetailBaseFragment;", "fragment", "setParentFragment", "(Lcom/transsion/ugcvideodetail/fragment/UGCVideoDetailBaseFragment;)V", "Lcom/transsion/baselib/db/download/DownloadBean;", "video", "setData", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "a", "Ljava/lang/String;", "TAG", "Lqv/n;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lqv/n;", "viewBinding", "c", "Lcom/transsion/baselib/db/download/DownloadBean;", "downloadBean", "d", "e", "Lcom/transsion/ugcvideodetail/fragment/UGCVideoDetailBaseFragment;", "parentFragment", "UGCVideoDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class UGCLocalVideoDetailInfoView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final n viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private DownloadBean downloadBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String pageName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private UGCVideoDetailBaseFragment parentFragment;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCLocalVideoDetailInfoView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UGCLocalVideoDetailInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCLocalVideoDetailInfoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "ResPostDetailInfoView";
        View.inflate(context, R$layout.layout_ugc_local_video_detail_info, this);
        n a11 = n.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        j();
    }

    private final void j() {
        this.viewBinding.f73933h.setOnClickListener(new View.OnClickListener() { // from class: sv.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCLocalVideoDetailInfoView.k(UGCLocalVideoDetailInfoView.this, view);
            }
        });
        this.viewBinding.f73934i.setOnClickListener(new View.OnClickListener() { // from class: sv.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCLocalVideoDetailInfoView.l(UGCLocalVideoDetailInfoView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(UGCLocalVideoDetailInfoView uGCLocalVideoDetailInfoView, View view) {
        if (!m.f70597a.e()) {
            b.f76876a.d(R$string.no_network_toast);
            return;
        }
        String str = uGCLocalVideoDetailInfoView.pageName;
        if (str != null) {
            h hVar = h.f56490a;
            DownloadBean downloadBean = uGCLocalVideoDetailInfoView.downloadBean;
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment = uGCLocalVideoDetailInfoView.parentFragment;
            String trackId = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getTrackId() : null;
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment2 = uGCLocalVideoDetailInfoView.parentFragment;
            String previousTrackId = uGCVideoDetailBaseFragment2 != null ? uGCVideoDetailBaseFragment2.getPreviousTrackId() : null;
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment3 = uGCLocalVideoDetailInfoView.parentFragment;
            hVar.e(str, "details", downloadBean, trackId, previousTrackId, uGCVideoDetailBaseFragment3 != null ? uGCVideoDetailBaseFragment3.getPreviousPageVideoId() : null);
        }
        Navigator c11 = TheRouter.c("/ugc_video/detail");
        DownloadBean downloadBean2 = uGCLocalVideoDetailInfoView.downloadBean;
        Navigator K = c11.K("id", downloadBean2 != null ? downloadBean2.getUgcVideoId() : null);
        DownloadBean downloadBean3 = uGCLocalVideoDetailInfoView.downloadBean;
        Navigator K2 = K.K("collection_id", downloadBean3 != null ? downloadBean3.getUgcVideoCollectionId() : null);
        DownloadBean downloadBean4 = uGCLocalVideoDetailInfoView.downloadBean;
        Navigator K3 = K2.K("ops", downloadBean4 != null ? downloadBean4.getOps() : null).K(WebConstants.PAGE_FROM, uGCLocalVideoDetailInfoView.pageName);
        DownloadBean downloadBean5 = uGCLocalVideoDetailInfoView.downloadBean;
        Navigator K4 = K3.K("parent_video_id", downloadBean5 != null ? downloadBean5.getUgcVideoId() : null);
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment4 = uGCLocalVideoDetailInfoView.parentFragment;
        Navigator.x(K4.K("parent_track_id", uGCVideoDetailBaseFragment4 != null ? uGCVideoDetailBaseFragment4.getTrackId() : null), uGCLocalVideoDetailInfoView.getContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(UGCLocalVideoDetailInfoView uGCLocalVideoDetailInfoView, View view) {
        if (!m.f70597a.e()) {
            b.f76876a.d(R$string.no_network_toast);
            return;
        }
        String str = uGCLocalVideoDetailInfoView.pageName;
        if (str != null) {
            h hVar = h.f56490a;
            DownloadBean downloadBean = uGCLocalVideoDetailInfoView.downloadBean;
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment = uGCLocalVideoDetailInfoView.parentFragment;
            String trackId = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getTrackId() : null;
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment2 = uGCLocalVideoDetailInfoView.parentFragment;
            String previousTrackId = uGCVideoDetailBaseFragment2 != null ? uGCVideoDetailBaseFragment2.getPreviousTrackId() : null;
            UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment3 = uGCLocalVideoDetailInfoView.parentFragment;
            hVar.e(str, "download", downloadBean, trackId, previousTrackId, uGCVideoDetailBaseFragment3 != null ? uGCVideoDetailBaseFragment3.getPreviousPageVideoId() : null);
        }
        uGCLocalVideoDetailInfoView.m();
    }

    private final void m() {
        Context context = getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean == null || fragmentActivity == null || fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            return;
        }
        DownloadManagerApi a11 = DownloadManagerApi.f58521j.a();
        String ugcVideoCollectionId = downloadBean.getUgcVideoCollectionId();
        String ugcVideoId = downloadBean.getUgcVideoId();
        String ugcVideoCollectionName = downloadBean.getUgcVideoCollectionName();
        String ugcVideoType = downloadBean.getUgcVideoType();
        String str = this.pageName;
        String ops = downloadBean.getOps();
        String subjectId = downloadBean.getSubjectId();
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment = this.parentFragment;
        String trackId = uGCVideoDetailBaseFragment != null ? uGCVideoDetailBaseFragment.getTrackId() : null;
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment2 = this.parentFragment;
        String previousTrackId = uGCVideoDetailBaseFragment2 != null ? uGCVideoDetailBaseFragment2.getPreviousTrackId() : null;
        UGCVideoDetailBaseFragment uGCVideoDetailBaseFragment3 = this.parentFragment;
        a11.f0(fragmentActivity, (r27 & 2) != 0 ? null : ugcVideoCollectionId, (r27 & 4) != 0 ? null : ugcVideoId, (r27 & 8) != 0 ? null : ugcVideoCollectionName, (r27 & 16) != 0 ? null : ugcVideoType, (r27 & 32) != 0 ? null : str, (r27 & 64) != 0 ? null : ops, (r27 & 128) != 0 ? null : subjectId, (r27 & 256) != 0 ? null : trackId, (r27 & 512) != 0 ? null : previousTrackId, (r27 & 1024) != 0 ? null : uGCVideoDetailBaseFragment3 != null ? uGCVideoDetailBaseFragment3.getPreviousPageVideoId() : null, (r27 & 2048) != 0 ? false : false, (r27 & 4096) == 0 ? null : null);
    }

    public final void setData(DownloadBean video) {
        Intrinsics.h(video, "video");
        this.downloadBean = video;
        AppCompatTextView appCompatTextView = this.viewBinding.f73935j;
        String ugcVideoName = video.getUgcVideoName();
        if (ugcVideoName == null) {
            ugcVideoName = video.getName();
        }
        appCompatTextView.setText(ugcVideoName);
        if (!video.isInnerRes()) {
            Group groupDetails = this.viewBinding.f73929d;
            Intrinsics.g(groupDetails, "groupDetails");
            c.g(groupDetails);
            Group groupDownload = this.viewBinding.f73930e;
            Intrinsics.g(groupDownload, "groupDownload");
            c.g(groupDownload);
        }
        String cover = video.getCover();
        if (cover != null) {
            f.a aVar = f.f62005a;
            Context context = getContext();
            Intrinsics.g(context, "getContext(...)");
            f.b g11 = aVar.m(context).g(cover);
            ShapeableImageView ivAvatar = this.viewBinding.f73931f;
            Intrinsics.g(ivAvatar, "ivAvatar");
            g11.d(ivAvatar);
        }
    }

    public final void setPageName(String pageName) {
        Intrinsics.h(pageName, "pageName");
        this.pageName = pageName;
    }

    public final void setParentFragment(UGCVideoDetailBaseFragment fragment) {
        Intrinsics.h(fragment, "fragment");
        this.parentFragment = fragment;
    }
}
