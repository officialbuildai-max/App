package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;

/* loaded from: classes2.dex */
public class s {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f20176b = new a(Utils.a().getPackageName(), Utils.a().getPackageName(), 3);

        /* renamed from: a, reason: collision with root package name */
        private NotificationChannel f20177a;

        public a(String str, CharSequence charSequence, int i11) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f20177a = m.f.a(str, charSequence, i11);
            }
        }

        public NotificationChannel b() {
            return this.f20177a;
        }
    }

    public static Notification a(a aVar, Utils.b bVar) {
        String id2;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            ((NotificationManager) Utils.a().getSystemService("notification")).createNotificationChannel(aVar.b());
        }
        NotificationCompat.m mVar = new NotificationCompat.m(Utils.a());
        if (i11 >= 26) {
            id2 = aVar.f20177a.getId();
            mVar.m(id2);
        }
        if (bVar != null) {
            bVar.accept(mVar);
        }
        return mVar.c();
    }
}
