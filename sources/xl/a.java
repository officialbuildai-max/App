package xl;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class a {
    public boolean a(Object obj, File file, long j11) {
        try {
            cm.a.e((ByteBuffer) obj, file);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
