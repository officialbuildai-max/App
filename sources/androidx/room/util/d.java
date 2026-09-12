package androidx.room.util;

import android.os.Build;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class d {
    public static final void a(ReadableByteChannel input, FileChannel output) {
        Intrinsics.h(input, "input");
        Intrinsics.h(output, "output");
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(input);
                OutputStream newOutputStream = Channels.newOutputStream(output);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    } else {
                        newOutputStream.write(bArr, 0, read);
                    }
                }
            } else {
                output.transferFrom(input, 0L, Long.MAX_VALUE);
            }
            output.force(false);
            input.close();
            output.close();
        } catch (Throwable th2) {
            input.close();
            output.close();
            throw th2;
        }
    }
}
