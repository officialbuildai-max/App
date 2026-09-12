package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class v implements bv.d {

    /* renamed from: a, reason: collision with root package name */
    Charset f55692a;

    /* renamed from: b, reason: collision with root package name */
    ByteBufferList f55693b;

    /* renamed from: c, reason: collision with root package name */
    a f55694c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str);
    }

    public v() {
        this(null);
    }

    public v(Charset charset) {
        this.f55693b = new ByteBufferList();
        this.f55692a = charset;
    }

    @Override // bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBufferList.C());
        while (byteBufferList.C() > 0) {
            byte e11 = byteBufferList.e();
            if (e11 == 10) {
                allocate.flip();
                this.f55693b.a(allocate);
                this.f55694c.a(this.f55693b.z(this.f55692a));
                this.f55693b = new ByteBufferList();
                return;
            }
            allocate.put(e11);
        }
        allocate.flip();
        this.f55693b.a(allocate);
    }

    public void a(a aVar) {
        this.f55694c = aVar;
    }
}
