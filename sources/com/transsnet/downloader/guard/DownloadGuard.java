package com.transsnet.downloader.guard;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$drawable;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.n;
import com.transsion.mpush.core.config.PushMsgSource;
import com.transsion.mpush.core.config.PushMsgType;
import com.transsion.push.api.IPushProvider;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import m.f;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public final class DownloadGuard {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadGuard f59507a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f59508b;

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f59509c;

    /* renamed from: d, reason: collision with root package name */
    private static Map f59510d;

    /* renamed from: e, reason: collision with root package name */
    private static final NotificationManager f59511e;

    /* renamed from: f, reason: collision with root package name */
    private static Map f59512f;

    /* loaded from: classes7.dex */
    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Intrinsics.h(name, "name");
            Intrinsics.h(service, "service");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.h(name, "name");
        }
    }

    static {
        DownloadGuard downloadGuard = new DownloadGuard();
        f59507a = downloadGuard;
        f59509c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.guard.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n0 d11;
                d11 = DownloadGuard.d();
                return d11;
            }
        });
        f59510d = new LinkedHashMap();
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        f59511e = notificationManager;
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            notificationManager.createNotificationChannel(f.a(downloadGuard.f(), Utils.a().getString(R$string.download_notifications_name), 2));
        }
        f59512f = new LinkedHashMap();
    }

    private DownloadGuard() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 d() {
        return o0.a(y0.b());
    }

    private final n0 e() {
        return (n0) f59509c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.notification_download_complete : R$layout.notification_download_complete_v12;
    }

    private final String h(DownloadBean downloadBean) {
        return (downloadBean.isSeries() ? downloadBean.getSubjectName() : downloadBean.getName()) + " " + (downloadBean.getEpse() > 0 ? downloadBean.getEp() > 0 ? n.b(downloadBean.getEp(), downloadBean.getSe(), downloadBean.isVideo()) : n.c(downloadBean.getEpse(), downloadBean.isVideo()) : "");
    }

    private final int i() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.notification_downloading : R$layout.notification_downloading_v12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationCompat.m j(DownloadBean downloadBean) {
        Long size;
        int i11 = Build.VERSION.SDK_INT >= 31 ? 67108864 : ASTNode.NOJIT;
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        if (iPushProvider == null) {
            return null;
        }
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent a12 = iPushProvider.a(a11);
        DownloadGuard downloadGuard = f59507a;
        int k11 = downloadGuard.k(downloadBean);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(k11);
        a12.putExtra("notification_id", sb2.toString());
        a12.putExtra("msg_source", PushMsgSource.SOURCE_PUSH);
        a12.putExtra("msg_type", PushMsgType.DOWNLOAD_PUSH.getType());
        int k12 = downloadGuard.k(downloadBean);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(k12);
        a12.putExtra("msg_id", sb3.toString());
        a12.addFlags(603979776);
        a12.setData(Uri.parse("oneroom://com.community.oneroom?type=/download/panel_activity" + UrlUtils.AND_MARK + "download_notify" + UrlUtils.EQUAL_MARK + 10 + UrlUtils.AND_MARK + OfflineConstantsKt.TRACK_KEY_PRE_DOWNLOAD_STATUS + UrlUtils.EQUAL_MARK + downloadBean.getStatus() + "&channel=download_notification"));
        PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, a12, i11);
        String h11 = h(downloadBean);
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
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), i());
        remoteViews.setProgressBar(R$id.progress, 100, longValue, false);
        remoteViews.setTextViewText(R$id.tv_name, downloadBean.getTitleName());
        remoteViews.setTextViewText(R$id.tv_epse, downloadBean.getEpName());
        remoteViews.setTextViewText(R$id.tv_size, i.b(progress, 1) + "/" + i.b(j11, 1));
        return new NotificationCompat.m(Utils.a(), f()).J(R$drawable.push_small_logo).p(h11).o(activity).l(false).s(remoteViews).E(true).l(false).F(true).r(remoteViews);
    }

    private final int k(DownloadBean downloadBean) {
        return l(downloadBean.getUrl(), downloadBean.getResourceId());
    }

    private final int l(String str, String str2) {
        if (str2 == null) {
            str2 = str;
        }
        int abs = Math.abs(str2.hashCode());
        return abs <= 0 ? Math.abs(str.hashCode()) : abs;
    }

    private final void m(DownloadBean downloadBean) {
        int k11 = k(downloadBean);
        f59510d.remove(Integer.valueOf(k11));
        f59511e.cancel(k11);
        k.d(e(), null, null, new DownloadGuard$otherStatus$1(downloadBean, null), 3, null);
    }

    private final void n(DownloadBean downloadBean) {
        int k11 = k(downloadBean);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l11 = (Long) f59512f.get(Integer.valueOf(k11));
        if (elapsedRealtime - (l11 != null ? l11.longValue() : 0L) < 2000) {
            return;
        }
        f59512f.put(Integer.valueOf(k11), Long.valueOf(elapsedRealtime));
        k.d(e(), null, null, new DownloadGuard$progress$1(downloadBean, k11, null), 3, null);
    }

    private final void o(int i11) {
        try {
            Intent intent = new Intent();
            intent.setClass(Utils.a(), DownloadGuardService.class);
            intent.putExtra("id", i11);
            if (Build.VERSION.SDK_INT >= 26) {
                Utils.a().bindService(intent, new a(), 1);
            } else {
                Utils.a().startService(intent);
            }
        } catch (Throwable unused) {
        }
        f59508b = true;
    }

    public final String f() {
        return "download_service";
    }

    public final void p(DownloadBean downloadInfo) {
        Intrinsics.h(downloadInfo, "downloadInfo");
        int k11 = k(downloadInfo);
        boolean containsKey = f59510d.containsKey(Integer.valueOf(k11));
        f59511e.cancel(10086);
        if (!containsKey) {
            f59510d.put(Integer.valueOf(k11), "");
            o(k11);
        } else {
            int status = downloadInfo.getStatus();
            if (status == 1 || status == 2) {
                n(downloadInfo);
            } else {
                m(downloadInfo);
            }
        }
    }
}
