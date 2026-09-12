package androidx.datastore.preferences.protobuf;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f8997a = Charset.forName(C.ASCII_NAME);

    /* renamed from: b, reason: collision with root package name */
    static final Charset f8998b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    static final Charset f8999c = Charset.forName("ISO-8859-1");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f9000d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f9001e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f9002f;

    /* loaded from: classes.dex */
    public interface a {
        int getNumber();
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean isInRange(int i11);
    }

    /* loaded from: classes.dex */
    public interface d extends List, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        d mutableCopyWithCapacity(int i11);
    }

    static {
        byte[] bArr = new byte[0];
        f9000d = bArr;
        f9001e = ByteBuffer.wrap(bArr);
        f9002f = i.k(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i11, int i12) {
        int g11 = g(i12, bArr, i11, i12);
        if (g11 == 0) {
            return 1;
        }
        return g11;
    }

    public static int f(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }
}
