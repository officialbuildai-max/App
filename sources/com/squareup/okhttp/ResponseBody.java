package com.squareup.okhttp;

import com.squareup.okhttp.internal.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes5.dex */
public abstract class ResponseBody implements Closeable {
    private Reader reader;

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(g.f40486c) : g.f40486c;
    }

    public static ResponseBody create(final MediaType mediaType, final long j11, final BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            return new ResponseBody() { // from class: com.squareup.okhttp.ResponseBody.1
                @Override // com.squareup.okhttp.ResponseBody
                public long contentLength() {
                    return j11;
                }

                @Override // com.squareup.okhttp.ResponseBody
                public MediaType contentType() {
                    return MediaType.this;
                }

                @Override // com.squareup.okhttp.ResponseBody
                public BufferedSource source() {
                    return bufferedSource;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = g.f40486c;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        Buffer writeString = new Buffer().writeString(str, charset);
        return create(mediaType, writeString.size(), writeString);
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new Buffer().write(bArr));
    }

    public final InputStream byteStream() throws IOException {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        BufferedSource source = source();
        try {
            byte[] readByteArray = source.readByteArray();
            g.c(source);
            if (contentLength == -1 || contentLength == readByteArray.length) {
                return readByteArray;
            }
            throw new IOException("Content-Length and stream length disagree");
        } catch (Throwable th2) {
            g.c(source);
            throw th2;
        }
    }

    public final Reader charStream() throws IOException {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(byteStream(), charset());
        this.reader = inputStreamReader;
        return inputStreamReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        source().close();
    }

    public abstract long contentLength() throws IOException;

    public abstract MediaType contentType();

    public abstract BufferedSource source() throws IOException;

    public final String string() throws IOException {
        return new String(bytes(), charset().name());
    }
}
