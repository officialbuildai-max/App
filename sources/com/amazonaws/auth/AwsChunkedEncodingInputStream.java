package com.amazonaws.auth;

import android.support.v4.media.session.PlaybackStateCompat;
import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class AwsChunkedEncodingInputStream extends SdkInputStream {

    /* renamed from: m, reason: collision with root package name */
    private static final byte[] f18418m = new byte[0];

    /* renamed from: n, reason: collision with root package name */
    private static final Log f18419n = LogFactory.b(AwsChunkedEncodingInputStream.class);

    /* renamed from: a, reason: collision with root package name */
    private InputStream f18420a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18421b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f18422c;

    /* renamed from: d, reason: collision with root package name */
    private final String f18423d;

    /* renamed from: e, reason: collision with root package name */
    private final String f18424e;

    /* renamed from: f, reason: collision with root package name */
    private final String f18425f;

    /* renamed from: g, reason: collision with root package name */
    private String f18426g;

    /* renamed from: h, reason: collision with root package name */
    private final AWS4Signer f18427h;

    /* renamed from: i, reason: collision with root package name */
    private ChunkContentIterator f18428i;

    /* renamed from: j, reason: collision with root package name */
    private DecodedStreamBuffer f18429j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f18430k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f18431l;

    public AwsChunkedEncodingInputStream(InputStream inputStream, int i11, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this.f18420a = null;
        this.f18430k = true;
        this.f18431l = false;
        if (inputStream instanceof AwsChunkedEncodingInputStream) {
            AwsChunkedEncodingInputStream awsChunkedEncodingInputStream = (AwsChunkedEncodingInputStream) inputStream;
            i11 = Math.max(awsChunkedEncodingInputStream.f18421b, i11);
            this.f18420a = awsChunkedEncodingInputStream.f18420a;
            this.f18429j = awsChunkedEncodingInputStream.f18429j;
        } else {
            this.f18420a = inputStream;
            this.f18429j = null;
        }
        if (i11 < 131072) {
            throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
        }
        this.f18421b = i11;
        this.f18422c = bArr;
        this.f18423d = str;
        this.f18424e = str2;
        this.f18425f = str3;
        this.f18426g = str3;
        this.f18427h = aWS4Signer;
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this(inputStream, 262144, bArr, str, str2, str3, aWS4Signer);
    }

    private static long m(long j11) {
        return Long.toHexString(j11).length() + 83 + j11 + 2;
    }

    public static long n(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("Nonnegative content length expected.");
        }
        long j12 = j11 / PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        long j13 = j11 % PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        return (j12 * m(PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) + (j13 > 0 ? m(j13) : 0L) + m(0L);
    }

    private byte[] o(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(bArr.length));
        String d11 = BinaryUtils.d(this.f18427h.r("AWS4-HMAC-SHA256-PAYLOAD\n" + this.f18423d + "\n" + this.f18424e + "\n" + this.f18426g + "\n" + BinaryUtils.d(this.f18427h.o("")) + "\n" + BinaryUtils.d(this.f18427h.p(bArr)), this.f18422c, SigningAlgorithm.HmacSHA256));
        this.f18426g = d11;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(";chunk-signature=");
        sb3.append(d11);
        sb2.append(sb3.toString());
        sb2.append("\r\n");
        try {
            String sb4 = sb2.toString();
            Charset charset = StringUtils.f19086a;
            byte[] bytes = sb4.getBytes(charset);
            byte[] bytes2 = "\r\n".getBytes(charset);
            byte[] bArr2 = new byte[bytes.length + bArr.length + bytes2.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length + bArr.length, bytes2.length);
            return bArr2;
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to sign the chunked data. " + e11.getMessage(), e11);
        }
    }

    private boolean p() {
        byte[] bArr = new byte[131072];
        int i11 = 0;
        while (i11 < 131072) {
            DecodedStreamBuffer decodedStreamBuffer = this.f18429j;
            if (decodedStreamBuffer == null || !decodedStreamBuffer.b()) {
                int read = this.f18420a.read(bArr, i11, 131072 - i11);
                if (read == -1) {
                    break;
                }
                DecodedStreamBuffer decodedStreamBuffer2 = this.f18429j;
                if (decodedStreamBuffer2 != null) {
                    decodedStreamBuffer2.a(bArr, i11, read);
                }
                i11 += read;
            } else {
                bArr[i11] = this.f18429j.c();
                i11++;
            }
        }
        if (i11 == 0) {
            this.f18428i = new ChunkContentIterator(o(f18418m));
            return true;
        }
        if (i11 < 131072) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            bArr = bArr2;
        }
        this.f18428i = new ChunkContentIterator(o(bArr));
        return false;
    }

    @Override // com.amazonaws.internal.SdkInputStream
    protected InputStream l() {
        return this.f18420a;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i11) {
        try {
            k();
            if (!this.f18430k) {
                throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
            }
            if (this.f18420a.markSupported()) {
                Log log = f18419n;
                if (log.b()) {
                    log.a("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
                }
                this.f18420a.mark(Integer.MAX_VALUE);
            } else {
                Log log2 = f18419n;
                if (log2.b()) {
                    log2.a("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
                }
                this.f18429j = new DecodedStreamBuffer(this.f18421b);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == -1) {
            return read;
        }
        Log log = f18419n;
        if (log.b()) {
            log.a("One byte read from the stream.");
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        k();
        bArr.getClass();
        if (i11 < 0 || i12 < 0 || i12 > bArr.length - i11) {
            throw new IndexOutOfBoundsException();
        }
        if (i12 == 0) {
            return 0;
        }
        ChunkContentIterator chunkContentIterator = this.f18428i;
        if (chunkContentIterator == null || !chunkContentIterator.a()) {
            if (this.f18431l) {
                return -1;
            }
            this.f18431l = p();
        }
        int b11 = this.f18428i.b(bArr, i11, i12);
        if (b11 > 0) {
            this.f18430k = false;
            Log log = f18419n;
            if (log.b()) {
                log.a(b11 + " byte read from the stream.");
            }
        }
        return b11;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        try {
            k();
            this.f18428i = null;
            this.f18426g = this.f18425f;
            if (this.f18420a.markSupported()) {
                Log log = f18419n;
                if (log.b()) {
                    log.a("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
                }
                this.f18420a.reset();
            } else {
                Log log2 = f18419n;
                if (log2.b()) {
                    log2.a("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
                }
                DecodedStreamBuffer decodedStreamBuffer = this.f18429j;
                if (decodedStreamBuffer == null) {
                    throw new IOException("Cannot reset the stream because the mark is not set.");
                }
                decodedStreamBuffer.d();
            }
            this.f18428i = null;
            this.f18430k = true;
            this.f18431l = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j11) {
        int read;
        if (j11 <= 0) {
            return 0L;
        }
        int min = (int) Math.min(PlaybackStateCompat.ACTION_SET_REPEAT_MODE, j11);
        byte[] bArr = new byte[min];
        long j12 = j11;
        while (j12 > 0 && (read = read(bArr, 0, min)) >= 0) {
            j12 -= read;
        }
        return j11 - j12;
    }
}
