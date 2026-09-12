package org.apache.tools.ant.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;

/* loaded from: classes7.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f71695a = x00.a.a("dos");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f71696b = x00.a.b("netware");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f71697c = x00.a.b("aix");

    /* renamed from: d, reason: collision with root package name */
    private static final String f71698d = System.getProperty("java.home");

    /* renamed from: e, reason: collision with root package name */
    private static final d f71699e = d.k();

    /* renamed from: f, reason: collision with root package name */
    private static String f71700f;

    /* renamed from: g, reason: collision with root package name */
    private static int f71701g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f71702h;

    /* renamed from: i, reason: collision with root package name */
    private static Vector f71703i;

    static {
        try {
            f71700f = "1.1";
            f71701g = 10 + 1;
            Class.forName("java.lang.ThreadLocal");
            f71700f = "1.2";
            f71701g++;
            Class.forName("java.lang.StrictMath");
            int i11 = f71701g;
            f71700f = "1.4";
            f71701g = i11 + 2;
            Class.forName("java.net.Proxy");
            f71700f = "1.5";
            f71701g++;
            Class.forName("java.util.ServiceLoader");
            f71700f = "1.6";
            f71701g++;
        } catch (Throwable unused) {
        }
        f71702h = false;
        try {
            Class.forName("kaffe.util.NotImplemented");
            f71702h = true;
        } catch (Throwable unused2) {
        }
    }

    private static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(f71695a ? ".exe" : "");
        return stringBuffer.toString();
    }

    private static void b() {
        Vector vector = new Vector();
        f71703i = vector;
        switch (f71701g) {
            case 15:
            case 16:
                vector.addElement("com.sun.org.apache");
            case 14:
                if (f71701g == 14) {
                    f71703i.addElement("org.apache.crimson");
                    f71703i.addElement("org.apache.xalan");
                    f71703i.addElement("org.apache.xml");
                    f71703i.addElement("org.apache.xpath");
                }
                f71703i.addElement("org.ietf.jgss");
                f71703i.addElement("org.w3c.dom");
                f71703i.addElement("org.xml.sax");
            case 13:
                f71703i.addElement("org.omg");
                f71703i.addElement("com.sun.corba");
                f71703i.addElement("com.sun.jndi");
                f71703i.addElement("com.sun.media");
                f71703i.addElement("com.sun.naming");
                f71703i.addElement("com.sun.org.omg");
                f71703i.addElement("com.sun.rmi");
                f71703i.addElement("sunw.io");
                f71703i.addElement("sunw.util");
            case 12:
                f71703i.addElement("com.sun.java");
                f71703i.addElement("com.sun.image");
                break;
        }
        f71703i.addElement("sun");
        f71703i.addElement("java");
        f71703i.addElement("javax");
    }

    public static File c(String[] strArr) {
        File f11 = f71699e.f("ANT", ".JAVA_OPTS", null, false, true);
        PrintWriter printWriter = null;
        try {
            PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter(f11)));
            for (String str : strArr) {
                try {
                    printWriter2.println(str);
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = printWriter2;
                    d.e(printWriter);
                    throw th;
                }
            }
            d.e(printWriter2);
            return f11;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static File d(String str, String str2) {
        File o11 = f71699e.o(str);
        if (!o11.exists()) {
            return null;
        }
        File file = new File(o11, a(str2));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static String e() {
        return f71700f;
    }

    public static int f() {
        return f71701g;
    }

    public static String g(String str) {
        File file;
        if (f71696b) {
            return str;
        }
        if (f71697c) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f71698d);
            stringBuffer.append("/sh");
            file = d(stringBuffer.toString(), str);
        } else {
            file = null;
        }
        if (file == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(f71698d);
            stringBuffer2.append("/bin");
            file = d(stringBuffer2.toString(), str);
        }
        return file != null ? file.getAbsolutePath() : a(str);
    }

    public static Vector h() {
        if (f71703i == null) {
            b();
        }
        return f71703i;
    }
}
