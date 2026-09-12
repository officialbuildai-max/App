package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    public static double f36562f = -1.0d;

    /* renamed from: a, reason: collision with root package name */
    private Context f36563a;

    /* renamed from: b, reason: collision with root package name */
    private AudioManager f36564b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f36565c = false;

    /* renamed from: d, reason: collision with root package name */
    private b f36566d;

    /* renamed from: e, reason: collision with root package name */
    private a f36567e;

    /* loaded from: classes5.dex */
    private static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f36568a;

        public a(d dVar) {
            this.f36568a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d dVar;
            b b11;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.f36568a.get()) == null || (b11 = dVar.b()) == null) {
                return;
            }
            double a11 = dVar.a();
            if (a11 >= 0.0d) {
                b11.a(a11);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(double d11);
    }

    public d(Context context) {
        this.f36563a = context;
        this.f36564b = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public double a() {
        AudioManager audioManager = this.f36564b;
        double streamVolume = ((this.f36564b != null ? r3.getStreamVolume(3) : -1) * 100.0d) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1);
        f36562f = streamVolume;
        return streamVolume;
    }

    public void a(b bVar) {
        this.f36566d = bVar;
    }

    public b b() {
        return this.f36566d;
    }

    public void c() {
        if (this.f36563a != null) {
            this.f36567e = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f36563a.registerReceiver(this.f36567e, intentFilter);
            this.f36565c = true;
        }
    }

    public void d() {
        Context context;
        if (!this.f36565c || (context = this.f36563a) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f36567e);
            this.f36566d = null;
            this.f36565c = false;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
