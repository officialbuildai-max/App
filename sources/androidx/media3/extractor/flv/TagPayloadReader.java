package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.j0;
import l2.s0;

/* loaded from: classes2.dex */
abstract class TagPayloadReader {

    /* renamed from: a, reason: collision with root package name */
    protected final s0 f13483a;

    /* loaded from: classes2.dex */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TagPayloadReader(s0 s0Var) {
        this.f13483a = s0Var;
    }

    public final boolean a(j0 j0Var, long j11) {
        return b(j0Var) && c(j0Var, j11);
    }

    protected abstract boolean b(j0 j0Var);

    protected abstract boolean c(j0 j0Var, long j11);
}
