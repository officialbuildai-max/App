package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: classes6.dex */
class z extends o {

    /* renamed from: b, reason: collision with root package name */
    SocketChannel f55725b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SocketChannel socketChannel) {
        super(socketChannel);
        this.f55725b = socketChannel;
    }

    @Override // com.transsion.transfer.androidasync.o
    public boolean h() {
        return this.f55725b.isConnected();
    }

    @Override // com.transsion.transfer.androidasync.o
    public SelectionKey i(Selector selector) {
        return k(selector, 8);
    }

    @Override // com.transsion.transfer.androidasync.o
    public void l() {
        try {
            this.f55725b.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    @Override // com.transsion.transfer.androidasync.o
    public int m(ByteBuffer[] byteBufferArr) {
        return (int) this.f55725b.write(byteBufferArr);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        return this.f55725b.read(byteBuffer);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) {
        return this.f55725b.read(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i11, int i12) {
        return this.f55725b.read(byteBufferArr, i11, i12);
    }
}
