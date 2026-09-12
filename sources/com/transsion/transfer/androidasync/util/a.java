package com.transsion.transfer.androidasync.util;

import com.transsion.transfer.androidasync.ByteBufferList;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    int f55686b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f55687c = 4096;

    /* renamed from: a, reason: collision with root package name */
    final int f55685a = ByteBufferList.f55288f;

    public ByteBuffer a() {
        return b(this.f55686b);
    }

    public ByteBuffer b(int i11) {
        return ByteBufferList.t(Math.min(Math.max(i11, this.f55687c), this.f55685a));
    }

    public int c() {
        return this.f55687c;
    }

    public a d(int i11) {
        this.f55687c = Math.max(0, i11);
        return this;
    }

    public void e(long j11) {
        this.f55686b = ((int) j11) * 2;
    }
}
