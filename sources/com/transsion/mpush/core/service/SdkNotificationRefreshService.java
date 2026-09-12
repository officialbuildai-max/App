package com.transsion.mpush.core.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import be.g;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.api.PermanentPushMessage;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004*\u000237\u0018\u0000 \u000b2\u00020\u0001:\u0002 $B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J)\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0003R \u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u00108¨\u0006:"}, d2 = {"Lcom/transsion/mpush/core/service/SdkNotificationRefreshService;", "Landroid/app/Service;", "<init>", "()V", "", "message", "", "i", "(Ljava/lang/Object;)V", j.f35620b, "", "h", "()J", CampaignEx.JSON_KEY_AD_K, "", "msgId", "", g.f16474b, "(Ljava/lang/String;)I", "onCreate", "Landroid/content/Intent;", "intent", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "", "Ljava/lang/ref/SoftReference;", "a", "Ljava/util/List;", "msgList", "Landroid/app/NotificationManager;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/app/NotificationManager;", "manager", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", "", "d", "Z", "isRepeating", "Lcom/transsion/mpush/core/service/SdkNotificationRefreshService$b;", "e", "Lcom/transsion/mpush/core/service/SdkNotificationRefreshService$b;", "binder", "com/transsion/mpush/core/service/SdkNotificationRefreshService$localReceiver$1", "f", "Lcom/transsion/mpush/core/service/SdkNotificationRefreshService$localReceiver$1;", "localReceiver", "com/transsion/mpush/core/service/SdkNotificationRefreshService$runnable$1", "Lcom/transsion/mpush/core/service/SdkNotificationRefreshService$runnable$1;", "runnable", "MBPush_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SdkNotificationRefreshService extends Service {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private NotificationManager manager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Handler handler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRepeating;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List msgList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b binder = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SdkNotificationRefreshService$localReceiver$1 localReceiver = new BroadcastReceiver() { // from class: com.transsion.mpush.core.service.SdkNotificationRefreshService$localReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra = intent != null ? intent.getParcelableExtra("message") : null;
            a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onReceive -> Msg: " + parcelableExtra, false, 4, null);
            SdkNotificationRefreshService.this.i(parcelableExtra);
        }
    };

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final SdkNotificationRefreshService$runnable$1 runnable = new SdkNotificationRefreshService$runnable$1(this);

    /* loaded from: classes6.dex */
    public static final class b extends Binder {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g(String msgId) {
        if (TextUtils.isEmpty(msgId)) {
            return Math.abs((int) System.currentTimeMillis());
        }
        return Math.abs(msgId != null ? msgId.hashCode() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long h() {
        return RangesKt.g(ln.a.f69101a.i().getRefreshTime(), 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(Object message) {
        if (message == null) {
            return;
        }
        Object obj = null;
        if (message instanceof PermanentPushMessage) {
            Iterator it = this.msgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SoftReference) next).get() instanceof PermanentPushMessage) {
                    obj = next;
                    break;
                }
            }
            SoftReference softReference = (SoftReference) obj;
            if (softReference != null) {
                this.msgList.remove(softReference);
            }
            this.msgList.add(new SoftReference(message));
            a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onShowMessage -> Cached Permanent", false, 4, null);
            return;
        }
        if (message instanceof LocalPushMessage) {
            LocalPushMessage localPushMessage = (LocalPushMessage) message;
            String messageId = localPushMessage.getMessageId();
            if (messageId == null || messageId.length() == 0) {
                return;
            }
            Iterator it2 = this.msgList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Object obj2 = ((SoftReference) next2).get();
                LocalPushMessage localPushMessage2 = obj2 instanceof LocalPushMessage ? (LocalPushMessage) obj2 : null;
                if (Intrinsics.c(localPushMessage2 != null ? localPushMessage2.getMessageId() : null, localPushMessage.getMessageId())) {
                    obj = next2;
                    break;
                }
            }
            if (obj == null) {
                this.msgList.add(new SoftReference(message));
                a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onShowMessage -> Cached Local: " + localPushMessage.getMessageId(), false, 4, null);
            }
        }
        if (this.msgList.size() >= 4) {
            if (!(((SoftReference) this.msgList.get(0)).get() instanceof PermanentPushMessage)) {
                this.msgList.remove(0);
                a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onShowMessage -> Evicted Oldest", false, 4, null);
            } else if (this.msgList.size() > 1) {
                this.msgList.remove(1);
                a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onShowMessage -> Evicted Old Local", false, 4, null);
            }
        }
    }

    private final void j() {
        if (this.isRepeating) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] startRepeat", false, 4, null);
        if (this.manager == null) {
            Object systemService = getApplicationContext().getSystemService("notification");
            this.manager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(this.runnable, h());
        }
        this.isRepeating = true;
    }

    private final void k() {
        this.isRepeating = false;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onCreate", false, 4, null);
        j();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.transsion.mpush.action.NEW_MESSAGE");
        r1.a.b(this).c(this.localReceiver, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.C0856a.f(lg.a.f68962a, "SdkNoticeRefresh", "[SdkNotificationRefreshService] onDestroy", false, 4, null);
        k();
        r1.a.b(this).e(this.localReceiver);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }
}
