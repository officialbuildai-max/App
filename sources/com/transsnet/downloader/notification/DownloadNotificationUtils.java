package com.transsnet.downloader.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.t;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.c0;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$string;
import com.transsion.baseui.util.n;
import com.transsion.lib.push.R$dimen;
import com.transsion.lib.push.R$id;
import com.transsion.lib.push.R$layout;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mpush.core.config.PushMsgSource;
import com.transsion.mpush.core.config.PushMsgType;
import com.transsion.push.api.IPushProvider;
import com.transsion.ugcvideodetail.api.UGCPageStyle;
import com.transsnet.downloader.guard.DownloadGuard;
import com.transsnet.downloader.manager.g;
import com.transsnet.downloader.manager.p;
import ej.f;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import nh.m;
import org.mvel2.ast.ASTNode;

/* loaded from: classes.dex */
public final class DownloadNotificationUtils {

    /* renamed from: e, reason: collision with root package name */
    private static int f59633e;

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadNotificationUtils f59629a = new DownloadNotificationUtils();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f59630b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.notification.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g r11;
            r11 = DownloadNotificationUtils.r();
            return r11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static boolean f59631c = true;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f59632d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.notification.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            NotificationManager F;
            F = DownloadNotificationUtils.F();
            return F;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private static String f59634f = "";

    /* loaded from: classes7.dex */
    public static final class a extends CustomTarget {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadBean f59635a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f59636b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f59637c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f59638d;

        a(DownloadBean downloadBean, boolean z10, String str, String str2) {
            this.f59635a = downloadBean;
            this.f59636b = z10;
            this.f59637c = str;
            this.f59638d = str2;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            a.C0856a.f(lg.a.f68962a, "download_notify", "onFailure", false, 4, null);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Bitmap resource, Transition transition) {
            NotificationCompat.m s11;
            Intrinsics.h(resource, "resource");
            a.C0856a.f(lg.a.f68962a, "download_notify", "onSuccess", false, 4, null);
            int i11 = Build.VERSION.SDK_INT;
            int i12 = i11 >= 31 ? 67108864 : ASTNode.NOJIT;
            DownloadNotificationUtils downloadNotificationUtils = DownloadNotificationUtils.f59629a;
            int z10 = downloadNotificationUtils.z(this.f59635a);
            int i13 = z10 + 1;
            IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
            if (iPushProvider != null) {
                String v11 = downloadNotificationUtils.v(this.f59635a);
                int status = this.f59635a.getStatus();
                PendingIntent t11 = downloadNotificationUtils.t(iPushProvider, i13, this.f59635a, i12);
                PendingIntent s12 = this.f59635a.getType() == 1 ? downloadNotificationUtils.s(iPushProvider, i13, this.f59635a, i12) : downloadNotificationUtils.C(iPushProvider, i13, this.f59635a, i12);
                String D = this.f59636b ? downloadNotificationUtils.D(status) : this.f59637c;
                if (!this.f59636b) {
                    v11 = this.f59638d;
                }
                String str = v11;
                if (i11 >= 31) {
                    RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), R$layout.push_notification_custom_left_pic_s_small);
                    remoteViews.setTextViewText(R$id.notification_title_tv, D);
                    remoteViews.setTextViewText(R$id.notification_content_tv, str);
                    remoteViews.setImageViewResource(R$id.iv_icon, R$mipmap.icon_play_white);
                    remoteViews.setTextViewText(R$id.tv_tips, Utils.a().getString(R$string.play));
                    remoteViews.setOnClickPendingIntent(R$id.ll_download, s12);
                    int dimension = (int) Utils.a().getResources().getDimension(R$dimen.push_notification_transition_rectangle_img_width);
                    int dimension2 = (int) Utils.a().getResources().getDimension(R$dimen.push_notification_transition_rectangle_img_height);
                    com.transsnet.downloader.notification.a aVar = com.transsnet.downloader.notification.a.f59640a;
                    Application a11 = Utils.a();
                    Intrinsics.g(a11, "getApp(...)");
                    Bitmap d11 = com.transsnet.downloader.notification.a.d(aVar, a11, resource, dimension, dimension2, false, 0, 32, null);
                    RemoteViews remoteViews2 = new RemoteViews(Utils.a().getPackageName(), R$layout.push_notification_custom_left_pic_s_big);
                    remoteViews2.setTextViewText(R$id.notification_title_tv, D);
                    remoteViews2.setTextViewText(R$id.notification_content_tv, str);
                    remoteViews2.setImageViewBitmap(R$id.notification_content_image, d11);
                    remoteViews2.setImageViewResource(R$id.iv_icon, R$mipmap.icon_play_white);
                    remoteViews2.setTextViewText(R$id.tv_tips, Utils.a().getString(R$string.play));
                    remoteViews2.setOnClickPendingIntent(R$id.ll_download, s12);
                    s11 = new NotificationCompat.m(Utils.a(), "download_service").J(R$drawable.push_small_logo).q(D).p(str).o(t11).l(true).s(remoteViews).r(remoteViews2);
                } else {
                    RemoteViews remoteViews3 = new RemoteViews(Utils.a().getPackageName(), R$layout.push_notification_custom_left_pic);
                    remoteViews3.setTextViewText(R$id.notification_title_tv, D);
                    remoteViews3.setTextViewText(R$id.notification_content_tv, str);
                    remoteViews3.setImageViewBitmap(R$id.notification_content_image, resource);
                    remoteViews3.setImageViewResource(R$id.iv_icon, R$mipmap.icon_play_white);
                    remoteViews3.setTextViewText(R$id.tv_tips, Utils.a().getString(R$string.play));
                    remoteViews3.setOnClickPendingIntent(R$id.ll_download, s12);
                    remoteViews3.setLong(R$id.time, "setTime", System.currentTimeMillis());
                    s11 = new NotificationCompat.m(Utils.a(), "download_service_high").J(R$drawable.push_small_logo).o(t11).q(D).p(str).l(true).s(remoteViews3);
                }
                Intrinsics.e(s11);
                downloadNotificationUtils.B().cancel(z10);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    t.d(Utils.a()).f(i13, s11.c());
                    Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m1185constructorimpl(ResultKt.a(th2));
                }
                if (this.f59636b) {
                    return;
                }
                com.transsion.push.utils.t.f50998a.b().putLong("download_play_notification_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements rp.b {
        b() {
        }

        @Override // rp.b
        public void a() {
            DownloadNotificationUtils downloadNotificationUtils = DownloadNotificationUtils.f59629a;
            if (downloadNotificationUtils.m()) {
                downloadNotificationUtils.x();
            }
        }
    }

    private DownloadNotificationUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationManager B() {
        return (NotificationManager) f59632d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent C(IPushProvider iPushProvider, int i11, DownloadBean downloadBean, int i12) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent a12 = iPushProvider.a(a11);
        a12.putExtra("notification_id", i11);
        a12.putExtra("msg_source", PushMsgSource.SOURCE_PUSH);
        a12.putExtra("msg_type", PushMsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        a12.putExtra("msg_id", sb2.toString());
        a12.addFlags(603979776);
        a12.setAction("android.intent.action.VIEW");
        StringBuilder sb3 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb3.append("&channel=download_notification");
        if (downloadBean.isShotTV()) {
            if (downloadBean.isUGCVideo()) {
                sb3.append("/ugc_video/detail");
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("id");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getUgcVideoId());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("videoStyle");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("id");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getUgcVideoId());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("collection_id");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getUgcVideoCollectionId());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("ops");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getOps());
            } else {
                sb3.append(ls.a.f69157a.b());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("id");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getSubjectId());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("ep");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getEp());
                sb3.append(UrlUtils.AND_MARK);
                sb3.append("ops");
                sb3.append(UrlUtils.EQUAL_MARK);
                sb3.append(downloadBean.getOps());
            }
        } else if (!downloadBean.isUGCVideo()) {
            sb3.append("/video/detail");
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_local_path");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getPath());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_name");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getName());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_resource_id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getResourceId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_post_id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getPostId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_subject_id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getSubjectId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_page_from");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(PushMsgSource.SOURCE_PUSH);
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("extra_is_series");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.isSeries());
        } else if (downloadBean.getUgcVideoIsVertical()) {
            sb3.append("/ugc_video/detail");
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getUgcVideoId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("videoStyle");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(UGCPageStyle.UGC_PAGE_STYLE_IMM_VERTICAL_VIDEO.getValue());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("resource_id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getResourceId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("ops");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getOps());
        } else {
            sb3.append("/ugc_video/local_detail");
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getUgcVideoId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("resource_id");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getResourceId());
            sb3.append(UrlUtils.AND_MARK);
            sb3.append("ops");
            sb3.append(UrlUtils.EQUAL_MARK);
            sb3.append(downloadBean.getOps());
        }
        a12.setData(Uri.parse(sb3.toString()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a12, i12);
        Intrinsics.g(activity, "getActivity(...)");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String D(int i11) {
        Application a11 = Utils.a();
        if (i11 == 3) {
            String string = a11.getString(com.transsnet.downloader.R$string.notification_download_waiting);
            Intrinsics.g(string, "getString(...)");
            return string;
        }
        if (i11 == 4) {
            String string2 = a11.getString(com.transsnet.downloader.R$string.notification_download_paused);
            Intrinsics.g(string2, "getString(...)");
            return string2;
        }
        if (i11 == 5) {
            String string3 = a11.getString(com.transsnet.downloader.R$string.notification_download_success);
            Intrinsics.g(string3, "getString(...)");
            return string3;
        }
        if (i11 != 6) {
            return "";
        }
        String string4 = a11.getString(com.transsnet.downloader.R$string.notification_download_failed);
        Intrinsics.g(string4, "getString(...)");
        return string4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotificationManager F() {
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(DownloadBean downloadBean) {
        if (downloadBean.getLastPlayTimeStamp() == 0) {
            String string = Utils.a().getString(com.transsnet.downloader.R$string.notification_download_complete);
            Intrinsics.g(string, "getString(...)");
            String string2 = Utils.a().getString(com.transsnet.downloader.R$string.notification_download_watch_tip, v(downloadBean));
            Intrinsics.g(string2, "getString(...)");
            o(downloadBean, false, string, string2);
            return;
        }
        Long duration = downloadBean.getDuration();
        if (duration != null) {
            if (duration.longValue() <= 0 || ((((float) downloadBean.getReadProgress()) * 1.0f) / ((float) r6)) * 1.0f >= 0.8d) {
                return;
            }
            String string3 = Utils.a().getString(com.transsnet.downloader.R$string.notification_continue_watching);
            Intrinsics.g(string3, "getString(...)");
            Application a11 = Utils.a();
            int i11 = com.transsnet.downloader.R$string.notification_download_continue_tip;
            DownloadNotificationUtils downloadNotificationUtils = f59629a;
            String string4 = a11.getString(i11, downloadNotificationUtils.v(downloadBean));
            Intrinsics.g(string4, "getString(...)");
            downloadNotificationUtils.o(downloadBean, false, string3, string4);
        }
    }

    private final void l(int i11) {
        B().cancel(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        boolean f11 = c0.f(com.transsion.push.utils.t.f50998a.b().getLong("download_play_notification_time", 0L));
        int i11 = Calendar.getInstance().get(11);
        return 19 <= i11 && i11 < 21 && !f11;
    }

    private final void o(DownloadBean downloadBean, boolean z10, String str, String str2) {
        try {
            RequestBuilder diskCacheStrategy = Glide.with(Utils.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA);
            f.a aVar = f.f62005a;
            String cover = downloadBean.getCover();
            if (cover == null) {
                cover = "";
            }
            Intrinsics.e(diskCacheStrategy.load2(f.a.e(aVar, cover, y.a() - dk.a.b(80), true, false, 8, null)).into((RequestBuilder) new a(downloadBean, z10, str, str2)));
        } catch (Exception unused) {
            a.C0856a.f(lg.a.f68962a, "DownloadNotificationUtils", "onFailure", false, 4, null);
        }
    }

    static /* synthetic */ void p(DownloadNotificationUtils downloadNotificationUtils, DownloadBean downloadBean, boolean z10, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        downloadNotificationUtils.o(downloadBean, z10, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(DownloadBean downloadBean) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g r() {
        return p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent s(IPushProvider iPushProvider, int i11, DownloadBean downloadBean, int i12) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent a12 = iPushProvider.a(a11);
        a12.putExtra("notification_id", i11);
        a12.putExtra("msg_source", PushMsgSource.SOURCE_PUSH);
        a12.putExtra("msg_type", PushMsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        a12.putExtra("msg_id", sb2.toString());
        a12.addFlags(603979776);
        a12.setAction("android.intent.action.VIEW");
        a12.setData(Uri.parse("oneroom://com.community.oneroom?type=/movie/detail" + UrlUtils.AND_MARK + "id" + UrlUtils.EQUAL_MARK + downloadBean.getSubjectId() + UrlUtils.AND_MARK + "autoPlay" + UrlUtils.EQUAL_MARK + "true&channel=download_notification" + UrlUtils.AND_MARK + "resourceId" + UrlUtils.EQUAL_MARK + downloadBean.getResourceId()));
        return PendingIntent.getActivity(Utils.a(), 0, a12, i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PendingIntent t(IPushProvider iPushProvider, int i11, DownloadBean downloadBean, int i12) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent a12 = iPushProvider.a(a11);
        a12.putExtra("notification_id", i11);
        a12.putExtra("msg_source", PushMsgSource.SOURCE_PUSH);
        a12.putExtra("msg_type", PushMsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        a12.putExtra("msg_id", sb2.toString());
        a12.addFlags(603979776);
        a12.setAction("android.intent.action.VIEW");
        a12.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity" + UrlUtils.AND_MARK + "download_notify" + UrlUtils.EQUAL_MARK + "10&channel=download_notification" + UrlUtils.AND_MARK + OfflineConstantsKt.TRACK_KEY_PRE_DOWNLOAD_STATUS + UrlUtils.EQUAL_MARK + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a12, i12);
        Intrinsics.g(activity, "getActivity(...)");
        return activity;
    }

    private final int u() {
        return Build.VERSION.SDK_INT < 31 ? com.transsnet.downloader.R$layout.notification_other_status : com.transsnet.downloader.R$layout.notification_other_status_v12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v(DownloadBean downloadBean) {
        return (downloadBean.isSeries() ? downloadBean.getSubjectName() : downloadBean.getName()) + " " + (downloadBean.getEpse() > 0 ? downloadBean.getEp() > 0 ? n.b(downloadBean.getEp(), downloadBean.getSe(), downloadBean.isVideo()) : n.c(downloadBean.getEpse(), downloadBean.isVideo()) : "");
    }

    private final int w() {
        return Build.VERSION.SDK_INT < 31 ? com.transsnet.downloader.R$layout.notification_downloading : com.transsnet.downloader.R$layout.notification_downloading_v12;
    }

    private final NotificationCompat.m y(int i11, DownloadBean downloadBean) {
        Long size;
        int i12 = Build.VERSION.SDK_INT >= 31 ? 67108864 : ASTNode.NOJIT;
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        if (iPushProvider == null) {
            return null;
        }
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent a12 = iPushProvider.a(a11);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        a12.putExtra("notification_id", sb2.toString());
        a12.putExtra("msg_source", PushMsgSource.SOURCE_PUSH);
        a12.putExtra("msg_type", PushMsgType.DOWNLOAD_PUSH.getType());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i11);
        a12.putExtra("msg_id", sb3.toString());
        a12.addFlags(603979776);
        a12.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity" + UrlUtils.AND_MARK + "download_notify" + UrlUtils.EQUAL_MARK + "10&channel=download_notification" + UrlUtils.AND_MARK + OfflineConstantsKt.TRACK_KEY_PRE_DOWNLOAD_STATUS + UrlUtils.EQUAL_MARK + downloadBean.getStatus()));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a12, i12);
        String v11 = v(downloadBean);
        long j11 = 0;
        long progress = downloadBean.getProgress() < 0 ? 0L : downloadBean.getProgress();
        Long size2 = downloadBean.getSize();
        if ((size2 != null ? size2.longValue() : 0L) >= 0 && (size = downloadBean.getSize()) != null) {
            j11 = size.longValue();
        }
        float progress2 = ((float) downloadBean.getProgress()) * 1.0f;
        Long size3 = downloadBean.getSize();
        int longValue = (int) ((progress2 / ((float) (size3 != null ? size3.longValue() : 1L))) * 100);
        if (longValue > 100) {
            longValue = 100;
        }
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), w());
        remoteViews.setProgressBar(com.transsnet.downloader.R$id.progress, 100, longValue, false);
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_name, v11);
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_size, oh.b.a(progress, 1) + "/" + oh.b.a(j11, 1));
        NotificationCompat.m r11 = new NotificationCompat.m(Utils.a(), "download_service").J(R$drawable.push_small_logo).q(D(downloadBean.getStatus())).p(v11).o(activity).l(false).s(remoteViews).r(remoteViews);
        Intrinsics.g(r11, "setCustomBigContentView(...)");
        return r11;
    }

    public final int A(String url, String str) {
        Intrinsics.h(url, "url");
        if (str == null) {
            str = url;
        }
        int abs = Math.abs(str.hashCode());
        return abs <= 0 ? Math.abs(url.hashCode()) : abs;
    }

    public final void E() {
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            B().createNotificationChannel(m.f.a("download_service", Utils.a().getString(com.transsnet.downloader.R$string.download_notifications_name), 2));
            g0.a();
            B().createNotificationChannel(m.f.a("download_service_high", Utils.a().getString(com.transsnet.downloader.R$string.download_success_notifications_name), 4));
        }
    }

    public final void G() {
        if (m()) {
            x();
        } else {
            rp.a.f74717a.c(new b());
        }
    }

    public final void I(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        int z10 = z(downloadInfo);
        int i11 = z10 + 1;
        int status = downloadInfo.getStatus();
        String resourceId = downloadInfo.getResourceId();
        if (resourceId == null) {
            resourceId = "";
        }
        if (!downloadInfo.isDownloading()) {
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "download_notify", "updateCustomView, status = " + status + "， name = " + downloadInfo.getTotalTitleName(), false, 4, null);
            if (f59633e == status && Intrinsics.c(f59634f, resourceId)) {
                a.C0856a.f(c0856a, "download_notify", "updateCustomView, return", false, 4, null);
                return;
            }
        }
        f59633e = status;
        f59634f = resourceId;
        if (status == 3) {
            l(z10);
            B().cancel(i11);
            return;
        }
        a.C0856a c0856a2 = lg.a.f68962a;
        a.C0856a.f(c0856a2, "download_notify", "updateCustomView--- 2, status = " + status + "， name = " + downloadInfo.getTotalTitleName(), false, 4, null);
        DownloadGuard.f59507a.p(downloadInfo);
        if (status == 6 && (downloadInfo.isNoNetError() || !m.f70597a.e())) {
            a.C0856a.f(c0856a2, "download_notify", "updateCustomView--- 无网错误不出通知", false, 4, null);
            l(z10);
            B().cancel(i11);
            return;
        }
        String v11 = v(downloadInfo);
        if (status == 1 || status == 2) {
            B().cancel(i11);
            return;
        }
        if (status == 5) {
            p(this, downloadInfo, false, null, null, 14, null);
            return;
        }
        if (status == 7 || status == 57) {
            l(z10);
            B().cancel(i11);
            return;
        }
        l(z10);
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), u());
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_status, D(downloadInfo.getStatus()));
        remoteViews.setTextViewText(com.transsnet.downloader.R$id.tv_name, v11);
        NotificationCompat.m y10 = y(i11, downloadInfo);
        if (y10 != null) {
            try {
                y10.l(true);
                y10.s(remoteViews).r(remoteViews);
                a.C0856a.v(c0856a2, "download_notify", "updateCustomView--- 3, status = " + status + "， name = " + downloadInfo.getTotalTitleName(), false, 4, null);
                t.d(Utils.a()).f(i11, y10.c());
            } catch (Throwable unused) {
            }
        }
    }

    public final void n(DownloadBean downloadInfo) {
        String value;
        Boolean m12;
        Intrinsics.h(downloadInfo, "downloadInfo");
        boolean z10 = false;
        ConfigBean c11 = sm.f.f75530c.a().c("download_foreground_service", false);
        if (c11 != null && (value = c11.getValue()) != null && (m12 = StringsKt.m1(value)) != null) {
            z10 = m12.booleanValue();
        }
        f59631c = z10;
        k.d(o0.a(y0.c()), null, null, new DownloadNotificationUtils$createNotification$1(downloadInfo, null), 3, null);
    }

    public final void x() {
        k.d(o0.a(y0.b()), null, null, new DownloadNotificationUtils$getLatestDownloadVideo$1(null), 3, null);
    }

    public final int z(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        return A(downloadInfo.getUrl(), downloadInfo.getResourceId());
    }
}
