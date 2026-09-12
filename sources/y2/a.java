package y2;

import androidx.media3.common.x;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class a extends u2.c {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f78934c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f78935a = StandardCharsets.UTF_8.newDecoder();

    /* renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f78936b = StandardCharsets.ISO_8859_1.newDecoder();

    private String c(ByteBuffer byteBuffer) {
        try {
            return this.f78935a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String charBuffer = this.f78936b.decode(byteBuffer).toString();
                this.f78936b.reset();
                byteBuffer.rewind();
                return charBuffer;
            } catch (CharacterCodingException unused2) {
                this.f78936b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th2) {
                this.f78936b.reset();
                byteBuffer.rewind();
                throw th2;
            }
        } finally {
            this.f78935a.reset();
            byteBuffer.rewind();
        }
    }

    @Override // u2.c
    protected x b(u2.b bVar, ByteBuffer byteBuffer) {
        String c11 = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (c11 == null) {
            return new x(new c(bArr, null, null));
        }
        Matcher matcher = f78934c.matcher(c11);
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
        return new x(new c(bArr, str, str2));
    }
}
