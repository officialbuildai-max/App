package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.concurrent.futures.b f14139a = androidx.concurrent.futures.b.y();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f14140b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static c f14141c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* loaded from: classes2.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int f14142a;

        /* renamed from: b, reason: collision with root package name */
        final int f14143b;

        /* renamed from: c, reason: collision with root package name */
        final long f14144c;

        /* renamed from: d, reason: collision with root package name */
        final long f14145d;

        b(int i11, int i12, long j11, long j12) {
            this.f14142a = i11;
            this.f14143b = i12;
            this.f14144c = j11;
            this.f14145d = j12;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f14142a);
                dataOutputStream.writeInt(this.f14143b);
                dataOutputStream.writeLong(this.f14144c);
                dataOutputStream.writeLong(this.f14145d);
                dataOutputStream.close();
            } catch (Throwable th2) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14143b == bVar.f14143b && this.f14144c == bVar.f14144c && this.f14142a == bVar.f14142a && this.f14145d == bVar.f14145d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f14143b), Long.valueOf(this.f14144c), Integer.valueOf(this.f14142a), Long.valueOf(this.f14145d));
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final int f14146a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f14147b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f14148c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f14149d;

        c(int i11, boolean z10, boolean z11, boolean z12) {
            this.f14146a = i11;
            this.f14148c = z11;
            this.f14147b = z10;
            this.f14149d = z12;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static c b(int i11, boolean z10, boolean z11, boolean z12) {
        c cVar = new c(i11, z10, z11, z12);
        f14141c = cVar;
        f14139a.u(cVar);
        return f14141c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:23|(1:89)(1:27)|28|(1:88)(1:32)|33|34|35|(2:74|75)(1:37)|38|(8:45|(1:49)|(1:56)|57|(2:64|65)|61|62|63)|(1:71)(1:(1:73))|(1:49)|(3:51|54|56)|57|(1:59)|64|65|61|62|63) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00fc, code lost:
    
        r5 = 196608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
    
        r5 = 327680;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.profileinstaller.m.c c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.m.c(android.content.Context, boolean):androidx.profileinstaller.m$c");
    }
}
