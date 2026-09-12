package com.google.common.hash;

import com.google.common.base.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
abstract class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f30931a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30932b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30933c;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i11) {
        this(i11, i11);
    }

    protected c(int i11, int i12) {
        m.d(i12 % i11 == 0);
        this.f30931a = ByteBuffer.allocate(i12 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f30932b = i12;
        this.f30933c = i11;
    }

    private void l() {
        g.a(this.f30931a);
        while (this.f30931a.remaining() >= this.f30933c) {
            n(this.f30931a);
        }
        this.f30931a.compact();
    }

    private void m() {
        if (this.f30931a.remaining() < 8) {
            l();
        }
    }

    private e p(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f30931a.remaining()) {
            this.f30931a.put(byteBuffer);
            m();
            return this;
        }
        int position = this.f30932b - this.f30931a.position();
        for (int i11 = 0; i11 < position; i11++) {
            this.f30931a.put(byteBuffer.get());
        }
        l();
        while (byteBuffer.remaining() >= this.f30933c) {
            n(byteBuffer);
        }
        this.f30931a.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.e
    public final HashCode b() {
        l();
        g.a(this.f30931a);
        if (this.f30931a.remaining() > 0) {
            o(this.f30931a);
            ByteBuffer byteBuffer = this.f30931a;
            g.b(byteBuffer, byteBuffer.limit());
        }
        return k();
    }

    @Override // com.google.common.hash.b, com.google.common.hash.e
    public final e d(byte[] bArr, int i11, int i12) {
        return p(ByteBuffer.wrap(bArr, i11, i12).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.e
    public final e e(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return p(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }

    @Override // com.google.common.hash.e
    public final e f(int i11) {
        this.f30931a.putInt(i11);
        m();
        return this;
    }

    @Override // com.google.common.hash.e
    public final e h(long j11) {
        this.f30931a.putLong(j11);
        m();
        return this;
    }

    @Override // com.google.common.hash.b
    public final e j(char c11) {
        this.f30931a.putChar(c11);
        m();
        return this;
    }

    protected abstract HashCode k();

    protected abstract void n(ByteBuffer byteBuffer);

    protected abstract void o(ByteBuffer byteBuffer);
}
