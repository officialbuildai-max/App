package x3;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f78169a;

    /* renamed from: b, reason: collision with root package name */
    private FileChannel f78170b;

    public c(String filename) {
        Intrinsics.h(filename, "filename");
        this.f78169a = filename + ".lck";
    }

    public final void a() {
        if (this.f78170b != null) {
            return;
        }
        try {
            File file = new File(this.f78169a);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.f78170b = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th2) {
            FileChannel fileChannel = this.f78170b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.f78170b = null;
            throw new IllegalStateException("Unable to lock file: '" + this.f78169a + "'.", th2);
        }
    }

    public final void b() {
        FileChannel fileChannel = this.f78170b;
        if (fileChannel == null) {
            return;
        }
        try {
            fileChannel.close();
        } finally {
            this.f78170b = null;
        }
    }
}
