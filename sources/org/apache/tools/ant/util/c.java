package org.apache.tools.ant.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class c extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f71676a = -1;

    /* renamed from: b, reason: collision with root package name */
    private boolean f71677b = false;

    /* renamed from: c, reason: collision with root package name */
    private File[] f71678c;

    /* renamed from: d, reason: collision with root package name */
    private InputStream f71679d;

    /* renamed from: e, reason: collision with root package name */
    private org.apache.tools.ant.q f71680e;

    public c(File[] fileArr) {
        this.f71678c = fileArr;
    }

    private void d() {
        d.b(this.f71679d);
        this.f71679d = null;
    }

    private void i(int i11) {
        d();
        File[] fileArr = this.f71678c;
        if (fileArr == null || i11 >= fileArr.length) {
            this.f71677b = true;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Opening ");
        stringBuffer.append(this.f71678c[i11]);
        h(stringBuffer.toString(), 3);
        try {
            this.f71679d = new BufferedInputStream(new FileInputStream(this.f71678c[i11]));
        } catch (IOException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Failed to open ");
            stringBuffer2.append(this.f71678c[i11]);
            h(stringBuffer2.toString(), 0);
            throw e11;
        }
    }

    private int k() {
        InputStream inputStream;
        if (this.f71677b || (inputStream = this.f71679d) == null) {
            return -1;
        }
        return inputStream.read();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d();
        this.f71677b = true;
    }

    public void h(String str, int i11) {
        org.apache.tools.ant.q qVar = this.f71680e;
        if (qVar != null) {
            qVar.log(str, i11);
        } else if (i11 > 1) {
            System.out.println(str);
        } else {
            System.err.println(str);
        }
    }

    public void l(org.apache.tools.ant.q qVar) {
        this.f71680e = qVar;
    }

    @Override // java.io.InputStream
    public int read() {
        int k11 = k();
        if (k11 != -1 || this.f71677b) {
            return k11;
        }
        int i11 = this.f71676a + 1;
        this.f71676a = i11;
        i(i11);
        return k();
    }
}
