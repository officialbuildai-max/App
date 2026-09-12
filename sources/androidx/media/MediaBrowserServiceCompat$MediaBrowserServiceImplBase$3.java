package androidx.media;

import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.j this$1;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;
    final /* synthetic */ b val$remoteUserInfo;

    MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3(MediaBrowserServiceCompat.j jVar, b bVar, String str, Bundle bundle) {
        this.val$remoteUserInfo = bVar;
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i11 = 0; i11 < this.this$1.f9841a.f9797e.size(); i11++) {
            MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.f9841a.f9797e.valueAt(i11);
            if (connectionRecord.f9804d.equals(this.val$remoteUserInfo)) {
                this.this$1.c(connectionRecord, this.val$parentId, this.val$options);
                return;
            }
        }
    }
}
