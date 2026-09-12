package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;

/* loaded from: classes5.dex */
public enum u {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: a, reason: collision with root package name */
    private final String f38420a;

    u(String str) {
        this.f38420a = str;
    }

    public static u a(String str) throws IOException {
        u uVar = HTTP_1_0;
        if (str.equals(uVar.f38420a)) {
            return uVar;
        }
        u uVar2 = HTTP_1_1;
        if (str.equals(uVar2.f38420a)) {
            return uVar2;
        }
        u uVar3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(uVar3.f38420a)) {
            return uVar3;
        }
        u uVar4 = HTTP_2;
        if (str.equals(uVar4.f38420a)) {
            return uVar4;
        }
        u uVar5 = SPDY_3;
        if (str.equals(uVar5.f38420a)) {
            return uVar5;
        }
        u uVar6 = QUIC;
        if (str.equals(uVar6.f38420a)) {
            return uVar6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f38420a;
    }
}
