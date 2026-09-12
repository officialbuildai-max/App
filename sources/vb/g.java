package vb;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import ob.j;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    final String f77322a;

    /* renamed from: b, reason: collision with root package name */
    private final File f77323b;

    /* renamed from: c, reason: collision with root package name */
    private final File f77324c;

    /* renamed from: d, reason: collision with root package name */
    private final File f77325d;

    /* renamed from: e, reason: collision with root package name */
    private final File f77326e;

    /* renamed from: f, reason: collision with root package name */
    private final File f77327f;

    /* renamed from: g, reason: collision with root package name */
    private final File f77328g;

    public g(Context context) {
        String str;
        String d11 = j.f71081a.e(context).d();
        this.f77322a = d11;
        File filesDir = context.getFilesDir();
        this.f77323b = filesDir;
        if (y()) {
            str = ".crashlytics.v3" + File.separator + x(d11);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File t11 = t(new File(filesDir, str));
        this.f77324c = t11;
        this.f77325d = t(new File(t11, "open-sessions"));
        this.f77326e = t(new File(t11, "reports"));
        this.f77327f = t(new File(t11, "priority-reports"));
        this.f77328g = t(new File(t11, "native-reports"));
    }

    private void b(String str) {
        File file = new File(this.f77323b, str);
        if (file.exists() && v(file)) {
            ob.g.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private void c(final String str) {
        String[] list;
        if (!this.f77323b.exists() || (list = this.f77323b.list(new FilenameFilter() { // from class: vb.f
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                boolean s11;
                s11 = g.s(str, file, str2);
                return s11;
            }
        })) == null) {
            return;
        }
        for (String str2 : list) {
            b(str2);
        }
    }

    private File p(String str) {
        return u(new File(this.f77325d, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean s(String str, File file, String str2) {
        return str2.startsWith(str);
    }

    private static synchronized File t(File file) {
        synchronized (g.class) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        return file;
                    }
                    ob.g.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
                    file.delete();
                }
                if (!file.mkdirs()) {
                    ob.g.f().d("Could not create Crashlytics-specific directory: " + file);
                }
                return file;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static File u(File file) {
        file.mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                v(file2);
            }
        }
        return file.delete();
    }

    private static List w(Object[] objArr) {
        return objArr == null ? Collections.emptyList() : Arrays.asList(objArr);
    }

    static String x(String str) {
        return str.length() > 40 ? CommonUtils.z(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    private boolean y() {
        return !this.f77322a.isEmpty();
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (y()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return v(new File(this.f77325d, str));
    }

    public List f() {
        return w(this.f77325d.list());
    }

    public File g(String str) {
        return new File(this.f77324c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return w(this.f77324c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f77328g, str);
    }

    public List j() {
        return w(this.f77328g.listFiles());
    }

    public File k(String str) {
        return u(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f77327f, str);
    }

    public List m() {
        return w(this.f77327f.listFiles());
    }

    public File n(String str) {
        return new File(this.f77326e, str);
    }

    public List o() {
        return w(this.f77326e.listFiles());
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return w(p(str).listFiles(filenameFilter));
    }
}
