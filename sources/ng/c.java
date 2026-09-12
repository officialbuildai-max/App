package ng;

import com.cloud.tmc.miniutils.constant.TimeConstants;
import java.io.File;

/* loaded from: classes3.dex */
public final class c implements g8.a {

    /* renamed from: a, reason: collision with root package name */
    private final long f70575a = 5242880;

    /* renamed from: b, reason: collision with root package name */
    private final int f70576b = TimeConstants.DAY;

    /* renamed from: c, reason: collision with root package name */
    private final long f70577c = System.currentTimeMillis();

    private final boolean b(File file) {
        if (file == null) {
            return false;
        }
        return (this.f70577c - file.lastModified()) / ((long) this.f70576b) >= 15;
    }

    @Override // g8.a
    public boolean a(File file) {
        if (file == null || !file.isFile()) {
            return false;
        }
        return b(file) || file.length() > this.f70575a;
    }
}
