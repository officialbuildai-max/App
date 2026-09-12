package com.transsion.athena.hatnea;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class atenha extends anateh {

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.athena.config.data.model.enatha f42818c;

    /* renamed from: d, reason: collision with root package name */
    private final com.transsion.athena.aethna.aethna f42819d;

    public atenha(@NonNull Handler handler, com.transsion.athena.config.data.model.enatha enathaVar, com.transsion.athena.aethna.aethna aethnaVar) {
        super(handler);
        this.f42818c = enathaVar;
        this.f42819d = aethnaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        com.transsion.athena.aethna.aethna aethnaVar = this.f42819d;
        if (aethnaVar != null) {
            aethnaVar.a(0, false);
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        ehanat<String> a11 = anehat.a(com.transsion.athena.config.data.model.ehanat.i(), "", this.f42818c.i());
        if (a11.f42830a == -1 && com.transsion.athena.config.data.model.anehat.a(this.f42818c.b()) && com.transsion.athena.config.data.model.ehanat.u() && !this.f42815a.hasMessages(298)) {
            Message obtainMessage = this.f42815a.obtainMessage(298);
            obtainMessage.arg1 = 1;
            this.f42815a.sendMessageDelayed(obtainMessage, 300000L);
            return;
        }
        int i11 = a11.f42830a;
        if (i11 == 0) {
            String str = a11.f42831b;
            com.transsion.athena.taaneh.aethna.c("<-- globalConfig:%s", str);
            com.transsion.athena.aethna.athena.c().a(str);
            this.f42818c.b(System.currentTimeMillis() + this.f42818c.c());
            this.f42815a.postAtFrontOfQueue(new Runnable() { // from class: com.transsion.athena.hatnea.a
                @Override // java.lang.Runnable
                public final void run() {
                    atenha.this.d();
                }
            });
        } else if (i11 != 1) {
            com.transsion.athena.config.data.model.enatha enathaVar = this.f42818c;
            enathaVar.c(enathaVar.d() + 1);
        } else {
            com.transsion.athena.taaneh.aethna.c("<-- globalConfig:%s", "NOT_MODIFIED");
            this.f42818c.b(System.currentTimeMillis() + this.f42818c.c());
        }
        com.transsion.athena.aethna.athena.c().l();
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Retrieve-Global-Config";
    }
}
