package com.mbridge.msdk.dycreator.error;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f34927a;

    /* renamed from: b, reason: collision with root package name */
    private String f34928b;

    public a(int i11, String str) {
        this.f34927a = i11;
        this.f34928b = str;
    }

    public a(b bVar) {
        if (bVar != null) {
            this.f34927a = bVar.b();
            this.f34928b = bVar.c();
        }
    }

    public String toString() {
        return "DyError{errorCode=" + this.f34927a + '}';
    }
}
