package com.google.android.exoplayer2.util;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes3.dex */
public abstract class b0 {
    public static void a(Context context, String str, int i11, int i12, int i13) {
        if (p0.f27680a >= 26) {
            NotificationManager notificationManager = (NotificationManager) a.e((NotificationManager) context.getSystemService("notification"));
            androidx.media3.common.util.g0.a();
            NotificationChannel a11 = m.f.a(str, context.getString(i11), i13);
            if (i12 != 0) {
                a11.setDescription(context.getString(i12));
            }
            notificationManager.createNotificationChannel(a11);
        }
    }
}
