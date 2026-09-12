package org.apache.commons.compress.archivers.zip;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import okio.Utf8;

/* loaded from: classes7.dex */
class e implements r {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f71265c = {Utf8.REPLACEMENT_BYTE};

    /* renamed from: d, reason: collision with root package name */
    private static final String f71266d = String.valueOf('?');

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f71267e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    private final Charset f71268a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f71269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Charset charset, boolean z10) {
        this.f71268a = charset;
        this.f71269b = z10;
    }

    private CharsetDecoder b() {
        if (this.f71269b) {
            CharsetDecoder newDecoder = this.f71268a.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return newDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(f71266d);
        }
        CharsetDecoder newDecoder2 = this.f71268a.newDecoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return newDecoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }

    @Override // org.apache.commons.compress.archivers.zip.r
    public String a(byte[] bArr) {
        return b().decode(ByteBuffer.wrap(bArr)).toString();
    }
}
