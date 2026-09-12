package com.transsion.athena.hatnea;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes5.dex */
public class atnhae extends anateh {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f42827c = {"https://time1.google.com", "https://time.cloudflare.com", "https://www.pool.ntp.org"};

    /* renamed from: d, reason: collision with root package name */
    private int f42828d;

    public atnhae(Handler handler) {
        super(handler);
        this.f42828d = 0;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        Message obtainMessage = this.f42815a.obtainMessage(503);
        obtainMessage.obj = 0L;
        while (true) {
            int i11 = this.f42828d;
            if (i11 >= 3) {
                break;
            }
            ehanat<Long> a11 = anehat.a(f42827c[i11]);
            if (a11.f42830a == 0) {
                obtainMessage.obj = a11.f42831b;
                break;
            }
            this.f42828d++;
        }
        this.f42815a.sendMessageAtFrontOfQueue(obtainMessage);
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Retrieve-Time";
    }
}
