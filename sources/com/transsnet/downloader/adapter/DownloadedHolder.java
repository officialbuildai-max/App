package com.transsnet.downloader.adapter;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.Snackbar;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$color;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.adapter.u0;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import java.lang.ref.SoftReference;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.y0;

@Deprecated
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0098\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012w\u0010\u0014\u001as\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\t¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001e\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b&\u0010%J1\u0010-\u001a\u00020\u00132\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010.JO\u00103\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b7\u00108J!\u0010:\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J!\u0010<\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b<\u0010;J\u0017\u0010=\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b=\u0010>R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010?R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010@R\u0085\u0001\u0010\u0014\u001as\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010AR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001d\u0010M\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001d\u0010R\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010QR\u001d\u0010W\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010J\u001a\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010^R\u0014\u0010c\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010^R\u0014\u0010e\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010CR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010CR\u0014\u0010m\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010CR\u0016\u0010o\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010ZR\u0016\u0010q\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010ZR\u0018\u0010t\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010s¨\u0006u"}, d2 = {"Lcom/transsnet/downloader/adapter/DownloadedHolder;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/transsnet/downloader/adapter/u0;", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "pageFrom", "", "stateTextSizeDP", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", RequestParameters.POSITION, "Lcom/transsion/baselib/db/download/DownloadBean;", "bean", NativeComponentConstants.KEY_COMPONENT_TYPE, "Lcom/transsnet/downloader/adapter/u0$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "popSaveListener", "<init>", "(Landroid/view/View;Ljava/lang/String;FLkotlin/jvm/functions/Function5;)V", WebConstants.FIELD_ITEM, "L", "(ILandroid/view/View;Lcom/transsion/baselib/db/download/DownloadBean;)V", "", "readProgress", "duration", NotificationCompat.CATEGORY_STATUS, "P", "(Ljava/lang/Long;Ljava/lang/Long;II)V", "M", "(Lcom/transsion/baselib/db/download/DownloadBean;I)V", "Landroid/content/Context;", "context", "U", "(Landroid/content/Context;)V", "z", "Ljava/lang/ref/SoftReference;", "", "userTag", "Lcom/transsion/baselib/db/audio/AudioBean;", "audioBean", "resourceId", "X", "(Ljava/lang/ref/SoftReference;Lcom/transsion/baselib/db/audio/AudioBean;Ljava/lang/String;)V", "path", "url", "postId", "subjectId", "N", "(Lcom/transsion/baselib/db/download/DownloadBean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "O", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "T", "(Lcom/transsion/baselib/db/download/DownloadBean;Lcom/transsion/baselib/db/audio/AudioBean;)V", "Ln6/a;", "c", "(ILn6/a;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "(Lcom/transsnet/downloader/adapter/u0$b;)V", "Ljava/lang/String;", "F", "Lkotlin/jvm/functions/Function5;", "d", "Landroid/view/View;", "D", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "Lcom/transsion/room/api/IAudioApi;", "e", "Lkotlin/Lazy;", "B", "()Lcom/transsion/room/api/IAudioApi;", "mAudioApi", "Lcom/transsion/room/api/IFloatingApi;", "f", "C", "()Lcom/transsion/room/api/IFloatingApi;", "mFloatApi", "Ljj/a;", be.g.f16474b, "A", "()Ljj/a;", "audioDao", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "tvName", "Lcom/tn/lib/widget/TnTextView;", "i", "Lcom/tn/lib/widget/TnTextView;", "tvPercent", com.mbridge.msdk.foundation.same.report.j.f35620b, "tvFileSize", CampaignEx.JSON_KEY_AD_K, "tvSaveFileName", "l", "vNoFile", "Landroid/widget/ProgressBar;", "m", "Landroid/widget/ProgressBar;", "progressBar", "n", "seriesBg1", "o", "seriesBg2", TtmlNode.TAG_P, "tvSaveTo", CampaignEx.JSON_KEY_AD_Q, "tvEp", CampaignEx.JSON_KEY_AD_R, "Lcom/transsnet/downloader/adapter/u0$b;", "onItemChangeListener", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadedHolder extends BaseViewHolder implements u0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String pageFrom;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float stateTextSizeDP;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function5 popSaveListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mAudioApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mFloatApi;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy audioDao;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView tvName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TnTextView tvPercent;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final TnTextView tvFileSize;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final TnTextView tvSaveFileName;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final View vNoFile;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ProgressBar progressBar;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final View seriesBg1;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final View seriesBg2;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView tvSaveTo;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView tvEp;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private u0.b onItemChangeListener;

    /* loaded from: classes7.dex */
    public static final class a implements PermissionUtils.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f58576a;

        a(long j11) {
            this.f58576a = j11;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            if (System.currentTimeMillis() - this.f58576a < 500) {
                com.transsnet.downloader.viewmodel.a0.f60208a.x();
            }
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends aq.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AudioBean f58577b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ DownloadBean f58578c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DownloadedHolder f58579d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AudioBean audioBean, DownloadBean downloadBean, DownloadedHolder downloadedHolder, SoftReference softReference) {
            super(softReference);
            this.f58577b = audioBean;
            this.f58578c = downloadBean;
            this.f58579d = downloadedHolder;
        }

        @Override // aq.e, com.transsion.player.orplayer.f
        public void onCompletion(ao.e eVar) {
            this.f58577b.setStatus(6);
            this.f58578c.setAudioStatus(6);
            DownloadedHolder downloadedHolder = this.f58579d;
            SoftReference a11 = a();
            AudioBean audioBean = this.f58577b;
            String resourceId = this.f58578c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f58578c.getUrl();
            }
            downloadedHolder.X(a11, audioBean, resourceId);
        }

        @Override // aq.e, com.transsion.player.orplayer.f
        public void onProgress(long j11, ao.e eVar) {
            this.f58577b.setReadProcess(Long.valueOf(j11));
            DownloadedHolder downloadedHolder = this.f58579d;
            SoftReference a11 = a();
            AudioBean audioBean = this.f58577b;
            String resourceId = this.f58578c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f58578c.getUrl();
            }
            downloadedHolder.X(a11, audioBean, resourceId);
        }

        @Override // aq.e, com.transsion.player.orplayer.f
        public void onVideoPause(ao.e eVar) {
            this.f58577b.setStatus(4);
            this.f58578c.setAudioStatus(4);
            DownloadedHolder downloadedHolder = this.f58579d;
            SoftReference a11 = a();
            AudioBean audioBean = this.f58577b;
            String resourceId = this.f58578c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f58578c.getUrl();
            }
            downloadedHolder.X(a11, audioBean, resourceId);
        }

        @Override // aq.e, com.transsion.player.orplayer.f
        public void onVideoStart(ao.e eVar) {
            this.f58577b.setStatus(3);
            this.f58578c.setAudioStatus(3);
            Long duration = this.f58577b.getDuration();
            if (duration != null && duration.longValue() == 0) {
                AudioBean audioBean = this.f58577b;
                IAudioApi B = this.f58579d.B();
                audioBean.setDuration(B != null ? Long.valueOf(B.e()) : null);
            }
            DownloadedHolder downloadedHolder = this.f58579d;
            SoftReference a11 = a();
            AudioBean audioBean2 = this.f58577b;
            String resourceId = this.f58578c.getResourceId();
            if (resourceId == null) {
                resourceId = this.f58578c.getUrl();
            }
            downloadedHolder.X(a11, audioBean2, resourceId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadedHolder(View view, String pageFrom, float f11, Function5 popSaveListener) {
        super(view);
        Intrinsics.h(view, "view");
        Intrinsics.h(pageFrom, "pageFrom");
        Intrinsics.h(popSaveListener, "popSaveListener");
        this.pageFrom = pageFrom;
        this.stateTextSizeDP = f11;
        this.popSaveListener = popSaveListener;
        this.mAudioApi = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.adapter.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IAudioApi J;
                J = DownloadedHolder.J();
                return J;
            }
        });
        this.mFloatApi = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.adapter.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IFloatingApi K;
                K = DownloadedHolder.K();
                return K;
            }
        });
        this.audioDao = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.adapter.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                jj.a y10;
                y10 = DownloadedHolder.y();
                return y10;
            }
        });
        this.view = view;
        this.tvName = (TextView) getView(R$id.tv_name);
        this.tvPercent = (TnTextView) getView(R$id.tv_process);
        this.vNoFile = getView(R$id.layout_no_file_tips);
        this.progressBar = (ProgressBar) getView(R$id.progress_bar);
        this.seriesBg1 = getView(R$id.v_series_top_bg);
        this.seriesBg2 = getView(R$id.v_series_top_bg_2);
        this.tvFileSize = (TnTextView) getView(R$id.tv_file_size);
        this.tvSaveFileName = (TnTextView) getView(R$id.tv_save_file_name);
        this.tvSaveTo = (TextView) getView(R$id.tv_save_to);
        this.tvEp = (TextView) getView(R$id.tv_ep);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final jj.a A() {
        return (jj.a) this.audioDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi B() {
        return (IAudioApi) this.mAudioApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi C() {
        return (IFloatingApi) this.mFloatApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence E(DownloadedHolder downloadedHolder, n6.a aVar, String str) {
        return downloadedHolder.itemView.getContext().getString(R$string.download_files, Integer.valueOf(((DownloadBean) aVar).getCount())) + " · " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence F(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(DownloadedHolder downloadedHolder, int i11, n6.a aVar, View view) {
        Intrinsics.e(view);
        downloadedHolder.L(i11, view, (DownloadBean) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(DownloadedHolder downloadedHolder, int i11, n6.a aVar, View view) {
        Intrinsics.e(view);
        downloadedHolder.L(i11, view, (DownloadBean) aVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(n6.a aVar, DownloadedHolder downloadedHolder, int i11, View view) {
        if (com.transsion.baseui.util.c.f43558a.a(view.getId(), 1000L)) {
            return;
        }
        DownloadBean downloadBean = (DownloadBean) aVar;
        if (downloadBean.getStatus() == 10) {
            downloadedHolder.O(downloadBean);
        } else {
            downloadedHolder.M(downloadBean, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAudioApi J() {
        return (IAudioApi) TheRouter.d(IAudioApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFloatingApi K() {
        return (IFloatingApi) TheRouter.d(IFloatingApi.class, new Object[0]);
    }

    private final void L(int position, View view, DownloadBean item) {
        if (item.isAllFileExist()) {
            this.popSaveListener.invoke(Integer.valueOf(position), view, item, 1, this.onItemChangeListener);
            return;
        }
        LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f60027a;
        Context context = view.getContext();
        Intrinsics.g(context, "getContext(...)");
        localVideoNotExistUtil.v(context, item, position);
    }

    private final void M(DownloadBean item, int position) {
        String name;
        String subjectName;
        if (item.getType() == 1) {
            if (item.isFileExist()) {
                kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(y0.c()), null, null, new DownloadedHolder$openMedia$1(this, item, null), 3, null);
                return;
            }
            LocalVideoNotExistUtil localVideoNotExistUtil = LocalVideoNotExistUtil.f60027a;
            View view = this.view;
            Intrinsics.e(view);
            Context context = view.getContext();
            Intrinsics.g(context, "getContext(...)");
            localVideoNotExistUtil.v(context, item, position);
            return;
        }
        String path = item.getPath();
        if (path != null && path.length() != 0) {
            File file = new File(path);
            Log.e("yy", "exists:" + file.exists() + "  canRead" + file.canRead() + "    " + path);
            boolean s11 = PermissionUtils.s("android.permission.WRITE_EXTERNAL_STORAGE");
            if (file.exists() && !file.canRead() && !s11) {
                Context context2 = this.itemView.getContext();
                Intrinsics.e(context2);
                U(context2);
                return;
            }
        }
        String path2 = item.getPath();
        String str = path2 == null ? "" : path2;
        String resourceId = item.getResourceId();
        if (resourceId == null) {
            resourceId = item.getUrl();
        }
        String str2 = resourceId;
        String url = item.getUrl();
        String str3 = (!item.isSeries() || (subjectName = item.getSubjectName()) == null || subjectName.length() <= 0 ? (name = item.getName()) != null : (name = item.getSubjectName()) != null) ? name : "";
        String postId = item.getPostId();
        if (postId == null) {
            postId = item.getUrl();
        }
        String str4 = postId;
        String subjectId = item.getSubjectId();
        N(item, str, str2, url, str3, str4, subjectId == null ? "" : subjectId, position);
    }

    private final void N(DownloadBean item, String path, String resourceId, String url, String name, String postId, String subjectId, int position) {
        Context context;
        if (item.isShotTV()) {
            View view = this.view;
            if (view == null || (context = view.getContext()) == null) {
                return;
            }
            Navigator.x(TheRouter.c(ls.a.f69157a.b()).K("id", item.getSubjectId()).F("ep", item.getEp()).G("ms", item.getReadProgress()), context, null, 2, null);
            return;
        }
        View view2 = this.view;
        Context context2 = view2 != null ? view2.getContext() : null;
        AppCompatActivity appCompatActivity = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
        if (appCompatActivity == null) {
            return;
        }
        Navigator F = TheRouter.c("/video/detail").F("subject_type", item.getSubjectType()).K("id", subjectId).K("extra_local_path", path).K("extra_url", url).K("extra_resource_id", resourceId).K("extra_subject_id", subjectId).K("extra_name", name).K("extra_post_id", postId).z("extra_completed", true).z("extra_is_series", item.isSeries()).K("extra_page_from", this.pageFrom).F("extra_height", item.getVideoHeight()).F("extra_width", item.getVideoWidth());
        if (!item.isSeries()) {
            position = -1;
        }
        Navigator.x(F.F("extra_series_position", position), appCompatActivity, null, 2, null);
    }

    private final void O(DownloadBean bean) {
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().K().q(null);
        aVar.a().K().q(bean);
        View view = this.view;
        Context context = view != null ? view.getContext() : null;
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return;
        }
        Navigator c11 = TheRouter.c("/download/series_list");
        String subjectName = bean.getSubjectName();
        if (subjectName == null) {
            subjectName = "Series";
        }
        Navigator.x(c11.K("extra_name", subjectName), appCompatActivity, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(Long readProgress, Long duration, int status, final int type) {
        final long longValue = readProgress != null ? readProgress.longValue() : 0L;
        long longValue2 = duration != null ? duration.longValue() : 1L;
        final int i11 = (int) (((((float) longValue) * 1.0f) / ((float) (longValue2 > 0 ? longValue2 : 1L))) * 100);
        if (i11 >= 0 && i11 < 101) {
            this.tvPercent.setTextAction(new Function0() { // from class: com.transsnet.downloader.adapter.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CharSequence Q;
                    Q = DownloadedHolder.Q(i11, longValue, type, this);
                    return Q;
                }
            });
            this.progressBar.setProgress(i11);
        }
        if (status == 1) {
            this.tvPercent.setTextAction(new Function0() { // from class: com.transsnet.downloader.adapter.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CharSequence R;
                    R = DownloadedHolder.R(DownloadedHolder.this);
                    return R;
                }
            });
        } else {
            if (status != 6) {
                return;
            }
            this.tvPercent.setTextAction(new Function0() { // from class: com.transsnet.downloader.adapter.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CharSequence S;
                    S = DownloadedHolder.S(DownloadedHolder.this);
                    return S;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence Q(int i11, long j11, int i12, DownloadedHolder downloadedHolder) {
        return i11 != 0 ? i11 != 100 ? i12 == 1 ? downloadedHolder.itemView.getContext().getString(R$string.download_listened, Integer.valueOf(i11)) : downloadedHolder.itemView.getContext().getString(R$string.download_watched, Integer.valueOf(i11)) : downloadedHolder.itemView.getContext().getString(R$string.download_finished) : j11 > 0 ? i12 == 1 ? downloadedHolder.itemView.getContext().getString(R$string.download_listened, 1) : downloadedHolder.itemView.getContext().getString(R$string.download_watched, 1) : downloadedHolder.itemView.getContext().getString(R$string.download_not_open);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence R(DownloadedHolder downloadedHolder) {
        return downloadedHolder.itemView.getContext().getString(R$string.download_not_open);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence S(DownloadedHolder downloadedHolder) {
        return downloadedHolder.itemView.getContext().getString(R$string.download_finished);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(DownloadBean item, AudioBean audioBean) {
        item.setAudioListener(new b(audioBean, item, this, new SoftReference(this)));
    }

    private final void U(final Context context) {
        Snackbar p02 = Snackbar.m0(this.itemView, R$string.download_open_file_no_permission, -1).p0(com.transsion.transfer.R$string.wifi_setting, new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadedHolder.V(DownloadedHolder.this, context, view);
            }
        });
        int color = androidx.core.content.b.getColor(context, R$color.download_snackbar_bg);
        int color2 = androidx.core.content.b.getColor(context, R$color.download_snackbar_action);
        p02.r0(color);
        View H = p02.H();
        Intrinsics.g(H, "getView(...)");
        com.transsion.baseui.util.q.c(H, com.blankj.utilcode.util.i.e(8.0f));
        final Button button = (Button) p02.H().findViewById(com.google.android.material.R$id.snackbar_action);
        if (button != null) {
            TextView textView = new TextView(context);
            textView.setAllCaps(false);
            textView.setTextColor(color);
            textView.setTextSize(14.0f);
            textView.setGravity(17);
            textView.setBackgroundColor(color2);
            com.transsion.baseui.util.q.c(textView, com.blankj.utilcode.util.i.e(8.0f));
            textView.setTypeface(jg.a.c(context));
            textView.setText(button.getText());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.adapter.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadedHolder.W(button, view);
                }
            });
            ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
            layoutParams.width = com.blankj.utilcode.util.i.e(68.0f);
            layoutParams.height = com.blankj.utilcode.util.i.e(32.0f);
            ViewGroup viewGroup = (ViewGroup) button.getParent();
            if (viewGroup != null) {
                viewGroup.addView(textView, layoutParams);
            }
            jg.c.g(button);
        }
        TextView textView2 = (TextView) p02.H().findViewById(com.google.android.material.R$id.snackbar_text);
        if (textView2 != null) {
            textView2.setAllCaps(false);
            textView2.setTextSize(14.0f);
            textView2.setTypeface(jg.a.c(context));
            textView2.setTextColor(color2);
        }
        p02.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(DownloadedHolder downloadedHolder, Context context, View view) {
        downloadedHolder.z(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Button button, View view) {
        button.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(SoftReference userTag, AudioBean audioBean, String resourceId) {
        if ((userTag != null ? userTag.get() : null) != null) {
            Object obj = userTag.get();
            Intrinsics.f(obj, "null cannot be cast to non-null type com.transsnet.downloader.adapter.DownloadedHolder");
            DownloadedHolder downloadedHolder = (DownloadedHolder) obj;
            if (audioBean != null) {
                downloadedHolder.P(audioBean.getReadProcess(), audioBean.getDuration(), audioBean.getStatus(), 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final jj.a y() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).o1();
    }

    private final void z(Context context) {
        PermissionUtils.x("android.permission.WRITE_EXTERNAL_STORAGE").m(new a(System.currentTimeMillis())).y();
    }

    /* renamed from: D, reason: from getter */
    public final View getView() {
        return this.view;
    }

    @Override // com.transsnet.downloader.adapter.u0
    public void a(u0.b listener) {
        Intrinsics.h(listener, "listener");
        this.onItemChangeListener = listener;
    }

    @Override // com.transsnet.downloader.adapter.u0
    public void b(int position, n6.a item) {
        if (item instanceof DownloadBean) {
            DownloadBean downloadBean = (DownloadBean) item;
            P(Long.valueOf(downloadBean.getReadProgress()), downloadBean.getDuration(), downloadBean.getStatus(), downloadBean.getType());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011e  */
    @Override // com.transsnet.downloader.adapter.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(final int r18, final n6.a r19) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.adapter.DownloadedHolder.c(int, n6.a):void");
    }
}
