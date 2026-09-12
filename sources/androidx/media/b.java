package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    c f9856a;

    public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String a11 = h.a(remoteUserInfo);
        if (a11 == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(a11)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        this.f9856a = new h(remoteUserInfo);
    }

    public b(String str, int i11, int i12) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f9856a = new h(str, i11, i12);
        } else {
            this.f9856a = new i(str, i11, i12);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f9856a.equals(((b) obj).f9856a);
        }
        return false;
    }

    public int hashCode() {
        return this.f9856a.hashCode();
    }
}
