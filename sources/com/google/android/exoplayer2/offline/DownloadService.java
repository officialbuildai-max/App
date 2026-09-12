package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.p0;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class DownloadService extends Service {

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap f25609j = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final String f25610a;

    /* renamed from: b, reason: collision with root package name */
    private final int f25611b;

    /* renamed from: c, reason: collision with root package name */
    private final int f25612c;

    /* renamed from: d, reason: collision with root package name */
    private a f25613d;

    /* renamed from: e, reason: collision with root package name */
    private int f25614e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25615f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f25616g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25617h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f25618i;

    /* loaded from: classes3.dex */
    private static final class a {
        static /* synthetic */ DownloadManager a(a aVar) {
            aVar.getClass();
            return null;
        }

        public abstract void b(DownloadService downloadService);

        public abstract void c(DownloadService downloadService);
    }

    protected abstract DownloadManager a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f25610a;
        if (str != null) {
            b0.a(this, str, this.f25611b, this.f25612c, 2);
        }
        int i11 = p0.f27680a;
        a();
        throw null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f25618i = true;
        ((a) com.google.android.exoplayer2.util.a.e(this.f25613d)).c(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009e, code lost:
    
        if (r3.equals("com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS") == false) goto L17;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int onStartCommand(android.content.Intent r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f25616g = true;
    }
}
