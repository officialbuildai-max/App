package com.transsion.transfer.androidasync;

/* loaded from: classes6.dex */
public abstract class u extends n {
    public u(s sVar) {
        super(sVar);
        q(0);
    }

    @Override // com.transsion.transfer.androidasync.n
    protected void j(ByteBufferList byteBufferList) {
        ByteBufferList s11 = s(byteBufferList);
        if (s11 != byteBufferList) {
            byteBufferList.B();
            s11.f(byteBufferList);
        }
    }

    public abstract ByteBufferList s(ByteBufferList byteBufferList);
}
