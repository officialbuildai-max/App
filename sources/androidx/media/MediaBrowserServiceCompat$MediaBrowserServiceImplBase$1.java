package androidx.media;

import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

/* loaded from: classes.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.j this$1;
    final /* synthetic */ MediaSessionCompat.Token val$token;

    MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(MediaBrowserServiceCompat.j jVar, MediaSessionCompat.Token token) {
        this.val$token = token;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<Object> it = this.this$1.f9841a.f9797e.values().iterator();
        while (it.hasNext()) {
            MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) it.next();
            try {
                connectionRecord.f9806f.c(connectionRecord.f9808h.d(), this.val$token, connectionRecord.f9808h.c());
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Connection for " + connectionRecord.f9801a + " is no longer valid.");
                it.remove();
            }
        }
    }
}
