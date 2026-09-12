package com.transsion.sunflower;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.WorkManager;
import androidx.work.b0;
import androidx.work.d;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class FSNManager {

    /* renamed from: f, reason: collision with root package name */
    public static final a f55175f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static volatile FSNManager f55176g;

    /* renamed from: a, reason: collision with root package name */
    private final d f55177a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f55178b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f55179c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f55180d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f55181e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FSNManager a() {
            return FSNManager.f55176g;
        }

        public final FSNManager b(d config) {
            Intrinsics.h(config, "config");
            FSNManager fSNManager = FSNManager.f55176g;
            if (fSNManager == null) {
                synchronized (this) {
                    fSNManager = new FSNManager(config, null);
                    FSNManager.f55176g = fSNManager;
                }
            }
            return fSNManager;
        }
    }

    private FSNManager(d dVar) {
        this.f55177a = dVar;
        this.f55178b = dVar.c();
        this.f55180d = LazyKt.b(new Function0<MMKV>() { // from class: com.transsion.sunflower.FSNManager$mmkv$2
            @Override // kotlin.jvm.functions.Function0
            public final MMKV invoke() {
                return MMKV.I("sunflower_app");
            }
        });
        this.f55181e = LazyKt.b(new Function0<c>() { // from class: com.transsion.sunflower.FSNManager$notificationHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                Context context;
                context = FSNManager.this.f55178b;
                return new c(context, "dauupupup", "dauupupup_name");
            }
        });
    }

    public /* synthetic */ FSNManager(d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
    }

    private final boolean e() {
        Object systemService = this.f55178b.getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isScreenOn();
    }

    private final boolean f(FSNConfig fSNConfig) {
        try {
            int i11 = Calendar.getInstance().get(11);
            int[] banTimeScope = fSNConfig.getBanTimeScope();
            List I0 = ArraysKt.I0(banTimeScope);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkBlockTimeWithConfig: hour:");
            sb2.append(i11);
            sb2.append(", banTimeScope:");
            sb2.append(I0);
            return ArraysKt.M(banTimeScope, i11);
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private final boolean h(FSNConfig fSNConfig) {
        Function0 g11;
        boolean enable = fSNConfig.getEnable();
        boolean z10 = !fSNConfig.getOnly4SilentUser() || ((g11 = this.f55177a.g()) != null && ((Boolean) g11.invoke()).booleanValue());
        boolean z11 = (System.currentTimeMillis() / ((long) 1000)) - j() > fSNConfig.getEffectInterval();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("effectBlock: ");
        sb2.append(!enable);
        sb2.append(", ");
        sb2.append(!z11);
        sb2.append(", ");
        sb2.append(!z10);
        return (enable && z11 && z10) ? false : true;
    }

    private final long i() {
        long delayTime;
        if (this.f55177a.j()) {
            FSNConfig b11 = this.f55177a.b();
            delayTime = b11 != null ? b11.getDelayTime() : 20L;
        } else {
            FSNConfig b12 = this.f55177a.b();
            delayTime = b12 != null ? b12.getDelayTime() : 900L;
        }
        return delayTime * 1000;
    }

    private final long j() {
        return k().getLong("dauupupup_last_effect_time", 0L);
    }

    private final c l() {
        return (c) this.f55181e.getValue();
    }

    private final List m(FSNConfig fSNConfig) {
        List U0;
        long currentTimeMillis = System.currentTimeMillis();
        int f11 = RangesKt.f(fSNConfig.getDayLimit(), 1);
        String string = k().getString("dauupupup_show_time_day", "");
        String str = string == null ? "" : string;
        if (str.length() == 0) {
            U0 = new ArrayList();
        } else {
            List R0 = StringsKt.R0(str, new char[]{','}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = R0.iterator();
            while (it.hasNext()) {
                Long x10 = StringsKt.x((String) it.next());
                if (x10 != null) {
                    arrayList.add(x10);
                }
            }
            U0 = CollectionsKt.U0(arrayList);
        }
        final long j11 = currentTimeMillis - (f11 * 86400000);
        CollectionsKt.I(U0, new Function1<Long, Boolean>() { // from class: com.transsion.sunflower.FSNManager$getShowListTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(long j12) {
                return Boolean.valueOf(j12 < j11);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).longValue());
            }
        });
        return U0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FSNManager this$0, String eventSource) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(eventSource, "$eventSource");
        this$0.r(eventSource);
    }

    private final boolean s(FSNConfig fSNConfig) {
        return m(fSNConfig).size() >= RangesKt.f(fSNConfig.getTimesLimit(), 1);
    }

    private final void u(FSNConfig fSNConfig) {
        k().putLong("dauupupup_last_effect_time", System.currentTimeMillis() / 1000);
        List m11 = m(fSNConfig);
        m11.add(Long.valueOf(System.currentTimeMillis()));
        k().putString("dauupupup_show_time_day", CollectionsKt.s0(m11, ",", null, null, 0, null, null, 62, null));
    }

    public final void g() {
        c.f55184d.a(this.f55178b, 10001);
    }

    public final MMKV k() {
        Object value = this.f55180d.getValue();
        Intrinsics.g(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final void n(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2128145023:
                    if (!str.equals("android.intent.action.SCREEN_OFF")) {
                        return;
                    }
                    break;
                case -1886648615:
                    if (!str.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        return;
                    }
                    break;
                case -1454123155:
                    if (str.equals("android.intent.action.SCREEN_ON")) {
                        g();
                        return;
                    }
                    return;
                case 823795052:
                    if (str.equals("android.intent.action.USER_PRESENT")) {
                        this.f55179c = false;
                        return;
                    }
                    return;
                case 1019184907:
                    if (!str.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            p(false, str);
        }
    }

    public final void o() {
        WorkManager.f(this.f55178b.getApplicationContext()).e("FSIWorker", ExistingPeriodicWorkPolicy.UPDATE, (b0) ((b0.a) new b0.a(FSIWorker.class, this.f55177a.j() ? 1L : 60L, TimeUnit.MINUTES).i(new d.a().a())).b());
    }

    public final void p(boolean z10, final String eventSource) {
        Intrinsics.h(eventSource, "eventSource");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 33) {
            return;
        }
        if (i11 < 24 || i11 > 33 || z10) {
            r(eventSource);
            return;
        }
        long i12 = i();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onReceive: fsi delay:");
        sb2.append(i12);
        sb2.append(" start");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object systemService = this.f55178b.getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
            ((AlarmManager) systemService).set(0, System.currentTimeMillis() + i(), "tag", new AlarmManager.OnAlarmListener() { // from class: com.transsion.sunflower.b
                @Override // android.app.AlarmManager.OnAlarmListener
                public final void onAlarm() {
                    FSNManager.q(FSNManager.this, eventSource);
                }
            }, new Handler(Looper.getMainLooper()));
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void r(String eventSource) {
        Intrinsics.h(eventSource, "eventSource");
        if (this.f55179c) {
            Function1 e11 = this.f55177a.e();
            if (e11 != null) {
                e11.invoke("block by had post");
                return;
            }
            return;
        }
        FSNConfig b11 = this.f55177a.b();
        if (b11 == null) {
            Function1 e12 = this.f55177a.e();
            if (e12 != null) {
                e12.invoke(" block by simba config null");
                return;
            }
            return;
        }
        Function0 i11 = this.f55177a.i();
        if (i11 != null && !((Boolean) i11.invoke()).booleanValue()) {
            Function1 e13 = this.f55177a.e();
            if (e13 != null) {
                e13.invoke(" block by app foreground");
                return;
            }
            return;
        }
        if (h(b11)) {
            Function1 e14 = this.f55177a.e();
            if (e14 != null) {
                e14.invoke(" block by remote switcher");
                return;
            }
            return;
        }
        if (s(b11)) {
            Function1 e15 = this.f55177a.e();
            if (e15 != null) {
                e15.invoke(" block by remote times limit");
                return;
            }
            return;
        }
        if (f(b11)) {
            Function1 e16 = this.f55177a.e();
            if (e16 != null) {
                e16.invoke(" block by time limit");
                return;
            }
            return;
        }
        if (e()) {
            Function1 e17 = this.f55177a.e();
            if (e17 != null) {
                e17.invoke(" block by remote screen state");
                return;
            }
            return;
        }
        Intent h11 = this.f55177a.h();
        if (h11 == null) {
            Function1 e18 = this.f55177a.e();
            if (e18 != null) {
                e18.invoke(" block by intent == null, deeplink:" + b11.getDeepLink());
                return;
            }
            return;
        }
        PendingIntent activity = PendingIntent.getActivity(this.f55178b, 1, h11, 201326592);
        c l11 = l();
        u(b11);
        Function1 f11 = this.f55177a.f();
        if (f11 != null) {
            f11.invoke(eventSource);
        }
        Context context = this.f55178b;
        NotificationCompat.m l12 = new NotificationCompat.m(context, "dauupupup").J(this.f55177a.d()).O(-1).l(true);
        Intrinsics.g(l12, "Builder(ctx, CHANNEL_ID)…     .setAutoCancel(true)");
        l11.a(context, l12, activity, 10001);
        this.f55179c = true;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendFSI-");
        sb2.append(eventSource);
        sb2.append(" done");
    }

    public final void t(FSNConfig fSNConfig) {
        this.f55177a.l(fSNConfig);
    }
}
