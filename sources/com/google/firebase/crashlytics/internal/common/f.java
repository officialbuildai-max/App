package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes4.dex */
class f implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f31226a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31227b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31228c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str, String str2, byte[] bArr) {
        this.f31227b = str;
        this.f31228c = str2;
        this.f31226a = bArr;
    }

    private byte[] c() {
        if (d()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f31226a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean d() {
        byte[] bArr = this.f31226a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public CrashlyticsReport.d.b a() {
        byte[] c11 = c();
        if (c11 == null) {
            return null;
        }
        return CrashlyticsReport.d.b.a().b(c11).c(this.f31227b).a();
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public String b() {
        return this.f31228c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public InputStream getStream() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.f31226a);
    }
}
