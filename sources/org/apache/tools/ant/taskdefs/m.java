package org.apache.tools.ant.taskdefs;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.q;
import org.apache.tools.ant.util.p;

/* loaded from: classes7.dex */
public class m {
    private static final String B = System.getProperty("file.encoding");
    private boolean A;

    /* renamed from: a, reason: collision with root package name */
    private File[] f71536a;

    /* renamed from: b, reason: collision with root package name */
    private File[] f71537b;

    /* renamed from: c, reason: collision with root package name */
    private File[] f71538c;

    /* renamed from: g, reason: collision with root package name */
    private String f71542g;

    /* renamed from: h, reason: collision with root package name */
    private String f71543h;

    /* renamed from: i, reason: collision with root package name */
    private String f71544i;

    /* renamed from: m, reason: collision with root package name */
    private q f71548m;

    /* renamed from: s, reason: collision with root package name */
    private Vector f71554s;

    /* renamed from: t, reason: collision with root package name */
    private Vector f71555t;

    /* renamed from: u, reason: collision with root package name */
    private Vector f71556u;

    /* renamed from: v, reason: collision with root package name */
    private String f71557v;

    /* renamed from: w, reason: collision with root package name */
    private String f71558w;

    /* renamed from: x, reason: collision with root package name */
    private String f71559x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f71560y;

    /* renamed from: z, reason: collision with root package name */
    private ThreadGroup f71561z;

    /* renamed from: d, reason: collision with root package name */
    private boolean f71539d = false;

    /* renamed from: e, reason: collision with root package name */
    private a f71540e = null;

    /* renamed from: f, reason: collision with root package name */
    private a f71541f = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f71545j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f71546k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f71547l = true;

    /* renamed from: n, reason: collision with root package name */
    private OutputStream f71549n = null;

    /* renamed from: o, reason: collision with root package name */
    private OutputStream f71550o = null;

    /* renamed from: p, reason: collision with root package name */
    private InputStream f71551p = null;

    /* renamed from: q, reason: collision with root package name */
    private PrintStream f71552q = null;

    /* renamed from: r, reason: collision with root package name */
    private PrintStream f71553r = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends ByteArrayOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private String f71562a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f71563b = false;

        a(String str) {
            this.f71562a = str;
        }

        @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f71563b) {
                return;
            }
            if (m.this.f71545j && m.this.f71560y) {
                return;
            }
            m.this.k(this, this.f71562a);
            this.f71563b = true;
        }
    }

    public m(q qVar) {
        String str = B;
        this.f71557v = str;
        this.f71558w = str;
        this.f71559x = str;
        this.f71560y = true;
        this.f71561z = new ThreadGroup("redirector");
        this.A = true;
        this.f71548m = qVar;
    }

    private void g() {
        OutputStream outputStream;
        File[] fileArr = this.f71538c;
        if (fileArr != null && fileArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer("Error ");
            stringBuffer.append(this.f71545j ? "appended" : "redirected");
            stringBuffer.append(" to ");
            this.f71550o = h(this.f71538c, stringBuffer.toString(), 3);
        } else if (!this.f71539d && (outputStream = this.f71549n) != null) {
            org.apache.tools.ant.util.m mVar = new org.apache.tools.ant.util.m(outputStream, 0L);
            try {
                this.f71549n = mVar.g();
                this.f71550o = mVar.g();
            } catch (IOException e11) {
                throw new BuildException("error splitting output/error streams", e11);
            }
        }
        if (this.f71543h == null) {
            this.f71541f = null;
            return;
        }
        if (this.f71541f == null) {
            this.f71541f = new a(this.f71543h);
            q qVar = this.f71548m;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Error redirected to property: ");
            stringBuffer2.append(this.f71543h);
            qVar.log(stringBuffer2.toString(), 3);
        }
        OutputStream gVar = new org.apache.tools.ant.util.g(this.f71541f);
        File[] fileArr2 = this.f71538c;
        if (fileArr2 != null && fileArr2.length != 0) {
            gVar = new org.apache.tools.ant.util.q(this.f71550o, gVar);
        }
        this.f71550o = gVar;
    }

    private OutputStream h(File[] fileArr, String str, int i11) {
        org.apache.tools.ant.util.h hVar = new org.apache.tools.ant.util.h(fileArr[0], this.f71545j, this.f71547l);
        q qVar = this.f71548m;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(fileArr[0]);
        qVar.log(stringBuffer.toString(), i11);
        char[] cArr = new char[str.length()];
        Arrays.fill(cArr, ' ');
        String str2 = new String(cArr);
        for (int i12 = 1; i12 < fileArr.length; i12++) {
            this.f71549n = new org.apache.tools.ant.util.q(this.f71549n, new org.apache.tools.ant.util.h(fileArr[i12], this.f71545j, this.f71547l));
            q qVar2 = this.f71548m;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str2);
            stringBuffer2.append(fileArr[i12]);
            qVar2.log(stringBuffer2.toString(), i11);
        }
        return hVar;
    }

    private void i() {
        File[] fileArr = this.f71537b;
        if (fileArr != null && fileArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer("Output ");
            stringBuffer.append(this.f71545j ? "appended" : "redirected");
            stringBuffer.append(" to ");
            this.f71549n = h(this.f71537b, stringBuffer.toString(), 3);
        }
        if (this.f71542g == null) {
            this.f71540e = null;
            return;
        }
        if (this.f71540e == null) {
            this.f71540e = new a(this.f71542g);
            q qVar = this.f71548m;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Output redirected to property: ");
            stringBuffer2.append(this.f71542g);
            qVar.log(stringBuffer2.toString(), 3);
        }
        OutputStream gVar = new org.apache.tools.ant.util.g(this.f71540e);
        if (this.f71549n != null) {
            gVar = new org.apache.tools.ant.util.q(this.f71549n, gVar);
        }
        this.f71549n = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ByteArrayOutputStream byteArrayOutputStream, String str) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(g.u(byteArrayOutputStream)));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                this.f71548m.getProject().J(str, stringBuffer.toString());
                return;
            } else {
                if (stringBuffer.length() != 0) {
                    stringBuffer.append(p.f71726a);
                }
                stringBuffer.append(readLine);
            }
        }
    }

    public synchronized void d() {
        try {
            System.out.flush();
            System.err.flush();
            InputStream inputStream = this.f71551p;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f71549n.flush();
            this.f71549n.close();
            this.f71550o.flush();
            this.f71550o.close();
            while (this.f71561z.activeCount() > 0) {
                try {
                    q qVar = this.f71548m;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("waiting for ");
                    stringBuffer.append(this.f71561z.activeCount());
                    stringBuffer.append(" Threads:");
                    qVar.log(stringBuffer.toString(), 4);
                    int activeCount = this.f71561z.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    this.f71561z.enumerate(threadArr);
                    for (int i11 = 0; i11 < activeCount; i11++) {
                        Thread thread = threadArr[i11];
                        if (thread == null) {
                            break;
                        }
                        try {
                            this.f71548m.log(thread.toString(), 4);
                        } catch (NullPointerException unused) {
                        }
                    }
                    wait(1000L);
                } catch (InterruptedException unused2) {
                }
            }
            j();
            this.f71551p = null;
            this.f71549n = null;
            this.f71550o = null;
            this.f71552q = null;
            this.f71553r = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized h e() {
        f();
        return new l(this.f71549n, this.f71550o, this.f71551p);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[Catch: all -> 0x0010, IOException -> 0x0095, TryCatch #1 {IOException -> 0x0095, blocks: (B:17:0x005f, B:19:0x0074, B:21:0x007a, B:22:0x0097), top: B:16:0x005f, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002a, B:10:0x002f, B:12:0x0049, B:14:0x004f, B:17:0x005f, B:19:0x0074, B:21:0x007a, B:22:0x0097, B:23:0x00c4, B:25:0x00c8, B:28:0x00d8, B:30:0x00ed, B:32:0x00f3, B:33:0x0110, B:34:0x013d, B:36:0x0142, B:38:0x0145, B:41:0x015b, B:43:0x0165, B:44:0x016e, B:45:0x01b3, B:47:0x01b7, B:49:0x01bb, B:51:0x01c1, B:53:0x01cf, B:54:0x01db, B:57:0x01ef, B:58:0x01f6, B:64:0x0175, B:65:0x017a, B:67:0x017b, B:69:0x017f, B:71:0x018a, B:72:0x019d, B:73:0x0198, B:77:0x0135, B:78:0x013c, B:79:0x00ce, B:84:0x00bc, B:85:0x00c3, B:86:0x0055, B:88:0x0033, B:91:0x0047, B:92:0x003f, B:93:0x0013, B:96:0x0028, B:97:0x0020), top: B:2:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ed A[Catch: all -> 0x0010, IOException -> 0x010e, TryCatch #4 {IOException -> 0x010e, blocks: (B:28:0x00d8, B:30:0x00ed, B:32:0x00f3, B:33:0x0110), top: B:27:0x00d8, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0142 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002a, B:10:0x002f, B:12:0x0049, B:14:0x004f, B:17:0x005f, B:19:0x0074, B:21:0x007a, B:22:0x0097, B:23:0x00c4, B:25:0x00c8, B:28:0x00d8, B:30:0x00ed, B:32:0x00f3, B:33:0x0110, B:34:0x013d, B:36:0x0142, B:38:0x0145, B:41:0x015b, B:43:0x0165, B:44:0x016e, B:45:0x01b3, B:47:0x01b7, B:49:0x01bb, B:51:0x01c1, B:53:0x01cf, B:54:0x01db, B:57:0x01ef, B:58:0x01f6, B:64:0x0175, B:65:0x017a, B:67:0x017b, B:69:0x017f, B:71:0x018a, B:72:0x019d, B:73:0x0198, B:77:0x0135, B:78:0x013c, B:79:0x00ce, B:84:0x00bc, B:85:0x00c3, B:86:0x0055, B:88:0x0033, B:91:0x0047, B:92:0x003f, B:93:0x0013, B:96:0x0028, B:97:0x0020), top: B:2:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b7 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002a, B:10:0x002f, B:12:0x0049, B:14:0x004f, B:17:0x005f, B:19:0x0074, B:21:0x007a, B:22:0x0097, B:23:0x00c4, B:25:0x00c8, B:28:0x00d8, B:30:0x00ed, B:32:0x00f3, B:33:0x0110, B:34:0x013d, B:36:0x0142, B:38:0x0145, B:41:0x015b, B:43:0x0165, B:44:0x016e, B:45:0x01b3, B:47:0x01b7, B:49:0x01bb, B:51:0x01c1, B:53:0x01cf, B:54:0x01db, B:57:0x01ef, B:58:0x01f6, B:64:0x0175, B:65:0x017a, B:67:0x017b, B:69:0x017f, B:71:0x018a, B:72:0x019d, B:73:0x0198, B:77:0x0135, B:78:0x013c, B:79:0x00ce, B:84:0x00bc, B:85:0x00c3, B:86:0x0055, B:88:0x0033, B:91:0x0047, B:92:0x003f, B:93:0x0013, B:96:0x0028, B:97:0x0020), top: B:2:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017f A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002a, B:10:0x002f, B:12:0x0049, B:14:0x004f, B:17:0x005f, B:19:0x0074, B:21:0x007a, B:22:0x0097, B:23:0x00c4, B:25:0x00c8, B:28:0x00d8, B:30:0x00ed, B:32:0x00f3, B:33:0x0110, B:34:0x013d, B:36:0x0142, B:38:0x0145, B:41:0x015b, B:43:0x0165, B:44:0x016e, B:45:0x01b3, B:47:0x01b7, B:49:0x01bb, B:51:0x01c1, B:53:0x01cf, B:54:0x01db, B:57:0x01ef, B:58:0x01f6, B:64:0x0175, B:65:0x017a, B:67:0x017b, B:69:0x017f, B:71:0x018a, B:72:0x019d, B:73:0x0198, B:77:0x0135, B:78:0x013c, B:79:0x00ce, B:84:0x00bc, B:85:0x00c3, B:86:0x0055, B:88:0x0033, B:91:0x0047, B:92:0x003f, B:93:0x0013, B:96:0x0028, B:97:0x0020), top: B:2:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x003f A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x002a, B:10:0x002f, B:12:0x0049, B:14:0x004f, B:17:0x005f, B:19:0x0074, B:21:0x007a, B:22:0x0097, B:23:0x00c4, B:25:0x00c8, B:28:0x00d8, B:30:0x00ed, B:32:0x00f3, B:33:0x0110, B:34:0x013d, B:36:0x0142, B:38:0x0145, B:41:0x015b, B:43:0x0165, B:44:0x016e, B:45:0x01b3, B:47:0x01b7, B:49:0x01bb, B:51:0x01c1, B:53:0x01cf, B:54:0x01db, B:57:0x01ef, B:58:0x01f6, B:64:0x0175, B:65:0x017a, B:67:0x017b, B:69:0x017f, B:71:0x018a, B:72:0x019d, B:73:0x0198, B:77:0x0135, B:78:0x013c, B:79:0x00ce, B:84:0x00bc, B:85:0x00c3, B:86:0x0055, B:88:0x0033, B:91:0x0047, B:92:0x003f, B:93:0x0013, B:96:0x0028, B:97:0x0020), top: B:2:0x0001, inners: #1, #2, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void f() {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.taskdefs.m.f():void");
    }

    public synchronized void j() {
        a aVar = this.f71540e;
        if (aVar != null) {
            try {
                aVar.close();
            } catch (IOException unused) {
            }
        }
        a aVar2 = this.f71541f;
        if (aVar2 != null) {
            try {
                aVar2.close();
            } catch (IOException unused2) {
            }
        }
    }
}
