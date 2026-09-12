package com.transsion.transfer.androidasync.http.filter;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.a0;
import com.transsion.transfer.androidasync.p;
import com.transsion.transfer.androidasync.t;

/* loaded from: classes6.dex */
public class ChunkedInputFilter extends t {

    /* renamed from: g, reason: collision with root package name */
    private int f55470g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f55471h = 0;

    /* renamed from: i, reason: collision with root package name */
    private State f55472i = State.CHUNK_LEN;

    /* renamed from: j, reason: collision with root package name */
    ByteBufferList f55473j = new ByteBufferList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum State {
        CHUNK_LEN,
        CHUNK_LEN_CR,
        CHUNK_LEN_CRLF,
        CHUNK,
        CHUNK_CR,
        CHUNK_CRLF,
        COMPLETE,
        ERROR
    }

    /* loaded from: classes6.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f55474a;

        static {
            int[] iArr = new int[State.values().length];
            f55474a = iArr;
            try {
                iArr[State.CHUNK_LEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f55474a[State.CHUNK_LEN_CR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f55474a[State.CHUNK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f55474a[State.CHUNK_CR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f55474a[State.CHUNK_CRLF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f55474a[State.COMPLETE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private boolean O(char c11, char c12) {
        if (c11 == c12) {
            return true;
        }
        this.f55472i = State.ERROR;
        M(new ChunkedDataException(c12 + " was expected, got " + c11));
        return false;
    }

    private boolean P(char c11) {
        return O(c11, '\r');
    }

    private boolean Q(char c11) {
        return O(c11, '\n');
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x001a. Please report as an issue. */
    @Override // com.transsion.transfer.androidasync.t, bv.d
    public void F(p pVar, ByteBufferList byteBufferList) {
        if (this.f55472i == State.ERROR) {
            byteBufferList.B();
            return;
        }
        while (byteBufferList.C() > 0) {
            try {
                switch (a.f55474a[this.f55472i.ordinal()]) {
                    case 1:
                        char m11 = byteBufferList.m();
                        if (m11 == '\r') {
                            this.f55472i = State.CHUNK_LEN_CR;
                        } else {
                            int i11 = this.f55470g * 16;
                            this.f55470g = i11;
                            if (m11 >= 'a' && m11 <= 'f') {
                                this.f55470g = i11 + (m11 - 'W');
                            } else if (m11 >= '0' && m11 <= '9') {
                                this.f55470g = i11 + (m11 - '0');
                            } else {
                                if (m11 < 'A' || m11 > 'F') {
                                    M(new ChunkedDataException("invalid chunk length: " + m11));
                                    return;
                                }
                                this.f55470g = i11 + (m11 - '7');
                            }
                        }
                        this.f55471h = this.f55470g;
                        break;
                    case 2:
                        if (!Q(byteBufferList.m())) {
                            return;
                        } else {
                            this.f55472i = State.CHUNK;
                        }
                    case 3:
                        int min = Math.min(this.f55471h, byteBufferList.C());
                        int i12 = this.f55471h - min;
                        this.f55471h = i12;
                        if (i12 == 0) {
                            this.f55472i = State.CHUNK_CR;
                        }
                        if (min != 0) {
                            byteBufferList.g(this.f55473j, min);
                            a0.a(this, this.f55473j);
                        }
                    case 4:
                        if (!P(byteBufferList.m())) {
                            return;
                        } else {
                            this.f55472i = State.CHUNK_CRLF;
                        }
                    case 5:
                        if (!Q(byteBufferList.m())) {
                            return;
                        }
                        if (this.f55470g > 0) {
                            this.f55472i = State.CHUNK_LEN;
                        } else {
                            this.f55472i = State.COMPLETE;
                            M(null);
                        }
                        this.f55470g = 0;
                    case 6:
                        return;
                }
            } catch (Exception e11) {
                M(e11);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.transfer.androidasync.q
    public void M(Exception exc) {
        if (exc == null && this.f55472i != State.COMPLETE) {
            exc = new ChunkedDataException("chunked input ended before final chunk");
        }
        super.M(exc);
    }
}
