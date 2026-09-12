package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f8131a = (IconCompat) versionedParcel.v(remoteActionCompat.f8131a, 1);
        remoteActionCompat.f8132b = versionedParcel.l(remoteActionCompat.f8132b, 2);
        remoteActionCompat.f8133c = versionedParcel.l(remoteActionCompat.f8133c, 3);
        remoteActionCompat.f8134d = (PendingIntent) versionedParcel.r(remoteActionCompat.f8134d, 4);
        remoteActionCompat.f8135e = versionedParcel.h(remoteActionCompat.f8135e, 5);
        remoteActionCompat.f8136f = versionedParcel.h(remoteActionCompat.f8136f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f8131a, 1);
        versionedParcel.D(remoteActionCompat.f8132b, 2);
        versionedParcel.D(remoteActionCompat.f8133c, 3);
        versionedParcel.H(remoteActionCompat.f8134d, 4);
        versionedParcel.z(remoteActionCompat.f8135e, 5);
        versionedParcel.z(remoteActionCompat.f8136f, 6);
    }
}
