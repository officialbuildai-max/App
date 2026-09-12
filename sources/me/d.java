package me;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes5.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final Context f69637a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioManager f69638b;

    /* renamed from: c, reason: collision with root package name */
    private final a f69639c;

    /* renamed from: d, reason: collision with root package name */
    private final c f69640d;

    /* renamed from: e, reason: collision with root package name */
    private float f69641e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f69637a = context;
        this.f69638b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f69639c = aVar;
        this.f69640d = cVar;
    }

    private float a() {
        return this.f69639c.a(this.f69638b.getStreamVolume(3), this.f69638b.getStreamMaxVolume(3));
    }

    private boolean b(float f11) {
        return f11 != this.f69641e;
    }

    private void c() {
        this.f69640d.a(this.f69641e);
    }

    public void d() {
        this.f69641e = a();
        c();
        this.f69637a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f69637a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float a11 = a();
        if (b(a11)) {
            this.f69641e = a11;
            c();
        }
    }
}
