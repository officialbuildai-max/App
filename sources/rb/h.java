package rb;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import rb.g;

/* loaded from: classes5.dex */
class h implements c {

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f74391d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final File f74392a;

    /* renamed from: b, reason: collision with root package name */
    private final int f74393b;

    /* renamed from: c, reason: collision with root package name */
    private g f74394c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements g.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f74395a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f74396b;

        a(byte[] bArr, int[] iArr) {
            this.f74395a = bArr;
            this.f74396b = iArr;
        }

        @Override // rb.g.d
        public void read(InputStream inputStream, int i11) {
            try {
                inputStream.read(this.f74395a, this.f74396b[0], i11);
                int[] iArr = this.f74396b;
                iArr[0] = iArr[0] + i11;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f74398a;

        /* renamed from: b, reason: collision with root package name */
        public final int f74399b;

        b(byte[] bArr, int i11) {
            this.f74398a = bArr;
            this.f74399b = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(File file, int i11) {
        this.f74392a = file;
        this.f74393b = i11;
    }

    private void f(long j11, String str) {
        if (this.f74394c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i11 = this.f74393b / 4;
            if (str.length() > i11) {
                str = "..." + str.substring(str.length() - i11);
            }
            this.f74394c.k(String.format(Locale.US, "%d %s%n", Long.valueOf(j11), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f74391d));
            while (!this.f74394c.q() && this.f74394c.Z() > this.f74393b) {
                this.f74394c.x();
            }
        } catch (IOException e11) {
            ob.g.f().e("There was a problem writing to the Crashlytics log.", e11);
        }
    }

    private b g() {
        if (!this.f74392a.exists()) {
            return null;
        }
        h();
        g gVar = this.f74394c;
        if (gVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[gVar.Z()];
        try {
            this.f74394c.o(new a(bArr, iArr));
        } catch (IOException e11) {
            ob.g.f().e("A problem occurred while reading the Crashlytics log file.", e11);
        }
        return new b(bArr, iArr[0]);
    }

    private void h() {
        if (this.f74394c == null) {
            try {
                this.f74394c = new g(this.f74392a);
            } catch (IOException e11) {
                ob.g.f().e("Could not open log file: " + this.f74392a, e11);
            }
        }
    }

    @Override // rb.c
    public void a() {
        CommonUtils.f(this.f74394c, "There was a problem closing the Crashlytics log file.");
        this.f74394c = null;
    }

    @Override // rb.c
    public String b() {
        byte[] c11 = c();
        if (c11 != null) {
            return new String(c11, f74391d);
        }
        return null;
    }

    @Override // rb.c
    public byte[] c() {
        b g11 = g();
        if (g11 == null) {
            return null;
        }
        int i11 = g11.f74399b;
        byte[] bArr = new byte[i11];
        System.arraycopy(g11.f74398a, 0, bArr, 0, i11);
        return bArr;
    }

    @Override // rb.c
    public void d() {
        a();
        this.f74392a.delete();
    }

    @Override // rb.c
    public void e(long j11, String str) {
        h();
        f(j11, str);
    }
}
