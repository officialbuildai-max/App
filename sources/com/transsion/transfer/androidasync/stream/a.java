package com.transsion.transfer.androidasync.stream;

import bv.d;
import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.p;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public abstract class a implements d, bv.a {

    /* renamed from: a, reason: collision with root package name */
    private OutputStream f55672a;

    public a(OutputStream outputStream) {
        this.f55672a = outputStream;
    }

    @Override // bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        while (byteBufferList.E() > 0) {
            try {
                try {
                    ByteBuffer D = byteBufferList.D();
                    this.f55672a.write(D.array(), D.arrayOffset() + D.position(), D.remaining());
                    ByteBufferList.A(D);
                } catch (Exception e11) {
                    g(e11);
                }
            } finally {
                byteBufferList.B();
            }
        }
    }

    @Override // bv.a
    public void g(Exception exc) {
        exc.printStackTrace();
    }
}
