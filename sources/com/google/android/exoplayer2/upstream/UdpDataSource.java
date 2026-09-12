package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* loaded from: classes3.dex */
public final class UdpDataSource extends f {

    /* renamed from: e, reason: collision with root package name */
    private final int f27314e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f27315f;

    /* renamed from: g, reason: collision with root package name */
    private final DatagramPacket f27316g;

    /* renamed from: h, reason: collision with root package name */
    private Uri f27317h;

    /* renamed from: i, reason: collision with root package name */
    private DatagramSocket f27318i;

    /* renamed from: j, reason: collision with root package name */
    private MulticastSocket f27319j;

    /* renamed from: k, reason: collision with root package name */
    private InetAddress f27320k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f27321l;

    /* renamed from: m, reason: collision with root package name */
    private int f27322m;

    /* loaded from: classes3.dex */
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
        this.f27314e = i12;
        byte[] bArr = new byte[i11];
        this.f27315f = bArr;
        this.f27316g = new DatagramPacket(bArr, 0, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) {
        Uri uri = nVar.f27491a;
        this.f27317h = uri;
        String str = (String) com.google.android.exoplayer2.util.a.e(uri.getHost());
        int port = this.f27317h.getPort();
        j(nVar);
        try {
            this.f27320k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f27320k, port);
            if (this.f27320k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f27319j = multicastSocket;
                multicastSocket.joinGroup(this.f27320k);
                this.f27318i = this.f27319j;
            } else {
                this.f27318i = new DatagramSocket(inetSocketAddress);
            }
            this.f27318i.setSoTimeout(this.f27314e);
            this.f27321l = true;
            k(nVar);
            return -1L;
        } catch (IOException e11) {
            throw new UdpDataSourceException(e11, 2001);
        } catch (SecurityException e12) {
            throw new UdpDataSourceException(e12, 2006);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f27317h = null;
        MulticastSocket multicastSocket = this.f27319j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) com.google.android.exoplayer2.util.a.e(this.f27320k));
            } catch (IOException unused) {
            }
            this.f27319j = null;
        }
        DatagramSocket datagramSocket = this.f27318i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f27318i = null;
        }
        this.f27320k = null;
        this.f27322m = 0;
        if (this.f27321l) {
            this.f27321l = false;
            i();
        }
    }

    public int d() {
        DatagramSocket datagramSocket = this.f27318i;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Uri getUri() {
        return this.f27317h;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        if (this.f27322m == 0) {
            try {
                ((DatagramSocket) com.google.android.exoplayer2.util.a.e(this.f27318i)).receive(this.f27316g);
                int length = this.f27316g.getLength();
                this.f27322m = length;
                h(length);
            } catch (SocketTimeoutException e11) {
                throw new UdpDataSourceException(e11, 2002);
            } catch (IOException e12) {
                throw new UdpDataSourceException(e12, 2001);
            }
        }
        int length2 = this.f27316g.getLength();
        int i13 = this.f27322m;
        int min = Math.min(i13, i12);
        System.arraycopy(this.f27315f, length2 - i13, bArr, i11, min);
        this.f27322m -= min;
        return min;
    }
}
