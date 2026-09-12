package com.transsion.ga;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.transsion.athena.athena;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.athena.taaneh.aethna;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AthenaAnalytics f44258a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AthenaAnalytics athenaAnalytics) {
        this.f44258a = athenaAnalytics;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        try {
            this.f44258a.f44225c = athena.AbstractBinderC0603athena.a(iBinder);
            this.f44258a.f44226d = true;
            aethna.c("AthenaTrackService onServiceConnected");
            copyOnWriteArrayList = this.f44258a.f44227e;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                TrackDataWrapper trackDataWrapper = (TrackDataWrapper) it.next();
                if (trackDataWrapper.c().c() < 524288) {
                    this.f44258a.A(trackDataWrapper.a(), trackDataWrapper.c(), trackDataWrapper.b());
                } else {
                    aethna.b("TrackData size is too large, ignored !!");
                }
            }
            copyOnWriteArrayList2 = this.f44258a.f44227e;
            copyOnWriteArrayList2.clear();
        } catch (Exception e11) {
            aethna.b(Log.getStackTraceString(e11));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f44258a.f44226d = false;
        aethna.c("AthenaTrackService onServiceDisconnected");
    }
}
