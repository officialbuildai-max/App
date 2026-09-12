package c10;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.chromium.net.UploadDataProvider;
import org.chromium.net.UploadDataSink;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: c10.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C0167a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f17058a;

        C0167a(File file) {
            this.f17058a = file;
        }

        @Override // c10.a.d
        public FileChannel d() {
            return new FileInputStream(this.f17058a).getChannel();
        }
    }

    /* loaded from: classes7.dex */
    class b implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptor f17059a;

        b(ParcelFileDescriptor parcelFileDescriptor) {
            this.f17059a = parcelFileDescriptor;
        }

        @Override // c10.a.d
        public FileChannel d() {
            if (this.f17059a.getStatSize() != -1) {
                return new ParcelFileDescriptor.AutoCloseInputStream(this.f17059a).getChannel();
            }
            this.f17059a.close();
            throw new IllegalArgumentException("Not a file: " + this.f17059a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class c extends UploadDataProvider {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f17060a;

        private c(ByteBuffer byteBuffer) {
            this.f17060a = byteBuffer;
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.f17060a.limit();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            if (byteBuffer.remaining() >= this.f17060a.remaining()) {
                byteBuffer.put(this.f17060a);
            } else {
                int limit = this.f17060a.limit();
                ByteBuffer byteBuffer2 = this.f17060a;
                byteBuffer.put(this.f17060a);
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindSucceeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface d {
        FileChannel d();
    }

    /* loaded from: classes7.dex */
    private static final class e extends UploadDataProvider {

        /* renamed from: a, reason: collision with root package name */
        private volatile FileChannel f17061a;

        /* renamed from: b, reason: collision with root package name */
        private final d f17062b;

        /* renamed from: c, reason: collision with root package name */
        private final Object f17063c;

        private e(d dVar) {
            this.f17063c = new Object();
            this.f17062b = dVar;
        }

        private FileChannel d() {
            if (this.f17061a == null) {
                synchronized (this.f17063c) {
                    try {
                        if (this.f17061a == null) {
                            this.f17061a = this.f17062b.d();
                        }
                    } finally {
                    }
                }
            }
            return this.f17061a;
        }

        @Override // org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            FileChannel fileChannel = this.f17061a;
            if (fileChannel != null) {
                fileChannel.close();
            }
        }

        @Override // org.chromium.net.UploadDataProvider
        public long getLength() {
            return d().size();
        }

        @Override // org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (!byteBuffer.hasRemaining()) {
                throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
            }
            FileChannel d11 = d();
            int i11 = 0;
            while (i11 == 0) {
                int read = d11.read(byteBuffer);
                if (read == -1) {
                    break;
                } else {
                    i11 += read;
                }
            }
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            d().position(0L);
            uploadDataSink.onRewindSucceeded();
        }
    }

    public static UploadDataProvider a(ParcelFileDescriptor parcelFileDescriptor) {
        return new e(new b(parcelFileDescriptor));
    }

    public static UploadDataProvider b(File file) {
        return new e(new C0167a(file));
    }

    public static UploadDataProvider c(ByteBuffer byteBuffer) {
        return new c(byteBuffer.slice());
    }

    public static UploadDataProvider d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static UploadDataProvider e(byte[] bArr, int i11, int i12) {
        return new c(ByteBuffer.wrap(bArr, i11, i12).slice());
    }
}
