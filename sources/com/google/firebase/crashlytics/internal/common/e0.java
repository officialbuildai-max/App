package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes4.dex */
class e0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final File f31223a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31224b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31225c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(String str, String str2, File file) {
        this.f31224b = str;
        this.f31225c = str2;
        this.f31223a = file;
    }

    private byte[] c() {
        byte[] bArr = new byte[8192];
        try {
            InputStream stream = getStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (stream == null) {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        if (stream != null) {
                            stream.close();
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int read = stream.read(bArr);
                            if (read <= 0) {
                                gZIPOutputStream.finish();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                gZIPOutputStream.close();
                                byteArrayOutputStream.close();
                                stream.close();
                                return byteArray;
                            }
                            gZIPOutputStream.write(bArr, 0, read);
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public CrashlyticsReport.d.b a() {
        byte[] c11 = c();
        if (c11 != null) {
            return CrashlyticsReport.d.b.a().b(c11).c(this.f31224b).a();
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public String b() {
        return this.f31225c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.j0
    public InputStream getStream() {
        if (this.f31223a.exists() && this.f31223a.isFile()) {
            try {
                return new FileInputStream(this.f31223a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
