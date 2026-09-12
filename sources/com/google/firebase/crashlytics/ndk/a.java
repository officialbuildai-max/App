package com.google.firebase.crashlytics.ndk;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.utils.i;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.ndk.f;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import sb.e;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f31829d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final Context f31830a;

    /* renamed from: b, reason: collision with root package name */
    private final e f31831b;

    /* renamed from: c, reason: collision with root package name */
    private final vb.g f31832c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, e eVar, vb.g gVar) {
        this.f31830a = context;
        this.f31831b = eVar;
        this.f31832c = gVar;
    }

    private static CrashlyticsReport.a a(ApplicationExitInfo applicationExitInfo) {
        int importance;
        String processName;
        int reason;
        long timestamp;
        int pid;
        long pss;
        long rss;
        CrashlyticsReport.a.b a11 = CrashlyticsReport.a.a();
        importance = applicationExitInfo.getImportance();
        CrashlyticsReport.a.b c11 = a11.c(importance);
        processName = applicationExitInfo.getProcessName();
        CrashlyticsReport.a.b e11 = c11.e(processName);
        reason = applicationExitInfo.getReason();
        CrashlyticsReport.a.b g11 = e11.g(reason);
        timestamp = applicationExitInfo.getTimestamp();
        CrashlyticsReport.a.b i11 = g11.i(timestamp);
        pid = applicationExitInfo.getPid();
        CrashlyticsReport.a.b d11 = i11.d(pid);
        pss = applicationExitInfo.getPss();
        CrashlyticsReport.a.b f11 = d11.f(pss);
        rss = applicationExitInfo.getRss();
        return f11.h(rss).j(i(applicationExitInfo)).a();
    }

    public static String b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return r(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private CrashlyticsReport.a c(String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return f(str);
        }
        return null;
    }

    private f.c e(String str, File file) {
        return new f.c(h(file, ".dmp"), c(str));
    }

    private CrashlyticsReport.a f(String str) {
        List historicalProcessExitReasons;
        historicalProcessExitReasons = ((ActivityManager) this.f31830a.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
        File q11 = this.f31832c.q(str, "start-time");
        return g(q11 == null ? System.currentTimeMillis() : q11.lastModified(), historicalProcessExitReasons);
    }

    private CrashlyticsReport.a g(long j11, List list) {
        int reason;
        long timestamp;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ApplicationExitInfo a11 = i.a(it.next());
            reason = a11.getReason();
            if (reason == 5) {
                timestamp = a11.getTimestamp();
                if (timestamp >= j11) {
                    arrayList.add(a11);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return a(i.a(arrayList.get(0)));
    }

    private static File h(File file, String str) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    private static String i(ApplicationExitInfo applicationExitInfo) {
        InputStream traceInputStream;
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
            return b(traceInputStream);
        } catch (IOException unused) {
            ob.g.f().k("Failed to get input stream from ApplicationExitInfo");
            return null;
        }
    }

    private static void o(vb.g gVar, String str, String str2, String str3) {
        q(new File(gVar.k(str), str3), str2);
    }

    private static void q(File file, String str) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), f31829d));
        } catch (IOException unused) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedWriter.write(str);
            CommonUtils.f(bufferedWriter, "Failed to close " + file);
        } catch (IOException unused2) {
            bufferedWriter2 = bufferedWriter;
            CommonUtils.f(bufferedWriter2, "Failed to close " + file);
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.f(bufferedWriter2, "Failed to close " + file);
            throw th;
        }
    }

    private static String r(byte[] bArr) {
        Base64.Encoder encoder;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                encoder = Base64.getEncoder();
                encodeToString = encoder.encodeToString(byteArrayOutputStream.toByteArray());
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return encodeToString;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public f d(String str) {
        File k11 = this.f31832c.k(str);
        File file = new File(k11, "pending");
        ob.g.f().i("Minidump directory: " + file.getAbsolutePath());
        File h11 = h(file, ".dmp");
        ob.g f11 = ob.g.f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Minidump file ");
        sb2.append((h11 == null || !h11.exists()) ? "does not exist" : "exists");
        f11.i(sb2.toString());
        f.b bVar = new f.b();
        if (k11 != null && k11.exists() && file.exists()) {
            bVar.l(e(str, file)).k(h(k11, ".device_info")).n(new File(k11, "session.json")).h(new File(k11, "app.json")).j(new File(k11, "device.json")).m(new File(k11, "os.json"));
        }
        return bVar.i();
    }

    public boolean j(String str) {
        f.c cVar = d(str).f31843a;
        return cVar != null && cVar.a();
    }

    public boolean k(String str, String str2, long j11, sb.e eVar) {
        File k11 = this.f31832c.k(str);
        if (k11 == null) {
            return false;
        }
        try {
            if (!this.f31831b.a(k11.getCanonicalPath(), this.f31830a.getAssets())) {
                return false;
            }
            l(str, str2, j11);
            m(str, eVar.a());
            p(str, eVar.d());
            n(str, eVar.c());
            return true;
        } catch (IOException e11) {
            ob.g.f().e("Error initializing Crashlytics NDK", e11);
            return false;
        }
    }

    public void l(String str, String str2, long j11) {
        o(this.f31832c, str, h.b(str, str2, j11), "session.json");
    }

    public void m(String str, e.a aVar) {
        o(this.f31832c, str, h.c(aVar.a(), aVar.f(), aVar.g(), aVar.e(), aVar.c(), aVar.d().d(), aVar.d().e()), "app.json");
    }

    public void n(String str, e.b bVar) {
        o(this.f31832c, str, h.d(bVar.a(), bVar.g(), bVar.b(), bVar.j(), bVar.d(), bVar.e(), bVar.i(), bVar.f(), bVar.h()), "device.json");
    }

    public void p(String str, e.c cVar) {
        o(this.f31832c, str, h.e(cVar.d(), cVar.c(), cVar.b()), "os.json");
    }
}
