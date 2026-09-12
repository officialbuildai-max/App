package t4;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.h;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.q0;
import com.airbnb.lottie.r;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final f f76184a;

    /* renamed from: b, reason: collision with root package name */
    private final e f76185b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f76186a;

        static {
            int[] iArr = new int[FileExtension.values().length];
            f76186a = iArr;
            try {
                iArr[FileExtension.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f76186a[FileExtension.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public g(f fVar, e eVar) {
        this.f76184a = fVar;
        this.f76185b = eVar;
    }

    private h a(Context context, String str, String str2) {
        f fVar;
        Pair a11;
        q0 C;
        if (str2 == null || (fVar = this.f76184a) == null || (a11 = fVar.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a11.first;
        InputStream inputStream = (InputStream) a11.second;
        int i11 = a.f76186a[fileExtension.ordinal()];
        if (i11 == 1) {
            C = r.C(context, new ZipInputStream(inputStream), str2);
        } else if (i11 != 2) {
            C = r.q(inputStream, str2);
        } else {
            try {
                C = r.q(new GZIPInputStream(inputStream), str2);
            } catch (IOException e11) {
                C = new q0((Throwable) e11);
            }
        }
        if (C.b() != null) {
            return (h) C.b();
        }
        return null;
    }

    private q0 b(Context context, String str, String str2) {
        v4.f.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                c a11 = this.f76185b.a(str);
                if (!a11.isSuccessful()) {
                    q0 q0Var = new q0((Throwable) new IllegalArgumentException(a11.error()));
                    try {
                        a11.close();
                    } catch (IOException e11) {
                        v4.f.d("LottieFetchResult close failed ", e11);
                    }
                    return q0Var;
                }
                q0 e12 = e(context, str, a11.M(), a11.z(), str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                sb2.append(e12.b() != null);
                v4.f.a(sb2.toString());
                try {
                    a11.close();
                } catch (IOException e13) {
                    v4.f.d("LottieFetchResult close failed ", e13);
                }
                return e12;
            } catch (Exception e14) {
                q0 q0Var2 = new q0((Throwable) e14);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e15) {
                        v4.f.d("LottieFetchResult close failed ", e15);
                    }
                }
                return q0Var2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e16) {
                    v4.f.d("LottieFetchResult close failed ", e16);
                }
            }
            throw th2;
        }
    }

    private q0 d(String str, InputStream inputStream, String str2) {
        f fVar;
        return (str2 == null || (fVar = this.f76184a) == null) ? r.q(new GZIPInputStream(inputStream), null) : r.q(new GZIPInputStream(new FileInputStream(fVar.g(str, inputStream, FileExtension.GZIP))), str);
    }

    private q0 e(Context context, String str, InputStream inputStream, String str2, String str3) {
        q0 g11;
        FileExtension fileExtension;
        f fVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            v4.f.a("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            g11 = g(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            v4.f.a("Handling gzip response.");
            fileExtension = FileExtension.GZIP;
            g11 = d(str, inputStream, str3);
        } else {
            v4.f.a("Received json response.");
            fileExtension = FileExtension.JSON;
            g11 = f(str, inputStream, str3);
        }
        if (str3 != null && g11.b() != null && (fVar = this.f76184a) != null) {
            fVar.f(str, fileExtension);
        }
        return g11;
    }

    private q0 f(String str, InputStream inputStream, String str2) {
        f fVar;
        return (str2 == null || (fVar = this.f76184a) == null) ? r.q(inputStream, null) : r.q(new FileInputStream(fVar.g(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    private q0 g(Context context, String str, InputStream inputStream, String str2) {
        f fVar;
        return (str2 == null || (fVar = this.f76184a) == null) ? r.C(context, new ZipInputStream(inputStream), null) : r.C(context, new ZipInputStream(new FileInputStream(fVar.g(str, inputStream, FileExtension.ZIP))), str);
    }

    public q0 c(Context context, String str, String str2) {
        h a11 = a(context, str, str2);
        if (a11 != null) {
            return new q0(a11);
        }
        v4.f.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
