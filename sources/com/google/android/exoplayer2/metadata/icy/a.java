package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.common.base.c;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class a extends g {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f25486c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f25487a = c.f30282c.newDecoder();

    /* renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f25488b = c.f30281b.newDecoder();

    private String c(ByteBuffer byteBuffer) {
        try {
            return this.f25487a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = this.f25488b.decode(byteBuffer).toString();
                this.f25488b.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (CharacterCodingException unused2) {
                this.f25488b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th2) {
                this.f25488b.reset();
                byteBuffer.rewind();
                throw th2;
            }
        } finally {
            this.f25487a.reset();
            byteBuffer.rewind();
        }
    }

    @Override // com.google.android.exoplayer2.metadata.g
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        String c11 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c11 == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f25486c.matcher(c11);
        String str2 = null;
        for (int i11 = 0; matcher.find(i11); i11 = matcher.end()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group != null) {
                String e11 = com.google.common.base.a.e(group);
                e11.hashCode();
                if (e11.equals("streamurl")) {
                    str2 = group2;
                } else if (e11.equals("streamtitle")) {
                    str = group2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
