package com.transsion.transfer.androidasync;

import android.os.Looper;
import com.transsion.transfer.androidasync.util.ArrayDeque;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/* loaded from: classes6.dex */
public class ByteBufferList {

    /* renamed from: d, reason: collision with root package name */
    static PriorityQueue f55286d = new PriorityQueue(8, new Reclaimer());

    /* renamed from: e, reason: collision with root package name */
    private static int f55287e = 1048576;

    /* renamed from: f, reason: collision with root package name */
    public static int f55288f = 262144;

    /* renamed from: g, reason: collision with root package name */
    static int f55289g = 0;

    /* renamed from: h, reason: collision with root package name */
    static int f55290h = 0;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f55291i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static final ByteBuffer f55292j = ByteBuffer.allocate(0);

    /* renamed from: a, reason: collision with root package name */
    ArrayDeque f55293a = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    ByteOrder f55294b = ByteOrder.BIG_ENDIAN;

    /* renamed from: c, reason: collision with root package name */
    private int f55295c = 0;

    /* loaded from: classes6.dex */
    static class Reclaimer implements Comparator<ByteBuffer> {
        Reclaimer() {
        }

        @Override // java.util.Comparator
        public int compare(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            return byteBuffer.capacity() > byteBuffer2.capacity() ? 1 : -1;
        }
    }

    public ByteBufferList() {
    }

    public ByteBufferList(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }

    public ByteBufferList(ByteBuffer... byteBufferArr) {
        b(byteBufferArr);
    }

    public static void A(ByteBuffer byteBuffer) {
        PriorityQueue p11;
        if (byteBuffer == null || byteBuffer.isDirect() || byteBuffer.arrayOffset() != 0 || byteBuffer.array().length != byteBuffer.capacity() || byteBuffer.capacity() < 8192 || byteBuffer.capacity() > f55288f || (p11 = p()) == null) {
            return;
        }
        synchronized (f55291i) {
            while (f55289g > f55287e && p11.size() > 0 && ((ByteBuffer) p11.peek()).capacity() < byteBuffer.capacity()) {
                try {
                    f55289g -= ((ByteBuffer) p11.remove()).capacity();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (f55289g > f55287e) {
                return;
            }
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            f55289g += byteBuffer.capacity();
            p11.add(byteBuffer);
            f55290h = Math.max(f55290h, byteBuffer.capacity());
        }
    }

    private void d(int i11) {
        if (C() >= 0) {
            this.f55295c += i11;
        }
    }

    private static PriorityQueue p() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || Thread.currentThread() != mainLooper.getThread()) {
            return f55286d;
        }
        return null;
    }

    public static ByteBuffer t(int i11) {
        PriorityQueue p11;
        if (i11 <= f55290h && (p11 = p()) != null) {
            synchronized (f55291i) {
                while (p11.size() > 0) {
                    try {
                        ByteBuffer byteBuffer = (ByteBuffer) p11.remove();
                        if (p11.size() == 0) {
                            f55290h = 0;
                        }
                        f55289g -= byteBuffer.capacity();
                        if (byteBuffer.capacity() >= i11) {
                            return byteBuffer;
                        }
                    } finally {
                    }
                }
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i11));
    }

    private ByteBuffer x(int i11) {
        ByteBuffer byteBuffer;
        if (C() < i11) {
            throw new IllegalArgumentException("count : " + C() + "/" + i11);
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) this.f55293a.peek();
        while (byteBuffer2 != null && !byteBuffer2.hasRemaining()) {
            A((ByteBuffer) this.f55293a.remove());
            byteBuffer2 = (ByteBuffer) this.f55293a.peek();
        }
        if (byteBuffer2 == null) {
            return f55292j;
        }
        if (byteBuffer2.remaining() >= i11) {
            return byteBuffer2.order(this.f55294b);
        }
        ByteBuffer t11 = t(i11);
        t11.limit(i11);
        byte[] array = t11.array();
        int i12 = 0;
        loop1: while (true) {
            byteBuffer = null;
            while (i12 < i11) {
                byteBuffer = (ByteBuffer) this.f55293a.remove();
                int min = Math.min(i11 - i12, byteBuffer.remaining());
                byteBuffer.get(array, i12, min);
                i12 += min;
                if (byteBuffer.remaining() == 0) {
                    break;
                }
            }
            A(byteBuffer);
        }
        if (byteBuffer != null && byteBuffer.remaining() > 0) {
            this.f55293a.addFirst(byteBuffer);
        }
        this.f55293a.addFirst(t11);
        return t11.order(this.f55294b);
    }

    public void B() {
        while (this.f55293a.size() > 0) {
            A((ByteBuffer) this.f55293a.remove());
        }
        this.f55295c = 0;
    }

    public int C() {
        return this.f55295c;
    }

    public ByteBuffer D() {
        ByteBuffer byteBuffer = (ByteBuffer) this.f55293a.remove();
        this.f55295c -= byteBuffer.remaining();
        return byteBuffer;
    }

    public int E() {
        return this.f55293a.size();
    }

    public void F() {
        x(0);
    }

    public ByteBufferList a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            A(byteBuffer);
            return this;
        }
        d(byteBuffer.remaining());
        if (this.f55293a.size() > 0) {
            ByteBuffer byteBuffer2 = (ByteBuffer) this.f55293a.getLast();
            if (byteBuffer2.capacity() - byteBuffer2.limit() >= byteBuffer.remaining()) {
                byteBuffer2.mark();
                byteBuffer2.position(byteBuffer2.limit());
                byteBuffer2.limit(byteBuffer2.capacity());
                byteBuffer2.put(byteBuffer);
                byteBuffer2.limit(byteBuffer2.position());
                byteBuffer2.reset();
                A(byteBuffer);
                F();
                return this;
            }
        }
        this.f55293a.add(byteBuffer);
        F();
        return this;
    }

    public ByteBufferList b(ByteBuffer... byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            a(byteBuffer);
        }
        return this;
    }

    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            A(byteBuffer);
            return;
        }
        d(byteBuffer.remaining());
        if (this.f55293a.size() > 0) {
            ByteBuffer byteBuffer2 = (ByteBuffer) this.f55293a.getFirst();
            if (byteBuffer2.position() >= byteBuffer.remaining()) {
                byteBuffer2.position(byteBuffer2.position() - byteBuffer.remaining());
                byteBuffer2.mark();
                byteBuffer2.put(byteBuffer);
                byteBuffer2.reset();
                A(byteBuffer);
                return;
            }
        }
        this.f55293a.addFirst(byteBuffer);
    }

    public byte e() {
        byte b11 = x(1).get();
        this.f55295c--;
        return b11;
    }

    public void f(ByteBufferList byteBufferList) {
        g(byteBufferList, C());
    }

    public void g(ByteBufferList byteBufferList, int i11) {
        if (C() < i11) {
            throw new IllegalArgumentException("length");
        }
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            ByteBuffer byteBuffer = (ByteBuffer) this.f55293a.remove();
            int remaining = byteBuffer.remaining();
            if (remaining == 0) {
                A(byteBuffer);
            } else {
                int i13 = remaining + i12;
                if (i13 > i11) {
                    int i14 = i11 - i12;
                    ByteBuffer t11 = t(i14);
                    t11.limit(i14);
                    byteBuffer.get(t11.array(), 0, i14);
                    byteBufferList.a(t11);
                    this.f55293a.addFirst(byteBuffer);
                    break;
                }
                byteBufferList.a(byteBuffer);
                i12 = i13;
            }
        }
        this.f55295c -= i11;
    }

    public void h(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    public void i(byte[] bArr, int i11, int i12) {
        if (C() < i12) {
            throw new IllegalArgumentException("length");
        }
        int i13 = i12;
        while (i13 > 0) {
            ByteBuffer byteBuffer = (ByteBuffer) this.f55293a.peek();
            int min = Math.min(byteBuffer.remaining(), i13);
            if (bArr != null) {
                byteBuffer.get(bArr, i11, min);
            } else {
                byteBuffer.position(byteBuffer.position() + min);
            }
            i13 -= min;
            i11 += min;
            if (byteBuffer.remaining() == 0) {
                A(byteBuffer);
            }
        }
        this.f55295c -= i12;
    }

    public ByteBuffer j() {
        if (C() == 0) {
            return f55292j;
        }
        x(C());
        return D();
    }

    public ByteBuffer[] k() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.f55293a.toArray(new ByteBuffer[this.f55293a.size()]);
        this.f55293a.clear();
        this.f55295c = 0;
        return byteBufferArr;
    }

    public byte[] l() {
        byte[] bArr = new byte[C()];
        h(bArr);
        return bArr;
    }

    public char m() {
        char c11 = (char) x(1).get();
        this.f55295c--;
        return c11;
    }

    public int n() {
        int i11 = x(4).getInt();
        this.f55295c -= 4;
        return i11;
    }

    public long o() {
        long j11 = x(8).getLong();
        this.f55295c -= 8;
        return j11;
    }

    public short q() {
        short s11 = x(2).getShort();
        this.f55295c -= 2;
        return s11;
    }

    public boolean r() {
        return C() > 0;
    }

    public boolean s() {
        return this.f55295c == 0;
    }

    public ByteBufferList u(ByteOrder byteOrder) {
        this.f55294b = byteOrder;
        return this;
    }

    public String v() {
        return w(null);
    }

    public String w(Charset charset) {
        byte[] array;
        int remaining;
        int i11;
        if (charset == null) {
            charset = com.transsion.transfer.androidasync.util.c.f55689b;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f55293a.iterator();
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            if (byteBuffer.isDirect()) {
                array = new byte[byteBuffer.remaining()];
                remaining = byteBuffer.remaining();
                byteBuffer.get(array);
                i11 = 0;
            } else {
                array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                remaining = byteBuffer.remaining();
                i11 = arrayOffset;
            }
            sb2.append(new String(array, i11, remaining, charset));
        }
        return sb2.toString();
    }

    public String y() {
        return z(null);
    }

    public String z(Charset charset) {
        String w11 = w(charset);
        B();
        return w11;
    }
}
