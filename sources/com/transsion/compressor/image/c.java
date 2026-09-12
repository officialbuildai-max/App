package com.transsion.compressor.image;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public abstract class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f44045a;

    public abstract InputStream a();

    @Override // com.transsion.compressor.image.d
    public void close() {
        InputStream inputStream = this.f44045a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } catch (Throwable th2) {
                this.f44045a = null;
                throw th2;
            }
            this.f44045a = null;
        }
    }

    @Override // com.transsion.compressor.image.d
    public InputStream open() {
        close();
        InputStream a11 = a();
        this.f44045a = a11;
        return a11;
    }
}
