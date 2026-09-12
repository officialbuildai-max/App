package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.PipedInputStream;

/* loaded from: classes7.dex */
public class i extends PipedInputStream {

    /* renamed from: a, reason: collision with root package name */
    private org.apache.tools.ant.q f71710a;

    public void b(String str, int i11) {
        org.apache.tools.ant.q qVar = this.f71710a;
        if (qVar != null) {
            qVar.log(str, i11);
        } else if (i11 > 1) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public void d(org.apache.tools.ant.q qVar) {
        this.f71710a = qVar;
    }

    @Override // java.io.PipedInputStream, java.io.InputStream
    public synchronized int read() {
        int i11;
        try {
            i11 = super.read();
        } catch (IOException e11) {
            if ("write end dead".equalsIgnoreCase(e11.getMessage())) {
                int i12 = ((PipedInputStream) this).in;
                if (i12 > 0) {
                    int i13 = ((PipedInputStream) this).out;
                    byte[] bArr = ((PipedInputStream) this).buffer;
                    if (i13 < bArr.length && i13 > i12) {
                        ((PipedInputStream) this).out = i13 + 1;
                        i11 = bArr[i13] & 255;
                    }
                }
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("error at LeadPipeInputStream.read():  ");
                stringBuffer.append(e11.getMessage());
                b(stringBuffer.toString(), 2);
            }
            i11 = -1;
        }
        return i11;
    }
}
