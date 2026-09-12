package se;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes5.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final Context f75461a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioManager f75462b;

    /* renamed from: c, reason: collision with root package name */
    private final a f75463c;

    /* renamed from: d, reason: collision with root package name */
    private final c f75464d;

    /* renamed from: e, reason: collision with root package name */
    private float f75465e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f75461a = context;
        this.f75462b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f75463c = aVar;
        this.f75464d = cVar;
    }

    private float a() {
        return this.f75463c.a(this.f75462b.getStreamVolume(3), this.f75462b.getStreamMaxVolume(3));
    }

    private boolean b(float f11) {
        return f11 != this.f75465e;
    }

    private void c() {
        this.f75464d.a(this.f75465e);
    }

    public void d() {
        this.f75465e = a();
        c();
        this.f75461a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f75461a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float a11 = a();
        if (b(a11)) {
            this.f75465e = a11;
            c();
        }
    }
}
