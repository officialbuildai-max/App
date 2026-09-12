package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.d0;
import g9.e0;

/* loaded from: classes3.dex */
abstract class TagPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    protected final e0 f25095a;

    /* loaded from: classes3.dex */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TagPayloadReader(e0 e0Var) {
        this.f25095a = e0Var;
    }

    public final boolean a(d0 d0Var, long j11) {
        return b(d0Var) && c(d0Var, j11);
    }

    protected abstract boolean b(d0 d0Var);

    protected abstract boolean c(d0 d0Var, long j11);
}
