package com.iab.omid.library.bytedance2.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final Context f33484a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioManager f33485b;

    /* renamed from: c, reason: collision with root package name */
    private final a f33486c;

    /* renamed from: d, reason: collision with root package name */
    private final c f33487d;

    /* renamed from: e, reason: collision with root package name */
    private float f33488e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f33484a = context;
        this.f33485b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f33486c = aVar;
        this.f33487d = cVar;
    }

    private float a() {
        return this.f33486c.a(this.f33485b.getStreamVolume(3), this.f33485b.getStreamMaxVolume(3));
    }

    private boolean a(float f11) {
        return f11 != this.f33488e;
    }

    private void b() {
        this.f33487d.a(this.f33488e);
    }

    public void c() {
        this.f33488e = a();
        b();
        this.f33484a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f33484a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float a11 = a();
        if (a(a11)) {
            this.f33488e = a11;
            b();
        }
    }
}
