package org.apache.tools.ant.taskdefs;

import com.cloud.tmc.kernel.utils.UrlUtils;
import com.transsion.push.PushConstants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.p;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: m, reason: collision with root package name */
    private static a f71490m;

    /* renamed from: n, reason: collision with root package name */
    private static a f71491n;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f71494q;

    /* renamed from: r, reason: collision with root package name */
    static /* synthetic */ Class f71495r;

    /* renamed from: s, reason: collision with root package name */
    static /* synthetic */ Class f71496s;

    /* renamed from: t, reason: collision with root package name */
    static /* synthetic */ Class f71497t;

    /* renamed from: a, reason: collision with root package name */
    private String[] f71498a;

    /* renamed from: b, reason: collision with root package name */
    private String[] f71499b;

    /* renamed from: c, reason: collision with root package name */
    private int f71500c;

    /* renamed from: d, reason: collision with root package name */
    private org.apache.tools.ant.taskdefs.h f71501d;

    /* renamed from: e, reason: collision with root package name */
    private org.apache.tools.ant.taskdefs.i f71502e;

    /* renamed from: f, reason: collision with root package name */
    private File f71503f;

    /* renamed from: g, reason: collision with root package name */
    private Project f71504g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f71505h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f71506i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f71507j;

    /* renamed from: k, reason: collision with root package name */
    private static final org.apache.tools.ant.util.d f71488k = org.apache.tools.ant.util.d.k();

    /* renamed from: l, reason: collision with root package name */
    private static String f71489l = System.getProperty("user.dir");

    /* renamed from: o, reason: collision with root package name */
    private static Vector f71492o = null;

    /* renamed from: p, reason: collision with root package name */
    private static ProcessDestroyer f71493p = new ProcessDestroyer();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private a() {
        }

        /* synthetic */ a(org.apache.tools.ant.taskdefs.f fVar) {
            this();
        }

        public Process a(Project project, String[] strArr, String[] strArr2) {
            if (project != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Execute:CommandLauncher: ");
                stringBuffer.append(org.apache.tools.ant.types.c.f(strArr));
                project.x(stringBuffer.toString(), 4);
            }
            return Runtime.getRuntime().exec(strArr, strArr2);
        }

        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (file == null) {
                return a(project, strArr, strArr2);
            }
            throw new IOException("Cannot execute a process in different directory under this JVM");
        }
    }

    /* loaded from: classes7.dex */
    private static class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private a f71508a;

        b(a aVar) {
            super(null);
            this.f71508a = aVar;
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process a(Project project, String[] strArr, String[] strArr2) {
            return this.f71508a.a(project, strArr, strArr2);
        }
    }

    /* loaded from: classes7.dex */
    private static class c extends a {

        /* renamed from: a, reason: collision with root package name */
        private Method f71509a;

        public c() throws NoSuchMethodException {
            super(null);
            Class cls = g.f71497t;
            if (cls == null) {
                cls = g.d("java.lang.Runtime");
                g.f71497t = cls;
            }
            Class<?> cls2 = g.f71495r;
            if (cls2 == null) {
                cls2 = g.d("[Ljava.lang.String;");
                g.f71495r = cls2;
            }
            Class<?> cls3 = g.f71495r;
            if (cls3 == null) {
                cls3 = g.d("[Ljava.lang.String;");
                g.f71495r = cls3;
            }
            Class<?> cls4 = g.f71496s;
            if (cls4 == null) {
                cls4 = g.d("java.io.File");
                g.f71496s = cls4;
            }
            this.f71509a = cls.getMethod("exec", cls2, cls3, cls4);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (project != null) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Execute:Java13CommandLauncher: ");
                    stringBuffer.append(org.apache.tools.ant.types.c.f(strArr));
                    project.x(stringBuffer.toString(), 4);
                } catch (InvocationTargetException e11) {
                    Throwable targetException = e11.getTargetException();
                    if (targetException instanceof ThreadDeath) {
                        throw ((ThreadDeath) targetException);
                    }
                    if (targetException instanceof IOException) {
                        throw ((IOException) targetException);
                    }
                    throw new BuildException("Unable to execute command", targetException);
                } catch (Exception e12) {
                    throw new BuildException("Unable to execute command", e12);
                }
            }
            return (Process) this.f71509a.invoke(Runtime.getRuntime(), strArr, strArr2, file);
        }
    }

    /* loaded from: classes7.dex */
    private static class d extends b {
        d(a aVar) {
            super(aVar);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (file == null) {
                return a(project, strArr, strArr2);
            }
            System.getProperties().put("user.dir", file.getAbsolutePath());
            try {
                return a(project, strArr, strArr2);
            } finally {
                System.getProperties().put("user.dir", g.f71489l);
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class e extends b {
        e(a aVar) {
            super(aVar);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (file == null) {
                if (project == null) {
                    return a(project, strArr, strArr2);
                }
                file = project.m();
            }
            String absolutePath = file.getAbsolutePath();
            String[] strArr3 = new String[strArr.length + 7];
            strArr3[0] = "cmd";
            strArr3[1] = "/c";
            strArr3[2] = absolutePath.substring(0, 2);
            strArr3[3] = "&&";
            strArr3[4] = "cd";
            strArr3[5] = absolutePath.substring(2);
            strArr3[6] = "&&";
            System.arraycopy(strArr, 0, strArr3, 7, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    /* loaded from: classes7.dex */
    private static class f extends b {

        /* renamed from: b, reason: collision with root package name */
        private String f71510b;

        f(String str, a aVar) {
            super(aVar);
            this.f71510b = str;
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (project == null) {
                if (file == null) {
                    return a(project, strArr, strArr2);
                }
                throw new IOException("Cannot locate antRun script: No project provided");
            }
            String s11 = project.s("ant.home");
            if (s11 == null) {
                throw new IOException("Cannot locate antRun script: Property 'ant.home' not found");
            }
            org.apache.tools.ant.util.d dVar = g.f71488k;
            File m11 = project.m();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(s11);
            stringBuffer.append(File.separator);
            stringBuffer.append(this.f71510b);
            String file2 = dVar.q(m11, stringBuffer.toString()).toString();
            if (file == null) {
                file = project.m();
            }
            String[] strArr3 = new String[strArr.length + 3];
            strArr3[0] = "perl";
            strArr3[1] = file2;
            strArr3[2] = file.getAbsolutePath();
            System.arraycopy(strArr, 0, strArr3, 3, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    /* renamed from: org.apache.tools.ant.taskdefs.g$g, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0892g extends b {

        /* renamed from: b, reason: collision with root package name */
        private String f71511b;

        C0892g(String str, a aVar) {
            super(aVar);
            this.f71511b = str;
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (project == null) {
                if (file == null) {
                    return a(project, strArr, strArr2);
                }
                throw new IOException("Cannot locate antRun script: No project provided");
            }
            String s11 = project.s("ant.home");
            if (s11 == null) {
                throw new IOException("Cannot locate antRun script: Property 'ant.home' not found");
            }
            org.apache.tools.ant.util.d dVar = g.f71488k;
            File m11 = project.m();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(s11);
            stringBuffer.append(File.separator);
            stringBuffer.append(this.f71511b);
            String file2 = dVar.q(m11, stringBuffer.toString()).toString();
            if (file == null) {
                file = project.m();
            }
            String[] strArr3 = new String[strArr.length + 2];
            strArr3[0] = file2;
            strArr3[1] = file.getAbsolutePath();
            System.arraycopy(strArr, 0, strArr3, 2, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    /* loaded from: classes7.dex */
    private static class h extends c {
        private File c(String[] strArr, String[] strArr2) {
            File f11 = g.f71488k.f("ANT", ".COM", null, true, true);
            PrintWriter printWriter = null;
            try {
                PrintWriter printWriter2 = new PrintWriter(new FileWriter(f11));
                if (strArr2 != null) {
                    for (int i11 = 0; i11 < strArr2.length; i11++) {
                        try {
                            int indexOf = strArr2[i11].indexOf(61);
                            if (indexOf != -1) {
                                printWriter2.print("$ DEFINE/NOLOG ");
                                printWriter2.print(strArr2[i11].substring(0, indexOf));
                                printWriter2.print(" \"");
                                printWriter2.print(strArr2[i11].substring(indexOf + 1));
                                printWriter2.println('\"');
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            printWriter = printWriter2;
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            throw th;
                        }
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("$ ");
                stringBuffer.append(strArr[0]);
                printWriter2.print(stringBuffer.toString());
                for (int i12 = 1; i12 < strArr.length; i12++) {
                    printWriter2.println(" -");
                    printWriter2.print(strArr[i12]);
                }
                printWriter2.close();
                return f11;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private void d(final File file, final Process process) {
            new Thread() { // from class: org.apache.tools.ant.taskdefs.Execute$VmsCommandLauncher$1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        process.waitFor();
                    } catch (InterruptedException unused) {
                    }
                    org.apache.tools.ant.util.d.g(file);
                }
            }.start();
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process a(Project project, String[] strArr, String[] strArr2) {
            File c11 = c(strArr, strArr2);
            Process a11 = super.a(project, new String[]{c11.getPath()}, strArr2);
            d(c11, a11);
            return a11;
        }

        @Override // org.apache.tools.ant.taskdefs.g.c, org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            File c11 = c(strArr, strArr2);
            Process b11 = super.b(project, new String[]{c11.getPath()}, strArr2, file);
            d(c11, b11);
            return b11;
        }
    }

    /* loaded from: classes7.dex */
    private static class i extends b {
        i(a aVar) {
            super(aVar);
        }

        @Override // org.apache.tools.ant.taskdefs.g.a
        public Process b(Project project, String[] strArr, String[] strArr2, File file) {
            if (file == null) {
                if (project == null) {
                    return a(project, strArr, strArr2);
                }
                file = project.m();
            }
            String[] strArr3 = new String[strArr.length + 6];
            strArr3[0] = "cmd";
            strArr3[1] = "/c";
            strArr3[2] = "cd";
            strArr3[3] = "/d";
            strArr3[4] = file.getAbsolutePath();
            strArr3[5] = "&&";
            System.arraycopy(strArr, 0, strArr3, 6, strArr.length);
            return a(project, strArr3, strArr2);
        }
    }

    static {
        org.apache.tools.ant.taskdefs.f fVar = null;
        f71490m = null;
        f71491n = null;
        f71494q = false;
        try {
            if (!x00.a.a("os/2")) {
                f71490m = new c();
            }
        } catch (NoSuchMethodException unused) {
        }
        if (x00.a.a("mac") && !x00.a.a("unix")) {
            f71491n = new d(new a(fVar));
            return;
        }
        if (x00.a.a("os/2")) {
            f71491n = new e(new a(fVar));
            return;
        }
        if (x00.a.a("windows")) {
            f71494q = true;
            a aVar = new a(fVar);
            if (x00.a.a("win9x")) {
                f71491n = new C0892g("bin/antRun.bat", aVar);
                return;
            } else {
                f71491n = new i(aVar);
                return;
            }
        }
        if (x00.a.a("netware")) {
            f71491n = new f("bin/antRun.pl", new a(fVar));
        } else if (!x00.a.a("openvms")) {
            f71491n = new C0892g("bin/antRun", new a(fVar));
        } else {
            try {
                f71491n = new h();
            } catch (NoSuchMethodException unused2) {
            }
        }
    }

    public g() {
        this(new l(), null);
    }

    public g(org.apache.tools.ant.taskdefs.h hVar) {
        this(hVar, null);
    }

    public g(org.apache.tools.ant.taskdefs.h hVar, org.apache.tools.ant.taskdefs.i iVar) {
        this.f71498a = null;
        this.f71499b = null;
        this.f71500c = Integer.MAX_VALUE;
        this.f71503f = null;
        this.f71504g = null;
        this.f71505h = false;
        this.f71506i = false;
        this.f71507j = true;
        s(hVar);
        this.f71502e = iVar;
        if (x00.a.a("openvms")) {
            this.f71507j = false;
        }
    }

    private static Vector c(Vector vector, BufferedReader bufferedReader) {
        HashMap hashMap = new HashMap();
        String str = null;
        String str2 = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.startsWith("\t=")) {
                if (str != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                    stringBuffer.append(readLine.substring(4, readLine.length() - 1));
                    str2 = stringBuffer.toString();
                }
            } else if (readLine.startsWith("  \"")) {
                if (str != null) {
                    hashMap.put(str, str2);
                }
                int indexOf = readLine.indexOf(61);
                String substring = readLine.substring(3, indexOf - 2);
                if (hashMap.containsKey(substring)) {
                    str = null;
                } else {
                    str2 = readLine.substring(indexOf + 3, readLine.length() - 1);
                    str = substring;
                }
            }
        }
        if (str != null) {
            hashMap.put(str, str2);
        }
        for (String str3 : hashMap.keySet()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str3);
            stringBuffer2.append(UrlUtils.EQUAL_MARK);
            stringBuffer2.append(hashMap.get(str3));
            vector.add(stringBuffer2.toString());
        }
        return vector;
    }

    static /* synthetic */ Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static void e(Process process) {
        org.apache.tools.ant.util.d.b(process.getInputStream());
        org.apache.tools.ant.util.d.c(process.getOutputStream());
        org.apache.tools.ant.util.d.b(process.getErrorStream());
    }

    private static String[] j() {
        if (x00.a.a("os/2")) {
            return new String[]{"cmd", "/c", "set"};
        }
        if (x00.a.a("windows")) {
            return x00.a.a("win9x") ? new String[]{"command.com", "/c", "set"} : new String[]{"cmd", "/c", "set"};
        }
        if (!x00.a.a("z/os") && !x00.a.a("unix")) {
            if (x00.a.a("netware") || x00.a.a("os/400")) {
                return new String[]{"env"};
            }
            if (x00.a.a("openvms")) {
                return new String[]{PushConstants.PUSH_SERVICE_TYPE_SHOW, "logical"};
            }
            return null;
        }
        String[] strArr = new String[1];
        if (new File("/bin/env").canRead()) {
            strArr[0] = "/bin/env";
        } else if (new File("/usr/bin/env").canRead()) {
            strArr[0] = "/usr/bin/env";
        } else {
            strArr[0] = "env";
        }
        return strArr;
    }

    public static synchronized Vector k() {
        BufferedReader bufferedReader;
        synchronized (g.class) {
            Vector vector = f71492o;
            if (vector != null) {
                return vector;
            }
            f71492o = new Vector();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                g gVar = new g(new l(byteArrayOutputStream));
                gVar.p(j());
                gVar.r(true);
                gVar.f();
                bufferedReader = new BufferedReader(new StringReader(u(byteArrayOutputStream)));
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            if (x00.a.a("openvms")) {
                Vector c11 = c(f71492o, bufferedReader);
                f71492o = c11;
                return c11;
            }
            String str = p.f71726a;
            String str2 = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.indexOf(61) != -1) {
                    if (str2 != null) {
                        f71492o.addElement(str2);
                    }
                    str2 = readLine;
                } else if (str2 == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str);
                    stringBuffer.append(readLine);
                    str2 = stringBuffer.toString();
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str2);
                    stringBuffer2.append(str);
                    stringBuffer2.append(readLine);
                    str2 = stringBuffer2.toString();
                }
            }
            if (str2 != null) {
                f71492o.addElement(str2);
            }
            return f71492o;
        }
    }

    public static Process m(Project project, String[] strArr, String[] strArr2, File file, boolean z10) {
        a aVar;
        if (file == null || file.exists()) {
            if (!z10 || (aVar = f71490m) == null) {
                aVar = f71491n;
            }
            return aVar.b(project, strArr, strArr2, file);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(file);
        stringBuffer.append(" doesn't exist.");
        throw new BuildException(stringBuffer.toString());
    }

    private String[] n() {
        if (x00.a.a("openvms")) {
            return this.f71499b;
        }
        Vector vector = (Vector) k().clone();
        int i11 = 0;
        while (true) {
            String[] strArr = this.f71499b;
            if (i11 >= strArr.length) {
                return (String[]) vector.toArray(new String[vector.size()]);
            }
            String str = strArr[i11];
            String substring = str.substring(0, str.indexOf(61) + 1);
            if (f71494q) {
                substring = substring.toLowerCase();
            }
            int size = vector.size();
            int i12 = 0;
            while (true) {
                if (i12 < size) {
                    String str2 = (String) vector.elementAt(i12);
                    if ((f71494q ? str2.toLowerCase() : str2).startsWith(substring)) {
                        vector.removeElementAt(i12);
                        if (f71494q) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str2.substring(0, substring.length()));
                            stringBuffer.append(str.substring(substring.length()));
                            str = stringBuffer.toString();
                        }
                    } else {
                        i12++;
                    }
                }
            }
            vector.addElement(str);
            i11++;
        }
    }

    public static String u(ByteArrayOutputStream byteArrayOutputStream) {
        if (x00.a.a("z/os")) {
            return byteArrayOutputStream.toString("Cp1047");
        }
        if (x00.a.a("os/400")) {
            return byteArrayOutputStream.toString("Cp500");
        }
        return byteArrayOutputStream.toString();
    }

    public int f() {
        File file = this.f71503f;
        if (file != null && !file.exists()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f71503f);
            stringBuffer.append(" doesn't exist.");
            throw new BuildException(stringBuffer.toString());
        }
        Process m11 = m(this.f71504g, g(), h(), this.f71503f, this.f71507j);
        try {
            this.f71501d.b(m11.getOutputStream());
            this.f71501d.c(m11.getInputStream());
            this.f71501d.a(m11.getErrorStream());
            this.f71501d.start();
            try {
                try {
                    f71493p.add(m11);
                    org.apache.tools.ant.taskdefs.i iVar = this.f71502e;
                    if (iVar != null) {
                        iVar.d(m11);
                    }
                    v(m11);
                    org.apache.tools.ant.taskdefs.i iVar2 = this.f71502e;
                    if (iVar2 != null) {
                        iVar2.e();
                    }
                    this.f71501d.stop();
                    e(m11);
                    org.apache.tools.ant.taskdefs.i iVar3 = this.f71502e;
                    if (iVar3 != null) {
                        iVar3.a();
                    }
                    int i11 = i();
                    f71493p.remove(m11);
                    return i11;
                } catch (Throwable th2) {
                    f71493p.remove(m11);
                    throw th2;
                }
            } catch (ThreadDeath e11) {
                m11.destroy();
                throw e11;
            }
        } catch (IOException e12) {
            m11.destroy();
            throw e12;
        }
    }

    public String[] g() {
        return this.f71498a;
    }

    public String[] h() {
        String[] strArr = this.f71499b;
        return (strArr == null || this.f71505h) ? strArr : n();
    }

    public int i() {
        return this.f71500c;
    }

    public boolean l() {
        org.apache.tools.ant.taskdefs.i iVar = this.f71502e;
        return iVar != null && iVar.c();
    }

    public void o(Project project) {
        this.f71504g = project;
    }

    public void p(String[] strArr) {
        this.f71498a = strArr;
    }

    protected void q(int i11) {
        this.f71500c = i11;
    }

    public void r(boolean z10) {
        this.f71505h = z10;
    }

    public void s(org.apache.tools.ant.taskdefs.h hVar) {
        this.f71501d = hVar;
    }

    public void t(boolean z10) {
        this.f71507j = z10;
    }

    protected void v(Process process) {
        try {
            process.waitFor();
            q(process.exitValue());
        } catch (InterruptedException unused) {
            process.destroy();
        }
    }
}
