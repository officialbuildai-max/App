package com.transsion.transfer.androidasync;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* loaded from: classes6.dex */
class y extends o {

    /* renamed from: b, reason: collision with root package name */
    ServerSocketChannel f55724b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ServerSocketChannel serverSocketChannel) {
        super(serverSocketChannel);
        this.f55724b = serverSocketChannel;
    }

    @Override // com.transsion.transfer.androidasync.o
    public boolean h() {
        return false;
    }

    @Override // com.transsion.transfer.androidasync.o
    public SelectionKey i(Selector selector) {
        return this.f55724b.register(selector, 16);
    }

    @Override // com.transsion.transfer.androidasync.o
    public void l() {
    }

    @Override // com.transsion.transfer.androidasync.o
    public int m(ByteBuffer[] byteBufferArr) {
        throw new IOException("Can't write ServerSocketChannel");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i11, int i12) {
        throw new IOException("Can't read ServerSocketChannel");
    }
}
