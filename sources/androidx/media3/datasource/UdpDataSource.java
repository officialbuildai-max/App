package androidx.media3.datasource;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import w1.h;

/* loaded from: classes2.dex */
public final class UdpDataSource extends w1.a {

    /* renamed from: e, reason: collision with root package name */
    private final int f10791e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f10792f;

    /* renamed from: g, reason: collision with root package name */
    private final DatagramPacket f10793g;

    /* renamed from: h, reason: collision with root package name */
    private Uri f10794h;

    /* renamed from: i, reason: collision with root package name */
    private DatagramSocket f10795i;

    /* renamed from: j, reason: collision with root package name */
    private MulticastSocket f10796j;

    /* renamed from: k, reason: collision with root package name */
    private InetAddress f10797k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10798l;

    /* renamed from: m, reason: collision with root package name */
    private int f10799m;

    /* loaded from: classes2.dex */
    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public UdpDataSource(int i11) {
        this(i11, 8000);
    }

    public UdpDataSource(int i11, int i12) {
        super(true);
        this.f10791e = i12;
        byte[] bArr = new byte[i11];
        this.f10792f = bArr;
        this.f10793g = new DatagramPacket(bArr, 0, i11);
    }

    @Override // androidx.media3.datasource.a
    public long a(h hVar) {
        Uri uri = hVar.f77634a;
        this.f10794h = uri;
        String str = (String) androidx.media3.common.util.a.e(uri.getHost());
        int port = this.f10794h.getPort();
        f(hVar);
        try {
            this.f10797k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f10797k, port);
            if (this.f10797k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f10796j = multicastSocket;
                multicastSocket.joinGroup(this.f10797k);
                this.f10795i = this.f10796j;
            } else {
                this.f10795i = new DatagramSocket(inetSocketAddress);
            }
            this.f10795i.setSoTimeout(this.f10791e);
            this.f10798l = true;
            g(hVar);
            return -1L;
        } catch (IOException e11) {
            throw new UdpDataSourceException(e11, 2001);
        } catch (SecurityException e12) {
            throw new UdpDataSourceException(e12, 2006);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f10794h = null;
        MulticastSocket multicastSocket = this.f10796j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) androidx.media3.common.util.a.e(this.f10797k));
            } catch (IOException unused) {
            }
            this.f10796j = null;
        }
        DatagramSocket datagramSocket = this.f10795i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f10795i = null;
        }
        this.f10797k = null;
        this.f10799m = 0;
        if (this.f10798l) {
            this.f10798l = false;
            e();
        }
    }

    @Override // androidx.media3.datasource.a
    public Uri getUri() {
        return this.f10794h;
    }

    @Override // androidx.media3.common.j
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (this.f10799m == 0) {
            try {
                ((DatagramSocket) androidx.media3.common.util.a.e(this.f10795i)).receive(this.f10793g);
                int length = this.f10793g.getLength();
                this.f10799m = length;
                d(length);
            } catch (SocketTimeoutException e11) {
                throw new UdpDataSourceException(e11, 2002);
            } catch (IOException e12) {
                throw new UdpDataSourceException(e12, 2001);
            }
        }
        int length2 = this.f10793g.getLength();
        int i13 = this.f10799m;
        int min = Math.min(i13, i12);
        System.arraycopy(this.f10792f, length2 - i13, bArr, i11, min);
        this.f10799m -= min;
        return min;
    }
}
