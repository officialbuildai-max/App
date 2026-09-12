package com.transsion.athena.enatha;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.transsion.athena.data.TrackData;

/* loaded from: classes5.dex */
public abstract class athena {

    /* renamed from: a, reason: collision with root package name */
    protected Context f42775a;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f42776b;

    public athena(Context context) {
        this.f42775a = context;
    }

    public void a() {
    }

    public void a(int i11) {
    }

    public abstract void a(Message message, long j11);

    public abstract void a(Runnable runnable);

    public abstract void a(Runnable runnable, long j11);

    public abstract void a(String str, TrackData trackData, long j11);

    public Handler b() {
        return this.f42776b;
    }

    public boolean c() {
        return true;
    }

    public void d() {
    }

    public void e() {
    }
}
