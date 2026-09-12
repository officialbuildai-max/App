package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f18037a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f18038b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f18039c = {80, 75, 3, 4};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f18040d = {31, -117, 8};

    public static LottieTask A(final Context context, final ZipInputStream zipInputStream, final String str) {
        return j(str, new Callable() { // from class: com.airbnb.lottie.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 C;
                C = r.C(context, zipInputStream, str);
                return C;
            }
        }, new Runnable() { // from class: com.airbnb.lottie.m
            @Override // java.lang.Runnable
            public final void run() {
                v4.l.c(zipInputStream);
            }
        });
    }

    public static LottieTask B(ZipInputStream zipInputStream, String str) {
        return A(null, zipInputStream, str);
    }

    public static q0 C(Context context, ZipInputStream zipInputStream, String str) {
        return D(context, zipInputStream, str, true);
    }

    public static q0 D(Context context, ZipInputStream zipInputStream, String str, boolean z10) {
        try {
            return E(context, zipInputStream, str);
        } finally {
            if (z10) {
                v4.l.c(zipInputStream);
            }
        }
    }

    private static q0 E(Context context, ZipInputStream zipInputStream, String str) {
        h a11;
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (str == null) {
            a11 = null;
        } else {
            try {
                a11 = p4.f.b().a(str);
            } catch (IOException e11) {
                return new q0((Throwable) e11);
            }
        }
        if (a11 != null) {
            return new q0(a11);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        h hVar = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                hVar = (h) t(JsonReader.s(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
            } else {
                if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                    if (!name.contains(".ttf") && !name.contains(".otf")) {
                        zipInputStream.closeEntry();
                    }
                    String[] split = name.split("/");
                    String str2 = split[split.length - 1];
                    String str3 = str2.split("\\.")[0];
                    File file = new File(context.getCacheDir(), str2);
                    new FileOutputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th2) {
                        v4.f.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th2);
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Typeface createFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            v4.f.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        hashMap2.put(str3, createFromFile);
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                        break;
                    }
                }
                String[] split2 = name.split("/");
                hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (hVar == null) {
            return new q0((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            l0 k11 = k(hVar, (String) entry.getKey());
            if (k11 != null) {
                k11.g(v4.l.m((Bitmap) entry.getValue(), k11.f(), k11.d()));
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            boolean z10 = false;
            for (p4.b bVar : hVar.g().values()) {
                if (bVar.a().equals(entry2.getKey())) {
                    bVar.e((Typeface) entry2.getValue());
                    z10 = true;
                }
            }
            if (!z10) {
                v4.f.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (hashMap.isEmpty()) {
            Iterator it = hVar.j().entrySet().iterator();
            while (it.hasNext()) {
                l0 l0Var = (l0) ((Map.Entry) it.next()).getValue();
                if (l0Var == null) {
                    return null;
                }
                String c11 = l0Var.c();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (c11.startsWith("data:") && c11.indexOf("base64,") > 0) {
                    try {
                        byte[] decode = Base64.decode(c11.substring(c11.indexOf(44) + 1), 0);
                        l0Var.g(v4.l.m(BitmapFactory.decodeByteArray(decode, 0, decode.length, options), l0Var.f(), l0Var.d()));
                    } catch (IllegalArgumentException e12) {
                        v4.f.d("data URL did not have correct base64 format.", e12);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            p4.f.b().c(str, hVar);
        }
        return new q0(hVar);
    }

    private static Boolean F(BufferedSource bufferedSource) {
        return R(bufferedSource, f18040d);
    }

    private static boolean G(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean H(BufferedSource bufferedSource) {
        return R(bufferedSource, f18039c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(String str, AtomicBoolean atomicBoolean, h hVar) {
        Map map = f18037a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            S(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J(String str, AtomicBoolean atomicBoolean, Throwable th2) {
        Map map = f18037a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            S(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q0 N(WeakReference weakReference, Context context, int i11, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return x(context, i11, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q0 O(Context context, String str, String str2) {
        q0 c11 = d.j(context).c(context, str, str2);
        if (str2 != null && c11.b() != null) {
            p4.f.b().c(str2, (h) c11.b());
        }
        return c11;
    }

    private static Boolean R(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b11 : bArr) {
                if (peek.readByte() != b11) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e11) {
            v4.f.b("Failed to check zip file header", e11);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static void S(boolean z10) {
        ArrayList arrayList = new ArrayList(f18038b);
        if (arrayList.size() <= 0) {
            return;
        }
        android.support.v4.media.session.c.a(arrayList.get(0));
        throw null;
    }

    private static String T(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(G(context) ? "_night_" : "_day_");
        sb2.append(i11);
        return sb2.toString();
    }

    private static LottieTask j(final String str, Callable callable, Runnable runnable) {
        h a11 = str == null ? null : p4.f.b().a(str);
        LottieTask lottieTask = a11 != null ? new LottieTask(a11) : null;
        if (str != null) {
            Map map = f18037a;
            if (map.containsKey(str)) {
                lottieTask = (LottieTask) map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask lottieTask2 = new LottieTask(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask2.d(new m0() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.m0
                public final void onResult(Object obj) {
                    r.I(str, atomicBoolean, (h) obj);
                }
            });
            lottieTask2.c(new m0() { // from class: com.airbnb.lottie.p
                @Override // com.airbnb.lottie.m0
                public final void onResult(Object obj) {
                    r.J(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = f18037a;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    S(false);
                }
            }
        }
        return lottieTask2;
    }

    private static l0 k(h hVar, String str) {
        for (l0 l0Var : hVar.j().values()) {
            if (l0Var.c().equals(str)) {
                return l0Var;
            }
        }
        return null;
    }

    public static LottieTask l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static LottieTask m(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return j(str2, new Callable() { // from class: com.airbnb.lottie.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 o11;
                o11 = r.o(applicationContext, str, str2);
                return o11;
            }
        }, null);
    }

    public static q0 n(Context context, String str) {
        return o(context, str, "asset_" + str);
    }

    public static q0 o(Context context, String str, String str2) {
        h a11 = str2 == null ? null : p4.f.b().a(str2);
        if (a11 != null) {
            return new q0(a11);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getAssets().open(str)));
            return H(buffer).booleanValue() ? C(context, new ZipInputStream(buffer.inputStream()), str2) : F(buffer).booleanValue() ? q(new GZIPInputStream(buffer.inputStream()), str2) : q(buffer.inputStream(), str2);
        } catch (IOException e11) {
            return new q0((Throwable) e11);
        }
    }

    public static LottieTask p(final InputStream inputStream, final String str) {
        return j(str, new Callable() { // from class: com.airbnb.lottie.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 q11;
                q11 = r.q(inputStream, str);
                return q11;
            }
        }, new Runnable() { // from class: com.airbnb.lottie.k
            @Override // java.lang.Runnable
            public final void run() {
                v4.l.c(inputStream);
            }
        });
    }

    public static q0 q(InputStream inputStream, String str) {
        return r(inputStream, str, true);
    }

    public static q0 r(InputStream inputStream, String str, boolean z10) {
        return s(JsonReader.s(Okio.buffer(Okio.source(inputStream))), str, z10);
    }

    public static q0 s(JsonReader jsonReader, String str, boolean z10) {
        return t(jsonReader, str, z10);
    }

    private static q0 t(JsonReader jsonReader, String str, boolean z10) {
        h a11;
        try {
            if (str == null) {
                a11 = null;
            } else {
                try {
                    a11 = p4.f.b().a(str);
                } catch (Exception e11) {
                    q0 q0Var = new q0((Throwable) e11);
                    if (z10) {
                        v4.l.c(jsonReader);
                    }
                    return q0Var;
                }
            }
            if (a11 != null) {
                q0 q0Var2 = new q0(a11);
                if (z10) {
                    v4.l.c(jsonReader);
                }
                return q0Var2;
            }
            h a12 = u4.w.a(jsonReader);
            if (str != null) {
                p4.f.b().c(str, a12);
            }
            q0 q0Var3 = new q0(a12);
            if (z10) {
                v4.l.c(jsonReader);
            }
            return q0Var3;
        } catch (Throwable th2) {
            if (z10) {
                v4.l.c(jsonReader);
            }
            throw th2;
        }
    }

    public static LottieTask u(Context context, int i11) {
        return v(context, i11, T(context, i11));
    }

    public static LottieTask v(Context context, final int i11, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return j(str, new Callable() { // from class: com.airbnb.lottie.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 N;
                N = r.N(weakReference, applicationContext, i11, str);
                return N;
            }
        }, null);
    }

    public static q0 w(Context context, int i11) {
        return x(context, i11, T(context, i11));
    }

    public static q0 x(Context context, int i11, String str) {
        h a11 = str == null ? null : p4.f.b().a(str);
        if (a11 != null) {
            return new q0(a11);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i11)));
            if (H(buffer).booleanValue()) {
                return C(context, new ZipInputStream(buffer.inputStream()), str);
            }
            if (!F(buffer).booleanValue()) {
                return q(buffer.inputStream(), str);
            }
            try {
                return q(new GZIPInputStream(buffer.inputStream()), str);
            } catch (IOException e11) {
                return new q0((Throwable) e11);
            }
        } catch (Resources.NotFoundException e12) {
            return new q0((Throwable) e12);
        }
    }

    public static LottieTask y(Context context, String str) {
        return z(context, str, "url_" + str);
    }

    public static LottieTask z(final Context context, final String str, final String str2) {
        return j(str2, new Callable() { // from class: com.airbnb.lottie.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                q0 O;
                O = r.O(context, str, str2);
                return O;
            }
        }, null);
    }
}
