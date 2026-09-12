package com.transsion.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.NotificationCompat;
import androidx.core.app.t;
import androidx.media3.common.util.g0;
import androidx.view.v;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.api.PermanentPushMessage;
import com.transsion.mpush.core.config.PermanentConfig;
import com.transsion.mpush.core.config.PushMsgSource;
import com.transsion.mpush.core.net.SdkPullMsgResp;
import com.transsion.mpush.core.renderer.s;
import com.transsion.push.feature.activate.ActivatePushFeature;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\bJ\u0019\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/transsion/push/PushTestActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "initView", "", "d0", "()Ljava/lang/String;", "x0", "u0", "w0", "", "grouped", "t0", "(Z)V", "c0", "o0", "()Z", "v0", "", "s0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/transsion/mpush/api/LocalPushMessage;", "p0", "()Ljava/util/List;", "Lcom/transsion/mpush/core/net/SdkPullMsgResp;", "q0", "()Lcom/transsion/mpush/core/net/SdkPullMsgResp;", "path", "r0", "(Ljava/lang/String;)Ljava/lang/String;", "e0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "a", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PushTestActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f50841b = new AtomicInteger(200000);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f50842c = new AtomicInteger(0);

    private final void c0() {
        NotificationManager notificationManager;
        NotificationChannel notificationChannel;
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) getSystemService(NotificationManager.class)) != null) {
            notificationChannel = notificationManager.getNotificationChannel("push_test_independent_channel");
            if (notificationChannel != null) {
                return;
            }
            g0.a();
            NotificationChannel a11 = m.f.a("push_test_independent_channel", "Push Test Independent", 4);
            a11.setDescription("Push independent test channel");
            a11.setShowBadge(true);
            notificationManager.createNotificationChannel(a11);
        }
    }

    private final String d0() {
        EditText editText = (EditText) findViewById(com.transsion.lib.push.R$id.edTitle);
        Editable text = editText != null ? editText.getText() : null;
        return (text == null || text.length() == 0) ? "Notification Title Test ------- Notification Title Test ------- Notification Title Test" : text.toString();
    }

    private final String e0() {
        return "push/notification.json";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(PushTestActivity pushTestActivity, View view) {
        pushTestActivity.v0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(PushTestActivity pushTestActivity, View view) {
        pushTestActivity.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(PushTestActivity pushTestActivity, View view) {
        pushTestActivity.t0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(PushTestActivity pushTestActivity, View view) {
        pushTestActivity.t0(true);
    }

    private final void initView() {
        final AppCompatButton appCompatButton = (AppCompatButton) findViewById(com.transsion.lib.push.R$id.simulate_schedule_push);
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.show_permanent_notification)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.f0(PushTestActivity.this, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.show_notification)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.g0(PushTestActivity.this, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.show_independent_notification_no_group)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.h0(PushTestActivity.this, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.show_independent_notification_group)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.i0(PushTestActivity.this, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.pull_local_push)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.j0(PushTestActivity.this, appCompatButton, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.pull_local_push_mock)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.k0(PushTestActivity.this, appCompatButton, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.simulate_schedule_push)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.l0(PushTestActivity.this, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.show_local_list)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.m0(PushTestActivity.this, view);
            }
        });
        ((AppCompatButton) findViewById(com.transsion.lib.push.R$id.btn_test_activate_push)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.push.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushTestActivity.n0(PushTestActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(PushTestActivity pushTestActivity, AppCompatButton appCompatButton, View view) {
        kotlinx.coroutines.k.d(v.a(pushTestActivity), null, null, new PushTestActivity$initView$5$1(appCompatButton, pushTestActivity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(PushTestActivity pushTestActivity, AppCompatButton appCompatButton, View view) {
        kotlinx.coroutines.k.d(v.a(pushTestActivity), null, null, new PushTestActivity$initView$6$1(appCompatButton, pushTestActivity, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(PushTestActivity pushTestActivity, View view) {
        pushTestActivity.x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(PushTestActivity pushTestActivity, View view) {
        pushTestActivity.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PushTestActivity pushTestActivity, View view) {
        Toast.makeText(pushTestActivity, "触发激活广告推送", 0).show();
        ActivatePushFeature activatePushFeature = new ActivatePushFeature();
        activatePushFeature.init(pushTestActivity);
        activatePushFeature.onTrigger(4);
    }

    private final boolean o0() {
        return Build.VERSION.SDK_INT < 33 || androidx.core.content.b.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0;
    }

    private final List p0() {
        SdkPullMsgResp q02 = q0();
        List<LocalPushMessage> items = q02 != null ? q02.getItems() : null;
        return items == null ? CollectionsKt.l() : items;
    }

    private final SdkPullMsgResp q0() {
        Object m1185constructorimpl;
        String r02;
        try {
            Result.Companion companion = Result.INSTANCE;
            r02 = r0(e0());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (r02 == null) {
            return null;
        }
        m1185constructorimpl = Result.m1185constructorimpl((SdkPullMsgResp) com.blankj.utilcode.util.o.d(r02, SdkPullMsgResp.class));
        return (SdkPullMsgResp) (Result.m1191isFailureimpl(m1185constructorimpl) ? null : m1185constructorimpl);
    }

    private final String r0(String path) {
        Object m1185constructorimpl;
        Object m1185constructorimpl2;
        BufferedReader bufferedReader;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream open = getAssets().open(path);
            Intrinsics.g(open, "open(...)");
            bufferedReader = new BufferedReader(new InputStreamReader(open, Charsets.UTF_8), 8192);
            try {
                String e11 = TextStreamsKt.e(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                m1185constructorimpl = Result.m1185constructorimpl(e11);
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        String str = (String) m1185constructorimpl;
        if (str != null) {
            return str;
        }
        try {
            InputStream open2 = getAssets().open("push/1/notification.json");
            Intrinsics.g(open2, "open(...)");
            bufferedReader = new BufferedReader(new InputStreamReader(open2, Charsets.UTF_8), 8192);
            try {
                String e12 = TextStreamsKt.e(bufferedReader);
                CloseableKt.a(bufferedReader, null);
                m1185constructorimpl2 = Result.m1185constructorimpl(e12);
            } finally {
            }
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.INSTANCE;
            m1185constructorimpl2 = Result.m1185constructorimpl(ResultKt.a(th3));
        }
        return (String) (Result.m1191isFailureimpl(m1185constructorimpl2) ? null : m1185constructorimpl2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s0(kotlin.coroutines.Continuation r37) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.PushTestActivity.s0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void t0(boolean grouped) {
        if (!o0()) {
            Toast.makeText(this, getString(com.transsion.lib.push.R$string.push_test_no_notification_permission), 0).show();
            return;
        }
        c0();
        String str = grouped ? "RAW-GROUP" : "RAW-NO-GROUP";
        int i11 = 0;
        while (i11 < 4) {
            int incrementAndGet = f50842c.incrementAndGet();
            int incrementAndGet2 = f50841b.incrementAndGet();
            i11++;
            String str2 = "pkg=" + getPackageName() + ", seq=" + incrementAndGet + ", idx=" + i11 + "/4, grouped=" + grouped;
            NotificationCompat.m I = new NotificationCompat.m(this, "push_test_independent_channel").J(com.transsion.lib.push.R$drawable.push_small_logo).l(true).G(1).q(str + " " + d0() + " #" + incrementAndGet).p(str2).L(new NotificationCompat.k().q(str2)).P(System.currentTimeMillis()).I(true);
            Intrinsics.g(I, "setShowWhen(...)");
            if (grouped) {
                I.y("push_test_independent_group_key").z(false);
            }
            t.d(this).f(incrementAndGet2, I.c());
        }
        Toast.makeText(this, getString(grouped ? com.transsion.lib.push.R$string.push_test_raw_group_sent : com.transsion.lib.push.R$string.push_test_raw_no_group_sent), 0).show();
    }

    private final void u0() {
        kotlinx.coroutines.k.d(v.a(this), null, null, new PushTestActivity$showLocalPushList$1(this, null), 3, null);
    }

    private final void v0() {
        List p02 = p0();
        if (p02.isEmpty()) {
            Toast.makeText(this, getString(com.transsion.lib.push.R$string.push_test_pull_parse_failed), 0).show();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List K0 = CollectionsKt.K0(p02, 10);
        ArrayList arrayList = new ArrayList(CollectionsKt.v(K0, 10));
        int i11 = 0;
        for (Object obj : K0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            LocalPushMessage localPushMessage = (LocalPushMessage) obj;
            String messageId = localPushMessage.getMessageId();
            if (messageId == null) {
                messageId = currentTimeMillis + "_" + i11;
            }
            String deeplink = localPushMessage.getDeeplink();
            arrayList.add(new PermanentPushMessage(0, deeplink != null ? StringsKt.Q(deeplink, "%MSGID%", messageId, false, 4, null) : null, messageId, (String) CollectionsKt.k0(localPushMessage.getImageArray()), localPushMessage.getTitle(), 1, null));
            i11 = i12;
        }
        new com.transsion.mpush.core.renderer.v().J(this, arrayList, new PermanentConfig(true, null, 0, d0(), 4, null));
        Toast.makeText(this, "show permanent size=" + arrayList.size(), 0).show();
    }

    private final void w0() {
        LocalPushMessage copy;
        LocalPushMessage localPushMessage = (LocalPushMessage) CollectionsKt.k0(p0());
        if (localPushMessage == null) {
            Toast.makeText(this, getString(com.transsion.lib.push.R$string.push_test_pull_parse_failed), 0).show();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(currentTimeMillis);
        String d02 = d0();
        String source = localPushMessage.getSource();
        if (source == null) {
            source = PushMsgSource.SOURCE_PUSH;
        }
        String str = source;
        String type = localPushMessage.getType();
        if (type == null) {
            type = "1";
        }
        copy = localPushMessage.copy((r38 & 1) != 0 ? localPushMessage.id : 0, (r38 & 2) != 0 ? localPushMessage.messageId : valueOf, (r38 & 4) != 0 ? localPushMessage.title : d02, (r38 & 8) != 0 ? localPushMessage.desc : null, (r38 & 16) != 0 ? localPushMessage.deeplink : null, (r38 & 32) != 0 ? localPushMessage.imageList : null, (r38 & 64) != 0 ? localPushMessage.pushTime : null, (r38 & 128) != 0 ? localPushMessage.source : str, (r38 & 256) != 0 ? localPushMessage.style : null, (r38 & 512) != 0 ? localPushMessage.type : type, (r38 & 1024) != 0 ? localPushMessage.receiveTime : currentTimeMillis, (r38 & 2048) != 0 ? localPushMessage.msgStatus : 0, (r38 & 4096) != 0 ? localPushMessage.showTime : 0L, (r38 & 8192) != 0 ? localPushMessage.forceShow : false, (r38 & 16384) != 0 ? localPushMessage.hasScreenOn : false, (r38 & 32768) != 0 ? localPushMessage.extraMap : null, (r38 & 65536) != 0 ? localPushMessage.builtIn : true, (r38 & 131072) != 0 ? localPushMessage.permanentMsgStatus : 0);
        String deeplink = copy.getDeeplink();
        copy.setDeeplink(deeplink != null ? StringsKt.Q(deeplink, "%MSGID%", valueOf, false, 4, null) : null);
        new s().show(this, copy);
        Toast.makeText(this, "show standard msgId=" + valueOf, 0).show();
    }

    private final void x0() {
        kotlinx.coroutines.k.d(v.a(this), null, null, new PushTestActivity$simulateSchedulePush$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.transsion.lib.push.R$layout.activity_push_test);
        initView();
    }
}
