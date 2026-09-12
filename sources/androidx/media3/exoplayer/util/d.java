package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.o;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f13121a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f13122b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f13123c = false;

    /* renamed from: d, reason: collision with root package name */
    private static long f13124d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static String f13125e = "time.android.com";

    /* renamed from: f, reason: collision with root package name */
    private static int f13126f = 1000;

    /* renamed from: g, reason: collision with root package name */
    private static long f13127g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    private static long f13128h = -9223372036854775807L;

    /* loaded from: classes2.dex */
    public interface b {
        void a(IOException iOException);

        void onInitialized();
    }

    /* loaded from: classes2.dex */
    private static final class c implements Loader.b {

        /* renamed from: a, reason: collision with root package name */
        private final b f13129a;

        public c(b bVar) {
            this.f13129a = bVar;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        public Loader.c k(Loader.d dVar, long j11, long j12, IOException iOException, int i11) {
            b bVar = this.f13129a;
            if (bVar != null) {
                bVar.a(iOException);
            }
            return Loader.f13031f;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        public /* synthetic */ void o(Loader.d dVar, long j11, long j12, int i11) {
            o.a(this, dVar, j11, j12, i11);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        public void p(Loader.d dVar, long j11, long j12) {
            if (this.f13129a != null) {
                if (d.m()) {
                    this.f13129a.onInitialized();
                } else {
                    this.f13129a.a(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.b
        public void q(Loader.d dVar, long j11, long j12, boolean z10) {
        }
    }

    /* renamed from: androidx.media3.exoplayer.util.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0112d implements Loader.d {
        private C0112d() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void cancelLoad() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void load() {
            synchronized (d.f13121a) {
                synchronized (d.f13122b) {
                    if (d.f13123c) {
                        return;
                    }
                    long e11 = d.e();
                    synchronized (d.f13122b) {
                        long unused = d.f13128h = SystemClock.elapsedRealtime();
                        long unused2 = d.f13124d = e11;
                        boolean unused3 = d.f13123c = true;
                    }
                }
            }
        }
    }

    static /* synthetic */ long e() {
        return n();
    }

    private static void h(byte b11, byte b12, int i11, long j11) {
        if (b11 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b12 != 4 && b12 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b12));
        }
        if (i11 != 0 && i11 <= 15) {
            if (j11 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i11);
        }
    }

    public static long i() {
        long j11;
        synchronized (f13122b) {
            try {
                j11 = f13123c ? f13124d : C.TIME_UNSET;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j11;
    }

    public static String j() {
        String str;
        synchronized (f13122b) {
            str = f13125e;
        }
        return str;
    }

    public static int k() {
        int i11;
        synchronized (f13122b) {
            i11 = f13126f;
        }
        return i11;
    }

    public static void l(Loader loader, b bVar) {
        if (m()) {
            if (bVar != null) {
                bVar.onInitialized();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.m(new C0112d(), new c(bVar), 1);
        }
    }

    public static boolean m() {
        boolean z10;
        synchronized (f13122b) {
            try {
                if (f13128h != C.TIME_UNSET && f13127g != C.TIME_UNSET) {
                    f13123c = f13123c && SystemClock.elapsedRealtime() - f13128h < f13127g;
                }
                z10 = f13123c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    private static long n() {
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(k());
            InetAddress[] allByName = InetAddress.getAllByName(j());
            int length = allByName.length;
            SocketTimeoutException socketTimeoutException = null;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, allByName[i11], Sdk$SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
                bArr[0] = 27;
                long currentTimeMillis = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                q(bArr, 40, currentTimeMillis);
                datagramSocket.send(datagramPacket);
                try {
                    datagramSocket.receive(new DatagramPacket(bArr, 48));
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j11 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
                    byte b11 = bArr[0];
                    int i13 = bArr[1] & 255;
                    long p11 = p(bArr, 24);
                    long p12 = p(bArr, 32);
                    long p13 = p(bArr, 40);
                    h((byte) ((b11 >> 6) & 3), (byte) (b11 & 7), i13, p13);
                    long j12 = (j11 + (((p12 - p11) + (p13 - j11)) / 2)) - elapsedRealtime2;
                    datagramSocket.close();
                    return j12;
                } catch (SocketTimeoutException e11) {
                    if (socketTimeoutException == null) {
                        socketTimeoutException = e11;
                    } else {
                        socketTimeoutException.addSuppressed(e11);
                    }
                    int i14 = i12 + 1;
                    if (i12 >= 10) {
                        break;
                    }
                    i11++;
                    i12 = i14;
                }
            }
            throw ((SocketTimeoutException) androidx.media3.common.util.a.e(socketTimeoutException));
        } finally {
        }
    }

    private static long o(byte[] bArr, int i11) {
        int i12 = bArr[i11];
        int i13 = bArr[i11 + 1];
        int i14 = bArr[i11 + 2];
        int i15 = bArr[i11 + 3];
        if ((i12 & 128) == 128) {
            i12 = (i12 & 127) + 128;
        }
        if ((i13 & 128) == 128) {
            i13 = (i13 & 127) + 128;
        }
        if ((i14 & 128) == 128) {
            i14 = (i14 & 127) + 128;
        }
        if ((i15 & 128) == 128) {
            i15 = (i15 & 127) + 128;
        }
        return (i12 << 24) + (i13 << 16) + (i14 << 8) + i15;
    }

    private static long p(byte[] bArr, int i11) {
        long o11 = o(bArr, i11);
        long o12 = o(bArr, i11 + 4);
        if (o11 == 0 && o12 == 0) {
            return 0L;
        }
        return ((o11 - 2208988800L) * 1000) + ((o12 * 1000) / TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE);
    }

    private static void q(byte[] bArr, int i11, long j11) {
        if (j11 == 0) {
            Arrays.fill(bArr, i11, i11 + 8, (byte) 0);
            return;
        }
        long j12 = j11 / 1000;
        long j13 = j11 - (j12 * 1000);
        bArr[i11] = (byte) (r2 >> 24);
        bArr[i11 + 1] = (byte) (r2 >> 16);
        bArr[i11 + 2] = (byte) (r2 >> 8);
        bArr[i11 + 3] = (byte) (j12 + 2208988800L);
        long j14 = (j13 * TmcConstants.TEMP_FILE_RUNTIME_MAX_SIZE) / 1000;
        bArr[i11 + 4] = (byte) (j14 >> 24);
        bArr[i11 + 5] = (byte) (j14 >> 16);
        bArr[i11 + 6] = (byte) (j14 >> 8);
        bArr[i11 + 7] = (byte) (Math.random() * 255.0d);
    }
}
