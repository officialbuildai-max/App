package androidx.work;

import android.app.Notification;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final int f15571a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15572b;

    /* renamed from: c, reason: collision with root package name */
    private final Notification f15573c;

    public i(int i11, Notification notification, int i12) {
        this.f15571a = i11;
        this.f15573c = notification;
        this.f15572b = i12;
    }

    public int a() {
        return this.f15572b;
    }

    public Notification b() {
        return this.f15573c;
    }

    public int c() {
        return this.f15571a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f15571a == iVar.f15571a && this.f15572b == iVar.f15572b) {
            return this.f15573c.equals(iVar.f15573c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f15571a * 31) + this.f15572b) * 31) + this.f15573c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f15571a + ", mForegroundServiceType=" + this.f15572b + ", mNotification=" + this.f15573c + '}';
    }
}
