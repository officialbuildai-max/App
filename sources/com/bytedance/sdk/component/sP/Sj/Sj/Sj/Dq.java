package com.bytedance.sdk.component.sP.Sj.Sj.Sj;

import com.bytedance.sdk.component.sP.Sj.uvD;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes2.dex */
public class Dq extends uvD {
    HttpURLConnection Sj;
    InputStream sP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dq(HttpURLConnection httpURLConnection) throws IOException {
        this.Sj = httpURLConnection;
        this.sP = new vS(httpURLConnection.getInputStream(), httpURLConnection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dq(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.Sj = httpURLConnection;
        this.sP = new vS(inputStream, httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.sP.Sj.uvD
    public byte[] EjP() {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = this.sP.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.sP.Sj.uvD
    public com.bytedance.sdk.component.sP.Sj.uA HiB() {
        if (this.Sj.getContentType() != null) {
            return com.bytedance.sdk.component.sP.Sj.uA.Sj(this.Sj.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.sP.Sj.uvD
    public long Sj() {
        try {
            return this.Sj.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.sP.Sj.uvD
    public InputStream TKC() {
        return this.sP;
    }

    @Override // com.bytedance.sdk.component.sP.Sj.uvD, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.sP.close();
            this.Sj.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.sP.Sj.uvD
    public String sP() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.sP));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String stringBuffer2 = stringBuffer.toString();
                    close();
                    return stringBuffer2;
                }
                stringBuffer.append(readLine + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }
}
