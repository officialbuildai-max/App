package d4;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    private static final C0755a f61350e = new C0755a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Map f61351f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f61352a;

    /* renamed from: b, reason: collision with root package name */
    private final File f61353b;

    /* renamed from: c, reason: collision with root package name */
    private final Lock f61354c;

    /* renamed from: d, reason: collision with root package name */
    private FileChannel f61355d;

    /* renamed from: d4.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0755a {
        private C0755a() {
        }

        public /* synthetic */ C0755a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (a.f61351f) {
                try {
                    Map map = a.f61351f;
                    Object obj = map.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        map.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return lock;
        }
    }

    public a(String name, File file, boolean z10) {
        File file2;
        Intrinsics.h(name, "name");
        this.f61352a = z10;
        if (file != null) {
            file2 = new File(file, name + ".lck");
        } else {
            file2 = null;
        }
        this.f61353b = file2;
        this.f61354c = f61350e.b(name);
    }

    public static /* synthetic */ void c(a aVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = aVar.f61352a;
        }
        aVar.b(z10);
    }

    public final void b(boolean z10) {
        this.f61354c.lock();
        if (z10) {
            try {
                File file = this.f61353b;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f61353b).getChannel();
                channel.lock();
                this.f61355d = channel;
            } catch (IOException e11) {
                this.f61355d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e11);
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f61355d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f61354c.unlock();
    }
}
