package vb;

import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.common.a0;
import com.google.firebase.crashlytics.internal.common.k;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import rb.o;
import tb.j;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f77312e = Charset.forName("UTF-8");

    /* renamed from: f, reason: collision with root package name */
    private static final int f77313f = 15;

    /* renamed from: g, reason: collision with root package name */
    private static final j f77314g = new j();

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator f77315h = new Comparator() { // from class: vb.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int u11;
            u11 = e.u((File) obj, (File) obj2);
            return u11;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final FilenameFilter f77316i = new FilenameFilter() { // from class: vb.b
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean v11;
            v11 = e.v(file, str);
            return v11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f77317a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private final g f77318b;

    /* renamed from: c, reason: collision with root package name */
    private final wb.b f77319c;

    /* renamed from: d, reason: collision with root package name */
    private final k f77320d;

    public e(g gVar, wb.b bVar, k kVar) {
        this.f77318b = gVar;
        this.f77319c = bVar;
        this.f77320d = kVar;
    }

    private static String A(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f77312e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void B(File file, CrashlyticsReport.d dVar, String str, CrashlyticsReport.a aVar) {
        String d11 = this.f77320d.d(str);
        try {
            j jVar = f77314g;
            F(this.f77318b.i(str), jVar.M(jVar.L(A(file)).u(dVar).q(aVar).p(d11)));
        } catch (IOException e11) {
            ob.g.f().l("Could not synthesize final native report file for " + file, e11);
        }
    }

    private void C(String str, long j11) {
        boolean z10;
        List<File> r11 = this.f77318b.r(str, f77316i);
        if (r11.isEmpty()) {
            ob.g.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(r11);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z10 = false;
            for (File file : r11) {
                try {
                    arrayList.add(f77314g.j(A(file)));
                } catch (IOException e11) {
                    ob.g.f().l("Could not add event to report for " + file, e11);
                }
                if (z10 || s(file.getName())) {
                    z10 = true;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            D(this.f77318b.q(str, "report"), arrayList, j11, z10, o.n(str, this.f77318b), this.f77320d.d(str));
        } else {
            ob.g.f().k("Could not parse event files for session " + str);
        }
    }

    private void D(File file, List list, long j11, boolean z10, String str, String str2) {
        try {
            j jVar = f77314g;
            CrashlyticsReport r11 = jVar.L(A(file)).v(j11, z10, str).p(str2).r(list);
            CrashlyticsReport.e n11 = r11.n();
            if (n11 == null) {
                return;
            }
            ob.g.f().b("appQualitySessionId: " + str2);
            F(z10 ? this.f77318b.l(n11.i()) : this.f77318b.n(n11.i()), jVar.M(r11));
        } catch (IOException e11) {
            ob.g.f().l("Could not synthesize final report file for " + file, e11);
        }
    }

    private int E(String str, int i11) {
        List r11 = this.f77318b.r(str, new FilenameFilter() { // from class: vb.c
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                boolean t11;
                t11 = e.t(file, str2);
                return t11;
            }
        });
        Collections.sort(r11, new Comparator() { // from class: vb.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int x10;
                x10 = e.x((File) obj, (File) obj2);
                return x10;
            }
        });
        return f(r11, i11);
    }

    private static void F(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f77312e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th2) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static void G(File file, String str, long j11) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f77312e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j11));
            outputStreamWriter.close();
        } catch (Throwable th2) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private SortedSet e(String str) {
        this.f77318b.d();
        SortedSet p11 = p();
        if (str != null) {
            p11.remove(str);
        }
        if (p11.size() <= 8) {
            return p11;
        }
        while (p11.size() > 8) {
            String str2 = (String) p11.last();
            ob.g.f().b("Removing session over cap: " + str2);
            this.f77318b.e(str2);
            p11.remove(str2);
        }
        return p11;
    }

    private static int f(List list, int i11) {
        int size = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (size <= i11) {
                return size;
            }
            g.v(file);
            size--;
        }
        return size;
    }

    private void g() {
        int i11 = this.f77319c.b().f31791a.f31803b;
        List n11 = n();
        int size = n11.size();
        if (size <= i11) {
            return;
        }
        Iterator it = n11.subList(i11, size).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    private static long h(long j11) {
        return j11 * 1000;
    }

    private void j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    private static String m(int i11, boolean z10) {
        return NotificationCompat.CATEGORY_EVENT + String.format(Locale.US, "%010d", Integer.valueOf(i11)) + (z10 ? "_" : "");
    }

    private List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f77318b.m());
        arrayList.addAll(this.f77318b.j());
        Comparator comparator = f77315h;
        Collections.sort(arrayList, comparator);
        List o11 = this.f77318b.o();
        Collections.sort(o11, comparator);
        arrayList.addAll(o11);
        return arrayList;
    }

    private static String o(String str) {
        return str.substring(0, f77313f);
    }

    private static boolean s(String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(File file, String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int u(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean v(File file, String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    public void i() {
        j(this.f77318b.o());
        j(this.f77318b.m());
        j(this.f77318b.j());
    }

    public void k(String str, long j11) {
        for (String str2 : e(str)) {
            ob.g.f().i("Finalizing report for session " + str2);
            C(str2, j11);
            this.f77318b.e(str2);
        }
        g();
    }

    public void l(String str, CrashlyticsReport.d dVar, CrashlyticsReport.a aVar) {
        File q11 = this.f77318b.q(str, "report");
        ob.g.f().b("Writing native session report for " + str + " to file: " + q11);
        B(q11, dVar, str, aVar);
    }

    public SortedSet p() {
        return new TreeSet(this.f77318b.f()).descendingSet();
    }

    public long q(String str) {
        return this.f77318b.q(str, "start-time").lastModified();
    }

    public boolean r() {
        return (this.f77318b.o().isEmpty() && this.f77318b.m().isEmpty() && this.f77318b.j().isEmpty()) ? false : true;
    }

    public List w() {
        List<File> n11 = n();
        ArrayList arrayList = new ArrayList();
        for (File file : n11) {
            try {
                arrayList.add(a0.a(f77314g.L(A(file)), file.getName(), file));
            } catch (IOException e11) {
                ob.g.f().l("Could not load report file " + file + "; deleting", e11);
                file.delete();
            }
        }
        return arrayList;
    }

    public void y(CrashlyticsReport.e.d dVar, String str, boolean z10) {
        int i11 = this.f77319c.b().f31791a.f31802a;
        try {
            F(this.f77318b.q(str, m(this.f77317a.getAndIncrement(), z10)), f77314g.k(dVar));
        } catch (IOException e11) {
            ob.g.f().l("Could not persist event for session " + str, e11);
        }
        E(str, i11);
    }

    public void z(CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.e n11 = crashlyticsReport.n();
        if (n11 == null) {
            ob.g.f().b("Could not get session for report");
            return;
        }
        String i11 = n11.i();
        try {
            F(this.f77318b.q(i11, "report"), f77314g.M(crashlyticsReport));
            G(this.f77318b.q(i11, "start-time"), "", n11.l());
        } catch (IOException e11) {
            ob.g.f().c("Could not persist report for session " + i11, e11);
        }
    }
}
