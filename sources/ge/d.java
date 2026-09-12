package ge;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* loaded from: classes5.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final Context f63683a;

    /* renamed from: b, reason: collision with root package name */
    private final AudioManager f63684b;

    /* renamed from: c, reason: collision with root package name */
    private final a f63685c;

    /* renamed from: d, reason: collision with root package name */
    private final c f63686d;

    /* renamed from: e, reason: collision with root package name */
    private float f63687e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f63683a = context;
        this.f63684b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f63685c = aVar;
        this.f63686d = cVar;
    }

    private float a() {
        return this.f63685c.a(this.f63684b.getStreamVolume(3), this.f63684b.getStreamMaxVolume(3));
    }

    private boolean b(float f11) {
        return f11 != this.f63687e;
    }

    private void c() {
        this.f63686d.a(this.f63687e);
    }

    public void d() {
        this.f63687e = a();
        c();
        this.f63683a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f63683a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        float a11 = a();
        if (b(a11)) {
            this.f63687e = a11;
            c();
        }
    }
}
