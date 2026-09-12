package com.transsion.shorttv.base.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class DeviceKeyMonitor {

    /* renamed from: e, reason: collision with root package name */
    public static final a f52882e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Context f52883a;

    /* renamed from: b, reason: collision with root package name */
    private final b f52884b;

    /* renamed from: c, reason: collision with root package name */
    private final String f52885c;

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f52886d;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onHomeClick();

        void onRecentClick();
    }

    public DeviceKeyMonitor(Context context, b listener) {
        Intrinsics.h(context, "context");
        Intrinsics.h(listener, "listener");
        this.f52883a = context;
        this.f52884b = listener;
        this.f52885c = "DeviceKeyMonitor";
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.transsion.shorttv.base.util.DeviceKeyMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.h(context2, "context");
                Intrinsics.h(intent, "intent");
                if (Intrinsics.c(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    String stringExtra = intent.getStringExtra("reason");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    int hashCode = stringExtra.hashCode();
                    if (hashCode != -1408204183) {
                        if (hashCode != 350448461) {
                            if (hashCode == 1092716832 && stringExtra.equals("homekey")) {
                                DeviceKeyMonitor.this.f52884b.onHomeClick();
                                return;
                            }
                            return;
                        }
                        if (!stringExtra.equals("recentapps")) {
                            return;
                        }
                    } else if (!stringExtra.equals("assist")) {
                        return;
                    }
                    DeviceKeyMonitor.this.f52884b.onRecentClick();
                }
            }
        };
        this.f52886d = broadcastReceiver;
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2) : context.registerReceiver(broadcastReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS")));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void b() {
        try {
            Result.Companion companion = Result.INSTANCE;
            BroadcastReceiver broadcastReceiver = this.f52886d;
            if (broadcastReceiver != null) {
                this.f52883a.unregisterReceiver(broadcastReceiver);
                this.f52886d = null;
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }
}
