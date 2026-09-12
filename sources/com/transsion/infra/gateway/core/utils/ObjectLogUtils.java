package com.transsion.infra.gateway.core.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
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
    private static final char[] f46051o = {'V', 'D', 'I', 'W', 'E', 'A'};

    /* renamed from: p, reason: collision with root package name */
    private static final String f46052p = System.getProperty("file.separator");

    /* renamed from: q, reason: collision with root package name */
    private static final String f46053q = System.getProperty("line.separator");

    /* renamed from: a, reason: collision with root package name */
    private final int f46054a;

    /* renamed from: b, reason: collision with root package name */
    private final int f46055b;

    /* renamed from: c, reason: collision with root package name */
    private final int f46056c;

    /* renamed from: d, reason: collision with root package name */
    private ExecutorService f46057d;

    /* renamed from: e, reason: collision with root package name */
    private final String f46058e;

    /* renamed from: f, reason: collision with root package name */
    private final String f46059f;

    /* renamed from: g, reason: collision with root package name */
    private final String f46060g;

    /* renamed from: h, reason: collision with root package name */
    private final int f46061h;

    /* renamed from: i, reason: collision with root package name */
    private final Format f46062i;

    /* renamed from: j, reason: collision with root package name */
    private final String f46063j;

    /* renamed from: k, reason: collision with root package name */
    private final String f46064k;

    /* renamed from: l, reason: collision with root package name */
    private final String f46065l;

    /* renamed from: m, reason: collision with root package name */
    a f46066m;

    /* renamed from: n, reason: collision with root package name */
    private int f46067n;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f46068a = false;

        /* renamed from: b, reason: collision with root package name */
        private boolean f46069b = true;

        /* renamed from: c, reason: collision with root package name */
        private String f46070c = null;

        /* renamed from: d, reason: collision with root package name */
        private boolean f46071d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f46072e = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f46073f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f46074g = true;

        /* renamed from: h, reason: collision with root package name */
        private int f46075h = 2;

        /* renamed from: i, reason: collision with root package name */
        private int f46076i = 2;

        /* renamed from: j, reason: collision with root package name */
        private String f46077j;

        /* renamed from: k, reason: collision with root package name */
        private String f46078k;

        public ObjectLogUtils m() {
            return new ObjectLogUtils(this);
        }

        public a n(boolean z10) {
            this.f46074g = z10;
            return this;
        }

        public a o(String str) {
            if (ObjectLogUtils.q(str)) {
                this.f46070c = "";
                this.f46071d = true;
            } else {
                this.f46070c = str;
                this.f46071d = false;
            }
            return this;
        }

        public a p(boolean z10) {
            this.f46072e = z10;
            return this;
        }

        public a q(boolean z10) {
            this.f46068a = z10;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("switch: ");
            sb2.append(this.f46068a);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("console: ");
            sb2.append(this.f46069b);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("tag: ");
            sb2.append(this.f46071d ? "null" : this.f46070c);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("head: ");
            sb2.append(this.f46072e);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("file: ");
            sb2.append(this.f46073f);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("dir: ");
            String str = this.f46078k;
            if (str == null) {
                str = this.f46077j;
            }
            sb2.append(str);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("border: ");
            sb2.append(this.f46074g);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("consoleFilter: ");
            sb2.append(ObjectLogUtils.f46051o[this.f46075h - 2]);
            sb2.append(ObjectLogUtils.f46053q);
            sb2.append("fileFilter: ");
            sb2.append(ObjectLogUtils.f46051o[this.f46076i - 2]);
            return sb2.toString();
        }
    }

    private ObjectLogUtils(a aVar) {
        this.f46054a = 16;
        this.f46055b = 32;
        this.f46056c = 48;
        this.f46058e = "|---------------------------------------------------------------------------------------------------";
        this.f46059f = "| ";
        this.f46060g = "|---------------------------------------------------------------------------------------------------";
        this.f46061h = 4000;
        this.f46062i = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ", Locale.getDefault());
        this.f46063j = "Log with null object.";
        this.f46064k = "null";
        this.f46065l = NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS;
        new a();
        this.f46067n = 0;
        this.f46066m = aVar;
    }

    private String d(String str) {
        if (!this.f46066m.f46074g) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split(f46053q)) {
            sb2.append("| ");
            sb2.append(str2);
            sb2.append(f46053q);
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
            return streamResult.getWriter().toString().replaceFirst(">", ">" + f46053q);
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static File n(Context context) {
        boolean z10 = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z10 = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (z10) {
            return null;
        }
        try {
            return context.getExternalCacheDir();
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(String str) {
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

    private void s(int i11, String str, Object... objArr) {
        if (!Log.isLoggable(str.length() > 23 ? str.substring(0, 23) : str, 3)) {
            if (!this.f46066m.f46068a) {
                return;
            }
            if (!this.f46066m.f46069b && !this.f46066m.f46073f) {
                return;
            }
        }
        int i12 = i11 & 15;
        int i13 = i11 & 240;
        if (i12 >= this.f46066m.f46075h || i12 >= this.f46066m.f46076i) {
            String[] x10 = x(str);
            String w11 = w(i13, objArr);
            if (this.f46066m.f46069b && i12 >= this.f46066m.f46075h) {
                u(i12, x10[0], x10[1], w11);
            }
            if ((this.f46066m.f46073f || i13 == 16) && i12 >= this.f46066m.f46076i) {
                v(i12, x10[0], x10[2] + w11);
            }
        }
    }

    private static void t(int i11, String str, String str2) {
        Log.println(i11, str, str2);
    }

    private void u(int i11, String str, String str2, String str3) {
        if (this.f46066m.f46072e) {
            t(i11, str, "\n" + str2);
        } else {
            t(i11, str, " \n");
        }
        if (this.f46066m.f46074g) {
            t(i11, str, "|---------------------------------------------------------------------------------------------------");
            str3 = d(str3);
        }
        int length = str3.length();
        int i12 = length / 4000;
        if (i12 > 0) {
            int i13 = 4000;
            t(i11, str, str3.substring(0, 4000));
            int i14 = 1;
            while (i14 < i12) {
                int i15 = i13 + 4000;
                String substring = str3.substring(i13, i15);
                if (this.f46066m.f46074g) {
                    substring = "| " + substring;
                }
                t(i11, str, substring);
                i14++;
                i13 = i15;
            }
            String substring2 = str3.substring(i13, length);
            if (this.f46066m.f46074g) {
                substring2 = "| " + substring2;
            }
            t(i11, str, substring2);
        } else {
            t(i11, str, str3);
        }
        if (this.f46066m.f46074g) {
            t(i11, str, "|---------------------------------------------------------------------------------------------------");
        }
    }

    private void v(int i11, final String str, String str2) {
        String format = this.f46062i.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        if (this.f46066m.f46077j == null) {
            if (!"mounted".equals(Environment.getExternalStorageState()) || n(com.transsion.infra.gateway.core.utils.a.a()) == null) {
                a aVar = this.f46066m;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.transsion.infra.gateway.core.utils.a.a().getCacheDir());
                String str3 = f46052p;
                sb2.append(str3);
                sb2.append("log");
                sb2.append(str3);
                aVar.f46077j = sb2.toString();
            } else {
                a aVar2 = this.f46066m;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(n(com.transsion.infra.gateway.core.utils.a.a()));
                String str4 = f46052p;
                sb3.append(str4);
                sb3.append("log");
                sb3.append(str4);
                aVar2.f46077j = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f46066m.f46078k == null ? this.f46066m.f46077j : this.f46066m.f46078k);
        sb4.append(substring);
        sb4.append(".txt");
        final String sb5 = sb4.toString();
        if (!f(sb5)) {
            Log.e(str, "log to " + sb5 + " failed!");
            return;
        }
        final String str5 = substring2 + f46051o[i11 - 2] + "/" + str + str2 + f46053q;
        if (this.f46057d == null) {
            this.f46057d = Executors.newSingleThreadExecutor();
        }
        this.f46057d.execute(new Runnable() { // from class: com.transsion.infra.gateway.core.utils.ObjectLogUtils.1
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
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.infra.gateway.core.utils.ObjectLogUtils.AnonymousClass1.run():void");
            }
        });
    }

    private String w(int i11, Object... objArr) {
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
            sb2.append(f46053q);
        }
        return sb2.toString();
    }

    private String[] x(String str) {
        if (this.f46066m.f46071d || this.f46066m.f46072e) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[this.f46067n + 5];
            String className = stackTraceElement.getClassName();
            String[] split = className.split("\\.");
            if (split.length > 0) {
                className = split[split.length - 1];
            }
            if (className.contains("$")) {
                className = className.split("\\$")[0];
            }
            if (this.f46066m.f46071d && q(str)) {
                str = className;
            }
            if (this.f46066m.f46072e) {
                String formatter = new Formatter().format("%s, %s(%s.java:%d)", Thread.currentThread().getName(), stackTraceElement.getMethodName(), className, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                return new String[]{str, formatter + f46053q, " [" + formatter + "]: "};
            }
        } else {
            str = this.f46066m.f46070c;
        }
        return new String[]{str, "", ": "};
    }

    public void A(String str, Object... objArr) {
        s(5, str, objArr);
    }

    public void g(Object obj) {
        s(3, this.f46066m.f46070c, obj);
    }

    public void h(String str, Object... objArr) {
        s(3, str, objArr);
    }

    public void i(Object obj) {
        s(6, this.f46066m.f46070c, obj);
    }

    public void j(String str, Object... objArr) {
        s(6, str, objArr);
    }

    public a m() {
        return this.f46066m;
    }

    public void o(Object obj) {
        s(4, this.f46066m.f46070c, obj);
    }

    public void p(String str, Object... objArr) {
        s(4, str, objArr);
    }

    public void r(String str, String str2) {
        s(35, str, str2);
    }

    public void y(int i11) {
        this.f46067n = i11;
    }

    public void z(String str, Object... objArr) {
        s(2, str, objArr);
    }
}
