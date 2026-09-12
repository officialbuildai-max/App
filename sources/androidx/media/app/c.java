package androidx.media.app;

import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.o;

/* loaded from: classes.dex */
public class c extends NotificationCompat.p {

    /* renamed from: f, reason: collision with root package name */
    MediaSessionCompat.Token f9851f;

    /* renamed from: g, reason: collision with root package name */
    CharSequence f9852g;

    /* renamed from: h, reason: collision with root package name */
    int f9853h;

    /* renamed from: i, reason: collision with root package name */
    PendingIntent f9854i;

    /* renamed from: e, reason: collision with root package name */
    int[] f9850e = null;

    /* renamed from: j, reason: collision with root package name */
    boolean f9855j = false;

    @Override // androidx.core.app.NotificationCompat.p
    public void b(o oVar) {
        if (Build.VERSION.SDK_INT >= 34) {
            a.d(oVar.a(), a.b(b.a(a.a(), this.f9852g, this.f9853h, this.f9854i, Boolean.valueOf(this.f9855j)), this.f9850e, this.f9851f));
        } else {
            a.d(oVar.a(), a.b(a.a(), this.f9850e, this.f9851f));
        }
    }

    @Override // androidx.core.app.NotificationCompat.p
    public RemoteViews m(o oVar) {
        return null;
    }

    @Override // androidx.core.app.NotificationCompat.p
    public RemoteViews n(o oVar) {
        return null;
    }

    public c q(MediaSessionCompat.Token token) {
        this.f9851f = token;
        return this;
    }

    public c r(int... iArr) {
        this.f9850e = iArr;
        return this;
    }
}
