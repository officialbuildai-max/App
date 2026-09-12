package com.tencent.tinker.android.dex;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.UTFDataFormatException;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* loaded from: classes5.dex */
public abstract class r {
    public static long a(String str, boolean z10) {
        int length = str.length();
        long j11 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            j11 += (charAt == 0 || charAt > 127) ? charAt <= 2047 ? 2L : 3L : 1L;
            if (z10 && j11 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        return j11;
    }

    public static String b(gf.a aVar, char[] cArr) {
        int i11;
        int i12 = 0;
        while (true) {
            char readByte = (char) (aVar.readByte() & 255);
            if (readByte == 0) {
                return new String(cArr, 0, i12);
            }
            cArr[i12] = readByte;
            if (readByte < 128) {
                i12++;
            } else {
                if ((readByte & 224) == 192) {
                    byte readByte2 = aVar.readByte();
                    if ((readByte2 & 192) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i11 = i12 + 1;
                    cArr[i12] = (char) (((readByte & 31) << 6) | (readByte2 & Utf8.REPLACEMENT_BYTE));
                } else {
                    if ((readByte & 240) != 224) {
                        throw new UTFDataFormatException("bad byte");
                    }
                    byte readByte3 = aVar.readByte();
                    byte readByte4 = aVar.readByte();
                    if ((readByte3 & 192) != 128 || (readByte4 & 192) != 128) {
                        break;
                    }
                    i11 = i12 + 1;
                    cArr[i12] = (char) (((readByte & 15) << 12) | ((readByte3 & Utf8.REPLACEMENT_BYTE) << 6) | (readByte4 & Utf8.REPLACEMENT_BYTE));
                }
                i12 = i11;
            }
        }
        throw new UTFDataFormatException("bad second or third byte");
    }

    public static void c(byte[] bArr, int i11, String str) {
        int length = str.length();
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt != 0 && charAt <= 127) {
                bArr[i11] = (byte) charAt;
                i11++;
            } else if (charAt <= 2047) {
                int i13 = i11 + 1;
                bArr[i11] = (byte) (((charAt >> 6) & 31) | PsExtractor.AUDIO_STREAM);
                i11 += 2;
                bArr[i13] = (byte) ((charAt & '?') | 128);
            } else {
                bArr[i11] = (byte) (((charAt >> '\f') & 15) | 224);
                int i14 = i11 + 2;
                bArr[i11 + 1] = (byte) (((charAt >> 6) & 63) | 128);
                i11 += 3;
                bArr[i14] = (byte) ((charAt & '?') | 128);
            }
        }
    }

    public static byte[] d(String str) {
        byte[] bArr = new byte[(int) a(str, false)];
        c(bArr, 0, str);
        return bArr;
    }
}
