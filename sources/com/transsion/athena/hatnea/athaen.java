package com.transsion.athena.hatnea;

import com.transsion.ga.AthenaAnalytics;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class athaen extends anateh {

    /* renamed from: c, reason: collision with root package name */
    private final com.transsion.athena.config.data.model.athena f42820c;

    /* renamed from: d, reason: collision with root package name */
    private long f42821d;

    /* renamed from: e, reason: collision with root package name */
    private final int f42822e;

    /* renamed from: f, reason: collision with root package name */
    private final com.transsion.athena.aethna.aethna f42823f;

    public athaen(com.transsion.athena.config.data.model.athena athenaVar, long j11, com.transsion.athena.aethna.aethna aethnaVar) {
        int b11 = com.transsion.athena.config.data.model.anehat.b(AthenaAnalytics.J());
        this.f42822e = b11;
        if (athenaVar.k() > 0 && b11 != athenaVar.d()) {
            com.transsion.athena.taaneh.aethna.c("dimensionChanged, so set appConfig version to 0");
            athenaVar.c(0L);
        }
        this.f42820c = athenaVar;
        this.f42821d = j11;
        this.f42823f = aethnaVar;
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected void a() {
        String str;
        boolean z10 = false;
        try {
            JSONObject a11 = com.transsion.athena.config.data.model.anehat.a(AthenaAnalytics.J());
            a11.put("sname", String.valueOf(this.f42820c.b()));
            a11.put("sdkver", com.transsion.athena.config.data.model.ehanat.a(this.f42820c.b()));
            str = a11.toString();
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(e11.getMessage());
            str = "";
        }
        ehanat<String> a12 = anehat.a(com.transsion.athena.config.data.model.ehanat.a(this.f42820c.c()), str, this.f42820c.k(), this.f42820c.b());
        int i11 = a12.f42830a;
        if (i11 == 0) {
            String str2 = a12.f42831b;
            com.transsion.athena.taaneh.aethna.c("<-- appIdConfig:%s", str2);
            com.transsion.athena.aethna.athena.c().a(this.f42820c, str2);
            this.f42820c.b(this.f42822e);
            if (this.f42820c.e() > 0) {
                this.f42821d = this.f42820c.e() * 3600000;
            }
            this.f42820c.b(System.currentTimeMillis() + this.f42821d);
            z10 = true;
        } else if (i11 != 1) {
            com.transsion.athena.config.data.model.athena athenaVar = this.f42820c;
            athenaVar.e(athenaVar.g() + 1);
        } else {
            com.transsion.athena.taaneh.aethna.c("<-- appIdConfig:%s", "NOT_MODIFIED");
            this.f42820c.b(this.f42822e);
            this.f42820c.b(System.currentTimeMillis() + this.f42821d);
        }
        com.transsion.athena.aethna.aethna aethnaVar = this.f42823f;
        if (aethnaVar != null) {
            aethnaVar.a(this.f42820c.b(), z10);
        }
    }

    @Override // com.transsion.athena.hatnea.anateh
    protected String c() {
        return "Retrieve-" + this.f42820c.b() + "-Config";
    }
}
