package androidx.media3.datasource.cronet;

import java.nio.ByteBuffer;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* loaded from: classes2.dex */
final class a extends UploadDataProvider {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f10994a;

    /* renamed from: b, reason: collision with root package name */
    private int f10995b;

    public a(byte[] bArr) {
        this.f10994a = bArr;
    }

    @Override // org.chromium.net.UploadDataProvider
    public long getLength() {
        return this.f10994a.length;
    }

    @Override // org.chromium.net.UploadDataProvider
    public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
        int min = Math.min(byteBuffer.remaining(), this.f10994a.length - this.f10995b);
        byteBuffer.put(this.f10994a, this.f10995b, min);
        this.f10995b += min;
        uploadDataSink.onReadSucceeded(false);
    }

    @Override // org.chromium.net.UploadDataProvider
    public void rewind(UploadDataSink uploadDataSink) {
        this.f10995b = 0;
        uploadDataSink.onRewindSucceeded();
    }
}
