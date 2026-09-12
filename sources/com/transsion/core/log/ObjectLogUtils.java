package com.transsion.core.log;

import android.os.Environment;
import android.util.Log;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.core.utils.b;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ObjectLogUtils {

    /* renamed from: o, reason: collision with root package name */
    private static final char[] f44089o = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* renamed from: p, reason: collision with root package name */
    private static final String f44090p = System.getProperty("file.separator");

    /* renamed from: q, reason: collision with root package name */
    private static final String f44091q = System.getProperty("line.separator");

    /* renamed from: a, reason: collision with root package name */
    private final int f44092a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44093b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44094c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f44095d;

    /* renamed from: e, reason: collision with root package name */
    private final String f44096e;

    /* renamed from: f, reason: collision with root package name */
    private final String f44097f;

    /* renamed from: g, reason: collision with root package name */
    private final String f44098g;

    /* renamed from: h, reason: collision with root package name */
    private final int f44099h;

    /* renamed from: i, reason: collision with root package name */
    private final Format f44100i;

    /* renamed from: j, reason: collision with root package name */
    private final String f44101j;

    /* renamed from: k, reason: collision with root package name */
    private final String f44102k;

    /* renamed from: l, reason: collision with root package name */
    private final String f44103l;

    /* renamed from: m, reason: collision with root package name */
    a f44104m;

    /* renamed from: n, reason: collision with root package name */
    private int f44105n;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f44106a = false;

        /* renamed from: b, reason: collision with root package name */
        private boolean f44107b = true;

        /* renamed from: c, reason: collision with root package name */
        private String f44108c = null;

        /* renamed from: d, reason: collision with root package name */
        private boolean f44109d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f44110e = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f44111f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f44112g = true;

        /* renamed from: h, reason: collision with root package name */
        private int f44113h = 2;

        /* renamed from: i, reason: collision with root package name */
        private int f44114i = 2;

        /* renamed from: j, reason: collision with root package name */
        private String f44115j;

        /* renamed from: k, reason: collision with root package name */
        private String f44116k;

        public ObjectLogUtils m() {
            return new ObjectLogUtils(this);
        }

        public a n(boolean z10) {
            this.f44112g = z10;
            return this;
        }

        public a o(boolean z10) {
            this.f44107b = z10;
            return this;
        }

        public a p(String str) {
            if (ObjectLogUtils.p(str)) {
                this.f44108c = "";
                this.f44109d = true;
            } else {
                this.f44108c = str;
                this.f44109d = false;
            }
            return this;
        }

        public a q(boolean z10) {
            this.f44110e = z10;
            return this;
        }

        public a r(boolean z10) {
            this.f44106a = z10;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("switch: ");
            sb2.append(this.f44106a);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("console: ");
            sb2.append(this.f44107b);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("tag: ");
            sb2.append(this.f44109d ? "null" : this.f44108c);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("head: ");
            sb2.append(this.f44110e);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("file: ");
            sb2.append(this.f44111f);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("dir: ");
            String str = this.f44116k;
            if (str == null) {
                str = this.f44115j;
            }
            sb2.append(str);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("border: ");
            sb2.append(this.f44112g);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("consoleFilter: ");
            sb2.append(ObjectLogUtils.f44089o[this.f44113h - 2]);
            sb2.append(ObjectLogUtils.f44091q);
            sb2.append("fileFilter: ");
            sb2.append(ObjectLogUtils.f44089o[this.f44114i - 2]);
            return sb2.toString();
        }
    }

    private ObjectLogUtils(a aVar) {
        this.f44092a = 16;
        this.f44093b = 32;
        this.f44094c = 48;
        this.f44096e = "|---------------------------------------------------------------------------------------------------";
        this.f44097f = "| ";
        this.f44098g = "|---------------------------------------------------------------------------------------------------";
        this.f44099h = 4000;
        this.f44100i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f44101j = "Log with null object.";
        this.f44102k = "null";
        this.f44103l = NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS;
        new a();
        this.f44105n = 0;
        this.f44104m = aVar;
    }

    private String d(String str) {
        if (!this.f44104m.f44112g) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f44091q)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(f44091q);
        }
        return sb2.toString();
    }

    private static boolean e(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!e(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private static String k(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return str;
    }

    private String l(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f44091q);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean p(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    private void r(int i11, String str, Object... objArr) {
        try {
            if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
                if (!this.f44104m.f44106a) {
                    return;
                }
                if (!this.f44104m.f44107b && !this.f44104m.f44111f) {
                    return;
                }
            }
            int i12 = i11 & 15;
            int i13 = i11 & 240;
            if (i12 >= this.f44104m.f44113h || i12 >= this.f44104m.f44114i) {
                String[] w11 = w(str);
                String v11 = v(i13, objArr);
                if (this.f44104m.f44107b && i12 >= this.f44104m.f44113h) {
                    t(i12, w11[0], w11[1], v11);
                }
                if ((this.f44104m.f44111f || i13 == 16) && i12 >= this.f44104m.f44114i) {
                    u(i12, w11[0], w11[2] + v11);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void s(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    private void t(int i11, String str, String str2, String str3) {
        if (this.f44104m.f44110e) {
            s(i11, str, "\n" + str2);
        } else {
            s(i11, str, " \n");
        }
        if (this.f44104m.f44112g) {
            s(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = d(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            s(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String substring = str3.substring(i13, i15);
                if (this.f44104m.f44112g) {
                    substring = "| " + substring;
                }
                s(i11, str, substring);
                i14++;
                i13 = i15;
            }
            String substring2 = str3.substring(i13, length);
            if (this.f44104m.f44112g) {
                substring2 = "| " + substring2;
            }
            s(i11, str, substring2);
        } else {
            s(i11, str, str3);
        }
        if (this.f44104m.f44112g) {
            s(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private void u(int i11, final String str, String str2) {
        String format = this.f44100i.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        if (this.f44104m.f44115j == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || b.a(qk.a.a()) == null) {
                a aVar = this.f44104m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(qk.a.a().getCacheDir());
                String str3 = f44090p;
                sb2.append(str3);
                sb2.append("log");
                sb2.append(str3);
                aVar.f44115j = sb2.toString();
            } else {
                a aVar2 = this.f44104m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b.a(qk.a.a()));
                String str4 = f44090p;
                sb3.append(str4);
                sb3.append("log");
                sb3.append(str4);
                aVar2.f44115j = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f44104m.f44116k == null ? this.f44104m.f44115j : this.f44104m.f44116k);
        sb4.append(substring);
        sb4.append(".txt");
        final String sb5 = sb4.toString();
        if (!f(sb5)) {
            Log.e(str, "log to " + sb5 + " failed!");
            return;
        }
        final String str5 = substring2 + f44089o[i11 - 2] + "/" + str + str2 + f44091q;
        if (this.f44095d == null) {
            this.f44095d = Executors.newSingleThreadExecutor();
        }
        this.f44095d.execute(new Runnable() { // from class: com.transsion.core.log.ObjectLogUtils.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x002c -> B:8:0x005e). Please report as a decompilation issue!!! */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "log to "
                    r1 = 0
                    java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    java.lang.String r4 = r2     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    r5 = 1
                    r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L37
                    java.lang.String r1 = r3     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r2.write(r1)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r1.<init>()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r1.append(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    java.lang.String r3 = r2     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r1.append(r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    java.lang.String r3 = " success!"
                    r1.append(r3)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
                    r2.close()     // Catch: java.io.IOException -> L2b
                    goto L5e
                L2b:
                    r0 = move-exception
                    r0.printStackTrace()
                    goto L5e
                L30:
                    r0 = move-exception
                    r1 = r2
                    goto L5f
                L33:
                    r1 = move-exception
                    goto L3b
                L35:
                    r0 = move-exception
                    goto L5f
                L37:
                    r2 = move-exception
                    r6 = r2
                    r2 = r1
                    r1 = r6
                L3b:
                    r1.printStackTrace()     // Catch: java.lang.Throwable -> L30
                    java.lang.String r1 = r4     // Catch: java.lang.Throwable -> L30
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
                    r3.<init>()     // Catch: java.lang.Throwable -> L30
                    r3.append(r0)     // Catch: java.lang.Throwable -> L30
                    java.lang.String r0 = r2     // Catch: java.lang.Throwable -> L30
                    r3.append(r0)     // Catch: java.lang.Throwable -> L30
                    java.lang.String r0 = " failed!"
                    r3.append(r0)     // Catch: java.lang.Throwable -> L30
                    java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L30
                    android.util.Log.e(r1, r0)     // Catch: java.lang.Throwable -> L30
                    if (r2 == 0) goto L5e
                    r2.close()     // Catch: java.io.IOException -> L2b
                L5e:
                    return
                L5f:
                    if (r1 == 0) goto L69
                    r1.close()     // Catch: java.io.IOException -> L65
                    goto L69
                L65:
                    r1 = move-exception
                    r1.printStackTrace()
                L69:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.core.log.ObjectLogUtils.AnonymousClass1.run():void");
            }
        });
    }

    private String v(int i11, Object... objArr) {
        if (objArr == null) {
            return "Log with null object.";
        }
        if (objArr.length == 1) {
            Object obj = objArr[0];
            String obj2 = obj != null ? obj.toString() : "null";
            return i11 == 32 ? k(obj2) : i11 == 48 ? l(obj2) : obj2;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            Object obj3 = objArr[i12];
            sb2.append(NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS);
            sb2.append("[");
            sb2.append(i12);
            sb2.append("]");
            sb2.append(" = ");
            sb2.append(obj3 == null ? "null" : obj3.toString());
            sb2.append(f44091q);
        }
        return sb2.toString();
    }

    private String[] w(String str) {
        if (this.f44104m.f44109d || this.f44104m.f44110e) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f44105n + 5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.f44104m.f44109d && p(str)) {
                str = className;
            }
            if (this.f44104m.f44110e) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + f44091q, " [" + formatter + "]: "};
            }
        } else {
            str = this.f44104m.f44108c;
        }
        return new String[]{str, "", ": "};
    }

    public void A(String str, Object... objArr) {
        r(5, str, objArr);
    }

    public void g(Object obj) {
        r(3, this.f44104m.f44108c, obj);
    }

    public void h(String str, Object... objArr) {
        r(3, str, objArr);
    }

    public void i(Object obj) {
        r(6, this.f44104m.f44108c, obj);
    }

    public void j(String str, Object... objArr) {
        r(6, str, objArr);
    }

    public a m() {
        return this.f44104m;
    }

    public void n(Object obj) {
        r(4, this.f44104m.f44108c, obj);
    }

    public void o(String str, Object... objArr) {
        r(4, str, objArr);
    }

    public void q(String str, String str2) {
        r(35, str, str2);
    }

    public void x(int i11) {
        this.f44105n = i11;
    }

    public void y(String str, Object... objArr) {
        r(2, str, objArr);
    }

    public void z(Object obj) {
        r(5, this.f44104m.f44108c, obj);
    }
}
