package com.transsion.sunflower;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.g0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m.f;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f55184d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f55185a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55186b;

    /* renamed from: c, reason: collision with root package name */
    private NotificationChannel f55187c;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i11) {
            Intrinsics.h(context, "context");
            Object systemService = context.getSystemService("notification");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            try {
                ((NotificationManager) systemService).cancel(i11);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public c(Context context, String channelId, String channelName) {
        Intrinsics.h(context, "context");
        Intrinsics.h(channelId, "channelId");
        Intrinsics.h(channelName, "channelName");
        this.f55185a = channelId;
        this.f55186b = channelName;
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            NotificationChannel a11 = f.a(channelId, channelName, 4);
            this.f55187c = a11;
            a11.setSound(null, null);
            NotificationChannel notificationChannel = this.f55187c;
            if (notificationChannel != null) {
                notificationChannel.enableVibration(false);
            }
            NotificationChannel notificationChannel2 = this.f55187c;
            if (notificationChannel2 != null) {
                notificationChannel2.setLockscreenVisibility(-1);
            }
            Object systemService = context.getSystemService("notification");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationChannel notificationChannel3 = this.f55187c;
            Intrinsics.e(notificationChannel3);
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel3);
        }
    }

    public final void a(Context context, NotificationCompat.m builder, PendingIntent pendingIntent, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(builder, "builder");
        builder.x(pendingIntent, true);
        try {
            Object systemService = context.getSystemService("notification");
            Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            notificationManager.cancel(i11);
            notificationManager.notify(i11, builder.c());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
