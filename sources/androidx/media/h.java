package androidx.media;

import android.media.session.MediaSessionManager;

/* loaded from: classes.dex */
final class h extends i {

    /* renamed from: d, reason: collision with root package name */
    final MediaSessionManager.RemoteUserInfo f9857d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(android.media.session.MediaSessionManager.RemoteUserInfo r4) {
        /*
            r3 = this;
            java.lang.String r0 = androidx.media.e.a(r4)
            int r1 = androidx.media.f.a(r4)
            int r2 = androidx.media.g.a(r4)
            r3.<init>(r0, r1, r2)
            r3.f9857d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media.h.<init>(android.media.session.MediaSessionManager$RemoteUserInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, int i11, int i12) {
        super(str, i11, i12);
        this.f9857d = d.a(str, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String packageName;
        packageName = remoteUserInfo.getPackageName();
        return packageName;
    }
}
